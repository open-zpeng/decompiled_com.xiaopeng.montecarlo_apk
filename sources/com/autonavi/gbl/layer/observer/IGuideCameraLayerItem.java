package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.SubCameraExtType;
import com.autonavi.gbl.guide.model.NaviSubCameraExt;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
import java.util.ArrayList;
@IntfAuto(target = GuideCameraLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGuideCameraLayerItem extends IQuadrantLayerItem {
    ArrayList<NaviSubCameraExt> getMAggregatedExts();

    @SubCameraExtType.SubCameraExtType1
    int getMCameraExtType();

    long getMCameraId();

    int getMCameraSpeed();

    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    int getMDistance();

    boolean getMNeedShowNewCamera();

    boolean getMNeedShowPenalty();

    Coord3DDouble getMPosition();

    boolean getMRunTimeShowNewCamera();

    boolean getMRunTimeShowPenalty();

    @BizDirectionStyle.BizDirectionStyle1
    int getMWantDirectionStyle();
}
