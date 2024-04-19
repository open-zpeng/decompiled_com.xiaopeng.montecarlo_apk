package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapScaleParam implements Serializable {
    public int mallocCacheType;
    public float screenScale;
    public float textScale;
    public float zoomScale;

    public MapScaleParam() {
        this.zoomScale = 0.6f;
        this.textScale = 2.0f;
        this.screenScale = 2.0f;
        this.mallocCacheType = 2;
    }

    public MapScaleParam(float f, float f2, float f3, int i) {
        this.zoomScale = f;
        this.textScale = f2;
        this.screenScale = f3;
        this.mallocCacheType = i;
    }
}
