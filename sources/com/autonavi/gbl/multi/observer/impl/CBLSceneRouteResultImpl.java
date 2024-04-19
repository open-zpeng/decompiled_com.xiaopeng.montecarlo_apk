package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.CBLSceneRouteResult;
@IntfAuto(target = CBLSceneRouteResult.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CBLSceneRouteResultImpl extends IKldSceneBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneRouteResultImpl.class);
    private transient long swigCPtr;

    private static native long CBLSceneRouteResultImpl_SWIGUpcast(long j);

    private static native void CBLSceneRouteResultImpl_change_ownership(CBLSceneRouteResultImpl cBLSceneRouteResultImpl, long j, boolean z);

    private static native void CBLSceneRouteResultImpl_director_connect(CBLSceneRouteResultImpl cBLSceneRouteResultImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onSceneEnteredNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneEnteredSwigExplicitCBLSceneRouteResultImplNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneExitNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl);

    private static native int onSceneExitSwigExplicitCBLSceneRouteResultImplNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl);

    private static native int onSceneInitNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl, long j2, CKldIntent cKldIntent);

    private static native int onSceneInitSwigExplicitCBLSceneRouteResultImplNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl, long j2, CKldIntent cKldIntent);

    private static native int onScenePauseNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl);

    private static native int onScenePauseSwigExplicitCBLSceneRouteResultImplNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl);

    private static native int onSceneResumeNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl, boolean z);

    private static native int onSceneResumeSwigExplicitCBLSceneRouteResultImplNative(long j, CBLSceneRouteResultImpl cBLSceneRouteResultImpl, boolean z);

    public CBLSceneRouteResultImpl(long j, boolean z) {
        super(CBLSceneRouteResultImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CBLSceneRouteResultImpl) {
            return getUID(this) == getUID((CBLSceneRouteResultImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        long cPtr = getCPtr(cBLSceneRouteResultImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        if (cBLSceneRouteResultImpl == null) {
            return 0L;
        }
        return cBLSceneRouteResultImpl.swigCPtr;
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
        CBLSceneRouteResultImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CBLSceneRouteResultImpl_change_ownership(this, this.swigCPtr, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        return $explicit_onSceneInit(cKldIntent);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneInit(CKldIntent cKldIntent) {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneRouteResultImpl.class ? onSceneInitNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneInitSwigExplicitCBLSceneRouteResultImplNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLSceneRouteResultImpl.class ? onSceneEnteredNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneEnteredSwigExplicitCBLSceneRouteResultImplNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLSceneRouteResultImpl.class ? onSceneExitNative(this.swigCPtr, this) : onSceneExitSwigExplicitCBLSceneRouteResultImplNative(this.swigCPtr, this);
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
            return getClass() == CBLSceneRouteResultImpl.class ? onSceneResumeNative(this.swigCPtr, this, z) : onSceneResumeSwigExplicitCBLSceneRouteResultImplNative(this.swigCPtr, this, z);
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
            return getClass() == CBLSceneRouteResultImpl.class ? onScenePauseNative(this.swigCPtr, this) : onScenePauseSwigExplicitCBLSceneRouteResultImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public CBLSceneRouteResultImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        CBLSceneRouteResultImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
