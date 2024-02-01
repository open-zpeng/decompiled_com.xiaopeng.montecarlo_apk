package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.router.LayerFocusChangeObserverRouter;
@IntfAuto(target = LayerFocusChangeObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILayerFocusChangeObserver {
    void onNotifyFocusChange(BaseLayer baseLayer, LayerItem layerItem, boolean z);
}
