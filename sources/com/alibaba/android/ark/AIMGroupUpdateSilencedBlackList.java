package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMGroupUpdateSilencedBlackList implements Serializable {
    private static final long serialVersionUID = 12468225701852859L;
    public String cid;
    public long duration;
    public ArrayList<AIMGroupUserInfo> members;
    public String operatorNick;

    public AIMGroupUpdateSilencedBlackList(String str, String str2, ArrayList<AIMGroupUserInfo> arrayList, long j) {
        this.duration = 0L;
        this.operatorNick = str;
        this.cid = str2;
        this.members = arrayList;
        this.duration = j;
    }

    public AIMGroupUpdateSilencedBlackList() {
        this.duration = 0L;
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

    public long getDuration() {
        return this.duration;
    }

    public String toString() {
        return "AIMGroupUpdateSilencedBlackList{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",members=" + this.members + ",duration=" + this.duration + "}";
    }
}
