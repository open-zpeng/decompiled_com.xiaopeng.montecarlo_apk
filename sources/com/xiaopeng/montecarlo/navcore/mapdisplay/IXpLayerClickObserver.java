package com.xiaopeng.montecarlo.navcore.mapdisplay;

import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.ClickViewIdInfo;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
/* loaded from: classes3.dex */
public interface IXpLayerClickObserver extends ILayerClickObserver {
    @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
    default void onAfterNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
    default void onBeforeNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
    }
}
