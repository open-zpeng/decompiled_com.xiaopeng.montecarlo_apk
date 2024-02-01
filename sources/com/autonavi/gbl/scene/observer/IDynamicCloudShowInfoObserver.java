package com.autonavi.gbl.scene.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaDataRuleRes;
import com.autonavi.gbl.common.model.DynamicTips;
import com.autonavi.gbl.common.model.RestrictRuleResult;
import com.autonavi.gbl.scene.router.DynamicCloudShowInfoObserverRouter;
@IntfAuto(target = DynamicCloudShowInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDynamicCloudShowInfoObserver {
    default void onDynamicalTipsNotify(DynamicTips dynamicTips) {
    }

    default void onRestrictedDataResult(RestrictRuleResult restrictRuleResult, GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes) {
    }
}
