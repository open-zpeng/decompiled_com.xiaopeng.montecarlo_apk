package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupAvatorMediaAuthInfo implements Serializable {
    private static final long serialVersionUID = -2779302182967531694L;
    public String cid;

    public AIMGroupAvatorMediaAuthInfo(String str) {
        this.cid = str;
    }

    public AIMGroupAvatorMediaAuthInfo() {
    }

    public String getCid() {
        return this.cid;
    }

    public String toString() {
        return "AIMGroupAvatorMediaAuthInfo{cid=" + this.cid + "}";
    }
}
