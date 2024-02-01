package com.autonavi.gbl.multi.display.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.router.DisplayDataProviderRouter;
@IntfAuto(target = DisplayDataProviderRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDisplayDataProvider {
    int onFetchDeviceAttr(@DisplayType.DisplayType1 int i, DeviceAttribute deviceAttribute);

    int onFetchSkyBox(@DisplayType.DisplayType1 int i, @DAY_STATUS.DAY_STATUS1 int i2, MapSkyboxParam mapSkyboxParam);

    int onFetchSurfaceAttr(@DisplayType.DisplayType1 int i, EGLSurfaceAttr eGLSurfaceAttr);
}
