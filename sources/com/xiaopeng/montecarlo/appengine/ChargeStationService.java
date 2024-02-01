package com.xiaopeng.montecarlo.appengine;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.aimessage.AiMsgUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class ChargeStationService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("ChargeStationService");

    @Publish
    public void searchCharge() {
        if (L.ENABLE) {
            L.d(TAG, "AI call search charge");
        }
        AiMsgUtils.getInstance().chargeSearch();
    }
}
