package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class CommutingForecastStatUtil {
    private static final L.Tag TAG = new L.Tag("CommutingForecastStatUtil");

    public static void sendStatDataWhenShowHomeCommutingForecast() {
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenShowHomeCommutingForecast");
        }
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.COMMUTING_FORECAST_HOME_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenNaviToHome() {
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenNaviToHome");
        }
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.COMMUTING_FORECAST_HOME_NAVI, new Object[0]);
    }

    public static void sendStatDataWhenExploreToHome() {
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenExploreToHome");
        }
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.COMMUTING_FORECAST_HOME_EXPLORE, new Object[0]);
    }

    public static void sendStatDataWhenShowCompanyCommutingForecast() {
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenShowCompanyCommutingForecast");
        }
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.COMMUTING_FORECAST_COMPANY_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenNaviToCompany() {
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenNaviToCompany");
        }
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.COMMUTING_FORECAST_COMPANY_NAVI, new Object[0]);
    }

    public static void sendStatDataWhenExploreToCompany() {
        if (L.ENABLE) {
            L.d(TAG, "sendStatDataWhenExploreToCompany");
        }
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.COMMUTING_FORECAST_COMPANY_EXPLORE, new Object[0]);
    }
}
