package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgCustomContent implements Serializable {
    private static final long serialVersionUID = -2211244513483980714L;
    public byte[] binaryData;
    public String degrade;
    public String summary;
    public String title;
    public int type;

    public AIMMsgCustomContent(int i, byte[] bArr, String str, String str2, String str3) {
        this.type = 0;
        this.type = i;
        this.binaryData = bArr;
        this.title = str;
        this.summary = str2;
        this.degrade = str3;
    }

    public AIMMsgCustomContent() {
        this.type = 0;
    }

    public int getType() {
        return this.type;
    }

    public byte[] getBinaryData() {
        return this.binaryData;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDegrade() {
        return this.degrade;
    }

    public String toString() {
        return "AIMMsgCustomContent{type=" + this.type + ",binaryData=" + this.binaryData + ",title=" + this.title + ",summary=" + this.summary + ",degrade=" + this.degrade + "}";
    }
}
