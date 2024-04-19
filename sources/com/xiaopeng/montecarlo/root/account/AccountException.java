package com.xiaopeng.montecarlo.root.account;
/* loaded from: classes3.dex */
public class AccountException extends RuntimeException {
    private final int mCode;
    private Object mErrorResponseData;
    private final String mMessage;

    public AccountException(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
    }

    public Object getErrorResponseData() {
        return this.mErrorResponseData;
    }

    public void setErrorResponseData(Object obj) {
        this.mErrorResponseData = obj;
    }

    public int getCode() {
        return this.mCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mMessage;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AccountException{code=" + this.mCode + ", message='" + this.mMessage + "'}";
    }
}
