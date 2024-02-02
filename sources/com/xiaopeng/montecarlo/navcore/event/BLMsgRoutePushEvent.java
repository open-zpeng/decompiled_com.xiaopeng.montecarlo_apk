package com.xiaopeng.montecarlo.navcore.event;

import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
/* loaded from: classes2.dex */
public class BLMsgRoutePushEvent {
    private AimRoutePushMsg mAimRoutePushMsg;

    public BLMsgRoutePushEvent(AimRoutePushMsg aimRoutePushMsg) {
        this.mAimRoutePushMsg = aimRoutePushMsg;
    }

    public AimRoutePushMsg getAimRoutePushMsg() {
        return this.mAimRoutePushMsg;
    }
}
