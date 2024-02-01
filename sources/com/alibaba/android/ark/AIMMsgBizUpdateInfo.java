package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgBizUpdateInfo implements Serializable {
    private static final long serialVersionUID = 99842092098319435L;
    public AIMMsgBizInfo bizInfo;
    public String cid;
    public String localid;
    public AIMMsgUpdateMode updateMode;

    public AIMMsgBizUpdateInfo(String str, String str2, AIMMsgUpdateMode aIMMsgUpdateMode, AIMMsgBizInfo aIMMsgBizInfo) {
        this.updateMode = AIMMsgUpdateMode.UPDATE_ALL;
        this.cid = str;
        this.localid = str2;
        if (aIMMsgUpdateMode != null) {
            this.updateMode = aIMMsgUpdateMode;
        }
        this.bizInfo = aIMMsgBizInfo;
    }

    public AIMMsgBizUpdateInfo() {
        this.updateMode = AIMMsgUpdateMode.UPDATE_ALL;
    }

    public String getCid() {
        return this.cid;
    }

    public String getLocalid() {
        return this.localid;
    }

    public AIMMsgUpdateMode getUpdateMode() {
        return this.updateMode;
    }

    public AIMMsgBizInfo getBizInfo() {
        return this.bizInfo;
    }

    public String toString() {
        return "AIMMsgBizUpdateInfo{cid=" + this.cid + ",localid=" + this.localid + ",updateMode=" + this.updateMode + ",bizInfo=" + this.bizInfo + "}";
    }
}
