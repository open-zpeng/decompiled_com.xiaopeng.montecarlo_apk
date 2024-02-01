package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RoadClass;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviCameraExt implements Serializable {
    public long cameraId;
    public Coord2DDouble coord2D;
    public Coord3DDouble coord3D;
    public int distance;
    public int distanceToEnd;
    public boolean isHidden;
    public int linkIndex;
    @RoadClass.RoadClass1
    public int roadClass;
    public int segmentIndex;
    public ArrayList<NaviSubCameraExt> subCameras;

    public NaviCameraExt() {
        this.cameraId = 0L;
        this.coord2D = new Coord2DDouble();
        this.coord3D = new Coord3DDouble();
        this.distance = 0;
        this.segmentIndex = 0;
        this.linkIndex = 0;
        this.distanceToEnd = 0;
        this.roadClass = -1;
        this.isHidden = false;
        this.subCameras = new ArrayList<>();
    }

    public NaviCameraExt(long j, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, int i, int i2, int i3, int i4, @RoadClass.RoadClass1 int i5, boolean z, ArrayList<NaviSubCameraExt> arrayList) {
        this.cameraId = j;
        this.coord2D = coord2DDouble;
        this.coord3D = coord3DDouble;
        this.distance = i;
        this.segmentIndex = i2;
        this.linkIndex = i3;
        this.distanceToEnd = i4;
        this.roadClass = i5;
        this.isHidden = z;
        this.subCameras = arrayList;
    }
}
