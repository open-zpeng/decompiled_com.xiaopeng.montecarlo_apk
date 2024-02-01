package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMGroupJoin implements Serializable {
    private static final long serialVersionUID = -4682972188020992305L;
    public String cid;
    public String operatorNick;
    public ArrayList<AIMGroupUserInfo> users;

    public AIMGroupJoin(String str, String str2, ArrayList<AIMGroupUserInfo> arrayList) {
        this.operatorNick = str;
        this.cid = str2;
        this.users = arrayList;
    }

    public AIMGroupJoin() {
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getCid() {
        return this.cid;
    }

    public ArrayList<AIMGroupUserInfo> getUsers() {
        return this.users;
    }

    public String toString() {
        return "AIMGroupJoin{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",users=" + this.users + "}";
    }
}
