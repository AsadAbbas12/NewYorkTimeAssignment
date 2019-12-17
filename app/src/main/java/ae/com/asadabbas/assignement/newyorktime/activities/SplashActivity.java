package ae.com.asadabbas.assignement.newyorktime.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ae.com.asadabbas.assignement.newyorktime.R;

import static ae.com.asadabbas.assignement.newyorktime.util.ValidationHelper.isNetworkAvailable;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                if (isNetworkAvailable(SplashActivity.this)) {
                    Intent intent = new Intent(SplashActivity.this, NewsListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SplashActivity.this, R.string.connect_internet_message, Toast.LENGTH_LONG).show();
                }

            }
        }, 2000);
    }
}
