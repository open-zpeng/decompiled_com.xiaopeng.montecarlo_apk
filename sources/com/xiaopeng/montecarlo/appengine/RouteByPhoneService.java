package com.xiaopeng.montecarlo.appengine;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class RouteByPhoneService implements IServicePublisher {
    public static final String PHONE_ROUTE_SEND2CAR_CONTENT = "route_send2car.json";
    public static final String PONE_ROUTE_ACTION = "com.xiaopeng.montecarlo.phone.route.action";
    private static final L.Tag TAG = new L.Tag("RouteByPhoneService");

    @Publish
    public void route() {
        if (L.ENABLE) {
            L.d(TAG, "AI center call route function");
        }
        sendBroadcast();
    }

    private void sendBroadcast() {
        LocalBroadcastManager.getInstance(ContextUtils.getContext()).sendBroadcast(new Intent(PONE_ROUTE_ACTION));
    }
}
