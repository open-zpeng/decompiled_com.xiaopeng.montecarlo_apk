package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LimitPointInfo implements Serializable {
    public short flag;
    public ArrayList<Coord2DDouble> inCoorList;
    public String inRoadName;
    public ArrayList<Coord2DDouble> outCoorList;
    public String outRoadName;
    public Coord2DDouble pos;
    public Coord3DDouble pos3D;
    public String roadName;
    public String timeDescription;
    public short type;
    public long vehicleType;

    public LimitPointInfo() {
        this.type = (short) 0;
        this.flag = (short) 0;
        this.pos = new Coord2DDouble();
        this.pos3D = new Coord3DDouble();
        this.roadName = "";
        this.timeDescription = "";
        this.vehicleType = 0L;
        this.inRoadName = "";
        this.outRoadName = "";
        this.inCoorList = new ArrayList<>();
        this.outCoorList = new ArrayList<>();
    }

    public LimitPointInfo(short s, short s2, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, String str, String str2, long j, String str3, String str4, ArrayList<Coord2DDouble> arrayList, ArrayList<Coord2DDouble> arrayList2) {
        this.type = s;
        this.flag = s2;
        this.pos = coord2DDouble;
        this.pos3D = coord3DDouble;
        this.roadName = str;
        this.timeDescription = str2;
        this.vehicleType = j;
        this.inRoadName = str3;
        this.outRoadName = str4;
        this.inCoorList = arrayList;
        this.outCoorList = arrayList2;
    }
}
