package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.FavoritePointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
@IntfAuto(target = FavoritePointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IFavoritePointLayerItem extends IPointLayerItem {
    @FavoriteType.FavoriteType1
    int getMFavoriteType();
}
