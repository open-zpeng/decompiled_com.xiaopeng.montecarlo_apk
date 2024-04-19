package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes2.dex */
public class OperateSettingInfo {
    @SerializedName("dataChildType")
    private Integer mDataChildType;
    @SerializedName("dataContent")
    private String mDataContent;
    @SerializedName("dataId")
    private String mDataId;
    @SerializedName(LocationUtils.DR_RECORD_TAG_DATA_TYPE)
    private Integer mDataType;
    @SerializedName("opType")
    private Integer mOpType;

    protected boolean canEqual(Object obj) {
        return obj instanceof OperateSettingInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OperateSettingInfo) {
            OperateSettingInfo operateSettingInfo = (OperateSettingInfo) obj;
            if (operateSettingInfo.canEqual(this)) {
                Integer opType = getOpType();
                Integer opType2 = operateSettingInfo.getOpType();
                if (opType != null ? opType.equals(opType2) : opType2 == null) {
                    Integer dataType = getDataType();
                    Integer dataType2 = operateSettingInfo.getDataType();
                    if (dataType != null ? dataType.equals(dataType2) : dataType2 == null) {
                        Integer dataChildType = getDataChildType();
                        Integer dataChildType2 = operateSettingInfo.getDataChildType();
                        if (dataChildType != null ? dataChildType.equals(dataChildType2) : dataChildType2 == null) {
                            String dataId = getDataId();
                            String dataId2 = operateSettingInfo.getDataId();
                            if (dataId != null ? dataId.equals(dataId2) : dataId2 == null) {
                                String dataContent = getDataContent();
                                String dataContent2 = operateSettingInfo.getDataContent();
                                return dataContent != null ? dataContent.equals(dataContent2) : dataContent2 == null;
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
        Integer opType = getOpType();
        int hashCode = opType == null ? 43 : opType.hashCode();
        Integer dataType = getDataType();
        int hashCode2 = ((hashCode + 59) * 59) + (dataType == null ? 43 : dataType.hashCode());
        Integer dataChildType = getDataChildType();
        int hashCode3 = (hashCode2 * 59) + (dataChildType == null ? 43 : dataChildType.hashCode());
        String dataId = getDataId();
        int hashCode4 = (hashCode3 * 59) + (dataId == null ? 43 : dataId.hashCode());
        String dataContent = getDataContent();
        return (hashCode4 * 59) + (dataContent != null ? dataContent.hashCode() : 43);
    }

    public OperateSettingInfo setDataChildType(Integer num) {
        this.mDataChildType = num;
        return this;
    }

    public OperateSettingInfo setDataContent(String str) {
        this.mDataContent = str;
        return this;
    }

    public OperateSettingInfo setDataId(String str) {
        this.mDataId = str;
        return this;
    }

    public OperateSettingInfo setDataType(Integer num) {
        this.mDataType = num;
        return this;
    }

    public OperateSettingInfo setOpType(Integer num) {
        this.mOpType = num;
        return this;
    }

    public String toString() {
        return "OperateSettingInfo(mOpType=" + getOpType() + ", mDataId=" + getDataId() + ", mDataType=" + getDataType() + ", mDataChildType=" + getDataChildType() + ", mDataContent=" + getDataContent() + ")";
    }

    public Integer getOpType() {
        return this.mOpType;
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

    public String getDataContent() {
        return this.mDataContent;
    }
}
