package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgBizInfo implements Serializable {
    private static final long serialVersionUID = -2070582339594290782L;
    public String bizTag;
    public String bizText;

    public AIMMsgBizInfo(String str, String str2) {
        this.bizTag = str;
        this.bizText = str2;
    }

    public AIMMsgBizInfo() {
    }

    public String getBizTag() {
        return this.bizTag;
    }

    public String getBizText() {
        return this.bizText;
    }

    public String toString() {
        return "AIMMsgBizInfo{bizTag=" + this.bizTag + ",bizText=" + this.bizText + "}";
    }
}
