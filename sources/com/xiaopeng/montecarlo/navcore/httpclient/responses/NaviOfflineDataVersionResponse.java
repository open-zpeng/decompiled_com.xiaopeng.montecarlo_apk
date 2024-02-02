package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviOfflineDataVersionResponse {
    @SerializedName("category")
    private String mCategory;
    @SerializedName("data_url")
    private String mDataUrl;
    @SerializedName("latest_data_version")
    private String mLatestDataVersion;
    @SerializedName("md5")
    private String mMd5;
    @SerializedName("type")
    private Integer mType;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviOfflineDataVersionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviOfflineDataVersionResponse) {
            NaviOfflineDataVersionResponse naviOfflineDataVersionResponse = (NaviOfflineDataVersionResponse) obj;
            if (naviOfflineDataVersionResponse.canEqual(this)) {
                Integer type = getType();
                Integer type2 = naviOfflineDataVersionResponse.getType();
                if (type != null ? type.equals(type2) : type2 == null) {
                    String latestDataVersion = getLatestDataVersion();
                    String latestDataVersion2 = naviOfflineDataVersionResponse.getLatestDataVersion();
                    if (latestDataVersion != null ? latestDataVersion.equals(latestDataVersion2) : latestDataVersion2 == null) {
                        String dataUrl = getDataUrl();
                        String dataUrl2 = naviOfflineDataVersionResponse.getDataUrl();
                        if (dataUrl != null ? dataUrl.equals(dataUrl2) : dataUrl2 == null) {
                            String md5 = getMd5();
                            String md52 = naviOfflineDataVersionResponse.getMd5();
                            if (md5 != null ? md5.equals(md52) : md52 == null) {
                                String category = getCategory();
                                String category2 = naviOfflineDataVersionResponse.getCategory();
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
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer type = getType();
        int hashCode = type == null ? 43 : type.hashCode();
        String latestDataVersion = getLatestDataVersion();
        int hashCode2 = ((hashCode + 59) * 59) + (latestDataVersion == null ? 43 : latestDataVersion.hashCode());
        String dataUrl = getDataUrl();
        int hashCode3 = (hashCode2 * 59) + (dataUrl == null ? 43 : dataUrl.hashCode());
        String md5 = getMd5();
        int hashCode4 = (hashCode3 * 59) + (md5 == null ? 43 : md5.hashCode());
        String category = getCategory();
        return (hashCode4 * 59) + (category != null ? category.hashCode() : 43);
    }

    public NaviOfflineDataVersionResponse setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public NaviOfflineDataVersionResponse setDataUrl(String str) {
        this.mDataUrl = str;
        return this;
    }

    public NaviOfflineDataVersionResponse setLatestDataVersion(String str) {
        this.mLatestDataVersion = str;
        return this;
    }

    public NaviOfflineDataVersionResponse setMd5(String str) {
        this.mMd5 = str;
        return this;
    }

    public NaviOfflineDataVersionResponse setType(Integer num) {
        this.mType = num;
        return this;
    }

    public String toString() {
        return "NaviOfflineDataVersionResponse(mType=" + getType() + ", mLatestDataVersion=" + getLatestDataVersion() + ", mDataUrl=" + getDataUrl() + ", mMd5=" + getMd5() + ", mCategory=" + getCategory() + ")";
    }

    public Integer getType() {
        return this.mType;
    }

    public String getLatestDataVersion() {
        return this.mLatestDataVersion;
    }

    public String getDataUrl() {
        return this.mDataUrl;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public String getCategory() {
        return this.mCategory;
    }
}
