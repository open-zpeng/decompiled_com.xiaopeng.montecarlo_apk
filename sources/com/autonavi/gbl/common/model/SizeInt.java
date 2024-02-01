package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SizeInt implements Serializable {
    public int height;
    public int width;

    public SizeInt() {
        this.width = 0;
        this.height = 0;
    }

    public SizeInt(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
