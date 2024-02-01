package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.SearchExitEntranceLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = SearchExitEntranceLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ISearchExitEntranceLayerItem extends IPointLayerItem {
    int getMType();
}
