package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.router.CBLSceneMapRouter;
@IntfAuto(target = CBLSceneMapRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICBLSceneMap extends IKldSceneBase {
    @Override // 
    int onSceneEntered(String str, CKldIntent cKldIntent);

    @Override // 
    int onSceneExit();

    @Override // 
    int onSceneInit(CKldIntent cKldIntent);

    @Override // 
    int onScenePause();

    @Override // 
    int onSceneResume(boolean z);
}
