package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.CBLSceneOpening;
@IntfAuto(target = CBLSceneOpening.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CBLSceneOpeningImpl extends IKldSceneBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneOpeningImpl.class);
    private transient long swigCPtr;

    private static native long CBLSceneOpeningImpl_SWIGUpcast(long j);

    private static native void CBLSceneOpeningImpl_change_ownership(CBLSceneOpeningImpl cBLSceneOpeningImpl, long j, boolean z);

    private static native void CBLSceneOpeningImpl_director_connect(CBLSceneOpeningImpl cBLSceneOpeningImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onSceneEnteredNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneEnteredSwigExplicitCBLSceneOpeningImplNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneExitNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl);

    private static native int onSceneExitSwigExplicitCBLSceneOpeningImplNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl);

    private static native int onSceneInitNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl, long j2, CKldIntent cKldIntent);

    private static native int onSceneInitSwigExplicitCBLSceneOpeningImplNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl, long j2, CKldIntent cKldIntent);

    private static native int onScenePauseNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl);

    private static native int onScenePauseSwigExplicitCBLSceneOpeningImplNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl);

    private static native int onSceneResumeNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl, boolean z);

    private static native int onSceneResumeSwigExplicitCBLSceneOpeningImplNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl, boolean z);

    private static native int openNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl);

    private static native int openSwigExplicitCBLSceneOpeningImplNative(long j, CBLSceneOpeningImpl cBLSceneOpeningImpl);

    public CBLSceneOpeningImpl(long j, boolean z) {
        super(CBLSceneOpeningImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CBLSceneOpeningImpl) {
            return getUID(this) == getUID((CBLSceneOpeningImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        long cPtr = getCPtr(cBLSceneOpeningImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        if (cBLSceneOpeningImpl == null) {
            return 0L;
        }
        return cBLSceneOpeningImpl.swigCPtr;
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
        CBLSceneOpeningImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CBLSceneOpeningImpl_change_ownership(this, this.swigCPtr, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        return $explicit_onSceneInit(cKldIntent);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneInit(CKldIntent cKldIntent) {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneOpeningImpl.class ? onSceneInitNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneInitSwigExplicitCBLSceneOpeningImplNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLSceneOpeningImpl.class ? onSceneEnteredNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneEnteredSwigExplicitCBLSceneOpeningImplNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLSceneOpeningImpl.class ? onSceneExitNative(this.swigCPtr, this) : onSceneExitSwigExplicitCBLSceneOpeningImplNative(this.swigCPtr, this);
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
            return getClass() == CBLSceneOpeningImpl.class ? onSceneResumeNative(this.swigCPtr, this, z) : onSceneResumeSwigExplicitCBLSceneOpeningImplNative(this.swigCPtr, this, z);
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
            return getClass() == CBLSceneOpeningImpl.class ? onScenePauseNative(this.swigCPtr, this) : onScenePauseSwigExplicitCBLSceneOpeningImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public int open() {
        return $explicit_open();
    }

    public int $explicit_open() {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneOpeningImpl.class ? openNative(this.swigCPtr, this) : openSwigExplicitCBLSceneOpeningImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public CBLSceneOpeningImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        CBLSceneOpeningImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
