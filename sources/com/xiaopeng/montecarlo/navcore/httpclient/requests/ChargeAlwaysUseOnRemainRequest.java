package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.ChargeStationInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.List;
/* loaded from: classes2.dex */
public class ChargeAlwaysUseOnRemainRequest {
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    String mLng;
    @SerializedName(CPSearchParam.PARAM_KEY_REMAIN_DIS)
    int mRemainDis;
    @SerializedName(CPSearchParam.PARAM_KEY_STATIONS)
    List<ChargeStationInfo> mStations;
    @SerializedName("strategy")
    int mStrategy;
    @SerializedName("vin")
    String mVin = RootUtil.getVin();
    @SerializedName("ts")
    long mTs = System.currentTimeMillis();

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeAlwaysUseOnRemainRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeAlwaysUseOnRemainRequest) {
            ChargeAlwaysUseOnRemainRequest chargeAlwaysUseOnRemainRequest = (ChargeAlwaysUseOnRemainRequest) obj;
            if (chargeAlwaysUseOnRemainRequest.canEqual(this) && getStrategy() == chargeAlwaysUseOnRemainRequest.getStrategy() && getRemainDis() == chargeAlwaysUseOnRemainRequest.getRemainDis() && getTs() == chargeAlwaysUseOnRemainRequest.getTs()) {
                String vin = getVin();
                String vin2 = chargeAlwaysUseOnRemainRequest.getVin();
                if (vin != null ? vin.equals(vin2) : vin2 == null) {
                    String lng = getLng();
                    String lng2 = chargeAlwaysUseOnRemainRequest.getLng();
                    if (lng != null ? lng.equals(lng2) : lng2 == null) {
                        String lat = getLat();
                        String lat2 = chargeAlwaysUseOnRemainRequest.getLat();
                        if (lat != null ? lat.equals(lat2) : lat2 == null) {
                            List<ChargeStationInfo> stations = getStations();
                            List<ChargeStationInfo> stations2 = chargeAlwaysUseOnRemainRequest.getStations();
                            return stations != null ? stations.equals(stations2) : stations2 == null;
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
        int strategy = ((getStrategy() + 59) * 59) + getRemainDis();
        long ts = getTs();
        int i = (strategy * 59) + ((int) (ts ^ (ts >>> 32)));
        String vin = getVin();
        int hashCode = (i * 59) + (vin == null ? 43 : vin.hashCode());
        String lng = getLng();
        int hashCode2 = (hashCode * 59) + (lng == null ? 43 : lng.hashCode());
        String lat = getLat();
        int hashCode3 = (hashCode2 * 59) + (lat == null ? 43 : lat.hashCode());
        List<ChargeStationInfo> stations = getStations();
        return (hashCode3 * 59) + (stations != null ? stations.hashCode() : 43);
    }

    public ChargeAlwaysUseOnRemainRequest setLat(String str) {
        this.mLat = str;
        return this;
    }

    public ChargeAlwaysUseOnRemainRequest setLng(String str) {
        this.mLng = str;
        return this;
    }

    public ChargeAlwaysUseOnRemainRequest setRemainDis(int i) {
        this.mRemainDis = i;
        return this;
    }

    public ChargeAlwaysUseOnRemainRequest setStations(List<ChargeStationInfo> list) {
        this.mStations = list;
        return this;
    }

    public ChargeAlwaysUseOnRemainRequest setStrategy(int i) {
        this.mStrategy = i;
        return this;
    }

    public ChargeAlwaysUseOnRemainRequest setTs(long j) {
        this.mTs = j;
        return this;
    }

    public ChargeAlwaysUseOnRemainRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "ChargeAlwaysUseOnRemainRequest(mVin=" + getVin() + ", mLng=" + getLng() + ", mLat=" + getLat() + ", mStrategy=" + getStrategy() + ", mRemainDis=" + getRemainDis() + ", mStations=" + getStations() + ", mTs=" + getTs() + ")";
    }

    public String getVin() {
        return this.mVin;
    }

    public String getLng() {
        return this.mLng;
    }

    public String getLat() {
        return this.mLat;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public int getRemainDis() {
        return this.mRemainDis;
    }

    public List<ChargeStationInfo> getStations() {
        return this.mStations;
    }

    public long getTs() {
        return this.mTs;
    }
}
