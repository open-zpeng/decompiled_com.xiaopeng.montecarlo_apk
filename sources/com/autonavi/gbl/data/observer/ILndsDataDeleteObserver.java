package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LndsSourceDataType;
import com.autonavi.gbl.data.router.LndsDataDeleteObserverRouter;
@IntfAuto(target = LndsDataDeleteObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILndsDataDeleteObserver {
    void afterDataDelete(int i, @LndsSourceDataType.LndsSourceDataType1 int i2);

    void beforeDataDelete(int i, @LndsSourceDataType.LndsSourceDataType1 int i2);
}
