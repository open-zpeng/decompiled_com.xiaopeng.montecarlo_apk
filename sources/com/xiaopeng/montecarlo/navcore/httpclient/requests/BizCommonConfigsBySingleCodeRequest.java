package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPCommonCfgParam;
/* loaded from: classes2.dex */
public class BizCommonConfigsBySingleCodeRequest {
    @SerializedName(XPCommonCfgParam.PARAM_KEY_CFG_CODE)
    String mCfgCode;
    @SerializedName("userType")
    Integer mUserType;

    protected boolean canEqual(Object obj) {
        return obj instanceof BizCommonConfigsBySingleCodeRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BizCommonConfigsBySingleCodeRequest) {
            BizCommonConfigsBySingleCodeRequest bizCommonConfigsBySingleCodeRequest = (BizCommonConfigsBySingleCodeRequest) obj;
            if (bizCommonConfigsBySingleCodeRequest.canEqual(this)) {
                Integer userType = getUserType();
                Integer userType2 = bizCommonConfigsBySingleCodeRequest.getUserType();
                if (userType != null ? userType.equals(userType2) : userType2 == null) {
                    String cfgCode = getCfgCode();
                    String cfgCode2 = bizCommonConfigsBySingleCodeRequest.getCfgCode();
                    return cfgCode != null ? cfgCode.equals(cfgCode2) : cfgCode2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer userType = getUserType();
        int hashCode = userType == null ? 43 : userType.hashCode();
        String cfgCode = getCfgCode();
        return ((hashCode + 59) * 59) + (cfgCode != null ? cfgCode.hashCode() : 43);
    }

    public BizCommonConfigsBySingleCodeRequest setCfgCode(String str) {
        this.mCfgCode = str;
        return this;
    }

    public BizCommonConfigsBySingleCodeRequest setUserType(Integer num) {
        this.mUserType = num;
        return this;
    }

    public String toString() {
        return "BizCommonConfigsBySingleCodeRequest(mCfgCode=" + getCfgCode() + ", mUserType=" + getUserType() + ")";
    }

    public String getCfgCode() {
        return this.mCfgCode;
    }

    public Integer getUserType() {
        return this.mUserType;
    }
}
