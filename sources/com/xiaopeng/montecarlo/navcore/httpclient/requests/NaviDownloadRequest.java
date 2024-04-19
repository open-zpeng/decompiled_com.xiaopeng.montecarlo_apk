package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviDownloadRequest {
    @SerializedName("category")
    private String mCategory;
    @SerializedName("current_data_version")
    private String mCurrentDataVersion;
    @SerializedName("type")
    private Integer mType = 1;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviDownloadRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviDownloadRequest) {
            NaviDownloadRequest naviDownloadRequest = (NaviDownloadRequest) obj;
            if (naviDownloadRequest.canEqual(this)) {
                Integer type = getType();
                Integer type2 = naviDownloadRequest.getType();
                if (type != null ? type.equals(type2) : type2 == null) {
                    String currentDataVersion = getCurrentDataVersion();
                    String currentDataVersion2 = naviDownloadRequest.getCurrentDataVersion();
                    if (currentDataVersion != null ? currentDataVersion.equals(currentDataVersion2) : currentDataVersion2 == null) {
                        String category = getCategory();
                        String category2 = naviDownloadRequest.getCategory();
                        return category != null ? category.equals(category2) : category2 == null;
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
        Integer type = getType();
        int hashCode = type == null ? 43 : type.hashCode();
        String currentDataVersion = getCurrentDataVersion();
        int hashCode2 = ((hashCode + 59) * 59) + (currentDataVersion == null ? 43 : currentDataVersion.hashCode());
        String category = getCategory();
        return (hashCode2 * 59) + (category != null ? category.hashCode() : 43);
    }

    public NaviDownloadRequest setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public NaviDownloadRequest setCurrentDataVersion(String str) {
        this.mCurrentDataVersion = str;
        return this;
    }

    public NaviDownloadRequest setType(Integer num) {
        this.mType = num;
        return this;
    }

    public String toString() {
        return "NaviDownloadRequest(mType=" + getType() + ", mCurrentDataVersion=" + getCurrentDataVersion() + ", mCategory=" + getCategory() + ")";
    }

    public Integer getType() {
        return this.mType;
    }

    public String getCurrentDataVersion() {
        return this.mCurrentDataVersion;
    }

    public String getCategory() {
        return this.mCategory;
    }
}
