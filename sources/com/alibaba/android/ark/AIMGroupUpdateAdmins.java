package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMGroupUpdateAdmins implements Serializable {
    private static final long serialVersionUID = -2431526830581386319L;
    public String cid;
    public ArrayList<AIMGroupUserInfo> members;
    public String operatorNick;

    public AIMGroupUpdateAdmins(String str, String str2, ArrayList<AIMGroupUserInfo> arrayList) {
        this.operatorNick = str;
        this.cid = str2;
        this.members = arrayList;
    }

    public AIMGroupUpdateAdmins() {
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getCid() {
        return this.cid;
    }

    public ArrayList<AIMGroupUserInfo> getMembers() {
        return this.members;
    }

    public String toString() {
        return "AIMGroupUpdateAdmins{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",members=" + this.members + "}";
    }
}
