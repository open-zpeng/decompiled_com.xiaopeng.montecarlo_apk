package com.autonavi.gbl.multi.display.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.display.DisplayCrop;
import com.autonavi.gbl.servicemanager.model.BusBusinessType;
@IntfAuto(target = DisplayCrop.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDisplayCropImpl {
    private static BindTable BIND_TABLE = new BindTable(IDisplayCropImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addGuideRouteObByCarControlNative(long j, IDisplayCropImpl iDisplayCropImpl);

    private static native void addMapViewObByFlyLineControlNative(long j, IDisplayCropImpl iDisplayCropImpl);

    private static native void destroyNativeObj(long j);

    private static native void enableAllVirtualBusesNative(long j, IDisplayCropImpl iDisplayCropImpl, boolean z);

    private static native void enableVirtualBusNative(long j, IDisplayCropImpl iDisplayCropImpl, int i, boolean z);

    private static native void openModeNative(long j, IDisplayCropImpl iDisplayCropImpl);

    private static native void removeGuideRouteObByCarControlNative(long j, IDisplayCropImpl iDisplayCropImpl);

    private static native void removeMapViewObByFlyLineControlNative(long j, IDisplayCropImpl iDisplayCropImpl);

    private static native void setLayerCollisionEnableNative(long j, IDisplayCropImpl iDisplayCropImpl, boolean z);

    private static native void setMapCallbackEnableNative(long j, IDisplayCropImpl iDisplayCropImpl, boolean z, boolean z2);

    private static native void showMapAllContentNative(long j, IDisplayCropImpl iDisplayCropImpl, boolean z);

    private static native void showMapRealCityNative(long j, IDisplayCropImpl iDisplayCropImpl, boolean z);

    public IDisplayCropImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDisplayCropImpl) && getUID(this) == getUID((IDisplayCropImpl) obj);
    }

    private static long getUID(IDisplayCropImpl iDisplayCropImpl) {
        long cPtr = getCPtr(iDisplayCropImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDisplayCropImpl iDisplayCropImpl) {
        if (iDisplayCropImpl == null) {
            return 0L;
        }
        return iDisplayCropImpl.swigCPtr;
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

    public void openMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openModeNative(j, this);
    }

    public void showMapAllContent(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showMapAllContentNative(j, this, z);
    }

    public void showMapRealCity(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showMapRealCityNative(j, this, z);
    }

    public void setMapCallbackEnable(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapCallbackEnableNative(j, this, z, z2);
    }

    public void enableAllVirtualBuses(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableAllVirtualBusesNative(j, this, z);
    }

    public void enableVirtualBus(@BusBusinessType.BusBusinessType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableVirtualBusNative(j, this, i, z);
    }

    public void setLayerCollisionEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLayerCollisionEnableNative(j, this, z);
    }

    public void addGuideRouteObByCarControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addGuideRouteObByCarControlNative(j, this);
    }

    public void removeGuideRouteObByCarControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeGuideRouteObByCarControlNative(j, this);
    }

    public void addMapViewObByFlyLineControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addMapViewObByFlyLineControlNative(j, this);
    }

    public void removeMapViewObByFlyLineControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeMapViewObByFlyLineControlNative(j, this);
    }
}
