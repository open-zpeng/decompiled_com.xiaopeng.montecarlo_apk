package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ElecCommonParameter implements Serializable {
    public float access;
    public float decess;

    public ElecCommonParameter() {
        this.access = 0.0f;
        this.decess = 0.0f;
    }

    public ElecCommonParameter(float f, float f2) {
        this.access = f;
        this.decess = f2;
    }
}
