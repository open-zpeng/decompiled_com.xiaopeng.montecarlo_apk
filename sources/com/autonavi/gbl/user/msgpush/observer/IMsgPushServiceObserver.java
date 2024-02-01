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
    default void notifyMessage(AimPoiPushMsg aimPoiPushMsg) {
    }

    default void notifyMessage(AimRoutePushMsg aimRoutePushMsg) {
    }

    default void notifyMessage(AutoPushMsg autoPushMsg) {
    }

    default void notifyMessage(DestinationPushMsg destinationPushMsg) {
    }

    default void notifyMessage(LinkStatusPushMsg linkStatusPushMsg) {
    }

    default void notifyMessage(ParkPushMsg parkPushMsg) {
    }

    default void notifyMessage(PaymentCapPushMsg paymentCapPushMsg) {
    }

    default void notifyMessage(PlanPrefPushMsg planPrefPushMsg) {
    }

    default void notifyMessage(QuitNaviPushMsg quitNaviPushMsg) {
    }

    default void notifyMessage(SafeSharePushMsg safeSharePushMsg) {
    }

    default void notifyMessage(TeamPushMsg teamPushMsg) {
    }

    default void notifyMessage(TeamUploadResponseMsg teamUploadResponseMsg) {
    }

    default void notifyMessage(Tripod2CarPushMsg tripod2CarPushMsg) {
    }

    default void notifyStatus(@MsgPushStatus.MsgPushStatus1 int i) {
    }
}
