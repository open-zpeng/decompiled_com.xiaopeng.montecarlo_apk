package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.DynamicLevelCalcResult;
import com.autonavi.gbl.layer.router.DynamicLevelCustomCalculatorRouter;
@IntfAuto(target = DynamicLevelCustomCalculatorRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDynamicLevelCustomCalculator {
    DynamicLevelCalcResult calculateCruiseDynamicLevel(int i);

    DynamicLevelCalcResult calculateGuide2DNorthUpDynamicLevel(int i);
}
