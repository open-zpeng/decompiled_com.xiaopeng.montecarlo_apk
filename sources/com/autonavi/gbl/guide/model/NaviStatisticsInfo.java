package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class NaviStatisticsInfo implements Serializable {
    public int accidentAreaCount;
    public float[] arrRoadDist;
    public int[] arrSpeedClass;
    public float[] arrTrafficDist;
    public int averageSpeed;
    public int brakesCount;
    public int drivenDist;
    public int drivenTime;
    public int estimateDist;
    public int estimateTime;
    public int highestSpeed;
    public int highwayOverSpeedHighCnt;
    public int highwayOverSpeedLowCnt;
    public int highwayOverSpeedMidCnt;
    public int normalOverSpeedHighCnt;
    public int normalOverSpeedLowCnt;
    public int normalOverSpeedMidCnt;
    public int normalRouteTime;
    public int overspeedCount;
    public int overspeedCountEx;
    public int rerouteCount;
    public int savedTime;
    public int slowTime;
    public int startSecond;
    public BigInteger startUTC;

    public NaviStatisticsInfo() {
        this.startUTC = new BigInteger("0");
        this.startSecond = 0;
        this.normalRouteTime = 0;
        this.savedTime = 0;
        this.estimateTime = 0;
        this.estimateDist = 0;
        this.drivenTime = 0;
        this.drivenDist = 0;
        this.averageSpeed = 0;
        this.highestSpeed = 0;
        this.overspeedCount = 0;
        this.overspeedCountEx = 0;
        this.highwayOverSpeedLowCnt = 0;
        this.highwayOverSpeedMidCnt = 0;
        this.highwayOverSpeedHighCnt = 0;
        this.normalOverSpeedLowCnt = 0;
        this.normalOverSpeedMidCnt = 0;
        this.normalOverSpeedHighCnt = 0;
        this.accidentAreaCount = 0;
        this.rerouteCount = 0;
        this.brakesCount = 0;
        this.slowTime = 0;
        this.arrTrafficDist = new float[5];
        this.arrRoadDist = new float[12];
        this.arrSpeedClass = new int[16];
    }

    public NaviStatisticsInfo(BigInteger bigInteger, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, float[] fArr, float[] fArr2, int[] iArr) {
        this.startUTC = bigInteger;
        this.startSecond = i;
        this.normalRouteTime = i2;
        this.savedTime = i3;
        this.estimateTime = i4;
        this.estimateDist = i5;
        this.drivenTime = i6;
        this.drivenDist = i7;
        this.averageSpeed = i8;
        this.highestSpeed = i9;
        this.overspeedCount = i10;
        this.overspeedCountEx = i11;
        this.highwayOverSpeedLowCnt = i12;
        this.highwayOverSpeedMidCnt = i13;
        this.highwayOverSpeedHighCnt = i14;
        this.normalOverSpeedLowCnt = i15;
        this.normalOverSpeedMidCnt = i16;
        this.normalOverSpeedHighCnt = i17;
        this.accidentAreaCount = i18;
        this.rerouteCount = i19;
        this.brakesCount = i20;
        this.slowTime = i21;
        this.arrTrafficDist = fArr;
        this.arrRoadDist = fArr2;
        this.arrSpeedClass = iArr;
    }
}
