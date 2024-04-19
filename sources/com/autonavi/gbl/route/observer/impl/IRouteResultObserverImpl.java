package com.autonavi.gbl.route.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.route.model.PathResultData;
import com.autonavi.gbl.route.observer.IRouteResultObserver;
import java.util.ArrayList;
@IntfAuto(target = IRouteResultObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteResultObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteResultObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IRouteResultObserverImpl_change_ownership(IRouteResultObserverImpl iRouteResultObserverImpl, long j, boolean z);

    private static native void IRouteResultObserverImpl_director_connect(IRouteResultObserverImpl iRouteResultObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onNewRouteErrorNative(long j, IRouteResultObserverImpl iRouteResultObserverImpl, long j2, PathResultData pathResultData, long j3, RouteLimitInfo routeLimitInfo);

    private static native void onNewRouteNative(long j, IRouteResultObserverImpl iRouteResultObserverImpl, long j2, PathResultData pathResultData, long[] jArr, long j3, RouteLimitInfo routeLimitInfo);

    public IRouteResultObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteResultObserverImpl) && getUID(this) == getUID((IRouteResultObserverImpl) obj);
    }

    private static long getUID(IRouteResultObserverImpl iRouteResultObserverImpl) {
        long cPtr = getCPtr(iRouteResultObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteResultObserverImpl iRouteResultObserverImpl) {
        if (iRouteResultObserverImpl == null) {
            return 0L;
        }
        return iRouteResultObserverImpl.swigCPtr;
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
        IRouteResultObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IRouteResultObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onNewRoute(PathResultData pathResultData, ArrayList<PathInfoImpl> arrayList, RouteLimitInfo routeLimitInfo) {
        long[] jArr;
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = PathInfoImpl.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        onNewRouteNative(this.swigCPtr, this, 0L, pathResultData, jArr, 0L, routeLimitInfo);
    }

    public void onNewRouteError(PathResultData pathResultData, RouteLimitInfo routeLimitInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onNewRouteErrorNative(j, this, 0L, pathResultData, 0L, routeLimitInfo);
    }

    public IRouteResultObserverImpl() {
        this(createNativeObj(), true);
        RouteObserverJNI.swig_jni_init();
        IRouteResultObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
