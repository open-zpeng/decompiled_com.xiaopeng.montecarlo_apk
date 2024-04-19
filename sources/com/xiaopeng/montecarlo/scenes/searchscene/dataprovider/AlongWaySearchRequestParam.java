package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes3.dex */
public class AlongWaySearchRequestParam extends SearchRequestParam {
    private XPCoordinate2DDouble mCarLocation = null;
    private String mCategory;
    private String mOrder;
    private String mText;

    public AlongWaySearchRequestParam() {
        this.mSearchType = 2;
    }

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

    public XPCoordinate2DDouble getCarLocation() {
        return this.mCarLocation;
    }

    public void setCarLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mCarLocation = xPCoordinate2DDouble;
    }

    public String getOrder() {
        return this.mOrder;
    }

    public void setOrder(String str) {
        this.mOrder = str;
    }
}
