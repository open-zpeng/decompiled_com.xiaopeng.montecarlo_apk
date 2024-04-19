package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataToastItem implements Serializable {
    public String dynamic_id_s;
    public String text;

    public WsNavigationDynamicDataToastItem() {
        this.text = "";
        this.dynamic_id_s = "";
    }

    public WsNavigationDynamicDataToastItem(String str, String str2) {
        this.text = str;
        this.dynamic_id_s = str2;
    }
}
