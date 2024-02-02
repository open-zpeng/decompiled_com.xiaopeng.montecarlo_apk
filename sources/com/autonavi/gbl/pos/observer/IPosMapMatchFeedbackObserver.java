package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.LocMMFeedbackInfo;
import com.autonavi.gbl.pos.router.PosMapMatchFeedbackObserverRouter;
@IntfAuto(target = PosMapMatchFeedbackObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosMapMatchFeedbackObserver {
    void onMapMatchFeedbackUpdate(LocMMFeedbackInfo locMMFeedbackInfo);
}
