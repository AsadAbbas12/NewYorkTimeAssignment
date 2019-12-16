package ae.com.asadabbas.assignement.newyorktime.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Asad Abbas on 7/10/18.
 * Copyrights © 7/10/18 Asad Abbas. All rights reserved
 */

public class NewsData implements Parcelable {

    @SerializedName("status")
    String status;

    @SerializedName("copyright")
    String copyright;

    @SerializedName("num_results")
    long num_results;

    @SerializedName("results")
    List<ResultsData> resultsData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public long getNum_results() {
        return num_results;
    }

    public void setNum_results(long num_results) {
        this.num_results = num_results;
    }

    public List<ResultsData> getResultsData() {
        return resultsData;
    }

    public void setResultsData(List<ResultsData> resultsData) {
        this.resultsData = resultsData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeString(this.copyright);
        dest.writeLong(this.num_results);
        dest.writeTypedList(this.resultsData);
    }

    public NewsData() {
    }

    protected NewsData(Parcel in) {
        this.status = in.readString();
        this.copyright = in.readString();
        this.num_results = in.readLong();
        this.resultsData = in.createTypedArrayList(ResultsData.CREATOR);
    }

    public static final Parcelable.Creator<NewsData> CREATOR = new Parcelable.Creator<NewsData>() {
        @Override
        public NewsData createFromParcel(Parcel source) {
            return new NewsData(source);
        }

        @Override
        public NewsData[] newArray(int size) {
            return new NewsData[size];
        }
    };
}
