package com.autonavi.gbl.guide.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.observer.IContinueGuideInfoObserver;
@IntfAuto(target = IContinueGuideInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IContinueGuideInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IContinueGuideInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IContinueGuideInfoObserverImpl_change_ownership(IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl, long j, boolean z);

    private static native void IContinueGuideInfoObserverImpl_director_connect(IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl, long j, boolean z, boolean z2);

    private static native void continueGuideStartNotifyNative(long j, IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void exitContinueGuideNotifyNative(long j, IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl);

    public IContinueGuideInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IContinueGuideInfoObserverImpl) && getUID(this) == getUID((IContinueGuideInfoObserverImpl) obj);
    }

    private static long getUID(IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl) {
        long cPtr = getCPtr(iContinueGuideInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl) {
        if (iContinueGuideInfoObserverImpl == null) {
            return 0L;
        }
        return iContinueGuideInfoObserverImpl.swigCPtr;
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
        IContinueGuideInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IContinueGuideInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void continueGuideStartNotify() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        continueGuideStartNotifyNative(j, this);
    }

    public void exitContinueGuideNotify() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        exitContinueGuideNotifyNative(j, this);
    }

    public IContinueGuideInfoObserverImpl() {
        this(createNativeObj(), true);
        GuideObserverJNI.swig_jni_init();
        IContinueGuideInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
