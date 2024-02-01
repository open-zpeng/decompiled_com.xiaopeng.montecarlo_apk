package com.autonavi.gbl.scene.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.model.PerceptSceneInfo;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.scene.model.ScenePreviewParam;
import com.autonavi.gbl.scene.router.ViewParamAdapterRouter;
@IntfAuto(target = ViewParamAdapterRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IViewParamAdapter {
    ScenePreviewParam getPreviewParam(@SceneModuleID.SceneModuleID1 int i, PerceptSceneInfo perceptSceneInfo);
}
