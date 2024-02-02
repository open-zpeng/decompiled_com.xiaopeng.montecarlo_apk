package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SizeDouble implements Serializable {
    public double height;
    public double width;

    public SizeDouble() {
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public SizeDouble(double d, double d2) {
        this.width = d;
        this.height = d2;
    }
}
