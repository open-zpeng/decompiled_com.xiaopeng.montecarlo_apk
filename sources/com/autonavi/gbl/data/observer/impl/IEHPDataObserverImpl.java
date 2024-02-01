package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.observer.IEHPDataObserver;
import java.util.ArrayList;
@IntfAuto(target = IEHPDataObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IEHPDataObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IEHPDataObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IEHPDataObserverImpl_change_ownership(IEHPDataObserverImpl iEHPDataObserverImpl, long j, boolean z);

    private static native void IEHPDataObserverImpl_director_connect(IEHPDataObserverImpl iEHPDataObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onEHPDataExistedAdcodeListNative(long j, IEHPDataObserverImpl iEHPDataObserverImpl, int i, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2);

    public IEHPDataObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IEHPDataObserverImpl) && getUID(this) == getUID((IEHPDataObserverImpl) obj);
    }

    private static long getUID(IEHPDataObserverImpl iEHPDataObserverImpl) {
        long cPtr = getCPtr(iEHPDataObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IEHPDataObserverImpl iEHPDataObserverImpl) {
        if (iEHPDataObserverImpl == null) {
            return 0L;
        }
        return iEHPDataObserverImpl.swigCPtr;
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
        IEHPDataObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IEHPDataObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onEHPDataExistedAdcodeList(@DownLoadMode.DownLoadMode1 int i, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onEHPDataExistedAdcodeListNative(j, this, i, arrayList, arrayList2);
    }

    public IEHPDataObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IEHPDataObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
