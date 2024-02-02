package com.xiaopeng.montecarlo.navcore.search.charge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class RecommendChargerBean {
    public static final int RECOMMEND_TYPE_AROUND = 2000;
    public static final int RECOMMEND_TYPE_FREQUENT = 1000;
    public static final int SOURCE_BL = 1;
    public static final int SOURCE_OTHER = 3;
    public static final int SOURCE_PRIVATE = 2;
    public static final int SOURCE_XP = 0;
    public static final int TYPE_AROUND_OTHER_FAST = 2002;
    public static final int TYPE_AROUND_OTHER_SLOW = 2003;
    public static final int TYPE_AROUND_XP = 2001;
    public static final int TYPE_FREQUENT_COMP = 1001;
    public static final int TYPE_FREQUENT_HOME = 1002;
    public static final int TYPE_FREQUENT_NORMAL = 1003;
    public static final int TYPE_ORIGIN_FREQUENT_COMP = 1;
    public static final int TYPE_ORIGIN_FREQUENT_HOME = 2;
    public static final int TYPE_ORIGIN_FREQUENT_NORMAL = 3;
    @SerializedName("address")
    @Expose
    private String mAddress;
    @SerializedName("type")
    @Expose
    private int mFrequentOriginalType;
    @SerializedName(CPSearchParam.PARAM_KEY_STATIONID)
    @Expose
    private String mId;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    @Expose
    private String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    @Expose
    private String mLon;
    @SerializedName("name")
    @Expose
    private String mName;
    @Expose(deserialize = false, serialize = false)
    private int mRecommendType;
    @SerializedName("source")
    @Expose
    private int mSource;
    @Expose(deserialize = false, serialize = false)
    private int mType;
    @Expose(deserialize = false, serialize = false)
    private XPPoiInfo mXPPoiInfo;
    @SerializedName("navDistance")
    @Expose(deserialize = true, serialize = false)
    private long mNavDistance = -1;
    @SerializedName("onRemainDis")
    @Expose(deserialize = true, serialize = false)
    private long mLeftDistance = -1;
    @SerializedName("lineDistance")
    @Expose(deserialize = true, serialize = false)
    private long mLineDistance = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ChargeDetailType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ChargeOriginType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ChargeRecommendType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface RecommendChargeSource {
    }

    public static boolean isFrequent(int i) {
        return i < 2000 && i > 1000;
    }

    public static boolean isHomeOrCompany(int i) {
        return i == 1 || i == 2;
    }

    public RecommendChargerBean() {
    }

    public RecommendChargerBean(String str, XPPoiInfo xPPoiInfo) {
        this.mId = str;
        this.mXPPoiInfo = xPPoiInfo;
        if (this.mXPPoiInfo == null) {
            throw new IllegalArgumentException("poiInfo cannot be null");
        }
    }

    public long getNavDistance() {
        return this.mNavDistance;
    }

    public void setNavDistance(long j) {
        this.mNavDistance = j;
    }

    public long getLeftDistance() {
        return this.mLeftDistance;
    }

    public void setLeftDistance(long j) {
        this.mLeftDistance = j;
    }

    public long getLineDistance() {
        return this.mLineDistance;
    }

    public void setLineDistance(long j) {
        this.mLineDistance = j;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public XPPoiInfo getXPPoiInfo() {
        return this.mXPPoiInfo;
    }

    public void setXPPoiInfo(XPPoiInfo xPPoiInfo) {
        this.mXPPoiInfo = xPPoiInfo;
        if (this.mXPPoiInfo == null) {
            throw new IllegalArgumentException("poiInfo cannot set to null");
        }
    }

    public int getFrequentOriginalType() {
        return this.mFrequentOriginalType;
    }

    public void setFrequentOriType(int i) {
        this.mFrequentOriginalType = i;
    }

    public int getRecommendType() {
        return this.mRecommendType;
    }

    public void setRecommendType(int i) {
        this.mRecommendType = i;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public int getSource() {
        return this.mSource;
    }

    public void setSource(int i) {
        this.mSource = i;
    }

    public double getLon() {
        return Double.parseDouble(this.mLon);
    }

    public void setLon(double d) {
        this.mLon = String.valueOf(d);
    }

    public double getLat() {
        return Double.parseDouble(this.mLat);
    }

    public void setLat(double d) {
        this.mLat = String.valueOf(d);
    }

    public void generateXPPoiInfo() {
        this.mXPPoiInfo = new XPPoiInfo();
        this.mXPPoiInfo.setPoiId(this.mId);
        this.mXPPoiInfo.setName(this.mName);
        this.mXPPoiInfo.setAddress(this.mAddress);
        this.mXPPoiInfo.setDisplayLat(getLat());
        this.mXPPoiInfo.setDisplayLon(getLon());
        this.mXPPoiInfo.setDistance(this.mLineDistance);
        int i = 3;
        this.mXPPoiInfo.setPoiSource(3);
        this.mXPPoiInfo.setCategory(107);
        int i2 = this.mSource;
        if (i2 == 0) {
            this.mXPPoiInfo.setCategory(108);
        } else if (i2 != 1) {
            i = i2 != 2 ? -1 : 8;
        } else {
            this.mXPPoiInfo.setCategory(103);
            i = 1;
        }
        this.mXPPoiInfo.setPoiSource(i);
    }

    public String toString() {
        return " { mName:" + this.mName + ", mId: " + this.mId + ", mNavDistance: " + this.mNavDistance + ", mLeftDistance: " + this.mLeftDistance + ", mType: " + this.mType + ", mFrequentOriginalType: " + this.mFrequentOriginalType + " } ";
    }
}
