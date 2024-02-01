package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsSearchPoiAutoCmallFillOrderResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsSearchPoiAutoCmallFillOrderRouter;
@IntfAuto(target = CallBackWsSearchPoiAutoCmallFillOrderRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsSearchPoiAutoCmallFillOrder {
    void onRecvAck(GWsSearchPoiAutoCmallFillOrderResponseParam gWsSearchPoiAutoCmallFillOrderResponseParam);
}
