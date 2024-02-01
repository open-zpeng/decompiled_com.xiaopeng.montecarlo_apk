package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.observer.IWordBreakAdapter;
import java.util.ArrayList;
@IntfAuto(target = IWordBreakAdapter.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IWordBreakAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(IWordBreakAdapterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IWordBreakAdapterImpl_change_ownership(IWordBreakAdapterImpl iWordBreakAdapterImpl, long j, boolean z);

    private static native void IWordBreakAdapterImpl_director_connect(IWordBreakAdapterImpl iWordBreakAdapterImpl, long j, boolean z, boolean z2);

    private static native boolean breakTextNative(long j, IWordBreakAdapterImpl iWordBreakAdapterImpl, String str, ArrayList<String> arrayList);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public IWordBreakAdapterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IWordBreakAdapterImpl) && getUID(this) == getUID((IWordBreakAdapterImpl) obj);
    }

    private static long getUID(IWordBreakAdapterImpl iWordBreakAdapterImpl) {
        long cPtr = getCPtr(iWordBreakAdapterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IWordBreakAdapterImpl iWordBreakAdapterImpl) {
        if (iWordBreakAdapterImpl == null) {
            return 0L;
        }
        return iWordBreakAdapterImpl.swigCPtr;
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
        IWordBreakAdapterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IWordBreakAdapterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean breakText(String str, ArrayList<String> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return breakTextNative(j, this, str, arrayList);
    }

    public IWordBreakAdapterImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        IWordBreakAdapterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
