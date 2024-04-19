package com.autonavi.gbl.card.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CardFontInfo implements Serializable {
    public long fontContentOffset;
    public String fontName;
    public String fontPath;

    public CardFontInfo() {
        this.fontName = "";
        this.fontPath = "";
        this.fontContentOffset = 0L;
    }

    public CardFontInfo(String str, String str2, long j) {
        this.fontName = str;
        this.fontPath = str2;
        this.fontContentOffset = j;
    }
}
