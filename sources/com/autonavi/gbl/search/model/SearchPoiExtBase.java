package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiExtBase implements Serializable {
    public int distance;
    public byte isSuggestedCategory;
    public int matchPosition;
    public byte matchType;
    public int matchValue;
    public short priority;
    public byte reserved;

    public SearchPoiExtBase() {
        this.distance = 0;
        this.matchValue = 0;
        this.matchPosition = 0;
        this.isSuggestedCategory = (byte) 0;
        this.priority = (short) 0;
        this.matchType = (byte) 0;
        this.reserved = (byte) 0;
    }

    public SearchPoiExtBase(int i, int i2, int i3, byte b, short s, byte b2, byte b3) {
        this.distance = i;
        this.matchValue = i2;
        this.matchPosition = i3;
        this.isSuggestedCategory = b;
        this.priority = s;
        this.matchType = b2;
        this.reserved = b3;
    }
}
