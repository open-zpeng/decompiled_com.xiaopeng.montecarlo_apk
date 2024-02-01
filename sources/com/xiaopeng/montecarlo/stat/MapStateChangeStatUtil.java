package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class MapStateChangeStatUtil extends StatUtil {
    private static final L.Tag TAG = new L.Tag("MapStateChangeStatUtil");

    public static void sendStatDataWhenMapStateActive(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenMapStateActive mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType parentPageType = getParentPageType(mainContext);
        if (parentPageType == PageType.NONE || parentPageType == PageType.SETTING) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenMapStateActive failure pageType:" + parentPageType);
                return;
            }
            return;
        }
        DataLogUtil.sendStatData(parentPageType, BtnType.MAP_STATE_ACTIVE, new Object[0]);
    }

    public static void sendStatDataWhenMapStateImmersion(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenMapStateImmersion mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType parentPageType = getParentPageType(mainContext);
        if (parentPageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenMapStateImmersion failure pageType:" + parentPageType);
                return;
            }
            return;
        }
        DataLogUtil.sendStatData(parentPageType, BtnType.MAP_STATE_IMMERSION, new Object[0]);
    }

    public static void sendStatData(MainContext mainContext, int i) {
        if (i == 0) {
            sendStatDataWhenMapStateActive(mainContext);
        } else if (i == 1) {
            sendStatDataWhenMapStateImmersion(mainContext);
        }
    }
}
