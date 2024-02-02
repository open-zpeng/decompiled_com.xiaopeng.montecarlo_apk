package com.xiaopeng.montecarlo.navcore.bean.sync;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class AccountDeleteUserDataResponse {
    @SerializedName("code")
    private int mCode;
    @SerializedName("data")
    private DataBean mData;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String mMsg;

    public void setCode(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setData(DataBean dataBean) {
        this.mData = dataBean;
    }

    public DataBean getData() {
        return this.mData;
    }

    public String toString() {
        return "AccountDeleteUserDataResponse{mCode=" + this.mCode + ", mMsg='" + this.mMsg + "', mData=" + this.mData + '}';
    }

    /* loaded from: classes2.dex */
    public static class DataBean {
        @SerializedName("server_version")
        private int mServerVersion;

        public void setServerVersion(int i) {
            this.mServerVersion = i;
        }

        public int getServerVersion() {
            return this.mServerVersion;
        }

        public String toString() {
            return "DataBean{mServerVersion=" + this.mServerVersion + '}';
        }
    }
}
