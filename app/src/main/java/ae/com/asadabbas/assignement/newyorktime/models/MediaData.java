package ae.com.asadabbas.assignement.newyorktime.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Asad Abbas on 7/10/18.
 * Copyrights © 7/10/18 Asad Abbas. All rights reserved
 */

public class MediaData implements Parcelable {


    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("type")
    String type;

    @SerializedName("subtype")
    String subtype;

    @SerializedName("caption")
    String caption;

    @SerializedName("copyright")
    String copyright;

    @SerializedName("approved_for_syndication")
    int approved_for_syndication;

    @SerializedName("media-metadata")
    List<MediaMetaData> mediaMetaDataList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getApproved_for_syndication() {
        return approved_for_syndication;
    }

    public void setApproved_for_syndication(int approved_for_syndication) {
        this.approved_for_syndication = approved_for_syndication;
    }

    public List<MediaMetaData> getMediaMetaDataList() {
        return mediaMetaDataList;
    }

    public void setMediaMetaDataList(List<MediaMetaData> mediaMetaDataList) {
        this.mediaMetaDataList = mediaMetaDataList;
    }

    public MediaData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.type);
        dest.writeString(this.subtype);
        dest.writeString(this.caption);
        dest.writeString(this.copyright);
        dest.writeInt(this.approved_for_syndication);
        dest.writeTypedList(this.mediaMetaDataList);
    }

    protected MediaData(Parcel in) {
        this.id = in.readInt();
        this.type = in.readString();
        this.subtype = in.readString();
        this.caption = in.readString();
        this.copyright = in.readString();
        this.approved_for_syndication = in.readInt();
        this.mediaMetaDataList = in.createTypedArrayList(MediaMetaData.CREATOR);
    }

    public static final Creator<MediaData> CREATOR = new Creator<MediaData>() {
        @Override
        public MediaData createFromParcel(Parcel source) {
            return new MediaData(source);
        }

        @Override
        public MediaData[] newArray(int size) {
            return new MediaData[size];
        }
    };
}
