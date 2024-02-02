package com.autonavi.gbl.map.impl;

import android.view.Surface;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.model.BLGLParameter;
import com.autonavi.gbl.map.model.DeviceFilterParam;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapRenderMode;
import com.autonavi.gbl.map.model.ScreenShotCallbackMethod;
import com.autonavi.gbl.map.model.ScreenShotMode;
import com.autonavi.gbl.map.model.ScreenShotParam;
import com.autonavi.gbl.map.model.ScreenshotCarType;
import com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl;
import com.autonavi.gbl.map.observer.impl.IEGLScreenshotObserverImpl;
@IntfAuto(target = MapDevice.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class MapDeviceImpl {
    private static BindTable BIND_TABLE = new BindTable(MapDeviceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addDeviceObserverNative(long j, MapDeviceImpl mapDeviceImpl, long j2, IDeviceObserverImpl iDeviceObserverImpl);

    private static native void attachSurfaceToDeviceNative(long j, MapDeviceImpl mapDeviceImpl, long j2, EGLSurfaceAttr eGLSurfaceAttr);

    private static native boolean changeDeviceSizeNative(long j, MapDeviceImpl mapDeviceImpl, long j2, EGLSurfaceAttr eGLSurfaceAttr);

    private static native void destoryFilterFBONative(long j, MapDeviceImpl mapDeviceImpl);

    private static native void destroyNativeObj(long j);

    private static native void detachSurfaceFromDeviceNative(long j, MapDeviceImpl mapDeviceImpl);

    private static native int getDeviceIdNative(long j, MapDeviceImpl mapDeviceImpl);

    private static native int getRenderFpsByModeNative(long j, MapDeviceImpl mapDeviceImpl, int i);

    private static native int getScreenShotModeNative(long j, MapDeviceImpl mapDeviceImpl);

    private static native long getWindowFromSurfaceNative(long j, MapDeviceImpl mapDeviceImpl, long j2, Surface surface);

    private static native boolean isRenderPausedNative(long j, MapDeviceImpl mapDeviceImpl);

    private static native void removeDeviceObserverNative(long j, MapDeviceImpl mapDeviceImpl, long j2, IDeviceObserverImpl iDeviceObserverImpl);

    private static native void renderPauseNative(long j, MapDeviceImpl mapDeviceImpl);

    private static native void renderResumeNative(long j, MapDeviceImpl mapDeviceImpl);

    private static native void resetRenderStateNative(long j, MapDeviceImpl mapDeviceImpl);

    private static native void resetTickCountNative(long j, MapDeviceImpl mapDeviceImpl, int i);

    private static native void setFilterParamNative(long j, MapDeviceImpl mapDeviceImpl, long j2, DeviceFilterParam deviceFilterParam);

    private static native void setInnerRenderResumeNative(long j, MapDeviceImpl mapDeviceImpl, boolean z);

    private static native void setMaxFpsNative(long j, MapDeviceImpl mapDeviceImpl, long j2);

    private static native void setMinFpsNative(long j, MapDeviceImpl mapDeviceImpl, long j2);

    private static native void setRenderFpsByMode1Native(long j, MapDeviceImpl mapDeviceImpl, int i, int i2);

    private static native void setRenderFpsByModeNative(long j, MapDeviceImpl mapDeviceImpl, int i);

    private static native void setRenderFpsWithTimerNative(long j, MapDeviceImpl mapDeviceImpl, int i, boolean z);

    private static native void setScreenshotCallBackMethodNative(long j, MapDeviceImpl mapDeviceImpl, int i);

    private static native void setScreenshotCarTypeNative(long j, MapDeviceImpl mapDeviceImpl, int i);

    private static native void setScreenshotMode1Native(long j, MapDeviceImpl mapDeviceImpl, int i, long j2, IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl);

    private static native void setScreenshotModeNative(long j, MapDeviceImpl mapDeviceImpl, int i);

    private static native void setScreenshotParameterNative(long j, MapDeviceImpl mapDeviceImpl, int i, long j2, ScreenShotParam screenShotParam);

    private static native void setScreenshotRectNative(long j, MapDeviceImpl mapDeviceImpl, int i, int i2, int i3, int i4);

    public MapDeviceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof MapDeviceImpl) && getUID(this) == getUID((MapDeviceImpl) obj);
    }

    private static long getUID(MapDeviceImpl mapDeviceImpl) {
        long cPtr = getCPtr(mapDeviceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MapDeviceImpl mapDeviceImpl) {
        if (mapDeviceImpl == null) {
            return 0L;
        }
        return mapDeviceImpl.swigCPtr;
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

    public void addDeviceObserver(IDeviceObserverImpl iDeviceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addDeviceObserverNative(j, this, IDeviceObserverImpl.getCPtr(iDeviceObserverImpl), iDeviceObserverImpl);
    }

    public void removeDeviceObserver(IDeviceObserverImpl iDeviceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeDeviceObserverNative(j, this, IDeviceObserverImpl.getCPtr(iDeviceObserverImpl), iDeviceObserverImpl);
    }

    @EGLDeviceID.EGLDeviceID1
    public int getDeviceId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDeviceIdNative(j, this);
    }

    public void attachSurfaceToDevice(EGLSurfaceAttr eGLSurfaceAttr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        attachSurfaceToDeviceNative(j, this, 0L, eGLSurfaceAttr);
    }

    public void detachSurfaceFromDevice() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        detachSurfaceFromDeviceNative(j, this);
    }

    public boolean changeDeviceSize(EGLSurfaceAttr eGLSurfaceAttr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return changeDeviceSizeNative(j, this, 0L, eGLSurfaceAttr);
    }

    public long getWindowFromSurface(Surface surface) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getWindowFromSurfaceNative(j, this, 0L, surface);
    }

    public void setRenderFpsByMode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRenderFpsByModeNative(j, this, i);
    }

    public void setRenderFpsByMode(@MapRenderMode.MapRenderMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRenderFpsByMode1Native(j, this, i, i2);
    }

    public int getRenderFpsByMode(@MapRenderMode.MapRenderMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRenderFpsByModeNative(j, this, i);
    }

    public void setRenderFpsWithTimer(int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRenderFpsWithTimerNative(j, this, i, z);
    }

    public void resetTickCount(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetTickCountNative(j, this, i);
    }

    public void renderPause() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        renderPauseNative(j, this);
    }

    public void renderResume() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        renderResumeNative(j, this);
    }

    public void setInnerRenderResume(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setInnerRenderResumeNative(j, this, z);
    }

    public boolean isRenderPaused() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRenderPausedNative(j, this);
    }

    public void setMaxFps(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setMaxFpsNative(j2, this, j);
    }

    public void setMinFps(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setMinFpsNative(j2, this, j);
    }

    public void resetRenderState() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetRenderStateNative(j, this);
    }

    public void setScreenshotCarType(@ScreenshotCarType.ScreenshotCarType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenshotCarTypeNative(j, this, i);
    }

    public void setScreenshotMode(@ScreenShotMode.ScreenShotMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenshotModeNative(j, this, i);
    }

    public void setScreenshotMode(@ScreenShotMode.ScreenShotMode1 int i, IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenshotMode1Native(j, this, i, IEGLScreenshotObserverImpl.getCPtr(iEGLScreenshotObserverImpl), iEGLScreenshotObserverImpl);
    }

    public void setScreenshotRect(int i, int i2, int i3, int i4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenshotRectNative(j, this, i, i2, i3, i4);
    }

    public void setScreenshotCallBackMethod(@ScreenShotCallbackMethod.ScreenShotCallbackMethod1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenshotCallBackMethodNative(j, this, i);
    }

    @ScreenShotMode.ScreenShotMode1
    public int getScreenShotMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScreenShotModeNative(j, this);
    }

    public void setScreenshotParameter(@BLGLParameter.BLGLParameter1 int i, ScreenShotParam screenShotParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenshotParameterNative(j, this, i, 0L, screenShotParam);
    }

    public void setFilterParam(DeviceFilterParam deviceFilterParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFilterParamNative(j, this, 0L, deviceFilterParam);
    }

    public void destoryFilterFBO() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destoryFilterFBONative(j, this);
    }
}
