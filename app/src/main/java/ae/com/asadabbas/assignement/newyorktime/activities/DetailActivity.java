package ae.com.asadabbas.assignement.newyorktime.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ae.com.asadabbas.assignement.newyorktime.R;
import ae.com.asadabbas.assignement.newyorktime.base.BaseActionBarActivity;
import ae.com.asadabbas.assignement.newyorktime.models.ResultsData;
import ae.com.asadabbas.assignement.newyorktime.util.Constant;
import ae.com.asadabbas.assignement.newyorktime.util.ValidationHelper;
import ae.com.asadabbas.assignement.newyorktime.views.BoldTextView;
import ae.com.asadabbas.assignement.newyorktime.views.LightTextView;
import butterknife.BindView;

import static ae.com.asadabbas.assignement.newyorktime.util.Constant.POSITION;
import static ae.com.asadabbas.assignement.newyorktime.util.Constant.TRANSITIONNAME;

public class DetailActivity extends BaseActionBarActivity {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.iv_picture)
    ImageView mPicture;

    @BindView(R.id.tv_title)
    BoldTextView mTitle;

    @BindView(R.id.abstraction)
    LightTextView mAbstraction;

    @Override
    public String actionBarTitle() {
        return null;
    }

    @Override
    public String actionBarSubTitle() {
        return null;
    }

    @Override
    public boolean showBackButton() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configToolbar();
        getExtra();
    }

    void configToolbar() {
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), TRANSITIONNAME);
        supportPostponeEnterTransition();
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    public ResultsData resultsData;

    void getExtra() {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            resultsData = bundle.getParcelable(Constant.RESULT_OBJECT);
            setDetails(resultsData);
        }
    }


    public void setDetails(ResultsData resultsData) {

        String title = resultsData.getTitle();
        String abstractionDescription = resultsData.getAbstractStr();
        String byLine = resultsData.getByline();

        mTitle.setText(title);
        mAbstraction.setText(abstractionDescription);
        collapsingToolbarLayout.setTitle(byLine);

        if (resultsData.getMediaDataList() != null && resultsData.getMediaDataList().get(POSITION).getMediaMetaDataList() != null) {
            String imageUrl = resultsData.getMediaDataList().get(POSITION).getMediaMetaDataList().get(POSITION).getUrl();
            // load image
            if (!ValidationHelper.isNullOrEmpty(imageUrl))
                Glide.with(this).load(imageUrl).into(mPicture);

        }
    }
}
