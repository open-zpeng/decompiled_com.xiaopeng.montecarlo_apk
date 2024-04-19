package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PointLayerItemStyle implements Serializable {
    public int bgMarkerId;
    public PointLayerItemShowRect bgShowRect;
    public PointLayerItemTexture bgTexture;
    public int bubbleMarkerId;
    public PointLayerItemShowRect bubbleShowRect;
    public PointLayerItemTexture bubbleTexture;
    public int poiMarkerId;
    public PointLayerItemShowRect poiShowRect;
    public PointLayerItemTexture poiTexture;

    public PointLayerItemStyle() {
        this.poiMarkerId = -1;
        this.bgMarkerId = -1;
        this.bubbleMarkerId = -1;
        this.poiTexture = new PointLayerItemTexture();
        this.bgTexture = new PointLayerItemTexture();
        this.bubbleTexture = new PointLayerItemTexture();
        this.poiShowRect = new PointLayerItemShowRect();
        this.bgShowRect = new PointLayerItemShowRect();
        this.bubbleShowRect = new PointLayerItemShowRect();
    }

    public PointLayerItemStyle(int i, int i2, int i3, PointLayerItemTexture pointLayerItemTexture, PointLayerItemTexture pointLayerItemTexture2, PointLayerItemTexture pointLayerItemTexture3, PointLayerItemShowRect pointLayerItemShowRect, PointLayerItemShowRect pointLayerItemShowRect2, PointLayerItemShowRect pointLayerItemShowRect3) {
        this.poiMarkerId = i;
        this.bgMarkerId = i2;
        this.bubbleMarkerId = i3;
        this.poiTexture = pointLayerItemTexture;
        this.bgTexture = pointLayerItemTexture2;
        this.bubbleTexture = pointLayerItemTexture3;
        this.poiShowRect = pointLayerItemShowRect;
        this.bgShowRect = pointLayerItemShowRect2;
        this.bubbleShowRect = pointLayerItemShowRect3;
    }
}
