package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.AnimationEvent;
import com.autonavi.gbl.map.router.LayerItemAnimationObserverRouter;
@IntfAuto(target = LayerItemAnimationObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILayerItemAnimationObserver {
    void onProcessAnimationEvent(BaseLayer baseLayer, LayerItem layerItem, AnimationEvent animationEvent);
}
