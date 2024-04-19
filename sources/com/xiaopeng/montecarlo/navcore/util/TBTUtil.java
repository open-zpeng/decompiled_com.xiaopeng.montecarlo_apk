package com.xiaopeng.montecarlo.navcore.util;

import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
/* loaded from: classes3.dex */
public class TBTUtil {
    public static long getPathId(@Nullable IVariantPath iVariantPath) {
        if (iVariantPath != null) {
            return iVariantPath.getPathId();
        }
        return -1L;
    }

    public static int getPathIndexFromPathId(@Nullable IPathResult iPathResult, long j) {
        if (iPathResult == null) {
            return -1;
        }
        for (int i = 0; i < iPathResult.getPathCount(); i++) {
            if (getPathId(iPathResult.getPath(i)) == j) {
                return i;
            }
        }
        return -1;
    }

    public static int getPathIndexFromPathId(IPathResult iPathResult, IVariantPath iVariantPath) {
        for (int i = 0; i < iPathResult.getPathCount(); i++) {
            if (getPathId(iPathResult.getPath(i)) == getPathId(iVariantPath)) {
                return i;
            }
        }
        return -1;
    }

    public static int getPathIndexFromPathId(@Nullable INaviPath iNaviPath, long j) {
        if (iNaviPath != null && iNaviPath.getNaviPathCount() >= 0) {
            for (int i = 0; i < iNaviPath.getNaviPathCount(); i++) {
                if (getPathId(iNaviPath.getVariantPath(i)) == j) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getRestoreStatus() {
        return isRestoreExplore(true) ? 2 : 1;
    }

    public static boolean isRestoreExplore(boolean z) {
        boolean z2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_NAVIGATION_STATUS, 1) == 2;
        return z ? z2 : z2 && DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_RESTORE_EXPLORE_STATUS, false);
    }

    public static long getPathViaDistance(long j, int i) {
        RouteResult routeResult;
        if (i >= 0 && (routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId())) != null && routeResult.mRouteInfos != null) {
            for (RouteResult.RouteInfo routeInfo : routeResult.mRouteInfos) {
                if (routeInfo.mPathId == j && CollectionUtils.isNotEmpty(routeInfo.mViasDisList) && i < routeInfo.mViasDisList.size()) {
                    return routeInfo.mViasDisList.get(i).longValue();
                }
            }
        }
        return -1L;
    }
}
