package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.servicemanager.model.BusBusinessType;
/* loaded from: classes2.dex */
public class IKldDisplayCrop {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addGuideRouteObByCarControlNative(long j, IKldDisplayCrop iKldDisplayCrop);

    private static native void addMapViewObByFlyLineControlNative(long j, IKldDisplayCrop iKldDisplayCrop);

    private static native void destroyNativeObj(long j);

    private static native void enableAllVirtualBusesNative(long j, IKldDisplayCrop iKldDisplayCrop, boolean z);

    private static native void enableVirtualBusNative(long j, IKldDisplayCrop iKldDisplayCrop, int i, boolean z);

    private static native void openModeNative(long j, IKldDisplayCrop iKldDisplayCrop);

    private static native void removeGuideRouteObByCarControlNative(long j, IKldDisplayCrop iKldDisplayCrop);

    private static native void removeMapViewObByFlyLineControlNative(long j, IKldDisplayCrop iKldDisplayCrop);

    private static native void setLayerCollisionEnableNative(long j, IKldDisplayCrop iKldDisplayCrop, boolean z);

    private static native void setMapCallbackEnableNative(long j, IKldDisplayCrop iKldDisplayCrop, boolean z, boolean z2);

    private static native void showMapAllContentNative(long j, IKldDisplayCrop iKldDisplayCrop, boolean z);

    private static native void showMapRealCityNative(long j, IKldDisplayCrop iKldDisplayCrop, boolean z);

    public IKldDisplayCrop(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IKldDisplayCrop iKldDisplayCrop) {
        if (iKldDisplayCrop == null) {
            return 0L;
        }
        return iKldDisplayCrop.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
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
