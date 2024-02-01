package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgGeoContent implements Serializable {
    private static final long serialVersionUID = 3231047220657287615L;
    public double latitude;
    public String locationName;
    public double longitude;
    public String mimeType;
    public AIMMsgImageFileType picFileType;
    public int picHeight;
    public String picLocalPath;
    public String picMediaId;
    public String picUploadPath;
    public String picUrl;
    public int picWidth;

    public AIMMsgGeoContent(String str, String str2, String str3, String str4, String str5, AIMMsgImageFileType aIMMsgImageFileType, int i, int i2, double d, double d2, String str6) {
        this.picFileType = AIMMsgImageFileType.IMAGE_FILE_TYPE_UNKNOWN;
        this.picWidth = -1;
        this.picHeight = -1;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.picLocalPath = str;
        this.picUploadPath = str2;
        this.mimeType = str3;
        this.picUrl = str4;
        this.picMediaId = str5;
        if (aIMMsgImageFileType != null) {
            this.picFileType = aIMMsgImageFileType;
        }
        this.picWidth = i;
        this.picHeight = i2;
        this.latitude = d;
        this.longitude = d2;
        this.locationName = str6;
    }

    public AIMMsgGeoContent() {
        this.picFileType = AIMMsgImageFileType.IMAGE_FILE_TYPE_UNKNOWN;
        this.picWidth = -1;
        this.picHeight = -1;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
    }

    public String getPicLocalPath() {
        return this.picLocalPath;
    }

    public String getPicUploadPath() {
        return this.picUploadPath;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getPicMediaId() {
        return this.picMediaId;
    }

    public AIMMsgImageFileType getPicFileType() {
        return this.picFileType;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public String toString() {
        return "AIMMsgGeoContent{picLocalPath=" + this.picLocalPath + ",picUploadPath=" + this.picUploadPath + ",mimeType=" + this.mimeType + ",picUrl=" + this.picUrl + ",picMediaId=" + this.picMediaId + ",picFileType=" + this.picFileType + ",picWidth=" + this.picWidth + ",picHeight=" + this.picHeight + ",latitude=" + this.latitude + ",longitude=" + this.longitude + ",locationName=" + this.locationName + "}";
    }
}
