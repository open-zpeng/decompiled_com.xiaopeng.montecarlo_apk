package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.router.RunTaskRouter;
@IntfAuto(target = RunTaskRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRunTask {
    long getId();

    String getTaskName();

    default void onCancel() {
    }

    default void run() {
    }
}
