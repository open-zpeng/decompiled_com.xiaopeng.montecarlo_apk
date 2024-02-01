package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgVideoContent implements Serializable {
    private static final long serialVersionUID = 2662444634905814516L;
    public AIMMsgImageFileType coverFileType;
    public int coverHeight;
    public String coverLocalPath;
    public String coverMediaId;
    public String coverMimeType;
    public String coverUploadPath;
    public String coverUrl;
    public int coverWidth;
    public long duration;
    public String fileName;
    public long fileSize;
    public String fileType;
    public int height;
    public String localPath;
    public String mediaId;
    public String mimeType;
    public String uploadPath;
    public String url;
    public int width;

    public AIMMsgVideoContent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, AIMMsgImageFileType aIMMsgImageFileType, String str10, String str11, String str12, long j, long j2, int i, int i2, int i3, int i4) {
        this.coverFileType = AIMMsgImageFileType.IMAGE_FILE_TYPE_UNKNOWN;
        this.fileSize = -1L;
        this.duration = -1L;
        this.height = -1;
        this.width = -1;
        this.coverWidth = -1;
        this.coverHeight = -1;
        this.localPath = str;
        this.uploadPath = str2;
        this.mimeType = str3;
        this.url = str4;
        this.mediaId = str5;
        this.coverLocalPath = str6;
        this.coverUploadPath = str7;
        this.coverUrl = str8;
        this.coverMediaId = str9;
        if (aIMMsgImageFileType != null) {
            this.coverFileType = aIMMsgImageFileType;
        }
        this.coverMimeType = str10;
        this.fileName = str11;
        this.fileType = str12;
        this.fileSize = j;
        this.duration = j2;
        this.height = i;
        this.width = i2;
        this.coverWidth = i3;
        this.coverHeight = i4;
    }

    public AIMMsgVideoContent() {
        this.coverFileType = AIMMsgImageFileType.IMAGE_FILE_TYPE_UNKNOWN;
        this.fileSize = -1L;
        this.duration = -1L;
        this.height = -1;
        this.width = -1;
        this.coverWidth = -1;
        this.coverHeight = -1;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getUploadPath() {
        return this.uploadPath;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getCoverLocalPath() {
        return this.coverLocalPath;
    }

    public String getCoverUploadPath() {
        return this.coverUploadPath;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getCoverMediaId() {
        return this.coverMediaId;
    }

    public AIMMsgImageFileType getCoverFileType() {
        return this.coverFileType;
    }

    public String getCoverMimeType() {
        return this.coverMimeType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getCoverWidth() {
        return this.coverWidth;
    }

    public int getCoverHeight() {
        return this.coverHeight;
    }

    public String toString() {
        return "AIMMsgVideoContent{localPath=" + this.localPath + ",uploadPath=" + this.uploadPath + ",mimeType=" + this.mimeType + ",url=" + this.url + ",mediaId=" + this.mediaId + ",coverLocalPath=" + this.coverLocalPath + ",coverUploadPath=" + this.coverUploadPath + ",coverUrl=" + this.coverUrl + ",coverMediaId=" + this.coverMediaId + ",coverFileType=" + this.coverFileType + ",coverMimeType=" + this.coverMimeType + ",fileName=" + this.fileName + ",fileType=" + this.fileType + ",fileSize=" + this.fileSize + ",duration=" + this.duration + ",height=" + this.height + ",width=" + this.width + ",coverWidth=" + this.coverWidth + ",coverHeight=" + this.coverHeight + "}";
    }
}
