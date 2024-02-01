package com.autonavi.gbl.scene.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.scene.model.ScreenParam;
import com.autonavi.gbl.scene.router.ScreenParamAdapterRouter;
@IntfAuto(target = ScreenParamAdapterRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IScreenParamAdapter {
    ScreenParam getScreenParam(@SceneModuleID.SceneModuleID1 int i, long j);
}
