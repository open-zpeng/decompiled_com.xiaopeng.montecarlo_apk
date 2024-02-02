package com.xiaopeng.montecarlo.root.httpclient.core;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class ResponseWrapper<T> {
    @SerializedName("code")
    private int mCode;
    @SerializedName("data")
    private T mData;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String mMsg;
    @SerializedName("responseCode")
    private int mResponseCode;

    protected boolean canEqual(Object obj) {
        return obj instanceof ResponseWrapper;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ResponseWrapper) {
            ResponseWrapper responseWrapper = (ResponseWrapper) obj;
            if (responseWrapper.canEqual(this) && getCode() == responseWrapper.getCode() && getResponseCode() == responseWrapper.getResponseCode()) {
                String msg = getMsg();
                String msg2 = responseWrapper.getMsg();
                if (msg != null ? msg.equals(msg2) : msg2 == null) {
                    T data = getData();
                    Object data2 = responseWrapper.getData();
                    return data != null ? data.equals(data2) : data2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int code = ((getCode() + 59) * 59) + getResponseCode();
        String msg = getMsg();
        int hashCode = (code * 59) + (msg == null ? 43 : msg.hashCode());
        T data = getData();
        return (hashCode * 59) + (data != null ? data.hashCode() : 43);
    }

    public ResponseWrapper<T> setCode(int i) {
        this.mCode = i;
        return this;
    }

    public ResponseWrapper<T> setData(T t) {
        this.mData = t;
        return this;
    }

    public ResponseWrapper<T> setMsg(String str) {
        this.mMsg = str;
        return this;
    }

    public ResponseWrapper<T> setResponseCode(int i) {
        this.mResponseCode = i;
        return this;
    }

    public String toString() {
        return "ResponseWrapper(mCode=" + getCode() + ", mMsg=" + getMsg() + ", mData=" + getData() + ", mResponseCode=" + getResponseCode() + ")";
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public T getData() {
        return this.mData;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
