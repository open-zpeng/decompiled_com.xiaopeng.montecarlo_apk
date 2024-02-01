package com.autonavi.gbl.map;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IOperatorScaleImpl;
@IntfAuto(target = IOperatorScaleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorScale {
    private static String PACKAGE = ReflexTool.PN(OperatorScale.class);
    private IOperatorScaleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected OperatorScale(long j, boolean z) {
        this(new IOperatorScaleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorScale.class, this, this.mControl);
        }
    }

    public OperatorScale(IOperatorScaleImpl iOperatorScaleImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorScaleImpl);
    }

    private void $constructor(IOperatorScaleImpl iOperatorScaleImpl) {
        if (iOperatorScaleImpl != null) {
            this.mControl = iOperatorScaleImpl;
            this.mTargetId = String.format("OperatorScale_%s_%d", String.valueOf(IOperatorScaleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorScaleImpl getControl() {
        return this.mControl;
    }

    public int getCurrentScale() {
        IOperatorScaleImpl iOperatorScaleImpl = this.mControl;
        if (iOperatorScaleImpl != null) {
            return iOperatorScaleImpl.getCurrentScale();
        }
        return 0;
    }

    public int getScale(int i) {
        IOperatorScaleImpl iOperatorScaleImpl = this.mControl;
        if (iOperatorScaleImpl != null) {
            return iOperatorScaleImpl.getScale(i);
        }
        return 0;
    }

    public double getMetersPerScalePixel() {
        IOperatorScaleImpl iOperatorScaleImpl = this.mControl;
        if (iOperatorScaleImpl != null) {
            return iOperatorScaleImpl.getMetersPerScalePixel();
        }
        return 0.0d;
    }

    public int getScaleLineLength() {
        IOperatorScaleImpl iOperatorScaleImpl = this.mControl;
        if (iOperatorScaleImpl != null) {
            return iOperatorScaleImpl.getScaleLineLength();
        }
        return 0;
    }

    public int getScaleLineLengthByAdjust(int i, int i2) {
        IOperatorScaleImpl iOperatorScaleImpl = this.mControl;
        if (iOperatorScaleImpl != null) {
            return iOperatorScaleImpl.getScaleLineLengthByAdjust(i, i2);
        }
        return 0;
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
