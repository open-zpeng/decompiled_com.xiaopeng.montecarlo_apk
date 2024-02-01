package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMParentConversationInfo implements Serializable {
    private static final long serialVersionUID = -2352269721825641663L;
    public AIMConversation convModel;
    public String parentConvProperty;
    public String parentId;

    public AIMParentConversationInfo(String str, String str2, AIMConversation aIMConversation) {
        this.parentId = str;
        this.parentConvProperty = str2;
        this.convModel = aIMConversation;
    }

    public AIMParentConversationInfo() {
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getParentConvProperty() {
        return this.parentConvProperty;
    }

    public AIMConversation getConvModel() {
        return this.convModel;
    }

    public String toString() {
        return "AIMParentConversationInfo{parentId=" + this.parentId + ",parentConvProperty=" + this.parentConvProperty + ",convModel=" + this.convModel + "}";
    }
}
