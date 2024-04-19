package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.router.UITaskThreadRouter;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = UITaskThreadRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IUITaskThread {
    void cancel(long j);

    void cancel(ArrayList<Long> arrayList);

    void clear();

    void post(UITask uITask, long j, BigInteger bigInteger);
}
