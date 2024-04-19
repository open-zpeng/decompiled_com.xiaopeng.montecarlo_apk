package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.lzy.okgo.cache.CacheEntity;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviStationInfo {
    @SerializedName("address")
    private String mAddress;
    @SerializedName("busiTime")
    private String mBusiTime;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("distance")
    private Integer mDistance;
    @SerializedName("evaNum")
    private Integer mEvaNum = 0;
    @SerializedName("evaScore")
    private String mEvaScore;
    @SerializedName("extContent")
    private List<ExtContent> mExtContent;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private String mId;
    @SerializedName("imgs")
    private List<String> mImgs;
    @SerializedName("intro")
    private String mIntro;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LON)
    private String mLon;
    @SerializedName("name")
    private String mName;
    @SerializedName("operId")
    private String mOperId;
    @SerializedName("operName")
    private String mOperName;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("selfSupportFlag")
    private Integer mSelfSupportFlag;
    @SerializedName("serviceTel")
    private String mServiceTel;
    @SerializedName("version")
    private String mVersion;

    /* loaded from: classes2.dex */
    public static class ExtContent {
        @SerializedName("desc")
        private String mDesc;
        @SerializedName(CacheEntity.KEY)
        private String mKey;
        @SerializedName("value")
        private String mValue;
    }
}
