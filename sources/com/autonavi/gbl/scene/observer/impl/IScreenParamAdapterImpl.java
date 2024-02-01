package com.autonavi.gbl.scene.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.scene.model.ScreenParam;
import com.autonavi.gbl.scene.observer.IScreenParamAdapter;
@IntfAuto(target = IScreenParamAdapter.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IScreenParamAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(IScreenParamAdapterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IScreenParamAdapterImpl_change_ownership(IScreenParamAdapterImpl iScreenParamAdapterImpl, long j, boolean z);

    private static native void IScreenParamAdapterImpl_director_connect(IScreenParamAdapterImpl iScreenParamAdapterImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native ScreenParam getScreenParamNative(long j, IScreenParamAdapterImpl iScreenParamAdapterImpl, int i, long j2);

    public IScreenParamAdapterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IScreenParamAdapterImpl) && getUID(this) == getUID((IScreenParamAdapterImpl) obj);
    }

    private static long getUID(IScreenParamAdapterImpl iScreenParamAdapterImpl) {
        long cPtr = getCPtr(iScreenParamAdapterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IScreenParamAdapterImpl iScreenParamAdapterImpl) {
        if (iScreenParamAdapterImpl == null) {
            return 0L;
        }
        return iScreenParamAdapterImpl.swigCPtr;
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
        IScreenParamAdapterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IScreenParamAdapterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ScreenParam getScreenParam(@SceneModuleID.SceneModuleID1 int i, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getScreenParamNative(j2, this, i, j);
    }

    public IScreenParamAdapterImpl() {
        this(createNativeObj(), true);
        SceneObserverJNI.swig_jni_init();
        IScreenParamAdapterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
