package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.model.LaneResourceRequest;
import com.autonavi.gbl.lane.model.LaneResourceRequestFile;
import com.autonavi.gbl.lane.model.LaneResourceResponse;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
@IntfAuto(target = ILaneResourceProxy.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneResourceProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneResourceProxyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILaneResourceProxyImpl_change_ownership(ILaneResourceProxyImpl iLaneResourceProxyImpl, long j, boolean z);

    private static native void ILaneResourceProxyImpl_director_connect(ILaneResourceProxyImpl iLaneResourceProxyImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native LaneResourceResponse onRequestResourceFileNative(long j, ILaneResourceProxyImpl iLaneResourceProxyImpl, long j2, LaneResourceRequestFile laneResourceRequestFile);

    private static native LaneResourceResponse onRequestResourceNative(long j, ILaneResourceProxyImpl iLaneResourceProxyImpl, long j2, LaneResourceRequest laneResourceRequest);

    public ILaneResourceProxyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneResourceProxyImpl) && getUID(this) == getUID((ILaneResourceProxyImpl) obj);
    }

    private static long getUID(ILaneResourceProxyImpl iLaneResourceProxyImpl) {
        long cPtr = getCPtr(iLaneResourceProxyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneResourceProxyImpl iLaneResourceProxyImpl) {
        if (iLaneResourceProxyImpl == null) {
            return 0L;
        }
        return iLaneResourceProxyImpl.swigCPtr;
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
        ILaneResourceProxyImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILaneResourceProxyImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneResourceResponse onRequestResource(LaneResourceRequest laneResourceRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onRequestResourceNative(j, this, 0L, laneResourceRequest);
    }

    public LaneResourceResponse onRequestResourceFile(LaneResourceRequestFile laneResourceRequestFile) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onRequestResourceFileNative(j, this, 0L, laneResourceRequestFile);
    }

    public ILaneResourceProxyImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILaneResourceProxyImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
