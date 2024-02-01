package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizCarControl;
import com.autonavi.gbl.layer.model.BizCarType;
import com.autonavi.gbl.layer.model.SkeletonCarStatus;
import com.autonavi.gbl.map.impl.MixtureSharedBaseImpl;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.CarMode;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.observer.impl.ICarObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.PointLightParam;
import java.util.ArrayList;
@IntfAuto(target = BizCarControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizCarControlImpl extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizCarControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizCarControlImpl_SWIGUpcast(long j);

    private static native boolean addCarObserverNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2, ICarObserverImpl iCarObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native int getCarModeNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native void getCarPositionNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2, CarLoc carLoc);

    private static native boolean getCarUpModeNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native boolean getFollowModeNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native boolean getLockMapRollAngleNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native boolean getPreviewModeNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native long getStyleNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native boolean getVisibleNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native boolean matchBizControlNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2);

    private static native boolean removeCarObserverNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2, ICarObserverImpl iCarObserverImpl);

    private static native void restoreVisibleNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native void saveVisibleNative(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native void setCarAnimationSwitchNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void setCarModeNative(long j, IBizCarControlImpl iBizCarControlImpl, int i, boolean z);

    private static native void setCarPositionNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2, CarLoc carLoc);

    private static native boolean setCarScaleByMapLevelNative(long j, IBizCarControlImpl iBizCarControlImpl, float[] fArr);

    private static native void setCarUpModeNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void setClickableNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void setFollowModeNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void setLockMapRollAngleNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void setMaxPitchAngleNative(long j, IBizCarControlImpl iBizCarControlImpl, float f);

    private static native void setModelScaleNative(long j, IBizCarControlImpl iBizCarControlImpl, float f);

    private static native void setOcclusionCarNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void setPreviewModeNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void setRouteArrowPriorityNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2, LayerPriority layerPriority);

    private static native void setSkeletonBaseScaleNative(long j, IBizCarControlImpl iBizCarControlImpl, float f);

    private static native void setSkeletonCarStatusNative(long j, IBizCarControlImpl iBizCarControlImpl, int i);

    private static native void setSkeletonDataNative(long j, IBizCarControlImpl iBizCarControlImpl, byte[] bArr);

    private static native void setStyleNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisibleNative(long j, IBizCarControlImpl iBizCarControlImpl, boolean z);

    private static native void updateCarPositionNative(long j, IBizCarControlImpl iBizCarControlImpl, long j2, CarLoc carLoc);

    private static native void updatePointLightParamNative(long j, IBizCarControlImpl iBizCarControlImpl, ArrayList<PointLightParam> arrayList);

    private static native void updateStyle1Native(long j, IBizCarControlImpl iBizCarControlImpl);

    private static native void updateStyleNative(long j, IBizCarControlImpl iBizCarControlImpl, int i);

    public IBizCarControlImpl(long j, boolean z) {
        super(IBizCarControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizCarControlImpl) {
            return getUID(this) == getUID((IBizCarControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizCarControlImpl iBizCarControlImpl) {
        long cPtr = getCPtr(iBizCarControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizCarControlImpl iBizCarControlImpl) {
        if (iBizCarControlImpl == null) {
            return 0L;
        }
        return iBizCarControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public IPrepareLayerStyleImpl getStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long styleNative = getStyleNative(j, this);
        if (styleNative == 0) {
            return null;
        }
        return new IPrepareLayerStyleImpl(styleNative, false);
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

    public boolean matchBizControl(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return matchBizControlNative(j2, this, j);
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

    public void setSkeletonBaseScale(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSkeletonBaseScaleNative(j, this, f);
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

    public CarLoc getCarPosition() {
        CarLoc carLoc = new CarLoc();
        getCarPosition(carLoc);
        return carLoc;
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

    public boolean getVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this);
    }

    public void saveVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        saveVisibleNative(j, this);
    }

    public void restoreVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        restoreVisibleNative(j, this);
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

    public void updatePointLightParam(ArrayList<PointLightParam> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePointLightParamNative(j, this, arrayList);
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
