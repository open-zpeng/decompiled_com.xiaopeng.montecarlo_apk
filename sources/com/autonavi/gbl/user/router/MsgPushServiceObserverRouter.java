package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
import com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl;
@IntfAuto(target = IMsgPushServiceObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MsgPushServiceObserverRouter extends IMsgPushServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MsgPushServiceObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MsgPushServiceObserverRouter.class);
    private TypeHelper mHelper;
    private IMsgPushServiceObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMsgPushServiceObserver iMsgPushServiceObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMsgPushServiceObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMsgPushServiceObserver;
    }

    protected MsgPushServiceObserverRouter(String str, IMsgPushServiceObserver iMsgPushServiceObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMsgPushServiceObserver);
    }

    protected MsgPushServiceObserverRouter(String str, IMsgPushServiceObserver iMsgPushServiceObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMsgPushServiceObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.router.MsgPushServiceObserverRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.router.MsgPushServiceObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyStatus(@MsgPushStatus.MsgPushStatus1 int i) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyStatus(i);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(AutoPushMsg autoPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(autoPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(AimPoiPushMsg aimPoiPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(aimPoiPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(AimRoutePushMsg aimRoutePushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(aimRoutePushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(ParkPushMsg parkPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(parkPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(TeamPushMsg teamPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(teamPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(TeamUploadResponseMsg teamUploadResponseMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(teamUploadResponseMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(Tripod2CarPushMsg tripod2CarPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(tripod2CarPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(LinkStatusPushMsg linkStatusPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(linkStatusPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(QuitNaviPushMsg quitNaviPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(quitNaviPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(PlanPrefPushMsg planPrefPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(planPrefPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(SafeSharePushMsg safeSharePushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(safeSharePushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(DestinationPushMsg destinationPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(destinationPushMsg);
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.impl.IMsgPushServiceObserverImpl
    public void notifyMessage(PaymentCapPushMsg paymentCapPushMsg) {
        IMsgPushServiceObserver iMsgPushServiceObserver = this.mObserver;
        if (iMsgPushServiceObserver != null) {
            iMsgPushServiceObserver.notifyMessage(paymentCapPushMsg);
        }
    }
}
