package com.xiaopeng.montecarlo.navcore.bean.favorite;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
/* loaded from: classes2.dex */
public class ChildPoiSimpleInfo {
    @SerializedName("mBlCategory")
    private String mBlCategory;
    @SerializedName("mCategory")
    private int mCategory;
    @SerializedName("mPoiAddress")
    private String mPoiAddress;
    @SerializedName("mPoiDistrictName")
    private String mPoiDistrictName;
    @SerializedName("mPoiId")
    private String mPoiId;
    @SerializedName("mPoiLat")
    private double mPoiLat;
    @SerializedName("mPoiLon")
    private double mPoiLon;
    @SerializedName("mPoiName")
    private String mPoiName;
    @SerializedName("mPoiNavLat")
    private double mPoiNavLat;
    @SerializedName("mPoiNavLon")
    private double mPoiNavLon;
    @SerializedName("mPoiSource")
    private int mPoiSource;

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getPoiName() {
        return this.mPoiName;
    }

    public void setPoiName(String str) {
        this.mPoiName = str;
    }

    public String getPoiAddress() {
        return this.mPoiAddress;
    }

    public void setPoiAddress(String str) {
        this.mPoiAddress = str;
    }

    public String getPoiDistrictName() {
        return this.mPoiDistrictName;
    }

    public void setPoiDistrictName(String str) {
        this.mPoiDistrictName = str;
    }

    public double getPoiLat() {
        return this.mPoiLat;
    }

    public void setPoiLat(double d) {
        this.mPoiLat = d;
    }

    public double getPoiLon() {
        return this.mPoiLon;
    }

    public void setPoiLon(double d) {
        this.mPoiLon = d;
    }

    public double getPoiNavLat() {
        return this.mPoiNavLat;
    }

    public void setPoiNavLat(double d) {
        this.mPoiNavLat = d;
    }

    public double getPoiNavLon() {
        return this.mPoiNavLon;
    }

    public void setPoiNavLon(double d) {
        this.mPoiNavLon = d;
    }

    public int getPoiSource() {
        return this.mPoiSource;
    }

    public void setPoiSource(int i) {
        this.mPoiSource = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public void setCategory(int i) {
        this.mCategory = i;
    }

    public String getBlCategory() {
        return this.mBlCategory;
    }

    public void setBlCategory(String str) {
        this.mBlCategory = str;
    }

    public String toString() {
        return GsonUtil.toJson(this);
    }
}
