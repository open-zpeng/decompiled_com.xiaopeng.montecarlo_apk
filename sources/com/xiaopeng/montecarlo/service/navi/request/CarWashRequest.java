package com.xiaopeng.montecarlo.service.navi.request;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class CarWashRequest {
    public static final int DEFAULT_SEARCH_MAX_COUNT = 50;
    public static final int DEFAULT_SEARCH_RADIUS = 50000;
    public static final String SEARCH_TYPE_AROUND = "SEARCH_TYPE_AROUND";
    @SerializedName("latitude")
    private double mLatitude;
    @SerializedName("longitude")
    private double mLongitude;
    @SerializedName("maxCount")
    private int mMaxCount;
    @SerializedName("radius")
    private int mRadius;
    @SerializedName("searchType")
    private String mSearchType;

    public String getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(String str) {
        this.mSearchType = str;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getMaxCount() {
        return this.mMaxCount;
    }

    public void setMaxCount(int i) {
        this.mMaxCount = i;
    }
}
