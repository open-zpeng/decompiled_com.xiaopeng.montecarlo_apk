package com.autonavi.gbl.user.group.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.group.GroupService;
import com.autonavi.gbl.user.group.model.GroupRequestCreate;
import com.autonavi.gbl.user.group.model.GroupRequestDissolve;
import com.autonavi.gbl.user.group.model.GroupRequestFriendList;
import com.autonavi.gbl.user.group.model.GroupRequestInfo;
import com.autonavi.gbl.user.group.model.GroupRequestInvite;
import com.autonavi.gbl.user.group.model.GroupRequestInviteQRUrl;
import com.autonavi.gbl.user.group.model.GroupRequestJoin;
import com.autonavi.gbl.user.group.model.GroupRequestKick;
import com.autonavi.gbl.user.group.model.GroupRequestQuit;
import com.autonavi.gbl.user.group.model.GroupRequestSetNickName;
import com.autonavi.gbl.user.group.model.GroupRequestStatus;
import com.autonavi.gbl.user.group.model.GroupRequestUpdate;
import com.autonavi.gbl.user.group.model.GroupRequestUrlTranslate;
import com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = GroupService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGroupServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IGroupServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int abortRequestNative(long j, IGroupServiceImpl iGroupServiceImpl, long j2);

    private static native int addObserverNative(long j, IGroupServiceImpl iGroupServiceImpl, long j2, IGroupServiceObserverImpl iGroupServiceObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native int executeRequest10Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestFriendList groupRequestFriendList);

    private static native int executeRequest11Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestInviteQRUrl groupRequestInviteQRUrl);

    private static native int executeRequest12Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestUrlTranslate groupRequestUrlTranslate);

    private static native int executeRequest1Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestCreate groupRequestCreate);

    private static native int executeRequest2Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestDissolve groupRequestDissolve);

    private static native int executeRequest3Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestJoin groupRequestJoin);

    private static native int executeRequest4Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestQuit groupRequestQuit);

    private static native int executeRequest5Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestInvite groupRequestInvite);

    private static native int executeRequest6Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestKick groupRequestKick);

    private static native int executeRequest7Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestInfo groupRequestInfo);

    private static native int executeRequest8Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestUpdate groupRequestUpdate);

    private static native int executeRequest9Native(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestSetNickName groupRequestSetNickName);

    private static native int executeRequestNative(long j, IGroupServiceImpl iGroupServiceImpl, long j2, GroupRequestStatus groupRequestStatus);

    private static native int getServiceIDNative(long j, IGroupServiceImpl iGroupServiceImpl);

    private static native String getVersionNative(long j, IGroupServiceImpl iGroupServiceImpl);

    private static native int initNative(long j, IGroupServiceImpl iGroupServiceImpl);

    private static native int isInitNative(long j, IGroupServiceImpl iGroupServiceImpl);

    private static native void removeObserverNative(long j, IGroupServiceImpl iGroupServiceImpl, long j2, IGroupServiceObserverImpl iGroupServiceObserverImpl);

    private static native void unInitNative(long j, IGroupServiceImpl iGroupServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IGroupServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGroupServiceImpl) && getUID(this) == getUID((IGroupServiceImpl) obj);
    }

    private static long getUID(IGroupServiceImpl iGroupServiceImpl) {
        long cPtr = getCPtr(iGroupServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGroupServiceImpl iGroupServiceImpl) {
        if (iGroupServiceImpl == null) {
            return 0L;
        }
        return iGroupServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public int init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public int getServiceID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getServiceIDNative(j, this);
    }

    public int addObserver(IGroupServiceObserverImpl iGroupServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IGroupServiceObserverImpl.getCPtr(iGroupServiceObserverImpl), iGroupServiceObserverImpl);
    }

    public void removeObserver(IGroupServiceObserverImpl iGroupServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IGroupServiceObserverImpl.getCPtr(iGroupServiceObserverImpl), iGroupServiceObserverImpl);
    }

    public int executeRequest(GroupRequestStatus groupRequestStatus) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequestNative(j, this, 0L, groupRequestStatus);
    }

    public int executeRequest(GroupRequestCreate groupRequestCreate) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest1Native(j, this, 0L, groupRequestCreate);
    }

    public int executeRequest(GroupRequestDissolve groupRequestDissolve) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest2Native(j, this, 0L, groupRequestDissolve);
    }

    public int executeRequest(GroupRequestJoin groupRequestJoin) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest3Native(j, this, 0L, groupRequestJoin);
    }

    public int executeRequest(GroupRequestQuit groupRequestQuit) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest4Native(j, this, 0L, groupRequestQuit);
    }

    public int executeRequest(GroupRequestInvite groupRequestInvite) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest5Native(j, this, 0L, groupRequestInvite);
    }

    public int executeRequest(GroupRequestKick groupRequestKick) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest6Native(j, this, 0L, groupRequestKick);
    }

    public int executeRequest(GroupRequestInfo groupRequestInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest7Native(j, this, 0L, groupRequestInfo);
    }

    public int executeRequest(GroupRequestUpdate groupRequestUpdate) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest8Native(j, this, 0L, groupRequestUpdate);
    }

    public int executeRequest(GroupRequestSetNickName groupRequestSetNickName) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest9Native(j, this, 0L, groupRequestSetNickName);
    }

    public int executeRequest(GroupRequestFriendList groupRequestFriendList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest10Native(j, this, 0L, groupRequestFriendList);
    }

    public int executeRequest(GroupRequestInviteQRUrl groupRequestInviteQRUrl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest11Native(j, this, 0L, groupRequestInviteQRUrl);
    }

    public int executeRequest(GroupRequestUrlTranslate groupRequestUrlTranslate) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest12Native(j, this, 0L, groupRequestUrlTranslate);
    }

    public int abortRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return abortRequestNative(j2, this, j);
    }
}
