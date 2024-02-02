package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes2.dex */
public class DataOperation extends DataTransform {
    @SerializedName("dataContent")
    private String mDataContent;
    @SerializedName("dataId")
    private String mDataId;
    @SerializedName("preVersion")
    private int mPreVersion;
    @SerializedName("version")
    private int mVersion;
    @SerializedName(LocationUtils.DR_RECORD_TAG_DATA_TYPE)
    private int mDataType = 0;
    @SerializedName("createTime")
    private long mCreateTime = 0;
    @SerializedName("opType")
    private int mOperationType = 1;
    @SerializedName("updateTime")
    private long mUpdateTime = 0;

    public String getDataId() {
        return this.mDataId;
    }

    public void setDataId(String str) {
        this.mDataId = str;
    }

    public int getDataType() {
        return this.mDataType;
    }

    public void setDataType(int i) {
        this.mDataType = i;
    }

    public String getDataContent() {
        return this.mDataContent;
    }

    public void setDataContent(String str) {
        this.mDataContent = str;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public int getOperationType() {
        return this.mOperationType;
    }

    public void setOperationType(int i) {
        this.mOperationType = i;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public int getPreVersion() {
        return this.mPreVersion;
    }

    public void setPreVersion(int i) {
        this.mPreVersion = i;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setUpdateTime(long j) {
        this.mUpdateTime = j;
    }

    public DataOperation() {
    }

    public DataOperation(AccountDataPullResponse.DataBean.ItemListBean itemListBean) {
        setDataId(itemListBean.getDataId());
        setDataType(itemListBean.getDataType());
        setDataContent(itemListBean.getDataContent());
        setPreVersion(itemListBean.getPreVersion());
        setVersion(itemListBean.getVersion());
        setCreateTime(itemListBean.getCreateTime());
        setUpdateTime(itemListBean.getUpdateTime());
        if (itemListBean.getIsDeleted() == 1) {
            setOperationType(3);
        } else {
            setOperationType(2);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    @Nullable
    public ContentValues toContentValues() {
        return super.toContentValues();
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    public void bindContentValues(Cursor cursor) {
        super.bindContentValues(cursor);
    }
}
