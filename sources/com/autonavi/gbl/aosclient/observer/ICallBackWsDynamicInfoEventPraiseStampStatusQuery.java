package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoEventPraiseStampStatusQueryResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsDynamicInfoEventPraiseStampStatusQueryRouter;
@IntfAuto(target = CallBackWsDynamicInfoEventPraiseStampStatusQueryRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsDynamicInfoEventPraiseStampStatusQuery {
    void onRecvAck(GWsDynamicInfoEventPraiseStampStatusQueryResponseParam gWsDynamicInfoEventPraiseStampStatusQueryResponseParam);
}
