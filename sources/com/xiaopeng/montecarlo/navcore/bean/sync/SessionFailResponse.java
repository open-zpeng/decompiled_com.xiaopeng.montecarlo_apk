package com.xiaopeng.montecarlo.navcore.bean.sync;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class SessionFailResponse {
    @SerializedName("code")
    private int mCode;
    @SerializedName("data")
    private DataBean mData;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String mMsg;

    public int getCode() {
        return this.mCode;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }

    public DataBean getData() {
        return this.mData;
    }

    public void setData(DataBean dataBean) {
        this.mData = dataBean;
    }

    /* loaded from: classes3.dex */
    public static class DataBean {
        @SerializedName("sid")
        private String mSid;

        public String getSid() {
            return this.mSid;
        }

        public void setSid(String str) {
            this.mSid = str;
        }
    }
}
