package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.PoiCmallDetailSearchResult;
import com.autonavi.gbl.search.observer.IPoiCmallDetailSearchObserver;
@IntfAuto(target = IPoiCmallDetailSearchObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPoiCmallDetailSearchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPoiCmallDetailSearchObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPoiCmallDetailSearchObserverImpl_change_ownership(IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl, long j, boolean z);

    private static native void IPoiCmallDetailSearchObserverImpl_director_connect(IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetPoiCmallDetailResultNative(long j, IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl, int i, int i2, long j2, PoiCmallDetailSearchResult poiCmallDetailSearchResult);

    public IPoiCmallDetailSearchObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPoiCmallDetailSearchObserverImpl) && getUID(this) == getUID((IPoiCmallDetailSearchObserverImpl) obj);
    }

    private static long getUID(IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl) {
        long cPtr = getCPtr(iPoiCmallDetailSearchObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPoiCmallDetailSearchObserverImpl iPoiCmallDetailSearchObserverImpl) {
        if (iPoiCmallDetailSearchObserverImpl == null) {
            return 0L;
        }
        return iPoiCmallDetailSearchObserverImpl.swigCPtr;
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
        IPoiCmallDetailSearchObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPoiCmallDetailSearchObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetPoiCmallDetailResult(int i, int i2, PoiCmallDetailSearchResult poiCmallDetailSearchResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetPoiCmallDetailResultNative(j, this, i, i2, 0L, poiCmallDetailSearchResult);
    }

    public IPoiCmallDetailSearchObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IPoiCmallDetailSearchObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
