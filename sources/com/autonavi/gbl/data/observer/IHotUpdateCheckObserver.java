package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.AutoInitResponseData;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.router.HotUpdateCheckObserverRouter;
@IntfAuto(target = HotUpdateCheckObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IHotUpdateCheckObserver {
    void onInitNotify(@OperationErrCode.OperationErrCode1 int i, AutoInitResponseData autoInitResponseData);
}
