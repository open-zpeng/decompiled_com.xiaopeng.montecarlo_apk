package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchGalleryInfo implements Serializable {
    public String dataType;
    public String srcType;
    public String url;

    public SearchGalleryInfo() {
        this.srcType = "";
        this.url = "";
        this.dataType = "";
    }

    public SearchGalleryInfo(String str, String str2, String str3) {
        this.srcType = str;
        this.url = str2;
        this.dataType = str3;
    }
}
