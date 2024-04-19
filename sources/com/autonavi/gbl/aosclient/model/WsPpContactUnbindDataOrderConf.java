package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsPpContactUnbindDataOrderConf implements Serializable {
    public String cancel_text;
    public String ok_text;
    public String schema;
    public String text;

    public WsPpContactUnbindDataOrderConf() {
        this.schema = "";
        this.text = "";
        this.ok_text = "";
        this.cancel_text = "";
    }

    public WsPpContactUnbindDataOrderConf(String str, String str2, String str3, String str4) {
        this.schema = str;
        this.text = str2;
        this.ok_text = str3;
        this.cancel_text = str4;
    }
}
