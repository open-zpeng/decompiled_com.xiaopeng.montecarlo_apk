package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.BizCarControl;
import com.autonavi.gbl.layer.model.BizCarType;
import com.autonavi.gbl.layer.model.SkeletonCarStatus;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.CarMode;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.observer.impl.ICarObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
@IntfAuto(target = BizCarControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizCarControl {
    private static BindTable BIND_TABLE = new BindTable(IBizCarControl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addCarObserverNative(long j, IBizCarControl iBizCarControl, long j2, ICarObserverImpl iCarObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native int getCarModeNative(long j, IBizCarControl iBizCarControl);

    private static native void getCarPositionNative(long j, IBizCarControl iBizCarControl, long j2, CarLoc carLoc);

    private static native boolean getCarUpModeNative(long j, IBizCarControl iBizCarControl);

    private static native boolean getFollowModeNative(long j, IBizCarControl iBizCarControl);

    private static native boolean getLockMapRollAngleNative(long j, IBizCarControl iBizCarControl);

    private static native boolean getPreviewModeNative(long j, IBizCarControl iBizCarControl);

    private static native boolean removeCarObserverNative(long j, IBizCarControl iBizCarControl, long j2, ICarObserverImpl iCarObserverImpl);

    private static native void setCarAnimationSwitchNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void setCarModeNative(long j, IBizCarControl iBizCarControl, int i, boolean z);

    private static native void setCarPositionNative(long j, IBizCarControl iBizCarControl, long j2, CarLoc carLoc);

    private static native boolean setCarScaleByMapLevelNative(long j, IBizCarControl iBizCarControl, float[] fArr);

    private static native void setCarUpModeNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void setClickableNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void setFollowModeNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void setLockMapRollAngleNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void setMaxPitchAngleNative(long j, IBizCarControl iBizCarControl, float f);

    private static native void setModelScaleNative(long j, IBizCarControl iBizCarControl, float f);

    private static native void setOcclusionCarNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void setPreviewModeNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void setRouteArrowPriorityNative(long j, IBizCarControl iBizCarControl, long j2, LayerPriority layerPriority);

    private static native void setSkeletonCarStatusNative(long j, IBizCarControl iBizCarControl, int i);

    private static native void setSkeletonDataNative(long j, IBizCarControl iBizCarControl, byte[] bArr);

    private static native void setStyleNative(long j, IBizCarControl iBizCarControl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisibleNative(long j, IBizCarControl iBizCarControl, boolean z);

    private static native void updateCarPositionNative(long j, IBizCarControl iBizCarControl, long j2, CarLoc carLoc);

    private static native void updateStyle1Native(long j, IBizCarControl iBizCarControl);

    private static native void updateStyleNative(long j, IBizCarControl iBizCarControl, int i);

    public IBizCarControl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizCarControl) && getUID(this) == getUID((IBizCarControl) obj);
    }

    private static long getUID(IBizCarControl iBizCarControl) {
        long cPtr = getCPtr(iBizCarControl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizCarControl iBizCarControl) {
        if (iBizCarControl == null) {
            return 0L;
        }
        return iBizCarControl.swigCPtr;
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

    public CarLoc getCarPosition() {
        CarLoc carLoc = new CarLoc();
        getCarPosition(carLoc);
        return carLoc;
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public void updateStyle(@BizCarType.BizCarType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateStyleNative(j, this, i);
    }

    public void updateStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateStyle1Native(j, this);
    }

    public void setCarMode(@CarMode.CarMode1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarModeNative(j, this, i, z);
    }

    @CarMode.CarMode1
    public int getCarMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCarModeNative(j, this);
    }

    public void setSkeletonData(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSkeletonDataNative(j, this, bArr);
    }

    public void setFollowMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFollowModeNative(j, this, z);
    }

    public boolean getFollowMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFollowModeNative(j, this);
    }

    public void setCarUpMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarUpModeNative(j, this, z);
    }

    public boolean getCarUpMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCarUpModeNative(j, this);
    }

    public void setPreviewMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPreviewModeNative(j, this, z);
    }

    public boolean getPreviewMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPreviewModeNative(j, this);
    }

    public void setLockMapRollAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLockMapRollAngleNative(j, this, z);
    }

    public boolean getLockMapRollAngle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLockMapRollAngleNative(j, this);
    }

    public void setSkeletonCarStatus(@SkeletonCarStatus.SkeletonCarStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSkeletonCarStatusNative(j, this, i);
    }

    public void setCarPosition(CarLoc carLoc) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarPositionNative(j, this, 0L, carLoc);
    }

    private void getCarPosition(CarLoc carLoc) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getCarPositionNative(j, this, 0L, carLoc);
    }

    public void updateCarPosition(CarLoc carLoc) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCarPositionNative(j, this, 0L, carLoc);
    }

    public void setOcclusionCar(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOcclusionCarNative(j, this, z);
    }

    public void setRouteArrowPriority(LayerPriority layerPriority) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRouteArrowPriorityNative(j, this, 0L, layerPriority);
    }

    public boolean setCarScaleByMapLevel(float[] fArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCarScaleByMapLevelNative(j, this, fArr);
    }

    public void setMaxPitchAngle(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMaxPitchAngleNative(j, this, f);
    }

    public void setVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j, this, z);
    }

    public void setCarAnimationSwitch(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarAnimationSwitchNative(j, this, z);
    }

    public void setClickable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setClickableNative(j, this, z);
    }

    public void setModelScale(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setModelScaleNative(j, this, f);
    }

    public boolean addCarObserver(ICarObserverImpl iCarObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addCarObserverNative(j, this, ICarObserverImpl.getCPtr(iCarObserverImpl), iCarObserverImpl);
    }

    public boolean removeCarObserver(ICarObserverImpl iCarObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeCarObserverNative(j, this, ICarObserverImpl.getCPtr(iCarObserverImpl), iCarObserverImpl);
    }
}
