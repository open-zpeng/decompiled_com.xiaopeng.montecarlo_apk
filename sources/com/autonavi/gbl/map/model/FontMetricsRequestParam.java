package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FontMetricsRequestParam implements Serializable {
    public float fFontSize;
    public String languageArr;
    public int nFontStyleCode;
    public String strName;

    public FontMetricsRequestParam() {
        this.fFontSize = 0.0f;
        this.nFontStyleCode = 0;
        this.strName = "";
        this.languageArr = "";
    }

    public FontMetricsRequestParam(float f, int i, String str, String str2) {
        this.fFontSize = f;
        this.nFontStyleCode = i;
        this.strName = str;
        this.languageArr = str2;
    }
}
