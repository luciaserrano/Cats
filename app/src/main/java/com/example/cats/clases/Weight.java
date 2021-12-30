package com.example.cats.clases;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weight implements Parcelable {

    @SerializedName("imperial")
    @Expose
    private String imperial;
    @SerializedName("metric")
    @Expose
    private String metric;

    /**
     * No args constructor for use in serialization
     */
    public Weight() {
    }

    /**
     * @param metric
     * @param imperial
     */
    public Weight(String imperial, String metric) {
        super();
        this.imperial = imperial;
        this.metric = metric;
    }

    protected Weight(Parcel in) {
        imperial = in.readString();
        metric = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imperial);
        dest.writeString(metric);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Weight> CREATOR = new Creator<Weight>() {
        @Override
        public Weight createFromParcel(Parcel in) {
            return new Weight(in);
        }

        @Override
        public Weight[] newArray(int size) {
            return new Weight[size];
        }
    };

    public String getImperial() {
        return imperial;
    }

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}

