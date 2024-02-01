package com.xiaopeng.montecarlo.scenes.cruisescene.card;

import com.xiaopeng.montecarlo.service.navi.type.Request;
/* loaded from: classes3.dex */
public class Action {
    public static final String ACTION_NAVI_SERVICE = "com.xiaopeng.montecarlo.NAVI_ACTION";
    public static int TYPE_SEND_BROADCAST = 1;
    public static int TYPE_START_ACTIVITY = 0;
    public static int TYPE_START_SERVICE = 2;
    public String actionImg;
    public String actionName;
    public int actionType;
    public Request datas;
}
