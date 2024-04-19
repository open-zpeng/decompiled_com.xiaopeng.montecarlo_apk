package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
/* loaded from: classes3.dex */
public class FavoriteAddressBean {
    @SerializedName("addressType")
    String mAddressType;
    @SerializedName("isFromBigData")
    boolean mIsFromBigData;
    @SerializedName("poiBean")
    PoiBean mPoiBean;

    public void setAddressType(String str) {
        this.mAddressType = str;
    }

    public void setFromBigData(boolean z) {
        this.mIsFromBigData = z;
    }

    public void setPoiBean(PoiBean poiBean) {
        this.mPoiBean = poiBean;
    }

    public boolean isFromBigData() {
        return this.mIsFromBigData;
    }

    public String getAddressType() {
        return this.mAddressType;
    }

    public PoiBean getPoiBean() {
        return this.mPoiBean;
    }
}
