package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class RouteBridge extends BaseBridge {
    public static final String END_POI = "end_poi";
    public static final String NEW_VIA = "via_poi";
    public static final String ROUTE_REQUEST = "route_request";
    public static final String ROUTE_SENDER = "route_sender";
    public static final String ROUTE_SENDER_AIMSG = "ROUTE_SENDER_AIMSG";
    public static final String START_POI = "start_poi";
    private static final L.Tag TAG = new L.Tag("RouteBridge");

    public RouteBridge() {
        super(StatusConst.Mode.ROUTE);
        enableSingleNotDestroyMode();
    }
}
