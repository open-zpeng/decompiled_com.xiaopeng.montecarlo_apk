package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackNavigationEtaquery;
@IntfAuto(target = ICallBackNavigationEtaquery.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackNavigationEtaqueryImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackNavigationEtaqueryImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackNavigationEtaqueryImpl_change_ownership(ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl, long j, boolean z);

    private static native void ICallBackNavigationEtaqueryImpl_director_connect(ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl, long j2, GNavigationEtaqueryResponseParam gNavigationEtaqueryResponseParam);

    public ICallBackNavigationEtaqueryImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackNavigationEtaqueryImpl) && getUID(this) == getUID((ICallBackNavigationEtaqueryImpl) obj);
    }

    private static long getUID(ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl) {
        long cPtr = getCPtr(iCallBackNavigationEtaqueryImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackNavigationEtaqueryImpl iCallBackNavigationEtaqueryImpl) {
        if (iCallBackNavigationEtaqueryImpl == null) {
            return 0L;
        }
        return iCallBackNavigationEtaqueryImpl.swigCPtr;
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
        ICallBackNavigationEtaqueryImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackNavigationEtaqueryImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GNavigationEtaqueryResponseParam gNavigationEtaqueryResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gNavigationEtaqueryResponseParam);
    }

    public ICallBackNavigationEtaqueryImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackNavigationEtaqueryImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
