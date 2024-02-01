package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.router.MassDataLayerRouter;
@IntfAuto(target = MassDataLayerRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMassDataLayer extends IBaseLayer {
    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer, com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    default void enableCollision(boolean z) {
    }

    long getAllDataCount();

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    RectDouble getBound();

    long getCircleDataCount();

    long getPointDataCount();

    long getPolygonDataCount();

    long getPolylineDataCount();
}
