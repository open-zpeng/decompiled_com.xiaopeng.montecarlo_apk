package com.autonavi.gbl.map;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.GestureConfigure;
import com.autonavi.gbl.map.impl.OperatorGestureImpl;
import com.autonavi.gbl.map.model.GestureInfo;
import com.autonavi.gbl.map.model.TouchEvent;
@IntfAuto(target = OperatorGestureImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class OperatorGesture {
    private static String PACKAGE = ReflexTool.PN(OperatorGesture.class);
    private OperatorGestureImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorGesture(long j, boolean z) {
        this(new OperatorGestureImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorGesture.class, this, this.mControl);
        }
    }

    public OperatorGesture(OperatorGestureImpl operatorGestureImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorGestureImpl);
    }

    private void $constructor(OperatorGestureImpl operatorGestureImpl) {
        if (operatorGestureImpl != null) {
            this.mControl = operatorGestureImpl;
            this.mTargetId = String.format("OperatorGesture_%s_%d", String.valueOf(OperatorGestureImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorGestureImpl getControl() {
        return this.mControl;
    }

    public void setTouchEnable(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setTouchEnable(z);
        }
    }

    public void addTouchEvent(TouchEvent touchEvent) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.addTouchEvent(touchEvent);
        }
    }

    public long addGesture(GestureInfo gestureInfo) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.addGesture(gestureInfo);
        }
        return 0L;
    }

    public void addMapGesture(int i, float f, float f2, float f3) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.addMapGesture(i, f, f2, f3);
        }
    }

    public void setGestureConfigure(GestureConfigure gestureConfigure) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setGestureConfigure(gestureConfigure);
        }
    }

    public GestureConfigure getGestureConfigure() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.getGestureConfigure();
        }
        return null;
    }

    public void enableSliding(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.enableSliding(z);
        }
    }

    public boolean isSlidingEnabled() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.isSlidingEnabled();
        }
        return false;
    }

    public void lockMapRollAngle(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.lockMapRollAngle(z);
        }
    }

    public boolean isMapRollAngleLocked() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.isMapRollAngleLocked();
        }
        return false;
    }

    public void lockMapPitchAngle(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.lockMapPitchAngle(z);
        }
    }

    public boolean isMapPitchAngleLocked() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.isMapPitchAngleLocked();
        }
        return false;
    }

    public void lockMapMove(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.lockMapMove(z);
        }
    }

    public boolean isMapMoveLocked() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.isMapMoveLocked();
        }
        return false;
    }

    public void lockMapPinchZoom(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.lockMapPinchZoom(z);
        }
    }

    public boolean isMapPinchZoomLocked() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.isMapPinchZoomLocked();
        }
        return false;
    }

    public void hidePoiOn3DMoving(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.hidePoiOn3DMoving(z);
        }
    }

    public boolean isPoiHiddenOn3DMoving() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.isPoiHiddenOn3DMoving();
        }
        return false;
    }

    public void hidePoiOn3DSliding(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.hidePoiOn3DSliding(z);
        }
    }

    public boolean isPoiHiddenOn3DSliding() {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            return operatorGestureImpl.isPoiHiddenOn3DSliding();
        }
        return false;
    }

    public void setAxisOfZoomInOnDoublePress(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setAxisOfZoomInOnDoublePress(z);
        }
    }

    public void setAxisOfTwoFingersPress(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setAxisOfTwoFingersPress(z);
        }
    }

    public void setAxisOfTwoFingersScaleRotate(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setAxisOfTwoFingersScaleRotate(z);
        }
    }

    public void setMapLabelClickable(boolean z) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setMapLabelClickable(z);
        }
    }

    public void setLongPressTimeOut(long j) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setLongPressTimeOut(j);
        }
    }

    public void setSinglePressTimeOut(long j) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setSinglePressTimeOut(j);
        }
    }

    public void setTimeOutOfTwoFingersPress(long j) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setTimeOutOfTwoFingersPress(j);
        }
    }

    public void setMaxValidOffsetOfTwoFingersPress(long j, long j2) {
        OperatorGestureImpl operatorGestureImpl = this.mControl;
        if (operatorGestureImpl != null) {
            operatorGestureImpl.setMaxValidOffsetOfTwoFingersPress(j, j2);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorGesture.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorGesture.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorGesture.3
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
