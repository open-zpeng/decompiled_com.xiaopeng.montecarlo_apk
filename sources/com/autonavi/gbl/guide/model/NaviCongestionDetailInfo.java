package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviCongestionDetailInfo implements Serializable {
    public int beginCoorIndex;
    public int beginCoorIndex3D;
    public int beginExactLength;
    public int beginExactLength3D;
    public Coord2DDouble beginExactPoint;
    public Coord3DDouble beginExactPoint3D;
    public int beginLinkIndex;
    public int beginSectionIndex;
    public int beginSegmentIndex;
    public int endCoorIndex;
    public int endCoorIndex3D;
    public int endExactLength;
    public int endExactLength3D;
    public Coord2DDouble endExactPoint;
    public Coord3DDouble endExactPoint3D;
    public int endLinkIndex;
    public int endSectionIndex;
    public int endSegmentIndex;
    public int remainDist;
    public int scopeFlag;
    @TrafficStatus.TrafficStatus1
    public int status;
    public int timeOfSeconds;

    public NaviCongestionDetailInfo() {
        this.timeOfSeconds = 0;
        this.scopeFlag = 0;
        this.beginSegmentIndex = 0;
        this.beginLinkIndex = 0;
        this.beginSectionIndex = 0;
        this.endSegmentIndex = 0;
        this.endLinkIndex = 0;
        this.endSectionIndex = 0;
        this.status = 0;
        this.remainDist = 0;
        this.beginExactLength = 0;
        this.beginExactPoint = new Coord2DDouble();
        this.beginCoorIndex = 0;
        this.endExactLength = 0;
        this.endExactPoint = new Coord2DDouble();
        this.endCoorIndex = 0;
        this.beginExactLength3D = 0;
        this.beginExactPoint3D = new Coord3DDouble();
        this.beginCoorIndex3D = 0;
        this.endExactLength3D = 0;
        this.endExactPoint3D = new Coord3DDouble();
        this.endCoorIndex3D = 0;
    }

    public NaviCongestionDetailInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @TrafficStatus.TrafficStatus1 int i9, int i10, int i11, Coord2DDouble coord2DDouble, int i12, int i13, Coord2DDouble coord2DDouble2, int i14, int i15, Coord3DDouble coord3DDouble, int i16, int i17, Coord3DDouble coord3DDouble2, int i18) {
        this.timeOfSeconds = i;
        this.scopeFlag = i2;
        this.beginSegmentIndex = i3;
        this.beginLinkIndex = i4;
        this.beginSectionIndex = i5;
        this.endSegmentIndex = i6;
        this.endLinkIndex = i7;
        this.endSectionIndex = i8;
        this.status = i9;
        this.remainDist = i10;
        this.beginExactLength = i11;
        this.beginExactPoint = coord2DDouble;
        this.beginCoorIndex = i12;
        this.endExactLength = i13;
        this.endExactPoint = coord2DDouble2;
        this.endCoorIndex = i14;
        this.beginExactLength3D = i15;
        this.beginExactPoint3D = coord3DDouble;
        this.beginCoorIndex3D = i16;
        this.endExactLength3D = i17;
        this.endExactPoint3D = coord3DDouble2;
        this.endCoorIndex3D = i18;
    }
}
