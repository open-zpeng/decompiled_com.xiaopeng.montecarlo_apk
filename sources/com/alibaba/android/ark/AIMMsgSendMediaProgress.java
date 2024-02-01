package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgSendMediaProgress implements Serializable {
    private static final long serialVersionUID = -367279389921062781L;
    public String cid;
    public String localid;
    public double progress;

    public AIMMsgSendMediaProgress(String str, String str2, double d) {
        this.progress = 0.0d;
        this.cid = str;
        this.localid = str2;
        this.progress = d;
    }

    public AIMMsgSendMediaProgress() {
        this.progress = 0.0d;
    }

    public String getCid() {
        return this.cid;
    }

    public String getLocalid() {
        return this.localid;
    }

    public double getProgress() {
        return this.progress;
    }

    public String toString() {
        return "AIMMsgSendMediaProgress{cid=" + this.cid + ",localid=" + this.localid + ",progress=" + this.progress + "}";
    }
}
