package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMConvCreateSingleConvParam implements Serializable {
    private static final long serialVersionUID = -465023542994768423L;
    public String bizType;
    public String cid;
    public HashMap<String, String> ctx;
    public HashMap<String, String> ext;
    public boolean isLocal;
    public String pairFirstParentId;
    public String pairSecondParentId;
    public ArrayList<AIMUserId> uids;

    public AIMConvCreateSingleConvParam(String str, String str2, HashMap<String, String> hashMap, ArrayList<AIMUserId> arrayList, HashMap<String, String> hashMap2, boolean z, String str3, String str4) {
        this.isLocal = false;
        this.cid = str;
        this.bizType = str2;
        this.ext = hashMap;
        this.uids = arrayList;
        this.ctx = hashMap2;
        this.isLocal = z;
        this.pairFirstParentId = str3;
        this.pairSecondParentId = str4;
    }

    public AIMConvCreateSingleConvParam() {
        this.isLocal = false;
    }

    public String getCid() {
        return this.cid;
    }

    public String getBizType() {
        return this.bizType;
    }

    public HashMap<String, String> getExt() {
        return this.ext;
    }

    public ArrayList<AIMUserId> getUids() {
        return this.uids;
    }

    public HashMap<String, String> getCtx() {
        return this.ctx;
    }

    public boolean getIsLocal() {
        return this.isLocal;
    }

    public String getPairFirstParentId() {
        return this.pairFirstParentId;
    }

    public String getPairSecondParentId() {
        return this.pairSecondParentId;
    }

    public String toString() {
        return "AIMConvCreateSingleConvParam{cid=" + this.cid + ",bizType=" + this.bizType + ",ext=" + this.ext + ",uids=" + this.uids + ",ctx=" + this.ctx + ",isLocal=" + this.isLocal + ",pairFirstParentId=" + this.pairFirstParentId + ",pairSecondParentId=" + this.pairSecondParentId + "}";
    }
}
