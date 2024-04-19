package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizChargeStationInfo;
import com.autonavi.gbl.layer.router.SearchChargeStationLayerItemRouter;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = SearchChargeStationLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISearchChargeStationLayerItem extends IPointLayerItem {
    BizChargeStationInfo getMChargeStationInfo();

    @Override // 
    boolean getOnVisible();

    Visible3V getOnVisible3V();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.layer.observer.IRouteBlockLayerItem
    void onVisible(boolean z);

    void onVisible3V(Visible3V visible3V);
}
