package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes3.dex */
public class WebNaviSettingInfo {
    @SerializedName("createTime")
    private Long mCreateTime;
    @SerializedName("dataChildType")
    private Integer mDataChildType;
    @SerializedName("dataContent")
    protected String mDataContent;
    @SerializedName("dataId")
    protected String mDataId;
    @SerializedName(LocationUtils.DR_RECORD_TAG_DATA_TYPE)
    protected Integer mDataType;
    @SerializedName("isDeleted")
    private Integer mIsDeleted;
    @SerializedName("preVersion")
    private Long mPreVersion;
    @SerializedName("updateTime")
    private Long mUpdateTime;
    @SerializedName("version")
    private Long mVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof WebNaviSettingInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WebNaviSettingInfo) {
            WebNaviSettingInfo webNaviSettingInfo = (WebNaviSettingInfo) obj;
            if (webNaviSettingInfo.canEqual(this)) {
                Integer dataType = getDataType();
                Integer dataType2 = webNaviSettingInfo.getDataType();
                if (dataType != null ? dataType.equals(dataType2) : dataType2 == null) {
                    Integer dataChildType = getDataChildType();
                    Integer dataChildType2 = webNaviSettingInfo.getDataChildType();
                    if (dataChildType != null ? dataChildType.equals(dataChildType2) : dataChildType2 == null) {
                        Long version = getVersion();
                        Long version2 = webNaviSettingInfo.getVersion();
                        if (version != null ? version.equals(version2) : version2 == null) {
                            Long preVersion = getPreVersion();
                            Long preVersion2 = webNaviSettingInfo.getPreVersion();
                            if (preVersion != null ? preVersion.equals(preVersion2) : preVersion2 == null) {
                                Long createTime = getCreateTime();
                                Long createTime2 = webNaviSettingInfo.getCreateTime();
                                if (createTime != null ? createTime.equals(createTime2) : createTime2 == null) {
                                    Long updateTime = getUpdateTime();
                                    Long updateTime2 = webNaviSettingInfo.getUpdateTime();
                                    if (updateTime != null ? updateTime.equals(updateTime2) : updateTime2 == null) {
                                        Integer isDeleted = getIsDeleted();
                                        Integer isDeleted2 = webNaviSettingInfo.getIsDeleted();
                                        if (isDeleted != null ? isDeleted.equals(isDeleted2) : isDeleted2 == null) {
                                            String dataId = getDataId();
                                            String dataId2 = webNaviSettingInfo.getDataId();
                                            if (dataId != null ? dataId.equals(dataId2) : dataId2 == null) {
                                                String dataContent = getDataContent();
                                                String dataContent2 = webNaviSettingInfo.getDataContent();
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
        Long version = getVersion();
        int hashCode3 = (hashCode2 * 59) + (version == null ? 43 : version.hashCode());
        Long preVersion = getPreVersion();
        int hashCode4 = (hashCode3 * 59) + (preVersion == null ? 43 : preVersion.hashCode());
        Long createTime = getCreateTime();
        int hashCode5 = (hashCode4 * 59) + (createTime == null ? 43 : createTime.hashCode());
        Long updateTime = getUpdateTime();
        int hashCode6 = (hashCode5 * 59) + (updateTime == null ? 43 : updateTime.hashCode());
        Integer isDeleted = getIsDeleted();
        int hashCode7 = (hashCode6 * 59) + (isDeleted == null ? 43 : isDeleted.hashCode());
        String dataId = getDataId();
        int hashCode8 = (hashCode7 * 59) + (dataId == null ? 43 : dataId.hashCode());
        String dataContent = getDataContent();
        return (hashCode8 * 59) + (dataContent != null ? dataContent.hashCode() : 43);
    }

    public WebNaviSettingInfo setCreateTime(Long l) {
        this.mCreateTime = l;
        return this;
    }

    public WebNaviSettingInfo setDataChildType(Integer num) {
        this.mDataChildType = num;
        return this;
    }

    public WebNaviSettingInfo setDataContent(String str) {
        this.mDataContent = str;
        return this;
    }

    public WebNaviSettingInfo setDataId(String str) {
        this.mDataId = str;
        return this;
    }

    public WebNaviSettingInfo setDataType(Integer num) {
        this.mDataType = num;
        return this;
    }

    public WebNaviSettingInfo setIsDeleted(Integer num) {
        this.mIsDeleted = num;
        return this;
    }

    public WebNaviSettingInfo setPreVersion(Long l) {
        this.mPreVersion = l;
        return this;
    }

    public WebNaviSettingInfo setUpdateTime(Long l) {
        this.mUpdateTime = l;
        return this;
    }

    public WebNaviSettingInfo setVersion(Long l) {
        this.mVersion = l;
        return this;
    }

    public String toString() {
        return "WebNaviSettingInfo(mDataId=" + getDataId() + ", mDataType=" + getDataType() + ", mDataChildType=" + getDataChildType() + ", mDataContent=" + getDataContent() + ", mVersion=" + getVersion() + ", mPreVersion=" + getPreVersion() + ", mCreateTime=" + getCreateTime() + ", mUpdateTime=" + getUpdateTime() + ", mIsDeleted=" + getIsDeleted() + ")";
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

    public Long getVersion() {
        return this.mVersion;
    }

    public Long getPreVersion() {
        return this.mPreVersion;
    }

    public Long getCreateTime() {
        return this.mCreateTime;
    }

    public Long getUpdateTime() {
        return this.mUpdateTime;
    }

    public Integer getIsDeleted() {
        return this.mIsDeleted;
    }
}
