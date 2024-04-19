package com.autonavi.gbl.map;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.OperatorScaleImpl;
@IntfAuto(target = OperatorScaleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorScale {
    private static String PACKAGE = ReflexTool.PN(OperatorScale.class);
    private OperatorScaleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorScale(long j, boolean z) {
        this(new OperatorScaleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorScale.class, this, this.mControl);
        }
    }

    public OperatorScale(OperatorScaleImpl operatorScaleImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorScaleImpl);
    }

    private void $constructor(OperatorScaleImpl operatorScaleImpl) {
        if (operatorScaleImpl != null) {
            this.mControl = operatorScaleImpl;
            this.mTargetId = String.format("OperatorScale_%s_%d", String.valueOf(OperatorScaleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorScaleImpl getControl() {
        return this.mControl;
    }

    public int getCurrentScale() {
        OperatorScaleImpl operatorScaleImpl = this.mControl;
        if (operatorScaleImpl != null) {
            return operatorScaleImpl.getCurrentScale();
        }
        return 0;
    }

    public int getScale(int i) {
        OperatorScaleImpl operatorScaleImpl = this.mControl;
        if (operatorScaleImpl != null) {
            return operatorScaleImpl.getScale(i);
        }
        return 0;
    }

    public double getMetersPerScalePixel() {
        OperatorScaleImpl operatorScaleImpl = this.mControl;
        if (operatorScaleImpl != null) {
            return operatorScaleImpl.getMetersPerScalePixel();
        }
        return 0.0d;
    }

    public int getScaleLineLength() {
        OperatorScaleImpl operatorScaleImpl = this.mControl;
        if (operatorScaleImpl != null) {
            return operatorScaleImpl.getScaleLineLength();
        }
        return 0;
    }

    public int getScaleLineLengthByAdjust(int i, int i2) {
        OperatorScaleImpl operatorScaleImpl = this.mControl;
        if (operatorScaleImpl != null) {
            return operatorScaleImpl.getScaleLineLengthByAdjust(i, i2);
        }
        return 0;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorScale.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorScale.2
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorScale.3
        }));
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
