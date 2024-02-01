package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataJamBubblesSegmentDeepInfo implements Serializable {
    public String icon;
    public int sceneType;
    public String text;

    public WsNavigationDynamicDataJamBubblesSegmentDeepInfo() {
        this.text = "";
        this.icon = "";
        this.sceneType = 0;
    }

    public WsNavigationDynamicDataJamBubblesSegmentDeepInfo(String str, String str2, int i) {
        this.text = str;
        this.icon = str2;
        this.sceneType = i;
    }
}
