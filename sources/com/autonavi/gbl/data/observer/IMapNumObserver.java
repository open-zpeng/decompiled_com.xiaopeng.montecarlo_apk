package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.router.MapNumObserverRouter;
@IntfAuto(target = MapNumObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IMapNumObserver {
    void onRequestMapNum(@OperationErrCode.OperationErrCode1 int i, MapNum mapNum);
}
