package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class HttpHeaderKeyValue implements Serializable {
    public String key;
    public String value;

    public HttpHeaderKeyValue() {
        this.key = "";
        this.value = "";
    }

    public HttpHeaderKeyValue(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
