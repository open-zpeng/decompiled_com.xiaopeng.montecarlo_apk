package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMsgLinkContent implements Serializable {
    private static final long serialVersionUID = -3943581329527170059L;
    public String desc;
    public HashMap<String, String> extension;
    public String picMediaId;
    public String title;
    public String url;

    public AIMMsgLinkContent(String str, String str2, String str3, String str4, HashMap<String, String> hashMap) {
        this.url = str;
        this.title = str2;
        this.desc = str3;
        this.picMediaId = str4;
        this.extension = hashMap;
    }

    public AIMMsgLinkContent() {
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

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMMsgLinkContent{url=" + this.url + ",title=" + this.title + ",desc=" + this.desc + ",picMediaId=" + this.picMediaId + ",extension=" + this.extension + "}";
    }
}
