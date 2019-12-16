package ae.com.asadabbas.assignement.newyorktime.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import ae.com.asadabbas.assignement.newyorktime.models.ResultsData;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class NewsRepositoryTest {

    @Spy
    NewsRepository newsRepository;

    @Rule // -> allows liveData to work on different thread besides main, must be public!
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void loadNewsData() {

        LiveData<List<ResultsData>> loadNewsData = newsRepository.loadNewsData();

        when(newsRepository.loadNewsData()).thenReturn(loadNewsData);
        System.out.println(newsRepository.loadNewsData().getValue());
    }
}