package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.model.RotateMode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ItemMarkerInfo implements Serializable {
    public boolean isRotateWithItem;
    public boolean isVisible;
    public double markerAlpha;
    public double markerAngle;
    public int markerId;
    public PointTextureInfo markerTextureInfo;
    public Coord3DDouble relativeCenter;
    @RotateMode.RotateMode1
    public int rotateMode;
    public Scale3D scale;

    public ItemMarkerInfo() {
        this.markerId = -1;
        this.rotateMode = 0;
        this.markerAngle = 0.0d;
        this.markerAlpha = 1.0d;
        this.relativeCenter = new Coord3DDouble();
        this.scale = new Scale3D();
        this.markerTextureInfo = new PointTextureInfo();
        this.isRotateWithItem = false;
        this.isVisible = true;
    }

    public ItemMarkerInfo(int i, @RotateMode.RotateMode1 int i2, double d, double d2, Coord3DDouble coord3DDouble, Scale3D scale3D, PointTextureInfo pointTextureInfo, boolean z, boolean z2) {
        this.markerId = i;
        this.rotateMode = i2;
        this.markerAngle = d;
        this.markerAlpha = d2;
        this.relativeCenter = coord3DDouble;
        this.scale = scale3D;
        this.markerTextureInfo = pointTextureInfo;
        this.isRotateWithItem = z;
        this.isVisible = z2;
    }
}
