package com.xiaopeng.montecarlo.mapoverlay.base;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
/* loaded from: classes2.dex */
public class DecoratorRequestParam extends BaseParameter {
    private String mCategory;
    private boolean mIsAborted;
    private double mLat;
    private double mLon;
    private String mPoiId;
    private XPPoiInfo mPoiInfo;
    private int mSearchId;
    private int mSearchType = 12;

    public int getSearchId() {
        return this.mSearchId;
    }

    public void setSearchId(int i) {
        this.mSearchId = i;
    }

    public double getLon() {
        return this.mLon;
    }

    public void setLon(double d) {
        this.mLon = d;
    }

    public double getLat() {
        return this.mLat;
    }

    public void setLat(double d) {
        this.mLat = d;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public XPPoiInfo getPoiInfo() {
        return this.mPoiInfo;
    }

    public void setPoiInfo(XPPoiInfo xPPoiInfo) {
        this.mPoiInfo = xPPoiInfo;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(int i) {
        this.mSearchType = i;
    }

    public boolean isAborted() {
        return this.mIsAborted;
    }

    public void setAborted(boolean z) {
        this.mIsAborted = z;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }
}
