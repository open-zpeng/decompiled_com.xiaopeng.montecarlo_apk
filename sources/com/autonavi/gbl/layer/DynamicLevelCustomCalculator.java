package com.autonavi.gbl.layer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.DynamicLevelCustomCalculatorImpl;
import com.autonavi.gbl.layer.model.DynamicLevelCalcResult;
import com.autonavi.gbl.layer.observer.IDynamicLevelCustomCalculator;
import com.autonavi.gbl.layer.router.DynamicLevelCustomCalculatorRouter;
@IntfAuto(target = DynamicLevelCustomCalculatorRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class DynamicLevelCustomCalculator implements IDynamicLevelCustomCalculator {
    private static String PACKAGE = ReflexTool.PN(DynamicLevelCustomCalculator.class);
    private boolean mHasDestroy;
    private DynamicLevelCustomCalculatorImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected DynamicLevelCustomCalculator(long j, boolean z) {
        this(new DynamicLevelCustomCalculatorRouter("DynamicLevelCustomCalculator", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IDynamicLevelCustomCalculator.class}, new Object[]{this});
    }

    public DynamicLevelCustomCalculator() {
        this(new DynamicLevelCustomCalculatorRouter("DynamicLevelCustomCalculator", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IDynamicLevelCustomCalculator.class}, new Object[]{this});
    }

    public DynamicLevelCustomCalculator(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(dynamicLevelCustomCalculatorImpl);
    }

    private void $constructor(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl) {
        if (dynamicLevelCustomCalculatorImpl != null) {
            this.mService = dynamicLevelCustomCalculatorImpl;
            this.mTargetId = String.format("DynamicLevelCustomCalculator_%s_%d", String.valueOf(DynamicLevelCustomCalculatorImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected DynamicLevelCustomCalculatorImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.IDynamicLevelCustomCalculator
    public DynamicLevelCalcResult calculateCruiseDynamicLevel(int i) {
        DynamicLevelCalcResult dynamicLevelCalcResult = new DynamicLevelCalcResult();
        if (Boolean.valueOf(calculateCruiseDynamicLevel(i, dynamicLevelCalcResult)).booleanValue()) {
            return dynamicLevelCalcResult;
        }
        return null;
    }

    private boolean calculateCruiseDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl = this.mService;
        if (dynamicLevelCustomCalculatorImpl == null || dynamicLevelCustomCalculatorImpl.isCMemOwn()) {
            return false;
        }
        return this.mService.$explicit_calculateCruiseDynamicLevel(i, dynamicLevelCalcResult);
    }

    @Override // com.autonavi.gbl.layer.observer.IDynamicLevelCustomCalculator
    public DynamicLevelCalcResult calculateGuide2DNorthUpDynamicLevel(int i) {
        DynamicLevelCalcResult dynamicLevelCalcResult = new DynamicLevelCalcResult();
        if (Boolean.valueOf(calculateGuide2DNorthUpDynamicLevel(i, dynamicLevelCalcResult)).booleanValue()) {
            return dynamicLevelCalcResult;
        }
        return null;
    }

    private boolean calculateGuide2DNorthUpDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl = this.mService;
        if (dynamicLevelCustomCalculatorImpl == null || dynamicLevelCustomCalculatorImpl.isCMemOwn()) {
            return false;
        }
        return this.mService.$explicit_calculateGuide2DNorthUpDynamicLevel(i, dynamicLevelCalcResult);
    }
}
