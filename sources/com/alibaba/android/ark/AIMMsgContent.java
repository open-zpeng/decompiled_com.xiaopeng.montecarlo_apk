package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgContent implements Serializable {
    private static final long serialVersionUID = 7273964921128734624L;
    public AIMMsgAudioContent audioContent;
    public AIMMsgContentType contentType;
    public AIMMsgCustomContent customContent;
    public AIMMsgGeoContent geoContent;
    public AIMMsgImageContent imageContent;
    public AIMMsgLinkContent linkContent;
    public AIMMsgStructContent structContent;
    public AIMMsgTextContent textContent;
    public AIMMsgVideoContent videoContent;

    public AIMMsgContent(AIMMsgContentType aIMMsgContentType, AIMMsgTextContent aIMMsgTextContent, AIMMsgImageContent aIMMsgImageContent, AIMMsgAudioContent aIMMsgAudioContent, AIMMsgVideoContent aIMMsgVideoContent, AIMMsgGeoContent aIMMsgGeoContent, AIMMsgCustomContent aIMMsgCustomContent, AIMMsgStructContent aIMMsgStructContent, AIMMsgLinkContent aIMMsgLinkContent) {
        this.contentType = AIMMsgContentType.CONTENT_TYPE_UNKNOW;
        if (aIMMsgContentType != null) {
            this.contentType = aIMMsgContentType;
        }
        this.textContent = aIMMsgTextContent;
        this.imageContent = aIMMsgImageContent;
        this.audioContent = aIMMsgAudioContent;
        this.videoContent = aIMMsgVideoContent;
        this.geoContent = aIMMsgGeoContent;
        this.customContent = aIMMsgCustomContent;
        this.structContent = aIMMsgStructContent;
        this.linkContent = aIMMsgLinkContent;
    }

    public AIMMsgContent() {
        this.contentType = AIMMsgContentType.CONTENT_TYPE_UNKNOW;
    }

    public AIMMsgContentType getContentType() {
        return this.contentType;
    }

    public AIMMsgTextContent getTextContent() {
        return this.textContent;
    }

    public AIMMsgImageContent getImageContent() {
        return this.imageContent;
    }

    public AIMMsgAudioContent getAudioContent() {
        return this.audioContent;
    }

    public AIMMsgVideoContent getVideoContent() {
        return this.videoContent;
    }

    public AIMMsgGeoContent getGeoContent() {
        return this.geoContent;
    }

    public AIMMsgCustomContent getCustomContent() {
        return this.customContent;
    }

    public AIMMsgStructContent getStructContent() {
        return this.structContent;
    }

    public AIMMsgLinkContent getLinkContent() {
        return this.linkContent;
    }

    public String toString() {
        return "AIMMsgContent{contentType=" + this.contentType + ",textContent=" + this.textContent + ",imageContent=" + this.imageContent + ",audioContent=" + this.audioContent + ",videoContent=" + this.videoContent + ",geoContent=" + this.geoContent + ",customContent=" + this.customContent + ",structContent=" + this.structContent + ",linkContent=" + this.linkContent + "}";
    }
}
