package com.autonavi.gbl.layer.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.common.path.option.LinkInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.SegmentInfo;
import com.autonavi.gbl.layer.model.BizLayerUtil;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.pos.model.LocInfo;
import java.util.ArrayList;
@IntfAuto(target = BizLayerUtil.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class BizLayerUtilImpl {
    private static BindTable BIND_TABLE = new BindTable(BizLayerUtilImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void calcCirclePointsByDistanceNative(long j, Coord3DDouble coord3DDouble, double d, ArrayList<Coord3DDouble> arrayList);

    private static native double calcDisPointToLineNative(long j, Coord3DDouble coord3DDouble, long j2, Coord3DDouble coord3DDouble2, long j3, Coord3DDouble coord3DDouble3);

    private static native double calcDistanceBetweenPointsNative(long j, Coord2DDouble coord2DDouble, long j2, Coord2DDouble coord2DDouble2);

    private static native void calcRectByCenterAndDistanceNative(long j, Coord2DDouble coord2DDouble, double d, long j2, RectDouble rectDouble);

    private static native double computeMeterPerPixelNative(double d, double d2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native Coord2DDouble getDistancePointNative(double d, double d2, double d3, double d4, double d5);

    private static native void getLinkPoints1Native(long j, IMapViewImpl iMapViewImpl, long j2, LinkInfo linkInfo, ArrayList<Coord3DDouble> arrayList);

    private static native void getLinkPointsNative(long j, IMapViewImpl iMapViewImpl, long j2, LinkInfo linkInfo, ArrayList<Coord3DDouble> arrayList, boolean z);

    private static native boolean getManeuverSegmentPointsNative(long j, IMapViewImpl iMapViewImpl, boolean z, long j2, PathInfo pathInfo, int i, ArrayList<Coord3DDouble> arrayList, ArrayList<Double> arrayList2);

    private static native boolean getRect1Native(long j, Coord3DDouble coord3DDouble, double d, long j2, RectDouble rectDouble);

    private static native boolean getRectNative(ArrayList<Coord3DDouble> arrayList, long j, RectDouble rectDouble);

    private static native void getSegmentPointsNative(long j, IMapViewImpl iMapViewImpl, long j2, SegmentInfo segmentInfo, ArrayList<Coord3DDouble> arrayList);

    private static native boolean isDoubleEqualNative(double d, double d2);

    private static native boolean isRectValidNative(long j, RectInt rectInt);

    private static native void locToCarLocNative(long j, LocInfo locInfo, long j2, CarLoc carLoc);

    private static native boolean rectIsInRectNative(long j, RectInt rectInt, long j2, RectInt rectInt2);

    private static native void unionRectAndPoint2DNative(long j, Coord2DDouble coord2DDouble, long j2, RectDouble rectDouble);

    private static native void unionRectMapNative(long j, RectDouble rectDouble, long j2, RectDouble rectDouble2);

    private static native void unionRectNative(long j, RectDouble rectDouble, long j2, RectDouble rectDouble2);

    public BizLayerUtilImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BizLayerUtilImpl) && getUID(this) == getUID((BizLayerUtilImpl) obj);
    }

    private static long getUID(BizLayerUtilImpl bizLayerUtilImpl) {
        long cPtr = getCPtr(bizLayerUtilImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BizLayerUtilImpl bizLayerUtilImpl) {
        if (bizLayerUtilImpl == null) {
            return 0L;
        }
        return bizLayerUtilImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static double calcDistanceBetweenPoints(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2) {
        return calcDistanceBetweenPointsNative(0L, coord2DDouble, 0L, coord2DDouble2);
    }

    public static double calcDisPointToLine(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, Coord3DDouble coord3DDouble3) {
        return calcDisPointToLineNative(0L, coord3DDouble, 0L, coord3DDouble2, 0L, coord3DDouble3);
    }

    public static RectDouble getRect(ArrayList<Coord3DDouble> arrayList) {
        RectDouble rectDouble = new RectDouble();
        if (Boolean.valueOf(getRect(arrayList, rectDouble)).booleanValue()) {
            return rectDouble;
        }
        return null;
    }

    private static boolean getRect(ArrayList<Coord3DDouble> arrayList, RectDouble rectDouble) {
        return getRectNative(arrayList, 0L, rectDouble);
    }

    public static RectDouble getRect(Coord3DDouble coord3DDouble, double d) {
        RectDouble rectDouble = new RectDouble();
        if (Boolean.valueOf(getRect(coord3DDouble, d, rectDouble)).booleanValue()) {
            return rectDouble;
        }
        return null;
    }

    private static boolean getRect(Coord3DDouble coord3DDouble, double d, RectDouble rectDouble) {
        return getRect1Native(0L, coord3DDouble, d, 0L, rectDouble);
    }

    public static RectDouble unionRect(RectDouble rectDouble) {
        RectDouble rectDouble2 = new RectDouble();
        unionRect(rectDouble, rectDouble2);
        return rectDouble2;
    }

    private static void unionRect(RectDouble rectDouble, RectDouble rectDouble2) {
        unionRectNative(0L, rectDouble, 0L, rectDouble2);
    }

    public static RectDouble unionRectMap(RectDouble rectDouble) {
        RectDouble rectDouble2 = new RectDouble();
        unionRectMap(rectDouble, rectDouble2);
        return rectDouble2;
    }

    private static void unionRectMap(RectDouble rectDouble, RectDouble rectDouble2) {
        unionRectMapNative(0L, rectDouble, 0L, rectDouble2);
    }

    public static Coord3DDouble[] calcCirclePointsByDistance(Coord3DDouble coord3DDouble, double d) {
        ArrayList arrayList = new ArrayList();
        calcCirclePointsByDistance(coord3DDouble, d, arrayList);
        if (arrayList.size() > 0) {
            Coord3DDouble[] coord3DDoubleArr = new Coord3DDouble[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                coord3DDoubleArr[i] = (Coord3DDouble) arrayList.get(i);
            }
            return coord3DDoubleArr;
        }
        return null;
    }

    private static void calcCirclePointsByDistance(Coord3DDouble coord3DDouble, double d, ArrayList<Coord3DDouble> arrayList) {
        calcCirclePointsByDistanceNative(0L, coord3DDouble, d, arrayList);
    }

    public static Coord2DDouble getDistancePoint(double d, double d2, double d3, double d4, double d5) {
        return getDistancePointNative(d, d2, d3, d4, d5);
    }

    public static RectDouble unionRectAndPoint2D(Coord2DDouble coord2DDouble) {
        RectDouble rectDouble = new RectDouble();
        unionRectAndPoint2D(coord2DDouble, rectDouble);
        return rectDouble;
    }

    private static void unionRectAndPoint2D(Coord2DDouble coord2DDouble, RectDouble rectDouble) {
        unionRectAndPoint2DNative(0L, coord2DDouble, 0L, rectDouble);
    }

    public static RectDouble calcRectByCenterAndDistance(Coord2DDouble coord2DDouble, double d) {
        RectDouble rectDouble = new RectDouble();
        calcRectByCenterAndDistance(coord2DDouble, d, rectDouble);
        return rectDouble;
    }

    private static void calcRectByCenterAndDistance(Coord2DDouble coord2DDouble, double d, RectDouble rectDouble) {
        calcRectByCenterAndDistanceNative(0L, coord2DDouble, d, 0L, rectDouble);
    }

    public static double computeMeterPerPixel(double d, double d2) {
        return computeMeterPerPixelNative(d, d2);
    }

    public static boolean isDoubleEqual(double d, double d2) {
        return isDoubleEqualNative(d, d2);
    }

    public static CarLoc locToCarLoc(LocInfo locInfo) {
        CarLoc carLoc = new CarLoc();
        locToCarLoc(locInfo, carLoc);
        return carLoc;
    }

    private static void locToCarLoc(LocInfo locInfo, CarLoc carLoc) {
        locToCarLocNative(0L, locInfo, 0L, carLoc);
    }

    public static boolean getManeuverSegmentPoints(IMapViewImpl iMapViewImpl, boolean z, PathInfo pathInfo, int i, ArrayList<Coord3DDouble> arrayList, ArrayList<Double> arrayList2) {
        return getManeuverSegmentPointsNative(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, z, PathInfo.getCPtr(pathInfo), pathInfo, i, arrayList, arrayList2);
    }

    public static Coord3DDouble[] getLinkPoints(IMapViewImpl iMapViewImpl, LinkInfo linkInfo, boolean z) {
        ArrayList arrayList = new ArrayList();
        getLinkPoints(iMapViewImpl, linkInfo, arrayList, z);
        if (arrayList.size() > 0) {
            Coord3DDouble[] coord3DDoubleArr = new Coord3DDouble[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                coord3DDoubleArr[i] = (Coord3DDouble) arrayList.get(i);
            }
            return coord3DDoubleArr;
        }
        return null;
    }

    private static void getLinkPoints(IMapViewImpl iMapViewImpl, LinkInfo linkInfo, ArrayList<Coord3DDouble> arrayList, boolean z) {
        getLinkPointsNative(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, LinkInfo.getCPtr(linkInfo), linkInfo, arrayList, z);
    }

    public static Coord3DDouble[] getLinkPoints(IMapViewImpl iMapViewImpl, LinkInfo linkInfo) {
        ArrayList arrayList = new ArrayList();
        getLinkPoints(iMapViewImpl, linkInfo, arrayList);
        if (arrayList.size() > 0) {
            Coord3DDouble[] coord3DDoubleArr = new Coord3DDouble[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                coord3DDoubleArr[i] = (Coord3DDouble) arrayList.get(i);
            }
            return coord3DDoubleArr;
        }
        return null;
    }

    private static void getLinkPoints(IMapViewImpl iMapViewImpl, LinkInfo linkInfo, ArrayList<Coord3DDouble> arrayList) {
        getLinkPoints1Native(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, LinkInfo.getCPtr(linkInfo), linkInfo, arrayList);
    }

    public static Coord3DDouble[] getSegmentPoints(IMapViewImpl iMapViewImpl, SegmentInfo segmentInfo) {
        ArrayList arrayList = new ArrayList();
        getSegmentPoints(iMapViewImpl, segmentInfo, arrayList);
        if (arrayList.size() > 0) {
            Coord3DDouble[] coord3DDoubleArr = new Coord3DDouble[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                coord3DDoubleArr[i] = (Coord3DDouble) arrayList.get(i);
            }
            return coord3DDoubleArr;
        }
        return null;
    }

    private static void getSegmentPoints(IMapViewImpl iMapViewImpl, SegmentInfo segmentInfo, ArrayList<Coord3DDouble> arrayList) {
        getSegmentPointsNative(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, SegmentInfo.getCPtr(segmentInfo), segmentInfo, arrayList);
    }

    public static boolean isRectValid(RectInt rectInt) {
        return isRectValidNative(0L, rectInt);
    }

    public static boolean rectIsInRect(RectInt rectInt, RectInt rectInt2) {
        return rectIsInRectNative(0L, rectInt, 0L, rectInt2);
    }

    public BizLayerUtilImpl() {
        this(createNativeObj(), true);
    }
}
