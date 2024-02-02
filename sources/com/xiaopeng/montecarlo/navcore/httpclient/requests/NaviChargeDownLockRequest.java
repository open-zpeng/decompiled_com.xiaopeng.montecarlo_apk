package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviChargeDownLockRequest {
    @SerializedName("lock_no")
    private String mLockNo;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviChargeDownLockRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviChargeDownLockRequest) {
            NaviChargeDownLockRequest naviChargeDownLockRequest = (NaviChargeDownLockRequest) obj;
            if (naviChargeDownLockRequest.canEqual(this)) {
                String lockNo = getLockNo();
                String lockNo2 = naviChargeDownLockRequest.getLockNo();
                return lockNo != null ? lockNo.equals(lockNo2) : lockNo2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String lockNo = getLockNo();
        return 59 + (lockNo == null ? 43 : lockNo.hashCode());
    }

    public NaviChargeDownLockRequest setLockNo(String str) {
        this.mLockNo = str;
        return this;
    }

    public String toString() {
        return "NaviChargeDownLockRequest(mLockNo=" + getLockNo() + ")";
    }

    public String getLockNo() {
        return this.mLockNo;
    }
}
