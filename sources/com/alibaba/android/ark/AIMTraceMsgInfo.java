package com.alibaba.android.ark;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMTraceMsgInfo {
    public String bizChainId;
    public String cid;
    public HashMap<String, String> extension;
    public String msgId;
    public String msgType;
    public String receiver;
    public String sender;

    public AIMTraceMsgInfo(String str, String str2, String str3, String str4, String str5, String str6, HashMap<String, String> hashMap) {
        this.cid = str;
        this.msgId = str2;
        this.bizChainId = str3;
        this.msgType = str4;
        this.sender = str5;
        this.receiver = str6;
        this.extension = hashMap;
    }

    public AIMTraceMsgInfo() {
    }

    public String getCid() {
        return this.cid;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getBizChainId() {
        return this.bizChainId;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public String getSender() {
        return this.sender;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMTraceMsgInfo{cid=" + this.cid + ",msgId=" + this.msgId + ",bizChainId=" + this.bizChainId + ",msgType=" + this.msgType + ",sender=" + this.sender + ",receiver=" + this.receiver + ",extension=" + this.extension + "}";
    }
}
