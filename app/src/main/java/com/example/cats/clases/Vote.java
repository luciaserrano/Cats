package com.example.cats.clases;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vote {

    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("sub_id")
    @Expose
    private String subId;
    @SerializedName("value")
    @Expose
    private int value;

    public Vote(String countryCode, String createdAt, int id, String imageId, String subId, int value) {
        super();
        this.countryCode = countryCode;
        this.createdAt = createdAt;
        this.id = id;
        this.imageId = imageId;
        this.subId = subId;
        this.value = value;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}