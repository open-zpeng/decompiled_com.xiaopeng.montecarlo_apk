package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WSMapapiBenzLinkidsGp implements Serializable {
    public int ag;
    public int sp;
    public long tm;
    public double x;
    public double y;

    public WSMapapiBenzLinkidsGp() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.sp = 0;
        this.ag = 0;
        this.tm = 0L;
    }

    public WSMapapiBenzLinkidsGp(double d, double d2, int i, int i2, long j) {
        this.x = d;
        this.y = d2;
        this.sp = i;
        this.ag = i2;
        this.tm = j;
    }
}
