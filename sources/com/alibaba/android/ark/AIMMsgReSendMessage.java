package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMsgReSendMessage implements Serializable {
    private static final long serialVersionUID = -1900922123145539696L;
    public HashMap<String, String> callbackCtx;
    public String cid;
    public String localid;

    public AIMMsgReSendMessage(String str, String str2, HashMap<String, String> hashMap) {
        this.cid = str;
        this.localid = str2;
        this.callbackCtx = hashMap;
    }

    public AIMMsgReSendMessage() {
    }

    public String getCid() {
        return this.cid;
    }

    public String getLocalid() {
        return this.localid;
    }

    public HashMap<String, String> getCallbackCtx() {
        return this.callbackCtx;
    }

    public String toString() {
        return "AIMMsgReSendMessage{cid=" + this.cid + ",localid=" + this.localid + ",callbackCtx=" + this.callbackCtx + "}";
    }
}
