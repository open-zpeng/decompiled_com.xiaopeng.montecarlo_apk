package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes3.dex */
public class OperateSettingErrorDto {
    @SerializedName("dataChildType")
    private Integer mDataChildType;
    @SerializedName("dataId")
    private String mDataId;
    @SerializedName(LocationUtils.DR_RECORD_TAG_DATA_TYPE)
    private Integer mDataType;
    @SerializedName("errorMsg")
    private String mErrorMsg;
    @SerializedName("errorType")
    private Integer mErrorType;

    protected boolean canEqual(Object obj) {
        return obj instanceof OperateSettingErrorDto;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OperateSettingErrorDto) {
            OperateSettingErrorDto operateSettingErrorDto = (OperateSettingErrorDto) obj;
            if (operateSettingErrorDto.canEqual(this)) {
                Integer dataType = getDataType();
                Integer dataType2 = operateSettingErrorDto.getDataType();
                if (dataType != null ? dataType.equals(dataType2) : dataType2 == null) {
                    Integer dataChildType = getDataChildType();
                    Integer dataChildType2 = operateSettingErrorDto.getDataChildType();
                    if (dataChildType != null ? dataChildType.equals(dataChildType2) : dataChildType2 == null) {
                        Integer errorType = getErrorType();
                        Integer errorType2 = operateSettingErrorDto.getErrorType();
                        if (errorType != null ? errorType.equals(errorType2) : errorType2 == null) {
                            String dataId = getDataId();
                            String dataId2 = operateSettingErrorDto.getDataId();
                            if (dataId != null ? dataId.equals(dataId2) : dataId2 == null) {
                                String errorMsg = getErrorMsg();
                                String errorMsg2 = operateSettingErrorDto.getErrorMsg();
                                return errorMsg != null ? errorMsg.equals(errorMsg2) : errorMsg2 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer dataType = getDataType();
        int hashCode = dataType == null ? 43 : dataType.hashCode();
        Integer dataChildType = getDataChildType();
        int hashCode2 = ((hashCode + 59) * 59) + (dataChildType == null ? 43 : dataChildType.hashCode());
        Integer errorType = getErrorType();
        int hashCode3 = (hashCode2 * 59) + (errorType == null ? 43 : errorType.hashCode());
        String dataId = getDataId();
        int hashCode4 = (hashCode3 * 59) + (dataId == null ? 43 : dataId.hashCode());
        String errorMsg = getErrorMsg();
        return (hashCode4 * 59) + (errorMsg != null ? errorMsg.hashCode() : 43);
    }

    public OperateSettingErrorDto setDataChildType(Integer num) {
        this.mDataChildType = num;
        return this;
    }

    public OperateSettingErrorDto setDataId(String str) {
        this.mDataId = str;
        return this;
    }

    public OperateSettingErrorDto setDataType(Integer num) {
        this.mDataType = num;
        return this;
    }

    public OperateSettingErrorDto setErrorMsg(String str) {
        this.mErrorMsg = str;
        return this;
    }

    public OperateSettingErrorDto setErrorType(Integer num) {
        this.mErrorType = num;
        return this;
    }

    public String toString() {
        return "OperateSettingErrorDto(mDataId=" + getDataId() + ", mDataType=" + getDataType() + ", mDataChildType=" + getDataChildType() + ", mErrorType=" + getErrorType() + ", mErrorMsg=" + getErrorMsg() + ")";
    }

    public String getDataId() {
        return this.mDataId;
    }

    public Integer getDataType() {
        return this.mDataType;
    }

    public Integer getDataChildType() {
        return this.mDataChildType;
    }

    public Integer getErrorType() {
        return this.mErrorType;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }
}
