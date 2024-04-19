package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.model.SceneErrorCode;
import com.autonavi.gbl.multi.router.KldSceneObserverRouter;
@IntfAuto(target = KldSceneObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IKldSceneObserver {
    int beforeExit(CKldSceneContextImpl cKldSceneContextImpl, String str);

    int beforeInit(CKldSceneContextImpl cKldSceneContextImpl, String str);

    int onInitDone(CKldSceneContextImpl cKldSceneContextImpl, String str);

    int onSceneEntered(CKldSceneContextImpl cKldSceneContextImpl, String str);

    int onSceneError(CKldSceneContextImpl cKldSceneContextImpl, String str, CKldIntent cKldIntent, @SceneErrorCode.SceneErrorCode1 int i);

    int onSceneExited(CKldSceneContextImpl cKldSceneContextImpl, String str);
}
