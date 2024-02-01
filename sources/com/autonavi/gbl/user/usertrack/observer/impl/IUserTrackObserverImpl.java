package com.autonavi.gbl.user.usertrack.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.autonavi.gbl.user.usertrack.model.FootprintDeleteRecordResult;
import com.autonavi.gbl.user.usertrack.model.FootprintNaviRecordResult;
import com.autonavi.gbl.user.usertrack.model.FootprintSummaryResult;
import com.autonavi.gbl.user.usertrack.model.FootprintSwitchResult;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver;
@IntfAuto(target = IUserTrackObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IUserTrackObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IUserTrackObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IUserTrackObserverImpl_change_ownership(IUserTrackObserverImpl iUserTrackObserverImpl, long j, boolean z);

    private static native void IUserTrackObserverImpl_director_connect(IUserTrackObserverImpl iUserTrackObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void notifyNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, int i, int i2);

    private static native void onCloseGpsTrackNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, int i, String str, String str2, long j2, GpsTrackDepthInfo gpsTrackDepthInfo);

    private static native void onFootprintDeleteRecordNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintDeleteRecordResult footprintDeleteRecordResult);

    private static native void onFootprintDeleteRecordSwigExplicitIUserTrackObserverImplNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintDeleteRecordResult footprintDeleteRecordResult);

    private static native void onFootprintNaviRecordListNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintNaviRecordResult footprintNaviRecordResult);

    private static native void onFootprintNaviRecordListSwigExplicitIUserTrackObserverImplNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintNaviRecordResult footprintNaviRecordResult);

    private static native void onFootprintSummaryNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintSummaryResult footprintSummaryResult);

    private static native void onFootprintSummarySwigExplicitIUserTrackObserverImplNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintSummaryResult footprintSummaryResult);

    private static native void onFootprintSwitchNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintSwitchResult footprintSwitchResult);

    private static native void onFootprintSwitchSwigExplicitIUserTrackObserverImplNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, long j2, FootprintSwitchResult footprintSwitchResult);

    private static native void onGpsTrackDepInfoNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, int i, String str, String str2, long j2, GpsTrackDepthInfo gpsTrackDepthInfo);

    private static native void onStartGpsTrackNative(long j, IUserTrackObserverImpl iUserTrackObserverImpl, int i, String str, String str2);

    public IUserTrackObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IUserTrackObserverImpl) && getUID(this) == getUID((IUserTrackObserverImpl) obj);
    }

    private static long getUID(IUserTrackObserverImpl iUserTrackObserverImpl) {
        long cPtr = getCPtr(iUserTrackObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IUserTrackObserverImpl iUserTrackObserverImpl) {
        if (iUserTrackObserverImpl == null) {
            return 0L;
        }
        return iUserTrackObserverImpl.swigCPtr;
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
        IUserTrackObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IUserTrackObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onStartGpsTrack(int i, String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onStartGpsTrackNative(j, this, i, str, str2);
    }

    public void onCloseGpsTrack(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onCloseGpsTrackNative(j, this, i, str, str2, 0L, gpsTrackDepthInfo);
    }

    public void onGpsTrackDepInfo(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGpsTrackDepInfoNative(j, this, i, str, str2, 0L, gpsTrackDepthInfo);
    }

    public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyNative(j, this, i, i2);
    }

    public void onFootprintSwitch(FootprintSwitchResult footprintSwitchResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IUserTrackObserverImpl.class) {
            onFootprintSwitchNative(this.swigCPtr, this, 0L, footprintSwitchResult);
        } else {
            onFootprintSwitchSwigExplicitIUserTrackObserverImplNative(this.swigCPtr, this, 0L, footprintSwitchResult);
        }
    }

    public void onFootprintSummary(FootprintSummaryResult footprintSummaryResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IUserTrackObserverImpl.class) {
            onFootprintSummaryNative(this.swigCPtr, this, 0L, footprintSummaryResult);
        } else {
            onFootprintSummarySwigExplicitIUserTrackObserverImplNative(this.swigCPtr, this, 0L, footprintSummaryResult);
        }
    }

    public void onFootprintNaviRecordList(FootprintNaviRecordResult footprintNaviRecordResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IUserTrackObserverImpl.class) {
            onFootprintNaviRecordListNative(this.swigCPtr, this, 0L, footprintNaviRecordResult);
        } else {
            onFootprintNaviRecordListSwigExplicitIUserTrackObserverImplNative(this.swigCPtr, this, 0L, footprintNaviRecordResult);
        }
    }

    public void onFootprintDeleteRecord(FootprintDeleteRecordResult footprintDeleteRecordResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IUserTrackObserverImpl.class) {
            onFootprintDeleteRecordNative(this.swigCPtr, this, 0L, footprintDeleteRecordResult);
        } else {
            onFootprintDeleteRecordSwigExplicitIUserTrackObserverImplNative(this.swigCPtr, this, 0L, footprintDeleteRecordResult);
        }
    }

    public IUserTrackObserverImpl() {
        this(createNativeObj(), true);
        UsertrackObserverJNI.swig_jni_init();
        IUserTrackObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
