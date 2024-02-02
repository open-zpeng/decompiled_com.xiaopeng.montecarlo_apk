package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.CameraType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviIntervalCamera implements Serializable {
    public Coord2DDouble coord2D;
    public Coord3DDouble coord3D;
    public int distance;
    public ArrayList<Short> speed;
    @CameraType.CameraType1
    public int type;

    public NaviIntervalCamera() {
        this.coord2D = new Coord2DDouble();
        this.coord3D = new Coord3DDouble();
        this.type = 255;
        this.distance = 0;
        this.speed = new ArrayList<>();
    }

    public NaviIntervalCamera(Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, @CameraType.CameraType1 int i, int i2, ArrayList<Short> arrayList) {
        this.coord2D = coord2DDouble;
        this.coord3D = coord3DDouble;
        this.type = i;
        this.distance = i2;
        this.speed = arrayList;
    }
}
