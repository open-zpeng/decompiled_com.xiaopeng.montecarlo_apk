package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.CBLScenePreview;
@IntfAuto(target = CBLScenePreview.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CBLScenePreviewImpl extends IKldSceneBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLScenePreviewImpl.class);
    private transient long swigCPtr;

    private static native long CBLScenePreviewImpl_SWIGUpcast(long j);

    private static native void CBLScenePreviewImpl_change_ownership(CBLScenePreviewImpl cBLScenePreviewImpl, long j, boolean z);

    private static native void CBLScenePreviewImpl_director_connect(CBLScenePreviewImpl cBLScenePreviewImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onSceneEnteredNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneEnteredSwigExplicitCBLScenePreviewImplNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneExitNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl);

    private static native int onSceneExitSwigExplicitCBLScenePreviewImplNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl);

    private static native int onSceneInitNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl, long j2, CKldIntent cKldIntent);

    private static native int onSceneInitSwigExplicitCBLScenePreviewImplNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl, long j2, CKldIntent cKldIntent);

    private static native int onScenePauseNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl);

    private static native int onScenePauseSwigExplicitCBLScenePreviewImplNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl);

    private static native int onSceneResumeNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl, boolean z);

    private static native int onSceneResumeSwigExplicitCBLScenePreviewImplNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl, boolean z);

    private static native int openNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl);

    private static native int openSwigExplicitCBLScenePreviewImplNative(long j, CBLScenePreviewImpl cBLScenePreviewImpl);

    public CBLScenePreviewImpl(long j, boolean z) {
        super(CBLScenePreviewImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CBLScenePreviewImpl) {
            return getUID(this) == getUID((CBLScenePreviewImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CBLScenePreviewImpl cBLScenePreviewImpl) {
        long cPtr = getCPtr(cBLScenePreviewImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CBLScenePreviewImpl cBLScenePreviewImpl) {
        if (cBLScenePreviewImpl == null) {
            return 0L;
        }
        return cBLScenePreviewImpl.swigCPtr;
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
        CBLScenePreviewImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CBLScenePreviewImpl_change_ownership(this, this.swigCPtr, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        return $explicit_onSceneInit(cKldIntent);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneInit(CKldIntent cKldIntent) {
        if (this.swigCPtr != 0) {
            return getClass() == CBLScenePreviewImpl.class ? onSceneInitNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneInitSwigExplicitCBLScenePreviewImplNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLScenePreviewImpl.class ? onSceneEnteredNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneEnteredSwigExplicitCBLScenePreviewImplNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLScenePreviewImpl.class ? onSceneExitNative(this.swigCPtr, this) : onSceneExitSwigExplicitCBLScenePreviewImplNative(this.swigCPtr, this);
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
            return getClass() == CBLScenePreviewImpl.class ? onSceneResumeNative(this.swigCPtr, this, z) : onSceneResumeSwigExplicitCBLScenePreviewImplNative(this.swigCPtr, this, z);
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
            return getClass() == CBLScenePreviewImpl.class ? onScenePauseNative(this.swigCPtr, this) : onScenePauseSwigExplicitCBLScenePreviewImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public int open() {
        return $explicit_open();
    }

    public int $explicit_open() {
        if (this.swigCPtr != 0) {
            return getClass() == CBLScenePreviewImpl.class ? openNative(this.swigCPtr, this) : openSwigExplicitCBLScenePreviewImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public CBLScenePreviewImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        CBLScenePreviewImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
