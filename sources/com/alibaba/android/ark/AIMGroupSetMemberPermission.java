package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupSetMemberPermission implements Serializable {
    private static final long serialVersionUID = 1899094375331760012L;
    public String cid;
    public AIMGroupPermission memberPermission;
    public String operatorNick;

    public AIMGroupSetMemberPermission(String str, String str2, AIMGroupPermission aIMGroupPermission) {
        this.cid = str;
        this.operatorNick = str2;
        this.memberPermission = aIMGroupPermission;
    }

    public AIMGroupSetMemberPermission() {
    }

    public String getCid() {
        return this.cid;
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public AIMGroupPermission getMemberPermission() {
        return this.memberPermission;
    }

    public String toString() {
        return "AIMGroupSetMemberPermission{cid=" + this.cid + ",operatorNick=" + this.operatorNick + ",memberPermission=" + this.memberPermission + "}";
    }
}
