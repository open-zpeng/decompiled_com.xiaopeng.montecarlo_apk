package com.autonavi.gbl.guide.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import com.autonavi.gbl.guide.observer.IGuideOperateObserver;
@IntfAuto(target = IGuideOperateObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IGuideOperateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGuideOperateObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGuideOperateObserverImpl_change_ownership(IGuideOperateObserverImpl iGuideOperateObserverImpl, long j, boolean z);

    private static native void IGuideOperateObserverImpl_director_connect(IGuideOperateObserverImpl iGuideOperateObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onUpdateMainNaviPathNative(long j, IGuideOperateObserverImpl iGuideOperateObserverImpl, long j2, PathInfoImpl pathInfoImpl);

    private static native boolean onUpdateMainNaviPathSwigExplicitIGuideOperateObserverImplNative(long j, IGuideOperateObserverImpl iGuideOperateObserverImpl, long j2, PathInfoImpl pathInfoImpl);

    private static native boolean pauseNaviNative(long j, IGuideOperateObserverImpl iGuideOperateObserverImpl);

    private static native boolean resumeNaviNative(long j, IGuideOperateObserverImpl iGuideOperateObserverImpl);

    private static native boolean setNaviPathNative(long j, IGuideOperateObserverImpl iGuideOperateObserverImpl, long j2, NaviPathImpl naviPathImpl, int i);

    private static native boolean startNaviNative(long j, IGuideOperateObserverImpl iGuideOperateObserverImpl, int i);

    private static native boolean stopNaviNative(long j, IGuideOperateObserverImpl iGuideOperateObserverImpl);

    public IGuideOperateObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGuideOperateObserverImpl) && getUID(this) == getUID((IGuideOperateObserverImpl) obj);
    }

    private static long getUID(IGuideOperateObserverImpl iGuideOperateObserverImpl) {
        long cPtr = getCPtr(iGuideOperateObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGuideOperateObserverImpl iGuideOperateObserverImpl) {
        if (iGuideOperateObserverImpl == null) {
            return 0L;
        }
        return iGuideOperateObserverImpl.swigCPtr;
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
        IGuideOperateObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGuideOperateObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean startNavi(@NaviType.NaviType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startNaviNative(j, this, i);
    }

    public boolean stopNavi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return stopNaviNative(j, this);
    }

    public boolean pauseNavi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pauseNaviNative(j, this);
    }

    public boolean resumeNavi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return resumeNaviNative(j, this);
    }

    public boolean setNaviPath(NaviPathImpl naviPathImpl, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setNaviPathNative(j, this, NaviPathImpl.getCPtr(naviPathImpl), naviPathImpl, i);
    }

    public boolean onUpdateMainNaviPath(PathInfoImpl pathInfoImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == IGuideOperateObserverImpl.class ? onUpdateMainNaviPathNative(this.swigCPtr, this, PathInfoImpl.getCPtr(pathInfoImpl), pathInfoImpl) : onUpdateMainNaviPathSwigExplicitIGuideOperateObserverImplNative(this.swigCPtr, this, PathInfoImpl.getCPtr(pathInfoImpl), pathInfoImpl);
        }
        throw new NullPointerException();
    }

    public IGuideOperateObserverImpl() {
        this(createNativeObj(), true);
        GuideObserverJNI.swig_jni_init();
        IGuideOperateObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
