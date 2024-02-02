package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.SearchAlongWayParam;
import com.autonavi.gbl.search.model.SearchRoadId;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPSearchRoadId;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class XPSearchAlongWayParam implements Parcelable {
    public int mAdcode;
    public String mCategory;
    public String mCustom;
    public String mCustomAnd;
    public int mEtaFlag;
    public int mEtaType;
    public String mGeoLine;
    public XPSearchRoadId[] mGuideRoads;
    private boolean mIsChargeRequest;
    public String mKeyword;
    public boolean mNeedEta;
    public boolean mNeedGasPrice;
    public boolean mNeedNaviInfo;
    private String mOrder;
    private int mPageNum;
    private int mPageSize;
    private boolean mRequireDetail;
    public String mRoutePoints;
    public int mRouteRange;
    private String mSearchStrategy;
    private int mSearchType;
    public XPCoordinate2DDouble mUserLoc;
    private static final L.Tag TAG = new L.Tag("XPSearchAlongWayParam");
    public static final Parcelable.Creator<XPSearchAlongWayParam> CREATOR = new Parcelable.Creator<XPSearchAlongWayParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.XPSearchAlongWayParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchAlongWayParam createFromParcel(@NonNull Parcel parcel) {
            return new XPSearchAlongWayParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchAlongWayParam[] newArray(int i) {
            return new XPSearchAlongWayParam[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPSearchAlongWayParam() {
        this.mUserLoc = new XPCoordinate2DDouble();
        this.mKeyword = "";
        this.mCategory = "";
        this.mAdcode = 0;
        this.mNeedGasPrice = false;
        this.mNeedNaviInfo = false;
        this.mNeedEta = false;
        this.mEtaType = -1;
        this.mEtaFlag = -1;
        this.mRoutePoints = "";
        this.mRouteRange = -1;
        this.mGeoLine = "";
        this.mCustom = "";
        this.mCustomAnd = "";
        this.mPageNum = 1;
        this.mPageSize = 20;
        this.mIsChargeRequest = false;
    }

    public XPSearchAlongWayParam(SearchAlongWayParam searchAlongWayParam, int i, int i2) {
        this.mUserLoc = new XPCoordinate2DDouble();
        this.mKeyword = "";
        this.mCategory = "";
        this.mAdcode = 0;
        this.mNeedGasPrice = false;
        this.mNeedNaviInfo = false;
        this.mNeedEta = false;
        this.mEtaType = -1;
        this.mEtaFlag = -1;
        this.mRoutePoints = "";
        this.mRouteRange = -1;
        this.mGeoLine = "";
        this.mCustom = "";
        this.mCustomAnd = "";
        this.mPageNum = 1;
        this.mPageSize = 20;
        this.mIsChargeRequest = false;
        this.mUserLoc = new XPCoordinate2DDouble(searchAlongWayParam.user_loc);
        this.mKeyword = searchAlongWayParam.keyword;
        this.mCategory = searchAlongWayParam.category;
        this.mAdcode = searchAlongWayParam.adcode;
        this.mNeedGasPrice = searchAlongWayParam.need_gasprice;
        this.mNeedNaviInfo = searchAlongWayParam.need_naviinfo;
        this.mNeedEta = searchAlongWayParam.need_eta;
        this.mEtaType = searchAlongWayParam.eta_type;
        this.mEtaFlag = searchAlongWayParam.eta_flag;
        this.mRoutePoints = searchAlongWayParam.routepoints;
        this.mRouteRange = searchAlongWayParam.route_range;
        this.mGeoLine = searchAlongWayParam.geoline;
        this.mCustom = searchAlongWayParam.custom;
        this.mCustomAnd = searchAlongWayParam.custom_and;
        int size = searchAlongWayParam.guideRoads.size();
        this.mGuideRoads = new XPSearchRoadId[size];
        for (int i3 = 0; i3 < size; i3++) {
            this.mGuideRoads[i3] = new XPSearchRoadId(searchAlongWayParam.guideRoads.get(i3));
        }
        this.mPageNum = 1;
        this.mSearchType = i;
    }

    protected XPSearchAlongWayParam(Parcel parcel) {
        this.mUserLoc = new XPCoordinate2DDouble();
        this.mKeyword = "";
        this.mCategory = "";
        this.mAdcode = 0;
        this.mNeedGasPrice = false;
        this.mNeedNaviInfo = false;
        this.mNeedEta = false;
        this.mEtaType = -1;
        this.mEtaFlag = -1;
        this.mRoutePoints = "";
        this.mRouteRange = -1;
        this.mGeoLine = "";
        this.mCustom = "";
        this.mCustomAnd = "";
        this.mPageNum = 1;
        this.mPageSize = 20;
        this.mIsChargeRequest = false;
        this.mUserLoc = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mKeyword = parcel.readString();
        this.mCategory = parcel.readString();
        this.mAdcode = parcel.readInt();
        this.mNeedGasPrice = parcel.readByte() != 0;
        this.mNeedNaviInfo = parcel.readByte() != 0;
        this.mNeedEta = parcel.readByte() != 0;
        this.mEtaType = parcel.readInt();
        this.mEtaFlag = parcel.readInt();
        this.mRoutePoints = parcel.readString();
        this.mRouteRange = parcel.readInt();
        this.mGeoLine = parcel.readString();
        this.mCustom = parcel.readString();
        this.mCustomAnd = parcel.readString();
        this.mGuideRoads = (XPSearchRoadId[]) parcel.createTypedArray(XPSearchRoadId.CREATOR);
        this.mPageNum = parcel.readInt();
        this.mPageSize = parcel.readInt();
        this.mSearchType = parcel.readInt();
        this.mSearchStrategy = parcel.readString();
        this.mRequireDetail = parcel.readByte() != 0;
        this.mIsChargeRequest = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.mUserLoc, i);
        parcel.writeString(this.mKeyword);
        parcel.writeString(this.mCategory);
        parcel.writeInt(this.mAdcode);
        parcel.writeByte(this.mNeedGasPrice ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mNeedNaviInfo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mNeedEta ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mEtaType);
        parcel.writeInt(this.mEtaFlag);
        parcel.writeString(this.mRoutePoints);
        parcel.writeInt(this.mRouteRange);
        parcel.writeString(this.mGeoLine);
        parcel.writeString(this.mCustom);
        parcel.writeString(this.mCustomAnd);
        parcel.writeTypedArray(this.mGuideRoads, i);
        parcel.writeInt(this.mPageNum);
        parcel.writeInt(this.mPageSize);
        parcel.writeInt(this.mSearchType);
        parcel.writeString(this.mSearchStrategy);
        parcel.writeByte(this.mRequireDetail ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsChargeRequest ? (byte) 1 : (byte) 0);
    }

    @NonNull
    public SearchAlongWayParam toSearchAlongWayParam() {
        SearchAlongWayParam searchAlongWayParam = new SearchAlongWayParam();
        searchAlongWayParam.user_loc = this.mUserLoc.toBLCoord2D();
        String str = this.mCategory;
        searchAlongWayParam.category = str;
        if (XPPoiCategory.SEARCH_CATEGORY_FIXSHOP_OFFLINE.equalsIgnoreCase(str)) {
            searchAlongWayParam.keyword = ContextUtils.getString(R.string.search_category_fixshop_offline_keyword);
        } else {
            searchAlongWayParam.keyword = this.mKeyword;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "mCategory:" + this.mCategory + ", mKeyword:" + this.mKeyword + ", param.keyword:" + searchAlongWayParam.keyword);
        }
        searchAlongWayParam.adcode = this.mAdcode;
        searchAlongWayParam.need_gasprice = this.mNeedGasPrice;
        searchAlongWayParam.need_naviinfo = this.mNeedNaviInfo;
        searchAlongWayParam.need_eta = this.mNeedEta;
        searchAlongWayParam.eta_type = this.mEtaType;
        searchAlongWayParam.eta_flag = this.mEtaFlag;
        searchAlongWayParam.routepoints = this.mRoutePoints;
        searchAlongWayParam.route_range = this.mRouteRange;
        searchAlongWayParam.geoline = this.mGeoLine;
        searchAlongWayParam.custom = this.mCustom;
        searchAlongWayParam.custom_and = this.mCustomAnd;
        XPSearchRoadId[] xPSearchRoadIdArr = this.mGuideRoads;
        if (xPSearchRoadIdArr != null && xPSearchRoadIdArr.length > 0) {
            int length = xPSearchRoadIdArr.length;
            ArrayList<SearchRoadId> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                arrayList.add(this.mGuideRoads[i].toBLSearchRoadId());
            }
            searchAlongWayParam.guideRoads = arrayList;
        }
        return searchAlongWayParam;
    }

    public void autoIncrementPageNum() {
        this.mPageNum++;
    }

    public XPCoordinate2DDouble getUserLoc() {
        return this.mUserLoc;
    }

    public void setUserLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mUserLoc = xPCoordinate2DDouble;
    }

    public String getKeyword() {
        return this.mKeyword;
    }

    public void setKeyword(String str) {
        this.mKeyword = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int getAdcode() {
        return this.mAdcode;
    }

    public void setAdcode(int i) {
        this.mAdcode = i;
    }

    public boolean isNeedGasPrice() {
        return this.mNeedGasPrice;
    }

    public void setNeedGasPrice(boolean z) {
        this.mNeedGasPrice = z;
    }

    public boolean isNeedNaviInfo() {
        return this.mNeedNaviInfo;
    }

    public void setNeedNaviInfo(boolean z) {
        this.mNeedNaviInfo = z;
    }

    public boolean isNeedEta() {
        return this.mNeedEta;
    }

    public void setNeedEta(boolean z) {
        this.mNeedEta = z;
    }

    public int getEtaType() {
        return this.mEtaType;
    }

    public void setEtaType(int i) {
        this.mEtaType = i;
    }

    public int getEtaFlag() {
        return this.mEtaFlag;
    }

    public void setEtaFlag(int i) {
        this.mEtaFlag = i;
    }

    public String getRoutePoints() {
        return this.mRoutePoints;
    }

    public void setRoutePoints(String str) {
        this.mRoutePoints = str;
    }

    public int getRouteRange() {
        return this.mRouteRange;
    }

    public void setRouteRange(int i) {
        this.mRouteRange = i;
    }

    public String getGeoLine() {
        return this.mGeoLine;
    }

    public void setGeoLine(String str) {
        this.mGeoLine = str;
    }

    public String getCustom() {
        return this.mCustom;
    }

    public void setCustom(String str) {
        this.mCustom = str;
    }

    public String getCustomAnd() {
        return this.mCustomAnd;
    }

    public void setCustomAnd(String str) {
        this.mCustomAnd = str;
    }

    public XPSearchRoadId[] getGuideRoads() {
        return this.mGuideRoads;
    }

    public void setGuideRoads(XPSearchRoadId[] xPSearchRoadIdArr) {
        this.mGuideRoads = xPSearchRoadIdArr;
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        this.mPageSize = i;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(int i) {
        this.mSearchType = i;
    }

    public String getSearchStrategy() {
        return this.mSearchStrategy;
    }

    public void setSearchStrategy(String str) {
        this.mSearchStrategy = str;
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

    public String getOrder() {
        return this.mOrder;
    }

    public void setOrder(String str) {
        this.mOrder = str;
    }
}
