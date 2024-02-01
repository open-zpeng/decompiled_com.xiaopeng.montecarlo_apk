package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class STPoint implements Serializable {
    public long ItemCollision;
    public STTipsBaseInfo baseInfo;
    public ArrayList<STDetail> detail;
    public long lay;
    public long lineCollision;
    public long mapCollision;
    public Coord2DDouble pos2D;
    public Coord3DDouble pos3D;
    public long ptCollision;
    public long ptType;
    public long showPath;

    public STPoint() {
        this.baseInfo = new STTipsBaseInfo();
        this.detail = new ArrayList<>();
        this.showPath = 0L;
        this.pos2D = new Coord2DDouble();
        this.pos3D = new Coord3DDouble();
        this.lay = 0L;
        this.ptCollision = 0L;
        this.lineCollision = 0L;
        this.mapCollision = 0L;
        this.ItemCollision = 0L;
        this.ptType = 0L;
    }

    public STPoint(STTipsBaseInfo sTTipsBaseInfo, ArrayList<STDetail> arrayList, long j, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.baseInfo = sTTipsBaseInfo;
        this.detail = arrayList;
        this.showPath = j;
        this.pos2D = coord2DDouble;
        this.pos3D = coord3DDouble;
        this.lay = j2;
        this.ptCollision = j3;
        this.lineCollision = j4;
        this.mapCollision = j5;
        this.ItemCollision = j6;
        this.ptType = j7;
    }
}
