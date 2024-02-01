package com.xiaopeng.montecarlo.bean;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class NaviRouteInfo implements Serializable {
    private XPPoiInfo mEndInfo;
    private boolean mIsStartNaviImmediately;
    private XPPoiInfo mStartInfo;
    private List<XPViaPoint> mViaList;

    public XPPoiInfo getStartInfo() {
        return this.mStartInfo;
    }

    public void setStartInfo(XPPoiInfo xPPoiInfo) {
        this.mStartInfo = xPPoiInfo;
    }

    public XPPoiInfo getEndInfo() {
        return this.mEndInfo;
    }

    public void setEndInfo(XPPoiInfo xPPoiInfo) {
        this.mEndInfo = xPPoiInfo;
    }

    public List<XPViaPoint> getViaList() {
        return this.mViaList;
    }

    public void setViaList(List<XPViaPoint> list) {
        this.mViaList = list;
    }

    public boolean isStartNaviImmediately() {
        return this.mIsStartNaviImmediately;
    }

    public void setStartNaviImmediately(boolean z) {
        this.mIsStartNaviImmediately = z;
    }
}
