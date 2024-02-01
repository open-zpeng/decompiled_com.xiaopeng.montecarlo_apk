package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CrossViewParam implements Serializable {
    public int crossViewHeight;
    public int crossViewStartX;
    public int crossViewStartY;
    public int crossViewWidth;

    public CrossViewParam() {
        this.crossViewStartX = 0;
        this.crossViewStartY = 0;
        this.crossViewWidth = 0;
        this.crossViewHeight = 0;
    }

    public CrossViewParam(int i, int i2, int i3, int i4) {
        this.crossViewStartX = i;
        this.crossViewStartY = i2;
        this.crossViewWidth = i3;
        this.crossViewHeight = i4;
    }
}
