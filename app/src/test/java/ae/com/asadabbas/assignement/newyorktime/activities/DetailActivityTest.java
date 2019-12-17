package ae.com.asadabbas.assignement.newyorktime.activities;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DetailActivityTest {

    @Mock
    DetailActivity detailActivity;

    @Test
    public void configToolbar() {
        doNothing().when(detailActivity).configToolbar();
    }

    @Test
    public void getExtra() {
        doNothing().when(detailActivity).getExtra();
    }

    @Test
    public void setDetails() {
        doNothing().when(detailActivity).setDetails(detailActivity.resultsData);
    }
}