package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupUpdateIcon implements Serializable {
    private static final long serialVersionUID = 5027519935945005822L;
    public String cid;
    public String icon;
    public String operatorNick;

    public AIMGroupUpdateIcon(String str, String str2, String str3) {
        this.operatorNick = str;
        this.cid = str2;
        this.icon = str3;
    }

    public AIMGroupUpdateIcon() {
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getCid() {
        return this.cid;
    }

    public String getIcon() {
        return this.icon;
    }

    public String toString() {
        return "AIMGroupUpdateIcon{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",icon=" + this.icon + "}";
    }
}
