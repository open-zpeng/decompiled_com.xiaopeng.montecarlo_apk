package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Font implements Serializable {
    public FontMetrics fontMetrics;
    public int nFontSize;
    public int nFontStyleCode;
    public String strName;

    public Font() {
        this.nFontStyleCode = 0;
        this.nFontSize = 0;
        this.strName = "";
        this.fontMetrics = new FontMetrics();
    }

    public Font(int i, int i2, String str, FontMetrics fontMetrics) {
        this.nFontStyleCode = i;
        this.nFontSize = i2;
        this.strName = str;
        this.fontMetrics = fontMetrics;
    }
}
