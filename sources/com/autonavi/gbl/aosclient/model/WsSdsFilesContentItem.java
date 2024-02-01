package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsSdsFilesContentItem implements Serializable {
    public String link;
    public String md5;
    public String name;
    public int size;

    public WsSdsFilesContentItem() {
        this.name = "";
        this.md5 = "";
        this.size = 0;
        this.link = "";
    }

    public WsSdsFilesContentItem(String str, String str2, int i, String str3) {
        this.name = str;
        this.md5 = str2;
        this.size = i;
        this.link = str3;
    }
}
