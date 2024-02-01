package com.xiaopeng.montecarlo.mapoverlay.base.control;

import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import java.util.List;
/* loaded from: classes.dex */
public interface IDecoratorOverlayItemOperation {
    void addOverlayItems(List<XPPointBaseData> list);

    void addOverlayObserver(int i, IXpLayerClickObserver iXpLayerClickObserver);

    void clearOverlay();

    void removeOverlayItems(List<XPPointBaseData> list);

    void removeOverlayObserver(int i, IXpLayerClickObserver iXpLayerClickObserver);

    void setOverlayItemFocusStatus(XPPointBaseData xPPointBaseData, boolean z);

    void setOverlayVisible(boolean z);

    boolean updateOverlayItems(List<XPPointBaseData> list);
}
