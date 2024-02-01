package com.xiaopeng.montecarlo.navcore.bean.search;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.search.model.SearchDistrict;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiLocation;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class XPPoiInfo implements Parcelable, Serializable {
    private static final String AI_PUSH_POI_ID_HEADER = "ai_push_";
    private static final String BL_SUPPLE_POI_ID_HEADER = "bl_supple_";
    private static final String CLOUD_ROUTE_POI_ID_HEADER = "cloud_route_";
    private static final String KEYWORD_POI_ID_HEADER = "keyword_";
    private static final String NULL_STRING = "null";
    public static final int POI_SOURCE_AI_PUSH = 4;
    public static final int POI_SOURCE_BL = 1;
    public static final int POI_SOURCE_CLOUD_ROUTE = 5;
    public static final int POI_SOURCE_RGC = 2;
    public static final int POI_SOURCE_THIRD_PARTY = 6;
    public static final int POI_SOURCE_UNKONWN = -1;
    public static final int POI_SOURCE_XP_CAR_WASH = 7;
    public static final int POI_SOURCE_XP_CHARGE = 3;
    public static final int POI_SOURCE_XP_FOOD = 9;
    public static final int POI_SOURCE_XP_PRIVATE = 8;
    public static final int POI_SOURCE_XP_SCRATCH_SPOT = 11;
    public static final int POI_SOURCE_XP_SERVER_CENTER = 10;
    public static final int POI_SOURCE_XP_VPA = 1;
    private static final String RGC_POI_ID_HEADER = "rgc_";
    private static final String THIRD_PARTY_POI_ID_HEADER = "third_party_";
    public static final int TRAVEL_POINT_TYPE_DELETE = 99;
    public static final int TRAVEL_POINT_TYPE_GPS = 0;
    public static final int TRAVEL_POINT_TYPE_POI = 2;
    public static final int TRAVEL_POINT_TYPE_RGC = 1;
    private static final String UNEXPECTED_POI_ID_HEADER = "unexpect_";
    private static final long serialVersionUID = 1050811255724729006L;
    @SerializedName("mAdCode")
    private int mAdCode;
    @SerializedName("mAddress")
    private String mAddress;
    @SerializedName("mAngel")
    private String mAngel;
    @SerializedName("mBlCategory")
    private String mBlCategory;
    private String mBlFavoriteItemId;
    @SerializedName("mCategory")
    private int mCategory;
    @SerializedName("mChild")
    private ArrayList<XPPoiInfo> mChild;
    @SerializedName("mCityCode")
    private String mCityCode;
    @SerializedName("mCityName")
    private String mCityName;
    @SerializedName("mDistance")
    private double mDistance;
    @SerializedName("mDistrictName")
    private String mDistrictName;
    @Nullable
    @SerializedName("mEnters")
    private ArrayList<XPCoordinate2DDouble> mEnters;
    @SerializedName("mEvaluationCount")
    private int mEvaluationCount;
    @Nullable
    @SerializedName("mExits")
    private ArrayList<XPCoordinate2DDouble> mExits;
    @SerializedName("mFloorName")
    private String mFloorName;
    @SerializedName("mHasPark")
    private boolean mHasPark;
    @SerializedName("mIconType")
    private String mIconType;
    @SerializedName("mIconUrl")
    private String mIconUrl;
    @SerializedName("mImageUrlList")
    private List<String> mImageUrlList;
    @SerializedName("mIsFreeParking")
    private boolean mIsFreeParking;
    @SerializedName("mIsOffline")
    private boolean mIsOffline;
    @SerializedName("mKey")
    private String mKey;
    @SerializedName("mLat")
    private double mLat;
    @SerializedName("mLon")
    private double mLon;
    @SerializedName("mName")
    private String mName;
    @SerializedName("mNaviLat")
    private double mNaviLat;
    @SerializedName("mNaviLon")
    private double mNaviLon;
    @SerializedName("mOpenTime")
    private String mOpenTime;
    @SerializedName("mOverhead")
    private short mOverhead;
    @SerializedName("mParentID")
    private String mParentID;
    @SerializedName("mParentName")
    private String mParentName;
    @SerializedName("mParentRel")
    private String mParentRel;
    @SerializedName("mParentSimpleName")
    private String mParentSimpleName;
    @SerializedName("mPark")
    private ArrayList<XPPoiInfo> mPark;
    @SerializedName("mParkRemain")
    private int mParkRemain;
    @SerializedName("mParkTotal")
    private int mParkTotal;
    @SerializedName("mPoiId")
    private String mPoiId;
    @Nullable
    @SerializedName("mPoiPolygonBounds")
    private ArrayList<XPCoordinate2DDouble> mPoiPolygonBounds;
    @SerializedName("mPoiSource")
    private int mPoiSource;
    @SerializedName("mPoints")
    private int[] mPoints;
    @SerializedName("mPrice")
    private String mPrice;
    @SerializedName("mProvinceName")
    private String mProvinceName;
    @SerializedName("mRating")
    private float mRating;
    @SerializedName("mRenderRank")
    private String mRenderRank;
    @SerializedName("mReserveA")
    private String mReserveA;
    @SerializedName("mReserveB")
    private String mReserveB;
    @SerializedName("mReserveC")
    private String mReserveC;
    @SerializedName("mRoadId")
    private long mRoadId;
    @SerializedName("mRoadInfo")
    private String mRoadInfo;
    @SerializedName("mSigshelter")
    private float mSigshelter;
    @SerializedName("mTag")
    private String mTag;
    @SerializedName("mTel")
    private String mTel;
    @SerializedName("mType")
    private int mType;
    @SerializedName("mTypeCode")
    @Deprecated
    private String mTypeCode;
    @SerializedName("mVisitCount")
    private int mVisitCount;
    @SerializedName("mXPCarServiceInfo")
    private XPCarServiceInfo mXPCarServiceInfo;
    @SerializedName("mXPDeepInfoPoi")
    private XPDeepInfoPoi mXPDeepInfoPoi;
    public static final Parcelable.Creator<XPPoiInfo> CREATOR = new Parcelable.Creator<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPPoiInfo createFromParcel(@NonNull Parcel parcel) {
            return new XPPoiInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPPoiInfo[] newArray(int i) {
            return new XPPoiInfo[i];
        }
    };
    private static final L.Tag TAG = new L.Tag("XPPoiInfo");

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PoiSource {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TravelPointType {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setNaviLon(double d) {
        this.mNaviLon = d;
    }

    public double getNaviLon() {
        return this.mNaviLon;
    }

    public void setNaviLat(double d) {
        this.mNaviLat = d;
    }

    public double getNaviLat() {
        return this.mNaviLat;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setCategory(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setOpenTime(String str) {
        this.mOpenTime = str;
    }

    public String getOpenTime() {
        return this.mOpenTime;
    }

    public void setParkTotal(int i) {
        this.mParkTotal = i;
    }

    public int getParkTotal() {
        return this.mParkTotal;
    }

    public void setParkRemain(int i) {
        this.mParkRemain = i;
    }

    public int getParkRemain() {
        return this.mParkRemain;
    }

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setSigshelter(float f) {
        this.mSigshelter = f;
    }

    public float getSigshelter() {
        return this.mSigshelter;
    }

    public void setCityName(String str) {
        this.mCityName = str;
    }

    public String getCityName() {
        return this.mCityName;
    }

    public void setCityCode(String str) {
        this.mCityCode = str;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public void setAdCode(int i) {
        this.mAdCode = i;
    }

    public int getAdCode() {
        return this.mAdCode;
    }

    public void setProvinceName(String str) {
        this.mProvinceName = str;
    }

    public String getProvinceName() {
        return this.mProvinceName;
    }

    public void setDistrictName(String str) {
        this.mDistrictName = str;
    }

    public String getDistrictName() {
        return this.mDistrictName;
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

    public void setRenderRank(String str) {
        this.mRenderRank = str;
    }

    public String getRenderRank() {
        return this.mRenderRank;
    }

    public void setRating(float f) {
        this.mRating = f;
    }

    public float getRating() {
        return this.mRating;
    }

    public void setTel(String str) {
        this.mTel = str;
    }

    public String getTel() {
        return this.mTel;
    }

    public void setDistance(double d) {
        this.mDistance = d;
    }

    public double getDistance() {
        return this.mDistance;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public String getKey() {
        return this.mKey;
    }

    public void setRoadId(long j) {
        this.mRoadId = j;
    }

    public long getRoadId() {
        return this.mRoadId;
    }

    public void setFloorName(String str) {
        this.mFloorName = str;
    }

    public String getFloorName() {
        return this.mFloorName;
    }

    public void setParentID(String str) {
        this.mParentID = str;
    }

    public String getParentID() {
        return this.mParentID;
    }

    public void setParentName(String str) {
        this.mParentName = str;
    }

    public String getParentName() {
        return this.mParentName;
    }

    public void setParentSimpleName(String str) {
        this.mParentSimpleName = str;
    }

    public String getParentSimpleName() {
        return this.mParentSimpleName;
    }

    public void setAngel(String str) {
        this.mAngel = str;
    }

    public String getAngel() {
        return this.mAngel;
    }

    public void setParentRel(String str) {
        this.mParentRel = str;
    }

    public String getParentRel() {
        return this.mParentRel;
    }

    public void setOverhead(short s) {
        this.mOverhead = s;
    }

    public short getOverhead() {
        return this.mOverhead;
    }

    public void setPoints(int[] iArr) {
        this.mPoints = iArr;
    }

    public int[] getPoints() {
        return this.mPoints;
    }

    public void setChild(ArrayList<XPPoiInfo> arrayList) {
        this.mChild = arrayList;
    }

    public ArrayList<XPPoiInfo> getChild() {
        return this.mChild;
    }

    public void setPark(ArrayList<XPPoiInfo> arrayList) {
        this.mPark = arrayList;
    }

    public ArrayList<XPPoiInfo> getPark() {
        return this.mPark;
    }

    public void setHasPark(boolean z) {
        this.mHasPark = z;
    }

    public boolean isHasPark() {
        return this.mHasPark;
    }

    public void setOffline(boolean z) {
        this.mIsOffline = z;
    }

    public boolean isOffline() {
        return this.mIsOffline;
    }

    public void setXPDeepInfoPoi(XPDeepInfoPoi xPDeepInfoPoi) {
        this.mXPDeepInfoPoi = xPDeepInfoPoi;
    }

    public XPDeepInfoPoi getXPDeepInfoPoi() {
        return this.mXPDeepInfoPoi;
    }

    public void setRoadInfo(String str) {
        this.mRoadInfo = str;
    }

    public String getRoadInfo() {
        return this.mRoadInfo;
    }

    public void setImageUrlList(List<String> list) {
        this.mImageUrlList = list;
    }

    public List<String> getImageUrlList() {
        return this.mImageUrlList;
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

    public void setVisitCount(int i) {
        this.mVisitCount = i;
    }

    public int getVisitCount() {
        return this.mVisitCount;
    }

    public void setEvaluationCount(int i) {
        this.mEvaluationCount = i;
    }

    public int getEvaluationCount() {
        return this.mEvaluationCount;
    }

    public void setXPCarServiceInfo(XPCarServiceInfo xPCarServiceInfo) {
        this.mXPCarServiceInfo = xPCarServiceInfo;
    }

    public XPCarServiceInfo getXPCarServiceInfo() {
        return this.mXPCarServiceInfo;
    }

    public void setBlFavoriteItemId(String str) {
        this.mBlFavoriteItemId = str;
    }

    public String getBlFavoriteItemId() {
        return this.mBlFavoriteItemId;
    }

    public void setFreeParking(boolean z) {
        this.mIsFreeParking = z;
    }

    public boolean isFreeParking() {
        return this.mIsFreeParking;
    }

    public XPPoiInfo() {
        this.mType = 2;
        this.mParkTotal = -1;
        this.mParkRemain = -1;
        this.mPoiSource = 1;
    }

    public XPPoiInfo(POIInfo pOIInfo) {
        this.mType = 2;
        this.mParkTotal = -1;
        this.mParkRemain = -1;
        this.mPoiSource = 1;
        Coord2DDouble coord2DDouble = pOIInfo.realPos;
        if (coord2DDouble != null) {
            this.mLat = coord2DDouble.lat;
            this.mLon = coord2DDouble.lon;
        } else {
            this.mLat = 0.0d;
            this.mLon = 0.0d;
        }
        this.mAngel = pOIInfo.angel;
        this.mFloorName = pOIInfo.floorName;
        this.mName = pOIInfo.name;
        Coord2DDouble coord2DDouble2 = pOIInfo.naviPos;
        if (coord2DDouble2 != null) {
            this.mNaviLat = coord2DDouble2.lat;
            this.mNaviLon = coord2DDouble2.lon;
        } else {
            this.mNaviLat = 0.0d;
            this.mNaviLon = 0.0d;
        }
        this.mOverhead = pOIInfo.overhead;
        this.mParentID = pOIInfo.parentID;
        this.mParentName = pOIInfo.parentName;
        this.mParentRel = pOIInfo.parentRel;
        this.mParentSimpleName = pOIInfo.parentSimpleName;
        this.mPoiId = pOIInfo.poiID == null ? "" : pOIInfo.poiID;
        this.mRoadId = pOIInfo.roadID;
        this.mSigshelter = pOIInfo.sigshelter;
        this.mType = pOIInfo.type;
        this.mTypeCode = pOIInfo.typeCode;
    }

    public XPPoiInfo(SearchDistrict searchDistrict) {
        this.mType = 2;
        this.mParkTotal = -1;
        this.mParkRemain = -1;
        this.mPoiSource = 1;
        this.mAdCode = searchDistrict.adcode;
        this.mAddress = searchDistrict.address;
        this.mName = searchDistrict.name;
        if (searchDistrict.poi_loc != null) {
            this.mLat = searchDistrict.poi_loc.lat;
            this.mLon = searchDistrict.poi_loc.lon;
        } else {
            this.mLat = 0.0d;
            this.mLon = 0.0d;
        }
        this.mCityName = searchDistrict.name;
        this.mCityCode = "" + searchDistrict.adcode;
    }

    public XPPoiInfo(PoiBean poiBean) {
        this.mType = 2;
        this.mParkTotal = -1;
        this.mParkRemain = -1;
        this.mPoiSource = 1;
        if (poiBean == null) {
            L.w(TAG, "poiBean is null");
            return;
        }
        if (!NULL_STRING.equals(poiBean.getAddress())) {
            this.mAddress = poiBean.getAddress();
        }
        if (!NULL_STRING.equals(poiBean.getCityName())) {
            this.mCityName = poiBean.getCityName();
        }
        this.mDistance = poiBean.getDistance();
        this.mLat = poiBean.getLatitude();
        this.mLon = poiBean.getLongitude();
        this.mName = !TextUtils.isEmpty(poiBean.getDstName()) ? poiBean.getDstName() : poiBean.getName();
        if (!NULL_STRING.equals(poiBean.getPoiId())) {
            this.mPoiId = poiBean.getPoiId();
        }
        if (!NULL_STRING.equals(poiBean.getTelephone())) {
            this.mTel = poiBean.getTelephone();
        }
        String typeCode = poiBean.getTypeCode();
        this.mTypeCode = typeCode;
        int category = poiBean.getCategory();
        if (category > 0) {
            this.mCategory = category;
        } else if (!RootUtil.isEmptyString(typeCode)) {
            this.mCategory = XPPoiCategory.transformCategory(typeCode);
        } else {
            this.mCategory = 100;
        }
        String source = poiBean.getSource();
        if (!TextUtils.isEmpty(source) && (NaviModel.POI_SOURCE_AICLOUD_AMAP.equals(source) || NaviModel.POI_SOURCE_BLSDK.equals(source))) {
            this.mBlCategory = typeCode;
        }
        PoiLocation entrLocation = poiBean.getEntrLocation();
        if (entrLocation != null) {
            this.mEnters = new ArrayList<>(1);
            this.mEnters.add(new XPCoordinate2DDouble(entrLocation.getLongitude(), entrLocation.getLatitude()));
        }
        PoiLocation exitLocation = poiBean.getExitLocation();
        if (exitLocation != null) {
            this.mExits = new ArrayList<>();
            this.mExits.add(0, new XPCoordinate2DDouble(exitLocation.getLongitude(), exitLocation.getLatitude()));
        }
        this.mNaviLat = poiBean.getNaviLat();
        this.mNaviLon = poiBean.getNaviLon();
        generatePoiIdIfEmpty(this, 5);
    }

    protected XPPoiInfo(Parcel parcel) {
        this.mType = 2;
        this.mParkTotal = -1;
        this.mParkRemain = -1;
        this.mPoiSource = 1;
        this.mLon = parcel.readDouble();
        this.mLat = parcel.readDouble();
        this.mNaviLon = parcel.readDouble();
        this.mNaviLat = parcel.readDouble();
        this.mName = parcel.readString();
        this.mType = parcel.readInt();
        this.mCategory = parcel.readInt();
        this.mBlCategory = parcel.readString();
        this.mTag = parcel.readString();
        this.mOpenTime = parcel.readString();
        this.mParkTotal = parcel.readInt();
        this.mParkRemain = parcel.readInt();
        this.mPrice = parcel.readString();
        this.mSigshelter = parcel.readFloat();
        this.mPoiId = parcel.readString();
        this.mAddress = parcel.readString();
        this.mCityName = parcel.readString();
        this.mCityCode = parcel.readString();
        this.mAdCode = parcel.readInt();
        this.mProvinceName = parcel.readString();
        this.mDistrictName = parcel.readString();
        this.mIconType = parcel.readString();
        this.mIconUrl = parcel.readString();
        this.mRenderRank = parcel.readString();
        this.mTel = parcel.readString();
        this.mDistance = parcel.readDouble();
        this.mKey = parcel.readString();
        this.mRoadId = parcel.readLong();
        this.mFloorName = parcel.readString();
        this.mParentID = parcel.readString();
        this.mParentName = parcel.readString();
        this.mParentSimpleName = parcel.readString();
        this.mAngel = parcel.readString();
        this.mParentRel = parcel.readString();
        this.mTypeCode = parcel.readString();
        this.mOverhead = (short) parcel.readInt();
        this.mPoints = parcel.createIntArray();
        this.mEnters = parcel.createTypedArrayList(XPCoordinate2DDouble.CREATOR);
        this.mExits = parcel.createTypedArrayList(XPCoordinate2DDouble.CREATOR);
        this.mChild = parcel.createTypedArrayList(CREATOR);
        this.mPark = parcel.createTypedArrayList(CREATOR);
        this.mHasPark = parcel.readByte() != 0;
        this.mIsOffline = parcel.readByte() != 0;
        this.mXPDeepInfoPoi = (XPDeepInfoPoi) parcel.readParcelable(XPDeepInfoPoi.class.getClassLoader());
        this.mPoiPolygonBounds = parcel.createTypedArrayList(XPCoordinate2DDouble.CREATOR);
        this.mRoadInfo = parcel.readString();
        this.mPoiSource = parcel.readInt();
        this.mImageUrlList = parcel.createStringArrayList();
        this.mReserveA = parcel.readString();
        this.mReserveB = parcel.readString();
        this.mReserveC = parcel.readString();
        this.mVisitCount = parcel.readInt();
        this.mEvaluationCount = parcel.readInt();
    }

    private static String getDistanceString(@NonNull Context context, double d) {
        if (d >= 1000.0d) {
            double round = ((float) Math.round((d / 1000.0d) * 10.0d)) / 10.0f;
            return d >= 100000.0d ? context.getString(R.string.km100, Integer.valueOf((int) round)) : context.getString(R.string.km, Double.valueOf(round));
        }
        return context.getString(R.string.meters, Integer.valueOf((int) d));
    }

    private static String generateRgcPoiId(XPPoiInfo xPPoiInfo) {
        if (isEmpty(xPPoiInfo)) {
            return RGC_POI_ID_HEADER + NavCoreUtil.generatePoiIdWithInfo(xPPoiInfo);
        }
        return "";
    }

    private static String generateBlSupplePoiId(XPPoiInfo xPPoiInfo) {
        if (isEmpty(xPPoiInfo)) {
            return BL_SUPPLE_POI_ID_HEADER + NavCoreUtil.generatePoiIdWithInfo(xPPoiInfo);
        }
        return "";
    }

    private static String generateUnexpectPoiId(XPPoiInfo xPPoiInfo) {
        if (isEmpty(xPPoiInfo)) {
            return UNEXPECTED_POI_ID_HEADER + NavCoreUtil.generatePoiIdWithInfo(xPPoiInfo);
        }
        return "";
    }

    public static String generateKeywordPoiId(XPPoiInfo xPPoiInfo) {
        if (isEmpty(xPPoiInfo)) {
            return KEYWORD_POI_ID_HEADER + NavCoreUtil.generatePoiIdWithInfo(xPPoiInfo);
        }
        return "";
    }

    private static String generateAiPushPoiId(XPPoiInfo xPPoiInfo) {
        if (isEmpty(xPPoiInfo)) {
            return AI_PUSH_POI_ID_HEADER + NavCoreUtil.generatePoiIdWithInfo(xPPoiInfo);
        }
        return "";
    }

    private static String generateCloudRoutePoiId(XPPoiInfo xPPoiInfo) {
        if (isEmpty(xPPoiInfo)) {
            return CLOUD_ROUTE_POI_ID_HEADER + NavCoreUtil.generatePoiIdWithInfo(xPPoiInfo);
        }
        return "";
    }

    private static String generateThirdPartyPoiId(XPPoiInfo xPPoiInfo) {
        if (isEmpty(xPPoiInfo)) {
            return THIRD_PARTY_POI_ID_HEADER + NavCoreUtil.generatePoiIdWithInfo(xPPoiInfo);
        }
        return "";
    }

    private static boolean isEmpty(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return false;
        }
        return TextUtils.isEmpty(xPPoiInfo.mPoiId) || NULL_STRING.equals(xPPoiInfo.mPoiId);
    }

    public static void generatePoiIdIfEmpty(XPPoiInfo xPPoiInfo, int i) {
        String str;
        if (xPPoiInfo != null) {
            if (i == 1) {
                xPPoiInfo.setPoiSource(1);
                str = generateBlSupplePoiId(xPPoiInfo);
            } else if (i == 5) {
                xPPoiInfo.setPoiSource(5);
                str = generateCloudRoutePoiId(xPPoiInfo);
            } else if (i == 4) {
                xPPoiInfo.setPoiSource(4);
                str = generateAiPushPoiId(xPPoiInfo);
            } else if (i == 2) {
                xPPoiInfo.setPoiSource(2);
                str = generateRgcPoiId(xPPoiInfo);
            } else if (i == 6) {
                xPPoiInfo.setPoiSource(6);
                str = generateThirdPartyPoiId(xPPoiInfo);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            xPPoiInfo.setPoiId(str);
        }
    }

    public boolean matchCustomPoiIdHeader() {
        String poiId = getPoiId();
        if (TextUtils.isEmpty(poiId)) {
            return false;
        }
        return poiId.startsWith(BL_SUPPLE_POI_ID_HEADER) || poiId.startsWith(KEYWORD_POI_ID_HEADER) || poiId.startsWith(UNEXPECTED_POI_ID_HEADER) || poiId.startsWith(AI_PUSH_POI_ID_HEADER) || poiId.startsWith(CLOUD_ROUTE_POI_ID_HEADER) || poiId.startsWith(THIRD_PARTY_POI_ID_HEADER) || poiId.startsWith(RGC_POI_ID_HEADER);
    }

    public XPPoiInfo deepClone() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        XPPoiInfo createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeDouble(this.mLon);
        parcel.writeDouble(this.mLat);
        parcel.writeDouble(this.mNaviLon);
        parcel.writeDouble(this.mNaviLat);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mCategory);
        parcel.writeString(this.mBlCategory);
        parcel.writeString(this.mTag);
        parcel.writeString(this.mOpenTime);
        parcel.writeInt(this.mParkTotal);
        parcel.writeInt(this.mParkRemain);
        parcel.writeString(this.mPrice);
        parcel.writeFloat(this.mSigshelter);
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mCityName);
        parcel.writeString(this.mCityCode);
        parcel.writeInt(this.mAdCode);
        parcel.writeString(this.mProvinceName);
        parcel.writeString(this.mDistrictName);
        parcel.writeString(this.mIconType);
        parcel.writeString(this.mIconUrl);
        parcel.writeString(this.mRenderRank);
        parcel.writeString(this.mTel);
        parcel.writeDouble(this.mDistance);
        parcel.writeString(this.mKey);
        parcel.writeLong(this.mRoadId);
        parcel.writeString(this.mFloorName);
        parcel.writeString(this.mParentID);
        parcel.writeString(this.mParentName);
        parcel.writeString(this.mParentSimpleName);
        parcel.writeString(this.mAngel);
        parcel.writeString(this.mParentRel);
        parcel.writeString(this.mTypeCode);
        parcel.writeInt(this.mOverhead);
        parcel.writeIntArray(this.mPoints);
        parcel.writeTypedList(this.mEnters);
        parcel.writeTypedList(this.mExits);
        parcel.writeTypedList(this.mChild);
        parcel.writeTypedList(this.mPark);
        parcel.writeByte(this.mHasPark ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsOffline ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mXPDeepInfoPoi, i);
        parcel.writeTypedList(this.mPoiPolygonBounds);
        parcel.writeString(this.mRoadInfo);
        parcel.writeInt(this.mPoiSource);
        parcel.writeStringList(this.mImageUrlList);
        parcel.writeString(this.mReserveA);
        parcel.writeString(this.mReserveB);
        parcel.writeString(this.mReserveC);
        parcel.writeInt(this.mVisitCount);
        parcel.writeInt(this.mEvaluationCount);
    }

    public double getDisplayLon() {
        return this.mLon;
    }

    public void setDisplayLon(double d) {
        this.mLon = d;
    }

    public double getDisplayLat() {
        return this.mLat;
    }

    public void setDisplayLat(double d) {
        this.mLat = d;
    }

    public XPCoordinate2DDouble getNaviPoint(boolean z) {
        ArrayList<XPCoordinate2DDouble> arrayList;
        ArrayList<XPCoordinate2DDouble> arrayList2;
        if (hasNaviLatLonInfo()) {
            return new XPCoordinate2DDouble(this.mNaviLon, this.mNaviLat);
        }
        if (!z && (arrayList2 = this.mEnters) != null && arrayList2.size() > 0 && isValidLatLon(this.mEnters.get(0).mLat, this.mEnters.get(0).mLon)) {
            return this.mEnters.get(0);
        }
        if (z && (arrayList = this.mExits) != null && arrayList.size() > 0 && isValidLatLon(this.mExits.get(0).mLat, this.mExits.get(0).mLon)) {
            return this.mExits.get(0);
        }
        return new XPCoordinate2DDouble(this.mLon, this.mLat);
    }

    @NonNull
    public String getBlCategory() {
        String str = this.mBlCategory;
        return str == null ? XPPoiCategory.BL_CATEGORY_INVALID : str;
    }

    public void setBlCategory(String str) {
        this.mBlCategory = str;
    }

    public String getXPCategory() {
        return isXPPoiSource() ? String.valueOf(getCategory()) : getBlCategory();
    }

    public boolean isXPPoiSource() {
        return getPoiSource() == 3 || getPoiSource() == 7;
    }

    public boolean hasParkSpaceInfo() {
        return this.mParkTotal > -1 || this.mParkRemain > -1;
    }

    @NonNull
    public String getPoiId() {
        if (TextUtils.isEmpty(this.mPoiId)) {
            this.mPoiId = generateUnexpectPoiId(this);
        }
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAddress mAddress:" + str);
        }
        this.mAddress = str;
        if (TextUtils.isEmpty(str) || str.indexOf("-") != 0) {
            return;
        }
        this.mAddress = str.substring(1);
    }

    @Deprecated
    public String getTypeCode() {
        return this.mTypeCode;
    }

    @Deprecated
    public void setTypeCode(String str) {
        this.mTypeCode = str;
    }

    @Nullable
    public ArrayList<XPCoordinate2DDouble> getEnters() {
        return this.mEnters;
    }

    public void setEnters(ArrayList<Coord2DDouble> arrayList) {
        this.mEnters = copyCoord2D(arrayList);
    }

    public void setEnter(@NonNull Coord2DDouble coord2DDouble) {
        this.mEnters = new ArrayList<>(1);
        this.mEnters.add(new XPCoordinate2DDouble(coord2DDouble));
    }

    @Nullable
    public ArrayList<XPCoordinate2DDouble> getExits() {
        return this.mExits;
    }

    public void setExits(ArrayList<Coord2DDouble> arrayList) {
        this.mExits = copyCoord2D(arrayList);
    }

    public void setExit(@NonNull Coord2DDouble coord2DDouble) {
        this.mExits = new ArrayList<>(1);
        this.mExits.add(new XPCoordinate2DDouble(coord2DDouble));
    }

    @Nullable
    public Coord2DDouble[] toBLCoord2DArray(@Nullable XPCoordinate2DDouble[] xPCoordinate2DDoubleArr) {
        if (xPCoordinate2DDoubleArr == null || xPCoordinate2DDoubleArr.length <= 0) {
            return null;
        }
        Coord2DDouble[] coord2DDoubleArr = new Coord2DDouble[xPCoordinate2DDoubleArr.length];
        for (int i = 0; i < xPCoordinate2DDoubleArr.length; i++) {
            coord2DDoubleArr[i] = xPCoordinate2DDoubleArr[i].toBLCoord2D();
        }
        return coord2DDoubleArr;
    }

    @Nullable
    public ArrayList<XPCoordinate2DDouble> getPoiPolygonBounds() {
        return this.mPoiPolygonBounds;
    }

    public void setPoiPolygonBounds(@Nullable ArrayList<Coord2DDouble> arrayList) {
        if (arrayList != null) {
            this.mPoiPolygonBounds = new ArrayList<>(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                this.mPoiPolygonBounds.add(new XPCoordinate2DDouble(arrayList.get(i)));
            }
            return;
        }
        this.mPoiPolygonBounds = null;
    }

    public int getPoiSource() {
        return this.mPoiSource;
    }

    public void setPoiSource(int i) {
        if (i != 1) {
            if (i == 2) {
                this.mType = 1;
            } else if (i != 3 && i != 7) {
                L.Tag tag = TAG;
                L.w(tag, "unknown POI source type: " + i);
            }
            this.mPoiSource = i;
        }
        this.mType = 2;
        this.mPoiSource = i;
    }

    @Nullable
    public ArrayList<XPCoordinate2DDouble> copyCoord2D(@Nullable ArrayList<Coord2DDouble> arrayList) {
        if (CollectionUtils.isEmpty(arrayList)) {
            return null;
        }
        ArrayList<XPCoordinate2DDouble> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(new XPCoordinate2DDouble(arrayList.get(i)));
        }
        return arrayList2;
    }

    @NonNull
    public POIInfo toBLPOIInfo(boolean z) {
        POIInfo pOIInfo = new POIInfo();
        pOIInfo.realPos.lat = (float) this.mLat;
        pOIInfo.realPos.lon = (float) this.mLon;
        pOIInfo.angel = this.mAngel;
        pOIInfo.floorName = this.mFloorName;
        pOIInfo.name = this.mName;
        pOIInfo.naviPos.lat = (float) getNaviPoint(z).mLat;
        pOIInfo.naviPos.lon = (float) getNaviPoint(z).mLon;
        pOIInfo.overhead = this.mOverhead;
        pOIInfo.parentID = this.mParentID;
        pOIInfo.parentName = this.mParentName;
        pOIInfo.parentRel = this.mParentRel;
        pOIInfo.parentSimpleName = this.mParentSimpleName;
        XPCarServiceInfo xPCarServiceInfo = this.mXPCarServiceInfo;
        if (xPCarServiceInfo != null && !TextUtils.isEmpty(xPCarServiceInfo.getAutoId())) {
            pOIInfo.poiID = this.mXPCarServiceInfo.getAutoId();
        } else {
            pOIInfo.poiID = this.mPoiId;
        }
        if (!z) {
            if (isCustomPoiId(pOIInfo.poiID)) {
                pOIInfo.poiID = "";
            }
            if (!TextUtils.isEmpty(pOIInfo.poiID)) {
                pOIInfo.type = 2;
            } else {
                pOIInfo.type = 1;
            }
        }
        pOIInfo.roadID = this.mRoadId;
        pOIInfo.sigshelter = this.mSigshelter;
        pOIInfo.typeCode = this.mBlCategory;
        return pOIInfo;
    }

    public boolean isCustomPoiId(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(BL_SUPPLE_POI_ID_HEADER) || str.startsWith(KEYWORD_POI_ID_HEADER) || str.startsWith(UNEXPECTED_POI_ID_HEADER) || str.startsWith(AI_PUSH_POI_ID_HEADER) || str.startsWith(CLOUD_ROUTE_POI_ID_HEADER) || str.startsWith(THIRD_PARTY_POI_ID_HEADER) || str.startsWith(RGC_POI_ID_HEADER);
    }

    public double getDefaultDistanceForDisplay() {
        return getDistance() <= 0.0d ? LocationUtils.getDistanceFromCurrentPos(getNaviPoint(false)) : getDistance();
    }

    public boolean hasDisplayLatLonInfo() {
        return isValidLatLon(this.mLat, this.mLon);
    }

    public boolean hasNaviLatLonInfo() {
        return isValidLatLon(this.mNaviLat, this.mNaviLon);
    }

    private boolean isValidLatLon(double d, double d2) {
        return NavCoreUtil.isValidLatLon(d, d2);
    }

    @NonNull
    public PoiBean toPoiBean(@NonNull Context context, long j) {
        double d = this.mDistance;
        if (((int) d) == 0) {
            this.mDistance = j;
        } else {
            j = (long) d;
        }
        PoiBean poiBean = toPoiBean();
        poiBean.setDisplayDistance(getDistanceString(context, j));
        return poiBean;
    }

    @NonNull
    public PoiBean toPoiBean() {
        PoiBean poiBean = new PoiBean();
        poiBean.setAddress(this.mAddress);
        poiBean.setCityName(this.mCityName);
        poiBean.setDstName(this.mDistrictName);
        poiBean.setLatitude(this.mLat);
        poiBean.setLongitude(this.mLon);
        poiBean.setPoiId(this.mPoiId);
        poiBean.setTelephone(this.mTel);
        poiBean.setName(this.mName);
        poiBean.setCategory(this.mCategory);
        poiBean.setNaviLat(this.mNaviLat);
        poiBean.setNaviLon(this.mNaviLon);
        poiBean.setDistance((long) this.mDistance);
        poiBean.setSource(NaviModel.POI_SOURCE_BLSDK);
        poiBean.setTypeCode(this.mBlCategory);
        PoiLocation poiLocation = new PoiLocation();
        ArrayList<XPCoordinate2DDouble> arrayList = this.mEnters;
        if (arrayList != null && arrayList.size() > 0) {
            poiLocation.setLatitude(this.mEnters.get(0).mLat);
            poiLocation.setLongitude(this.mEnters.get(0).mLon);
        }
        poiBean.setEntrLocation(poiLocation);
        PoiLocation poiLocation2 = new PoiLocation();
        ArrayList<XPCoordinate2DDouble> arrayList2 = this.mExits;
        if (arrayList2 != null && arrayList2.size() > 0) {
            poiLocation2.setLatitude(this.mExits.get(0).mLat);
            poiLocation2.setLongitude(this.mExits.get(0).mLon);
        }
        poiBean.setExitLocation(poiLocation2);
        return poiBean;
    }

    @NonNull
    public XPPoiInfo toRGCPoi() {
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setDisplayLon(getDisplayLon());
        xPPoiInfo.setDisplayLat(getDisplayLat());
        xPPoiInfo.setDistance(getDistance());
        if (!TextUtils.isEmpty(getName())) {
            xPPoiInfo.setName(getName());
        }
        if (!TextUtils.isEmpty(getAddress())) {
            xPPoiInfo.setAddress(getAddress());
        }
        return xPPoiInfo;
    }

    public boolean isKeywordPoiInfo() {
        return TextUtils.isEmpty(this.mPoiId) || this.mPoiId.startsWith(KEYWORD_POI_ID_HEADER);
    }

    @NonNull
    public String toString() {
        String str = this.mPoiId;
        return str == null ? "" : str;
    }

    public String dumpXPPoiInfo() {
        return "poiid = " + this.mPoiId + ", name = " + this.mName + ", address = " + this.mAddress + ", poiSource = " + this.mPoiSource + ", mLon = " + this.mLon + ", mLat = " + this.mLat + ", mImageUrlList = " + this.mImageUrlList;
    }

    public boolean isInAOI() {
        return CollectionUtils.isNotEmpty(getPoiPolygonBounds());
    }

    public boolean isGroupInfo() {
        return XPPoiCategory.isCharge(this.mCategory) && !TextUtils.isEmpty(this.mPoiId) && this.mPoiId.contains(",");
    }

    public boolean isNameAndAddressEmpty() {
        return TextUtils.isEmpty(this.mName) && TextUtils.isEmpty(this.mAddress);
    }
}
