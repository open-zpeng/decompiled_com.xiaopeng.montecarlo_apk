package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMUserId implements Serializable {
    private static final long serialVersionUID = -7284978217354499482L;
    public String domain;
    public String uid;

    public AIMUserId(String str, String str2) {
        this.uid = str;
        this.domain = str2;
    }

    public AIMUserId() {
    }

    public String getUid() {
        return this.uid;
    }

    public String getDomain() {
        return this.domain;
    }

    public String toString() {
        return "AIMUserId{uid=" + this.uid + ",domain=" + this.domain + "}";
    }
}
