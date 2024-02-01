package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.guide.model.TrafficLight;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficSignal implements Serializable {
    public int countDown;
    @TrafficLight.TrafficLight1
    public int lightStatus;
    public long pathID;
    public Coord2DInt32 pos;
    public Coord3DInt32 pos3D;

    public TrafficSignal() {
        this.pathID = 0L;
        this.lightStatus = 0;
        this.countDown = -1;
        this.pos = new Coord2DInt32();
        this.pos3D = new Coord3DInt32();
    }

    public TrafficSignal(long j, @TrafficLight.TrafficLight1 int i, int i2, Coord2DInt32 coord2DInt32, Coord3DInt32 coord3DInt32) {
        this.pathID = j;
        this.lightStatus = i;
        this.countDown = i2;
        this.pos = coord2DInt32;
        this.pos3D = coord3DInt32;
    }
}
