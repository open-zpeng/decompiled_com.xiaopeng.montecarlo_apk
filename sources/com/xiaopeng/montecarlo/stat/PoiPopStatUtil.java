package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes3.dex */
public class PoiPopStatUtil extends StatUtil {
    private static final L.Tag TAG = new L.Tag("PoiPopStatUtil");
    private static final PageType[] B0514_PAGES = {PageType.NAVI_CRUISE, PageType.NAVI_ROUTING, PageType.NAVI_DETECT_ROUTE, PageType.NAVI_GUIDANCE, PageType.Navi_Search_Main_Result, PageType.SEARCH_WAYPOINT_RESULT, PageType.SEARCH_HOME_RESULT, PageType.SEARCH_OFFICE_RESULT, PageType.SEARCH_NEARBY_RESULT, PageType.SEARCH_CHARGINGSTATION_RESULT};

    public static void sendStatDataWhenPoiPop(final XPPoiInfo xPPoiInfo, MainContext mainContext) {
        L.Tag tag = TAG;
        L.d(tag, "sendStatDataWhenPoiPop poiInfo:" + xPPoiInfo + ",mainContext:" + mainContext);
        if (xPPoiInfo == null || mainContext == null) {
            return;
        }
        final PageType parentPageType = getParentPageType(mainContext);
        if (parentPageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenPoiPop failure pageType:" + parentPageType);
            return;
        }
        final String blCategory = xPPoiInfo.getBlCategory();
        if (xPPoiInfo.isXPPoiSource()) {
            blCategory = String.valueOf(xPPoiInfo.getCategory());
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.PoiPopStatUtil.1
            @Override // java.lang.Runnable
            public void run() {
                DataLogUtil.sendStatData(PageType.this, BtnType.POI_CARD_SHOW, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), blCategory, 0);
            }
        });
    }

    public static void sendStatDataWhenPoiDismiss(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenPoiDismiss mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenPoiDismiss failure pageType:" + pageType);
        } else if (checkB0514NeedLogForPages(pageType)) {
            DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_DISMISS, new Object[0]);
        }
    }

    private static boolean checkB0514NeedLogForPages(PageType pageType) {
        for (PageType pageType2 : B0514_PAGES) {
            if (pageType.getPageId().equals(pageType2.getPageId())) {
                return true;
            }
        }
        return false;
    }

    public static void sendStatDataWhenStartNavi(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenStartNavi mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenStartNavi failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_START_NAVI_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenAddWaypoint(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenAddWaypoint mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenAddWaypoint failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_ADD_WAYPOINT_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenDeleteWaypoint(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenDeleteWaypoint mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenDeleteWaypoint failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_DELETE_WAYPOINT_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenSubPoi(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSubPoi mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenSubPoi failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_SUB_POI_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenFavorite(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenFavorite mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenFavorite failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_FAVORITE_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenSearchAround(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSearchAround mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenSearchAround failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_SEARCH_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenGesture(MainContext mainContext, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenGesture mainContext:" + mainContext + ",type:" + i);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenGesture failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_ACTION_GESTURE, Integer.valueOf(i));
    }

    public static void sendStatDataWhenSettingHome(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSettingHome mainContext:" + mainContext);
        }
        if (mainContext == null) {
            L.w(TAG, "sendStatDataWhenSettingHome failure mainContext is null");
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenSettingHome failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag3 = TAG;
            L.d(tag3, "sendStatDataWhenSettingHome pageType:" + pageType);
        }
        if (pageType != PageType.NAVI_CRUISE) {
            DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_SETTING_HOME_BUTTON, new Object[0]);
        }
    }

    public static void sendStatDataWhenSettingCompany(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSettingCompany mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenSettingCompany failure pageType:" + pageType);
        } else if (pageType != PageType.NAVI_CRUISE) {
            DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_SETTING_COMPANY_BUTTON, new Object[0]);
        }
    }

    public static void sendStatDataWhenSelectChargeSpot(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSelectChargeSpot mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenSelectChargeSpot failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_SELECT_CHARGE_SPOT_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenDialWithBT(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenDialWithBT mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenDialWithBT failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_DEAIL_WITH_BT_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenShowPicture(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenDialWithBT mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenDialWithBT failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.POI_CARD_SHOW_PICTURE_BUTTON, new Object[0]);
    }
}
