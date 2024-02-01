package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RasterImageLayerItemStyle implements Serializable {
    public int bg_marker_id;
    public int height;
    public int marker_id;
    public int width;
    public int winx;
    public int winy;

    public RasterImageLayerItemStyle() {
        this.winx = 0;
        this.winy = 0;
        this.width = 0;
        this.height = 0;
        this.bg_marker_id = -1;
        this.marker_id = -1;
    }

    public RasterImageLayerItemStyle(int i, int i2, int i3, int i4, int i5, int i6) {
        this.winx = i;
        this.winy = i2;
        this.width = i3;
        this.height = i4;
        this.bg_marker_id = i5;
        this.marker_id = i6;
    }
}
