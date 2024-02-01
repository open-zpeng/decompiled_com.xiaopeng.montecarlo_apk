package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.PoiShopListSearchResult;
import com.autonavi.gbl.search.observer.IPoiShopListSearchObserver;
@IntfAuto(target = IPoiShopListSearchObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPoiShopListSearchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPoiShopListSearchObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPoiShopListSearchObserverImpl_change_ownership(IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl, long j, boolean z);

    private static native void IPoiShopListSearchObserverImpl_director_connect(IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetPoiShopListResultNative(long j, IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl, int i, int i2, long j2, PoiShopListSearchResult poiShopListSearchResult);

    public IPoiShopListSearchObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPoiShopListSearchObserverImpl) && getUID(this) == getUID((IPoiShopListSearchObserverImpl) obj);
    }

    private static long getUID(IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl) {
        long cPtr = getCPtr(iPoiShopListSearchObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPoiShopListSearchObserverImpl iPoiShopListSearchObserverImpl) {
        if (iPoiShopListSearchObserverImpl == null) {
            return 0L;
        }
        return iPoiShopListSearchObserverImpl.swigCPtr;
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
        IPoiShopListSearchObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPoiShopListSearchObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetPoiShopListResult(int i, int i2, PoiShopListSearchResult poiShopListSearchResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetPoiShopListResultNative(j, this, i, i2, 0L, poiShopListSearchResult);
    }

    public IPoiShopListSearchObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IPoiShopListSearchObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
