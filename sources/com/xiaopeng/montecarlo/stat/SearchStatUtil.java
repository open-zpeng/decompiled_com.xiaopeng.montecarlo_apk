package com.xiaopeng.montecarlo.stat;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.gbl.multi.model.MultiModelConstants;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes3.dex */
public class SearchStatUtil extends StatUtil {
    private static final L.Tag TAG = new L.Tag("SearchStatUtil");

    public static void sendStatDataWhenSearchPageShow(MainContext mainContext, int i) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSearchPageShow failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSearchPageShow src:" + i);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_SHOW, Integer.valueOf(i));
    }

    public static void sendStatDataWhenSwitchToBackground(PageType pageType, MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        if (pageType == PageType.NONE || pageType == PageType.NAVI_CRUISE || pageType == PageType.NAVI_ROUTING) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSwitchToBackground failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenSwitchToBackground");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_BACKGROUND, new Object[0]);
    }

    public static void sendStatDataWhenSwitchToForeground(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSwitchToForeground failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenSwitchToForeground");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_FOREGROUND, new Object[0]);
    }

    public static void sendStatDataWhenPageExit(PageType pageType, MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenPageExit failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenPageExit");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_EXIT, new Object[0]);
    }

    public static void sendStatDataWhenExecuteGestureOperations(MainContext mainContext, int i) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenExecuteGestureOperations failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenExecuteGestureOperations index:" + i);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_GESTURE_OPERATIONS, Integer.valueOf(i));
    }

    public static void sendStatDataWhenHistoryItemOperations(MainContext mainContext, String str, BtnType btnType, String str2, int i) {
        sendStatDataWhenHistoryItemOperations(mainContext, str, btnType, null, str2, i);
    }

    public static void sendStatDataWhenHistoryItemOperations(MainContext mainContext, String str, BtnType btnType, XPPoiInfo xPPoiInfo, String str2, int i) {
        if (mainContext == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenHistoryItemOperations failure operation:" + str + ",pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenHistoryItemOperations  operation:" + str + ",location:" + str2 + ",index:" + i);
        }
        if (xPPoiInfo == null) {
            DataLogUtil.sendStatData(pageType, btnType, str2, Integer.valueOf(i));
        } else {
            DataLogUtil.sendStatData(pageType, btnType, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), xPPoiInfo.getXPCategory(), str2, Integer.valueOf(i));
        }
    }

    public static void sendStatDataWhenHistoryPathItemSelected(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenHistoryPathItemSelected failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_HISTORY_PATH_ITEM_SELECTED, new Object[0]);
    }

    public static void sendStatDataWhenHistoryItemSelected(MainContext mainContext, String str, int i) {
        sendStatDataWhenHistoryItemOperations(mainContext, "Selected", BtnType.SEARCH_PAGE_HISTORY_ITEM_SELECTED, str, i);
    }

    public static void sendStatDataWhenHistoryItemNavi(MainContext mainContext, XPPoiInfo xPPoiInfo, String str, int i) {
        sendStatDataWhenHistoryItemOperations(mainContext, MultiModelConstants.SCENE_NAME_NAVI, BtnType.SEARCH_PAGE_HISTORY_ITEM_NAVI, xPPoiInfo, str, i);
    }

    public static void sendStatDataWhenHistoryItemSettingHome(MainContext mainContext, String str, int i) {
        sendStatDataWhenHistoryItemOperations(mainContext, "SettingHome", BtnType.SEARCH_PAGE_HISTORY_ITEM_SETTING_HOME, str, i);
    }

    public static void sendStatDataWhenHistoryItemSettingOffice(MainContext mainContext, String str, int i) {
        sendStatDataWhenHistoryItemOperations(mainContext, "SettingOffice", BtnType.SEARCH_PAGE_HISTORY_ITEM_SETTING_OFFICE, str, i);
    }

    public static void sendStatDataWhenHistoryItemAddWaypoint(MainContext mainContext, XPPoiInfo xPPoiInfo, String str, int i) {
        sendStatDataWhenHistoryItemOperations(mainContext, "AddWaypoint", BtnType.SEARCH_PAGE_HISTORY_ITEM_ADD_WAYPOINT, xPPoiInfo, str, i);
    }

    public static void sendStatDataWhenHistoryItemDeleteWaypoint(MainContext mainContext, String str, int i) {
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.SEARCH_NEARBY_PAGE || pageType == PageType.SEARCH_WAYPOINT_PAGE) {
            DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_HISTORY_ITEM_DELETE_WAYPOINT, str, Integer.valueOf(i));
        }
    }

    public static void sendStatDataWhenSugOperations(Context context, MainContext mainContext, String str, BtnType btnType, XPPoiInfo xPPoiInfo, int i) {
        sendStatDataWhenSugOperations(context, getPageType(mainContext), mainContext, str, btnType, xPPoiInfo, i);
    }

    public static void sendStatDataWhenSugOperations(Context context, final PageType pageType, MainContext mainContext, String str, final BtnType btnType, final XPPoiInfo xPPoiInfo, final int i) {
        if (mainContext == null || xPPoiInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSugOperations failure operation:" + str + ",pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSugOperations operation:" + str + ",poiInfo:" + xPPoiInfo + ",index:" + i);
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.SearchStatUtil.1
            @Override // java.lang.Runnable
            public void run() {
                DataLogUtil.sendStatData(PageType.this, btnType, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), xPPoiInfo.getBlCategory(), StatUtil.formatLocationToStr(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat()), Integer.valueOf(i));
            }
        });
    }

    public static void sendStatDataWhenSugSelected(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo, int i) {
        sendStatDataWhenSugOperations(context, mainContext, "Selected", BtnType.SEARCH_PAGE_SUG_SELECTED, xPPoiInfo, i);
    }

    public static void sendStatDataWhenSugNavi(PageType pageType, Context context, MainContext mainContext, XPPoiInfo xPPoiInfo, int i) {
        sendStatDataWhenSugOperations(context, pageType, mainContext, MultiModelConstants.SCENE_NAME_NAVI, BtnType.SEARCH_PAGE_SUG_NAVI, xPPoiInfo, i);
    }

    public static void sendStatDataWhenSugSettingHome(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo, int i) {
        sendStatDataWhenSugOperations(context, mainContext, "SettingHome", BtnType.SEARCH_PAGE_SUG_SETTING_HOME, xPPoiInfo, i);
    }

    public static void sendStatDataWhenSugSettingOffice(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo, int i) {
        sendStatDataWhenSugOperations(context, mainContext, "SettingOffice", BtnType.SEARCH_PAGE_SUG_SETTING_OFFICE, xPPoiInfo, i);
    }

    public static void sendStatDataWhenSugAddWaypoint(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo, int i) {
        sendStatDataWhenSugOperations(context, mainContext, "AddWaypoint", BtnType.SEARCH_PAGE_SUG_ADD_WAYPOINT, xPPoiInfo, i);
    }

    public static void sendStatDataWhenSugDeleteWaypoint(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo, int i) {
        sendStatDataWhenSugOperations(context, mainContext, "DeleteWaypoint", BtnType.SEARCH_PAGE_SUG_DELETE_WAYPOINT, xPPoiInfo, i);
    }

    public static void sendStatDataWhen4STabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhen4STabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhen4STabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_4S, new Object[0]);
    }

    public static void sendStatDataWhenChargeTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenChargeTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenChargeTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_CHARGE, Integer.valueOf(CarServiceManager.getInstance().getCarRemainDistance()));
    }

    public static void sendStatDataWhenRepairTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenRepairTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenRepairTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_REPAIR, new Object[0]);
    }

    public static void sendStatDataWhenParkingTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenParkingTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenParkingTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_PARKING, new Object[0]);
    }

    public static void sendStatDataWhenFoodTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenFoodTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenFoodTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_FOOD, new Object[0]);
    }

    public static void sendStatDataWhenWCTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenWCTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenWCTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_WC, new Object[0]);
    }

    public static void sendStatDataWhenExpCenterTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenExpCenterTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenExpCenterTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_EXP_CENTER, new Object[0]);
    }

    public static void sendStatDataWhenHomeTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenHomeTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenHomeTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_HOME, new Object[0]);
    }

    public static void sendStatDataWhenHomeEmpty(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenHomeEmpty failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenHomeEmpty");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_HOME_EMPTY, new Object[0]);
    }

    public static void sendStatDataWhenHomeEdit(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenHomeEdit failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenHomeEdit");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_HOME_EDIT, new Object[0]);
    }

    public static void sendStatDataWhenOfficeTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenOfficeTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenOfficeTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_OFFICE, new Object[0]);
    }

    public static void sendStatDataWhenOfficeEmpty(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenOfficeEmpty failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenOfficeEmpty");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_OFFICE_EMPTY, new Object[0]);
    }

    public static void sendStatDataWhenOfficeEdit(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenOfficeEdit failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenOfficeEdit");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_OFFICE_EDIT, new Object[0]);
    }

    public static void sendStatDataWhenExitButtonClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenExitButtonClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenExitButtonClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_EXIT_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenExitByGesture(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenExitByGesture failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenExitByGesture");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_EXIT_GESTURE, new Object[0]);
    }

    public static void sendStatDataWhenClearKeywords(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenClearKeywords failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenClearKeywords");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_CLEAR_KEYWORDS_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenDeleteHistoryItem(MainContext mainContext, final XPPoiInfo xPPoiInfo, final int i) {
        if (mainContext == null || xPPoiInfo == null) {
            return;
        }
        final PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenDeleteHistoryItem failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSugOperations poiInfo:" + xPPoiInfo);
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.SearchStatUtil.2
            @Override // java.lang.Runnable
            public void run() {
                DataLogUtil.sendStatData(PageType.this, BtnType.SEARCH_PAGE_DELETE_HISTORY_ITEM, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), xPPoiInfo.getBlCategory(), StatUtil.formatLocationToStr(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat()), Integer.valueOf(i));
            }
        });
    }

    public static void sendStatDataWhenDeleteAllHistories(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenDeleteAllHistories failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenDeleteAllHistories");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_DELETE_ALL_HISTORIES, new Object[0]);
    }

    public static void sendStatDataWhenFavoriteTabClicked(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenHistoryTabClicked failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenHistoryTabClicked");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_TAB_FAVORITES, new Object[0]);
    }

    public static void sendStatDataWhenDeleteFavoriteItem(MainContext mainContext, final XPPoiInfo xPPoiInfo, final int i) {
        if (mainContext == null || xPPoiInfo == null) {
            return;
        }
        final PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenDeleteFavoriteItem failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenDeleteFavoriteItem poiInfo:" + xPPoiInfo);
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.SearchStatUtil.3
            @Override // java.lang.Runnable
            public void run() {
                DataLogUtil.sendStatData(PageType.this, BtnType.SEARCH_PAGE_DELETE_FAVORITE_ITEM, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), xPPoiInfo.getBlCategory(), StatUtil.formatLocationToStr(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat()), Integer.valueOf(i));
            }
        });
    }

    public static void sendStatDataWhenFavListItemSelected(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo) {
        sendStatDataFavListItem(xPPoiInfo, BtnType.SEARCH_PAGE_LIST_ITEM_SELECTED);
    }

    public static void sendStatDataWhenStartNavi(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo) {
        sendStatDataFavListItem(xPPoiInfo, BtnType.SEARCH_PAGE_LIST_ITEM_START_NAVI_CLICK);
    }

    public static void sendStatDataWhenFavListItemAddWayPoint(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo) {
        sendStatDataFavListItem(xPPoiInfo, BtnType.SEARCH_PAGE_LIST_ITEM_ADD_WAY_POINT);
    }

    public static void sendStatDataWhenFavListItemRemoveWayPoint(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo) {
        sendStatDataFavListItem(xPPoiInfo, BtnType.SEARCH_PAGE_LIST_ITEM_REMOVE_WAY_POINT);
    }

    private static void sendStatDataFavListItem(final XPPoiInfo xPPoiInfo, final BtnType btnType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenStartNavi poiInfo:" + xPPoiInfo);
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.SearchStatUtil.4
            @Override // java.lang.Runnable
            public void run() {
                PageType pageType = PageType.NAVI_SEARCH_FAVORITE;
                BtnType btnType2 = BtnType.this;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(StatUtil.getPoiType(xPPoiInfo));
                objArr[1] = xPPoiInfo.getPoiId();
                objArr[2] = xPPoiInfo.getBlCategory();
                objArr[3] = StatUtil.formatLocationToStr(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat());
                objArr[4] = TextUtils.isEmpty(xPPoiInfo.getName()) ? "" : xPPoiInfo.getName();
                DataLogUtil.sendStatData(pageType, btnType2, objArr);
            }
        });
    }

    public static void sendStatDataWhenDeleteAllFavorites(MainContext mainContext) {
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenDeleteAllFavorites");
        }
        DataLogUtil.sendStatData(PageType.NAVI_SEARCH_FAVORITE, BtnType.SEARCH_PAGE_CLEAR_ALL_FAVORITES, new Object[0]);
    }

    public static void sendStatDataWhenCancelSearch(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenCancelSearch failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenCancelSearch");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_CANCELED, new Object[0]);
    }

    public static void sendStatDataWhenSearchNoneResult(MainContext mainContext, String str) {
        if (mainContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSearchNoneResult failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSearchNoneResult keyword:" + str);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_SEARCH_NONE_RESULT, str, XPNetworkManager.INSTANCE.getNetworkType());
    }

    public static void sendStatDataWhenDeleteAllHistoriesDialogConfirmed() {
        DataLogUtil.sendStatData(PageType.MESSAGE_HISTORY_DATA, BtnType.SEARCH_PAGE_DELETE_ALL_HISTORIES_DIALOG_CONFIRM, new Object[0]);
    }

    public static void sendStatDataWhenDeleteAllHistoriesDialogCanceled() {
        DataLogUtil.sendStatData(PageType.MESSAGE_HISTORY_DATA, BtnType.SEARCH_PAGE_DELETE_ALL_HISTORIES_DIALOG_CANCEL, new Object[0]);
    }

    public static void sendStatDataWhenDeleteAllFavoritesDialogConfirmed(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = PageType.MESSAGE_FAVORITE;
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenDeleteAllFavoritesDialogConfirmed");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_DELETE_ALL_FAVORITES_DIALOG_CONFIRM, new Object[0]);
    }

    public static void sendStatDataWhenDeleteAllFavoritesDialogCanceled(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = PageType.MESSAGE_FAVORITE;
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenDeleteAllFavoritesDialogCanceled");
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_PAGE_DELETE_ALL_FAVORITES_DIALOG_CANCEL, new Object[0]);
    }

    public static void sendStatDataWhenbindAmapDialogShow(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenDeleteAllFavoritesDialogCanceled failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenDeleteAllFavoritesDialogCanceled");
        }
        DataLogUtil.sendStatData(PageType.NAVI_AMAPBINDING, BtnType.NAVI_GUIDER_BIND_AMAP_DIALOG_SHOW, new Object[0]);
    }

    public static void biMatchQuickBinded(int i) {
        DataLogUtil.sendStatData(PageType.NAVI_AMAPBINDING, BtnType.SETTING_MATCH_AMAP_ACCOUNT_QUICK_BINDED, Integer.valueOf(i));
    }
}
