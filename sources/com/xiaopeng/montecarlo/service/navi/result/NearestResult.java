package com.xiaopeng.montecarlo.service.navi.result;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes3.dex */
public class NearestResult {
    @SerializedName("code")
    private String mCode = "-1";
    @SerializedName("address")
    private String mAddress = "null";
    @SerializedName("province")
    private String mProvince = "null";
    @SerializedName(CPSearchParam.PARAM_KEY_CITY)
    private String mCity = "null";
    @SerializedName("district")
    private String mDistrict = "null";

    public void setCode(String str) {
        this.mCode = str;
    }

    public String getCode() {
        return this.mCode;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setProvince(String str) {
        this.mProvince = str;
    }

    public String getProvince() {
        return this.mProvince;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public String getCity() {
        return this.mCity;
    }

    public void setDistrict(String str) {
        this.mDistrict = str;
    }

    public String getDistrict() {
        return this.mDistrict;
    }

    public String toString() {
        return "NearestResult{mCode='" + this.mCode + "', mAddress='" + this.mAddress + "', mProvince='" + this.mProvince + "', mCity='" + this.mCity + "', mDistrict='" + this.mDistrict + "'}";
    }
}
