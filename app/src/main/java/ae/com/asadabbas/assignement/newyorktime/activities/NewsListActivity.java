package ae.com.asadabbas.assignement.newyorktime.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import ae.com.asadabbas.assignement.newyorktime.App;
import ae.com.asadabbas.assignement.newyorktime.R;
import ae.com.asadabbas.assignement.newyorktime.adapters.NewsAdapter;
import ae.com.asadabbas.assignement.newyorktime.base.BaseActionBarActivity;
import ae.com.asadabbas.assignement.newyorktime.generics.RecyclerViewAdapter;
import ae.com.asadabbas.assignement.newyorktime.models.ResultsData;
import ae.com.asadabbas.assignement.newyorktime.viewmodels.NewsViewModel;
import butterknife.BindView;

import static ae.com.asadabbas.assignement.newyorktime.util.Constant.RESULT_OBJECT;

public class NewsListActivity extends BaseActionBarActivity implements RecyclerViewAdapter.OnViewHolderClick {

    @BindView(R.id.news_recycler)
    RecyclerView mNewsRecycler;

    NewsAdapter adapter;
    NewsViewModel viewModel;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public String actionBarTitle() {
        return getString(R.string.heading);
    }

    @Override
    public String actionBarSubTitle() {
        return null;
    }

    @Override
    public boolean showBackButton() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        subscribeObservers();
    }

    public void init() {


        mToolbar.setNavigationIcon(R.drawable.drawer);
        setSupportActionBar(mToolbar);
        mNewsRecycler.setLayoutManager(new LinearLayoutManager(this));
        mNewsRecycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new NewsAdapter(this);
        viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
    }

    // Create the observer which updates the UI.
    final Observer<List<ResultsData>> observer = new Observer<List<ResultsData>>() {

        @Override
        public void onChanged(@Nullable List<ResultsData> resultsData) {
            hideWaitDialog();
            // Update the UI
            adapter.setClickListener(NewsListActivity.this);
            adapter.setList(resultsData);
            mNewsRecycler.setAdapter(adapter);
        }
    };

    void subscribeObservers() {
        showWaitDialog();
        viewModel.getResultData().observe(this, observer);
    }

    @Override
    public void onClick(View view, int position, Object item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(RESULT_OBJECT, (ResultsData) item);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_search:
                break;

            case R.id.action_filter:
                break;

        }
        return true;
    }

}
