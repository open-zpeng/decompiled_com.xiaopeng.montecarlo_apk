package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Vector3i implements Serializable {
    public int x;
    public int y;
    public int z;

    public Vector3i() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3i(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
    }
}
