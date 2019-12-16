package ae.com.asadabbas.assignement.newyorktime.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Singleton;

import ae.com.asadabbas.assignement.newyorktime.apiservices.RestClient;
import ae.com.asadabbas.assignement.newyorktime.listeners.OnResultListener;
import ae.com.asadabbas.assignement.newyorktime.models.NewsData;
import ae.com.asadabbas.assignement.newyorktime.models.ResultsData;

/**
 * Created by Asad Abbas on 15/12/19.
 * Copyrights © 15/12/19 Asad Abbas. All rights reserved
 */

@Singleton
public class NewsRepository {

    public LiveData<List<ResultsData>> loadNewsData() {

        RestClient restClient = new RestClient();

        final MutableLiveData<List<ResultsData>> resultLiveData = new MutableLiveData<>();

        // Do an asynchronous operation to fetch result Data.
        restClient.getNews(new OnResultListener() {

            @Override
            public void onResult(Object result, boolean status, String errorMessage) {

                if (status) {
                    if (result != null) {
                        NewsData newsData = (NewsData) result;
                        List<ResultsData> resultsData = newsData.getResultsData();
                        resultLiveData.setValue(resultsData);
                    }
                }
            }
        });

        return resultLiveData;
    }
}
