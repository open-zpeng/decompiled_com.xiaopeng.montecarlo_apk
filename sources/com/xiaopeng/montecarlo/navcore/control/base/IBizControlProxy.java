package com.xiaopeng.montecarlo.navcore.control.base;

import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
/* loaded from: classes2.dex */
public interface IBizControlProxy {
    void addClickObserver(ILayerClickObserver iLayerClickObserver);

    void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver);

    void clearAllItems();

    void clearAllItems(long j);

    void clearFocus(long j);

    BaseLayer getBaseLayer(int i);

    boolean matchBizControl(long j);

    void removeClickObserver(ILayerClickObserver iLayerClickObserver);

    void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver);

    void setClickable(long j, boolean z);

    void setFocus(long j, String str, boolean z);

    void setStyle(IPrepareLayerStyle iPrepareLayerStyle);

    void setVisible(int i, boolean z);

    void setVisible(boolean z);

    void updateStyle();

    void updateStyle(boolean z);
}
