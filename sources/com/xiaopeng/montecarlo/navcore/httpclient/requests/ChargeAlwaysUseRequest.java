package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.root.util.RootUtil;
/* loaded from: classes2.dex */
public class ChargeAlwaysUseRequest {
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    String mLng;
    @SerializedName(CPSearchParam.PARAM_KEY_NEED_REQUIRE_DIS)
    int mNeedDis;
    @SerializedName(CPSearchParam.PARAM_KEY_REMAIN_DIS)
    int mRemainDis;
    @SerializedName("strategy")
    int mStrategy;
    @SerializedName("vin")
    String mVin = RootUtil.getVin();
    @SerializedName(CPSearchParam.PARAM_KEY_CDUID)
    String mCduId = RootUtil.getHardwareId();
    @SerializedName("ts")
    long mTs = System.currentTimeMillis();

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeAlwaysUseRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeAlwaysUseRequest) {
            ChargeAlwaysUseRequest chargeAlwaysUseRequest = (ChargeAlwaysUseRequest) obj;
            if (chargeAlwaysUseRequest.canEqual(this) && getRemainDis() == chargeAlwaysUseRequest.getRemainDis() && getNeedDis() == chargeAlwaysUseRequest.getNeedDis() && getStrategy() == chargeAlwaysUseRequest.getStrategy() && getTs() == chargeAlwaysUseRequest.getTs()) {
                String vin = getVin();
                String vin2 = chargeAlwaysUseRequest.getVin();
                if (vin != null ? vin.equals(vin2) : vin2 == null) {
                    String cduId = getCduId();
                    String cduId2 = chargeAlwaysUseRequest.getCduId();
                    if (cduId != null ? cduId.equals(cduId2) : cduId2 == null) {
                        String lng = getLng();
                        String lng2 = chargeAlwaysUseRequest.getLng();
                        if (lng != null ? lng.equals(lng2) : lng2 == null) {
                            String lat = getLat();
                            String lat2 = chargeAlwaysUseRequest.getLat();
                            return lat != null ? lat.equals(lat2) : lat2 == null;
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
        int remainDis = ((((getRemainDis() + 59) * 59) + getNeedDis()) * 59) + getStrategy();
        long ts = getTs();
        int i = (remainDis * 59) + ((int) (ts ^ (ts >>> 32)));
        String vin = getVin();
        int hashCode = (i * 59) + (vin == null ? 43 : vin.hashCode());
        String cduId = getCduId();
        int hashCode2 = (hashCode * 59) + (cduId == null ? 43 : cduId.hashCode());
        String lng = getLng();
        int hashCode3 = (hashCode2 * 59) + (lng == null ? 43 : lng.hashCode());
        String lat = getLat();
        return (hashCode3 * 59) + (lat != null ? lat.hashCode() : 43);
    }

    public ChargeAlwaysUseRequest setCduId(String str) {
        this.mCduId = str;
        return this;
    }

    public ChargeAlwaysUseRequest setLat(String str) {
        this.mLat = str;
        return this;
    }

    public ChargeAlwaysUseRequest setLng(String str) {
        this.mLng = str;
        return this;
    }

    public ChargeAlwaysUseRequest setNeedDis(int i) {
        this.mNeedDis = i;
        return this;
    }

    public ChargeAlwaysUseRequest setRemainDis(int i) {
        this.mRemainDis = i;
        return this;
    }

    public ChargeAlwaysUseRequest setStrategy(int i) {
        this.mStrategy = i;
        return this;
    }

    public ChargeAlwaysUseRequest setTs(long j) {
        this.mTs = j;
        return this;
    }

    public ChargeAlwaysUseRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "ChargeAlwaysUseRequest(mVin=" + getVin() + ", mCduId=" + getCduId() + ", mLng=" + getLng() + ", mLat=" + getLat() + ", mRemainDis=" + getRemainDis() + ", mNeedDis=" + getNeedDis() + ", mStrategy=" + getStrategy() + ", mTs=" + getTs() + ")";
    }

    public String getVin() {
        return this.mVin;
    }

    public String getCduId() {
        return this.mCduId;
    }

    public String getLng() {
        return this.mLng;
    }

    public String getLat() {
        return this.mLat;
    }

    public int getRemainDis() {
        return this.mRemainDis;
    }

    public int getNeedDis() {
        return this.mNeedDis;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public long getTs() {
        return this.mTs;
    }
}
