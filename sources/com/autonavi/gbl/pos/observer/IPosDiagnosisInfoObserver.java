package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.router.PosDiagnosisInfoObserverRouter;
@IntfAuto(target = PosDiagnosisInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosDiagnosisInfoObserver {
    void onDiagnosisInfoUpdate(String str);
}
