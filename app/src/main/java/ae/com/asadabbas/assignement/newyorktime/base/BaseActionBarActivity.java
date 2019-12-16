package ae.com.asadabbas.assignement.newyorktime.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ae.com.asadabbas.assignement.newyorktime.App;
import ae.com.asadabbas.assignement.newyorktime.R;
import butterknife.ButterKnife;


public abstract class BaseActionBarActivity extends BaseActivity {

    public abstract String actionBarTitle();

    public abstract String actionBarSubTitle();

    public abstract boolean showBackButton();

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hasDataBindingView()) {
            //Data binding and setContentView has been set
        } else {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);
        configureToolbar();
    }

    public boolean hasDataBindingView() {
        return false;
    }

    Toolbar toolbar;

    private void configureToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            if (actionBarTitle() != null) {
                toolbar.setTitle(actionBarTitle());
            } else {
                toolbar.setTitle("");
            }
            if (actionBarSubTitle() != null) {
                toolbar.setSubtitle(actionBarSubTitle());
            }
            setSupportActionBar(toolbar);
            if (showBackButton()) {
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                getSupportActionBar().setDisplayShowHomeEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        } else {
            throw new RuntimeException(this.getLocalClassName() + " should have toolbar_main.xml in parent view");
        }
    }

    public Toolbar toolbar() {

        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    finish();
                } else {
                    onBackPressed();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
