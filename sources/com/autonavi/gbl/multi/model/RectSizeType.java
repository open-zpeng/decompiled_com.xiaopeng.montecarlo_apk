package com.autonavi.gbl.multi.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RectSizeType implements Serializable {
    public int height;
    public int width;

    public RectSizeType() {
        this.width = 0;
        this.height = 0;
    }

    public RectSizeType(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
