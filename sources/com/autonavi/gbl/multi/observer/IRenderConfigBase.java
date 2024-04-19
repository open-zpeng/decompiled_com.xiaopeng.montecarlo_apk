package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.model.LeftTop;
import com.autonavi.gbl.multi.model.ZoomScale;
import com.autonavi.gbl.multi.router.RenderConfigBaseRouter;
@IntfAuto(target = RenderConfigBaseRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRenderConfigBase extends IKldConfigItemBase {
    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int applyConfig(KldDisplay kldDisplay);

    int getFps();

    boolean getIsMapVisiable();

    float getMapTextScale();

    MapViewPortParam getMapViewPort();

    LeftTop getProjectCenter();

    ZoomScale getZoomScale();

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int parseConfigString(String str);
}
