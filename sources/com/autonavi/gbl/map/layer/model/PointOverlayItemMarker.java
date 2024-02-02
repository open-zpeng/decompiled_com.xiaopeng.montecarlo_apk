package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PointOverlayItemMarker implements Serializable {
    public int bubbleMarker;
    public PointTextureInfo bubbleTextureInfo;
    public int iconMarker;
    public PointTextureInfo iconTextureInfo;
    public int nameMarker;
    public PointTextureInfo nameTextureInfo;

    public PointOverlayItemMarker() {
        this.iconMarker = -1;
        this.iconTextureInfo = new PointTextureInfo();
        this.nameMarker = -1;
        this.nameTextureInfo = new PointTextureInfo();
        this.bubbleMarker = -1;
        this.bubbleTextureInfo = new PointTextureInfo();
    }

    public PointOverlayItemMarker(int i, PointTextureInfo pointTextureInfo, int i2, PointTextureInfo pointTextureInfo2, int i3, PointTextureInfo pointTextureInfo3) {
        this.iconMarker = i;
        this.iconTextureInfo = pointTextureInfo;
        this.nameMarker = i2;
        this.nameTextureInfo = pointTextureInfo2;
        this.bubbleMarker = i3;
        this.bubbleTextureInfo = pointTextureInfo3;
    }
}
