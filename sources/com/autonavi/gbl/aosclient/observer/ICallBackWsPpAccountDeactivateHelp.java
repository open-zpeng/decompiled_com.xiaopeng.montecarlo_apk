package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateHelpResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpAccountDeactivateHelpRouter;
@IntfAuto(target = CallBackWsPpAccountDeactivateHelpRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpAccountDeactivateHelp {
    void onRecvAck(GWsPpAccountDeactivateHelpResponseParam gWsPpAccountDeactivateHelpResponseParam);
}
