package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldImMsgCommentSetResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsShieldImMsgCommentSetRouter;
@IntfAuto(target = CallBackWsShieldImMsgCommentSetRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsShieldImMsgCommentSet {
    void onRecvAck(GWsShieldImMsgCommentSetResponseParam gWsShieldImMsgCommentSetResponseParam);
}
