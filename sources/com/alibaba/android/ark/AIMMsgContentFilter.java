package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgContentFilter implements Serializable {
    private static final long serialVersionUID = 2757903873889908490L;
    public int contentType;
    public String customContentType;

    public AIMMsgContentFilter(int i, String str) {
        this.contentType = -1;
        this.contentType = i;
        this.customContentType = str;
    }

    public AIMMsgContentFilter() {
        this.contentType = -1;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getCustomContentType() {
        return this.customContentType;
    }

    public String toString() {
        return "AIMMsgContentFilter{contentType=" + this.contentType + ",customContentType=" + this.customContentType + "}";
    }
}
