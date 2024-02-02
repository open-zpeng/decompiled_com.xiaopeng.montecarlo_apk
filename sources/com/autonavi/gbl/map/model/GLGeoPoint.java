package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GLGeoPoint implements Serializable {
    public int m_X;
    public int m_Y;

    public GLGeoPoint() {
        this.m_X = 0;
        this.m_Y = 0;
    }

    public GLGeoPoint(int i, int i2) {
        this.m_X = i;
        this.m_Y = i2;
    }
}
