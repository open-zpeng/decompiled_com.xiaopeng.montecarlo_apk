package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizDynamicControlImpl;
import com.autonavi.gbl.layer.model.DynamicControlType;
import com.autonavi.gbl.layer.model.DynamicInitParam;
import com.autonavi.gbl.layer.model.DynamicInitParamEx;
import com.autonavi.gbl.layer.model.RuleBoolParam;
import com.autonavi.gbl.layer.model.RuleFloatParam;
import com.autonavi.gbl.layer.model.RuleInt64Param;
import com.autonavi.gbl.layer.model.RuleStringParam;
import java.util.ArrayList;
@IntfAuto(target = IBizDynamicControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizDynamicControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizDynamicControl.class);
    private IBizDynamicControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizDynamicControl(long j, boolean z) {
        this(new IBizDynamicControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizDynamicControl.class, this, this.mControl);
        }
    }

    public BizDynamicControl(IBizDynamicControlImpl iBizDynamicControlImpl) {
        super(iBizDynamicControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizDynamicControlImpl);
    }

    private void $constructor(IBizDynamicControlImpl iBizDynamicControlImpl) {
        if (iBizDynamicControlImpl != null) {
            this.mControl = iBizDynamicControlImpl;
            this.mTargetId = String.format("BizDynamicControl_%s_%d", String.valueOf(IBizDynamicControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizDynamicControlImpl getControl() {
        return this.mControl;
    }

    public int init(DynamicInitParam dynamicInitParam) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.init(dynamicInitParam);
        }
        return Integer.MIN_VALUE;
    }

    public int unInit() {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.unInit();
        }
        return Integer.MIN_VALUE;
    }

    public ArrayList<Long> createDynamicLayer(String str, String str2) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.createDynamicLayer(str, str2);
        }
        return null;
    }

    public int updateSourceData(long j, String str) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.updateSourceData(j, str);
        }
        return Integer.MIN_VALUE;
    }

    public int destroyDynamicLayer(long j) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.destroyDynamicLayer(j);
        }
        return Integer.MIN_VALUE;
    }

    public long getBizType(String str) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.getBizType(str);
        }
        return 0L;
    }

    @DynamicControlType.DynamicControlType1
    public int getControlType() {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.getControlType();
        }
        return Integer.MIN_VALUE;
    }

    public int updateRuleValue(long j, RuleInt64Param ruleInt64Param) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.updateRuleValue(j, ruleInt64Param);
        }
        return Integer.MIN_VALUE;
    }

    public int updateRuleValue(long j, RuleFloatParam ruleFloatParam) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.updateRuleValue(j, ruleFloatParam);
        }
        return Integer.MIN_VALUE;
    }

    public int updateRuleValue(long j, RuleBoolParam ruleBoolParam) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.updateRuleValue(j, ruleBoolParam);
        }
        return Integer.MIN_VALUE;
    }

    public int updateRuleValue(long j, RuleStringParam ruleStringParam) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.updateRuleValue(j, ruleStringParam);
        }
        return Integer.MIN_VALUE;
    }

    public int updateRuleValue(long j, String str, String str2) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.updateRuleValue(j, str, str2);
        }
        return Integer.MIN_VALUE;
    }

    public int init(DynamicInitParamEx dynamicInitParamEx) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.init(dynamicInitParamEx);
        }
        return Integer.MIN_VALUE;
    }

    public int switchStyle(int i) {
        IBizDynamicControlImpl iBizDynamicControlImpl = this.mControl;
        if (iBizDynamicControlImpl != null) {
            return iBizDynamicControlImpl.switchStyle(i);
        }
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
