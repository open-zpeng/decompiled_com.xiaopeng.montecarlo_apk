package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespAction implements Serializable {
    public String params;
    public String type;

    public WsNavigationDynamicDataRespAction() {
        this.type = "";
        this.params = "";
    }

    public WsNavigationDynamicDataRespAction(String str, String str2) {
        this.type = str;
        this.params = str2;
    }
}
