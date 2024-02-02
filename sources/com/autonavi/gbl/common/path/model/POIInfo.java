package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class POIInfo implements Serializable {
    public String angel;
    public BigInteger checkPointLinkId;
    public String extendInfoFlag;
    public int floor;
    public String floorName;
    public short fromJump;
    public String name;
    public Coord2DDouble naviPos;
    public short overhead;
    public float overheadBackAltDiff;
    public String parentID;
    public String parentName;
    public String parentRel;
    public String parentSimpleName;
    public String poiID;
    public short pointCnt;
    public int[] points;
    public Coord2DDouble realPos;
    public long roadID;
    public float sigshelter;
    public String srcApp;
    public int type;
    public String typeCode;

    public POIInfo() {
        this.realPos = new Coord2DDouble();
        this.naviPos = new Coord2DDouble();
        this.sigshelter = 0.0f;
        this.type = 0;
        this.roadID = 0L;
        this.poiID = "";
        this.name = "";
        this.floorName = "";
        this.parentName = "";
        this.parentSimpleName = "";
        this.angel = "";
        this.parentID = "";
        this.parentRel = "";
        this.typeCode = "";
        this.fromJump = (short) 0;
        this.overhead = (short) 0;
        this.pointCnt = (short) 0;
        this.checkPointLinkId = new BigInteger("0");
        this.overheadBackAltDiff = -10001.1f;
        this.floor = 0;
        this.extendInfoFlag = "";
        this.srcApp = "";
        this.points = null;
    }

    public POIInfo(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, float f, int i, long j, String str, String str2, String str3, String str4, String str5, String str6, int[] iArr, String str7, String str8, String str9, short s, short s2, short s3, BigInteger bigInteger, float f2, int i2, String str10, String str11) {
        this.realPos = coord2DDouble;
        this.naviPos = coord2DDouble2;
        this.sigshelter = f;
        this.type = i;
        this.roadID = j;
        this.poiID = str;
        this.name = str2;
        this.floorName = str3;
        this.parentName = str4;
        this.parentSimpleName = str5;
        this.angel = str6;
        this.points = iArr;
        this.parentID = str7;
        this.parentRel = str8;
        this.typeCode = str9;
        this.fromJump = s;
        this.overhead = s2;
        this.pointCnt = s3;
        this.checkPointLinkId = bigInteger;
        this.overheadBackAltDiff = f2;
        this.floor = i2;
        this.extendInfoFlag = str10;
        this.srcApp = str11;
    }
}
