package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class EglConfigAttr implements Serializable {
    public int alpha;
    public int antialias;
    public int blue;
    public int depth;
    public int green;
    public int red;
    public int samples;
    public int stencil;

    public EglConfigAttr() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.alpha = 0;
        this.depth = 0;
        this.stencil = 0;
        this.antialias = 0;
        this.samples = 0;
    }

    public EglConfigAttr(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.red = i;
        this.green = i2;
        this.blue = i3;
        this.alpha = i4;
        this.depth = i5;
        this.stencil = i6;
        this.antialias = i7;
        this.samples = i8;
    }
}
