package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchReviewPicInfo implements Serializable {
    public String desc;
    public String source;
    public String url;

    public SearchReviewPicInfo() {
        this.desc = "";
        this.url = "";
        this.source = "";
    }

    public SearchReviewPicInfo(String str, String str2, String str3) {
        this.desc = str;
        this.url = str2;
        this.source = str3;
    }
}
