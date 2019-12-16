package ae.com.asadabbas.assignement.newyorktime.apiservices.service;

import ae.com.asadabbas.assignement.newyorktime.models.NewsData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    // provided the the api key to fetch the data from nyTime news
    @GET("1.json?api-key=U2sf7QzDULcIi2UI0OKSSTF19VG8vYRn")
    Call<NewsData> getNews();

}
