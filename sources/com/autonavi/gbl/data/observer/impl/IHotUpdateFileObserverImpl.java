package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.HotUpdateFileType;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IHotUpdateFileObserver;
@IntfAuto(target = IHotUpdateFileObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IHotUpdateFileObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IHotUpdateFileObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IHotUpdateFileObserverImpl_change_ownership(IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl, long j, boolean z);

    private static native void IHotUpdateFileObserverImpl_director_connect(IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onHotUpdateFileNative(long j, IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl, int i, int i2, String str);

    public IHotUpdateFileObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IHotUpdateFileObserverImpl) && getUID(this) == getUID((IHotUpdateFileObserverImpl) obj);
    }

    private static long getUID(IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl) {
        long cPtr = getCPtr(iHotUpdateFileObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl) {
        if (iHotUpdateFileObserverImpl == null) {
            return 0L;
        }
        return iHotUpdateFileObserverImpl.swigCPtr;
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
        IHotUpdateFileObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IHotUpdateFileObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, @OperationErrCode.OperationErrCode1 int i2, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onHotUpdateFileNative(j, this, i, i2, str);
    }

    public IHotUpdateFileObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IHotUpdateFileObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
