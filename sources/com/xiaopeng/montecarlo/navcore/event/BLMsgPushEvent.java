package com.xiaopeng.montecarlo.navcore.event;

import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
/* loaded from: classes3.dex */
public class BLMsgPushEvent {
    private AimPoiPushMsg mAimPoiPushMsg;

    public BLMsgPushEvent(AimPoiPushMsg aimPoiPushMsg) {
        this.mAimPoiPushMsg = aimPoiPushMsg;
    }

    public AimPoiPushMsg getAimPoiPushMsg() {
        return this.mAimPoiPushMsg;
    }
}
