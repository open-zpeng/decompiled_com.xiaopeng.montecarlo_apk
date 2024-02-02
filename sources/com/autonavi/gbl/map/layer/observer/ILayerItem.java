package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.observer.ICollisionItem;
import com.autonavi.gbl.map.router.LayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = LayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILayerItem extends ICollisionItem {
    double getAlpha();

    double getAngle();

    @Override // com.autonavi.gbl.map.observer.ICollisionItem
    ArrayList<PixelPoint> getBound();

    int getBusinessType();

    LayerScale getDisplayScale();

    boolean getFocus();

    String getID();

    String getInfo();

    @LayerItemType.LayerItemType1
    int getItemType();

    double getMaxPitch();

    double getPitch();

    @Override // com.autonavi.gbl.map.observer.ICollisionItem
    int getPriority();

    @Override // com.autonavi.gbl.map.observer.ICollisionItem
    boolean getVisible();

    void onPaint();

    @Override // com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem, com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    void onVisible(boolean z);
}
