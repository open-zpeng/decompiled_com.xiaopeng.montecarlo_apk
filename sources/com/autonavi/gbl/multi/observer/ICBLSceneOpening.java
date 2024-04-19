package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.router.CBLSceneOpeningRouter;
@IntfAuto(target = CBLSceneOpeningRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICBLSceneOpening extends IKldSceneBase {
    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    int onSceneEntered(String str, CKldIntent cKldIntent);

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    int onSceneExit();

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    int onSceneInit(CKldIntent cKldIntent);

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    int onScenePause();

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    int onSceneResume(boolean z);
}
