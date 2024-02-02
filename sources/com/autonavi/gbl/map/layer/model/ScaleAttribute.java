package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.map.layer.model.ScalePriority;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ScaleAttribute implements Serializable {
    @ScalePriority.ScalePriority1
    public int priority;
    public ScaleInfo scale;

    public ScaleAttribute() {
        this.priority = 1;
        this.scale = new ScaleInfo();
    }

    public ScaleAttribute(@ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        this.priority = i;
        this.scale = scaleInfo;
    }
}
