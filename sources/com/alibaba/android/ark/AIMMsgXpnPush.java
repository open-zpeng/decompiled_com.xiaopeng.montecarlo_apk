package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgXpnPush implements Serializable {
    private static final long serialVersionUID = 7138965674112986166L;
    public String senderNick;
    public String templateId;

    public AIMMsgXpnPush(String str, String str2) {
        this.templateId = str;
        this.senderNick = str2;
    }

    public AIMMsgXpnPush() {
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getSenderNick() {
        return this.senderNick;
    }

    public String toString() {
        return "AIMMsgXpnPush{templateId=" + this.templateId + ",senderNick=" + this.senderNick + "}";
    }
}
