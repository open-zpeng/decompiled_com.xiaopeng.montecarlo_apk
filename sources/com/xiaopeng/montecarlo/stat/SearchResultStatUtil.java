package com.xiaopeng.montecarlo.stat;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SearchResultStatUtil {
    private static final L.Tag TAG = new L.Tag("SearchResultStatUtil");

    public static void sendStatDataWhenExposure(PageType pageType, String str, int i) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenExposure failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenExposure pagetype:" + pageType + "  keyword:" + str + ", carRemainDis : " + i);
        }
        if (i > 0) {
            DataLogUtil.sendStatData(pageType, BtnType.CHARGE_SEARCH_RESULT_EXPOSURE, str, Integer.valueOf(i));
        } else {
            DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_EXPOSURE, str);
        }
    }

    public static void sendStatDataWhenGotoBackground(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenGotoBackground failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenGotoBackground pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_GOTOBACKGROUND, new Object[0]);
    }

    public static void sendStatDataWhenGotoForeground(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenGotoForeground failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenGotoForeground pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_GOTOFOREGROUND, new Object[0]);
    }

    public static void sendStatDataWhenExit(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenExit failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenExit pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_EXIT, new Object[0]);
    }

    public static void sendStatDataWhenBrowse(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenBrowse failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenBrowse pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_BROWSE, new Object[0]);
    }

    public static void sendStatDataWhenBackClick(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenBackClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenBackClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_BACK_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenExitClick(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenExitClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenExitClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_EXIT_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenItemClick(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenItemClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenItemClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_ITEM_CLICK_BUTTON, new Object[0]);
    }

    public static void sendStatDataWhenNaviClick(PageType pageType, XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenNaviClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenNaviClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_NAVI_BUTTON, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), xPPoiInfo.getXPCategory(), convert2Point(xPPoiInfo));
    }

    public static void sendStatDataWhenAddWayClick(PageType pageType, XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenAddWayClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenAddWayClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_ADD_WAY_BUTTON, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), xPPoiInfo.getXPCategory(), convert2Point(xPPoiInfo));
    }

    public static void sendStatDataWhenRemoveWayClick(PageType pageType, XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenRemoveWayClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenRemoveWayClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_REMOVE_VIA, convert2Point(xPPoiInfo));
    }

    public static void sendStatDataWhenSetHomeClick(PageType pageType, XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSetHomeClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSetHomeClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_SET_HOME_BUTTON, convert2Point(xPPoiInfo));
    }

    public static void sendStatDataWhenSetCompanyClick(PageType pageType, XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSetCompanyClick failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSetCompanyClick pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_SET_COMPANY_BUTTON, convert2Point(xPPoiInfo));
    }

    public static void sendStatDataWhenSelectFilterFree(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSelectFilterFree failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSelectFilterFree pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_CLICK_FILTER_FREE, new Object[0]);
    }

    public static void sendStatDataWhenSelectFilterSelfSale(PageType pageType) {
        if (pageType == PageType.NONE) {
            L.Tag tag = TAG;
            L.w(tag, "sendStatDataWhenSelectFilterSelfSale failure pageType:" + pageType);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "sendStatDataWhenSelectFilterSelfSale pagetype:" + pageType);
        }
        DataLogUtil.sendStatData(pageType, BtnType.SEARCH_RESULT_CLICK_FILTER_SELF_SALE, new Object[0]);
    }

    private static Coord2DDouble convert2Point(XPPoiInfo xPPoiInfo) {
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        coord2DDouble.lat = xPPoiInfo.getDisplayLat();
        coord2DDouble.lon = xPPoiInfo.getDisplayLon();
        return coord2DDouble;
    }
}
