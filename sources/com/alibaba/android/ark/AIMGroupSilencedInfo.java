package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMGroupSilencedInfo implements Serializable {
    private static final long serialVersionUID = -3506472172727837191L;
    public ArrayList<AIMGroupSilencedBlackListMemberInfo> blacklistInfo;
    public String cid;
    public ArrayList<AIMGroupSilencedWhiteListMemberInfo> whitelist;

    public AIMGroupSilencedInfo(String str, ArrayList<AIMGroupSilencedBlackListMemberInfo> arrayList, ArrayList<AIMGroupSilencedWhiteListMemberInfo> arrayList2) {
        this.cid = str;
        this.blacklistInfo = arrayList;
        this.whitelist = arrayList2;
    }

    public AIMGroupSilencedInfo() {
    }

    public String getCid() {
        return this.cid;
    }

    public ArrayList<AIMGroupSilencedBlackListMemberInfo> getBlacklistInfo() {
        return this.blacklistInfo;
    }

    public ArrayList<AIMGroupSilencedWhiteListMemberInfo> getWhitelist() {
        return this.whitelist;
    }

    public String toString() {
        return "AIMGroupSilencedInfo{cid=" + this.cid + ",blacklistInfo=" + this.blacklistInfo + ",whitelist=" + this.whitelist + "}";
    }
}
