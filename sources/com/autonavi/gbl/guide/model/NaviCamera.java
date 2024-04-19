package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.common.path.model.RoadClass;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviCamera implements Serializable {
    public Coord2DDouble coord2D;
    public Coord3DDouble coord3D;
    public int distance;
    public int distanceToEnd;
    public long id;
    public boolean isNew;
    public int linkIndex;
    public int penalty;
    @RoadClass.RoadClass1
    public int roadClass;
    public int segmentIndex;
    public ArrayList<Short> speed;
    public ArrayList<NaviSubCamera> subCameras;
    @CameraType.CameraType1
    public int type;

    public NaviCamera() {
        this.coord2D = new Coord2DDouble();
        this.coord3D = new Coord3DDouble();
        this.type = 0;
        this.distance = 0;
        this.speed = new ArrayList<>();
        this.roadClass = -1;
        this.segmentIndex = 0;
        this.linkIndex = 0;
        this.distanceToEnd = 0;
        this.subCameras = new ArrayList<>();
        this.penalty = 0;
        this.id = 0L;
        this.isNew = false;
    }

    public NaviCamera(Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, @CameraType.CameraType1 int i, int i2, ArrayList<Short> arrayList, @RoadClass.RoadClass1 int i3, int i4, int i5, int i6, ArrayList<NaviSubCamera> arrayList2, int i7, long j, boolean z) {
        this.coord2D = coord2DDouble;
        this.coord3D = coord3DDouble;
        this.type = i;
        this.distance = i2;
        this.speed = arrayList;
        this.roadClass = i3;
        this.segmentIndex = i4;
        this.linkIndex = i5;
        this.distanceToEnd = i6;
        this.subCameras = arrayList2;
        this.penalty = i7;
        this.id = j;
        this.isNew = z;
    }
}
