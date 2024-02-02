package com.xiaopeng.montecarlo.navcore.powerdistance.route;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.powerdistance.IExternalDataListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PdExternalData;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class RoutePowerDisHelperContainer implements IExternalDataListener {
    private ConcurrentHashMap<Long, PdExternalData> mDataMap = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<RoutePowerDisHelper> mPresenterArrayList = new CopyOnWriteArrayList<>();
    private IRouteExternalDataListener mRouteExternalDataListener;

    /* loaded from: classes2.dex */
    public interface IRouteExternalDataListener {
        void onKeyPointsFetched(Map<Long, PdExternalData> map);
    }

    public void createDisHelper(XPNaviInfo xPNaviInfo, @NonNull IVariantPath iVariantPath, @NonNull IPathResult iPathResult, @NonNull OnUpdateRemainDisListener onUpdateRemainDisListener, IRouteExternalDataListener iRouteExternalDataListener) {
        this.mPresenterArrayList.add(new RoutePowerDisHelper(xPNaviInfo, iVariantPath, iPathResult, onUpdateRemainDisListener, this));
        this.mRouteExternalDataListener = iRouteExternalDataListener;
        this.mDataMap.clear();
    }

    public void clear() {
        if (CollectionUtils.isNotEmpty(this.mPresenterArrayList)) {
            for (int size = this.mPresenterArrayList.size() - 1; size >= 0; size--) {
                this.mPresenterArrayList.remove(size).close();
            }
            this.mDataMap.clear();
        }
    }

    public void updateRemainDis() {
        if (CollectionUtils.isNotEmpty(this.mPresenterArrayList)) {
            for (int size = this.mPresenterArrayList.size() - 1; size >= 0; size--) {
                this.mPresenterArrayList.get(size).updateRemainDis(true);
            }
        }
    }

    public double getOnlineK(int i) {
        RoutePowerDisHelper routePowerDisHelper;
        if (!CollectionUtils.isIndexLegal(i, this.mPresenterArrayList) || (routePowerDisHelper = this.mPresenterArrayList.get(i)) == null) {
            return 1.0d;
        }
        double k = routePowerDisHelper.getK();
        if (L.ENABLE) {
            L.Tag tag = RoutePowerDisHelper.TAG;
            L.d(tag, "getOnlineK  pathIndex: " + i + "  pathId:" + routePowerDisHelper.getPathId());
            return k;
        }
        return k;
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.IExternalDataListener
    public void onExternalDataFetched(final long j, final PdExternalData pdExternalData) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelperContainer.1
            @Override // java.lang.Runnable
            public void run() {
                RoutePowerDisHelperContainer.this.mDataMap.put(Long.valueOf(j), pdExternalData);
                if (L.ENABLE) {
                    L.Tag tag = RoutePowerDisHelper.TAG;
                    L.d(tag, "ROUTE_CHARGE onExternalDataFetched: " + RoutePowerDisHelperContainer.this.mDataMap.size() + "  mPresenterArrayList:" + RoutePowerDisHelperContainer.this.mPresenterArrayList.size());
                }
                if (RoutePowerDisHelperContainer.this.mDataMap.size() != RoutePowerDisHelperContainer.this.mPresenterArrayList.size() || RoutePowerDisHelperContainer.this.mRouteExternalDataListener == null) {
                    return;
                }
                RoutePowerDisHelperContainer.this.mRouteExternalDataListener.onKeyPointsFetched(RoutePowerDisHelperContainer.this.mDataMap);
            }
        });
    }
}
