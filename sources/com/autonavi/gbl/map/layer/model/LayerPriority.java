package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.map.layer.model.LayerDrawPriority;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LayerPriority implements Serializable {
    @LayerDrawPriority.LayerDrawPriority1
    public int drawlayerPrio;
    public int priority;

    public LayerPriority() {
        this.drawlayerPrio = 140;
        this.priority = 0;
    }

    public LayerPriority(@LayerDrawPriority.LayerDrawPriority1 int i, int i2) {
        this.drawlayerPrio = i;
        this.priority = i2;
    }
}
