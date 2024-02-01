package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SceneSearchResult;
import com.autonavi.gbl.search.router.SceneSearchObserverRouter;
@IntfAuto(target = SceneSearchObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ISceneSearchObserver {
    void onGetSceneResult(int i, int i2, SceneSearchResult sceneSearchResult);
}
