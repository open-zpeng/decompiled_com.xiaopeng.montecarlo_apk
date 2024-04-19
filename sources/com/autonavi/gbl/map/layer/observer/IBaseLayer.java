package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.observer.ICollisionGroup;
import com.autonavi.gbl.map.router.BaseLayerRouter;
import java.util.ArrayList;
@IntfAuto(target = BaseLayerRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IBaseLayer extends ICollisionGroup {
    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    void applyItemsOnVisible();

    ArrayList<LayerItem> getAllItems();

    RectDouble getBound();

    boolean getClickable();

    int getCount();

    LayerScale getDisplayScale();

    int getFilterPoiType();

    boolean getFocus(String str);

    LayerItem getItem(String str);

    long getLayerID();

    String getName();

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    LayerPriority getPriority();

    boolean getVisible();

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    void intersectUI(ArrayList<RectDouble> arrayList);

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    void lockItems();

    void onPaint();

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    void unLockItems();

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    void updateQuadrantItems();
}
