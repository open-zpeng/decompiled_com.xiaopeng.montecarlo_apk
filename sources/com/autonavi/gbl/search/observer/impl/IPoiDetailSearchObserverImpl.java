package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.PoiDetailSearchResult;
import com.autonavi.gbl.search.observer.IPoiDetailSearchObserver;
@IntfAuto(target = IPoiDetailSearchObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPoiDetailSearchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPoiDetailSearchObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPoiDetailSearchObserverImpl_change_ownership(IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl, long j, boolean z);

    private static native void IPoiDetailSearchObserverImpl_director_connect(IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetPoiDetailResultNative(long j, IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl, int i, int i2, long j2, PoiDetailSearchResult poiDetailSearchResult);

    public IPoiDetailSearchObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPoiDetailSearchObserverImpl) && getUID(this) == getUID((IPoiDetailSearchObserverImpl) obj);
    }

    private static long getUID(IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl) {
        long cPtr = getCPtr(iPoiDetailSearchObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPoiDetailSearchObserverImpl iPoiDetailSearchObserverImpl) {
        if (iPoiDetailSearchObserverImpl == null) {
            return 0L;
        }
        return iPoiDetailSearchObserverImpl.swigCPtr;
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
        IPoiDetailSearchObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPoiDetailSearchObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetPoiDetailResult(int i, int i2, PoiDetailSearchResult poiDetailSearchResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetPoiDetailResultNative(j, this, i, i2, 0L, poiDetailSearchResult);
    }

    public IPoiDetailSearchObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IPoiDetailSearchObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
