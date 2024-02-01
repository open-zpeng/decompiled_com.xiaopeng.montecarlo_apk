package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.router.UITaskRouter;
@IntfAuto(target = UITaskRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IUITask extends IRunTask {
    @Override // com.autonavi.gbl.util.observer.IRunTask
    long getId();

    @Override // com.autonavi.gbl.util.observer.IRunTask
    default void onCancel() {
    }

    @Override // com.autonavi.gbl.util.observer.IRunTask
    default void run() {
    }
}
