package com.alibaba.android.ark;
/* loaded from: classes.dex */
public final class AIMTraceConvInfo {
    public String bizType;
    public String cid;
    public String targetUid;

    public AIMTraceConvInfo(String str, String str2, String str3) {
        this.cid = str;
        this.bizType = str2;
        this.targetUid = str3;
    }

    public AIMTraceConvInfo() {
    }

    public String getCid() {
        return this.cid;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getTargetUid() {
        return this.targetUid;
    }

    public String toString() {
        return "AIMTraceConvInfo{cid=" + this.cid + ",bizType=" + this.bizType + ",targetUid=" + this.targetUid + "}";
    }
}
