package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.SearchKeywordParam;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes3.dex */
public class XPSearchKeywordParam implements Parcelable {
    public static final Parcelable.Creator<XPSearchKeywordParam> CREATOR = new Parcelable.Creator<XPSearchKeywordParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.XPSearchKeywordParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchKeywordParam createFromParcel(Parcel parcel) {
            return new XPSearchKeywordParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchKeywordParam[] newArray(int i) {
            return new XPSearchKeywordParam[i];
        }
    };
    private int mAdCode;
    private boolean mAddrPoiMerge;
    private String mBusOrCar;
    private String mCategory;
    private String mCenter;
    private String mCity;
    private boolean mCitySuggestion;
    private String mClassifyData;
    private String mClusterState;
    private String mCmsPoi;
    private String mCustom;
    private String mDataType;
    private boolean mDirectJump;
    private String mGeoobj;
    private String mHotelCheckIn;
    private String mHotelCheckOut;
    private String mId;
    private boolean mIsChargeRequest;
    private boolean mIsClassify;
    private String mKeywords;
    private boolean mLocStrict;
    private boolean mNeedCodePoint;
    private boolean mNeedMagicBox;
    private boolean mNeedParkInfo;
    private boolean mNeedUtd;
    private String mOfflineCustom;
    private int mOfflineResultMaxCount;
    private String mOnlyPoi;
    private int mPageNum;
    private int mPageSize;
    private XPCoordinate2DDouble mPoiLoc;
    private boolean mQii;
    private boolean mQueryAcs;
    private String mQueryMode;
    private String mQueryType;
    private String mRange;
    private boolean mRequireDetail;
    private String mScStyle;
    private int mScenario;
    private String mSceneFilter;
    private String mSceneId;
    private int mSearchOperate;
    private String mSearchSceneId;
    private String mSearchStrategy;
    private String mSiv;
    private int mSortRule;
    private int mSpecialPoi;
    private int mSpecialSearch;
    private String mSug;
    private String mSugAdcode;
    private String mSugPoiName;
    private String mSuperId;
    private String mTransferFilterFlag;
    private String mUserCity;
    private XPCoordinate2DDouble mUserLoc;
    private String mUtdSceneId;
    private String mVersion;
    private String mXPChargeOrder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPSearchKeywordParam() {
        this.mId = "";
        this.mSuperId = "";
        this.mUserLoc = new XPCoordinate2DDouble();
        this.mQueryType = "";
        this.mKeywords = "";
        this.mGeoobj = "";
        this.mSearchOperate = 0;
        this.mUtdSceneId = "";
        this.mLocStrict = false;
        this.mCity = "";
        this.mPageNum = 1;
        this.mPageSize = 20;
        this.mUserCity = "";
        this.mSearchSceneId = "";
        this.mPoiLoc = new XPCoordinate2DDouble();
        this.mScenario = 1;
        this.mCustom = "";
        this.mOfflineCustom = "";
        this.mSpecialSearch = 0;
        this.mRange = "";
        this.mSugAdcode = "";
        this.mOnlyPoi = "poi";
        this.mBusOrCar = "";
        this.mClassifyData = "";
        this.mSugPoiName = "";
        this.mSceneFilter = "";
        this.mScStyle = "";
        this.mHotelCheckIn = "";
        this.mHotelCheckOut = "";
        this.mNeedMagicBox = false;
        this.mIsClassify = false;
        this.mNeedParkInfo = true;
        this.mNeedCodePoint = true;
        this.mAddrPoiMerge = true;
        this.mCitySuggestion = true;
        this.mDirectJump = false;
        this.mNeedUtd = true;
        this.mQii = true;
        this.mQueryAcs = false;
        this.mClusterState = "5";
        this.mTransferFilterFlag = "0";
        this.mQueryMode = "";
        this.mCategory = "";
        this.mCenter = "";
        this.mDataType = "poi";
        this.mSpecialPoi = 0;
        this.mSortRule = 0;
        this.mSceneId = "";
        this.mSug = "";
        this.mAdCode = 0;
        this.mCmsPoi = "1";
        this.mVersion = "2.17";
        this.mSiv = "";
        this.mOfflineResultMaxCount = 20;
        this.mIsChargeRequest = false;
    }

    public XPSearchKeywordParam(SearchKeywordParam searchKeywordParam, String str) {
        this.mId = "";
        this.mSuperId = "";
        this.mUserLoc = new XPCoordinate2DDouble();
        this.mQueryType = "";
        this.mKeywords = "";
        this.mGeoobj = "";
        this.mSearchOperate = 0;
        this.mUtdSceneId = "";
        this.mLocStrict = false;
        this.mCity = "";
        this.mPageNum = 1;
        this.mPageSize = 20;
        this.mUserCity = "";
        this.mSearchSceneId = "";
        this.mPoiLoc = new XPCoordinate2DDouble();
        this.mScenario = 1;
        this.mCustom = "";
        this.mOfflineCustom = "";
        this.mSpecialSearch = 0;
        this.mRange = "";
        this.mSugAdcode = "";
        this.mOnlyPoi = "poi";
        this.mBusOrCar = "";
        this.mClassifyData = "";
        this.mSugPoiName = "";
        this.mSceneFilter = "";
        this.mScStyle = "";
        this.mHotelCheckIn = "";
        this.mHotelCheckOut = "";
        this.mNeedMagicBox = false;
        this.mIsClassify = false;
        this.mNeedParkInfo = true;
        this.mNeedCodePoint = true;
        this.mAddrPoiMerge = true;
        this.mCitySuggestion = true;
        this.mDirectJump = false;
        this.mNeedUtd = true;
        this.mQii = true;
        this.mQueryAcs = false;
        this.mClusterState = "5";
        this.mTransferFilterFlag = "0";
        this.mQueryMode = "";
        this.mCategory = "";
        this.mCenter = "";
        this.mDataType = "poi";
        this.mSpecialPoi = 0;
        this.mSortRule = 0;
        this.mSceneId = "";
        this.mSug = "";
        this.mAdCode = 0;
        this.mCmsPoi = "1";
        this.mVersion = "2.17";
        this.mSiv = "";
        this.mOfflineResultMaxCount = 20;
        this.mIsChargeRequest = false;
        this.mId = searchKeywordParam.id;
        this.mSuperId = searchKeywordParam.superid;
        this.mUserLoc = new XPCoordinate2DDouble(searchKeywordParam.user_loc);
        this.mQueryType = searchKeywordParam.query_type;
        this.mKeywords = searchKeywordParam.keywords;
        this.mGeoobj = searchKeywordParam.geoobj;
        this.mSearchOperate = searchKeywordParam.search_operate;
        this.mUtdSceneId = searchKeywordParam.utd_sceneid;
        this.mLocStrict = searchKeywordParam.loc_strict;
        this.mCity = searchKeywordParam.city;
        this.mPageNum = searchKeywordParam.pagenum;
        this.mPageSize = searchKeywordParam.pagesize;
        this.mUserCity = searchKeywordParam.user_city;
        this.mSearchSceneId = searchKeywordParam.search_sceneid;
        this.mPoiLoc = new XPCoordinate2DDouble(searchKeywordParam.poi_loc);
        this.mScenario = searchKeywordParam.scenario;
        this.mCustom = searchKeywordParam.custom;
        this.mOfflineCustom = searchKeywordParam.offlineCustom;
        this.mSpecialSearch = searchKeywordParam.specialSearch;
        this.mRange = searchKeywordParam.range;
        this.mSugAdcode = searchKeywordParam.sugadcode;
        this.mOnlyPoi = searchKeywordParam.onlypoi;
        this.mBusOrCar = searchKeywordParam.busorcar;
        this.mClassifyData = searchKeywordParam.classify_data;
        this.mSugPoiName = searchKeywordParam.sugpoiname;
        this.mSceneFilter = searchKeywordParam.scenefilter;
        this.mScStyle = searchKeywordParam.sc_stype;
        this.mHotelCheckIn = searchKeywordParam.hotelcheckin;
        this.mHotelCheckOut = searchKeywordParam.hotelcheckout;
        this.mNeedMagicBox = searchKeywordParam.need_magicbox;
        this.mIsClassify = searchKeywordParam.is_classify;
        this.mNeedParkInfo = searchKeywordParam.need_parkinfo;
        this.mNeedCodePoint = searchKeywordParam.need_codepoint;
        this.mAddrPoiMerge = searchKeywordParam.addr_poi_merge;
        this.mCitySuggestion = searchKeywordParam.citysuggestion;
        this.mDirectJump = searchKeywordParam.direct_jump;
        this.mNeedUtd = searchKeywordParam.need_utd;
        this.mQii = searchKeywordParam.qii;
        this.mQueryAcs = searchKeywordParam.query_acs;
        this.mClusterState = searchKeywordParam.cluster_state;
        this.mTransferFilterFlag = searchKeywordParam.transfer_filter_flag;
        this.mQueryMode = searchKeywordParam.query_mode;
        this.mCategory = searchKeywordParam.category;
        this.mCenter = searchKeywordParam.center;
        this.mDataType = searchKeywordParam.data_type;
        this.mSpecialPoi = searchKeywordParam.specialpoi;
        this.mSortRule = searchKeywordParam.sort_rule;
        this.mSceneId = searchKeywordParam.scene_id;
        this.mSug = searchKeywordParam.sug;
        this.mAdCode = searchKeywordParam.adcode;
        this.mCmsPoi = searchKeywordParam.cmspoi;
        this.mVersion = searchKeywordParam.version;
        this.mSiv = searchKeywordParam.siv;
        this.mOfflineResultMaxCount = searchKeywordParam.offlineResultMaxCount;
    }

    protected XPSearchKeywordParam(Parcel parcel) {
        this.mId = "";
        this.mSuperId = "";
        this.mUserLoc = new XPCoordinate2DDouble();
        this.mQueryType = "";
        this.mKeywords = "";
        this.mGeoobj = "";
        this.mSearchOperate = 0;
        this.mUtdSceneId = "";
        this.mLocStrict = false;
        this.mCity = "";
        this.mPageNum = 1;
        this.mPageSize = 20;
        this.mUserCity = "";
        this.mSearchSceneId = "";
        this.mPoiLoc = new XPCoordinate2DDouble();
        this.mScenario = 1;
        this.mCustom = "";
        this.mOfflineCustom = "";
        this.mSpecialSearch = 0;
        this.mRange = "";
        this.mSugAdcode = "";
        this.mOnlyPoi = "poi";
        this.mBusOrCar = "";
        this.mClassifyData = "";
        this.mSugPoiName = "";
        this.mSceneFilter = "";
        this.mScStyle = "";
        this.mHotelCheckIn = "";
        this.mHotelCheckOut = "";
        this.mNeedMagicBox = false;
        this.mIsClassify = false;
        this.mNeedParkInfo = true;
        this.mNeedCodePoint = true;
        this.mAddrPoiMerge = true;
        this.mCitySuggestion = true;
        this.mDirectJump = false;
        this.mNeedUtd = true;
        this.mQii = true;
        this.mQueryAcs = false;
        this.mClusterState = "5";
        this.mTransferFilterFlag = "0";
        this.mQueryMode = "";
        this.mCategory = "";
        this.mCenter = "";
        this.mDataType = "poi";
        this.mSpecialPoi = 0;
        this.mSortRule = 0;
        this.mSceneId = "";
        this.mSug = "";
        this.mAdCode = 0;
        this.mCmsPoi = "1";
        this.mVersion = "2.17";
        this.mSiv = "";
        this.mOfflineResultMaxCount = 20;
        this.mIsChargeRequest = false;
        this.mId = parcel.readString();
        this.mSuperId = parcel.readString();
        this.mUserLoc = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mQueryType = parcel.readString();
        this.mKeywords = parcel.readString();
        this.mGeoobj = parcel.readString();
        this.mSearchOperate = parcel.readInt();
        this.mUtdSceneId = parcel.readString();
        this.mLocStrict = parcel.readByte() != 0;
        this.mCity = parcel.readString();
        this.mPageNum = parcel.readInt();
        this.mPageSize = parcel.readInt();
        this.mUserCity = parcel.readString();
        this.mSearchSceneId = parcel.readString();
        this.mPoiLoc = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mScenario = parcel.readInt();
        this.mCustom = parcel.readString();
        this.mOfflineCustom = parcel.readString();
        this.mSpecialSearch = parcel.readInt();
        this.mRange = parcel.readString();
        this.mSugAdcode = parcel.readString();
        this.mOnlyPoi = parcel.readString();
        this.mBusOrCar = parcel.readString();
        this.mClassifyData = parcel.readString();
        this.mSugPoiName = parcel.readString();
        this.mSceneFilter = parcel.readString();
        this.mScStyle = parcel.readString();
        this.mHotelCheckIn = parcel.readString();
        this.mHotelCheckOut = parcel.readString();
        this.mNeedMagicBox = parcel.readByte() != 0;
        this.mIsClassify = parcel.readByte() != 0;
        this.mNeedParkInfo = parcel.readByte() != 0;
        this.mNeedCodePoint = parcel.readByte() != 0;
        this.mAddrPoiMerge = parcel.readByte() != 0;
        this.mCitySuggestion = parcel.readByte() != 0;
        this.mDirectJump = parcel.readByte() != 0;
        this.mNeedUtd = parcel.readByte() != 0;
        this.mQii = parcel.readByte() != 0;
        this.mQueryAcs = parcel.readByte() != 0;
        this.mClusterState = parcel.readString();
        this.mTransferFilterFlag = parcel.readString();
        this.mQueryMode = parcel.readString();
        this.mCategory = parcel.readString();
        this.mCenter = parcel.readString();
        this.mDataType = parcel.readString();
        this.mSpecialPoi = parcel.readInt();
        this.mSortRule = parcel.readInt();
        this.mSceneId = parcel.readString();
        this.mSug = parcel.readString();
        this.mAdCode = parcel.readInt();
        this.mCmsPoi = parcel.readString();
        this.mVersion = parcel.readString();
        this.mSiv = parcel.readString();
        this.mOfflineResultMaxCount = parcel.readInt();
        this.mSearchStrategy = parcel.readString();
        this.mXPChargeOrder = parcel.readString();
        this.mRequireDetail = parcel.readByte() != 0;
        this.mIsChargeRequest = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mSuperId);
        parcel.writeParcelable(this.mUserLoc, i);
        parcel.writeString(this.mQueryType);
        parcel.writeString(this.mKeywords);
        parcel.writeString(this.mGeoobj);
        parcel.writeInt(this.mSearchOperate);
        parcel.writeString(this.mUtdSceneId);
        parcel.writeByte(this.mLocStrict ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mCity);
        parcel.writeInt(this.mPageNum);
        parcel.writeInt(this.mPageSize);
        parcel.writeString(this.mUserCity);
        parcel.writeString(this.mSearchSceneId);
        parcel.writeParcelable(this.mPoiLoc, i);
        parcel.writeInt(this.mScenario);
        parcel.writeString(this.mCustom);
        parcel.writeString(this.mOfflineCustom);
        parcel.writeInt(this.mSpecialSearch);
        parcel.writeString(this.mRange);
        parcel.writeString(this.mSugAdcode);
        parcel.writeString(this.mOnlyPoi);
        parcel.writeString(this.mBusOrCar);
        parcel.writeString(this.mClassifyData);
        parcel.writeString(this.mSugPoiName);
        parcel.writeString(this.mSceneFilter);
        parcel.writeString(this.mScStyle);
        parcel.writeString(this.mHotelCheckIn);
        parcel.writeString(this.mHotelCheckOut);
        parcel.writeByte(this.mNeedMagicBox ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsClassify ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mNeedParkInfo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mNeedCodePoint ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mAddrPoiMerge ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mCitySuggestion ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mDirectJump ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mNeedUtd ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mQii ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mQueryAcs ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mClusterState);
        parcel.writeString(this.mTransferFilterFlag);
        parcel.writeString(this.mQueryMode);
        parcel.writeString(this.mCategory);
        parcel.writeString(this.mCenter);
        parcel.writeString(this.mDataType);
        parcel.writeInt(this.mSpecialPoi);
        parcel.writeInt(this.mSortRule);
        parcel.writeString(this.mSceneId);
        parcel.writeString(this.mSug);
        parcel.writeInt(this.mAdCode);
        parcel.writeString(this.mCmsPoi);
        parcel.writeString(this.mVersion);
        parcel.writeString(this.mSiv);
        parcel.writeInt(this.mOfflineResultMaxCount);
        parcel.writeString(this.mSearchStrategy);
        parcel.writeString(this.mXPChargeOrder);
        parcel.writeByte(this.mRequireDetail ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsChargeRequest ? (byte) 1 : (byte) 0);
    }

    @NonNull
    public SearchKeywordParam toSearchKeywordParam() {
        SearchKeywordParam searchKeywordParam = new SearchKeywordParam();
        searchKeywordParam.id = this.mId;
        searchKeywordParam.superid = this.mSuperId;
        searchKeywordParam.user_loc = this.mUserLoc.toBLCoord2D();
        searchKeywordParam.query_type = this.mQueryType;
        searchKeywordParam.keywords = this.mKeywords;
        searchKeywordParam.geoobj = this.mGeoobj;
        searchKeywordParam.search_operate = this.mSearchOperate;
        searchKeywordParam.utd_sceneid = this.mUtdSceneId;
        searchKeywordParam.loc_strict = this.mLocStrict;
        searchKeywordParam.city = this.mCity;
        searchKeywordParam.pagenum = this.mPageNum;
        searchKeywordParam.pagesize = this.mPageSize;
        searchKeywordParam.user_city = this.mUserCity;
        searchKeywordParam.search_sceneid = this.mSearchSceneId;
        searchKeywordParam.poi_loc = this.mPoiLoc.toBLCoord2D();
        searchKeywordParam.scenario = this.mScenario;
        searchKeywordParam.custom = this.mCustom;
        searchKeywordParam.offlineCustom = this.mOfflineCustom;
        searchKeywordParam.specialSearch = this.mSpecialSearch;
        searchKeywordParam.range = this.mRange;
        searchKeywordParam.sugadcode = this.mSugAdcode;
        searchKeywordParam.onlypoi = this.mOnlyPoi;
        searchKeywordParam.busorcar = this.mBusOrCar;
        searchKeywordParam.classify_data = this.mClassifyData;
        searchKeywordParam.sugpoiname = this.mSugPoiName;
        searchKeywordParam.scenefilter = this.mSceneFilter;
        searchKeywordParam.sc_stype = this.mScStyle;
        searchKeywordParam.hotelcheckin = this.mHotelCheckIn;
        searchKeywordParam.hotelcheckout = this.mHotelCheckOut;
        searchKeywordParam.need_magicbox = this.mNeedMagicBox;
        searchKeywordParam.is_classify = this.mIsClassify;
        searchKeywordParam.need_parkinfo = this.mNeedParkInfo;
        searchKeywordParam.need_codepoint = this.mNeedCodePoint;
        searchKeywordParam.addr_poi_merge = this.mAddrPoiMerge;
        searchKeywordParam.citysuggestion = this.mCitySuggestion;
        searchKeywordParam.direct_jump = this.mDirectJump;
        searchKeywordParam.need_utd = this.mNeedUtd;
        searchKeywordParam.qii = this.mQii;
        searchKeywordParam.query_acs = this.mQueryAcs;
        searchKeywordParam.cluster_state = this.mClusterState;
        searchKeywordParam.transfer_filter_flag = this.mTransferFilterFlag;
        searchKeywordParam.query_mode = this.mQueryMode;
        searchKeywordParam.category = this.mCategory;
        searchKeywordParam.center = this.mCenter;
        searchKeywordParam.data_type = this.mDataType;
        searchKeywordParam.specialpoi = this.mSpecialPoi;
        searchKeywordParam.sort_rule = this.mSortRule;
        searchKeywordParam.scene_id = this.mSceneId;
        searchKeywordParam.sug = this.mSug;
        searchKeywordParam.adcode = this.mAdCode;
        searchKeywordParam.cmspoi = this.mCmsPoi;
        searchKeywordParam.version = this.mVersion;
        searchKeywordParam.siv = this.mSiv;
        searchKeywordParam.offlineResultMaxCount = this.mOfflineResultMaxCount;
        return searchKeywordParam;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getSuperId() {
        return this.mSuperId;
    }

    public void setSuperId(String str) {
        this.mSuperId = str;
    }

    public XPCoordinate2DDouble getUserLoc() {
        return this.mUserLoc;
    }

    public void setUserLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mUserLoc = xPCoordinate2DDouble;
    }

    public String getQueryType() {
        return this.mQueryType;
    }

    public void setQueryType(String str) {
        this.mQueryType = str;
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    public void setKeywords(String str) {
        this.mKeywords = str;
    }

    public String getGeoobj() {
        return this.mGeoobj;
    }

    public void setGeoobj(String str) {
        this.mGeoobj = str;
    }

    public int getSearchOperate() {
        return this.mSearchOperate;
    }

    public void setSearchOperate(int i) {
        this.mSearchOperate = i;
    }

    public String getUtdSceneId() {
        return this.mUtdSceneId;
    }

    public void setUtdSceneId(String str) {
        this.mUtdSceneId = str;
    }

    public boolean isLocStrict() {
        return this.mLocStrict;
    }

    public void setLocStrict(boolean z) {
        this.mLocStrict = z;
    }

    public String getCity() {
        return this.mCity;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    public void autoIncrementPageNum() {
        this.mPageNum++;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        this.mPageSize = i;
    }

    public String getUserCity() {
        return this.mUserCity;
    }

    public void setUserCity(String str) {
        this.mUserCity = str;
    }

    public String getSearchSceneId() {
        return this.mSearchSceneId;
    }

    public void setSearchSceneId(String str) {
        this.mSearchSceneId = str;
    }

    public XPCoordinate2DDouble getPoiLoc() {
        return this.mPoiLoc;
    }

    public void setPoiLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLoc = xPCoordinate2DDouble;
    }

    public int getScenario() {
        return this.mScenario;
    }

    public void setScenario(int i) {
        this.mScenario = i;
    }

    public String getCustom() {
        return this.mCustom;
    }

    public void setCustom(String str) {
        this.mCustom = str;
    }

    public String getOfflineCustom() {
        return this.mOfflineCustom;
    }

    public void setOfflineCustom(String str) {
        this.mOfflineCustom = str;
    }

    public int getSpecialSearch() {
        return this.mSpecialSearch;
    }

    public void setSpecialSearch(int i) {
        this.mSpecialSearch = i;
    }

    public String getRange() {
        return this.mRange;
    }

    public void setRange(String str) {
        this.mRange = str;
    }

    public String getSugAdcode() {
        return this.mSugAdcode;
    }

    public void setSugAdcode(String str) {
        this.mSugAdcode = str;
    }

    public String getOnlyPoi() {
        return this.mOnlyPoi;
    }

    public void setOnlyPoi(String str) {
        this.mOnlyPoi = str;
    }

    public String getBusOrCar() {
        return this.mBusOrCar;
    }

    public void setBusOrCar(String str) {
        this.mBusOrCar = str;
    }

    public String getClassifyData() {
        return this.mClassifyData;
    }

    public void setClassifyData(String str) {
        this.mClassifyData = str;
    }

    public String getSugPoiName() {
        return this.mSugPoiName;
    }

    public void setSugPoiName(String str) {
        this.mSugPoiName = str;
    }

    public String getSceneFilter() {
        return this.mSceneFilter;
    }

    public void setSceneFilter(String str) {
        this.mSceneFilter = str;
    }

    public String getScStyle() {
        return this.mScStyle;
    }

    public void setScStyle(String str) {
        this.mScStyle = str;
    }

    public String getHotelCheckIn() {
        return this.mHotelCheckIn;
    }

    public void setHotelCheckIn(String str) {
        this.mHotelCheckIn = str;
    }

    public String getHotelCheckOut() {
        return this.mHotelCheckOut;
    }

    public void setHotelCheckOut(String str) {
        this.mHotelCheckOut = str;
    }

    public boolean isNeedMagicBox() {
        return this.mNeedMagicBox;
    }

    public void setNeedMagicBox(boolean z) {
        this.mNeedMagicBox = z;
    }

    public boolean isIsClassify() {
        return this.mIsClassify;
    }

    public void setIsClassify(boolean z) {
        this.mIsClassify = z;
    }

    public boolean isNeedParkInfo() {
        return this.mNeedParkInfo;
    }

    public void setNeedParkInfo(boolean z) {
        this.mNeedParkInfo = z;
    }

    public boolean isNeedCodePoint() {
        return this.mNeedCodePoint;
    }

    public void setNeedCodePoint(boolean z) {
        this.mNeedCodePoint = z;
    }

    public boolean isAddrPoiMerge() {
        return this.mAddrPoiMerge;
    }

    public void setAddrPoiMerge(boolean z) {
        this.mAddrPoiMerge = z;
    }

    public boolean isCitySuggestion() {
        return this.mCitySuggestion;
    }

    public void setCitySuggestion(boolean z) {
        this.mCitySuggestion = z;
    }

    public boolean isDirectJump() {
        return this.mDirectJump;
    }

    public void setDirectJump(boolean z) {
        this.mDirectJump = z;
    }

    public boolean isNeedUtd() {
        return this.mNeedUtd;
    }

    public void setNeedUtd(boolean z) {
        this.mNeedUtd = z;
    }

    public boolean isQii() {
        return this.mQii;
    }

    public void setQii(boolean z) {
        this.mQii = z;
    }

    public boolean isQueryAcs() {
        return this.mQueryAcs;
    }

    public void setQueryAcs(boolean z) {
        this.mQueryAcs = z;
    }

    public String getClusterState() {
        return this.mClusterState;
    }

    public void setClusterState(String str) {
        this.mClusterState = str;
    }

    public String getTransferFilterFlag() {
        return this.mTransferFilterFlag;
    }

    public void setTransferFilterFlag(String str) {
        this.mTransferFilterFlag = str;
    }

    public String getQueryMode() {
        return this.mQueryMode;
    }

    public void setQueryMode(String str) {
        this.mQueryMode = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCenter() {
        return this.mCenter;
    }

    public void setCenter(String str) {
        this.mCenter = str;
    }

    public String getDataType() {
        return this.mDataType;
    }

    public void setDataType(String str) {
        this.mDataType = str;
    }

    public int getSpecialPoi() {
        return this.mSpecialPoi;
    }

    public void setSpecialPoi(int i) {
        this.mSpecialPoi = i;
    }

    public int getSortRule() {
        return this.mSortRule;
    }

    public void setSortRule(int i) {
        this.mSortRule = i;
    }

    public String getSceneId() {
        return this.mSceneId;
    }

    public void setSceneId(String str) {
        this.mSceneId = str;
    }

    public String getSug() {
        return this.mSug;
    }

    public void setSug(String str) {
        this.mSug = str;
    }

    public int getAdCode() {
        return this.mAdCode;
    }

    public void setAdCode(int i) {
        this.mAdCode = i;
    }

    public String getCmsPoi() {
        return this.mCmsPoi;
    }

    public void setCmsPoi(String str) {
        this.mCmsPoi = str;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getSiv() {
        return this.mSiv;
    }

    public void setSiv(String str) {
        this.mSiv = str;
    }

    public int getOfflineResultMaxCount() {
        return this.mOfflineResultMaxCount;
    }

    public void setOfflineResultMaxCount(int i) {
        this.mOfflineResultMaxCount = i;
    }

    public String getSearchStrategy() {
        return this.mSearchStrategy;
    }

    public void setSearchStrategy(String str) {
        this.mSearchStrategy = str;
    }

    public String getXPChargeOrder() {
        return this.mXPChargeOrder;
    }

    public void setXPChargeOrder(String str) {
        this.mXPChargeOrder = str;
    }

    public boolean getRequireDetail() {
        return this.mRequireDetail;
    }

    public void setRequireDetail(boolean z) {
        this.mRequireDetail = z;
    }

    public boolean getIsChargeRequest() {
        return this.mIsChargeRequest;
    }

    public void setIsChargeRequest(boolean z) {
        this.mIsChargeRequest = z;
    }

    public boolean isClassify() {
        return this.mIsClassify;
    }

    public void setClassify(boolean z) {
        this.mIsClassify = z;
    }

    public boolean isRequireDetail() {
        return this.mRequireDetail;
    }

    public boolean isChargeRequest() {
        return this.mIsChargeRequest;
    }

    public void setChargeRequest(boolean z) {
        this.mIsChargeRequest = z;
    }
}
