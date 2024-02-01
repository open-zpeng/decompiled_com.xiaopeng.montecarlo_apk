package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
/* loaded from: classes3.dex */
public class RecommendChargeStatUtil {
    public static void sendShowData(RecommendChargerBean recommendChargerBean) {
        if (recommendChargerBean == null) {
            return;
        }
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, getShowBtnType(recommendChargerBean.getType()), Integer.valueOf(getChargeStatType(recommendChargerBean)), recommendChargerBean.getId(), recommendChargerBean.getXPPoiInfo().getBlCategory());
    }

    public static void sendClickData(RecommendChargerBean recommendChargerBean) {
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, getClickBtnType(recommendChargerBean.getType()), Integer.valueOf(getChargeStatType(recommendChargerBean)), recommendChargerBean.getXPPoiInfo().getPoiId(), recommendChargerBean.getXPPoiInfo().getBlCategory(), Integer.valueOf(CarServiceManager.getInstance().getCarRemainDistance()));
    }

    private static int getChargeStatType(RecommendChargerBean recommendChargerBean) {
        return StatUtil.getPoiType(recommendChargerBean.getXPPoiInfo());
    }

    private static BtnType getShowBtnType(int i) {
        return RecommendChargerBean.isFrequent(i) ? BtnType.RECOMMEND_CHARGER_FRE_SHOW : BtnType.RECOMMEND_CHARGER_AROUND_SHOW;
    }

    private static BtnType getClickBtnType(int i) {
        return RecommendChargerBean.isFrequent(i) ? BtnType.RECOMMEND_CHARGER_FRE_CLICK : BtnType.RECOMMEND_CHARGER_AROUND_CLICK;
    }
}
