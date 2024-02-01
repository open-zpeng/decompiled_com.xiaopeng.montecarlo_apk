package com.xiaopeng.montecarlo.navcore.bean.search;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes3.dex */
public class XPNaviServerPoint {
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private double mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LON)
    private double mLon;

    protected boolean canEqual(Object obj) {
        return obj instanceof XPNaviServerPoint;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XPNaviServerPoint) {
            XPNaviServerPoint xPNaviServerPoint = (XPNaviServerPoint) obj;
            return xPNaviServerPoint.canEqual(this) && Double.compare(getLon(), xPNaviServerPoint.getLon()) == 0 && Double.compare(getLat(), xPNaviServerPoint.getLat()) == 0;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(getLon());
        long doubleToLongBits2 = Double.doubleToLongBits(getLat());
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public void setLat(double d) {
        this.mLat = d;
    }

    public void setLon(double d) {
        this.mLon = d;
    }

    public String toString() {
        return "XPNaviServerPoint(mLon=" + getLon() + ", mLat=" + getLat() + ")";
    }

    public double getLon() {
        return this.mLon;
    }

    public double getLat() {
        return this.mLat;
    }

    public XPNaviServerPoint(double d, double d2) {
        this.mLon = d;
        this.mLat = d2;
    }
}
