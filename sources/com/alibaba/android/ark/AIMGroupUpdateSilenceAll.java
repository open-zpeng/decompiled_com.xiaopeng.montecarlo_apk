package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupUpdateSilenceAll implements Serializable {
    private static final long serialVersionUID = -3687030329365474423L;
    public String cid;
    public String operatorNick;

    public AIMGroupUpdateSilenceAll(String str, String str2) {
        this.operatorNick = str;
        this.cid = str2;
    }

    public AIMGroupUpdateSilenceAll() {
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getCid() {
        return this.cid;
    }

    public String toString() {
        return "AIMGroupUpdateSilenceAll{operatorNick=" + this.operatorNick + ",cid=" + this.cid + "}";
    }
}
