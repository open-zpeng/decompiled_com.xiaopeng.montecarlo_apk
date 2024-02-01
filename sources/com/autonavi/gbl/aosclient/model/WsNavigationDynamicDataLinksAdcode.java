package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataLinksAdcode implements Serializable {
    public ArrayList<WsNavigationDynamicDataLinksAdcodeItem> adcodeItems;

    public WsNavigationDynamicDataLinksAdcode() {
        this.adcodeItems = new ArrayList<>();
    }

    public WsNavigationDynamicDataLinksAdcode(ArrayList<WsNavigationDynamicDataLinksAdcodeItem> arrayList) {
        this.adcodeItems = arrayList;
    }
}
