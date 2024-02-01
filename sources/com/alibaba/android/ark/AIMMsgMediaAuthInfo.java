package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgMediaAuthInfo implements Serializable {
    private static final long serialVersionUID = -786229484041132297L;
    public String cid;
    public String mid;

    public AIMMsgMediaAuthInfo(String str, String str2) {
        this.cid = str;
        this.mid = str2;
    }

    public AIMMsgMediaAuthInfo() {
    }

    public String getCid() {
        return this.cid;
    }

    public String getMid() {
        return this.mid;
    }

    public String toString() {
        return "AIMMsgMediaAuthInfo{cid=" + this.cid + ",mid=" + this.mid + "}";
    }
}
