package com.autonavi.gbl.user.msgpush.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import com.autonavi.gbl.user.msgpush.model.AutoPushMsg;
import com.autonavi.gbl.user.msgpush.model.DestinationPushMsg;
import com.autonavi.gbl.user.msgpush.model.LinkStatusPushMsg;
import com.autonavi.gbl.user.msgpush.model.MsgPushStatus;
import com.autonavi.gbl.user.msgpush.model.ParkPushMsg;
import com.autonavi.gbl.user.msgpush.model.PaymentCapPushMsg;
import com.autonavi.gbl.user.msgpush.model.PlanPrefPushMsg;
import com.autonavi.gbl.user.msgpush.model.QuitNaviPushMsg;
import com.autonavi.gbl.user.msgpush.model.SafeSharePushMsg;
import com.autonavi.gbl.user.msgpush.model.TeamPushMsg;
import com.autonavi.gbl.user.msgpush.model.TeamUploadResponseMsg;
import com.autonavi.gbl.user.msgpush.model.Tripod2CarPushMsg;
import com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver;
@IntfAuto(target = IMsgPushServiceObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMsgPushServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMsgPushServiceObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMsgPushServiceObserverImpl_change_ownership(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j, boolean z);

    private static native void IMsgPushServiceObserverImpl_director_connect(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void notifyMessage10Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, SafeSharePushMsg safeSharePushMsg);

    private static native void notifyMessage11Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, DestinationPushMsg destinationPushMsg);

    private static native void notifyMessage12Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, PaymentCapPushMsg paymentCapPushMsg);

    private static native void notifyMessage1Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, AimPoiPushMsg aimPoiPushMsg);

    private static native void notifyMessage2Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, AimRoutePushMsg aimRoutePushMsg);

    private static native void notifyMessage3Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, ParkPushMsg parkPushMsg);

    private static native void notifyMessage4Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, TeamPushMsg teamPushMsg);

    private static native void notifyMessage5Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, TeamUploadResponseMsg teamUploadResponseMsg);

    private static native void notifyMessage6Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, Tripod2CarPushMsg tripod2CarPushMsg);

    private static native void notifyMessage7Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, LinkStatusPushMsg linkStatusPushMsg);

    private static native void notifyMessage8Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, QuitNaviPushMsg quitNaviPushMsg);

    private static native void notifyMessage9Native(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, PlanPrefPushMsg planPrefPushMsg);

    private static native void notifyMessageNative(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, long j2, AutoPushMsg autoPushMsg);

    private static native void notifyStatusNative(long j, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, int i);

    public IMsgPushServiceObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMsgPushServiceObserverImpl) && getUID(this) == getUID((IMsgPushServiceObserverImpl) obj);
    }

    private static long getUID(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl) {
        long cPtr = getCPtr(iMsgPushServiceObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl) {
        if (iMsgPushServiceObserverImpl == null) {
            return 0L;
        }
        return iMsgPushServiceObserverImpl.swigCPtr;
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
        IMsgPushServiceObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMsgPushServiceObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void notifyStatus(@MsgPushStatus.MsgPushStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyStatusNative(j, this, i);
    }

    public void notifyMessage(AutoPushMsg autoPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessageNative(j, this, 0L, autoPushMsg);
    }

    public void notifyMessage(AimPoiPushMsg aimPoiPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage1Native(j, this, 0L, aimPoiPushMsg);
    }

    public void notifyMessage(AimRoutePushMsg aimRoutePushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage2Native(j, this, 0L, aimRoutePushMsg);
    }

    public void notifyMessage(ParkPushMsg parkPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage3Native(j, this, 0L, parkPushMsg);
    }

    public void notifyMessage(TeamPushMsg teamPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage4Native(j, this, 0L, teamPushMsg);
    }

    public void notifyMessage(TeamUploadResponseMsg teamUploadResponseMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage5Native(j, this, 0L, teamUploadResponseMsg);
    }

    public void notifyMessage(Tripod2CarPushMsg tripod2CarPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage6Native(j, this, 0L, tripod2CarPushMsg);
    }

    public void notifyMessage(LinkStatusPushMsg linkStatusPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage7Native(j, this, 0L, linkStatusPushMsg);
    }

    public void notifyMessage(QuitNaviPushMsg quitNaviPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage8Native(j, this, 0L, quitNaviPushMsg);
    }

    public void notifyMessage(PlanPrefPushMsg planPrefPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage9Native(j, this, 0L, planPrefPushMsg);
    }

    public void notifyMessage(SafeSharePushMsg safeSharePushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage10Native(j, this, 0L, safeSharePushMsg);
    }

    public void notifyMessage(DestinationPushMsg destinationPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage11Native(j, this, 0L, destinationPushMsg);
    }

    public void notifyMessage(PaymentCapPushMsg paymentCapPushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyMessage12Native(j, this, 0L, paymentCapPushMsg);
    }

    public IMsgPushServiceObserverImpl() {
        this(createNativeObj(), true);
        MsgpushObserverJNI.swig_jni_init();
        IMsgPushServiceObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
