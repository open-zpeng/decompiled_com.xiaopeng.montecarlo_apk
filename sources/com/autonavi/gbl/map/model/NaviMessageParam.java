package com.autonavi.gbl.map.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.model.CarLoc;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class NaviMessageParam implements Serializable {
    public int cacheMessagePolicy;
    public float carAngle;
    public float carAngle3D;
    public float carPitch;
    public CarLoc loc;
    public Coord3DDouble mapCenter;
    public float mapLevel;
    public float mapPitch;
    public float mapRollAngle;
    public long pModeOverlay;
    public long pNaviControl;

    public NaviMessageParam() {
        this.mapCenter = new Coord3DDouble();
        this.loc = new CarLoc();
        this.carAngle = 0.0f;
        this.carAngle3D = 0.0f;
        this.carPitch = 0.0f;
        this.mapRollAngle = 0.0f;
        this.mapPitch = 0.0f;
        this.mapLevel = 0.0f;
        this.pNaviControl = 0L;
        this.pModeOverlay = 0L;
        this.cacheMessagePolicy = 1;
    }

    public NaviMessageParam(Coord3DDouble coord3DDouble, CarLoc carLoc, float f, float f2, float f3, float f4, float f5, float f6, long j, long j2, int i) {
        this.mapCenter = coord3DDouble;
        this.loc = carLoc;
        this.carAngle = f;
        this.carAngle3D = f2;
        this.carPitch = f3;
        this.mapRollAngle = f4;
        this.mapPitch = f5;
        this.mapLevel = f6;
        this.pNaviControl = j;
        this.pModeOverlay = j2;
        this.cacheMessagePolicy = i;
    }
}
