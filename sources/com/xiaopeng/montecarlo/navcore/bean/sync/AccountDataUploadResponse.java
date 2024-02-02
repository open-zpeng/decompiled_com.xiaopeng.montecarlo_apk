package com.xiaopeng.montecarlo.navcore.bean.sync;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes2.dex */
public class AccountDataUploadResponse {
    @SerializedName("code")
    private int mCode;
    @SerializedName("data")
    private MDataBean mData;
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

    public void setData(MDataBean mDataBean) {
        this.mData = mDataBean;
    }

    public MDataBean getData() {
        return this.mData;
    }

    /* loaded from: classes2.dex */
    public static class MDataBean {
        @SerializedName("errorItemList")
        private List<ErrorItem> mErrorItemList;
        @SerializedName("serverVersion")
        private int mServerVersion;
        @SerializedName("successCount")
        private int mSuccessCount;

        public void setServerVersion(int i) {
            this.mServerVersion = i;
        }

        public int getServerVersion() {
            return this.mServerVersion;
        }

        public void setSuccessCount(int i) {
            this.mSuccessCount = i;
        }

        public int getSuccessCount() {
            return this.mSuccessCount;
        }

        public void setErrorItemList(List<ErrorItem> list) {
            this.mErrorItemList = list;
        }

        public List<ErrorItem> getErrorItemList() {
            return this.mErrorItemList;
        }
    }
}
