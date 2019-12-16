package ae.com.asadabbas.assignement.newyorktime.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import ae.com.asadabbas.assignement.newyorktime.models.ResultsData;
import ae.com.asadabbas.assignement.newyorktime.repository.NewsRepository;

/**
 * Created by Asad Abbas on 15/12/19.
 * Copyrights © 15/12/19 Asad Abbas. All rights reserved
 */

public class NewsViewModel extends AndroidViewModel {

    LiveData<List<ResultsData>> newsLiveData;
    NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository();
        newsLiveData = new MutableLiveData<>();
        newsLiveData = newsRepository.loadNewsData();
    }

    public LiveData<List<ResultsData>> getResultData() {

        return newsLiveData;
    }
}
