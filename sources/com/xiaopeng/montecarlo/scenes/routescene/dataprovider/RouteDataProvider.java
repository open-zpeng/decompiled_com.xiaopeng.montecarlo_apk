package com.xiaopeng.montecarlo.scenes.routescene.dataprovider;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes3.dex */
public class RouteDataProvider extends BaseDataProvider<BaseResultData, BaseParameter, BaseCallBack> {
    private static final L.Tag TAG = new L.Tag("RouteDataProvider");

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected DataProviderResponse fetchDataDelegate(BaseParameter baseParameter) throws DataProviderException {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return null;
    }

    public long requestRoute(@NonNull RouteParams routeParams, RouteManager.IRouteResultListener iRouteResultListener) {
        XPPoiInfo xPPoiInfo = routeParams.mStartInfo;
        XPPoiInfo xPPoiInfo2 = routeParams.mEndInfo;
        List<XPViaPoint> list = routeParams.mViaInfos;
        int i = routeParams.mRoutePreference;
        if (xPPoiInfo == null || xPPoiInfo2 == null) {
            return -1L;
        }
        return TBTManager.getInstance().requestRoute(new RouteParams.Builder().setStartInfo(xPPoiInfo).setEndInfo(xPPoiInfo2).setViaInfos(list).setRouteLevel(2).setIsRequestOdd(CarServiceManager.getInstance().isNGPOn()).setRoutePreference(i).build(), iRouteResultListener);
    }

    public long restoreRoute(RouteManager.IRouteResultListener iRouteResultListener) {
        RouteParams restoreRouteParams = TBTManager.getInstance().getRestoreRouteParams();
        if (restoreRouteParams != null) {
            restoreRouteParams.mStartInfo = TBTManager.getInstance().getStartPOIFromCurrent();
            return TBTManager.getInstance().requestRoute(restoreRouteParams, iRouteResultListener);
        }
        return -1L;
    }

    public void cancelRoute(long j) {
        TBTManager.getInstance().cancelRequestRoute(j);
    }
}
