package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.model.ActionLastDesc;
import com.autonavi.gbl.map.model.Point3F;
import com.autonavi.gbl.map.router.SkeletonLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = SkeletonLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISkeletonLayerItem extends ILayerItem {
    ArrayList<ActionLastDesc> getActionList();

    String getCurrentAction();

    Coord3DDouble getPosition();

    Point3F getRotateAngles();

    float getScaleRation();

    RectDouble getScreenBound();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    void onPaint();
}
