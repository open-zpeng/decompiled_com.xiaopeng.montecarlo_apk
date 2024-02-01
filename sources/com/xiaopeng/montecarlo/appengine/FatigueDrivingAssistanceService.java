package com.xiaopeng.montecarlo.appengine;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
/* loaded from: classes.dex */
public class FatigueDrivingAssistanceService implements IServicePublisher {
    private static final String PARAM_KEY_GET_HIGHWAY_INFO = "getHighWayInfo";

    @Publish
    public String getMessage(String str) {
        if (str.compareTo(PARAM_KEY_GET_HIGHWAY_INFO) == 0) {
            return TBTManager.getInstance().getHighWayInfo();
        }
        return null;
    }
}
