package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LocVisualObj implements Serializable {
    public ArrayList<LocBarrier> barriers;
    public int cntBarriers;
    public int cntMarkings;
    public int cntOverheads;
    public int cntPoles;
    public int cntTrafficLights;
    public int cntTrafficSigns;
    public int cntWalls;
    @LocDataType.LocDataType1
    public int dataType;
    public ArrayList<LocMarking> markings;
    public ArrayList<LocOverhead> overheads;
    public ArrayList<LocPole> poles;
    public BigInteger ticktime;
    public ArrayList<LocTrafficLight> trafficLights;
    public ArrayList<LocTrafficSign> trafficSigns;
    public ArrayList<LocWall> walls;

    public LocVisualObj() {
        this.dataType = LocDataType.LocDataVisualObj;
        this.ticktime = new BigInteger("0");
        this.cntTrafficSigns = 0;
        this.trafficSigns = new ArrayList<>();
        this.cntPoles = 0;
        this.poles = new ArrayList<>();
        this.cntMarkings = 0;
        this.markings = new ArrayList<>();
        this.cntTrafficLights = 0;
        this.trafficLights = new ArrayList<>();
        this.cntWalls = 0;
        this.walls = new ArrayList<>();
        this.cntOverheads = 0;
        this.overheads = new ArrayList<>();
        this.cntBarriers = 0;
        this.barriers = new ArrayList<>();
    }

    public LocVisualObj(@LocDataType.LocDataType1 int i, BigInteger bigInteger, int i2, ArrayList<LocTrafficSign> arrayList, int i3, ArrayList<LocPole> arrayList2, int i4, ArrayList<LocMarking> arrayList3, int i5, ArrayList<LocTrafficLight> arrayList4, int i6, ArrayList<LocWall> arrayList5, int i7, ArrayList<LocOverhead> arrayList6, int i8, ArrayList<LocBarrier> arrayList7) {
        this.dataType = i;
        this.ticktime = bigInteger;
        this.cntTrafficSigns = i2;
        this.trafficSigns = arrayList;
        this.cntPoles = i3;
        this.poles = arrayList2;
        this.cntMarkings = i4;
        this.markings = arrayList3;
        this.cntTrafficLights = i5;
        this.trafficLights = arrayList4;
        this.cntWalls = i6;
        this.walls = arrayList5;
        this.cntOverheads = i7;
        this.overheads = arrayList6;
        this.cntBarriers = i8;
        this.barriers = arrayList7;
    }
}
