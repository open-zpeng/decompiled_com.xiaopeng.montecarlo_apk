package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class RestrictStatUtil extends StatUtil {
    private static final L.Tag TAG = new L.Tag("RestrictStatUtil");

    public static void sendStatDataWhenRestrict() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.RESTRICT_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenRestrictClose() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.RESTRICT_BTN_CLOSE, new Object[0]);
    }

    public static void sendStatDataWhenSettingPlate() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.RESTRICT_BTN_SETTING_PLATE, new Object[0]);
    }

    public static void sendStatDataWhenReadDetail() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.RESTRICT_BTN_DETAIL, new Object[0]);
    }
}
