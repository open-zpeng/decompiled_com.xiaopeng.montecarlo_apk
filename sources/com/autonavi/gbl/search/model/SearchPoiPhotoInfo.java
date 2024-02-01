package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiPhotoInfo implements Serializable {
    public String pic_id;
    public String src_type;
    public String url;

    public SearchPoiPhotoInfo() {
        this.url = "";
        this.pic_id = "";
        this.src_type = "";
    }

    public SearchPoiPhotoInfo(String str, String str2, String str3) {
        this.url = str;
        this.pic_id = str2;
        this.src_type = str3;
    }
}
