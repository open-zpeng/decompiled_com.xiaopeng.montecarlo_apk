package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMsgLocalExtensionUpdateInfo implements Serializable {
    private static final long serialVersionUID = 1738292068739853407L;
    public String cid;
    public HashMap<String, String> extension;
    public String localid;

    public AIMMsgLocalExtensionUpdateInfo(String str, String str2, HashMap<String, String> hashMap) {
        this.cid = str;
        this.localid = str2;
        this.extension = hashMap;
    }

    public AIMMsgLocalExtensionUpdateInfo() {
    }

    public String getCid() {
        return this.cid;
    }

    public String getLocalid() {
        return this.localid;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMMsgLocalExtensionUpdateInfo{cid=" + this.cid + ",localid=" + this.localid + ",extension=" + this.extension + "}";
    }
}
