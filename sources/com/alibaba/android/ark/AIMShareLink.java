package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMShareLink implements Serializable {
    private static final long serialVersionUID = -3792093533092020086L;
    public String desc;
    public String picMediaId;
    public String title;
    public String url;

    public AIMShareLink(String str, String str2, String str3, String str4) {
        this.url = str;
        this.title = str2;
        this.desc = str3;
        this.picMediaId = str4;
    }

    public AIMShareLink() {
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getPicMediaId() {
        return this.picMediaId;
    }

    public String toString() {
        return "AIMShareLink{url=" + this.url + ",title=" + this.title + ",desc=" + this.desc + ",picMediaId=" + this.picMediaId + "}";
    }
}
