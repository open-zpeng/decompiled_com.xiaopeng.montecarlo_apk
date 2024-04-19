package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdCheckbindResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpCarltdCheckbindRouter;
@IntfAuto(target = CallBackWsPpCarltdCheckbindRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpCarltdCheckbind {
    void onRecvAck(GWsPpCarltdCheckbindResponseParam gWsPpCarltdCheckbindResponseParam);
}
