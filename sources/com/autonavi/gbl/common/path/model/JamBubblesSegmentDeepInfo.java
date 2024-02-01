package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class JamBubblesSegmentDeepInfo implements Serializable {
    public String icon;
    public String iconPath;
    public int sceneType;
    public String text;

    public JamBubblesSegmentDeepInfo() {
        this.text = "";
        this.icon = "";
        this.iconPath = "";
        this.sceneType = 0;
    }

    public JamBubblesSegmentDeepInfo(String str, String str2, String str3, int i) {
        this.text = str;
        this.icon = str2;
        this.iconPath = str3;
        this.sceneType = i;
    }
}
