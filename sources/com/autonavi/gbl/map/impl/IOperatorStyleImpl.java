package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.OperatorStyle;
import com.autonavi.gbl.map.model.MapColorParam;
import com.autonavi.gbl.map.model.MapStyleParam;
import com.autonavi.gbl.map.model.MapStylesSetType;
import com.autonavi.gbl.map.observer.impl.IMapStyleSwitchObserverImpl;
@IntfAuto(target = OperatorStyle.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IOperatorStyleImpl {
    private static BindTable BIND_TABLE = new BindTable(IOperatorStyleImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native void getBackgroundColorNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, MapColorParam mapColorParam);

    private static native int getMapAssetStyleVersionNative(long j, IOperatorStyleImpl iOperatorStyleImpl);

    private static native int getMapStyleModeNative(long j, IOperatorStyleImpl iOperatorStyleImpl);

    private static native void getMapStyleNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, MapStyleParam mapStyleParam);

    private static native int getMapStyleStateNative(long j, IOperatorStyleImpl iOperatorStyleImpl);

    private static native int getMapStyleTimeNative(long j, IOperatorStyleImpl iOperatorStyleImpl);

    private static native void getRestoreMapStyleNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, MapStyleParam mapStyleParam);

    private static native boolean isSkinExistNative(long j, IOperatorStyleImpl iOperatorStyleImpl, int i, int i2, int i3);

    private static native void setBackgroundColorNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, MapColorParam mapColorParam);

    private static native boolean setBusRoutePreviewNative(long j, IOperatorStyleImpl iOperatorStyleImpl, boolean z);

    private static native void setMapBoardTextureNative(long j, IOperatorStyleImpl iOperatorStyleImpl, byte[] bArr);

    private static native boolean setMapStyleNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, MapStyleParam mapStyleParam, boolean z);

    private static native boolean setMapStylePathNative(long j, IOperatorStyleImpl iOperatorStyleImpl, String str);

    private static native void setMapStyleSwitchObserverNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl);

    private static native void setMaskColorNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, MapColorParam mapColorParam);

    private static native void setRestoreMapStyleNative(long j, IOperatorStyleImpl iOperatorStyleImpl, long j2, MapStyleParam mapStyleParam);

    private static native void setSkyTextureNative(long j, IOperatorStyleImpl iOperatorStyleImpl, byte[] bArr);

    private static native void setStyleParamNative(long j, IOperatorStyleImpl iOperatorStyleImpl, int i, boolean z);

    public IOperatorStyleImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IOperatorStyleImpl) && getUID(this) == getUID((IOperatorStyleImpl) obj);
    }

    private static long getUID(IOperatorStyleImpl iOperatorStyleImpl) {
        long cPtr = getCPtr(iOperatorStyleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IOperatorStyleImpl iOperatorStyleImpl) {
        if (iOperatorStyleImpl == null) {
            return 0L;
        }
        return iOperatorStyleImpl.swigCPtr;
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

    public boolean setMapStyle(MapStyleParam mapStyleParam, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMapStyleNative(j, this, 0L, mapStyleParam, z);
    }

    public boolean setBusRoutePreview(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setBusRoutePreviewNative(j, this, z);
    }

    public int getMapStyleMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapStyleModeNative(j, this);
    }

    public int getMapStyleTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapStyleTimeNative(j, this);
    }

    public int getMapStyleState() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapStyleStateNative(j, this);
    }

    public MapStyleParam getMapStyle() {
        MapStyleParam mapStyleParam = new MapStyleParam();
        getMapStyle(mapStyleParam);
        return mapStyleParam;
    }

    private void getMapStyle(MapStyleParam mapStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getMapStyleNative(j, this, 0L, mapStyleParam);
    }

    public void setRestoreMapStyle(MapStyleParam mapStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRestoreMapStyleNative(j, this, 0L, mapStyleParam);
    }

    public MapStyleParam getRestoreMapStyle() {
        MapStyleParam mapStyleParam = new MapStyleParam();
        getRestoreMapStyle(mapStyleParam);
        return mapStyleParam;
    }

    private void getRestoreMapStyle(MapStyleParam mapStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getRestoreMapStyleNative(j, this, 0L, mapStyleParam);
    }

    public boolean isSkinExist(int i, int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSkinExistNative(j, this, i, i2, i3);
    }

    public void setSkyTexture(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSkyTextureNative(j, this, bArr);
    }

    public void setMapBoardTexture(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapBoardTextureNative(j, this, bArr);
    }

    public void setBackgroundColor(MapColorParam mapColorParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setBackgroundColorNative(j, this, 0L, mapColorParam);
    }

    public MapColorParam getBackgroundColor() {
        MapColorParam mapColorParam = new MapColorParam();
        getBackgroundColor(mapColorParam);
        return mapColorParam;
    }

    private void getBackgroundColor(MapColorParam mapColorParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getBackgroundColorNative(j, this, 0L, mapColorParam);
    }

    public void setMaskColor(MapColorParam mapColorParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMaskColorNative(j, this, 0L, mapColorParam);
    }

    public void setStyleParam(@MapStylesSetType.MapStylesSetType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleParamNative(j, this, i, z);
    }

    public boolean setMapStylePath(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMapStylePathNative(j, this, str);
    }

    public void setMapStyleSwitchObserver(IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapStyleSwitchObserverNative(j, this, IMapStyleSwitchObserverImpl.getCPtr(iMapStyleSwitchObserverImpl), iMapStyleSwitchObserverImpl);
    }

    public int getMapAssetStyleVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapAssetStyleVersionNative(j, this);
    }
}
