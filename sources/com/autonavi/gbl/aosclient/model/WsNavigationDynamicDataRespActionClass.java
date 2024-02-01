package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespActionClass implements Serializable {
    public String params;
    public String text;
    public String type;

    public WsNavigationDynamicDataRespActionClass() {
        this.text = "";
        this.type = "";
        this.params = "";
    }

    public WsNavigationDynamicDataRespActionClass(String str, String str2, String str3) {
        this.text = str;
        this.type = str2;
        this.params = str3;
    }
}
