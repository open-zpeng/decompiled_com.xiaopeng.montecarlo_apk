package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class KeyValue implements Serializable {
    public String key;
    public String value;

    public KeyValue() {
        this.key = "";
        this.value = "";
    }

    public KeyValue(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
