package com.autonavi.gbl.user.msgpush.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.user.msgpush.MsgPushService;
import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimRouteParam;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushInfo;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import com.autonavi.gbl.user.msgpush.model.AutoPushMsg;
import com.autonavi.gbl.user.msgpush.model.MobileRouteParam;
import com.autonavi.gbl.user.msgpush.model.MobileRoutePointType;
import com.autonavi.gbl.user.msgpush.model.MsgPushInitParam;
import com.autonavi.gbl.user.msgpush.model.MsgPushStatus;
import com.autonavi.gbl.user.msgpush.model.MsgPushType;
import com.autonavi.gbl.user.msgpush.model.ParkPushMsg;
import com.autonavi.gbl.user.msgpush.model.PushMsg;
import com.autonavi.gbl.user.msgpush.model.RoutepathrestorationPathInfo;
import com.autonavi.gbl.user.msgpush.model.TeamPushMsg;
import com.autonavi.gbl.user.msgpush.model.TeamUploadMsg;
import com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl;
import com.autonavi.gbl.util.model.ErrorCode;
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

    private static native boolean parseAimRouteParamNative(String str, long j, MobileRouteParam mobileRouteParam, long j2, MobileRoutePointType mobileRoutePointType);

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
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public ArrayList<AutoPushMsg> getAutoPushMessages() {
        ArrayList<AutoPushMsg> arrayList = new ArrayList<>();
        if (getAutoPushMessages(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<AimPoiPushMsg> getAimPoiPushMessages() {
        ArrayList<AimPoiPushMsg> arrayList = new ArrayList<>();
        if (getAimPoiPushMessages(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<AimRoutePushMsg> getAimRoutePushMessages() {
        ArrayList<AimRoutePushMsg> arrayList = new ArrayList<>();
        if (getAimRoutePushMessages(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<AimRoutePushMsg> getAimRoutePushMessages(boolean z) {
        ArrayList<AimRoutePushMsg> arrayList = new ArrayList<>();
        if (getAimRoutePushMessages(arrayList, z) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<AimPushMsg> getAimPushMsgCollection() {
        ArrayList<AimPushMsg> arrayList = new ArrayList<>();
        if (getAimPushMsgCollection(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<AimPushMsg> getAimPushMsgCollection(boolean z) {
        ArrayList<AimPushMsg> arrayList = new ArrayList<>();
        if (getAimPushMsgCollection(arrayList, z) != 0) {
            return null;
        }
        return arrayList;
    }

    public static AimRoutePushInfo parseAimRoutePushInfo(String str) {
        AimRoutePushInfo aimRoutePushInfo = new AimRoutePushInfo();
        if (parseAimRoutePushInfo(str, aimRoutePushInfo)) {
            return aimRoutePushInfo;
        }
        return null;
    }

    public ArrayList<ParkPushMsg> getParkPushMsgMessages() {
        ArrayList<ParkPushMsg> arrayList = new ArrayList<>();
        if (getParkPushMsgMessages(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<TeamPushMsg> getTeamPushMsgMessages() {
        ArrayList<TeamPushMsg> arrayList = new ArrayList<>();
        if (getTeamPushMsgMessages(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<PushMsg> getPushMsgCollection() {
        ArrayList<PushMsg> arrayList = new ArrayList<>();
        if (getPushMsgCollection(arrayList) != 0) {
            return null;
        }
        return arrayList;
    }

    public RoutepathrestorationPathInfo getRoutePathRestorationPathInfo(long j) {
        RoutepathrestorationPathInfo routepathrestorationPathInfo = new RoutepathrestorationPathInfo();
        if (getRoutePathRestorationPathInfo(j, routepathrestorationPathInfo) != 0) {
            return null;
        }
        return routepathrestorationPathInfo;
    }

    @ErrorCode.ErrorCode1
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

    @ErrorCode.ErrorCode1
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

    @ErrorCode.ErrorCode1
    public int startListen(UserLoginInfo userLoginInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startListenNative(j, this, 0L, userLoginInfo);
    }

    @ErrorCode.ErrorCode1
    public int stopListen() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return stopListenNative(j, this);
    }

    @ErrorCode.ErrorCode1
    public int setMessageFilter(@MsgPushType.MsgPushType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMessageFilterNative(j, this, i, z);
    }

    @ErrorCode.ErrorCode1
    private int getAutoPushMessages(ArrayList<AutoPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAutoPushMessagesNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getAimPoiPushMessages(ArrayList<AimPoiPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimPoiPushMessagesNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getAimRoutePushMessages(ArrayList<AimRoutePushMsg> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimRoutePushMessagesNative(j, this, arrayList, z);
    }

    @ErrorCode.ErrorCode1
    private int getAimRoutePushMessages(ArrayList<AimRoutePushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimRoutePushMessages1Native(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getAimPushMsgCollection(ArrayList<AimPushMsg> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimPushMsgCollectionNative(j, this, arrayList, z);
    }

    @ErrorCode.ErrorCode1
    private int getAimPushMsgCollection(ArrayList<AimPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAimPushMsgCollection1Native(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getParkPushMsgMessages(ArrayList<ParkPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getParkPushMsgMessagesNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getTeamPushMsgMessages(ArrayList<TeamPushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTeamPushMsgMessagesNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getPushMsgCollection(ArrayList<PushMsg> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPushMsgCollectionNative(j, this, arrayList);
    }

    @ErrorCode.ErrorCode1
    private int getRoutePathRestorationPathInfo(long j, RoutepathrestorationPathInfo routepathrestorationPathInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getRoutePathRestorationPathInfoNative(j2, this, j, 0L, routepathrestorationPathInfo);
    }

    @ErrorCode.ErrorCode1
    public int deleteMessage(@MsgPushType.MsgPushType1 int i, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return deleteMessageNative(j2, this, i, j);
    }

    @ErrorCode.ErrorCode1
    public int markMessageAsRead(@MsgPushType.MsgPushType1 int i, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return markMessageAsReadNative(j2, this, i, j);
    }

    @ErrorCode.ErrorCode1
    public int markAllMessageAsRead(@MsgPushType.MsgPushType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return markAllMessageAsReadNative(j, this, i);
    }

    @ErrorCode.ErrorCode1
    public int updateAimRouteEndPoiName(long j, String str) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateAimRouteEndPoiNameNative(j2, this, j, str);
    }

    @ErrorCode.ErrorCode1
    public int publishTeamInfo(TeamUploadMsg teamUploadMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return publishTeamInfoNative(j, this, 0L, teamUploadMsg);
    }

    public static boolean parseAimRoutePushInfo(String str, AimRoutePushInfo aimRoutePushInfo) {
        return parseAimRoutePushInfoNative(str, 0L, aimRoutePushInfo);
    }

    public static AimRouteParam parseAimRouteParam(String str) {
        AimRouteParam aimRouteParam = new AimRouteParam();
        MobileRouteParam mobileRouteParam = new MobileRouteParam();
        MobileRoutePointType mobileRoutePointType = new MobileRoutePointType();
        Boolean valueOf = Boolean.valueOf(parseAimRouteParam(str, mobileRouteParam, mobileRoutePointType));
        aimRouteParam.routeParam = mobileRouteParam;
        aimRouteParam.pointType = mobileRoutePointType;
        if (valueOf.booleanValue()) {
            return aimRouteParam;
        }
        return null;
    }

    private static boolean parseAimRouteParam(String str, MobileRouteParam mobileRouteParam, MobileRoutePointType mobileRoutePointType) {
        return parseAimRouteParamNative(str, 0L, mobileRouteParam, 0L, mobileRoutePointType);
    }
}
