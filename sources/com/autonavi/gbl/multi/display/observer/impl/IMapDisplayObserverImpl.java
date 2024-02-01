package com.autonavi.gbl.multi.display.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMessageType;
import com.autonavi.gbl.multi.display.impl.IDisplayCropImpl;
import com.autonavi.gbl.multi.display.impl.IDisplayImpl;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IMapDisplayObserver;
@IntfAuto(target = IMapDisplayObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapDisplayObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapDisplayObserverImpl_change_ownership(IMapDisplayObserverImpl iMapDisplayObserverImpl, long j, boolean z);

    private static native void IMapDisplayObserverImpl_director_connect(IMapDisplayObserverImpl iMapDisplayObserverImpl, long j, boolean z, boolean z2);

    private static native void beforeEGLDevCreatedNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, long j2, IDisplayImpl iDisplayImpl);

    private static native void beforeEGLMapCreatedNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, long j2, IDisplayImpl iDisplayImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onCheckSyncAllowedNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, int i2, int i3);

    private static native void onDisplayCreatedNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, int i2);

    private static native void onDisplayCropCustomNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, long j2, IDisplayImpl iDisplayImpl, long j3, IDisplayCropImpl iDisplayCropImpl);

    private static native void onMainDisplayCreatedNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, int i);

    private static native void onMapDoRenderNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, int i2);

    private static native void onMapFirstPaintNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, int i2);

    private static native boolean onProcessCustomInComeMsgNative(long j, IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, int i2, int i3, long j2, ChannelParcelImpl channelParcelImpl);

    public IMapDisplayObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapDisplayObserverImpl) && getUID(this) == getUID((IMapDisplayObserverImpl) obj);
    }

    private static long getUID(IMapDisplayObserverImpl iMapDisplayObserverImpl) {
        long cPtr = getCPtr(iMapDisplayObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapDisplayObserverImpl iMapDisplayObserverImpl) {
        if (iMapDisplayObserverImpl == null) {
            return 0L;
        }
        return iMapDisplayObserverImpl.swigCPtr;
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
        IMapDisplayObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapDisplayObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IMapDisplayObserverImpl() {
        this(createNativeObj(), true);
        MultiDisplayObserverJNI.swig_jni_init();
        IMapDisplayObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDisplayCreatedNative(j, this, i, i2);
    }

    public void onDisplayCropCustom(IDisplayImpl iDisplayImpl, IDisplayCropImpl iDisplayCropImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDisplayCropCustomNative(j, this, IDisplayImpl.getCPtr(iDisplayImpl), iDisplayImpl, IDisplayCropImpl.getCPtr(iDisplayCropImpl), iDisplayCropImpl);
    }

    public void onMapFirstPaint(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMapFirstPaintNative(j, this, i, i2);
    }

    public void onMainDisplayCreated(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMainDisplayCreatedNative(j, this, i);
    }

    public void beforeEGLDevCreated(IDisplayImpl iDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLDevCreatedNative(j, this, IDisplayImpl.getCPtr(iDisplayImpl), iDisplayImpl);
    }

    public void beforeEGLMapCreated(IDisplayImpl iDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLMapCreatedNative(j, this, IDisplayImpl.getCPtr(iDisplayImpl), iDisplayImpl);
    }

    public void onMapDoRender(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMapDoRenderNative(j, this, i, i2);
    }

    public boolean onCheckSyncAllowed(int i, int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onCheckSyncAllowedNative(j, this, i, i2, i3);
    }

    public boolean onProcessCustomInComeMsg(int i, @ChannelMessageType.ChannelMessageType1 int i2, int i3, ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onProcessCustomInComeMsgNative(j, this, i, i2, i3, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }
}
