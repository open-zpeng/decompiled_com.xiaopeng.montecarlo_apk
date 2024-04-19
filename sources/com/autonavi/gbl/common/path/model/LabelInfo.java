package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LabelInfo implements Serializable {
    public String content;
    public String poiid;
    public short type;

    public LabelInfo() {
        this.type = (short) 0;
        this.poiid = "";
        this.content = "";
    }

    public LabelInfo(short s, String str, String str2) {
        this.type = s;
        this.poiid = str;
        this.content = str2;
    }
}
