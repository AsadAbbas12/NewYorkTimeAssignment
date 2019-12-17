package ae.com.asadabbas.assignement.newyorktime.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import ae.com.asadabbas.assignement.newyorktime.R;
import ae.com.asadabbas.assignement.newyorktime.generics.RecyclerViewAdapter;
import ae.com.asadabbas.assignement.newyorktime.models.MediaData;
import ae.com.asadabbas.assignement.newyorktime.models.MediaMetaData;
import ae.com.asadabbas.assignement.newyorktime.models.ResultsData;
import ae.com.asadabbas.assignement.newyorktime.util.ValidationHelper;
import ae.com.asadabbas.assignement.newyorktime.views.BoldTextView;
import ae.com.asadabbas.assignement.newyorktime.views.LightTextView;

import static ae.com.asadabbas.assignement.newyorktime.util.Constant.POSITION;

public class NewsAdapter extends RecyclerViewAdapter<ResultsData> {
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.nyt_list_items, viewGroup, false);

        return view;
    }

    @Override
    protected void bindView(ResultsData mResultsDataList, ViewHolder viewHolder) {

        if (mResultsDataList != null) {
            try {

                BoldTextView descriptionView = (BoldTextView) viewHolder.getView(R.id.tv_description);
                LightTextView byLineView = (LightTextView) viewHolder.getView(R.id.tv_written_by);
                LightTextView typeView = (LightTextView) viewHolder.getView(R.id.tv_type);
                LightTextView dateView = (LightTextView) viewHolder.getView(R.id.tv_date);
                RoundedImageView pictureView = (RoundedImageView) viewHolder.getView(R.id.iv_picture);

                String description = mResultsDataList.getTitle();
                String byLine = mResultsDataList.getByline();
                String publishDate = mResultsDataList.getPublished_date();
                String type = mResultsDataList.getType();

                List<MediaData> mediaDataList = mResultsDataList.getMediaDataList();
                List<MediaMetaData> mediaMetaDataList = mediaDataList.get(POSITION).getMediaMetaDataList();

                if (!ValidationHelper.isNullOrEmpty(mediaDataList) && !ValidationHelper.isNullOrEmpty(mediaMetaDataList)) {
                    String imageUrl = mediaMetaDataList.get(POSITION).getUrl();
                    // load image
                    if (!ValidationHelper.isNullOrEmpty(imageUrl))
                        Glide.with(getContext()).load(imageUrl).into(pictureView);
                }

                if (!ValidationHelper.isNullOrEmpty(description))
                    descriptionView.setText(description);

                if (!ValidationHelper.isNullOrEmpty(byLine))
                    byLineView.setText(byLine);

                if (!ValidationHelper.isNullOrEmpty(publishDate))
                    dateView.setText(publishDate);

                if (!ValidationHelper.isNullOrEmpty(type))
                    typeView.setText(type);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
