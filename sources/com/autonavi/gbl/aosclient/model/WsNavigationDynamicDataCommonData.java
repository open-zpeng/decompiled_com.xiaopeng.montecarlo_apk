package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataCommonData implements Serializable {
    public WsNavigationDynamicDataServicearea servicearea;

    public WsNavigationDynamicDataCommonData() {
        this.servicearea = new WsNavigationDynamicDataServicearea();
    }

    public WsNavigationDynamicDataCommonData(WsNavigationDynamicDataServicearea wsNavigationDynamicDataServicearea) {
        this.servicearea = wsNavigationDynamicDataServicearea;
    }
}
