package com.xiaopeng.montecarlo.navcore.search.charge;
/* loaded from: classes2.dex */
public class ChargeDataException extends Exception {
    public static final int DOWN_LOCK_ERROR_BOOKED_BY_OTHERS = 411;
    private long mErrorCode;

    public ChargeDataException(long j, String str) {
        super(str == null ? "" : str);
        this.mErrorCode = j;
    }

    public long getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }
}
