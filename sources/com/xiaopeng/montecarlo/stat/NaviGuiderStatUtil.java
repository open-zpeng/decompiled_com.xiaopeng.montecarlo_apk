package com.xiaopeng.montecarlo.stat;

import android.text.TextUtils;
import com.autonavi.gbl.user.msgpush.model.AimPoiInfo;
import com.xiaopeng.montecarlo.aimessage.type.MapPoint;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
/* loaded from: classes3.dex */
public class NaviGuiderStatUtil extends StatUtil {
    public static void loginXpAccountBtn() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.SETTING_BTN_LOGIN_XP_ACCOUNT, new Object[0]);
    }

    public static void bIGifIconBtn() {
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.NAVI_GUIDER_GIF_ICON_BTN, new Object[0]);
    }

    public static void bISettingNaviGuiderEnterBtn() {
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.SETTING_NAVI_GUIDER_ENTER_ICON_BTN, new Object[0]);
    }

    public static void bIAmapIconClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_BIND_AMAP_TAB_ICON_BTN, new Object[0]);
    }

    public static void bIWechatIconClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_WECHAT_TAB_ICON_BTN, new Object[0]);
    }

    public static void bIXiaopengIconClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_XP_ACCOUNT_TAB_ICON_BTN, new Object[0]);
    }

    public static void bIBindAmapPager() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_BIND_AMAP_PAGER, new Object[0]);
    }

    public static void bIWeChatPager() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_WECHAT_PAGER, new Object[0]);
    }

    public static void bIXpAccountPager() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_XP_ACCOUNT_PAGER, new Object[0]);
    }

    public static void bIUnbindAmapBtn() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_UNBIND_AMAP_BTN, new Object[0]);
    }

    public static void bINaviGuiderCloseEvent() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_CLOSE_EVENT, new Object[0]);
    }

    public static void bIIsAmapAccount(boolean z) {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_IS_AMAP_ACCOUNT, Boolean.valueOf(z));
    }

    public static void bIBaiduIconClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_BAIDU_ICON_BTN, new Object[0]);
    }

    public static void bIDianpingIconClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_DIANPING_ICON_BTN, new Object[0]);
    }

    public static void bIMeituanIconClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_MEITUAN_ICON_BTN, new Object[0]);
    }

    public static void bIBindAmapClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_BIND_AMAP_BTN, new Object[0]);
    }

    public static void bIBindWechatClick() {
        DataLogUtil.sendStatData(PageType.NAVI_MESSAGE_NAVI_SYNC, BtnType.NAVI_GUIDER_BIND_WECHAT_BTN, new Object[0]);
    }

    public static void bIAmapSend2AI(AimPoiInfo aimPoiInfo) {
        if (aimPoiInfo != null) {
            XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
            xPCoordinate2DDouble.mLat = aimPoiInfo.lat;
            xPCoordinate2DDouble.mLon = aimPoiInfo.lon;
            PageType pageType = PageType.NAVI_MESSAGE_NAVI_SYNC;
            BtnType btnType = BtnType.NAVI_GUIDER_AMAP_SEND2AI;
            Object[] objArr = new Object[3];
            objArr[0] = TextUtils.isEmpty(aimPoiInfo.poiId) ? "" : aimPoiInfo.poiId;
            objArr[1] = TextUtils.isEmpty(aimPoiInfo.poiType) ? "" : aimPoiInfo.poiType;
            objArr[2] = xPCoordinate2DDouble;
            DataLogUtil.sendStatData(pageType, btnType, objArr);
        }
    }

    public static void bIAmapSend2CarStartRoute(StatusConst.Mode mode, AimPoiInfo aimPoiInfo) {
        if (aimPoiInfo != null) {
            XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
            xPCoordinate2DDouble.mLat = aimPoiInfo.lat;
            xPCoordinate2DDouble.mLon = aimPoiInfo.lon;
            PageType pageType = getPageType(mode);
            BtnType btnType = BtnType.NAVI_GUIDER_AMAP_SEND2CAR_START_NAVI;
            Object[] objArr = new Object[4];
            objArr[0] = TextUtils.isEmpty(aimPoiInfo.poiId) ? "" : aimPoiInfo.poiId;
            objArr[1] = TextUtils.isEmpty(aimPoiInfo.poiType) ? "" : aimPoiInfo.poiType;
            objArr[2] = XPPoiCategory.BL_CATEGORY_INVALID;
            objArr[3] = xPCoordinate2DDouble;
            DataLogUtil.sendStatData(pageType, btnType, objArr);
        }
    }

    public static void bIWechatSend2CarStartRoute(StatusConst.Mode mode, MapRouteMsg mapRouteMsg) {
        MapPoint dest;
        if (mapRouteMsg == null || (dest = mapRouteMsg.getDest()) == null) {
            return;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        xPCoordinate2DDouble.mLat = dest.getLat();
        xPCoordinate2DDouble.mLon = dest.getLon();
        PageType pageType = getPageType(mode);
        BtnType btnType = BtnType.NAVI_GUIDER_WECHAT_SEND2CART_START_NAVI;
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(dest.getId()) ? "" : dest.getId();
        objArr[1] = TextUtils.isEmpty(dest.getPoiType()) ? "" : dest.getPoiType();
        objArr[2] = "";
        objArr[3] = xPCoordinate2DDouble;
        DataLogUtil.sendStatData(pageType, btnType, objArr);
    }

    public static void bIXpSend2CarStartRoute(StatusConst.Mode mode, MapRouteMsg mapRouteMsg) {
        MapPoint dest;
        if (mapRouteMsg == null || (dest = mapRouteMsg.getDest()) == null) {
            return;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        xPCoordinate2DDouble.mLat = dest.getLat();
        xPCoordinate2DDouble.mLon = dest.getLon();
        PageType pageType = getPageType(mode);
        BtnType btnType = BtnType.NAVI_GUIDER_XP_SEND2CAR_START_NAVI;
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(dest.getId()) ? "" : dest.getId();
        objArr[1] = TextUtils.isEmpty(dest.getPoiType()) ? "" : dest.getPoiType();
        objArr[2] = "";
        objArr[3] = xPCoordinate2DDouble;
        DataLogUtil.sendStatData(pageType, btnType, objArr);
    }

    public static void bIXpRouteSend2CarStartRoute(StatusConst.Mode mode, MapRouteMsg mapRouteMsg) {
        MapPoint dest;
        if (mapRouteMsg == null || (dest = mapRouteMsg.getDest()) == null) {
            return;
        }
        PageType pageType = getPageType(mode);
        if (PageType.NAVI_CRUISE == pageType || PageType.NAVI_ROUTING == pageType || PageType.NAVI_DETECT_ROUTE == pageType || PageType.SEARCH_MAIN_PAGE == pageType) {
            int transformCategory = XPPoiCategory.transformCategory(dest.getPoiType());
            BtnType btnType = BtnType.NAVI_GUIDER_XP_ROUTE_SEND2CAR_START_NAVI;
            Object[] objArr = new Object[4];
            objArr[0] = TextUtils.isEmpty(dest.getId()) ? "" : dest.getId();
            objArr[1] = TextUtils.isEmpty(dest.getType()) ? "" : dest.getType();
            objArr[2] = Integer.valueOf(transformCategory);
            objArr[3] = dest;
            DataLogUtil.sendStatData(pageType, btnType, objArr);
        }
    }

    private static PageType getPageType(StatusConst.Mode mode) {
        switch (mode) {
            case EMPTY:
                return PageType.NONE;
            case ROUTE:
                return PageType.NAVI_ROUTING;
            case CONTAINER_ROUTE:
                return PageType.NAVI_CONTAINER;
            case NAVI:
                return PageType.NAVI_GUIDANCE;
            case DRIVING:
                return PageType.NAVI_CRUISE;
            case SEARCH:
                return PageType.SEARCH_MAIN_PAGE;
            case SEARCH_RESULT:
                return PageType.Navi_Search_Main_Result;
            case CONTAINER_SEARCH_RESULT:
                return PageType.NAVI_CONTAINER;
            case SET_HOME_OFFICE:
                return PageType.SEARCH_MAIN_PAGE;
            case SETTING:
                return PageType.SETTING;
            case SETTING_LICENCE_PLATE:
                return PageType.SETTING;
            case SETTING_MAP_DOWNLOAD:
                return PageType.SETTING;
            case DEBUG:
                return PageType.SETTING;
            case SCAN_SEARCH:
                return PageType.SEARCH_MAIN_PAGE;
            case EXPLORE:
                return PageType.NAVI_DETECT_ROUTE;
            case CONTAINER_EXPLORE:
                return PageType.NAVI_CONTAINER;
            case RESTRICT:
                return PageType.SETTING;
            case NAVI_GUIDER:
                return PageType.NAVI_MESSAGE_NAVI_SYNC;
            case CRUISE:
                return PageType.NAVI_CRUISE;
            case LINK_SEAMLESS_NAVI:
                return PageType.NAVI_MESSAGE_NAVI_SYNC;
            case POPDIALOG:
                return PageType.NONE;
            default:
                return PageType.NONE;
        }
    }
}
