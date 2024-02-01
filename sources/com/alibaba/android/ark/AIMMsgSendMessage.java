package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMsgSendMessage implements Serializable {
    private static final long serialVersionUID = -8374348083740157820L;
    public HashMap<String, String> callbackCtx;
    public String cid;
    public AIMMsgContent content;
    public HashMap<String, String> extension;
    public boolean groupShare;
    public HashMap<String, String> localExtension;
    public ArrayList<AIMUserId> receivers;
    public AIMMsgXpnPush xpnPush;

    public AIMMsgSendMessage(String str, AIMMsgContent aIMMsgContent, ArrayList<AIMUserId> arrayList, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, AIMMsgXpnPush aIMMsgXpnPush, boolean z) {
        this.groupShare = false;
        this.cid = str;
        this.content = aIMMsgContent;
        this.receivers = arrayList;
        this.extension = hashMap;
        this.localExtension = hashMap2;
        this.callbackCtx = hashMap3;
        this.xpnPush = aIMMsgXpnPush;
        this.groupShare = z;
    }

    public AIMMsgSendMessage() {
        this.groupShare = false;
    }

    public String getCid() {
        return this.cid;
    }

    public AIMMsgContent getContent() {
        return this.content;
    }

    public ArrayList<AIMUserId> getReceivers() {
        return this.receivers;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public HashMap<String, String> getLocalExtension() {
        return this.localExtension;
    }

    public HashMap<String, String> getCallbackCtx() {
        return this.callbackCtx;
    }

    public AIMMsgXpnPush getXpnPush() {
        return this.xpnPush;
    }

    public boolean getGroupShare() {
        return this.groupShare;
    }

    public String toString() {
        return "AIMMsgSendMessage{cid=" + this.cid + ",content=" + this.content + ",receivers=" + this.receivers + ",extension=" + this.extension + ",localExtension=" + this.localExtension + ",callbackCtx=" + this.callbackCtx + ",xpnPush=" + this.xpnPush + ",groupShare=" + this.groupShare + "}";
    }
}
