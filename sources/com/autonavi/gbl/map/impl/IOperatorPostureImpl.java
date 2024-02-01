package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.SizeFloat;
import com.autonavi.gbl.map.OperatorPosture;
import com.autonavi.gbl.map.model.CalMapZoomerLonLatParam;
import com.autonavi.gbl.map.model.CalMapZoomerParam;
import com.autonavi.gbl.map.model.Matrix4x4F;
import com.autonavi.gbl.map.model.PointD;
import com.autonavi.gbl.map.model.PointF;
@IntfAuto(target = OperatorPosture.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IOperatorPostureImpl {
    private static BindTable BIND_TABLE = new BindTable(IOperatorPostureImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native float calcMapZoomScaleFactorNative(int i, int i2, float f);

    private static native float calculateMapZoomerLonLatNative(long j, IOperatorPostureImpl iOperatorPostureImpl, long j2, CalMapZoomerLonLatParam calMapZoomerLonLatParam);

    private static native float calculateMapZoomerNative(long j, IOperatorPostureImpl iOperatorPostureImpl, long j2, CalMapZoomerParam calMapZoomerParam);

    private static native long cloneDicePostureNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native long cloneMapPostureNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native void destroyClonedDicePostureNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native void destroyClonedMapPostureNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native void destroyNativeObj(long j);

    private static native float getCameraToCenterOriDisNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native RectDouble getMapBoundNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native void getMapCenterNative(long j, IOperatorPostureImpl iOperatorPostureImpl, long j2, Coord3DDouble coord3DDouble);

    private static native double getMapLenWithScreenByYNative(long j, IOperatorPostureImpl iOperatorPostureImpl, double d, double d2);

    private static native double getMapLenWithScreenNative(long j, IOperatorPostureImpl iOperatorPostureImpl, double d);

    private static native double getMaxPitchAngleNative();

    private static native float getMaxScaleNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native double getMinPitchAngleNative();

    private static native float getMinScaleNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getNearScaleRateNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getPitchAngleNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getPixelToWorldScaleNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native PointF getProjectionCenterNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native Matrix4x4F getProjectionMatrixNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getRawAngleNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getRollAngleNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getScaleFactorNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getScreenDpiNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native SizeFloat getScreenSizeNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native Matrix4x4F getViewMatrixNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native SizeFloat getViewSizeNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getWinSkyHeightNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native float getZoomLevelNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native boolean isSameCoordByLonLatNative(long j, Coord3DDouble coord3DDouble, long j2, Coord3DDouble coord3DDouble2);

    private static native PointD lonLatToMapNative(double d, double d2);

    private static native PointD lonLatToScreenNative(long j, IOperatorPostureImpl iOperatorPostureImpl, double d, double d2, double d3);

    private static native Coord2DDouble mapToLonLatNative(double d, double d2);

    private static native PointD mapToScreenNative(long j, IOperatorPostureImpl iOperatorPostureImpl, double d, double d2, double d3);

    private static native void meterToMapPixelNative(double d, double d2, double d3, double[] dArr);

    private static native int meterToP20Native(double d, double d2, float f);

    private static native void recalculateNative(long j, IOperatorPostureImpl iOperatorPostureImpl);

    private static native Coord2DDouble screenToLonLatNative(long j, IOperatorPostureImpl iOperatorPostureImpl, double d, double d2);

    private static native PointD screenToMapNative(long j, IOperatorPostureImpl iOperatorPostureImpl, double d, double d2);

    private static native void setMapCenter1Native(long j, IOperatorPostureImpl iOperatorPostureImpl, double d, double d2, double d3, boolean z, boolean z2);

    private static native void setMapCenterNative(long j, IOperatorPostureImpl iOperatorPostureImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setMaxZoomLevelNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f);

    private static native void setMinZoomLevelNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f);

    private static native void setNakeEyeProjectionCenterPercentNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f, float f2, float f3, float f4);

    private static native void setNearDefaultValueNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f, float f2);

    private static native void setPitchAngle1Native(long j, IOperatorPostureImpl iOperatorPostureImpl, float f, boolean z, boolean z2);

    private static native void setPitchAngleNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f);

    private static native void setProjectionCenterNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f, float f2);

    private static native void setRawAngleNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f);

    private static native void setRollAngle1Native(long j, IOperatorPostureImpl iOperatorPostureImpl, float f, boolean z, boolean z2);

    private static native void setRollAngleNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f);

    private static native boolean setWinSkyHeightNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f);

    private static native void setZoomLevel1Native(long j, IOperatorPostureImpl iOperatorPostureImpl, float f, boolean z, boolean z2);

    private static native void setZoomLevelNative(long j, IOperatorPostureImpl iOperatorPostureImpl, float f);

    private static native void updateDicePostureNative(long j, IOperatorPostureImpl iOperatorPostureImpl, long j2, IOperatorPostureImpl iOperatorPostureImpl2);

    private static native void updateMapPostureNative(long j, IOperatorPostureImpl iOperatorPostureImpl, long j2, IOperatorPostureImpl iOperatorPostureImpl2);

    public IOperatorPostureImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IOperatorPostureImpl) && getUID(this) == getUID((IOperatorPostureImpl) obj);
    }

    private static long getUID(IOperatorPostureImpl iOperatorPostureImpl) {
        long cPtr = getCPtr(iOperatorPostureImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IOperatorPostureImpl iOperatorPostureImpl) {
        if (iOperatorPostureImpl == null) {
            return 0L;
        }
        return iOperatorPostureImpl.swigCPtr;
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
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getViewSizeNative(j, this);
    }

    public SizeFloat getScreenSize() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScreenSizeNative(j, this);
    }

    public RectDouble getMapBound() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapBoundNative(j, this);
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

    public PointF getProjectionCenter() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getProjectionCenterNative(j, this);
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

    public boolean setWinSkyHeight(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setWinSkyHeightNative(j, this, f);
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

    public PointD screenToMap(double d, double d2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return screenToMapNative(j, this, d, d2);
    }

    public Coord2DDouble screenToLonLat(double d, double d2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return screenToLonLatNative(j, this, d, d2);
    }

    public PointD mapToScreen(double d, double d2, double d3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapToScreenNative(j, this, d, d2, d3);
    }

    public static Coord2DDouble mapToLonLat(double d, double d2) {
        return mapToLonLatNative(d, d2);
    }

    public static PointD lonLatToMap(double d, double d2) {
        return lonLatToMapNative(d, d2);
    }

    public PointD lonLatToScreen(double d, double d2, double d3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lonLatToScreenNative(j, this, d, d2, d3);
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

    public IOperatorPostureImpl cloneMapPosture() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long cloneMapPostureNative = cloneMapPostureNative(j, this);
        if (cloneMapPostureNative == 0) {
            return null;
        }
        return new IOperatorPostureImpl(cloneMapPostureNative, false);
    }

    public void updateMapPosture(IOperatorPostureImpl iOperatorPostureImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateMapPostureNative(j, this, getCPtr(iOperatorPostureImpl), iOperatorPostureImpl);
    }

    public static void destroyClonedMapPosture(IOperatorPostureImpl iOperatorPostureImpl) {
        destroyClonedMapPostureNative(getCPtr(iOperatorPostureImpl), iOperatorPostureImpl);
    }

    public IOperatorPostureImpl cloneDicePosture() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long cloneDicePostureNative = cloneDicePostureNative(j, this);
        if (cloneDicePostureNative == 0) {
            return null;
        }
        return new IOperatorPostureImpl(cloneDicePostureNative, false);
    }

    public void updateDicePosture(IOperatorPostureImpl iOperatorPostureImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateDicePostureNative(j, this, getCPtr(iOperatorPostureImpl), iOperatorPostureImpl);
    }

    public static void destroyClonedDicePosture(IOperatorPostureImpl iOperatorPostureImpl) {
        destroyClonedDicePostureNative(getCPtr(iOperatorPostureImpl), iOperatorPostureImpl);
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

    public void setNakeEyeProjectionCenterPercent(float f, float f2, float f3, float f4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNakeEyeProjectionCenterPercentNative(j, this, f, f2, f3, f4);
    }
}
