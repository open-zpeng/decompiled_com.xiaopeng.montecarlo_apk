package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.model.SceneViewState;
import com.autonavi.gbl.multi.observer.KldSceneBase;
@IntfAuto(target = KldSceneBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldSceneBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(IKldSceneBaseImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IKldSceneBaseImpl_change_ownership(IKldSceneBaseImpl iKldSceneBaseImpl, long j, boolean z);

    private static native void IKldSceneBaseImpl_director_connect(IKldSceneBaseImpl iKldSceneBaseImpl, long j, boolean z, boolean z2);

    private static native int activateMapConfigNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native int activateMapConfigSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native int activateRenderConfigNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native int activateRenderConfigSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native long getContextNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native long getSceneConfNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native String getSceneNameNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native long getUserDataNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native void onNewIntentNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl, long j2, CKldIntent cKldIntent);

    private static native void onNewIntentSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl, long j2, CKldIntent cKldIntent);

    private static native int onSceneEnteredNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl, String str, long j2, CKldIntent cKldIntent);

    private static native int onSceneExitNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native int onSceneInitNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl, long j2, CKldIntent cKldIntent);

    private static native int onScenePauseNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native int onSceneResumeNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl, boolean z);

    private static native int onUpateSceneStateNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl, String str, long j2, SceneViewState sceneViewState);

    private static native int onUpateSceneStateSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl, String str, long j2, SceneViewState sceneViewState);

    private static native void restoreSceneStateNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native void restoreSceneStateSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setMapCenterWhenRestoreNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setMapCenterWhenRestoreSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setMapModeWhenRestoreNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setMapModeWhenRestoreSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setMapProjectionCenterWhenRestoreNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setMapProjectionCenterWhenRestoreSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setZoomerWhenRestoreNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    private static native boolean setZoomerWhenRestoreSwigExplicitIKldSceneBaseImplNative(long j, IKldSceneBaseImpl iKldSceneBaseImpl);

    public IKldSceneBaseImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldSceneBaseImpl) && getUID(this) == getUID((IKldSceneBaseImpl) obj);
    }

    private static long getUID(IKldSceneBaseImpl iKldSceneBaseImpl) {
        long cPtr = getCPtr(iKldSceneBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldSceneBaseImpl iKldSceneBaseImpl) {
        if (iKldSceneBaseImpl == null) {
            return 0L;
        }
        return iKldSceneBaseImpl.swigCPtr;
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
        IKldSceneBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IKldSceneBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IKldSceneBaseImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        IKldSceneBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public int onSceneInit(CKldIntent cKldIntent) {
        return $explicit_onSceneInit(cKldIntent);
    }

    public int $explicit_onSceneInit(CKldIntent cKldIntent) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSceneInitNative(j, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
    }

    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        return $explicit_onSceneEntered(str, cKldIntent);
    }

    public int $explicit_onSceneEntered(String str, CKldIntent cKldIntent) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSceneEnteredNative(j, this, str, CKldIntent.getCPtr(cKldIntent), cKldIntent);
    }

    public int onSceneExit() {
        return $explicit_onSceneExit();
    }

    public int $explicit_onSceneExit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSceneExitNative(j, this);
    }

    public int onSceneResume(boolean z) {
        return $explicit_onSceneResume(z);
    }

    public int $explicit_onSceneResume(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSceneResumeNative(j, this, z);
    }

    public int onScenePause() {
        return $explicit_onScenePause();
    }

    public int $explicit_onScenePause() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onScenePauseNative(j, this);
    }

    public void onNewIntent(CKldIntent cKldIntent) {
        $explicit_onNewIntent(cKldIntent);
    }

    public void $explicit_onNewIntent(CKldIntent cKldIntent) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IKldSceneBaseImpl.class) {
            onNewIntentNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
        } else {
            onNewIntentSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this, CKldIntent.getCPtr(cKldIntent), cKldIntent);
        }
    }

    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        return $explicit_onUpateSceneState(str, sceneViewState);
    }

    public int $explicit_onUpateSceneState(String str, SceneViewState sceneViewState) {
        if (this.swigCPtr != 0) {
            return getClass() == IKldSceneBaseImpl.class ? onUpateSceneStateNative(this.swigCPtr, this, str, 0L, sceneViewState) : onUpateSceneStateSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this, str, 0L, sceneViewState);
        }
        throw new NullPointerException();
    }

    public void restoreSceneState() {
        $explicit_restoreSceneState();
    }

    public void $explicit_restoreSceneState() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IKldSceneBaseImpl.class) {
            restoreSceneStateNative(this.swigCPtr, this);
        } else {
            restoreSceneStateSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this);
        }
    }

    public boolean setMapCenterWhenRestore() {
        return $explicit_setMapCenterWhenRestore();
    }

    public boolean $explicit_setMapCenterWhenRestore() {
        if (this.swigCPtr != 0) {
            return getClass() == IKldSceneBaseImpl.class ? setMapCenterWhenRestoreNative(this.swigCPtr, this) : setMapCenterWhenRestoreSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean setZoomerWhenRestore() {
        return $explicit_setZoomerWhenRestore();
    }

    public boolean $explicit_setZoomerWhenRestore() {
        if (this.swigCPtr != 0) {
            return getClass() == IKldSceneBaseImpl.class ? setZoomerWhenRestoreNative(this.swigCPtr, this) : setZoomerWhenRestoreSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean setMapModeWhenRestore() {
        return $explicit_setMapModeWhenRestore();
    }

    public boolean $explicit_setMapModeWhenRestore() {
        if (this.swigCPtr != 0) {
            return getClass() == IKldSceneBaseImpl.class ? setMapModeWhenRestoreNative(this.swigCPtr, this) : setMapModeWhenRestoreSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean setMapProjectionCenterWhenRestore() {
        return $explicit_setMapProjectionCenterWhenRestore();
    }

    public boolean $explicit_setMapProjectionCenterWhenRestore() {
        if (this.swigCPtr != 0) {
            return getClass() == IKldSceneBaseImpl.class ? setMapProjectionCenterWhenRestoreNative(this.swigCPtr, this) : setMapProjectionCenterWhenRestoreSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public CKldSceneContextImpl getContext() {
        return $explicit_getContext();
    }

    public CKldSceneContextImpl $explicit_getContext() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long contextNative = getContextNative(j, this);
        if (contextNative == 0) {
            return null;
        }
        return new CKldSceneContextImpl(contextNative, false);
    }

    public int activateMapConfig() {
        return $explicit_activateMapConfig();
    }

    public int $explicit_activateMapConfig() {
        if (this.swigCPtr != 0) {
            return getClass() == IKldSceneBaseImpl.class ? activateMapConfigNative(this.swigCPtr, this) : activateMapConfigSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public int activateRenderConfig() {
        return $explicit_activateRenderConfig();
    }

    public int $explicit_activateRenderConfig() {
        if (this.swigCPtr != 0) {
            return getClass() == IKldSceneBaseImpl.class ? activateRenderConfigNative(this.swigCPtr, this) : activateRenderConfigSwigExplicitIKldSceneBaseImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public String getSceneName() {
        return $explicit_getSceneName();
    }

    public String $explicit_getSceneName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSceneNameNative(j, this);
    }

    public DisplaySceneConfigBaseImpl getSceneConf() {
        return $explicit_getSceneConf();
    }

    public DisplaySceneConfigBaseImpl $explicit_getSceneConf() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long sceneConfNative = getSceneConfNative(j, this);
        if (sceneConfNative == 0) {
            return null;
        }
        return new DisplaySceneConfigBaseImpl(sceneConfNative, false);
    }

    public CKldIntent getUserData() {
        return $explicit_getUserData();
    }

    public CKldIntent $explicit_getUserData() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return new CKldIntent(getUserDataNative(j, this), true);
    }
}
