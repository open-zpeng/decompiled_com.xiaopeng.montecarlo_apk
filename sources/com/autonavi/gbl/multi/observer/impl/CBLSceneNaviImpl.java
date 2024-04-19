package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.CBLSceneNavi;
@IntfAuto(target = CBLSceneNavi.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CBLSceneNaviImpl extends IKldSceneBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneNaviImpl.class);
    private transient long swigCPtr;

    private static native long CBLSceneNaviImpl_SWIGUpcast(long j);

    private static native void CBLSceneNaviImpl_change_ownership(CBLSceneNaviImpl cBLSceneNaviImpl, long j, boolean z);

    private static native void CBLSceneNaviImpl_director_connect(CBLSceneNaviImpl cBLSceneNaviImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onSceneEnteredNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneEnteredSwigExplicitCBLSceneNaviImplNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneExitNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    private static native int onSceneExitSwigExplicitCBLSceneNaviImplNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    private static native int onSceneInitNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl, long j2, CKldIntent cKldIntent);

    private static native int onSceneInitSwigExplicitCBLSceneNaviImplNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl, long j2, CKldIntent cKldIntent);

    private static native int onScenePauseNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    private static native int onScenePauseSwigExplicitCBLSceneNaviImplNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    private static native int onSceneResumeNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl, boolean z);

    private static native int onSceneResumeSwigExplicitCBLSceneNaviImplNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl, boolean z);

    private static native int openNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    private static native int openSwigExplicitCBLSceneNaviImplNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    private static native boolean setMapCenterWhenRestoreNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    private static native boolean setMapCenterWhenRestoreSwigExplicitCBLSceneNaviImplNative(long j, CBLSceneNaviImpl cBLSceneNaviImpl);

    public CBLSceneNaviImpl(long j, boolean z) {
        super(CBLSceneNaviImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CBLSceneNaviImpl) {
            return getUID(this) == getUID((CBLSceneNaviImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CBLSceneNaviImpl cBLSceneNaviImpl) {
        long cPtr = getCPtr(cBLSceneNaviImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CBLSceneNaviImpl cBLSceneNaviImpl) {
        if (cBLSceneNaviImpl == null) {
            return 0L;
        }
        return cBLSceneNaviImpl.swigCPtr;
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
        CBLSceneNaviImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CBLSceneNaviImpl_change_ownership(this, this.swigCPtr, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        return $explicit_onSceneInit(cKldIntent);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int $explicit_onSceneInit(CKldIntent cKldIntent) {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneNaviImpl.class ? onSceneInitNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneInitSwigExplicitCBLSceneNaviImplNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLSceneNaviImpl.class ? onSceneEnteredNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent) : onSceneEnteredSwigExplicitCBLSceneNaviImplNative(this.swigCPtr, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent);
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
            return getClass() == CBLSceneNaviImpl.class ? onSceneExitNative(this.swigCPtr, this) : onSceneExitSwigExplicitCBLSceneNaviImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public boolean setMapCenterWhenRestore() {
        return $explicit_setMapCenterWhenRestore();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public boolean $explicit_setMapCenterWhenRestore() {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneNaviImpl.class ? setMapCenterWhenRestoreNative(this.swigCPtr, this) : setMapCenterWhenRestoreSwigExplicitCBLSceneNaviImplNative(this.swigCPtr, this);
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
            return getClass() == CBLSceneNaviImpl.class ? onSceneResumeNative(this.swigCPtr, this, z) : onSceneResumeSwigExplicitCBLSceneNaviImplNative(this.swigCPtr, this, z);
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
            return getClass() == CBLSceneNaviImpl.class ? onScenePauseNative(this.swigCPtr, this) : onScenePauseSwigExplicitCBLSceneNaviImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public int open() {
        return $explicit_open();
    }

    public int $explicit_open() {
        if (this.swigCPtr != 0) {
            return getClass() == CBLSceneNaviImpl.class ? openNative(this.swigCPtr, this) : openSwigExplicitCBLSceneNaviImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public CBLSceneNaviImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        CBLSceneNaviImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
