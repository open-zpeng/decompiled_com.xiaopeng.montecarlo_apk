package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes2.dex */
public class XPCruiseCongestionInfo {
    public int mCongestionStatus;
    public int mEtaTime;
    public int mEventID;
    public XPCoordinate2DDouble mEventPos;
    public int mEventType;
    public int mLayer;
    public int mLayerTag;
    public int mLength;
    public XPLinkLineStatus[] mLinkData;
    public String mRoadName;
    public String mSocolPicUrl;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mRoadName: ");
        sb.append(this.mRoadName);
        sb.append(", mCongestionStatus: ");
        sb.append(this.mCongestionStatus);
        sb.append(", mEtaTime: ");
        sb.append(this.mEtaTime);
        sb.append(", mLength: ");
        sb.append(this.mLength);
        sb.append(", mEventID: ");
        sb.append(this.mEventID);
        sb.append(", mEventType: ");
        sb.append(this.mEventType);
        sb.append(", mEventPos: ");
        XPCoordinate2DDouble xPCoordinate2DDouble = this.mEventPos;
        if (xPCoordinate2DDouble == null) {
            sb.append("null");
        } else {
            sb.append(xPCoordinate2DDouble.mLat);
            sb.append(",");
            sb.append(this.mEventPos.mLon);
        }
        sb.append(", mLayer: ");
        sb.append(this.mLayer);
        sb.append(", mLayerTag: ");
        sb.append(this.mLayerTag);
        return sb.toString();
    }
}
