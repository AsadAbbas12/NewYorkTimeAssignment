package ae.com.asadabbas.assignement.newyorktime.apiservices;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.CookieHandler;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import ae.com.asadabbas.assignement.newyorktime.App;
import ae.com.asadabbas.assignement.newyorktime.apiservices.service.APIService;
import ae.com.asadabbas.assignement.newyorktime.listeners.OnResultListener;
import ae.com.asadabbas.assignement.newyorktime.models.NewsData;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class RestClient {

    private static final String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/";

    private APIService service;

    private OkHttpClient getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        return client;
    }

    public RestClient() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(getClient())
                .build();
        service = retrofit.create(APIService.class);
    }

    public void getNews(final OnResultListener onResultListener) {
        Call<NewsData> newsData = service.getNews();
        newsData.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if (response.isSuccessful()) {
                    NewsData newsData = response.body();
                    onResultListener.onResult(newsData, true, null);
                } else if (response.errorBody() != null) {
                    try {
                        onResultListener.onResult(null, false, response.errorBody().string());
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                Log.e("REST", t.getMessage());
                onResultListener.onResult(null, false, t.getMessage());
            }
        });
    }
}