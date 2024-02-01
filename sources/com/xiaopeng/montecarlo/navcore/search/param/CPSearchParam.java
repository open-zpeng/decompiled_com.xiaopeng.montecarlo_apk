package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class CPSearchParam implements Parcelable {
    public static final Parcelable.Creator<CPSearchParam> CREATOR = new Parcelable.Creator<CPSearchParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CPSearchParam createFromParcel(Parcel parcel) {
            return new CPSearchParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CPSearchParam[] newArray(int i) {
            return new CPSearchParam[i];
        }
    };
    public static final int NEED_RECOMMEND_CHARGE_DIS_NO = 0;
    public static final int NEED_RECOMMEND_CHARGE_DIS_YES = 1;
    public static final String PARAM_KEY_AREACODE = "areacode";
    public static final String PARAM_KEY_CDUID = "cduId";
    public static final String PARAM_KEY_CITY = "city";
    public static final String PARAM_KEY_CITYCODE = "citycode";
    public static final String PARAM_KEY_DETAIL = "detail";
    public static final String PARAM_KEY_INDEX = "index";
    public static final String PARAM_KEY_IS_FREE = "isFree";
    public static final String PARAM_KEY_LAT = "lat";
    public static final String PARAM_KEY_LNG = "lng";
    public static final String PARAM_KEY_LOCATION = "location";
    public static final String PARAM_KEY_LON = "lon";
    public static final String PARAM_KEY_NEED_REQUIRE_DIS = "needDis";
    public static final String PARAM_KEY_ORDER = "order";
    public static final String PARAM_KEY_PATH = "path";
    public static final String PARAM_KEY_PILE_TYPE = "pileType";
    public static final String PARAM_KEY_QUERY = "query";
    public static final String PARAM_KEY_RADIUS = "radius";
    public static final String PARAM_KEY_REMAIN_DIS = "remainDis";
    public static final String PARAM_KEY_SEARCH = "search";
    public static final String PARAM_KEY_SIZE = "size";
    public static final String PARAM_KEY_STATIONID = "stationId";
    public static final String PARAM_KEY_STATIONS = "stations";
    public static final String PARAM_KEY_STRATEGY = "strategy";
    public static final String PARAM_KEY_TS = "ts";
    public static final String PARAM_KEY_VERSIONID = "versionId";
    public static final String PARAM_KEY_VIN = "vin";
    private String mAreaCode;
    private XPCoordinate2DDouble mCarLocation;
    private String mCategory;
    private int mChargeType;
    private String mCity;
    private String mCityCode;
    private boolean mDetail;
    private boolean mFree;
    private int mIndex;
    private int mNeedDis;
    private String mOrder;
    private List<String> mPath;
    private int mPileType;
    private String mPoiId;
    private XPCoordinate2DDouble mPoiLocation;
    private String mQuery;
    private int mRadius;
    private int mRemainDistance;
    private String mSearch;
    private int mSize;
    private List<RecommendChargerBean> mStations;
    private int mStrategy;
    private int mVehicleId;
    private String mVin;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CPSearchParam() {
        this.mChargeType = 1;
        this.mPileType = 0;
        this.mNeedDis = 0;
    }

    protected CPSearchParam(Parcel parcel) {
        this.mChargeType = 1;
        this.mPileType = 0;
        this.mNeedDis = 0;
        this.mPoiId = parcel.readString();
        this.mCategory = parcel.readString();
        this.mVin = parcel.readString();
        this.mPoiLocation = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mCarLocation = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mRadius = parcel.readInt();
        this.mSearch = parcel.readString();
        this.mOrder = parcel.readString();
        this.mDetail = parcel.readByte() != 0;
        this.mIndex = parcel.readInt();
        this.mSize = parcel.readInt();
        this.mPath = parcel.createStringArrayList();
        this.mCityCode = parcel.readString();
        this.mAreaCode = parcel.readString();
        this.mQuery = parcel.readString();
        this.mPileType = parcel.readInt();
        this.mFree = parcel.readByte() != 0;
        this.mCity = parcel.readString();
        this.mRemainDistance = parcel.readInt();
        this.mNeedDis = parcel.readInt();
        this.mStrategy = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mCategory);
        parcel.writeString(this.mVin);
        parcel.writeParcelable(this.mPoiLocation, i);
        parcel.writeParcelable(this.mCarLocation, i);
        parcel.writeInt(this.mRadius);
        parcel.writeString(this.mSearch);
        parcel.writeString(this.mOrder);
        parcel.writeByte(this.mDetail ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mSize);
        parcel.writeStringList(this.mPath);
        parcel.writeString(this.mCityCode);
        parcel.writeString(this.mAreaCode);
        parcel.writeString(this.mQuery);
        parcel.writeInt(this.mPileType);
        parcel.writeByte(this.mFree ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mCity);
        parcel.writeInt(this.mRemainDistance);
        parcel.writeInt(this.mNeedDis);
        parcel.writeInt(this.mStrategy);
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getVin() {
        return this.mVin;
    }

    public void setVin(String str) {
        this.mVin = str;
    }

    public XPCoordinate2DDouble getPoiLocation() {
        return this.mPoiLocation;
    }

    public void setPoiLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLocation = xPCoordinate2DDouble;
    }

    public XPCoordinate2DDouble getCarLocation() {
        return this.mCarLocation;
    }

    public void setCarLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mCarLocation = xPCoordinate2DDouble;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public String getSearch() {
        return this.mSearch;
    }

    public void setSearch(String str) {
        this.mSearch = str;
    }

    public String getOrder() {
        return this.mOrder;
    }

    public void setOrder(String str) {
        this.mOrder = str;
    }

    public boolean isDetail() {
        return this.mDetail;
    }

    public void setDetail(boolean z) {
        this.mDetail = z;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public int getSize() {
        return this.mSize;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public List<String> getPath() {
        return this.mPath;
    }

    public void setPath(List<String> list) {
        this.mPath = list;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public void setCityCode(String str) {
        this.mCityCode = str;
    }

    public String getAreaCode() {
        return this.mAreaCode;
    }

    public void setAreaCode(String str) {
        this.mAreaCode = str;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public void setQuery(String str) {
        this.mQuery = str;
    }

    public int getPileType() {
        return this.mPileType;
    }

    public void setPileType(int i) {
        this.mPileType = i;
    }

    public boolean isFree() {
        return this.mFree;
    }

    public void setFree(boolean z) {
        this.mFree = z;
    }

    public String getCity() {
        return this.mCity;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public int getRemainDistance() {
        return this.mRemainDistance;
    }

    public void setRemainDistance(int i) {
        this.mRemainDistance = i;
    }

    public int getNeedDis() {
        return this.mNeedDis;
    }

    public void setNeedDis(int i) {
        this.mNeedDis = i;
    }

    public List<RecommendChargerBean> getStations() {
        return this.mStations;
    }

    public void setStations(List<RecommendChargerBean> list) {
        this.mStations = list;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public void setStrategy(int i) {
        this.mStrategy = i;
    }

    public void prePage() {
        this.mIndex -= this.mSize;
        if (this.mIndex < 0) {
            this.mIndex = 0;
        }
    }

    public int getChargeType() {
        return this.mChargeType;
    }

    public void setChargeType(int i) {
        this.mChargeType = i;
    }

    public void nextPage() {
        this.mIndex += this.mSize;
    }

    public Map<String, Object> toAroundParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("vin", RootUtil.getVin());
        if (this.mPoiLocation != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00000");
            hashMap.put(PARAM_KEY_LON, decimalFormat.format(this.mPoiLocation.mLon));
            hashMap.put(PARAM_KEY_LAT, decimalFormat.format(this.mPoiLocation.mLat));
        }
        hashMap.put("radius", Integer.valueOf(getRadius()));
        hashMap.put("search", getSearch());
        hashMap.put("order", getOrder());
        hashMap.put(PARAM_KEY_DETAIL, Boolean.valueOf(isDetail()));
        hashMap.put(PARAM_KEY_INDEX, Integer.valueOf(getIndex()));
        hashMap.put("size", Integer.valueOf(getSize()));
        return hashMap;
    }

    public Map<String, Object> toAlongWayParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("vin", RootUtil.getVin());
        if (this.mPoiLocation != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00000");
            hashMap.put(PARAM_KEY_LON, decimalFormat.format(this.mPoiLocation.mLon));
            hashMap.put(PARAM_KEY_LAT, decimalFormat.format(this.mPoiLocation.mLat));
        }
        hashMap.put("radius", Integer.valueOf(getRadius()));
        hashMap.put("search", getSearch());
        hashMap.put(PARAM_KEY_DETAIL, Boolean.valueOf(isDetail()));
        hashMap.put(PARAM_KEY_INDEX, Integer.valueOf(getIndex()));
        hashMap.put("size", Integer.valueOf(getSize()));
        hashMap.put("path", getPath());
        return hashMap;
    }

    public Map<String, Object> toAreaParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("vin", RootUtil.getVin());
        if (this.mPoiLocation != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00000");
            hashMap.put(PARAM_KEY_LON, decimalFormat.format(this.mPoiLocation.mLon));
            hashMap.put(PARAM_KEY_LAT, decimalFormat.format(this.mPoiLocation.mLat));
        }
        hashMap.put("search", getSearch());
        hashMap.put("order", getOrder());
        hashMap.put("citycode", getCityCode());
        hashMap.put(PARAM_KEY_AREACODE, getAreaCode());
        return hashMap;
    }

    public Map<String, Object> toPointParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("vin", RootUtil.getVin());
        hashMap.put(PARAM_KEY_STATIONID, this.mPoiId);
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(PARAM_KEY_DETAIL, Boolean.valueOf(this.mDetail));
        return hashMap;
    }

    public Map<String, Object> toKeywordParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("vin", RootUtil.getVin());
        if (getPoiLocation() != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00000");
            hashMap.put("location", decimalFormat.format(getPoiLocation().mLon) + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + decimalFormat.format(getPoiLocation().mLat));
        }
        hashMap.put("query", getQuery());
        if (getPileType() != 0) {
            hashMap.put(PARAM_KEY_PILE_TYPE, Integer.valueOf(getPileType()));
        }
        if (!TextUtils.isEmpty(getCity())) {
            hashMap.put(PARAM_KEY_CITY, getCity());
        }
        hashMap.put(PARAM_KEY_IS_FREE, Boolean.valueOf(isFree()));
        hashMap.put("radius", Integer.valueOf(getRadius()));
        hashMap.put("order", getOrder());
        hashMap.put(PARAM_KEY_DETAIL, Boolean.valueOf(isDetail()));
        hashMap.put(PARAM_KEY_INDEX, Integer.valueOf(getIndex()));
        hashMap.put("size", Integer.valueOf(getSize()));
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    public Map<String, Object> toRecommendFreqParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("vin", RootUtil.getVin());
        if (this.mPoiLocation != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00000");
            hashMap.put(PARAM_KEY_LNG, decimalFormat.format(this.mPoiLocation.mLon));
            hashMap.put(PARAM_KEY_LAT, decimalFormat.format(this.mPoiLocation.mLat));
        }
        hashMap.put(PARAM_KEY_REMAIN_DIS, Integer.valueOf(this.mRemainDistance));
        hashMap.put(PARAM_KEY_NEED_REQUIRE_DIS, Integer.valueOf(this.mNeedDis));
        if (this.mNeedDis == 1) {
            hashMap.put("strategy", Integer.valueOf(XPCloudRouteStrategy.isLegal(this.mStrategy) ? this.mStrategy : 10));
        }
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(PARAM_KEY_CDUID, RootUtil.getHardwareId());
        return hashMap;
    }

    public Map<String, Object> toRecommendDisFreqParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("vin", RootUtil.getVin());
        if (this.mPoiLocation != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00000");
            hashMap.put(PARAM_KEY_LNG, decimalFormat.format(this.mPoiLocation.mLon));
            hashMap.put(PARAM_KEY_LAT, decimalFormat.format(this.mPoiLocation.mLat));
        }
        hashMap.put(PARAM_KEY_REMAIN_DIS, Integer.valueOf(this.mRemainDistance));
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("strategy", Integer.valueOf(XPCloudRouteStrategy.isLegal(this.mStrategy) ? this.mStrategy : 10));
        hashMap.put(PARAM_KEY_STATIONS, this.mStations);
        return hashMap;
    }

    public Map<String, Object> toChargeParam(int i) {
        if (i == 6) {
            return toRecommendFreqParam();
        }
        if (i == 7) {
            return toRecommendDisFreqParam();
        }
        return null;
    }
}
