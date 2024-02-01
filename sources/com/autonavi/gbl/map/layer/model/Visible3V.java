package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Visible3V implements Serializable {
    public boolean bubble;
    public boolean icon;
    public boolean name;

    public Visible3V() {
        this.icon = true;
        this.name = true;
        this.bubble = true;
    }

    public Visible3V(boolean z, boolean z2, boolean z3) {
        this.icon = z;
        this.name = z2;
        this.bubble = z3;
    }
}
