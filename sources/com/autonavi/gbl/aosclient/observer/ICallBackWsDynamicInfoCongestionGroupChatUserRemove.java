package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsDynamicInfoCongestionGroupChatUserRemoveRouter;
@IntfAuto(target = CallBackWsDynamicInfoCongestionGroupChatUserRemoveRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsDynamicInfoCongestionGroupChatUserRemove {
    void onRecvAck(GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam);
}
