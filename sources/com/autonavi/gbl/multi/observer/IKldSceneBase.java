package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.model.SceneViewState;
import com.autonavi.gbl.multi.router.KldSceneBaseRouter;
@IntfAuto(target = KldSceneBaseRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IKldSceneBase {
    CKldSceneContextImpl getContext();

    DisplaySceneConfigBase getSceneConf();

    String getSceneName();

    CKldIntent getUserData();

    void onNewIntent(CKldIntent cKldIntent);

    int onSceneEntered(String str, CKldIntent cKldIntent);

    int onSceneExit();

    int onSceneInit(CKldIntent cKldIntent);

    int onScenePause();

    int onSceneResume(boolean z);

    int onUpateSceneState(String str, SceneViewState sceneViewState);
}
