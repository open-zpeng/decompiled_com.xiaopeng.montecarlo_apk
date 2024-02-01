package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupSetOwner implements Serializable {
    private static final long serialVersionUID = -842631821870498711L;
    public String cid;
    public String operatorNick;
    public AIMGroupUserInfo owner;

    public AIMGroupSetOwner(String str, String str2, AIMGroupUserInfo aIMGroupUserInfo) {
        this.operatorNick = str;
        this.cid = str2;
        this.owner = aIMGroupUserInfo;
    }

    public AIMGroupSetOwner() {
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getCid() {
        return this.cid;
    }

    public AIMGroupUserInfo getOwner() {
        return this.owner;
    }

    public String toString() {
        return "AIMGroupSetOwner{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",owner=" + this.owner + "}";
    }
}
