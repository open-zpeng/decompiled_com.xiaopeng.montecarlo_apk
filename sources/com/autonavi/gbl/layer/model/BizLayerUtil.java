package com.autonavi.gbl.layer.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.common.path.option.LinkInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.SegmentInfo;
import com.autonavi.gbl.common.path.option.impl.LinkInfoImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.common.path.option.impl.SegmentInfoImpl;
import com.autonavi.gbl.layer.model.impl.BizLayerUtilImpl;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.pos.model.LocInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = BizLayerUtilImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizLayerUtil {
    private static String PACKAGE = ReflexTool.PN(BizLayerUtil.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private BizLayerUtilImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizLayerUtil(long j, boolean z) {
        this(new BizLayerUtilImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizLayerUtil.class, this, this.mControl);
        }
    }

    public BizLayerUtil() {
        this(new BizLayerUtilImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizLayerUtil.class, this, this.mControl);
        }
    }

    public BizLayerUtil(BizLayerUtilImpl bizLayerUtilImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bizLayerUtilImpl);
    }

    private void $constructor(BizLayerUtilImpl bizLayerUtilImpl) {
        if (bizLayerUtilImpl != null) {
            this.mControl = bizLayerUtilImpl;
            this.mTargetId = String.format("BizLayerUtil_%s_%d", String.valueOf(BizLayerUtilImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BizLayerUtilImpl getControl() {
        return this.mControl;
    }

    public static RectDouble unionRect(RectDouble rectDouble) {
        return BizLayerUtilImpl.unionRect(rectDouble);
    }

    public static RectDouble unionRectMap(RectDouble rectDouble) {
        return BizLayerUtilImpl.unionRectMap(rectDouble);
    }

    public static RectDouble unionRectAndPoint2D(Coord2DDouble coord2DDouble) {
        return BizLayerUtilImpl.unionRectAndPoint2D(coord2DDouble);
    }

    public static Coord3DDouble[] calcCirclePointsByDistance(Coord3DDouble coord3DDouble, double d) {
        return BizLayerUtilImpl.calcCirclePointsByDistance(coord3DDouble, d);
    }

    public static RectDouble calcRectByCenterAndDistance(Coord2DDouble coord2DDouble, double d) {
        return BizLayerUtilImpl.calcRectByCenterAndDistance(coord2DDouble, d);
    }

    public static Coord3DDouble[] getLinkPoints(MapView mapView, LinkInfo linkInfo, boolean z) {
        MapViewImpl mapViewImpl;
        try {
            Method method = BizLayerUtil.class.getMethod("getLinkPoints", MapView.class, LinkInfo.class, Boolean.TYPE);
            if (mapView != null) {
                TypeHelper typeHelper = gTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $mapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.1
                    }));
                }
            } else {
                mapViewImpl = null;
            }
            if (linkInfo != null) {
                TypeHelper typeHelper2 = gTypeHelper;
                r0 = typeHelper2 != null ? (LinkInfoImpl) typeHelper2.transfer(method, 1, linkInfo) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $linkInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.2
                    }));
                }
            }
            return BizLayerUtilImpl.getLinkPoints(mapViewImpl, r0, z);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static Coord3DDouble[] getSegmentPoints(MapView mapView, SegmentInfo segmentInfo) {
        MapViewImpl mapViewImpl;
        try {
            Method method = BizLayerUtil.class.getMethod("getSegmentPoints", MapView.class, SegmentInfo.class);
            if (mapView != null) {
                TypeHelper typeHelper = gTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $mapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.3
                    }));
                }
            } else {
                mapViewImpl = null;
            }
            if (segmentInfo != null) {
                TypeHelper typeHelper2 = gTypeHelper;
                r0 = typeHelper2 != null ? (SegmentInfoImpl) typeHelper2.transfer(method, 1, segmentInfo) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $segmentInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.4
                    }));
                }
            }
            return BizLayerUtilImpl.getSegmentPoints(mapViewImpl, r0);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static CarLoc locToCarLoc(LocInfo locInfo) {
        return BizLayerUtilImpl.locToCarLoc(locInfo);
    }

    public static Coord3DDouble calcProjLine(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, Coord3DDouble coord3DDouble3) {
        return BizLayerUtilImpl.calcProjLine(coord3DDouble, coord3DDouble2, coord3DDouble3);
    }

    public static RectDouble getRect(ArrayList<Coord3DDouble> arrayList) {
        return BizLayerUtilImpl.getRect(arrayList);
    }

    public static RectDouble getRect(Coord3DDouble coord3DDouble, double d) {
        return BizLayerUtilImpl.getRect(coord3DDouble, d);
    }

    public static double calcDistanceBetweenPoints(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2) {
        return BizLayerUtilImpl.calcDistanceBetweenPoints(coord2DDouble, coord2DDouble2);
    }

    public static double calcDisPointToLine(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, Coord3DDouble coord3DDouble3) {
        return BizLayerUtilImpl.calcDisPointToLine(coord3DDouble, coord3DDouble2, coord3DDouble3);
    }

    public static Coord2DDouble getDistancePoint(double d, double d2, double d3, double d4, double d5) {
        return BizLayerUtilImpl.getDistancePoint(d, d2, d3, d4, d5);
    }

    public static double computeMeterPerPixel(double d, double d2) {
        return BizLayerUtilImpl.computeMeterPerPixel(d, d2);
    }

    public static boolean isDoubleEqual(double d, double d2) {
        return BizLayerUtilImpl.isDoubleEqual(d, d2);
    }

    public static boolean getManeuverSegmentPoints(MapView mapView, boolean z, PathInfo pathInfo, int i, ArrayList<Coord3DDouble> arrayList, ArrayList<Double> arrayList2) {
        MapViewImpl mapViewImpl;
        try {
            Method method = BizLayerUtil.class.getMethod("getManeuverSegmentPoints", MapView.class, Boolean.TYPE, PathInfo.class, Integer.TYPE, ArrayList.class, ArrayList.class);
            if (mapView != null) {
                TypeHelper typeHelper = gTypeHelper;
                MapViewImpl mapViewImpl2 = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl2 == null) {
                    DebugTool.e("%s: $mapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.5
                    }));
                }
                mapViewImpl = mapViewImpl2;
            } else {
                mapViewImpl = null;
            }
            if (pathInfo != null) {
                TypeHelper typeHelper2 = gTypeHelper;
                r4 = typeHelper2 != null ? (PathInfoImpl) typeHelper2.transfer(method, 2, pathInfo) : null;
                if (r4 == null) {
                    DebugTool.e("%s: $pathInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.6
                    }));
                }
            }
            return BizLayerUtilImpl.getManeuverSegmentPoints(mapViewImpl, z, r4, i, arrayList, arrayList2);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean isRectValid(RectInt rectInt) {
        return BizLayerUtilImpl.isRectValid(rectInt);
    }

    public static boolean rectIsInRect(RectInt rectInt, RectInt rectInt2) {
        return BizLayerUtilImpl.rectIsInRect(rectInt, rectInt2);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.7
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.8
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.model.BizLayerUtil.9
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
