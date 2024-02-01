package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgStructElementUid implements Serializable {
    private static final long serialVersionUID = -4553744696086986603L;
    public String defaultNick;
    public String prefix;
    public AIMUserId uid;

    public AIMMsgStructElementUid(AIMUserId aIMUserId, String str, String str2) {
        this.uid = aIMUserId;
        this.defaultNick = str;
        this.prefix = str2;
    }

    public AIMMsgStructElementUid() {
    }

    public AIMUserId getUid() {
        return this.uid;
    }

    public String getDefaultNick() {
        return this.defaultNick;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String toString() {
        return "AIMMsgStructElementUid{uid=" + this.uid + ",defaultNick=" + this.defaultNick + ",prefix=" + this.prefix + "}";
    }
}
