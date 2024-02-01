package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.DynamicLayerObserverParam;
import com.autonavi.gbl.layer.router.DynamicLayerObserverRouter;
@IntfAuto(target = DynamicLayerObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDynamicLayerObserver {
    float getPointMarkerScaleFactor();

    boolean isNightMode();

    default void onFocusChange(DynamicLayerObserverParam dynamicLayerObserverParam, boolean z) {
    }

    default void onNotifyClick(DynamicLayerObserverParam dynamicLayerObserverParam) {
    }
}
