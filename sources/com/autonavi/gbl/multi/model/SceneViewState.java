package com.autonavi.gbl.multi.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.model.MapviewMode;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SceneViewState implements Serializable {
    public Coord3DDouble mapCenter;
    @MapviewMode.MapviewMode1
    public int mapMode;
    public float percentX;
    public float percentY;
    public long zoomer;

    public SceneViewState() {
        this.zoomer = 15L;
        this.mapMode = 0;
        this.mapCenter = new Coord3DDouble();
        this.percentX = 0.0f;
        this.percentY = 0.0f;
    }

    public SceneViewState(long j, @MapviewMode.MapviewMode1 int i, Coord3DDouble coord3DDouble, float f, float f2) {
        this.zoomer = j;
        this.mapMode = i;
        this.mapCenter = coord3DDouble;
        this.percentX = f;
        this.percentY = f2;
    }
}
