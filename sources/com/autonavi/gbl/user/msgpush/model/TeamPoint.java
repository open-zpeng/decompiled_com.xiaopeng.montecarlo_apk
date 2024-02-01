package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TeamPoint implements Serializable {
    public double x;
    public double y;

    public TeamPoint() {
        this.x = 0.0d;
        this.y = 0.0d;
    }

    public TeamPoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }
}
