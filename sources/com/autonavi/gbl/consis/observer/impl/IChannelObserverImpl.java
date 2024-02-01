package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.observer.IChannelObserver;
@IntfAuto(target = IChannelObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelObserverImpl_change_ownership(IChannelObserverImpl iChannelObserverImpl, long j, boolean z);

    private static native void IChannelObserverImpl_director_connect(IChannelObserverImpl iChannelObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onChannelCreateNative(long j, IChannelObserverImpl iChannelObserverImpl, String str, String str2);

    private static native void onChannelDestroyNative(long j, IChannelObserverImpl iChannelObserverImpl, String str, String str2);

    public IChannelObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelObserverImpl) && getUID(this) == getUID((IChannelObserverImpl) obj);
    }

    private static long getUID(IChannelObserverImpl iChannelObserverImpl) {
        long cPtr = getCPtr(iChannelObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelObserverImpl iChannelObserverImpl) {
        if (iChannelObserverImpl == null) {
            return 0L;
        }
        return iChannelObserverImpl.swigCPtr;
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
        IChannelObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onChannelCreate(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onChannelCreateNative(j, this, str, str2);
    }

    public void onChannelDestroy(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onChannelDestroyNative(j, this, str, str2);
    }

    public IChannelObserverImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
