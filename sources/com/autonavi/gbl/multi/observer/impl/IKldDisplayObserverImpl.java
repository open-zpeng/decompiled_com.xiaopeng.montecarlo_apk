package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.CHANNEL_MSG_TYPE;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.impl.IKldDisplayCrop;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.IKldDisplayObserver;
@IntfAuto(target = IKldDisplayObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IKldDisplayObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IKldDisplayObserverImpl_change_ownership(IKldDisplayObserverImpl iKldDisplayObserverImpl, long j, boolean z);

    private static native void IKldDisplayObserverImpl_director_connect(IKldDisplayObserverImpl iKldDisplayObserverImpl, long j, boolean z, boolean z2);

    private static native void beforeEGLDevCreatedNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native void beforeEGLMapCreatedNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native void beforeSceneContextInitNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, long j2, CKldSceneContextImpl cKldSceneContextImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onCheckSyncAllowedNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, int i2, int i3);

    private static native void onDisplayCreatedNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, int i2);

    private static native void onDisplayCropCustomNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, long j2, IKldDisplayImpl iKldDisplayImpl, long j3, IKldDisplayCrop iKldDisplayCrop);

    private static native void onMainDisplayCreatedNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, int i);

    private static native void onMapDoRenderNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, int i2);

    private static native void onMapFirstPaintNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, int i2);

    private static native boolean onProcessCustomInComeMsgNative(long j, IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, int i2, int i3, long j2, ChannelParcelImpl channelParcelImpl);

    public IKldDisplayObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldDisplayObserverImpl) && getUID(this) == getUID((IKldDisplayObserverImpl) obj);
    }

    private static long getUID(IKldDisplayObserverImpl iKldDisplayObserverImpl) {
        long cPtr = getCPtr(iKldDisplayObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldDisplayObserverImpl iKldDisplayObserverImpl) {
        if (iKldDisplayObserverImpl == null) {
            return 0L;
        }
        return iKldDisplayObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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
        IKldDisplayObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IKldDisplayObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IKldDisplayObserverImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        IKldDisplayObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDisplayCreatedNative(j, this, i, i2);
    }

    public void onDisplayCropCustom(IKldDisplayImpl iKldDisplayImpl, IKldDisplayCrop iKldDisplayCrop) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDisplayCropCustomNative(j, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl, IKldDisplayCrop.getCPtr(iKldDisplayCrop), iKldDisplayCrop);
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

    public void beforeSceneContextInit(CKldSceneContextImpl cKldSceneContextImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeSceneContextInitNative(j, this, CKldSceneContextImpl.getCPtr(cKldSceneContextImpl), cKldSceneContextImpl);
    }

    public void beforeEGLDevCreated(IKldDisplayImpl iKldDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLDevCreatedNative(j, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
    }

    public void beforeEGLMapCreated(IKldDisplayImpl iKldDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLMapCreatedNative(j, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
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

    public boolean onProcessCustomInComeMsg(int i, @CHANNEL_MSG_TYPE.CHANNEL_MSG_TYPE1 int i2, int i3, ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onProcessCustomInComeMsgNative(j, this, i, i2, i3, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }
}
