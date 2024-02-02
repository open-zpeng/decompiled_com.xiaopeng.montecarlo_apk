package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes2.dex */
public class ReplaceSettingInfo {
    @SerializedName("dataChildType")
    private Integer mDataChildType;
    @SerializedName("dataContent")
    private String mDataContent;
    @SerializedName("dataId")
    private String mDataId;
    @SerializedName(LocationUtils.DR_RECORD_TAG_DATA_TYPE)
    private Integer mDataType;

    protected boolean canEqual(Object obj) {
        return obj instanceof ReplaceSettingInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReplaceSettingInfo) {
            ReplaceSettingInfo replaceSettingInfo = (ReplaceSettingInfo) obj;
            if (replaceSettingInfo.canEqual(this)) {
                Integer dataType = getDataType();
                Integer dataType2 = replaceSettingInfo.getDataType();
                if (dataType != null ? dataType.equals(dataType2) : dataType2 == null) {
                    Integer dataChildType = getDataChildType();
                    Integer dataChildType2 = replaceSettingInfo.getDataChildType();
                    if (dataChildType != null ? dataChildType.equals(dataChildType2) : dataChildType2 == null) {
                        String dataId = getDataId();
                        String dataId2 = replaceSettingInfo.getDataId();
                        if (dataId != null ? dataId.equals(dataId2) : dataId2 == null) {
                            String dataContent = getDataContent();
                            String dataContent2 = replaceSettingInfo.getDataContent();
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

    public int hashCode() {
        Integer dataType = getDataType();
        int hashCode = dataType == null ? 43 : dataType.hashCode();
        Integer dataChildType = getDataChildType();
        int hashCode2 = ((hashCode + 59) * 59) + (dataChildType == null ? 43 : dataChildType.hashCode());
        String dataId = getDataId();
        int hashCode3 = (hashCode2 * 59) + (dataId == null ? 43 : dataId.hashCode());
        String dataContent = getDataContent();
        return (hashCode3 * 59) + (dataContent != null ? dataContent.hashCode() : 43);
    }

    public ReplaceSettingInfo setDataChildType(Integer num) {
        this.mDataChildType = num;
        return this;
    }

    public ReplaceSettingInfo setDataContent(String str) {
        this.mDataContent = str;
        return this;
    }

    public ReplaceSettingInfo setDataId(String str) {
        this.mDataId = str;
        return this;
    }

    public ReplaceSettingInfo setDataType(Integer num) {
        this.mDataType = num;
        return this;
    }

    public String toString() {
        return "ReplaceSettingInfo(mDataId=" + getDataId() + ", mDataType=" + getDataType() + ", mDataChildType=" + getDataChildType() + ", mDataContent=" + getDataContent() + ")";
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
