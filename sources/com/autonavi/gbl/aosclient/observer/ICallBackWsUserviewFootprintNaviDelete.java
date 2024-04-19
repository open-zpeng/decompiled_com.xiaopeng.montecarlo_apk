package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviDeleteResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsUserviewFootprintNaviDeleteRouter;
@IntfAuto(target = CallBackWsUserviewFootprintNaviDeleteRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsUserviewFootprintNaviDelete {
    void onRecvAck(GWsUserviewFootprintNaviDeleteResponseParam gWsUserviewFootprintNaviDeleteResponseParam);
}
