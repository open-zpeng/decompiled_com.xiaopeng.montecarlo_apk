package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ClusterDisplayScale implements Serializable {
    public LayerScale displayScale;
    public String strTypeCode;

    public ClusterDisplayScale() {
        this.strTypeCode = "";
        this.displayScale = new LayerScale();
    }

    public ClusterDisplayScale(String str, LayerScale layerScale) {
        this.strTypeCode = str;
        this.displayScale = layerScale;
    }
}
