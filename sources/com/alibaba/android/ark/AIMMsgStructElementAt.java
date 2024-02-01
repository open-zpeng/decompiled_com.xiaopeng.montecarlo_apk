package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgStructElementAt implements Serializable {
    private static final long serialVersionUID = 2649813998637046874L;
    public String defaultNick;
    public boolean isAtAll;
    public AIMUserId uid;

    public AIMMsgStructElementAt(boolean z, AIMUserId aIMUserId, String str) {
        this.isAtAll = false;
        this.isAtAll = z;
        this.uid = aIMUserId;
        this.defaultNick = str;
    }

    public AIMMsgStructElementAt() {
        this.isAtAll = false;
    }

    public boolean getIsAtAll() {
        return this.isAtAll;
    }

    public AIMUserId getUid() {
        return this.uid;
    }

    public String getDefaultNick() {
        return this.defaultNick;
    }

    public String toString() {
        return "AIMMsgStructElementAt{isAtAll=" + this.isAtAll + ",uid=" + this.uid + ",defaultNick=" + this.defaultNick + "}";
    }
}
