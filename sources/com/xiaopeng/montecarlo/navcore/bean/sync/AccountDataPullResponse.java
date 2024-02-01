package com.xiaopeng.montecarlo.navcore.bean.sync;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import java.util.List;
/* loaded from: classes3.dex */
public class AccountDataPullResponse {
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

    /* loaded from: classes3.dex */
    public static class DataBean {
        @SerializedName("itemList")
        private List<ItemListBean> mItemList;
        @SerializedName("localVersion")
        private int mLocalVersion;
        @SerializedName("serverVersion")
        private int mServerVersion;

        public void setServerVersion(int i) {
            this.mServerVersion = i;
        }

        public int getServerVersion() {
            return this.mServerVersion;
        }

        public void setLocalVersion(int i) {
            this.mLocalVersion = i;
        }

        public int getLocalVersion() {
            return this.mLocalVersion;
        }

        public void setItemList(List<ItemListBean> list) {
            this.mItemList = list;
        }

        public List<ItemListBean> getItemList() {
            return this.mItemList;
        }

        /* loaded from: classes3.dex */
        public static class ItemListBean {
            @SerializedName("createTime")
            private long mCreateTime;
            @SerializedName("dataContent")
            private String mDataContent;
            @SerializedName("dataId")
            private String mDataId;
            @SerializedName(LocationUtils.DR_RECORD_TAG_DATA_TYPE)
            private int mDataType;
            @SerializedName("isDeleted")
            private int mIsDeleted;
            @SerializedName("preVersion")
            private int mPreVersion;
            @SerializedName("updateTime")
            private long mUpdateTime;
            @SerializedName("version")
            private int mVersion;

            public void setDataId(String str) {
                this.mDataId = str;
            }

            public String getDataId() {
                return this.mDataId;
            }

            public void setDataType(int i) {
                this.mDataType = i;
            }

            public int getDataType() {
                return this.mDataType;
            }

            public void setDataContent(String str) {
                this.mDataContent = str;
            }

            public String getDataContent() {
                return this.mDataContent;
            }

            public void setVersion(int i) {
                this.mVersion = i;
            }

            public int getVersion() {
                return this.mVersion;
            }

            public void setPreVersion(int i) {
                this.mPreVersion = i;
            }

            public int getPreVersion() {
                return this.mPreVersion;
            }

            public void setCreateTime(long j) {
                this.mCreateTime = j;
            }

            public long getCreateTime() {
                return this.mCreateTime;
            }

            public void setUpdateTime(long j) {
                this.mUpdateTime = j;
            }

            public long getUpdateTime() {
                return this.mUpdateTime;
            }

            public void setIsDeleted(int i) {
                this.mIsDeleted = i;
            }

            public int getIsDeleted() {
                return this.mIsDeleted;
            }
        }
    }
}
