package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupUpdateTitle implements Serializable {
    private static final long serialVersionUID = 1301969160813141184L;
    public String cid;
    public String operatorNick;
    public String title;

    public AIMGroupUpdateTitle(String str, String str2, String str3) {
        this.operatorNick = str;
        this.cid = str2;
        this.title = str3;
    }

    public AIMGroupUpdateTitle() {
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getCid() {
        return this.cid;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "AIMGroupUpdateTitle{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",title=" + this.title + "}";
    }
}
