package ae.com.asadabbas.assignement.newyorktime.activities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NewsListActivityTest {

    @Mock
    NewsListActivityTest mainActivityTest;

    @Test
    public void subscribeObservers() {

        doNothing().when(mainActivityTest).subscribeObservers();
    }

    @Test
    public void init() {
        doNothing().when(mainActivityTest).init();
    }

    @Test
    public void onClick() {
        doNothing().when(mainActivityTest).onClick();
    }


}