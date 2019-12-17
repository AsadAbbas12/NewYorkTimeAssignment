package ae.com.asadabbas.assignement.newyorktime.repository;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import ae.com.asadabbas.assignement.newyorktime.models.ResultsData;
import ae.com.asadabbas.assignement.newyorktime.util.ValidationHelper;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.Silent.class)
public class NewsRepositoryTest {

    @Mock
    NewsRepository newsRepository;

    @Rule // -> allows liveData to work on different thread besides main, must be public!
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    ResultsData resultsData;
    MutableLiveData<List<ResultsData>> loadNewsData;

    @Before
    public void setUp() throws Exception {
        resultsData = new ResultsData();
        loadNewsData = new MutableLiveData<>();
    }

    @Test
    public void loadNewsData() {

        resultsData.setByline("Asad Abbas");
        resultsData.setSection("Most Popular");
        resultsData.setSource("New York Time");

        List<ResultsData> resultsDataList = new ArrayList<>();
        resultsDataList.add(resultsData);
        loadNewsData.setValue(resultsDataList);

        // doReturn(newsRepository.loadNewsData()).when(newsRepository).loadNewsData();

        when(newsRepository.loadNewsData()).thenReturn(loadNewsData);

        List<ResultsData> mockData = loadNewsData.getValue();
        for (ResultsData resultsData1 : mockData) {
            String result_str = String.format("By Line: %s  ,Type %s News ", resultsData1.getByline(), resultsData1.getSection());
            System.out.println(result_str);
        }
    }
}