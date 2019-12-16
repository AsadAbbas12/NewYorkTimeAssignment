package ae.com.asadabbas.assignement.newyorktime.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Asad Abbas on 7/10/18.
 * Copyrights © 7/10/18 Asad Abbas. All rights reserved
 */


public class ResultsData implements Parcelable {

    @SerializedName("id")
    long id;

    @SerializedName("url")
    String url;

    @SerializedName("adx_keywords")
    String adx_keywords;

    @SerializedName("column")
    String column;

    @SerializedName("section")
    String section;

    @SerializedName("byline")
    String byline;

    @SerializedName("type")
    String type;

    @SerializedName("title")
    String title;

    @SerializedName("abstract")
    String abstractStr;

    @SerializedName("published_date")
    String published_date;

    @SerializedName("source")
    String source;

    @SerializedName("asset_id")
    long asset_id;

    @SerializedName("views")
    long views;

    @SerializedName("media")
    List<MediaData> mediaDataList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
        this.adx_keywords = adx_keywords;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractStr() {
        return abstractStr;
    }

    public void setAbstractStr(String abstractStr) {
        this.abstractStr = abstractStr;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(long asset_id) {
        this.asset_id = asset_id;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public List<MediaData> getMediaDataList() {
        return mediaDataList;
    }

    public void setMediaDataList(List<MediaData> mediaDataList) {
        this.mediaDataList = mediaDataList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.adx_keywords);
        dest.writeString(this.column);
        dest.writeString(this.section);
        dest.writeString(this.byline);
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeString(this.abstractStr);
        dest.writeString(this.published_date);
        dest.writeString(this.source);
        dest.writeLong(this.id);
        dest.writeLong(this.asset_id);
        dest.writeLong(this.views);
        dest.writeTypedList(this.mediaDataList);
    }

    public ResultsData() {
    }

    protected ResultsData(Parcel in) {
        this.url = in.readString();
        this.adx_keywords = in.readString();
        this.column = in.readString();
        this.section = in.readString();
        this.byline = in.readString();
        this.type = in.readString();
        this.title = in.readString();
        this.abstractStr = in.readString();
        this.published_date = in.readString();
        this.source = in.readString();
        this.id = in.readLong();
        this.asset_id = in.readLong();
        this.views = in.readLong();
        this.mediaDataList = in.createTypedArrayList(MediaData.CREATOR);
    }

    public static final Parcelable.Creator<ResultsData> CREATOR = new Parcelable.Creator<ResultsData>() {
        @Override
        public ResultsData createFromParcel(Parcel source) {
            return new ResultsData(source);
        }

        @Override
        public ResultsData[] newArray(int size) {
            return new ResultsData[size];
        }
    };
}
