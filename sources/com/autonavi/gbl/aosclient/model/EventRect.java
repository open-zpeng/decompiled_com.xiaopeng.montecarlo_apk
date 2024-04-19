package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EventRect implements Serializable {
    public float max_x;
    public float max_y;
    public float min_x;
    public float min_y;

    public EventRect() {
        this.min_x = 0.0f;
        this.min_y = 0.0f;
        this.max_x = 0.0f;
        this.max_y = 0.0f;
    }

    public EventRect(float f, float f2, float f3, float f4) {
        this.min_x = f;
        this.min_y = f2;
        this.max_x = f3;
        this.max_y = f4;
    }
}
