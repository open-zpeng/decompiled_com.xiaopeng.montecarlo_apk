package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataLinksAdcodeItem implements Serializable {
    public String key;
    public String value;

    public WsNavigationDynamicDataLinksAdcodeItem() {
        this.key = "";
        this.value = "";
    }

    public WsNavigationDynamicDataLinksAdcodeItem(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
