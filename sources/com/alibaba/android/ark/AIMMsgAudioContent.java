package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgAudioContent implements Serializable {
    private static final long serialVersionUID = 8327191143264808589L;
    public AIMMsgAudioType audioType;
    public byte[] binaryData;
    public long duration;
    public String localPath;
    public String mediaId;
    public String mimeType;
    public String uploadPath;
    public String url;

    public AIMMsgAudioContent(String str, String str2, String str3, String str4, String str5, byte[] bArr, AIMMsgAudioType aIMMsgAudioType, long j) {
        this.audioType = AIMMsgAudioType.AUDIO_TYPE_UNKNOWN;
        this.duration = 0L;
        this.localPath = str;
        this.uploadPath = str2;
        this.mimeType = str3;
        this.url = str4;
        this.mediaId = str5;
        this.binaryData = bArr;
        if (aIMMsgAudioType != null) {
            this.audioType = aIMMsgAudioType;
        }
        this.duration = j;
    }

    public AIMMsgAudioContent() {
        this.audioType = AIMMsgAudioType.AUDIO_TYPE_UNKNOWN;
        this.duration = 0L;
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

    public byte[] getBinaryData() {
        return this.binaryData;
    }

    public AIMMsgAudioType getAudioType() {
        return this.audioType;
    }

    public long getDuration() {
        return this.duration;
    }

    public String toString() {
        return "AIMMsgAudioContent{localPath=" + this.localPath + ",uploadPath=" + this.uploadPath + ",mimeType=" + this.mimeType + ",url=" + this.url + ",mediaId=" + this.mediaId + ",binaryData=" + this.binaryData + ",audioType=" + this.audioType + ",duration=" + this.duration + "}";
    }
}
