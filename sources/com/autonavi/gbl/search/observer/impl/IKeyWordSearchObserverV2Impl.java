package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.KeywordSearchResultV2;
import com.autonavi.gbl.search.observer.IKeyWordSearchObserverV2;
@IntfAuto(target = IKeyWordSearchObserverV2.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKeyWordSearchObserverV2Impl {
    private static BindTable BIND_TABLE = new BindTable(IKeyWordSearchObserverV2Impl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IKeyWordSearchObserverV2Impl_change_ownership(IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, long j, boolean z);

    private static native void IKeyWordSearchObserverV2Impl_director_connect(IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetKeyWordResultNative(long j, IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl, int i, int i2, long j2, KeywordSearchResultV2 keywordSearchResultV2);

    public IKeyWordSearchObserverV2Impl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKeyWordSearchObserverV2Impl) && getUID(this) == getUID((IKeyWordSearchObserverV2Impl) obj);
    }

    private static long getUID(IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl) {
        long cPtr = getCPtr(iKeyWordSearchObserverV2Impl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKeyWordSearchObserverV2Impl iKeyWordSearchObserverV2Impl) {
        if (iKeyWordSearchObserverV2Impl == null) {
            return 0L;
        }
        return iKeyWordSearchObserverV2Impl.swigCPtr;
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
        IKeyWordSearchObserverV2Impl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IKeyWordSearchObserverV2Impl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetKeyWordResult(int i, int i2, KeywordSearchResultV2 keywordSearchResultV2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetKeyWordResultNative(j, this, i, i2, 0L, keywordSearchResultV2);
    }

    public IKeyWordSearchObserverV2Impl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IKeyWordSearchObserverV2Impl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
