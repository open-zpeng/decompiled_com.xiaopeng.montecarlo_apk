package com.autonavi.gbl.scene.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.model.PerceptSceneInfo;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.scene.model.ScenePreviewParam;
import com.autonavi.gbl.scene.observer.IViewParamAdapter;
@IntfAuto(target = IViewParamAdapter.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IViewParamAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(IViewParamAdapterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IViewParamAdapterImpl_change_ownership(IViewParamAdapterImpl iViewParamAdapterImpl, long j, boolean z);

    private static native void IViewParamAdapterImpl_director_connect(IViewParamAdapterImpl iViewParamAdapterImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native ScenePreviewParam getPreviewParamNative(long j, IViewParamAdapterImpl iViewParamAdapterImpl, int i, long j2, PerceptSceneInfo perceptSceneInfo);

    public IViewParamAdapterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IViewParamAdapterImpl) && getUID(this) == getUID((IViewParamAdapterImpl) obj);
    }

    private static long getUID(IViewParamAdapterImpl iViewParamAdapterImpl) {
        long cPtr = getCPtr(iViewParamAdapterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IViewParamAdapterImpl iViewParamAdapterImpl) {
        if (iViewParamAdapterImpl == null) {
            return 0L;
        }
        return iViewParamAdapterImpl.swigCPtr;
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
        IViewParamAdapterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IViewParamAdapterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ScenePreviewParam getPreviewParam(@SceneModuleID.SceneModuleID1 int i, PerceptSceneInfo perceptSceneInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPreviewParamNative(j, this, i, 0L, perceptSceneInfo);
    }

    public IViewParamAdapterImpl() {
        this(createNativeObj(), true);
        SceneObserverJNI.swig_jni_init();
        IViewParamAdapterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
