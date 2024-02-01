package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.powerdistance.EnergyInfo;
/* loaded from: classes3.dex */
public class DumpEnergyInfo {
    @SerializedName(EnergyInfo.AIRCONDITIONOFFK)
    private String mAirConditionOffK;
    @SerializedName("airConditionOffPV")
    private String mAirConditionOffPV;
    @SerializedName(EnergyInfo.AIRCONDITIONONK)
    private String mAirConditionOnK;
    @SerializedName("airConditionOnPV")
    private String mAirConditionOnPV;
    @SerializedName(EnergyInfo.RANGE)
    private String mRange;

    protected boolean canEqual(Object obj) {
        return obj instanceof DumpEnergyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DumpEnergyInfo) {
            DumpEnergyInfo dumpEnergyInfo = (DumpEnergyInfo) obj;
            if (dumpEnergyInfo.canEqual(this)) {
                String range = getRange();
                String range2 = dumpEnergyInfo.getRange();
                if (range != null ? range.equals(range2) : range2 == null) {
                    String airConditionOnPV = getAirConditionOnPV();
                    String airConditionOnPV2 = dumpEnergyInfo.getAirConditionOnPV();
                    if (airConditionOnPV != null ? airConditionOnPV.equals(airConditionOnPV2) : airConditionOnPV2 == null) {
                        String airConditionOnK = getAirConditionOnK();
                        String airConditionOnK2 = dumpEnergyInfo.getAirConditionOnK();
                        if (airConditionOnK != null ? airConditionOnK.equals(airConditionOnK2) : airConditionOnK2 == null) {
                            String airConditionOffPV = getAirConditionOffPV();
                            String airConditionOffPV2 = dumpEnergyInfo.getAirConditionOffPV();
                            if (airConditionOffPV != null ? airConditionOffPV.equals(airConditionOffPV2) : airConditionOffPV2 == null) {
                                String airConditionOffK = getAirConditionOffK();
                                String airConditionOffK2 = dumpEnergyInfo.getAirConditionOffK();
                                return airConditionOffK != null ? airConditionOffK.equals(airConditionOffK2) : airConditionOffK2 == null;
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
        String range = getRange();
        int hashCode = range == null ? 43 : range.hashCode();
        String airConditionOnPV = getAirConditionOnPV();
        int hashCode2 = ((hashCode + 59) * 59) + (airConditionOnPV == null ? 43 : airConditionOnPV.hashCode());
        String airConditionOnK = getAirConditionOnK();
        int hashCode3 = (hashCode2 * 59) + (airConditionOnK == null ? 43 : airConditionOnK.hashCode());
        String airConditionOffPV = getAirConditionOffPV();
        int hashCode4 = (hashCode3 * 59) + (airConditionOffPV == null ? 43 : airConditionOffPV.hashCode());
        String airConditionOffK = getAirConditionOffK();
        return (hashCode4 * 59) + (airConditionOffK != null ? airConditionOffK.hashCode() : 43);
    }

    public DumpEnergyInfo setAirConditionOffK(String str) {
        this.mAirConditionOffK = str;
        return this;
    }

    public DumpEnergyInfo setAirConditionOffPV(String str) {
        this.mAirConditionOffPV = str;
        return this;
    }

    public DumpEnergyInfo setAirConditionOnK(String str) {
        this.mAirConditionOnK = str;
        return this;
    }

    public DumpEnergyInfo setAirConditionOnPV(String str) {
        this.mAirConditionOnPV = str;
        return this;
    }

    public DumpEnergyInfo setRange(String str) {
        this.mRange = str;
        return this;
    }

    public String toString() {
        return "DumpEnergyInfo(mRange=" + getRange() + ", mAirConditionOnPV=" + getAirConditionOnPV() + ", mAirConditionOnK=" + getAirConditionOnK() + ", mAirConditionOffPV=" + getAirConditionOffPV() + ", mAirConditionOffK=" + getAirConditionOffK() + ")";
    }

    public String getRange() {
        return this.mRange;
    }

    public String getAirConditionOnPV() {
        return this.mAirConditionOnPV;
    }

    public String getAirConditionOnK() {
        return this.mAirConditionOnK;
    }

    public String getAirConditionOffPV() {
        return this.mAirConditionOffPV;
    }

    public String getAirConditionOffK() {
        return this.mAirConditionOffK;
    }
}
