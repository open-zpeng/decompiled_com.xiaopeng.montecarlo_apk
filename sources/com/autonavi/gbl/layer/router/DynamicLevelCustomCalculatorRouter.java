package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.layer.DynamicLevelCustomCalculator;
import com.autonavi.gbl.layer.impl.DynamicLevelCustomCalculatorImpl;
import com.autonavi.gbl.layer.model.DynamicLevelCalcResult;
import com.autonavi.gbl.layer.observer.IDynamicLevelCustomCalculator;
@IntfAuto(target = DynamicLevelCustomCalculator.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class DynamicLevelCustomCalculatorRouter extends DynamicLevelCustomCalculatorImpl {
    private static BindTable BIND_TABLE = new BindTable(DynamicLevelCustomCalculatorRouter.class);
    private static String PACKAGE = ReflexTool.PN(DynamicLevelCustomCalculatorRouter.class);
    private TypeHelper mHelper;
    private IDynamicLevelCustomCalculator mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IDynamicLevelCustomCalculator iDynamicLevelCustomCalculator) {
        if (iDynamicLevelCustomCalculator != null) {
            this.mObserver = iDynamicLevelCustomCalculator;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(DynamicLevelCustomCalculator.class, iDynamicLevelCustomCalculator, this);
            }
        }
    }

    private void $constructor(String str, IDynamicLevelCustomCalculator iDynamicLevelCustomCalculator) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(DynamicLevelCustomCalculatorImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iDynamicLevelCustomCalculator);
    }

    public DynamicLevelCustomCalculatorRouter(String str, IDynamicLevelCustomCalculator iDynamicLevelCustomCalculator, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDynamicLevelCustomCalculator);
    }

    public DynamicLevelCustomCalculatorRouter(String str, IDynamicLevelCustomCalculator iDynamicLevelCustomCalculator) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDynamicLevelCustomCalculator);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.DynamicLevelCustomCalculatorRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.DynamicLevelCustomCalculatorImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.DynamicLevelCustomCalculatorRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.DynamicLevelCustomCalculatorImpl
    public boolean calculateCruiseDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        return $wrapper_calculateCruiseDynamicLevel(i, dynamicLevelCalcResult);
    }

    private boolean $wrapper_calculateCruiseDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        IDynamicLevelCustomCalculator iDynamicLevelCustomCalculator = this.mObserver;
        if (iDynamicLevelCustomCalculator != null) {
            try {
                TypeUtil.deepcopy(iDynamicLevelCustomCalculator.calculateCruiseDynamicLevel(i), dynamicLevelCalcResult);
                return true;
            } catch (Exception unused) {
                DebugTool.e("calculateCruiseDynamicLevel copy failed", new Object[0]);
                return true;
            }
        }
        return true;
    }

    @Override // com.autonavi.gbl.layer.impl.DynamicLevelCustomCalculatorImpl
    public boolean calculateGuide2DNorthUpDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        return $wrapper_calculateGuide2DNorthUpDynamicLevel(i, dynamicLevelCalcResult);
    }

    private boolean $wrapper_calculateGuide2DNorthUpDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        IDynamicLevelCustomCalculator iDynamicLevelCustomCalculator = this.mObserver;
        if (iDynamicLevelCustomCalculator != null) {
            try {
                TypeUtil.deepcopy(iDynamicLevelCustomCalculator.calculateGuide2DNorthUpDynamicLevel(i), dynamicLevelCalcResult);
                return true;
            } catch (Exception unused) {
                DebugTool.e("calculateGuide2DNorthUpDynamicLevel copy failed", new Object[0]);
                return true;
            }
        }
        return true;
    }
}
