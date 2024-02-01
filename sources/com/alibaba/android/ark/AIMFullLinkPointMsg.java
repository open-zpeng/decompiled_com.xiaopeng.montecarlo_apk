package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMFullLinkPointMsg {
    public AIMFullLinkPointBase basePoint;
    public ArrayList<AIMTraceMsgInfo> msgInfos;

    public AIMFullLinkPointMsg(AIMFullLinkPointBase aIMFullLinkPointBase, ArrayList<AIMTraceMsgInfo> arrayList) {
        this.basePoint = aIMFullLinkPointBase;
        this.msgInfos = arrayList;
    }

    public AIMFullLinkPointMsg() {
    }

    public AIMFullLinkPointBase getBasePoint() {
        return this.basePoint;
    }

    public ArrayList<AIMTraceMsgInfo> getMsgInfos() {
        return this.msgInfos;
    }

    public String toString() {
        return "AIMFullLinkPointMsg{basePoint=" + this.basePoint + ",msgInfos=" + this.msgInfos + "}";
    }
}
