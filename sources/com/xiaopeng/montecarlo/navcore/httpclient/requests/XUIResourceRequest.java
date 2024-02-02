package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
/* loaded from: classes2.dex */
public class XUIResourceRequest {
    @SerializedName("attrs")
    private Map<String, String> mAttrs;
    @SerializedName("category")
    private String mCategory = "1050100";
    @SerializedName("current_version")
    private Long mCurrentVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof XUIResourceRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XUIResourceRequest) {
            XUIResourceRequest xUIResourceRequest = (XUIResourceRequest) obj;
            if (xUIResourceRequest.canEqual(this)) {
                Long currentVersion = getCurrentVersion();
                Long currentVersion2 = xUIResourceRequest.getCurrentVersion();
                if (currentVersion != null ? currentVersion.equals(currentVersion2) : currentVersion2 == null) {
                    Map<String, String> attrs = getAttrs();
                    Map<String, String> attrs2 = xUIResourceRequest.getAttrs();
                    if (attrs != null ? attrs.equals(attrs2) : attrs2 == null) {
                        String category = getCategory();
                        String category2 = xUIResourceRequest.getCategory();
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
        Long currentVersion = getCurrentVersion();
        int hashCode = currentVersion == null ? 43 : currentVersion.hashCode();
        Map<String, String> attrs = getAttrs();
        int hashCode2 = ((hashCode + 59) * 59) + (attrs == null ? 43 : attrs.hashCode());
        String category = getCategory();
        return (hashCode2 * 59) + (category != null ? category.hashCode() : 43);
    }

    public XUIResourceRequest setAttrs(Map<String, String> map) {
        this.mAttrs = map;
        return this;
    }

    public XUIResourceRequest setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public XUIResourceRequest setCurrentVersion(Long l) {
        this.mCurrentVersion = l;
        return this;
    }

    public String toString() {
        return "XUIResourceRequest(mAttrs=" + getAttrs() + ", mCurrentVersion=" + getCurrentVersion() + ", mCategory=" + getCategory() + ")";
    }

    public Map<String, String> getAttrs() {
        return this.mAttrs;
    }

    public Long getCurrentVersion() {
        return this.mCurrentVersion;
    }

    public String getCategory() {
        return this.mCategory;
    }
}
