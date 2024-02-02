package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.search.model.SearchSuggestResult;
import com.autonavi.gbl.search.observer.IGSearchSuggestionObserver;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchSuggestionObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchSuggestionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchSuggestionObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchSuggestionObserverImpl_change_ownership(IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl, long j, boolean z);

    private static native void IGSearchSuggestionObserverImpl_director_connect(IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetSuggestionResultNative(long j, IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl, int i, int i2, long j2, SearchSuggestResult searchSuggestResult);

    public IGSearchSuggestionObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchSuggestionObserverImpl) && getUID(this) == getUID((IGSearchSuggestionObserverImpl) obj);
    }

    private static long getUID(IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl) {
        long cPtr = getCPtr(iGSearchSuggestionObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchSuggestionObserverImpl iGSearchSuggestionObserverImpl) {
        if (iGSearchSuggestionObserverImpl == null) {
            return 0L;
        }
        return iGSearchSuggestionObserverImpl.swigCPtr;
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
        IGSearchSuggestionObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchSuggestionObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetSuggestionResult(int i, @EGErr.EGErr1 int i2, SearchSuggestResult searchSuggestResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetSuggestionResultNative(j, this, i, i2, 0L, searchSuggestResult);
    }

    public IGSearchSuggestionObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchSuggestionObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
