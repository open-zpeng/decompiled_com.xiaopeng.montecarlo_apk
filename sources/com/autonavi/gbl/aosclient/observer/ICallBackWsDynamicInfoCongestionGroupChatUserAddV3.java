package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsDynamicInfoCongestionGroupChatUserAddV3Router;
@IntfAuto(target = CallBackWsDynamicInfoCongestionGroupChatUserAddV3Router.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsDynamicInfoCongestionGroupChatUserAddV3 {
    void onRecvAck(GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam);
}
