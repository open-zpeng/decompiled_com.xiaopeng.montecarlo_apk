package com.autonavi.gbl.user.msgpush;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.user.msgpush.impl.IMsgPushServiceImpl;
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
import com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver;
import com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IMsgPushServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MsgPushService implements IService {
    private static String PACKAGE = ReflexTool.PN(MsgPushService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IMsgPushServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MsgPushService(long j, boolean z) {
        this((IMsgPushServiceImpl) ReflexTool.invokeDeclConstructorSafe(IMsgPushServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MsgPushService.class, this, this.mControl);
        }
    }

    public MsgPushService(IMsgPushServiceImpl iMsgPushServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iMsgPushServiceImpl);
    }

    private void $constructor(IMsgPushServiceImpl iMsgPushServiceImpl) {
        if (iMsgPushServiceImpl != null) {
            this.mControl = iMsgPushServiceImpl;
            this.mTargetId = String.format("MsgPushService_%s_%d", String.valueOf(IMsgPushServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IMsgPushServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            iMsgPushServiceImpl.onCreate();
        }
    }

    public int init(MsgPushInitParam msgPushInitParam) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.init(msgPushInitParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            iMsgPushServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public int getServiceID() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getServiceID();
        }
        return 0;
    }

    public String getVersion() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getVersion();
        }
        return null;
    }

    public int addObserver(IMsgPushServiceObserver iMsgPushServiceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MsgPushService.class.getMethod("addObserver", IMsgPushServiceObserver.class);
            IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl = null;
            if (iMsgPushServiceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMsgPushServiceObserverImpl = (IMsgPushServiceObserverImpl) typeHelper.transfer(method, 0, iMsgPushServiceObserver);
            }
            IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
            if (iMsgPushServiceImpl != null) {
                return iMsgPushServiceImpl.addObserver(iMsgPushServiceObserverImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void removeObserver(IMsgPushServiceObserver iMsgPushServiceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MsgPushService.class.getMethod("removeObserver", IMsgPushServiceObserver.class);
            IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl = null;
            if (iMsgPushServiceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMsgPushServiceObserverImpl = (IMsgPushServiceObserverImpl) typeHelper.transfer(method, 0, iMsgPushServiceObserver);
            }
            IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
            if (iMsgPushServiceImpl != null) {
                iMsgPushServiceImpl.removeObserver(iMsgPushServiceObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iMsgPushServiceObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @MsgPushStatus.MsgPushStatus1
    public int getMsgPushStatus() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getMsgPushStatus();
        }
        return Integer.MIN_VALUE;
    }

    public int startListen(UserLoginInfo userLoginInfo) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.startListen(userLoginInfo);
        }
        return Integer.MIN_VALUE;
    }

    public int stopListen() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.stopListen();
        }
        return Integer.MIN_VALUE;
    }

    public int setMessageFilter(@MsgPushType.MsgPushType1 int i, boolean z) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.setMessageFilter(i, z);
        }
        return Integer.MIN_VALUE;
    }

    public ArrayList<AutoPushMsg> getAutoPushMessages() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getAutoPushMessages();
        }
        return null;
    }

    public ArrayList<AimPoiPushMsg> getAimPoiPushMessages() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getAimPoiPushMessages();
        }
        return null;
    }

    public ArrayList<AimRoutePushMsg> getAimRoutePushMessages(boolean z) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getAimRoutePushMessages(z);
        }
        return null;
    }

    public ArrayList<AimRoutePushMsg> getAimRoutePushMessages() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getAimRoutePushMessages();
        }
        return null;
    }

    public ArrayList<AimPushMsg> getAimPushMsgCollection(boolean z) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getAimPushMsgCollection(z);
        }
        return null;
    }

    public ArrayList<AimPushMsg> getAimPushMsgCollection() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getAimPushMsgCollection();
        }
        return null;
    }

    public ArrayList<ParkPushMsg> getParkPushMsgMessages() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getParkPushMsgMessages();
        }
        return null;
    }

    public ArrayList<TeamPushMsg> getTeamPushMsgMessages() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getTeamPushMsgMessages();
        }
        return null;
    }

    public ArrayList<PushMsg> getPushMsgCollection() {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getPushMsgCollection();
        }
        return null;
    }

    public RoutepathrestorationPathInfo getRoutePathRestorationPathInfo(long j) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.getRoutePathRestorationPathInfo(j);
        }
        return null;
    }

    public int deleteMessage(@MsgPushType.MsgPushType1 int i, long j) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.deleteMessage(i, j);
        }
        return Integer.MIN_VALUE;
    }

    public int markMessageAsRead(@MsgPushType.MsgPushType1 int i, long j) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.markMessageAsRead(i, j);
        }
        return Integer.MIN_VALUE;
    }

    public int markAllMessageAsRead(@MsgPushType.MsgPushType1 int i) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.markAllMessageAsRead(i);
        }
        return Integer.MIN_VALUE;
    }

    public int updateAimRouteEndPoiName(long j, String str) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.updateAimRouteEndPoiName(j, str);
        }
        return Integer.MIN_VALUE;
    }

    public int publishTeamInfo(TeamUploadMsg teamUploadMsg) {
        IMsgPushServiceImpl iMsgPushServiceImpl = this.mControl;
        if (iMsgPushServiceImpl != null) {
            return iMsgPushServiceImpl.publishTeamInfo(teamUploadMsg);
        }
        return Integer.MIN_VALUE;
    }

    public static AimRoutePushInfo parseAimRoutePushInfo(String str) {
        return IMsgPushServiceImpl.parseAimRoutePushInfo(str);
    }

    public static AimRouteParam parseAimRouteParam(String str) {
        return IMsgPushServiceImpl.parseAimRouteParam(str);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IMsgPushServiceObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
