package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.model.SceneErrorCode;
import com.autonavi.gbl.multi.observer.IKldSceneObserver;
@IntfAuto(target = IKldSceneObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldSceneObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IKldSceneObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IKldSceneObserverImpl_change_ownership(IKldSceneObserverImpl iKldSceneObserverImpl, long j, boolean z);

    private static native void IKldSceneObserverImpl_director_connect(IKldSceneObserverImpl iKldSceneObserverImpl, long j, boolean z, boolean z2);

    private static native int beforeExitNative(long j, IKldSceneObserverImpl iKldSceneObserverImpl, long j2, CKldSceneContextImpl cKldSceneContextImpl, String str);

    private static native int beforeInitNative(long j, IKldSceneObserverImpl iKldSceneObserverImpl, long j2, CKldSceneContextImpl cKldSceneContextImpl, String str);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onInitDoneNative(long j, IKldSceneObserverImpl iKldSceneObserverImpl, long j2, CKldSceneContextImpl cKldSceneContextImpl, String str);

    private static native int onSceneEnteredNative(long j, IKldSceneObserverImpl iKldSceneObserverImpl, long j2, CKldSceneContextImpl cKldSceneContextImpl, String str);

    private static native int onSceneErrorNative(long j, IKldSceneObserverImpl iKldSceneObserverImpl, long j2, CKldSceneContextImpl cKldSceneContextImpl, String str, long j3, CKldIntent cKldIntent, int i);

    private static native int onSceneExitedNative(long j, IKldSceneObserverImpl iKldSceneObserverImpl, long j2, CKldSceneContextImpl cKldSceneContextImpl, String str);

    public IKldSceneObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldSceneObserverImpl) && getUID(this) == getUID((IKldSceneObserverImpl) obj);
    }

    private static long getUID(IKldSceneObserverImpl iKldSceneObserverImpl) {
        long cPtr = getCPtr(iKldSceneObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldSceneObserverImpl iKldSceneObserverImpl) {
        if (iKldSceneObserverImpl == null) {
            return 0L;
        }
        return iKldSceneObserverImpl.swigCPtr;
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
        IKldSceneObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IKldSceneObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IKldSceneObserverImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        IKldSceneObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public int onSceneError(CKldSceneContextImpl cKldSceneContextImpl, String str, CKldIntent cKldIntent, @SceneErrorCode.SceneErrorCode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSceneErrorNative(j, this, CKldSceneContextImpl.getCPtr(cKldSceneContextImpl), cKldSceneContextImpl, str, CKldIntent.getCPtr(cKldIntent), cKldIntent, i);
    }

    public int beforeInit(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return beforeInitNative(j, this, CKldSceneContextImpl.getCPtr(cKldSceneContextImpl), cKldSceneContextImpl, str);
    }

    public int onInitDone(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onInitDoneNative(j, this, CKldSceneContextImpl.getCPtr(cKldSceneContextImpl), cKldSceneContextImpl, str);
    }

    public int onSceneEntered(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSceneEnteredNative(j, this, CKldSceneContextImpl.getCPtr(cKldSceneContextImpl), cKldSceneContextImpl, str);
    }

    public int beforeExit(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return beforeExitNative(j, this, CKldSceneContextImpl.getCPtr(cKldSceneContextImpl), cKldSceneContextImpl, str);
    }

    public int onSceneExited(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSceneExitedNative(j, this, CKldSceneContextImpl.getCPtr(cKldSceneContextImpl), cKldSceneContextImpl, str);
    }
}
