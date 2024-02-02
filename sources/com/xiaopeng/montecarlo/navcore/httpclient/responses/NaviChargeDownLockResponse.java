package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviChargeDownLockResponse {
    @SerializedName("code")
    private long mCode;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String mMsg;
    @SerializedName("data")
    private Boolean mResult;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviChargeDownLockResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviChargeDownLockResponse) {
            NaviChargeDownLockResponse naviChargeDownLockResponse = (NaviChargeDownLockResponse) obj;
            if (naviChargeDownLockResponse.canEqual(this) && getCode() == naviChargeDownLockResponse.getCode()) {
                Boolean result = getResult();
                Boolean result2 = naviChargeDownLockResponse.getResult();
                if (result != null ? result.equals(result2) : result2 == null) {
                    String msg = getMsg();
                    String msg2 = naviChargeDownLockResponse.getMsg();
                    return msg != null ? msg.equals(msg2) : msg2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long code = getCode();
        Boolean result = getResult();
        int hashCode = ((((int) (code ^ (code >>> 32))) + 59) * 59) + (result == null ? 43 : result.hashCode());
        String msg = getMsg();
        return (hashCode * 59) + (msg != null ? msg.hashCode() : 43);
    }

    public NaviChargeDownLockResponse setCode(long j) {
        this.mCode = j;
        return this;
    }

    public NaviChargeDownLockResponse setMsg(String str) {
        this.mMsg = str;
        return this;
    }

    public NaviChargeDownLockResponse setResult(Boolean bool) {
        this.mResult = bool;
        return this;
    }

    public String toString() {
        return "NaviChargeDownLockResponse(mCode=" + getCode() + ", mMsg=" + getMsg() + ", mResult=" + getResult() + ")";
    }

    public long getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public Boolean getResult() {
        return this.mResult;
    }
}
