package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.CBLSceneMap;
@IntfAuto(target = CBLSceneMap.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CBLSceneMapImpl extends IKldSceneBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneMapImpl.class);
    private transient long swigCPtr;

    private static native long CBLSceneMapImpl_SWIGUpcast(long j);

    private static native void CBLSceneMapImpl_change_ownership(CBLSceneMapImpl cBLSceneMapImpl, long j, boolean z);

    private static native void CBLSceneMapImpl_director_connect(CBLSceneMapImpl cBLSceneMapImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onSceneEnteredNative(long j, CBLSceneMapImpl cBLSceneMapImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneEnteredSwigExplicitCBLSceneMapImplNative(long j, CBLSceneMapImpl cBLSceneMapImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneExitNative(long j, CBLSceneMapImpl cBLSceneMapImpl);

    private static native int onSceneExitSwigExplicitCBLSceneMapImplNative(long j, CBLSceneMapImpl cBLSceneMapImpl);

    private static native int onSceneInitNative(long j, CBLSceneMapImpl cBLSceneMapImpl, long j2, CKldIntent cKldIntent);

    private static native int onSceneInitSwigExplicitCBLSceneMapImplNative(long j, CBLSceneMapImpl cBLSceneMapImpl, long j2, CKldIntent cKldIntent);

    private static native int onScenePauseNative(long j, CBLSceneMapImpl cBLSceneMapImpl);

    private static native int onScenePauseSwigExplicitCBLSceneMapImplNative(long j, CBLSceneMapImpl cBLSceneMapImpl);

    private static native int onSceneResumeNative(long j, CBLSceneMapImpl cBLSceneMapImpl, boolean z);

    private static native int onSceneResumeSwigExplicitCBLSceneMapImplNative(long j, CBLSceneMapImpl cBLSceneMapImpl, boolean z);

    private static native int openNative(long j, CBLSceneMapImpl cBLSceneMapImpl);

    private static native int openSwigExplicitCBLSceneMapImplNative(long j, CBLSceneMapImpl cBLSceneMapImpl);

    public CBLSceneMapImpl(long j, boolean z) {
        super(CBLSceneMapImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CBLSceneMapImpl) {
            return getUID(this) == getUID((CBLSceneMapImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CBLSceneMapImpl cBLSceneMapImpl) {
        long cPtr = getCPtr(cBLSceneMapImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CBLSceneMapImpl cBLSceneMapImpl) {
        if (cBLSceneMapImpl == null) {
            return 0L;
        }
        return cBLSceneMapImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CBLSceneMapImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CBLSceneMapImpl_change_ownership(this, this.swigCPtr, true);
    }

    public CBLSceneMapImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        CBLSceneMapImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        return $explicit_onSceneInit(cKldIntent);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneInit(CKldIntent cKldIntent) {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneMapImpl.class ? onSceneInitNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneInitSwigExplicitCBLSceneMapImplNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        return $explicit_onSceneEntered(str, cKldIntent);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneEntered(String str, CKldIntent cKldIntent) {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneMapImpl.class ? onSceneEnteredNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneEnteredSwigExplicitCBLSceneMapImplNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneExit() {
        return $explicit_onSceneExit();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneExit() {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneMapImpl.class ? onSceneExitNative(this.swigCPtr, this) : onSceneExitSwigExplicitCBLSceneMapImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneResume(boolean z) {
        return $explicit_onSceneResume(z);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneResume(boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneMapImpl.class ? onSceneResumeNative(this.swigCPtr, this, z) : onSceneResumeSwigExplicitCBLSceneMapImplNative(this.swigCPtr, this, z);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onScenePause() {
        return $explicit_onScenePause();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onScenePause() {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneMapImpl.class ? onScenePauseNative(this.swigCPtr, this) : onScenePauseSwigExplicitCBLSceneMapImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public int open() {
        return $explicit_open();
    }

    public int $explicit_open() {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneMapImpl.class ? openNative(this.swigCPtr, this) : openSwigExplicitCBLSceneMapImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
