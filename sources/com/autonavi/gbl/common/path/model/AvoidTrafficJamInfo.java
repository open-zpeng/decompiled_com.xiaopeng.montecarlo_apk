package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AvoidTrafficJamInfo implements Serializable {
    public short averageSpeed;
    public ArrayList<Integer> coorList;
    public int length;
    public Coord2DDouble pos;
    public Coord3DDouble pos3D;
    public short priority;
    public short reversed;
    public String roadName;
    public ArrayList<Integer> segStartCoorIndexs;
    public short status;
    public ArrayList<Short> statusList;
    public int travelTime;

    public AvoidTrafficJamInfo() {
        this.pos = new Coord2DDouble();
        this.pos3D = new Coord3DDouble();
        this.roadName = "";
        this.length = 0;
        this.status = (short) 0;
        this.priority = (short) 0;
        this.averageSpeed = (short) 0;
        this.reversed = (short) 0;
        this.travelTime = 0;
        this.coorList = null;
        this.segStartCoorIndexs = null;
        this.statusList = null;
    }

    public AvoidTrafficJamInfo(Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, String str, int i, short s, short s2, short s3, short s4, int i2, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<Short> arrayList3) {
        this.pos = coord2DDouble;
        this.pos3D = coord3DDouble;
        this.roadName = str;
        this.length = i;
        this.status = s;
        this.priority = s2;
        this.averageSpeed = s3;
        this.reversed = s4;
        this.travelTime = i2;
        this.coorList = arrayList;
        this.segStartCoorIndexs = arrayList2;
        this.statusList = arrayList3;
    }
}
