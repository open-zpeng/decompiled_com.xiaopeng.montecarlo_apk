package com.autonavi.gbl.user.behavior.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ConfigValue implements Serializable {
    public int intValue;
    public String[] strArrayValue;
    public String strValue;

    public ConfigValue() {
        this.intValue = 0;
        this.strValue = "";
        this.strArrayValue = new String[3];
    }

    public ConfigValue(int i, String str, String[] strArr) {
        this.intValue = i;
        this.strValue = str;
        this.strArrayValue = strArr;
    }
}
