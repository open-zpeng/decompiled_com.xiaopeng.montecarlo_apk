package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes2.dex */
public class CruiseChargeParam extends CruiseRequestParam {
    public static final int RADIUS_10KM = 10000;
    public static final int RADIUS_3KM = 3000;
    public static final int RADIUS_5KM = 5000;
    private XPCoordinate2DDouble mCarLocation;
    private int mRadius = 0;
    private String mKeyword = "";

    public CruiseChargeParam() {
        this.mCruiseType = 5;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public String getKeyword() {
        return this.mKeyword;
    }

    public void setKeyword(String str) {
        this.mKeyword = str;
    }

    public XPCoordinate2DDouble getCarLocation() {
        return this.mCarLocation;
    }

    public void setCarLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mCarLocation = xPCoordinate2DDouble;
    }
}
