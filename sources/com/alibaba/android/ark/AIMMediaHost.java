package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMediaHost implements Serializable {
    private static final long serialVersionUID = -4519883499023741302L;
    public String host;
    public AIMMediaHostType type;

    public AIMMediaHost(AIMMediaHostType aIMMediaHostType, String str) {
        this.type = AIMMediaHostType.MEDIA_HOST_TYPE_AUTH;
        if (aIMMediaHostType != null) {
            this.type = aIMMediaHostType;
        }
        this.host = str;
    }

    public AIMMediaHost() {
        this.type = AIMMediaHostType.MEDIA_HOST_TYPE_AUTH;
    }

    public AIMMediaHostType getType() {
        return this.type;
    }

    public String getHost() {
        return this.host;
    }

    public String toString() {
        return "AIMMediaHost{type=" + this.type + ",host=" + this.host + "}";
    }
}
