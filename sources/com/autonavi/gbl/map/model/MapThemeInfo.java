package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapThemeInfo implements Serializable {
    public String name;
    public int themeId;

    public MapThemeInfo() {
        this.name = "";
        this.themeId = -1;
    }

    public MapThemeInfo(String str, int i) {
        this.name = str;
        this.themeId = i;
    }
}
