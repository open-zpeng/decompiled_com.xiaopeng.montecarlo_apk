package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.root.datalog.PageType;
/* loaded from: classes3.dex */
public class StatUtil {
    public static PageType getPageType(MainContext mainContext) {
        return DataLogHelper.getPageTypeByCurScene(mainContext);
    }

    public static PageType getParentPageType(MainContext mainContext) {
        return DataLogHelper.getPageTypeByParentScene(mainContext);
    }

    public static PageType getCurnPageType(IBaseScene iBaseScene) {
        return DataLogHelper.getPageTypeByScene(iBaseScene);
    }

    public static int getPoiType(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo.isXPPoiSource()) {
            return 0;
        }
        if (xPPoiInfo.getPoiSource() == 1) {
            return 1;
        }
        if (xPPoiInfo.getPoiSource() == 2) {
            return 2;
        }
        if (xPPoiInfo.getPoiSource() == 8) {
            return 5;
        }
        if (xPPoiInfo.getPoiSource() == 6) {
            return 6;
        }
        return FavoriteDataManager.getInstance().isExist(new FavoriteAddress(xPPoiInfo)) >= 0 ? 3 : 0;
    }

    public static String getPoiCategory(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return "";
        }
        if (XPPoiCategory.isValidBLPoi(xPPoiInfo.getBlCategory())) {
            return xPPoiInfo.getBlCategory();
        }
        return String.valueOf(xPPoiInfo.getCategory());
    }

    public static String formatLocationToStr(double d, double d2) {
        return d + "," + d2;
    }
}
