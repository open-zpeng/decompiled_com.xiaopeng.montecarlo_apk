package com.autonavi.gbl.user.msgpush.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
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
import com.autonavi.gbl.user.router.MsgPushServiceObserverRouter;
@IntfAuto(target = MsgPushServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMsgPushServiceObserver {
    void notifyMessage(AimPoiPushMsg aimPoiPushMsg);

    void notifyMessage(AimRoutePushMsg aimRoutePushMsg);

    void notifyMessage(AutoPushMsg autoPushMsg);

    void notifyMessage(DestinationPushMsg destinationPushMsg);

    void notifyMessage(LinkStatusPushMsg linkStatusPushMsg);

    void notifyMessage(ParkPushMsg parkPushMsg);

    void notifyMessage(PaymentCapPushMsg paymentCapPushMsg);

    void notifyMessage(PlanPrefPushMsg planPrefPushMsg);

    void notifyMessage(QuitNaviPushMsg quitNaviPushMsg);

    void notifyMessage(SafeSharePushMsg safeSharePushMsg);

    void notifyMessage(TeamPushMsg teamPushMsg);

    void notifyMessage(TeamUploadResponseMsg teamUploadResponseMsg);

    void notifyMessage(Tripod2CarPushMsg tripod2CarPushMsg);

    void notifyStatus(@MsgPushStatus.MsgPushStatus1 int i);
}
