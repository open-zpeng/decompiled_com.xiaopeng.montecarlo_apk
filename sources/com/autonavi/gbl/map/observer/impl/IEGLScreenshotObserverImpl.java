package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.ScreenShotCallbackMethod;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.autonavi.gbl.map.observer.IEGLScreenshotObserver;
@IntfAuto(target = IEGLScreenshotObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IEGLScreenshotObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IEGLScreenshotObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IEGLScreenshotObserverImpl_change_ownership(IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl, long j, boolean z);

    private static native void IEGLScreenshotObserverImpl_director_connect(IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onEGLScreenshotNative(long j, IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl, int i, byte[] bArr, long j2, ScreenShotDataInfo screenShotDataInfo, int i2, long j3);

    public IEGLScreenshotObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IEGLScreenshotObserverImpl) && getUID(this) == getUID((IEGLScreenshotObserverImpl) obj);
    }

    private static long getUID(IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl) {
        long cPtr = getCPtr(iEGLScreenshotObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl) {
        if (iEGLScreenshotObserverImpl == null) {
            return 0L;
        }
        return iEGLScreenshotObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IEGLScreenshotObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IEGLScreenshotObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onEGLScreenshot(int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, @ScreenShotCallbackMethod.ScreenShotCallbackMethod1 int i2, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onEGLScreenshotNative(j2, this, i, bArr, 0L, screenShotDataInfo, i2, j);
    }

    public IEGLScreenshotObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IEGLScreenshotObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
