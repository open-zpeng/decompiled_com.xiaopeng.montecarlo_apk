package com.xiaopeng.montecarlo.mapoverlay.charge;

import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes.dex */
public class ChargeBizData {
    private XPPointBaseData mBizPointBaseData;
    private int mTextureFocusMarkerId;
    private int mTextureMarkerId;
    private XPPoiInfo mXPPoiInfo;

    public XPPoiInfo getXPPoiInfo() {
        return this.mXPPoiInfo;
    }

    public void setXPPoiInfo(XPPoiInfo xPPoiInfo) {
        this.mXPPoiInfo = xPPoiInfo;
    }

    public XPPointBaseData getBizPointBaseData() {
        return this.mBizPointBaseData;
    }

    public void setBizPointBaseData(XPPointBaseData xPPointBaseData) {
        this.mBizPointBaseData = xPPointBaseData;
    }

    public int getTextureMarkerId() {
        return this.mTextureMarkerId;
    }

    public void setTextureMarkerId(int i) {
        this.mTextureMarkerId = i;
    }

    public int getTextureFocusMarkerId() {
        return this.mTextureFocusMarkerId;
    }

    public void setTextureFocusMarkerId(int i) {
        this.mTextureFocusMarkerId = i;
    }
}
