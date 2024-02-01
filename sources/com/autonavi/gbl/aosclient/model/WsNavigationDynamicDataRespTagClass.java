package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespTagClass implements Serializable {
    public String backgroundColor;
    public String color;

    public WsNavigationDynamicDataRespTagClass() {
        this.color = "";
        this.backgroundColor = "";
    }

    public WsNavigationDynamicDataRespTagClass(String str, String str2) {
        this.color = str;
        this.backgroundColor = str2;
    }
}
