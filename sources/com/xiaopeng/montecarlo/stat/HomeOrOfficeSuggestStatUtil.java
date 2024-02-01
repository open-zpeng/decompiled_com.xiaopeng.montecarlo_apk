package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class HomeOrOfficeSuggestStatUtil {
    private static final L.Tag TAG = new L.Tag("HomeOrOfficeSuggestStatUtil");

    public static void sendStatDataWhenHomeSugDialogShow() {
        L.d(TAG, "sendStatDataWhenHomeSugDialogShow");
        DataLogUtil.sendStatData(PageType.MESSAGE_HOME_RECOMMENDATION, BtnType.HOME_SUGGEST_DIALOG_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenHomeSugConfirmAdded() {
        L.d(TAG, "sendStatDataWhenHomeSugConfirmAdded");
        DataLogUtil.sendStatData(PageType.MESSAGE_HOME_RECOMMENDATION, BtnType.HOME_SUGGEST_CONFIRM_ADDED, new Object[0]);
    }

    public static void sendStatDataWhenHomeSugCancelAdded() {
        L.d(TAG, "sendStatDataWhenHomeSugCancelAdded");
        DataLogUtil.sendStatData(PageType.MESSAGE_HOME_RECOMMENDATION, BtnType.HOME_SUGGEST_CANCEL_ADDED, new Object[0]);
    }

    public static void sendStatDataWhenOfficeSugDialogShow() {
        L.d(TAG, "sendStatDataWhenOfficeSugdDialogShow");
        DataLogUtil.sendStatData(PageType.MESSAGE_OFFICE_RECOMMENDATION, BtnType.OFFICE_SUGGEST_DIALOG_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenOfficeSugConfirmAdded() {
        L.d(TAG, "sendStatDataWhenOfficeSugConfirmAdded");
        DataLogUtil.sendStatData(PageType.MESSAGE_OFFICE_RECOMMENDATION, BtnType.OFFICE_SUGGEST_CONFIRM_ADDED, new Object[0]);
    }

    public static void sendStatDataWhenOfficeSugCancelAdded() {
        L.d(TAG, "sendStatDataWhenOfficeSugCancelAdded");
        DataLogUtil.sendStatData(PageType.MESSAGE_OFFICE_RECOMMENDATION, BtnType.OFFICE_SUGGEST_CANCEL_ADDED, new Object[0]);
    }

    public static void sendStatDataWhenAddWayPointHomeSettingDialogShow() {
        L.d(TAG, "sendStatDataWhenAddWayPointHomeSettingDialogShow");
        DataLogUtil.sendStatData(PageType.SEARCH_WAYPOINT_PAGE, BtnType.ADD_WAYPOINT_WHEN_HOME_SETTING_DIALOG_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenAddWayPointHomeSettingDialogAdd() {
        L.d(TAG, "sendStatDataWhenAddWayPointHomeSettingDialogAdd");
        DataLogUtil.sendStatData(PageType.SEARCH_WAYPOINT_PAGE, BtnType.ADD_WAYPOINT_WHEN_HOME_SETTING_DIALOG_ADD, new Object[0]);
    }

    public static void sendStatDataWhenAddWayPointHomeSettingDialogStartNavi() {
        L.d(TAG, "sendStatDataWhenAddWayPointHomeSettingDialogStartNavi");
        DataLogUtil.sendStatData(PageType.SEARCH_WAYPOINT_PAGE, BtnType.ADD_WAYPOINT_WHEN_HOME_SETTING_DIALOG_START_NAVI, new Object[0]);
    }

    public static void sendStatDataWhenAddWayPointOfficeSettingDialogShow() {
        L.d(TAG, "sendStatDataWhenAddWayPointOfficeSettingDialogShow");
        DataLogUtil.sendStatData(PageType.SEARCH_WAYPOINT_PAGE, BtnType.ADD_WAYPOINT_WHEN_OFFICE_SETTING_DIALOG_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenAddWayPointOfficeSettingDialogAdd() {
        L.d(TAG, "sendStatDataWhenAddWayPointOfficeSettingDialogAdd");
        DataLogUtil.sendStatData(PageType.SEARCH_WAYPOINT_PAGE, BtnType.ADD_WAYPOINT_WHEN_OFFICE_SETTING_DIALOG_ADD, new Object[0]);
    }

    public static void sendStatDataWhenAddWayPointOfficeSettingDialogStartNavi() {
        L.d(TAG, "sendStatDataWhenAddWayPointOfficeSettingDialogStartNavi");
        DataLogUtil.sendStatData(PageType.SEARCH_WAYPOINT_PAGE, BtnType.ADD_WAYPOINT_WHEN_OFFICE_SETTING_DIALOG_START_NAVI, new Object[0]);
    }
}
