package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class NaviGetVehicleInfoResponse {
    @SerializedName("plateNo")
    private String mPlateNo;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviGetVehicleInfoResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviGetVehicleInfoResponse) {
            NaviGetVehicleInfoResponse naviGetVehicleInfoResponse = (NaviGetVehicleInfoResponse) obj;
            if (naviGetVehicleInfoResponse.canEqual(this)) {
                String plateNo = getPlateNo();
                String plateNo2 = naviGetVehicleInfoResponse.getPlateNo();
                return plateNo != null ? plateNo.equals(plateNo2) : plateNo2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String plateNo = getPlateNo();
        return 59 + (plateNo == null ? 43 : plateNo.hashCode());
    }

    public NaviGetVehicleInfoResponse setPlateNo(String str) {
        this.mPlateNo = str;
        return this;
    }

    public String toString() {
        return "NaviGetVehicleInfoResponse(mPlateNo=" + getPlateNo() + ")";
    }

    public String getPlateNo() {
        return this.mPlateNo;
    }
}
