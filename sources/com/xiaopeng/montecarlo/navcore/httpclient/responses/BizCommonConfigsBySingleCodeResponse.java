package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes2.dex */
public class BizCommonConfigsBySingleCodeResponse {
    @SerializedName("value")
    List<String> mValue;

    protected boolean canEqual(Object obj) {
        return obj instanceof BizCommonConfigsBySingleCodeResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BizCommonConfigsBySingleCodeResponse) {
            BizCommonConfigsBySingleCodeResponse bizCommonConfigsBySingleCodeResponse = (BizCommonConfigsBySingleCodeResponse) obj;
            if (bizCommonConfigsBySingleCodeResponse.canEqual(this)) {
                List<String> value = getValue();
                List<String> value2 = bizCommonConfigsBySingleCodeResponse.getValue();
                return value != null ? value.equals(value2) : value2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<String> value = getValue();
        return 59 + (value == null ? 43 : value.hashCode());
    }

    public BizCommonConfigsBySingleCodeResponse setValue(List<String> list) {
        this.mValue = list;
        return this;
    }

    public String toString() {
        return "BizCommonConfigsBySingleCodeResponse(mValue=" + getValue() + ")";
    }

    public List<String> getValue() {
        return this.mValue;
    }
}
