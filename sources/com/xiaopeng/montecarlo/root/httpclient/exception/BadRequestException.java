package com.xiaopeng.montecarlo.root.httpclient.exception;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class BadRequestException extends RuntimeException {
    @SerializedName("code")
    int mCode;
    @SerializedName("data")
    String mData;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    String mMsg;

    public BadRequestException setCode(int i) {
        this.mCode = i;
        return this;
    }

    public BadRequestException setData(String str) {
        this.mData = str;
        return this;
    }

    public BadRequestException setMsg(String str) {
        this.mMsg = str;
        return this;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public String getData() {
        return this.mData;
    }

    public BadRequestException(String str) {
        super(str);
    }
}
