package com.xiaopeng.montecarlo.stat;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bean.NaviRouteInfo;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SettingStatUtil extends StatUtil {
    public static final int DIALOG_BIND_AMAP_FAIL = 0;
    public static final int DIALOG_BIND_AMAP_SUCCESS = 1;
    public static final int DIALOG_UNBIND_AMAP = 2;
    public static final int NO_AGREE_BIND_FAIL = 5;
    public static final int OPEN_QRCODE_LOGIN = 2;
    public static final int OPEN_QRCODE_LOGIN_FAIL = 4;
    public static final int OPEN_QUICK_LOGIN = 1;
    public static final int OPEN_QUICK_LOGIN_FAIL = 3;
    private static final L.Tag TAG = new L.Tag("SettingStatUtil");
    public static final int UNBIND_FAIL = 7;
    public static final int UNBIND_SUCCESS = 6;

    public static void sendStatDataBindAmap(int i) {
    }

    public static void sendStatDataLoginXPAccount() {
    }

    public static void sendStatDataMsgMatchAmapAccount() {
    }

    public static void sendStatDataMsgUnmatchAmapAccount() {
    }

    public static void sendStatDataEnter(MainContext mainContext) {
        DataLogUtil.sendStatData(DataLogHelper.getPageTypeByParentScene(mainContext), BtnType.SETTING_BTN_ENTER, new Object[0]);
    }

    public static void sendStatDataExposure() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_EXPOSURE, new Object[0]);
    }

    public static void sendStatData2Background() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_TO_BACKGROUND, new Object[0]);
    }

    public static void sendStatData2Foreground() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_TO_FOREGROUND, new Object[0]);
    }

    public static void sendStatDataExit() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_EXIT, new Object[0]);
    }

    public static void sendStatDataAvoidCongestion(boolean z, boolean z2) {
        sendStatData(BtnType.SETTING_AVOID_CONGESTION, z ? 1 : 0, z2 ? 1 : 0);
    }

    private static void sendStatData(BtnType btnType, int i, int i2) {
        DataLogUtil.sendStatData(PageType.SETTING, btnType, Integer.valueOf(i2), Integer.valueOf(i), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataAvoidFee(boolean z, boolean z2) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_AVOID_FEE, Integer.valueOf(z2 ? 1 : 0), Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataAvoidHighWay(boolean z, boolean z2) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_AVOID_HIGHWAY, Integer.valueOf(z2 ? 1 : 0), Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataHighWayPriority(boolean z, boolean z2) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_HIGHWAY_PRIORITY, Integer.valueOf(z2 ? 1 : 0), Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataNaviDetailBroadcast(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_NAVI_DETAIL_BROADCAST, Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataNormalBroadcast(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_NAVI_NORMAL_BROADCAST, Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataUltraSimpleBroadcast(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_NAVI_ULTRA_SIMPLE_BROADCAST, Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendMinimapMapMode(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, z ? BtnType.SETTING_BTN_MINIMAP_MAPMODE_2D : BtnType.SETTING_BTN_MINIMAP_MAPMODE_3D, new Object[0]);
    }

    public static void sendStatDataMapThumbnail() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_MAP_THUMBNAIL, new Object[0]);
    }

    public static void sendStatDataMapLightColumn() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_MAP_LIGHTCOLUMN, new Object[0]);
    }

    public static void sendStatDataCruiseAheadTraffic(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_CRUISE_AHEAD_TRAFFIC, Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataCruiseElectronicEyeBroadcast(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_CRUISE_ELECTRONIC_EYE_BROADCAST, Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataCruiseSafetyBroadcast(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_CRUISE_SAFETY_BROADCAST, Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataAvoidRestrictionRoute(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_AVOID_RESTRICTION_ROUTE, Integer.valueOf(z ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    public static void sendStatDataEditPlate(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_EDIT_PLATE, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataSavePlate(boolean z, String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataSavePlate status:" + (z ? 1 : 0) + " plateNum:" + str);
        }
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_SAVE_PLATE, Integer.valueOf(z ? 1 : 0), str);
    }

    public static void sendStatDataRouteRadar(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_ROUTE_RADAR, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataChargingStationShow(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_CHARGING_STATION_SHOW, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataRealTimeTraffic(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_REAL_TIME_TRAFFIC, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataScratchSpot(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_SCRATCH_SPOT, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDynamicLevel(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_MAP_DYNAMIC_LEVEL, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatRecommendPark(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_RECOMMEND_PARK, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataCarLogo() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_CUSTOM_CAR_LOGO_ENTER, new Object[0]);
    }

    public static void sendStatDataUpateCarLogo(int i) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_CUSTOM_CAR_LOGO_CHANGE, Integer.valueOf(i));
    }

    public static void sendStatDataMsgLoginXPAccount(boolean z) {
        DataLogUtil.sendStatData(PageType.MESSAGE_ACCOUNT, BtnType.SETTING_MSG_LOGIN_XP_ACCOUNT, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataMatchAmapAccountQuickBinded(int i) {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.SETTING_MATCH_AMAP_ACCOUNT_QUICK_BINDED, Integer.valueOf(i));
    }

    public static void sendStatDataUnmatchAmapAccountQuickBinded(int i) {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.SETTING_UNMATCH_AMAP_ACCOUNT_QUICK_BINDED, Integer.valueOf(i));
    }

    public static void sendStatDataDailogAmapQrcode() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.SETTING_DAILOG_AMAP_QRCODE, new Object[0]);
    }

    public static void sendStatDataDelUserData() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_DEL_USER_DATA, new Object[0]);
    }

    public static void sendStatDataSecdCofrimDelUserData() {
        DataLogUtil.sendStatData(PageType.SETTING_USER_DATA, BtnType.SETTING_BTN_SECD_COFRIM_DEL_USER_DATA, new Object[0]);
    }

    public static void sendStatDataCancleUserData() {
        DataLogUtil.sendStatData(PageType.SETTING_USER_DATA, BtnType.SETTING_BTN_CANCLE_USER_DATA, new Object[0]);
    }

    public static void sendStatDataOnClickReset(boolean z) {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_BTN_ONCLICK_RESET, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataWhenThirdPartCalled(MainContext mainContext, NaviRouteInfo naviRouteInfo, BtnType btnType, String str) {
        if (mainContext == null || naviRouteInfo == null || btnType == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenThirdPartCalled failure pageType:" + pageType + " BtnType: " + btnType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenThirdPartCalled BtnType: " + btnType + " pageType: " + pageType + " categoryCode:" + str);
        }
        if (pageType == PageType.NAVI_CRUISE || pageType == PageType.NAVI_ROUTING || pageType == PageType.NAVI_DETECT_ROUTE || pageType == PageType.NAVI_GUIDANCE || pageType == PageType.SEARCH_MAIN_PAGE || pageType == PageType.Navi_Search_Main_Result || pageType == PageType.SETTING) {
            XPPoiInfo endInfo = naviRouteInfo.getEndInfo();
            if (endInfo != null) {
                XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
                xPCoordinate2DDouble.mLat = endInfo.getDisplayLat();
                xPCoordinate2DDouble.mLon = endInfo.getDisplayLon();
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(StatUtil.getPoiType(endInfo));
                objArr[1] = endInfo.getPoiId();
                if (TextUtils.isEmpty(str)) {
                    str = endInfo.getBlCategory();
                }
                objArr[2] = str;
                objArr[3] = xPCoordinate2DDouble;
                DataLogUtil.sendStatData(pageType, btnType, objArr);
                return;
            }
            L.w(TAG, "sendStatDataWhenThirdPartCalled failure because poiInfo is null");
        }
    }

    private static float getCarSpeed() {
        return TBTManager.getInstance().getCarSpeed();
    }

    public static void sendStatDataWhenCallWeChat(MainContext mainContext) {
        if (mainContext == null) {
            return;
        }
        PageType pageType = StatUtil.getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenCallWeChat failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenCallWeChat");
        }
        if (pageType == PageType.NAVI_CRUISE || pageType == PageType.NAVI_ROUTING || pageType == PageType.NAVI_DETECT_ROUTE || pageType == PageType.NAVI_GUIDANCE || pageType == PageType.SEARCH_MAIN_PAGE || pageType == PageType.Navi_Search_Main_Result || pageType == PageType.SETTING) {
            DataLogUtil.sendStatData(pageType, BtnType.USER_CENTER_WE_CHAT, new Object[0]);
        }
    }
}
