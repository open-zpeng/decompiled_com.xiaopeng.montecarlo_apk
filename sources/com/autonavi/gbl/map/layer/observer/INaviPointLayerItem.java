package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.router.NaviPointLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = NaviPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface INaviPointLayerItem extends ILayerItem {
    boolean getBillboard();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    ArrayList<PixelPoint> getBound();

    PointLayerItemStyle getFocusStyle();

    ItemIgnoreRegion getItemIgnoreRegion();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    int getItemType();

    RectInt getItemVisibleRegion();

    PointLayerItemStyle getNormalStyle();

    Coord3DDouble getPosition();

    Coord3DDouble getPosition3D();

    Coord3DDouble getRotateCenter3D();

    ScaleInfo getScale();

    Visible3V getVisible3V();
}
