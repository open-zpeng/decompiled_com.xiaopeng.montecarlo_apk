package com.autonavi.gbl.card.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CardFontInfo implements Serializable {
    public long fontContentOffset;
    public long fontContentTail;
    public String fontName;
    public String fontPath;

    public CardFontInfo() {
        this.fontName = "";
        this.fontPath = "";
        this.fontContentOffset = 0L;
        this.fontContentTail = 0L;
    }

    public CardFontInfo(String str, String str2, long j, long j2) {
        this.fontName = str;
        this.fontPath = str2;
        this.fontContentOffset = j;
        this.fontContentTail = j2;
    }
}
