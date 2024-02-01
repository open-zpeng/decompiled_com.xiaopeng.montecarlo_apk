package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespStyleClass implements Serializable {
    public WsNavigationDynamicDataRespTagClass tag;

    public WsNavigationDynamicDataRespStyleClass() {
        this.tag = new WsNavigationDynamicDataRespTagClass();
    }

    public WsNavigationDynamicDataRespStyleClass(WsNavigationDynamicDataRespTagClass wsNavigationDynamicDataRespTagClass) {
        this.tag = wsNavigationDynamicDataRespTagClass;
    }
}
