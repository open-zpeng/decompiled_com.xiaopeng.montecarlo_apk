package com.autonavi.gbl.multi.display.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.impl.IMapDeviceImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.multi.display.Display;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl;
@IntfAuto(target = Display.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDisplayImpl {
    private static BindTable BIND_TABLE = new BindTable(IDisplayImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addObserverNative(long j, IDisplayImpl iDisplayImpl, long j2, IMapDisplayObserverImpl iMapDisplayObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native long getCropNative(long j, IDisplayImpl iDisplayImpl);

    private static native int getIdNative(long j, IDisplayImpl iDisplayImpl);

    private static native long getMapDeviceNative(long j, IDisplayImpl iDisplayImpl);

    private static native long getMapViewNative(long j, IDisplayImpl iDisplayImpl);

    private static native int getTypeNative(long j, IDisplayImpl iDisplayImpl);

    private static native boolean isRemoteNative(long j, IDisplayImpl iDisplayImpl);

    private static native void removeObserverNative(long j, IDisplayImpl iDisplayImpl, long j2, IMapDisplayObserverImpl iMapDisplayObserverImpl);

    public IDisplayImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDisplayImpl) && getUID(this) == getUID((IDisplayImpl) obj);
    }

    private static long getUID(IDisplayImpl iDisplayImpl) {
        long cPtr = getCPtr(iDisplayImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDisplayImpl iDisplayImpl) {
        if (iDisplayImpl == null) {
            return 0L;
        }
        return iDisplayImpl.swigCPtr;
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

    public int getId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getIdNative(j, this);
    }

    @DisplayType.DisplayType1
    public int getType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTypeNative(j, this);
    }

    public boolean isRemote() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRemoteNative(j, this);
    }

    public IMapViewImpl getMapView() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapViewNative = getMapViewNative(j, this);
        if (mapViewNative == 0) {
            return null;
        }
        return new IMapViewImpl(mapViewNative, false);
    }

    public IMapDeviceImpl getMapDevice() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapDeviceNative = getMapDeviceNative(j, this);
        if (mapDeviceNative == 0) {
            return null;
        }
        return new IMapDeviceImpl(mapDeviceNative, false);
    }

    public IDisplayCropImpl getCrop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long cropNative = getCropNative(j, this);
        if (cropNative == 0) {
            return null;
        }
        return new IDisplayCropImpl(cropNative, false);
    }

    public void addObserver(IMapDisplayObserverImpl iMapDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addObserverNative(j, this, IMapDisplayObserverImpl.getCPtr(iMapDisplayObserverImpl), iMapDisplayObserverImpl);
    }

    public void removeObserver(IMapDisplayObserverImpl iMapDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IMapDisplayObserverImpl.getCPtr(iMapDisplayObserverImpl), iMapDisplayObserverImpl);
    }
}
