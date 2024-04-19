package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.SizeFloat;
import com.autonavi.gbl.map.OperatorPosture;
import com.autonavi.gbl.map.model.CalMapZoomerLonLatParam;
import com.autonavi.gbl.map.model.CalMapZoomerParam;
import com.autonavi.gbl.map.model.MapBound;
import com.autonavi.gbl.map.model.Matrix4x4F;
import com.autonavi.gbl.map.model.PointD;
@IntfAuto(target = OperatorPosture.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class OperatorPostureImpl {
    private static BindTable BIND_TABLE = new BindTable(OperatorPostureImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native float calcMapZoomScaleFactorNative(int i, int i2, float f);

    private static native float calculateMapZoomerLonLatNative(long j, OperatorPostureImpl operatorPostureImpl, long j2, CalMapZoomerLonLatParam calMapZoomerLonLatParam);

    private static native float calculateMapZoomerNative(long j, OperatorPostureImpl operatorPostureImpl, long j2, CalMapZoomerParam calMapZoomerParam);

    private static native long cloneDicePostureNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native long cloneMapPostureNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void destroyClonedDicePostureNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void destroyClonedMapPostureNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void destroyNativeObj(long j);

    private static native float getCameraToCenterOriDisNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void getMapBoundNative(long j, OperatorPostureImpl operatorPostureImpl, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4);

    private static native void getMapCenterNative(long j, OperatorPostureImpl operatorPostureImpl, long j2, Coord3DDouble coord3DDouble);

    private static native double getMapLenWithScreenByYNative(long j, OperatorPostureImpl operatorPostureImpl, double d, double d2);

    private static native double getMapLenWithScreenNative(long j, OperatorPostureImpl operatorPostureImpl, double d);

    private static native double getMaxPitchAngleNative();

    private static native float getMaxScaleNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native double getMinPitchAngleNative();

    private static native float getMinScaleNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getNearScaleRateNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getPitchAngleNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getPixelToWorldScaleNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void getProjectionCenterNative(long j, OperatorPostureImpl operatorPostureImpl, float[] fArr, float[] fArr2);

    private static native Matrix4x4F getProjectionMatrixNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getRawAngleNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getRollAngleNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getScaleFactorNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getScreenDpiNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void getScreenSizeNative(long j, OperatorPostureImpl operatorPostureImpl, float[] fArr, float[] fArr2);

    private static native Matrix4x4F getViewMatrixNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void getViewSizeNative(long j, OperatorPostureImpl operatorPostureImpl, float[] fArr, float[] fArr2);

    private static native float getWinSkyHeightNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native float getZoomLevelNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native boolean isSameCoordByLonLatNative(long j, Coord3DDouble coord3DDouble, long j2, Coord3DDouble coord3DDouble2);

    private static native void lonLatToMapNative(double d, double d2, double[] dArr, double[] dArr2);

    private static native void lonLatToScreenNative(long j, OperatorPostureImpl operatorPostureImpl, double d, double d2, double d3, double[] dArr, double[] dArr2);

    private static native void mapToLonLatNative(double d, double d2, double[] dArr, double[] dArr2);

    private static native void mapToScreenNative(long j, OperatorPostureImpl operatorPostureImpl, double d, double d2, double d3, double[] dArr, double[] dArr2);

    private static native void meterToMapPixelNative(double d, double d2, double d3, double[] dArr);

    private static native int meterToP20Native(double d, double d2, float f);

    private static native void recalculateNative(long j, OperatorPostureImpl operatorPostureImpl);

    private static native void screenToLonLatNative(long j, OperatorPostureImpl operatorPostureImpl, double d, double d2, double[] dArr, double[] dArr2);

    private static native void screenToMapNative(long j, OperatorPostureImpl operatorPostureImpl, double d, double d2, double[] dArr, double[] dArr2);

    private static native void setMapCenter1Native(long j, OperatorPostureImpl operatorPostureImpl, double d, double d2, double d3, boolean z, boolean z2);

    private static native void setMapCenterNative(long j, OperatorPostureImpl operatorPostureImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setMaxZoomLevelNative(long j, OperatorPostureImpl operatorPostureImpl, float f);

    private static native void setMinZoomLevelNative(long j, OperatorPostureImpl operatorPostureImpl, float f);

    private static native void setNakeEyeProjectionCenterPercentNative(long j, OperatorPostureImpl operatorPostureImpl, float f, float f2, float f3, float f4);

    private static native void setNearDefaultValueNative(long j, OperatorPostureImpl operatorPostureImpl, float f, float f2);

    private static native void setPitchAngle1Native(long j, OperatorPostureImpl operatorPostureImpl, float f, boolean z, boolean z2);

    private static native void setPitchAngleNative(long j, OperatorPostureImpl operatorPostureImpl, float f);

    private static native void setProjectionCenterNative(long j, OperatorPostureImpl operatorPostureImpl, float f, float f2);

    private static native void setRawAngleNative(long j, OperatorPostureImpl operatorPostureImpl, float f);

    private static native void setRollAngle1Native(long j, OperatorPostureImpl operatorPostureImpl, float f, boolean z, boolean z2);

    private static native void setRollAngleNative(long j, OperatorPostureImpl operatorPostureImpl, float f);

    private static native void setZoomLevel1Native(long j, OperatorPostureImpl operatorPostureImpl, float f, boolean z, boolean z2);

    private static native void setZoomLevelNative(long j, OperatorPostureImpl operatorPostureImpl, float f);

    private static native void updateDicePostureNative(long j, OperatorPostureImpl operatorPostureImpl, long j2, OperatorPostureImpl operatorPostureImpl2);

    private static native void updateMapPostureNative(long j, OperatorPostureImpl operatorPostureImpl, long j2, OperatorPostureImpl operatorPostureImpl2);

    public OperatorPostureImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof OperatorPostureImpl) && getUID(this) == getUID((OperatorPostureImpl) obj);
    }

    private static long getUID(OperatorPostureImpl operatorPostureImpl) {
        long cPtr = getCPtr(operatorPostureImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(OperatorPostureImpl operatorPostureImpl) {
        if (operatorPostureImpl == null) {
            return 0L;
        }
        return operatorPostureImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static double getMaxPitchAngle() {
        return getMaxPitchAngleNative();
    }

    public static double getMinPitchAngle() {
        return getMinPitchAngleNative();
    }

    public static float calcMapZoomScaleFactor(int i, int i2, float f) {
        return calcMapZoomScaleFactorNative(i, i2, f);
    }

    public static int meterToP20(double d, double d2, float f) {
        return meterToP20Native(d, d2, f);
    }

    public SizeFloat getViewSize() {
        SizeFloat sizeFloat = new SizeFloat();
        float[] fArr = new float[1];
        float[] fArr2 = new float[1];
        getViewSize(fArr, fArr2);
        sizeFloat.width = fArr[0];
        sizeFloat.height = fArr2[0];
        return sizeFloat;
    }

    private void getViewSize(float[] fArr, float[] fArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getViewSizeNative(j, this, fArr, fArr2);
    }

    public SizeFloat getScreenSize() {
        SizeFloat sizeFloat = new SizeFloat();
        float[] fArr = new float[1];
        float[] fArr2 = new float[1];
        getScreenSize(fArr, fArr2);
        sizeFloat.width = fArr[0];
        sizeFloat.height = fArr2[0];
        return sizeFloat;
    }

    private void getScreenSize(float[] fArr, float[] fArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getScreenSizeNative(j, this, fArr, fArr2);
    }

    public MapBound getMapBound() {
        MapBound mapBound = new MapBound();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        double[] dArr3 = new double[1];
        double[] dArr4 = new double[1];
        getMapBound(dArr, dArr2, dArr3, dArr4);
        mapBound.left = dArr[0];
        mapBound.top = dArr2[0];
        mapBound.width = dArr3[0];
        mapBound.height = dArr4[0];
        return mapBound;
    }

    private void getMapBound(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getMapBoundNative(j, this, dArr, dArr2, dArr3, dArr4);
    }

    public Coord3DDouble getMapCenter() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getMapCenter(coord3DDouble);
        return coord3DDouble;
    }

    private void getMapCenter(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getMapCenterNative(j, this, 0L, coord3DDouble);
    }

    public SizeFloat getProjectionCenter() {
        SizeFloat sizeFloat = new SizeFloat();
        float[] fArr = new float[1];
        float[] fArr2 = new float[1];
        getProjectionCenter(fArr, fArr2);
        sizeFloat.width = fArr[0];
        sizeFloat.height = fArr2[0];
        return sizeFloat;
    }

    private void getProjectionCenter(float[] fArr, float[] fArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getProjectionCenterNative(j, this, fArr, fArr2);
    }

    public float getMaxScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMaxScaleNative(j, this);
    }

    public float getMinScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMinScaleNative(j, this);
    }

    public float getZoomLevel() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getZoomLevelNative(j, this);
    }

    public float getScaleFactor() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScaleFactorNative(j, this);
    }

    public float getPitchAngle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPitchAngleNative(j, this);
    }

    public float getRollAngle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRollAngleNative(j, this);
    }

    public float getRawAngle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRawAngleNative(j, this);
    }

    public float getWinSkyHeight() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getWinSkyHeightNative(j, this);
    }

    public float getScreenDpi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScreenDpiNative(j, this);
    }

    public float getNearScaleRate() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNearScaleRateNative(j, this);
    }

    public float getCameraToCenterOriDis() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCameraToCenterOriDisNative(j, this);
    }

    public float getPixelToWorldScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPixelToWorldScaleNative(j, this);
    }

    public void setMapCenter(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapCenterNative(j, this, 0L, coord3DDouble);
    }

    public void setMapCenter(double d, double d2, double d3, boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapCenter1Native(j, this, d, d2, d3, z, z2);
    }

    public void setProjectionCenter(float f, float f2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setProjectionCenterNative(j, this, f, f2);
    }

    public void setZoomLevel(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setZoomLevelNative(j, this, f);
    }

    public void setMaxZoomLevel(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMaxZoomLevelNative(j, this, f);
    }

    public void setMinZoomLevel(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMinZoomLevelNative(j, this, f);
    }

    public void setZoomLevel(float f, boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setZoomLevel1Native(j, this, f, z, z2);
    }

    public void setRollAngle(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRollAngleNative(j, this, f);
    }

    public void setRollAngle(float f, boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRollAngle1Native(j, this, f, z, z2);
    }

    public void setRawAngle(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRawAngleNative(j, this, f);
    }

    public void setPitchAngle(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPitchAngleNative(j, this, f);
    }

    public void setPitchAngle(float f, boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPitchAngle1Native(j, this, f, z, z2);
    }

    public void setNearDefaultValue(float f, float f2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNearDefaultValueNative(j, this, f, f2);
    }

    public void recalculate() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        recalculateNative(j, this);
    }

    public Coord2DDouble screenToMap(double d, double d2) {
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        screenToMap(d, d2, dArr, dArr2);
        coord2DDouble.lon = dArr[0];
        coord2DDouble.lat = dArr2[0];
        return coord2DDouble;
    }

    private void screenToMap(double d, double d2, double[] dArr, double[] dArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        screenToMapNative(j, this, d, d2, dArr, dArr2);
    }

    public Coord2DDouble screenToLonLat(double d, double d2) {
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        screenToLonLat(d, d2, dArr, dArr2);
        coord2DDouble.lon = dArr[0];
        coord2DDouble.lat = dArr2[0];
        return coord2DDouble;
    }

    private void screenToLonLat(double d, double d2, double[] dArr, double[] dArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        screenToLonLatNative(j, this, d, d2, dArr, dArr2);
    }

    public PointD mapToScreen(double d, double d2, double d3) {
        PointD pointD = new PointD();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        mapToScreen(d, d2, d3, dArr, dArr2);
        pointD.x = dArr[0];
        pointD.y = dArr2[0];
        return pointD;
    }

    private void mapToScreen(double d, double d2, double d3, double[] dArr, double[] dArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapToScreenNative(j, this, d, d2, d3, dArr, dArr2);
    }

    public static Coord2DDouble mapToLonLat(double d, double d2) {
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        mapToLonLat(d, d2, dArr, dArr2);
        coord2DDouble.lon = dArr[0];
        coord2DDouble.lat = dArr2[0];
        return coord2DDouble;
    }

    private static void mapToLonLat(double d, double d2, double[] dArr, double[] dArr2) {
        mapToLonLatNative(d, d2, dArr, dArr2);
    }

    public static Coord2DDouble lonLatToMap(double d, double d2) {
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        lonLatToMap(d, d2, dArr, dArr2);
        coord2DDouble.lon = dArr[0];
        coord2DDouble.lat = dArr2[0];
        return coord2DDouble;
    }

    private static void lonLatToMap(double d, double d2, double[] dArr, double[] dArr2) {
        lonLatToMapNative(d, d2, dArr, dArr2);
    }

    public PointD lonLatToScreen(double d, double d2, double d3) {
        PointD pointD = new PointD();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        lonLatToScreen(d, d2, d3, dArr, dArr2);
        pointD.x = dArr[0];
        pointD.y = dArr2[0];
        return pointD;
    }

    private void lonLatToScreen(double d, double d2, double d3, double[] dArr, double[] dArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lonLatToScreenNative(j, this, d, d2, d3, dArr, dArr2);
    }

    public double getMapLenWithScreen(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapLenWithScreenNative(j, this, d);
    }

    public double getMapLenWithScreenByY(double d, double d2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapLenWithScreenByYNative(j, this, d, d2);
    }

    public float calculateMapZoomer(CalMapZoomerParam calMapZoomerParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return calculateMapZoomerNative(j, this, 0L, calMapZoomerParam);
    }

    public float calculateMapZoomerLonLat(CalMapZoomerLonLatParam calMapZoomerLonLatParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return calculateMapZoomerLonLatNative(j, this, 0L, calMapZoomerLonLatParam);
    }

    public Matrix4x4F getViewMatrix() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getViewMatrixNative(j, this);
    }

    public Matrix4x4F getProjectionMatrix() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getProjectionMatrixNative(j, this);
    }

    public OperatorPostureImpl cloneMapPosture() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long cloneMapPostureNative = cloneMapPostureNative(j, this);
        if (cloneMapPostureNative == 0) {
            return null;
        }
        return new OperatorPostureImpl(cloneMapPostureNative, false);
    }

    public void updateMapPosture(OperatorPostureImpl operatorPostureImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateMapPostureNative(j, this, getCPtr(operatorPostureImpl), operatorPostureImpl);
    }

    public static void destroyClonedMapPosture(OperatorPostureImpl operatorPostureImpl) {
        destroyClonedMapPostureNative(getCPtr(operatorPostureImpl), operatorPostureImpl);
    }

    public OperatorPostureImpl cloneDicePosture() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long cloneDicePostureNative = cloneDicePostureNative(j, this);
        if (cloneDicePostureNative == 0) {
            return null;
        }
        return new OperatorPostureImpl(cloneDicePostureNative, false);
    }

    public void updateDicePosture(OperatorPostureImpl operatorPostureImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateDicePostureNative(j, this, getCPtr(operatorPostureImpl), operatorPostureImpl);
    }

    public void setNakeEyeProjectionCenterPercent(float f, float f2, float f3, float f4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNakeEyeProjectionCenterPercentNative(j, this, f, f2, f3, f4);
    }

    public static void destroyClonedDicePosture(OperatorPostureImpl operatorPostureImpl) {
        destroyClonedDicePostureNative(getCPtr(operatorPostureImpl), operatorPostureImpl);
    }

    public static double meterToMapPixel(double d, double d2, double d3) {
        double[] dArr = new double[1];
        meterToMapPixel(d, d2, d3, dArr);
        return dArr[0];
    }

    private static void meterToMapPixel(double d, double d2, double d3, double[] dArr) {
        meterToMapPixelNative(d, d2, d3, dArr);
    }

    public static boolean isSameCoordByLonLat(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2) {
        return isSameCoordByLonLatNative(0L, coord3DDouble, 0L, coord3DDouble2);
    }
}
