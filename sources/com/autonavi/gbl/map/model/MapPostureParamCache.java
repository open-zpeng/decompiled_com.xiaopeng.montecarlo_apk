package com.autonavi.gbl.map.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MapPostureParamCache implements Serializable {
    public Coord3DDouble mapCenter;
    public float mapRollAngle;
    public float maplevel;
    public float pitchAngle;
    public float projectX;
    public float projectY;
    public MapStyleParam styleParam;

    public MapPostureParamCache() {
        this.mapCenter = new Coord3DDouble();
        this.maplevel = 0.0f;
        this.mapRollAngle = 0.0f;
        this.pitchAngle = 0.0f;
        this.projectX = 0.0f;
        this.projectY = 0.0f;
        this.styleParam = new MapStyleParam();
    }

    public MapPostureParamCache(Coord3DDouble coord3DDouble, float f, float f2, float f3, float f4, float f5, MapStyleParam mapStyleParam) {
        this.mapCenter = coord3DDouble;
        this.maplevel = f;
        this.mapRollAngle = f2;
        this.pitchAngle = f3;
        this.projectX = f4;
        this.projectY = f5;
        this.styleParam = mapStyleParam;
    }
}
