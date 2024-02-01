package com.autonavi.gbl.map;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IOperatorAnimationImpl;
import com.autonavi.gbl.map.model.AnimationDeviationParam;
import com.autonavi.gbl.map.model.AnimationGeoAndScreenParam;
import com.autonavi.gbl.map.model.AnimationGroupParam;
import com.autonavi.gbl.map.model.AnimationMoveParam;
import com.autonavi.gbl.map.model.AnimationPivotZoomParam;
import com.autonavi.gbl.map.model.AnimationScreenMoveParam;
import com.autonavi.gbl.map.model.AnimationZoomRotateParam;
import com.autonavi.gbl.map.model.MapAnimationGroupType;
@IntfAuto(target = IOperatorAnimationImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorAnimation {
    private static String PACKAGE = ReflexTool.PN(OperatorAnimation.class);
    private IOperatorAnimationImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected OperatorAnimation(long j, boolean z) {
        this(new IOperatorAnimationImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorAnimation.class, this, this.mControl);
        }
    }

    public OperatorAnimation(IOperatorAnimationImpl iOperatorAnimationImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorAnimationImpl);
    }

    private void $constructor(IOperatorAnimationImpl iOperatorAnimationImpl) {
        if (iOperatorAnimationImpl != null) {
            this.mControl = iOperatorAnimationImpl;
            this.mTargetId = String.format("OperatorAnimation_%s_%d", String.valueOf(IOperatorAnimationImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorAnimationImpl getControl() {
        return this.mControl;
    }

    public void addGroupAnimation(AnimationGroupParam animationGroupParam, long j, boolean z, long j2) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.addGroupAnimation(animationGroupParam, j, z, j2);
        }
    }

    public void addMoveAnimation(AnimationMoveParam animationMoveParam, int i, boolean z, long j) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.addMoveAnimation(animationMoveParam, i, z, j);
        }
    }

    public void addPivotZoomAnimation(AnimationPivotZoomParam animationPivotZoomParam, int i, boolean z, long j) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.addPivotZoomAnimation(animationPivotZoomParam, i, z, j);
        }
    }

    public void addZoomRotateAnimation(AnimationZoomRotateParam animationZoomRotateParam, int i, boolean z, long j) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.addZoomRotateAnimation(animationZoomRotateParam, i, z, j);
        }
    }

    public void addGeoAndScreenCenterAnimation(AnimationGeoAndScreenParam animationGeoAndScreenParam, int i, boolean z, long j) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.addGeoAndScreenCenterAnimation(animationGeoAndScreenParam, i, z, j);
        }
    }

    public void addScreenMoveAnimation(AnimationScreenMoveParam animationScreenMoveParam, int i, boolean z) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.addScreenMoveAnimation(animationScreenMoveParam, i, z);
        }
    }

    public void addDeviationAnimation(AnimationDeviationParam animationDeviationParam, int i, boolean z, long j) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.addDeviationAnimation(animationDeviationParam, i, z, j);
        }
    }

    public void removeAnimation(@MapAnimationGroupType.MapAnimationGroupType1 int i) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.removeAnimation(i);
        }
    }

    public void removeAnimationByTypes(long j, long j2) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.removeAnimationByTypes(j, j2);
        }
    }

    public void removeAnimationByTypes(long j) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.removeAnimationByTypes(j);
        }
    }

    public void removeAnimationByTypes(long j, long j2, boolean z) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.removeAnimationByTypes(j, j2, z);
        }
    }

    public void removeAllAnimation(long j, boolean z) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.removeAllAnimation(j, z);
        }
    }

    public void finishAllAnimation(boolean z, long j) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.finishAllAnimation(z, j);
        }
    }

    public void finishAllAnimation(boolean z) {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            iOperatorAnimationImpl.finishAllAnimation(z);
        }
    }

    public int getAnimationCount() {
        IOperatorAnimationImpl iOperatorAnimationImpl = this.mControl;
        if (iOperatorAnimationImpl != null) {
            return iOperatorAnimationImpl.getAnimationCount();
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
