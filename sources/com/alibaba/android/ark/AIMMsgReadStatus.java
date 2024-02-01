package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMMsgReadStatus implements Serializable {
    private static final long serialVersionUID = 5182081095530477248L;
    public String cid;
    public String mid;
    public ArrayList<AIMUserId> readUids;
    public ArrayList<AIMUserId> unreadUids;

    public AIMMsgReadStatus(String str, String str2, ArrayList<AIMUserId> arrayList, ArrayList<AIMUserId> arrayList2) {
        this.cid = str;
        this.mid = str2;
        this.readUids = arrayList;
        this.unreadUids = arrayList2;
    }

    public AIMMsgReadStatus() {
    }

    public String getCid() {
        return this.cid;
    }

    public String getMid() {
        return this.mid;
    }

    public ArrayList<AIMUserId> getReadUids() {
        return this.readUids;
    }

    public ArrayList<AIMUserId> getUnreadUids() {
        return this.unreadUids;
    }

    public String toString() {
        return "AIMMsgReadStatus{cid=" + this.cid + ",mid=" + this.mid + ",readUids=" + this.readUids + ",unreadUids=" + this.unreadUids + "}";
    }
}
