package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizDynamicControl;
import com.autonavi.gbl.layer.model.DynamicControlType;
import com.autonavi.gbl.layer.model.DynamicInitParam;
import com.autonavi.gbl.layer.model.DynamicInitParamEx;
import com.autonavi.gbl.layer.model.RuleBoolParam;
import com.autonavi.gbl.layer.model.RuleFloatParam;
import com.autonavi.gbl.layer.model.RuleInt64Param;
import com.autonavi.gbl.layer.model.RuleStringParam;
import java.util.ArrayList;
@IntfAuto(target = BizDynamicControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizDynamicControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizDynamicControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizDynamicControlImpl_SWIGUpcast(long j);

    private static native int createDynamicLayerNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl, String str, String str2, ArrayList<Long> arrayList);

    private static native int destroyDynamicLayerNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2);

    private static native void destroyNativeObj(long j);

    private static native long getBizTypeNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl, String str);

    private static native int getControlTypeNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl);

    private static native int init1Native(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, DynamicInitParamEx dynamicInitParamEx);

    private static native int initNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, DynamicInitParam dynamicInitParam);

    private static native int switchStyleNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl, int i);

    private static native int unInitNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl);

    private static native int updateRuleValue1Native(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, long j3, RuleFloatParam ruleFloatParam);

    private static native int updateRuleValue2Native(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, long j3, RuleBoolParam ruleBoolParam);

    private static native int updateRuleValue3Native(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, long j3, RuleStringParam ruleStringParam);

    private static native int updateRuleValue4Native(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, String str, String str2);

    private static native int updateRuleValueNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, long j3, RuleInt64Param ruleInt64Param);

    private static native int updateSourceDataNative(long j, IBizDynamicControlImpl iBizDynamicControlImpl, long j2, String str);

    public IBizDynamicControlImpl(long j, boolean z) {
        super(IBizDynamicControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizDynamicControlImpl) {
            return getUID(this) == getUID((IBizDynamicControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizDynamicControlImpl iBizDynamicControlImpl) {
        long cPtr = getCPtr(iBizDynamicControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizDynamicControlImpl iBizDynamicControlImpl) {
        if (iBizDynamicControlImpl == null) {
            return 0L;
        }
        return iBizDynamicControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public int init(DynamicInitParam dynamicInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, dynamicInitParam);
    }

    public int unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return unInitNative(j, this);
    }

    public ArrayList<Long> createDynamicLayer(String str, String str2) {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (Integer.valueOf(createDynamicLayer(str, str2, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int createDynamicLayer(String str, String str2, ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return createDynamicLayerNative(j, this, str, str2, arrayList);
    }

    public int updateSourceData(long j, String str) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateSourceDataNative(j2, this, j, str);
    }

    public int destroyDynamicLayer(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return destroyDynamicLayerNative(j2, this, j);
    }

    public long getBizType(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBizTypeNative(j, this, str);
    }

    @DynamicControlType.DynamicControlType1
    public int getControlType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getControlTypeNative(j, this);
    }

    public int updateRuleValue(long j, RuleInt64Param ruleInt64Param) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateRuleValueNative(j2, this, j, 0L, ruleInt64Param);
    }

    public int updateRuleValue(long j, RuleFloatParam ruleFloatParam) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateRuleValue1Native(j2, this, j, 0L, ruleFloatParam);
    }

    public int updateRuleValue(long j, RuleBoolParam ruleBoolParam) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateRuleValue2Native(j2, this, j, 0L, ruleBoolParam);
    }

    public int updateRuleValue(long j, RuleStringParam ruleStringParam) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateRuleValue3Native(j2, this, j, 0L, ruleStringParam);
    }

    public int updateRuleValue(long j, String str, String str2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return updateRuleValue4Native(j2, this, j, str, str2);
    }

    public int init(DynamicInitParamEx dynamicInitParamEx) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return init1Native(j, this, 0L, dynamicInitParamEx);
    }

    public int switchStyle(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return switchStyleNative(j, this, i);
    }
}
