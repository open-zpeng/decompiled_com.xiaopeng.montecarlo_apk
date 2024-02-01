package com.autonavi.gbl.recorder.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PlayerMessage implements Serializable {
    public int type;

    public PlayerMessage() {
        this.type = 0;
    }

    public PlayerMessage(int i) {
        this.type = i;
    }
}
