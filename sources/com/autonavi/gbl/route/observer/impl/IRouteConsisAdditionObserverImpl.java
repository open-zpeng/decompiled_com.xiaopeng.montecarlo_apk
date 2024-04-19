package com.autonavi.gbl.route.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.RouteErrorcode;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.route.model.ConsisPathIdentity;
import com.autonavi.gbl.route.observer.IRouteConsisAdditionObserver;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
@IntfAuto(target = IRouteConsisAdditionObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteConsisAdditionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteConsisAdditionObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IRouteConsisAdditionObserverImpl_change_ownership(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j, boolean z);

    private static native void IRouteConsisAdditionObserverImpl_director_connect(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetNaviPathNative(long j, IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, ArrayList<ConsisPathIdentity> arrayList, ArrayList<PathInfoImpl> arrayList2);

    private static native void onSyncRouteErrorNative(long j, IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j2, int i);

    private static native void onSyncRouteOptionNative(long j, IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native void onSyncRouteResultNative(long j, IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j2, String str, long[] jArr, long j3, BinaryStream binaryStream, int i);

    private static native void onSyncRouteSuccessNative(long j, IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j2, ArrayList<ConsisPathIdentity> arrayList);

    public IRouteConsisAdditionObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteConsisAdditionObserverImpl) && getUID(this) == getUID((IRouteConsisAdditionObserverImpl) obj);
    }

    private static long getUID(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl) {
        long cPtr = getCPtr(iRouteConsisAdditionObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl) {
        if (iRouteConsisAdditionObserverImpl == null) {
            return 0L;
        }
        return iRouteConsisAdditionObserverImpl.swigCPtr;
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
        IRouteConsisAdditionObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IRouteConsisAdditionObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onSyncRouteSuccess(long j, ArrayList<ConsisPathIdentity> arrayList) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSyncRouteSuccessNative(j2, this, j, arrayList);
    }

    public void onSyncRouteError(long j, @RouteErrorcode.RouteErrorcode1 int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSyncRouteErrorNative(j2, this, j, i);
    }

    public void onSyncRouteResult(long j, String str, ArrayList<PathInfoImpl> arrayList, BinaryStream binaryStream, @RouteErrorcode.RouteErrorcode1 int i) {
        long[] jArr;
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i2 = 0; i2 < size; i2++) {
                jArr2[i2] = PathInfoImpl.getCPtr(arrayList.get(i2));
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        onSyncRouteResultNative(this.swigCPtr, this, j, str, jArr, 0L, binaryStream, i);
    }

    public void onSyncRouteOption(IRouteOptionImpl iRouteOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSyncRouteOptionNative(j, this, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    public void onGetNaviPath(ArrayList<ConsisPathIdentity> arrayList, ArrayList<PathInfoImpl> arrayList2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetNaviPathNative(j, this, arrayList, arrayList2);
    }

    public IRouteConsisAdditionObserverImpl() {
        this(createNativeObj(), true);
        RouteObserverJNI.swig_jni_init();
        IRouteConsisAdditionObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
