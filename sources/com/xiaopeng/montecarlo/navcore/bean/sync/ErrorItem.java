package com.xiaopeng.montecarlo.navcore.bean.sync;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes3.dex */
public class ErrorItem {
    @SerializedName("dataId")
    private String mDataId;
    @SerializedName(LocationUtils.DR_RECORD_TAG_DATA_TYPE)
    private int mDataType;
    @SerializedName("errorMsg")
    private String mErrorMsg;
    @SerializedName("errorType")
    private int mErrorType;

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

    public void setErrorType(int i) {
        this.mErrorType = i;
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String dumpInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorItem dataId:" + this.mDataId);
        sb.append(" dataType:" + this.mDataType);
        sb.append(" errorType:" + this.mErrorType);
        sb.append(" errorMsg:" + this.mErrorMsg);
        return sb.toString();
    }
}
