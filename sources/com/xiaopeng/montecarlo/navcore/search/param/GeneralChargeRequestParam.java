package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class GeneralChargeRequestParam extends BaseParameter implements Parcelable {
    public static final Parcelable.Creator<GeneralChargeRequestParam> CREATOR = new Parcelable.Creator<GeneralChargeRequestParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeneralChargeRequestParam createFromParcel(Parcel parcel) {
            return new GeneralChargeRequestParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeneralChargeRequestParam[] newArray(int i) {
            return new GeneralChargeRequestParam[i];
        }
    };
    public static final String ORDER_TYPE_DISTANCE = "DISTANCE";
    public static final String ORDER_TYPE_FREE = "FREE ";
    public static final String ORDER_TYPE_SCORE = "SCORE";
    @SerializedName(CPSearchParam.PARAM_KEY_AREACODE)
    @Expose
    private String mAreacode;
    @SerializedName("canUse")
    @Expose
    private int mCanUse;
    private int mChargeType;
    @SerializedName("citycode")
    @Expose
    private String mCitycode;
    @SerializedName(CPSearchParam.PARAM_KEY_DETAIL)
    @Expose
    private boolean mDetail;
    @SerializedName("filterDiscountType")
    private String mFilterDiscountType;
    @SerializedName("filterOperationMode")
    private String mFilterOperationMode;
    @SerializedName(CPSearchParam.PARAM_KEY_INDEX)
    @Expose
    private int mIndex;
    @SerializedName("free")
    @Expose
    private boolean mIsFree;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    @Expose
    private String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    @Expose
    private String mLng;
    @SerializedName("locationType")
    @Expose
    private int mLocationType;
    @SerializedName("order")
    @Expose
    private String mOrder;
    @SerializedName(XPNaviSearchParam.PARAM_PAGE)
    @Expose
    private int mPage;
    @SerializedName("path")
    @Expose
    private String mPath;
    private long mPathId;
    @SerializedName(CPSearchParam.PARAM_KEY_PILE_TYPE)
    @Expose
    private int mPileType;
    @SerializedName("query")
    @Expose
    private String mQuery;
    @SerializedName("radius")
    @Expose
    private int mRadius;
    @SerializedName(CPSearchParam.PARAM_KEY_REMAIN_DIS)
    @Expose
    private int mRemainDis;
    @SerializedName("size")
    @Expose
    private int mSize;
    @SerializedName("stationIds")
    @Expose
    private String mStationIds;
    @SerializedName("ts")
    @Expose
    private long mTs;
    @SerializedName("vin")
    @Expose
    private String mVin;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GeneralChargeRequestParam setAreacode(String str) {
        this.mAreacode = str;
        return this;
    }

    public GeneralChargeRequestParam setCanUse(int i) {
        this.mCanUse = i;
        return this;
    }

    public GeneralChargeRequestParam setChargeType(int i) {
        this.mChargeType = i;
        return this;
    }

    public GeneralChargeRequestParam setCitycode(String str) {
        this.mCitycode = str;
        return this;
    }

    public GeneralChargeRequestParam setDetail(boolean z) {
        this.mDetail = z;
        return this;
    }

    public GeneralChargeRequestParam setFilterDiscountType(String str) {
        this.mFilterDiscountType = str;
        return this;
    }

    public GeneralChargeRequestParam setFilterOperationMode(String str) {
        this.mFilterOperationMode = str;
        return this;
    }

    public GeneralChargeRequestParam setFree(boolean z) {
        this.mIsFree = z;
        return this;
    }

    public GeneralChargeRequestParam setIndex(int i) {
        this.mIndex = i;
        return this;
    }

    public GeneralChargeRequestParam setLocationType(int i) {
        this.mLocationType = i;
        return this;
    }

    public GeneralChargeRequestParam setOrder(String str) {
        this.mOrder = str;
        return this;
    }

    public GeneralChargeRequestParam setPage(int i) {
        this.mPage = i;
        return this;
    }

    public GeneralChargeRequestParam setPath(String str) {
        this.mPath = str;
        return this;
    }

    public GeneralChargeRequestParam setPathId(long j) {
        this.mPathId = j;
        return this;
    }

    public GeneralChargeRequestParam setPileType(int i) {
        this.mPileType = i;
        return this;
    }

    public GeneralChargeRequestParam setQuery(String str) {
        this.mQuery = str;
        return this;
    }

    public GeneralChargeRequestParam setRadius(int i) {
        this.mRadius = i;
        return this;
    }

    public GeneralChargeRequestParam setRemainDis(int i) {
        this.mRemainDis = i;
        return this;
    }

    public GeneralChargeRequestParam setSize(int i) {
        this.mSize = i;
        return this;
    }

    public GeneralChargeRequestParam setStationIds(String str) {
        this.mStationIds = str;
        return this;
    }

    public GeneralChargeRequestParam setTs(long j) {
        this.mTs = j;
        return this;
    }

    public GeneralChargeRequestParam setVin(String str) {
        this.mVin = str;
        return this;
    }

    public boolean isFree() {
        return this.mIsFree;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public int getRemainDis() {
        return this.mRemainDis;
    }

    public int getPileType() {
        return this.mPileType;
    }

    public int getCanUse() {
        return this.mCanUse;
    }

    public int getLocationType() {
        return this.mLocationType;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getSize() {
        return this.mSize;
    }

    public int getPage() {
        return this.mPage;
    }

    public long getTs() {
        return this.mTs;
    }

    public String getVin() {
        return this.mVin;
    }

    public boolean isDetail() {
        return this.mDetail;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String getStationIds() {
        return this.mStationIds;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getLng() {
        return this.mLng;
    }

    public String getLat() {
        return this.mLat;
    }

    public String getCitycode() {
        return this.mCitycode;
    }

    public String getAreacode() {
        return this.mAreacode;
    }

    public String getOrder() {
        return this.mOrder;
    }

    public String getFilterOperationMode() {
        return this.mFilterOperationMode;
    }

    public String getFilterDiscountType() {
        return this.mFilterDiscountType;
    }

    public long getPathId() {
        return this.mPathId;
    }

    public int getChargeType() {
        return this.mChargeType;
    }

    public GeneralChargeRequestParam() {
        this.mSize = 50;
        this.mPage = 1;
        this.mVin = RootUtil.getVin();
        this.mTs = System.currentTimeMillis();
    }

    public GeneralChargeRequestParam setLng(double d) {
        this.mLng = new DecimalFormat("#.000000").format(d);
        return this;
    }

    public GeneralChargeRequestParam setLat(double d) {
        this.mLat = new DecimalFormat("#.000000").format(d);
        return this;
    }

    public void nextPage() {
        this.mIndex += this.mSize;
        this.mPage++;
    }

    public void updateTs() {
        this.mTs = System.currentTimeMillis();
    }

    public void obtainPath() {
        StringBuilder sb = new StringBuilder();
        List<XPCoordinate2DDouble> currentRoutePoints = TBTManager.getInstance().getCurrentRoutePoints();
        if (CollectionUtils.isNotEmpty(currentRoutePoints)) {
            DecimalFormat decimalFormat = new DecimalFormat("#.000000");
            int size = currentRoutePoints.size() < 16 ? currentRoutePoints.size() : 16;
            for (int i = 0; i < size; i++) {
                sb.append(decimalFormat.format(currentRoutePoints.get(i).mLon));
                sb.append(",");
                sb.append(decimalFormat.format(currentRoutePoints.get(i).mLat));
                sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            }
            XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
            if (endInfo != null && endInfo.getDisplayLon() > 0.0d && endInfo.getDisplayLat() > 0.0d) {
                sb.append(decimalFormat.format(endInfo.getDisplayLon()));
                sb.append(",");
                sb.append(decimalFormat.format(endInfo.getDisplayLat()));
                sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            }
            this.mPath = sb.toString();
        }
    }

    public List<String> parsePath() {
        String[] split;
        if (TextUtils.isEmpty(this.mPath)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.mPath.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR)) {
            if (str.split(",").length == 2) {
                arrayList.add(split[0] + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + split[1]);
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mIsFree ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mRadius);
        parcel.writeInt(this.mRemainDis);
        parcel.writeInt(this.mPileType);
        parcel.writeInt(this.mCanUse);
        parcel.writeInt(this.mLocationType);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mSize);
        parcel.writeLong(this.mTs);
        parcel.writeString(this.mVin);
        parcel.writeByte(this.mDetail ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mQuery);
        parcel.writeString(this.mStationIds);
        parcel.writeString(this.mPath);
        parcel.writeString(this.mLng);
        parcel.writeString(this.mLat);
        parcel.writeString(this.mCitycode);
        parcel.writeString(this.mAreacode);
        parcel.writeString(this.mOrder);
        parcel.writeLong(this.mPathId);
        parcel.writeInt(this.mChargeType);
    }

    protected GeneralChargeRequestParam(Parcel parcel) {
        this.mSize = 50;
        this.mPage = 1;
        this.mIsFree = parcel.readByte() != 0;
        this.mRadius = parcel.readInt();
        this.mRemainDis = parcel.readInt();
        this.mPileType = parcel.readInt();
        this.mCanUse = parcel.readInt();
        this.mLocationType = parcel.readInt();
        this.mIndex = parcel.readInt();
        this.mSize = parcel.readInt();
        this.mTs = parcel.readLong();
        this.mVin = parcel.readString();
        this.mDetail = parcel.readByte() != 0;
        this.mQuery = parcel.readString();
        this.mStationIds = parcel.readString();
        this.mPath = parcel.readString();
        this.mLng = parcel.readString();
        this.mLat = parcel.readString();
        this.mCitycode = parcel.readString();
        this.mAreacode = parcel.readString();
        this.mOrder = parcel.readString();
        this.mPathId = parcel.readLong();
        this.mChargeType = parcel.readInt();
    }
}
