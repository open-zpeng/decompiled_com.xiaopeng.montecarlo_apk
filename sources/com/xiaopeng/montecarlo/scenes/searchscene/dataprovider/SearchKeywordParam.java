package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes3.dex */
public class SearchKeywordParam extends SearchRequestParam {
    private int mAdCode;
    private String mCategory;
    private XPCoordinate2DDouble mPoiLoc;
    private String mRange;
    private String mText;
    private XPCoordinate2DDouble mUserLoc;

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public XPCoordinate2DDouble getUserLoc() {
        return this.mUserLoc;
    }

    public void setUserLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mUserLoc = xPCoordinate2DDouble;
    }

    public XPCoordinate2DDouble getPoiLoc() {
        return this.mPoiLoc;
    }

    public void setPoiLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLoc = xPCoordinate2DDouble;
    }

    public String getRange() {
        return this.mRange;
    }

    public void setRange(String str) {
        this.mRange = str;
    }

    public int getAdCode() {
        return this.mAdCode;
    }

    public void setAdCode(int i) {
        this.mAdCode = i;
    }
}
