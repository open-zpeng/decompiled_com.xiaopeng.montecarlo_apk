package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.router.RunTaskThreadRouter;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = RunTaskThreadRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRunTaskThread {
    default void cancel(long j) {
    }

    default void cancel(ArrayList<Long> arrayList) {
    }

    default void clear() {
    }

    default void post(RunTask runTask, long j, BigInteger bigInteger) {
    }
}
