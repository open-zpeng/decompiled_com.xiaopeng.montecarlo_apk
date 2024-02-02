package com.xiaopeng.montecarlo.scenes.navi.dataprovider;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class NaviRequestParam extends BaseParameter {
    public static final int NAVI_REQUEST_TYPE_CROSS_ICON = 1;
    private static final int NAVI_REQUEST_TYPE_INVALID = -1;
    public static final int NAVI_REQUEST_TYPE_TURN_ICON = 0;
    private XPCrossImageInfo mCrossImageInfo;
    protected int mNaviRequestType = -1;
    private XPObtainInfo mObtainInfo;
    private int mRadianType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface NaviRequestType {
    }

    public int getNaviRequestType() {
        return this.mNaviRequestType;
    }

    public void setNaviRequestType(int i) {
        this.mNaviRequestType = i;
    }

    public int getRadianType() {
        return this.mRadianType;
    }

    public void setRadianType(int i) {
        this.mRadianType = i;
    }

    public void setObtainInfo(XPObtainInfo xPObtainInfo) {
        this.mObtainInfo = xPObtainInfo;
    }

    public XPObtainInfo getObtainInfo() {
        return this.mObtainInfo;
    }

    public void setCrossImageInfo(XPCrossImageInfo xPCrossImageInfo) {
        this.mCrossImageInfo = xPCrossImageInfo;
    }

    public XPCrossImageInfo getCrossImageInfo() {
        return this.mCrossImageInfo;
    }
}
