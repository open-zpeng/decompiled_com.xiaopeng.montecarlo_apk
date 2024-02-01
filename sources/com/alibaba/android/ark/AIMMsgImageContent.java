package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMsgImageContent implements Serializable {
    private static final long serialVersionUID = -3446957660644080118L;
    public byte[] blurredData;
    public HashMap<String, String> extension;
    public String fileName;
    public AIMMsgImageFileType fileType;
    public int height;
    public String localPath;
    public String mediaId;
    public String mimeType;
    public AIMMsgOrientation orientation;
    public String originalUrl;
    public int size;
    public String thumbnailUrl;
    public AIMMsgImageCompressType type;
    public String uploadPath;
    public int width;

    public AIMMsgImageContent(String str, String str2, String str3, String str4, String str5, byte[] bArr, String str6, String str7, int i, int i2, int i3, AIMMsgImageCompressType aIMMsgImageCompressType, AIMMsgImageFileType aIMMsgImageFileType, AIMMsgOrientation aIMMsgOrientation, HashMap<String, String> hashMap) {
        this.height = -1;
        this.width = -1;
        this.size = -1;
        this.type = AIMMsgImageCompressType.IMAGE_COMPRESS_TYPE_UNKNOWN;
        this.fileType = AIMMsgImageFileType.IMAGE_FILE_TYPE_UNKNOWN;
        this.orientation = AIMMsgOrientation.ORIENTATION_UNKNOWN;
        this.localPath = str;
        this.uploadPath = str2;
        this.mimeType = str3;
        this.originalUrl = str4;
        this.thumbnailUrl = str5;
        this.blurredData = bArr;
        this.mediaId = str6;
        this.fileName = str7;
        this.height = i;
        this.width = i2;
        this.size = i3;
        if (aIMMsgImageCompressType != null) {
            this.type = aIMMsgImageCompressType;
        }
        if (aIMMsgImageFileType != null) {
            this.fileType = aIMMsgImageFileType;
        }
        if (aIMMsgOrientation != null) {
            this.orientation = aIMMsgOrientation;
        }
        this.extension = hashMap;
    }

    public AIMMsgImageContent() {
        this.height = -1;
        this.width = -1;
        this.size = -1;
        this.type = AIMMsgImageCompressType.IMAGE_COMPRESS_TYPE_UNKNOWN;
        this.fileType = AIMMsgImageFileType.IMAGE_FILE_TYPE_UNKNOWN;
        this.orientation = AIMMsgOrientation.ORIENTATION_UNKNOWN;
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

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public byte[] getBlurredData() {
        return this.blurredData;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getSize() {
        return this.size;
    }

    public AIMMsgImageCompressType getType() {
        return this.type;
    }

    public AIMMsgImageFileType getFileType() {
        return this.fileType;
    }

    public AIMMsgOrientation getOrientation() {
        return this.orientation;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMMsgImageContent{localPath=" + this.localPath + ",uploadPath=" + this.uploadPath + ",mimeType=" + this.mimeType + ",originalUrl=" + this.originalUrl + ",thumbnailUrl=" + this.thumbnailUrl + ",blurredData=" + this.blurredData + ",mediaId=" + this.mediaId + ",fileName=" + this.fileName + ",height=" + this.height + ",width=" + this.width + ",size=" + this.size + ",type=" + this.type + ",fileType=" + this.fileType + ",orientation=" + this.orientation + ",extension=" + this.extension + "}";
    }
}
