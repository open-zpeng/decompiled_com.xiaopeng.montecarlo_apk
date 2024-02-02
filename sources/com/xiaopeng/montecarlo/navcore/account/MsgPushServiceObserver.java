package com.xiaopeng.montecarlo.navcore.account;

import android.text.TextUtils;
import com.autonavi.gbl.aosclient.model.BLAosCookie;
import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import com.autonavi.gbl.user.msgpush.model.AutoPushMsg;
import com.autonavi.gbl.user.msgpush.model.DestinationPushMsg;
import com.autonavi.gbl.user.msgpush.model.LinkStatusPushMsg;
import com.autonavi.gbl.user.msgpush.model.MsgPushStatus;
import com.autonavi.gbl.user.msgpush.model.ParkPushMsg;
import com.autonavi.gbl.user.msgpush.model.PlanPrefPushMsg;
import com.autonavi.gbl.user.msgpush.model.QuitNaviPushMsg;
import com.autonavi.gbl.user.msgpush.model.SafeSharePushMsg;
import com.autonavi.gbl.user.msgpush.model.TeamPushMsg;
import com.autonavi.gbl.user.msgpush.model.TeamUploadResponseMsg;
import com.autonavi.gbl.user.msgpush.model.Tripod2CarPushMsg;
import com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.event.BLMsgPushEvent;
import com.xiaopeng.montecarlo.navcore.event.BLMsgRoutePushEvent;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes2.dex */
public class MsgPushServiceObserver implements IMsgPushServiceObserver {
    private static final L.Tag TAG = new L.Tag("blMsgPushObs");

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(DestinationPushMsg destinationPushMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(LinkStatusPushMsg linkStatusPushMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(PlanPrefPushMsg planPrefPushMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(QuitNaviPushMsg quitNaviPushMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(SafeSharePushMsg safeSharePushMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(TeamPushMsg teamPushMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(TeamUploadResponseMsg teamUploadResponseMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(Tripod2CarPushMsg tripod2CarPushMsg) {
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyStatus(@MsgPushStatus.MsgPushStatus1 int i) {
        L.Tag tag = TAG;
        L.i(tag, "send2car status = [" + i + "]");
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(AutoPushMsg autoPushMsg) {
        String json = GsonUtil.toJson(autoPushMsg);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "autoPushMsg = [" + json + "]");
        }
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(AimPoiPushMsg aimPoiPushMsg) {
        String json = GsonUtil.toJson(aimPoiPushMsg);
        L.Tag tag = TAG;
        L.i(tag, "send2car aimPoiPushMsg = [" + json + "]");
        BLAosCookie cookie = AosServiceWrapper.getInstance().getBLAosService().getCookie();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "send2car blAosCookie = " + GsonUtil.toJson(cookie));
        }
        if (cookie == null || TextUtils.isEmpty(cookie.mCookie) || aimPoiPushMsg == null || !AccountStore.getInstance().isCurrentLoginAMapUser(aimPoiPushMsg.userId)) {
            return;
        }
        EventBus.getDefault().post(new BLMsgPushEvent(aimPoiPushMsg));
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(AimRoutePushMsg aimRoutePushMsg) {
        String json = GsonUtil.toJson(aimRoutePushMsg);
        L.Tag tag = TAG;
        L.i(tag, "send2car aimRoutePushMsg = [" + json + "]");
        BLAosCookie cookie = AosServiceWrapper.getInstance().getBLAosService().getCookie();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "send2car blAosCookie = " + GsonUtil.toJson(cookie));
        }
        if (cookie == null || TextUtils.isEmpty(cookie.mCookie) || aimRoutePushMsg == null || !AccountStore.getInstance().isCurrentLoginAMapUser(aimRoutePushMsg.userId)) {
            return;
        }
        EventBus.getDefault().post(new BLMsgRoutePushEvent(aimRoutePushMsg));
    }

    @Override // com.autonavi.gbl.user.msgpush.observer.IMsgPushServiceObserver
    public void notifyMessage(ParkPushMsg parkPushMsg) {
        String json = GsonUtil.toJson(parkPushMsg);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "parkPushMsg = [" + json + "]");
        }
    }
}
