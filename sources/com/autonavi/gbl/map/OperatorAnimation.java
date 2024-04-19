package com.autonavi.gbl.map;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.OperatorAnimationImpl;
import com.autonavi.gbl.map.model.AnimationDeviationParam;
import com.autonavi.gbl.map.model.AnimationGeoAndScreenParam;
import com.autonavi.gbl.map.model.AnimationGroupParam;
import com.autonavi.gbl.map.model.AnimationMoveParam;
import com.autonavi.gbl.map.model.AnimationPivotZoomParam;
import com.autonavi.gbl.map.model.AnimationScreenMoveParam;
import com.autonavi.gbl.map.model.AnimationZoomRotateParam;
import com.autonavi.gbl.map.model.MapAnimationGroupType;
@IntfAuto(target = OperatorAnimationImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorAnimation {
    private static String PACKAGE = ReflexTool.PN(OperatorAnimation.class);
    private OperatorAnimationImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorAnimation(long j, boolean z) {
        this(new OperatorAnimationImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorAnimation.class, this, this.mControl);
        }
    }

    public OperatorAnimation(OperatorAnimationImpl operatorAnimationImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorAnimationImpl);
    }

    private void $constructor(OperatorAnimationImpl operatorAnimationImpl) {
        if (operatorAnimationImpl != null) {
            this.mControl = operatorAnimationImpl;
            this.mTargetId = String.format("OperatorAnimation_%s_%d", String.valueOf(OperatorAnimationImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorAnimationImpl getControl() {
        return this.mControl;
    }

    public void addGroupAnimation(AnimationGroupParam animationGroupParam, long j, boolean z, long j2) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.addGroupAnimation(animationGroupParam, j, z, j2);
        }
    }

    public void addMoveAnimation(AnimationMoveParam animationMoveParam, int i, boolean z, long j) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.addMoveAnimation(animationMoveParam, i, z, j);
        }
    }

    public void addPivotZoomAnimation(AnimationPivotZoomParam animationPivotZoomParam, int i, boolean z, long j) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.addPivotZoomAnimation(animationPivotZoomParam, i, z, j);
        }
    }

    public void addZoomRotateAnimation(AnimationZoomRotateParam animationZoomRotateParam, int i, boolean z, long j) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.addZoomRotateAnimation(animationZoomRotateParam, i, z, j);
        }
    }

    public void addGeoAndScreenCenterAnimation(AnimationGeoAndScreenParam animationGeoAndScreenParam, int i, boolean z, long j) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.addGeoAndScreenCenterAnimation(animationGeoAndScreenParam, i, z, j);
        }
    }

    public void addScreenMoveAnimation(AnimationScreenMoveParam animationScreenMoveParam, int i, boolean z) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.addScreenMoveAnimation(animationScreenMoveParam, i, z);
        }
    }

    public void addDeviationAnimation(AnimationDeviationParam animationDeviationParam, int i, boolean z, long j) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.addDeviationAnimation(animationDeviationParam, i, z, j);
        }
    }

    public void removeAnimation(@MapAnimationGroupType.MapAnimationGroupType1 int i) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.removeAnimation(i);
        }
    }

    public void removeAnimationByTypes(long j, long j2) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.removeAnimationByTypes(j, j2);
        }
    }

    public void removeAnimationByTypes(long j) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.removeAnimationByTypes(j);
        }
    }

    public void removeAnimationByTypes(long j, long j2, boolean z) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.removeAnimationByTypes(j, j2, z);
        }
    }

    public void removeAllAnimation(long j, boolean z) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.removeAllAnimation(j, z);
        }
    }

    public void finishAllAnimation(boolean z, long j) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.finishAllAnimation(z, j);
        }
    }

    public void finishAllAnimation(boolean z) {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            operatorAnimationImpl.finishAllAnimation(z);
        }
    }

    public int getAnimationCount() {
        OperatorAnimationImpl operatorAnimationImpl = this.mControl;
        if (operatorAnimationImpl != null) {
            return operatorAnimationImpl.getAnimationCount();
        }
        return 0;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorAnimation.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorAnimation.2
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorAnimation.3
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
