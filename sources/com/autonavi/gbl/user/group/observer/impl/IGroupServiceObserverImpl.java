package com.autonavi.gbl.user.group.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.group.model.GroupResponseCreate;
import com.autonavi.gbl.user.group.model.GroupResponseDissolve;
import com.autonavi.gbl.user.group.model.GroupResponseFriendList;
import com.autonavi.gbl.user.group.model.GroupResponseInfo;
import com.autonavi.gbl.user.group.model.GroupResponseInvite;
import com.autonavi.gbl.user.group.model.GroupResponseInviteQRUrl;
import com.autonavi.gbl.user.group.model.GroupResponseJoin;
import com.autonavi.gbl.user.group.model.GroupResponseKick;
import com.autonavi.gbl.user.group.model.GroupResponseQuit;
import com.autonavi.gbl.user.group.model.GroupResponseSetNickName;
import com.autonavi.gbl.user.group.model.GroupResponseStatus;
import com.autonavi.gbl.user.group.model.GroupResponseUpdate;
import com.autonavi.gbl.user.group.model.GroupResponseUrlTranslate;
import com.autonavi.gbl.user.group.observer.IGroupServiceObserver;
@IntfAuto(target = IGroupServiceObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGroupServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGroupServiceObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGroupServiceObserverImpl_change_ownership(IGroupServiceObserverImpl iGroupServiceObserverImpl, long j, boolean z);

    private static native void IGroupServiceObserverImpl_director_connect(IGroupServiceObserverImpl iGroupServiceObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onNotify10Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseFriendList groupResponseFriendList);

    private static native void onNotify11Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseInviteQRUrl groupResponseInviteQRUrl);

    private static native void onNotify12Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseUrlTranslate groupResponseUrlTranslate);

    private static native void onNotify1Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseCreate groupResponseCreate);

    private static native void onNotify2Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseDissolve groupResponseDissolve);

    private static native void onNotify3Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseJoin groupResponseJoin);

    private static native void onNotify4Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseQuit groupResponseQuit);

    private static native void onNotify5Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseInvite groupResponseInvite);

    private static native void onNotify6Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseKick groupResponseKick);

    private static native void onNotify7Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseInfo groupResponseInfo);

    private static native void onNotify8Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseUpdate groupResponseUpdate);

    private static native void onNotify9Native(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseSetNickName groupResponseSetNickName);

    private static native void onNotifyNative(long j, IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j2, long j3, GroupResponseStatus groupResponseStatus);

    public IGroupServiceObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGroupServiceObserverImpl) && getUID(this) == getUID((IGroupServiceObserverImpl) obj);
    }

    private static long getUID(IGroupServiceObserverImpl iGroupServiceObserverImpl) {
        long cPtr = getCPtr(iGroupServiceObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGroupServiceObserverImpl iGroupServiceObserverImpl) {
        if (iGroupServiceObserverImpl == null) {
            return 0L;
        }
        return iGroupServiceObserverImpl.swigCPtr;
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
        IGroupServiceObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGroupServiceObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onNotify(int i, long j, GroupResponseStatus groupResponseStatus) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotifyNative(j2, this, i, j, 0L, groupResponseStatus);
    }

    public void onNotify(int i, long j, GroupResponseCreate groupResponseCreate) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify1Native(j2, this, i, j, 0L, groupResponseCreate);
    }

    public void onNotify(int i, long j, GroupResponseDissolve groupResponseDissolve) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify2Native(j2, this, i, j, 0L, groupResponseDissolve);
    }

    public void onNotify(int i, long j, GroupResponseJoin groupResponseJoin) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify3Native(j2, this, i, j, 0L, groupResponseJoin);
    }

    public void onNotify(int i, long j, GroupResponseQuit groupResponseQuit) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify4Native(j2, this, i, j, 0L, groupResponseQuit);
    }

    public void onNotify(int i, long j, GroupResponseInvite groupResponseInvite) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify5Native(j2, this, i, j, 0L, groupResponseInvite);
    }

    public void onNotify(int i, long j, GroupResponseKick groupResponseKick) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify6Native(j2, this, i, j, 0L, groupResponseKick);
    }

    public void onNotify(int i, long j, GroupResponseInfo groupResponseInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify7Native(j2, this, i, j, 0L, groupResponseInfo);
    }

    public void onNotify(int i, long j, GroupResponseUpdate groupResponseUpdate) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify8Native(j2, this, i, j, 0L, groupResponseUpdate);
    }

    public void onNotify(int i, long j, GroupResponseSetNickName groupResponseSetNickName) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify9Native(j2, this, i, j, 0L, groupResponseSetNickName);
    }

    public void onNotify(int i, long j, GroupResponseFriendList groupResponseFriendList) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify10Native(j2, this, i, j, 0L, groupResponseFriendList);
    }

    public void onNotify(int i, long j, GroupResponseInviteQRUrl groupResponseInviteQRUrl) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify11Native(j2, this, i, j, 0L, groupResponseInviteQRUrl);
    }

    public void onNotify(int i, long j, GroupResponseUrlTranslate groupResponseUrlTranslate) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNotify12Native(j2, this, i, j, 0L, groupResponseUrlTranslate);
    }

    public IGroupServiceObserverImpl() {
        this(createNativeObj(), true);
        GroupObserverJNI.swig_jni_init();
        IGroupServiceObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
