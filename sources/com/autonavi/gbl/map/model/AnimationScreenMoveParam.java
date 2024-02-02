package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AnimationScreenMoveParam implements Serializable {
    public int deltaScreenX;
    public int deltaScreenY;

    public AnimationScreenMoveParam() {
        this.deltaScreenX = 0;
        this.deltaScreenY = 0;
    }

    public AnimationScreenMoveParam(int i, int i2) {
        this.deltaScreenX = i;
        this.deltaScreenY = i2;
    }
}
