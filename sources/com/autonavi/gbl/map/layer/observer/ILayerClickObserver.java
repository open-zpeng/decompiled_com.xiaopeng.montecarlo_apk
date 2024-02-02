package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.observer.impl.ClickViewIdInfo;
import com.autonavi.gbl.map.router.LayerClickObserverRouter;
@IntfAuto(target = LayerClickObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILayerClickObserver {
    void onAfterNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo);

    void onBeforeNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo);

    void onNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo);
}
