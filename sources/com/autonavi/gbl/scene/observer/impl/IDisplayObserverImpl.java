package com.autonavi.gbl.scene.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.model.ClickedInfo;
import com.autonavi.gbl.scene.model.DisplayInfo;
import com.autonavi.gbl.scene.observer.IDisplayObserver;
@IntfAuto(target = IDisplayObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDisplayObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDisplayObserverImpl_change_ownership(IDisplayObserverImpl iDisplayObserverImpl, long j, boolean z);

    private static native void IDisplayObserverImpl_director_connect(IDisplayObserverImpl iDisplayObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onClickNative(long j, IDisplayObserverImpl iDisplayObserverImpl, long j2, ClickedInfo clickedInfo);

    private static native void onHideNative(long j, IDisplayObserverImpl iDisplayObserverImpl, long j2, DisplayInfo displayInfo);

    private static native void onShowNative(long j, IDisplayObserverImpl iDisplayObserverImpl, long j2, DisplayInfo displayInfo);

    public IDisplayObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDisplayObserverImpl) && getUID(this) == getUID((IDisplayObserverImpl) obj);
    }

    private static long getUID(IDisplayObserverImpl iDisplayObserverImpl) {
        long cPtr = getCPtr(iDisplayObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDisplayObserverImpl iDisplayObserverImpl) {
        if (iDisplayObserverImpl == null) {
            return 0L;
        }
        return iDisplayObserverImpl.swigCPtr;
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
        IDisplayObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDisplayObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onShow(DisplayInfo displayInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNative(j, this, 0L, displayInfo);
    }

    public void onHide(DisplayInfo displayInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onHideNative(j, this, 0L, displayInfo);
    }

    public void onClick(ClickedInfo clickedInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onClickNative(j, this, 0L, clickedInfo);
    }

    public IDisplayObserverImpl() {
        this(createNativeObj(), true);
        SceneObserverJNI.swig_jni_init();
        IDisplayObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
