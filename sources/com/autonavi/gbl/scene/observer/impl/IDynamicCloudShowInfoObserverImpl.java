package com.autonavi.gbl.scene.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaDataRuleRes;
import com.autonavi.gbl.common.model.DynamicTips;
import com.autonavi.gbl.common.model.RestrictRuleResult;
import com.autonavi.gbl.scene.observer.IDynamicCloudShowInfoObserver;
@IntfAuto(target = IDynamicCloudShowInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDynamicCloudShowInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDynamicCloudShowInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDynamicCloudShowInfoObserverImpl_change_ownership(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl, long j, boolean z);

    private static native void IDynamicCloudShowInfoObserverImpl_director_connect(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onDynamicalTipsNotifyNative(long j, IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl, long j2, DynamicTips dynamicTips);

    private static native void onRestrictedDataResultNative(long j, IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl, long j2, RestrictRuleResult restrictRuleResult, long j3, GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes);

    public IDynamicCloudShowInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDynamicCloudShowInfoObserverImpl) && getUID(this) == getUID((IDynamicCloudShowInfoObserverImpl) obj);
    }

    private static long getUID(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl) {
        long cPtr = getCPtr(iDynamicCloudShowInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl) {
        if (iDynamicCloudShowInfoObserverImpl == null) {
            return 0L;
        }
        return iDynamicCloudShowInfoObserverImpl.swigCPtr;
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
        IDynamicCloudShowInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDynamicCloudShowInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRestrictedDataResult(RestrictRuleResult restrictRuleResult, GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRestrictedDataResultNative(j, this, 0L, restrictRuleResult, 0L, gReStrictedAreaDataRuleRes);
    }

    public void onDynamicalTipsNotify(DynamicTips dynamicTips) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDynamicalTipsNotifyNative(j, this, 0L, dynamicTips);
    }

    public IDynamicCloudShowInfoObserverImpl() {
        this(createNativeObj(), true);
        SceneObserverJNI.swig_jni_init();
        IDynamicCloudShowInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
