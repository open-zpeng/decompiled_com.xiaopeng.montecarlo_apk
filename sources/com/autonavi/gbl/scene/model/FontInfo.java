package com.autonavi.gbl.scene.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FontInfo implements Serializable {
    public long fontContentOffset;
    public String fontName;
    public String fontPath;
    public long type;

    public FontInfo() {
        this.fontName = "";
        this.fontPath = "";
        this.fontContentOffset = 0L;
        this.type = 0L;
    }

    public FontInfo(String str, String str2, long j, long j2) {
        this.fontName = str;
        this.fontPath = str2;
        this.fontContentOffset = j;
        this.type = j2;
    }
}
