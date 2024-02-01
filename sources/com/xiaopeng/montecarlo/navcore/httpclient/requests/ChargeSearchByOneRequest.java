package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.root.util.RootUtil;
/* loaded from: classes3.dex */
public class ChargeSearchByOneRequest {
    @SerializedName(CPSearchParam.PARAM_KEY_AREACODE)
    private String mAreacode;
    @SerializedName("canUse")
    private int mCanUse;
    @SerializedName("citycode")
    private String mCitycode;
    @SerializedName(CPSearchParam.PARAM_KEY_DETAIL)
    private boolean mDetail;
    @SerializedName(CPSearchParam.PARAM_KEY_INDEX)
    private int mIndex;
    @SerializedName("free")
    private boolean mIsFree;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    private String mLng;
    @SerializedName("locationType")
    private int mLocationType;
    @SerializedName("order")
    private String mOrder;
    @SerializedName("path")
    private String mPath;
    @SerializedName(CPSearchParam.PARAM_KEY_PILE_TYPE)
    private int mPileType;
    @SerializedName("query")
    private String mQuery;
    @SerializedName("radius")
    private int mRadius;
    @SerializedName(CPSearchParam.PARAM_KEY_REMAIN_DIS)
    private int mRemainDis;
    @SerializedName("stationIds")
    private String mStationIds;
    @SerializedName("size")
    private int mSize = 50;
    @SerializedName("ts")
    private long mTs = System.currentTimeMillis();
    @SerializedName("vin")
    private String mVin = RootUtil.getVin();

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeSearchByOneRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeSearchByOneRequest) {
            ChargeSearchByOneRequest chargeSearchByOneRequest = (ChargeSearchByOneRequest) obj;
            if (chargeSearchByOneRequest.canEqual(this) && isFree() == chargeSearchByOneRequest.isFree() && getRadius() == chargeSearchByOneRequest.getRadius() && getRemainDis() == chargeSearchByOneRequest.getRemainDis() && getPileType() == chargeSearchByOneRequest.getPileType() && getCanUse() == chargeSearchByOneRequest.getCanUse() && getLocationType() == chargeSearchByOneRequest.getLocationType() && getIndex() == chargeSearchByOneRequest.getIndex() && getSize() == chargeSearchByOneRequest.getSize() && getTs() == chargeSearchByOneRequest.getTs() && isDetail() == chargeSearchByOneRequest.isDetail()) {
                String vin = getVin();
                String vin2 = chargeSearchByOneRequest.getVin();
                if (vin != null ? vin.equals(vin2) : vin2 == null) {
                    String query = getQuery();
                    String query2 = chargeSearchByOneRequest.getQuery();
                    if (query != null ? query.equals(query2) : query2 == null) {
                        String stationIds = getStationIds();
                        String stationIds2 = chargeSearchByOneRequest.getStationIds();
                        if (stationIds != null ? stationIds.equals(stationIds2) : stationIds2 == null) {
                            String path = getPath();
                            String path2 = chargeSearchByOneRequest.getPath();
                            if (path != null ? path.equals(path2) : path2 == null) {
                                String lng = getLng();
                                String lng2 = chargeSearchByOneRequest.getLng();
                                if (lng != null ? lng.equals(lng2) : lng2 == null) {
                                    String lat = getLat();
                                    String lat2 = chargeSearchByOneRequest.getLat();
                                    if (lat != null ? lat.equals(lat2) : lat2 == null) {
                                        String citycode = getCitycode();
                                        String citycode2 = chargeSearchByOneRequest.getCitycode();
                                        if (citycode != null ? citycode.equals(citycode2) : citycode2 == null) {
                                            String areacode = getAreacode();
                                            String areacode2 = chargeSearchByOneRequest.getAreacode();
                                            if (areacode != null ? areacode.equals(areacode2) : areacode2 == null) {
                                                String order = getOrder();
                                                String order2 = chargeSearchByOneRequest.getOrder();
                                                return order != null ? order.equals(order2) : order2 == null;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int radius = (((((((((((((((isFree() ? 79 : 97) + 59) * 59) + getRadius()) * 59) + getRemainDis()) * 59) + getPileType()) * 59) + getCanUse()) * 59) + getLocationType()) * 59) + getIndex()) * 59) + getSize();
        long ts = getTs();
        int i = (((radius * 59) + ((int) (ts ^ (ts >>> 32)))) * 59) + (isDetail() ? 79 : 97);
        String vin = getVin();
        int hashCode = (i * 59) + (vin == null ? 43 : vin.hashCode());
        String query = getQuery();
        int hashCode2 = (hashCode * 59) + (query == null ? 43 : query.hashCode());
        String stationIds = getStationIds();
        int hashCode3 = (hashCode2 * 59) + (stationIds == null ? 43 : stationIds.hashCode());
        String path = getPath();
        int hashCode4 = (hashCode3 * 59) + (path == null ? 43 : path.hashCode());
        String lng = getLng();
        int hashCode5 = (hashCode4 * 59) + (lng == null ? 43 : lng.hashCode());
        String lat = getLat();
        int hashCode6 = (hashCode5 * 59) + (lat == null ? 43 : lat.hashCode());
        String citycode = getCitycode();
        int hashCode7 = (hashCode6 * 59) + (citycode == null ? 43 : citycode.hashCode());
        String areacode = getAreacode();
        int hashCode8 = (hashCode7 * 59) + (areacode == null ? 43 : areacode.hashCode());
        String order = getOrder();
        return (hashCode8 * 59) + (order != null ? order.hashCode() : 43);
    }

    public ChargeSearchByOneRequest setAreacode(String str) {
        this.mAreacode = str;
        return this;
    }

    public ChargeSearchByOneRequest setCanUse(int i) {
        this.mCanUse = i;
        return this;
    }

    public ChargeSearchByOneRequest setCitycode(String str) {
        this.mCitycode = str;
        return this;
    }

    public ChargeSearchByOneRequest setDetail(boolean z) {
        this.mDetail = z;
        return this;
    }

    public ChargeSearchByOneRequest setFree(boolean z) {
        this.mIsFree = z;
        return this;
    }

    public ChargeSearchByOneRequest setIndex(int i) {
        this.mIndex = i;
        return this;
    }

    public ChargeSearchByOneRequest setLat(String str) {
        this.mLat = str;
        return this;
    }

    public ChargeSearchByOneRequest setLng(String str) {
        this.mLng = str;
        return this;
    }

    public ChargeSearchByOneRequest setLocationType(int i) {
        this.mLocationType = i;
        return this;
    }

    public ChargeSearchByOneRequest setOrder(String str) {
        this.mOrder = str;
        return this;
    }

    public ChargeSearchByOneRequest setPath(String str) {
        this.mPath = str;
        return this;
    }

    public ChargeSearchByOneRequest setPileType(int i) {
        this.mPileType = i;
        return this;
    }

    public ChargeSearchByOneRequest setQuery(String str) {
        this.mQuery = str;
        return this;
    }

    public ChargeSearchByOneRequest setRadius(int i) {
        this.mRadius = i;
        return this;
    }

    public ChargeSearchByOneRequest setRemainDis(int i) {
        this.mRemainDis = i;
        return this;
    }

    public ChargeSearchByOneRequest setSize(int i) {
        this.mSize = i;
        return this;
    }

    public ChargeSearchByOneRequest setStationIds(String str) {
        this.mStationIds = str;
        return this;
    }

    public ChargeSearchByOneRequest setTs(long j) {
        this.mTs = j;
        return this;
    }

    public ChargeSearchByOneRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "ChargeSearchByOneRequest(mIsFree=" + isFree() + ", mRadius=" + getRadius() + ", mRemainDis=" + getRemainDis() + ", mPileType=" + getPileType() + ", mCanUse=" + getCanUse() + ", mLocationType=" + getLocationType() + ", mIndex=" + getIndex() + ", mSize=" + getSize() + ", mTs=" + getTs() + ", mVin=" + getVin() + ", mDetail=" + isDetail() + ", mQuery=" + getQuery() + ", mStationIds=" + getStationIds() + ", mPath=" + getPath() + ", mLng=" + getLng() + ", mLat=" + getLat() + ", mCitycode=" + getCitycode() + ", mAreacode=" + getAreacode() + ", mOrder=" + getOrder() + ")";
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
}
