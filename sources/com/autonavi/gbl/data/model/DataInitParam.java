package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DataInitParam implements Serializable {
    public String strName;
    public String strValue;

    public DataInitParam() {
        this.strName = "";
        this.strValue = "";
    }

    public DataInitParam(String str, String str2) {
        this.strName = str;
        this.strValue = str2;
    }
}
