package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.MapResourceParam;
import com.autonavi.gbl.map.model.ReportCode;
import com.autonavi.gbl.map.model.ReportType;
import com.autonavi.gbl.map.observer.IBLMapEngineProxy;
@IntfAuto(target = IBLMapEngineProxy.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBLMapEngineProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(IBLMapEngineProxyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IBLMapEngineProxyImpl_change_ownership(IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j, boolean z);

    private static native void IBLMapEngineProxyImpl_director_connect(IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onMapLogReporterNative(long j, IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j2, int i, int i2, String str);

    private static native void onSendBehaviorLogNative(long j, IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j2, String str, String str2, String str3);

    private static native void requireMapRenderNative(long j, IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j2, int i, int i2);

    private static native byte[] requireMapResourceNative(long j, IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j2, long j3, MapResourceParam mapResourceParam);

    public IBLMapEngineProxyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBLMapEngineProxyImpl) && getUID(this) == getUID((IBLMapEngineProxyImpl) obj);
    }

    private static long getUID(IBLMapEngineProxyImpl iBLMapEngineProxyImpl) {
        long cPtr = getCPtr(iBLMapEngineProxyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLMapEngineProxyImpl iBLMapEngineProxyImpl) {
        if (iBLMapEngineProxyImpl == null) {
            return 0L;
        }
        return iBLMapEngineProxyImpl.swigCPtr;
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
        IBLMapEngineProxyImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBLMapEngineProxyImpl_change_ownership(this, this.swigCPtr, true);
    }

    public byte[] requireMapResource(long j, MapResourceParam mapResourceParam) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return requireMapResourceNative(j2, this, j, 0L, mapResourceParam);
    }

    public void onMapLogReporter(long j, @ReportType.ReportType1 int i, @ReportCode.ReportCode1 int i2, String str) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapLogReporterNative(j2, this, j, i, i2, str);
    }

    public void onSendBehaviorLog(long j, String str, String str2, String str3) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSendBehaviorLogNative(j2, this, j, str, str2, str3);
    }

    public void requireMapRender(long j, int i, int i2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        requireMapRenderNative(j2, this, j, i, i2);
    }

    public IBLMapEngineProxyImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IBLMapEngineProxyImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
