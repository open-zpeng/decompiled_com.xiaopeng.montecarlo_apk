package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMGroupUpdateSilencedWhiteList implements Serializable {
    private static final long serialVersionUID = -2431526830581386319L;
    public String cid;
    public ArrayList<AIMGroupUserInfo> members;
    public String operatorNick;

    public AIMGroupUpdateSilencedWhiteList(String str, String str2, ArrayList<AIMGroupUserInfo> arrayList) {
        this.operatorNick = str;
        this.cid = str2;
        this.members = arrayList;
    }

    public AIMGroupUpdateSilencedWhiteList() {
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
        return "AIMGroupUpdateSilencedWhiteList{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",members=" + this.members + "}";
    }
}
