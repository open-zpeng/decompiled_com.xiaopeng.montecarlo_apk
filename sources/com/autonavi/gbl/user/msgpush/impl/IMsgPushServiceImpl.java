package com.autonavi.gbl.user.msgpush.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.user.msgpush.MsgPushService;
import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimRouteParam;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushInfo;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import com.autonavi.gbl.user.msgpush.model.AutoPushMsg;
import com.autonavi.gbl.user.msgpush.model.MsgPushInitParam;
import com.autonavi.gbl.user.msgpush.model.MsgPushStatus;
import com.autonavi.gbl.user.msgpush.model.MsgPushType;
import com.autonavi.gbl.user.msgpush.model.ParkPushMsg;
import com.autonavi.gbl.user.msgpush.model.PushMsg;
import com.autonavi.gbl.user.msgpush.model.RoutepathrestorationPathInfo;
import com.autonavi.gbl.user.msgpush.model.TeamPushMsg;
import com.autonavi.gbl.user.msgpush.model.TeamUploadMsg;
import com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = MsgPushService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMsgPushServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IMsgPushServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int addObserverNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, long j2, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl);

    private static native int deleteMessageNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, int i, long j2);

    private static native void destroyNativeObj(long j);

    private static native int getAimPoiPushMessagesNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<AimPoiPushMsg> arrayList);

    private static native int getAimPushMsgCollection1Native(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<AimPushMsg> arrayList);

    private static native int getAimPushMsgCollectionNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<AimPushMsg> arrayList, boolean z);

    private static native int getAimRoutePushMessages1Native(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<AimRoutePushMsg> arrayList);

    private static native int getAimRoutePushMessagesNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<AimRoutePushMsg> arrayList, boolean z);

    private static native int getAutoPushMessagesNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<AutoPushMsg> arrayList);

    private static native int getMsgPushStatusNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl);

    private static native int getParkPushMsgMessagesNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<ParkPushMsg> arrayList);

    private static native int getPushMsgCollectionNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<PushMsg> arrayList);

    private static native int getRoutePathRestorationPathInfoNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, long j2, long j3, RoutepathrestorationPathInfo routepathrestorationPathInfo);

    private static native int getServiceIDNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl);

    private static native int getTeamPushMsgMessagesNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, ArrayList<TeamPushMsg> arrayList);

    private static native String getVersionNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl);

    private static native int initNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, long j2, MsgPushInitParam msgPushInitParam);

    private static native int isInitNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl);

    private static native int markAllMessageAsReadNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, int i);

    private static native int markMessageAsReadNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, int i, long j2);

    private static native boolean parseAimRouteParamNative(String str, long j, AimRouteParam aimRouteParam);

    private static native boolean parseAimRoutePushInfoNative(String str, long j, AimRoutePushInfo aimRoutePushInfo);

    private static native int publishTeamInfoNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, long j2, TeamUploadMsg teamUploadMsg);

    private static native void removeObserverNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, long j2, IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl);

    private static native int setMessageFilterNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, int i, boolean z);

    private static native int startListenNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, long j2, UserLoginInfo userLoginInfo);

    private static native int stopListenNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl);

    private static native void unInitNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl);

    private static native int updateAimRouteEndPoiNameNative(long j, IMsgPushServiceImpl iMsgPushServiceImpl, long j2, String str);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IMsgPushServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMsgPushServiceImpl) && getUID(this) == getUID((IMsgPushServiceImpl) obj);
    }

    private static long getUID(IMsgPushServiceImpl iMsgPushServiceImpl) {
        long cPtr = getCPtr(iMsgPushServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMsgPushServiceImpl iMsgPushServiceImpl) {
        if (iMsgPushServiceImpl == null) {
            return 0L;
        }
        return iMsgPushServiceImpl.swigCPtr;
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

    public int init(MsgPushInitParam msgPushInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, msgPushInitParam);
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

    public int getServiceID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getServiceIDNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public int addObserver(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IMsgPushServiceObserverImpl.getCPtr(iMsgPushServiceObserverImpl), iMsgPushServiceObserverImpl);
    }

    public void removeObserver(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IMsgPushServiceObserverImpl.getCPtr(iMsgPushServiceObserverImpl), iMsgPushServiceObserverImpl);
    }

    @MsgPushStatus.MsgPushStatus1
    public int getMsgPushStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMsgPushStatusNative(j, this);
    }

    public int startListen(UserLoginInfo userLoginInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startListenNative(j, this, 0L, userLoginInfo);
    }

    public int stopListen() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return stopListenNative(j, this);
    }

    public int setMessageFilter(@MsgPushType.MsgPushType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMessageFilterNative(j, this, i, z);
    }

    public ArrayList<AutoPushMsg> getAutoPushMessages() {
        ArrayList<AutoPushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getAutoPushMessages(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getAutoPushMessages(ArrayList<AutoPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAutoPushMessagesNative(j, this, arrayList);
    }

    public ArrayList<AimPoiPushMsg> getAimPoiPushMessages() {
        ArrayList<AimPoiPushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getAimPoiPushMessages(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getAimPoiPushMessages(ArrayList<AimPoiPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimPoiPushMessagesNative(j, this, arrayList);
    }

    public ArrayList<AimRoutePushMsg> getAimRoutePushMessages(boolean z) {
        ArrayList<AimRoutePushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getAimRoutePushMessages(arrayList, z)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getAimRoutePushMessages(ArrayList<AimRoutePushMsg> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimRoutePushMessagesNative(j, this, arrayList, z);
    }

    public ArrayList<AimRoutePushMsg> getAimRoutePushMessages() {
        ArrayList<AimRoutePushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getAimRoutePushMessages(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getAimRoutePushMessages(ArrayList<AimRoutePushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimRoutePushMessages1Native(j, this, arrayList);
    }

    public ArrayList<AimPushMsg> getAimPushMsgCollection(boolean z) {
        ArrayList<AimPushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getAimPushMsgCollection(arrayList, z)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getAimPushMsgCollection(ArrayList<AimPushMsg> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimPushMsgCollectionNative(j, this, arrayList, z);
    }

    public ArrayList<AimPushMsg> getAimPushMsgCollection() {
        ArrayList<AimPushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getAimPushMsgCollection(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getAimPushMsgCollection(ArrayList<AimPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimPushMsgCollection1Native(j, this, arrayList);
    }

    public ArrayList<ParkPushMsg> getParkPushMsgMessages() {
        ArrayList<ParkPushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getParkPushMsgMessages(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getParkPushMsgMessages(ArrayList<ParkPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getParkPushMsgMessagesNative(j, this, arrayList);
    }

    public ArrayList<TeamPushMsg> getTeamPushMsgMessages() {
        ArrayList<TeamPushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getTeamPushMsgMessages(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getTeamPushMsgMessages(ArrayList<TeamPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTeamPushMsgMessagesNative(j, this, arrayList);
    }

    public ArrayList<PushMsg> getPushMsgCollection() {
        ArrayList<PushMsg> arrayList = new ArrayList<>();
        if (Integer.valueOf(getPushMsgCollection(arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getPushMsgCollection(ArrayList<PushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPushMsgCollectionNative(j, this, arrayList);
    }

    public RoutepathrestorationPathInfo getRoutePathRestorationPathInfo(long j) {
        RoutepathrestorationPathInfo routepathrestorationPathInfo = new RoutepathrestorationPathInfo();
        if (Integer.valueOf(getRoutePathRestorationPathInfo(j, routepathrestorationPathInfo)).intValue() == 0) {
            return routepathrestorationPathInfo;
        }
        return null;
    }

    private int getRoutePathRestorationPathInfo(long j, RoutepathrestorationPathInfo routepathrestorationPathInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getRoutePathRestorationPathInfoNative(j2, this, j, 0L, routepathrestorationPathInfo);
    }

    public int deleteMessage(@MsgPushType.MsgPushType1 int i, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return deleteMessageNative(j2, this, i, j);
    }

    public int markMessageAsRead(@MsgPushType.MsgPushType1 int i, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return markMessageAsReadNative(j2, this, i, j);
    }

    public int markAllMessageAsRead(@MsgPushType.MsgPushType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return markAllMessageAsReadNative(j, this, i);
    }

    public int updateAimRouteEndPoiName(long j, String str) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateAimRouteEndPoiNameNative(j2, this, j, str);
    }

    public int publishTeamInfo(TeamUploadMsg teamUploadMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return publishTeamInfoNative(j, this, 0L, teamUploadMsg);
    }

    public static AimRoutePushInfo parseAimRoutePushInfo(String str) {
        AimRoutePushInfo aimRoutePushInfo = new AimRoutePushInfo();
        if (Boolean.valueOf(parseAimRoutePushInfo(str, aimRoutePushInfo)).booleanValue()) {
            return aimRoutePushInfo;
        }
        return null;
    }

    private static boolean parseAimRoutePushInfo(String str, AimRoutePushInfo aimRoutePushInfo) {
        return parseAimRoutePushInfoNative(str, 0L, aimRoutePushInfo);
    }

    public static AimRouteParam parseAimRouteParam(String str) {
        AimRouteParam aimRouteParam = new AimRouteParam();
        if (Boolean.valueOf(parseAimRouteParam(str, aimRouteParam)).booleanValue()) {
            return aimRouteParam;
        }
        return null;
    }

    private static boolean parseAimRouteParam(String str, AimRouteParam aimRouteParam) {
        return parseAimRouteParamNative(str, 0L, aimRouteParam);
    }
}
