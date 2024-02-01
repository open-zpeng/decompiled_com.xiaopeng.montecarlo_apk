package com.alibaba.android.ark;
/* loaded from: classes.dex */
public final class AIMMsgKeyInfo {
    public String cid;
    public String mid;

    public AIMMsgKeyInfo(String str, String str2) {
        this.mid = str;
        this.cid = str2;
    }

    public AIMMsgKeyInfo() {
    }

    public String getMid() {
        return this.mid;
    }

    public String getCid() {
        return this.cid;
    }

    public String toString() {
        return "AIMMsgKeyInfo{mid=" + this.mid + ",cid=" + this.cid + "}";
    }
}
