package com.xiaopeng.montecarlo.scenes.routescene;
/* loaded from: classes3.dex */
public class RouteSaveState {
    public static final String KEY_IS_STOP_COUNT_DOWN = "is_stop_count_down";
    public static final String KEY_ROUTE_CHARGE_IS_ENABLE = "is_route_charge_enable";
    public static final String KEY_ROUTE_ISOFFLINE = "is_offline";
    public static final String KEY_ROUTE_REQUEST_ID = "request_id";
    public static final String KEY_ROUTE_SELECT_PATHID = "select_path_id";
    public long mRequestId = -1;
    public int mSelectPathId = 0;
    public boolean mIsOfflineRoute = false;
    public boolean mIsRouteChargeEnable = false;
    public boolean mIsStopCountDown = false;
}
