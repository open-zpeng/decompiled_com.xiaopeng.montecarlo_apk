package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class XUIResourceResponse {
    @SerializedName("category")
    private String mCategory;
    @SerializedName("content")
    private String mContent;
    @SerializedName("current_version")
    private long mCurrentVersion;
    @SerializedName("latest_version")
    private long mLatestVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof XUIResourceResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XUIResourceResponse) {
            XUIResourceResponse xUIResourceResponse = (XUIResourceResponse) obj;
            if (xUIResourceResponse.canEqual(this) && getCurrentVersion() == xUIResourceResponse.getCurrentVersion() && getLatestVersion() == xUIResourceResponse.getLatestVersion()) {
                String category = getCategory();
                String category2 = xUIResourceResponse.getCategory();
                if (category != null ? category.equals(category2) : category2 == null) {
                    String content = getContent();
                    String content2 = xUIResourceResponse.getContent();
                    return content != null ? content.equals(content2) : content2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long currentVersion = getCurrentVersion();
        long latestVersion = getLatestVersion();
        String category = getCategory();
        int hashCode = ((((((int) (currentVersion ^ (currentVersion >>> 32))) + 59) * 59) + ((int) ((latestVersion >>> 32) ^ latestVersion))) * 59) + (category == null ? 43 : category.hashCode());
        String content = getContent();
        return (hashCode * 59) + (content != null ? content.hashCode() : 43);
    }

    public XUIResourceResponse setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public XUIResourceResponse setContent(String str) {
        this.mContent = str;
        return this;
    }

    public XUIResourceResponse setCurrentVersion(long j) {
        this.mCurrentVersion = j;
        return this;
    }

    public XUIResourceResponse setLatestVersion(long j) {
        this.mLatestVersion = j;
        return this;
    }

    public String toString() {
        return "XUIResourceResponse(mCurrentVersion=" + getCurrentVersion() + ", mLatestVersion=" + getLatestVersion() + ", mCategory=" + getCategory() + ", mContent=" + getContent() + ")";
    }

    public long getCurrentVersion() {
        return this.mCurrentVersion;
    }

    public long getLatestVersion() {
        return this.mLatestVersion;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getContent() {
        return this.mContent;
    }
}
