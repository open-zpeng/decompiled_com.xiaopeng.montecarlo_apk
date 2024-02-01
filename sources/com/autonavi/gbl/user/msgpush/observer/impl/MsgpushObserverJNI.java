package com.autonavi.gbl.user.msgpush.observer.impl;

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
/* loaded from: classes2.dex */
public class MsgpushObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyStatus(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, @MsgPushStatus.MsgPushStatus1 int i) {
        iMsgPushServiceObserverImpl.notifyStatus(i);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_0(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, AutoPushMsg autoPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(autoPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_1(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, AimPoiPushMsg aimPoiPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(aimPoiPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_2(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, AimRoutePushMsg aimRoutePushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(aimRoutePushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_3(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, ParkPushMsg parkPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(parkPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_4(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, TeamPushMsg teamPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(teamPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_5(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, TeamUploadResponseMsg teamUploadResponseMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(teamUploadResponseMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_6(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, Tripod2CarPushMsg tripod2CarPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(tripod2CarPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_7(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, LinkStatusPushMsg linkStatusPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(linkStatusPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_8(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, QuitNaviPushMsg quitNaviPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(quitNaviPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_9(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, PlanPrefPushMsg planPrefPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(planPrefPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_10(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, SafeSharePushMsg safeSharePushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(safeSharePushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_11(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, DestinationPushMsg destinationPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(destinationPushMsg);
    }

    public static void SwigDirector_IMsgPushServiceObserverImpl_notifyMessage__SWIG_12(IMsgPushServiceObserverImpl iMsgPushServiceObserverImpl, PaymentCapPushMsg paymentCapPushMsg) {
        iMsgPushServiceObserverImpl.notifyMessage(paymentCapPushMsg);
    }
}
