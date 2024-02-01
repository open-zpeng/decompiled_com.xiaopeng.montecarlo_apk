package com.xiaopeng.montecarlo.navcore.bean.sync;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
/* loaded from: classes3.dex */
public class XPHistoryRecordItem {
    @SerializedName("mAdCode")
    private String mAdCode;
    @SerializedName("mAddress")
    private String mAddress;
    @SerializedName("mCategory")
    private String mCategory;
    @SerializedName("mChildPoisJson")
    private String mChildPoisJson;
    @SerializedName("mCityCode")
    private String mCityCode;
    @SerializedName("mCityName")
    private String mCityName;
    @SerializedName("mCreateTime")
    private String mCreateTime;
    @SerializedName("mDataVersion")
    private long mDataVersion;
    @SerializedName("mDistrictName")
    private String mDistrictName;
    @SerializedName("mHasChildPois")
    private String mHasChildPois;
    @SerializedName("mHasParkPois")
    private String mHasParkPois;
    @SerializedName("mHistoryType")
    private String mHistoryType;
    @SerializedName("mIconType")
    private String mIconType;
    @SerializedName("mIconUrl")
    private String mIconUrl;
    @SerializedName("mIsOffline")
    private String mIsOffline;
    @SerializedName("mLat")
    private String mLat;
    @SerializedName("mLon")
    private String mLon;
    @SerializedName("mName")
    private String mName;
    @SerializedName("mNavLat")
    private String mNavLat;
    @SerializedName("mNavLon")
    private String mNavLon;
    @SerializedName("mOpenTime")
    private String mOpenTime;
    @SerializedName("mOverHead")
    private String mOverHead;
    @SerializedName("mParentID")
    private String mParentID;
    @SerializedName("mParentName")
    private String mParentName;
    @SerializedName("mParentSimpleName")
    private String mParentSimpleName;
    @SerializedName("mPhoneNumbers")
    private String mPhoneNumbers;
    @SerializedName("mPoiId")
    private String mPoiId;
    @SerializedName("mPoiSource")
    private String mPoiSource;
    @SerializedName("mPrice")
    private String mPrice;
    @SerializedName("mProvinceName")
    private String mProvinceName;
    @SerializedName("mReserveA")
    private String mReserveA;
    @SerializedName("mReserveB")
    private String mReserveB;
    @SerializedName("mReserveC")
    private String mReserveC;
    @SerializedName("mTag")
    private String mTag;
    @SerializedName("mType")
    private String mType;
    @SerializedName("mTypeCode")
    private String mTypeCode;
    @SerializedName("mUpdateCount")
    private int mUpdateCount;
    @SerializedName("mViaPoisJson")
    private String mViaPoisJson;

    public void setLon(String str) {
        this.mLon = str;
    }

    public String getLon() {
        return this.mLon;
    }

    public String getLat() {
        return this.mLat;
    }

    public void setLat(String str) {
        this.mLat = str;
    }

    public String getNavLon() {
        return this.mNavLon;
    }

    public void setNavLon(String str) {
        this.mNavLon = str;
    }

    public String getNavLat() {
        return this.mNavLat;
    }

    public void setNavLat(String str) {
        this.mNavLat = str;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public void setCityCode(String str) {
        this.mCityCode = str;
    }

    public void setCityName(String str) {
        this.mCityName = str;
    }

    public String getCityName() {
        return this.mCityName;
    }

    public void setPhoneNumbers(String str) {
        this.mPhoneNumbers = str;
    }

    public String getPhoneNumbers() {
        return this.mPhoneNumbers;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getOpenTime() {
        return this.mOpenTime;
    }

    public void setOpenTime(String str) {
        this.mOpenTime = str;
    }

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setHasChildPois(String str) {
        this.mHasChildPois = str;
    }

    public String getHasChildPois() {
        return this.mHasChildPois;
    }

    public String getChildPoisJson() {
        return this.mChildPoisJson;
    }

    public void setChildPoisJson(String str) {
        this.mChildPoisJson = str;
    }

    public void setIsOffline(String str) {
        this.mIsOffline = str;
    }

    public String getIsOffline() {
        return this.mIsOffline;
    }

    public String getAdCode() {
        return this.mAdCode;
    }

    public void setAdCode(String str) {
        this.mAdCode = str;
    }

    public String getProvinceName() {
        return this.mProvinceName;
    }

    public void setProvinceName(String str) {
        this.mProvinceName = str;
    }

    public String getDistrictName() {
        return this.mDistrictName;
    }

    public void setDistrictName(String str) {
        this.mDistrictName = str;
    }

    public void setIconType(String str) {
        this.mIconType = str;
    }

    public String getIconType() {
        return this.mIconType;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getParentID() {
        return this.mParentID;
    }

    public void setParentID(String str) {
        this.mParentID = str;
    }

    public void setParentName(String str) {
        this.mParentName = str;
    }

    public String getParentName() {
        return this.mParentName;
    }

    public String getParentSimpleName() {
        return this.mParentSimpleName;
    }

    public void setParentSimpleName(String str) {
        this.mParentSimpleName = str;
    }

    public void setTypeCode(String str) {
        this.mTypeCode = str;
    }

    public String getTypeCode() {
        return this.mTypeCode;
    }

    public void setOverHead(String str) {
        this.mOverHead = str;
    }

    public String getOverHead() {
        return this.mOverHead;
    }

    public String getHasParkPois() {
        return this.mHasParkPois;
    }

    public void setHasParkPois(String str) {
        this.mHasParkPois = str;
    }

    public String getCreateTime() {
        return this.mCreateTime;
    }

    public void setCreateTime(String str) {
        this.mCreateTime = str;
    }

    public String getHistoryType() {
        return this.mHistoryType;
    }

    public void setHistoryType(String str) {
        this.mHistoryType = str;
    }

    public void setPoiSource(String str) {
        this.mPoiSource = str;
    }

    public String getPoiSource() {
        return this.mPoiSource;
    }

    public void setReserveA(String str) {
        this.mReserveA = str;
    }

    public String getReserveA() {
        return this.mReserveA;
    }

    public void setReserveB(String str) {
        this.mReserveB = str;
    }

    public String getReserveB() {
        return this.mReserveB;
    }

    public void setReserveC(String str) {
        this.mReserveC = str;
    }

    public String getReserveC() {
        return this.mReserveC;
    }

    public void setViaPoisJson(String str) {
        this.mViaPoisJson = str;
    }

    public String getViaPoisJson() {
        return this.mViaPoisJson;
    }

    public long getDataVersion() {
        return this.mDataVersion;
    }

    public void setDataVersion(long j) {
        this.mDataVersion = j;
    }

    public void setUpdateCount(int i) {
        this.mUpdateCount = i;
    }

    public int getUpdateCount() {
        return this.mUpdateCount;
    }

    public XPHistoryRecordItem(HistoryRecordInfo historyRecordInfo) {
        if (historyRecordInfo != null) {
            XPPoiInfo xPPoiInfo = historyRecordInfo.getXPPoiInfo();
            if (xPPoiInfo != null) {
                this.mLon = String.valueOf(xPPoiInfo.getDisplayLon());
                this.mLat = String.valueOf(xPPoiInfo.getDisplayLat());
                this.mNavLon = String.valueOf(xPPoiInfo.getNaviLon());
                this.mNavLat = String.valueOf(xPPoiInfo.getNaviLat());
                this.mPoiId = xPPoiInfo.getPoiId();
                this.mCityCode = xPPoiInfo.getCityCode();
                this.mCityName = xPPoiInfo.getCityName();
                this.mPhoneNumbers = xPPoiInfo.getTel();
                this.mTag = xPPoiInfo.getTag();
                this.mOpenTime = xPPoiInfo.getOpenTime();
                this.mPrice = xPPoiInfo.getPrice();
                this.mName = xPPoiInfo.getName();
                this.mType = String.valueOf(xPPoiInfo.getType());
                this.mCategory = String.valueOf(xPPoiInfo.getCategory());
                this.mAddress = xPPoiInfo.getAddress();
                this.mIsOffline = xPPoiInfo.isOffline() ? "1" : "0";
                this.mAdCode = String.valueOf(xPPoiInfo.getAdCode());
                this.mProvinceName = xPPoiInfo.getProvinceName();
                this.mDistrictName = xPPoiInfo.getDistrictName();
                this.mIconType = xPPoiInfo.getIconType();
                this.mIconUrl = xPPoiInfo.getIconUrl();
                this.mParentID = xPPoiInfo.getParentID();
                this.mParentName = xPPoiInfo.getParentName();
                this.mParentSimpleName = xPPoiInfo.getParentSimpleName();
                this.mTypeCode = xPPoiInfo.getTypeCode();
                this.mOverHead = String.valueOf((int) xPPoiInfo.getOverhead());
                this.mHasParkPois = xPPoiInfo.isHasPark() ? "1" : "0";
                this.mPoiSource = String.valueOf(xPPoiInfo.getPoiSource());
                this.mReserveA = xPPoiInfo.getBlCategory();
                this.mReserveB = xPPoiInfo.getReserveB();
                this.mReserveC = xPPoiInfo.getReserveC();
            }
            this.mHasChildPois = historyRecordInfo.isHasChildPois() ? "1" : "0";
            if (xPPoiInfo != null && CollectionUtils.isNotEmpty(xPPoiInfo.getChild())) {
                this.mChildPoisJson = historyRecordInfo.toSimplePoiJson(xPPoiInfo.getChild());
            } else {
                this.mChildPoisJson = "";
            }
            this.mCreateTime = String.valueOf(historyRecordInfo.getCreateTime());
            this.mHistoryType = String.valueOf(historyRecordInfo.getHistoryType());
            if (CollectionUtils.isNotEmpty(historyRecordInfo.getViaPois())) {
                this.mViaPoisJson = historyRecordInfo.toSimplePoiJson(historyRecordInfo.getViaPois());
            } else {
                this.mViaPoisJson = "";
            }
            this.mDataVersion = historyRecordInfo.getDataVersion();
            this.mUpdateCount = historyRecordInfo.getUpdateCount();
        }
    }
}
