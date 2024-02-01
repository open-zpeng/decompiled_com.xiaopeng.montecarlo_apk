package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TipInfo implements Serializable {
    public String tip;
    public short type;

    public TipInfo() {
        this.tip = "";
        this.type = (short) 0;
    }

    public TipInfo(String str, short s) {
        this.tip = str;
        this.type = s;
    }
}
