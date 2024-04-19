package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapRGBA implements Serializable {
    public short a;
    public short b;
    public short g;
    public short r;

    public MapRGBA() {
        this.r = (short) 0;
        this.g = (short) 0;
        this.b = (short) 0;
        this.a = (short) 0;
    }

    public MapRGBA(short s, short s2, short s3, short s4) {
        this.r = s;
        this.g = s2;
        this.b = s3;
        this.a = s4;
    }
}
