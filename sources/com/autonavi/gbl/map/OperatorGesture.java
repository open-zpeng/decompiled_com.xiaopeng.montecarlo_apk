package com.autonavi.gbl.map;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IOperatorGestureImpl;
import com.autonavi.gbl.map.model.GestureConfigure;
import com.autonavi.gbl.map.model.GestureInfo;
import com.autonavi.gbl.map.model.TouchEvent;
@IntfAuto(target = IOperatorGestureImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorGesture {
    private static String PACKAGE = ReflexTool.PN(OperatorGesture.class);
    private IOperatorGestureImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected OperatorGesture(long j, boolean z) {
        this(new IOperatorGestureImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorGesture.class, this, this.mControl);
        }
    }

    public OperatorGesture(IOperatorGestureImpl iOperatorGestureImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorGestureImpl);
    }

    private void $constructor(IOperatorGestureImpl iOperatorGestureImpl) {
        if (iOperatorGestureImpl != null) {
            this.mControl = iOperatorGestureImpl;
            this.mTargetId = String.format("OperatorGesture_%s_%d", String.valueOf(IOperatorGestureImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorGestureImpl getControl() {
        return this.mControl;
    }

    public void setTouchEnable(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setTouchEnable(z);
        }
    }

    public void addTouchEvent(TouchEvent touchEvent) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.addTouchEvent(touchEvent);
        }
    }

    public long addGesture(GestureInfo gestureInfo) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.addGesture(gestureInfo);
        }
        return 0L;
    }

    public void addMapGesture(int i, float f, float f2, float f3) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.addMapGesture(i, f, f2, f3);
        }
    }

    public void setGestureConfigure(GestureConfigure gestureConfigure) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setGestureConfigure(gestureConfigure);
        }
    }

    public GestureConfigure getGestureConfigure() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.getGestureConfigure();
        }
        return null;
    }

    public void enableSliding(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.enableSliding(z);
        }
    }

    public boolean isSlidingEnabled() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.isSlidingEnabled();
        }
        return false;
    }

    public void lockMapRollAngle(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.lockMapRollAngle(z);
        }
    }

    public boolean isMapRollAngleLocked() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.isMapRollAngleLocked();
        }
        return false;
    }

    public void lockMapPitchAngle(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.lockMapPitchAngle(z);
        }
    }

    public boolean isMapPitchAngleLocked() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.isMapPitchAngleLocked();
        }
        return false;
    }

    public void lockMapMove(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.lockMapMove(z);
        }
    }

    public boolean isMapMoveLocked() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.isMapMoveLocked();
        }
        return false;
    }

    public void lockMapPinchZoom(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.lockMapPinchZoom(z);
        }
    }

    public boolean isMapPinchZoomLocked() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.isMapPinchZoomLocked();
        }
        return false;
    }

    public void hidePoiOn3DMoving(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.hidePoiOn3DMoving(z);
        }
    }

    public boolean isPoiHiddenOn3DMoving() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.isPoiHiddenOn3DMoving();
        }
        return false;
    }

    public void hidePoiOn3DSliding(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.hidePoiOn3DSliding(z);
        }
    }

    public boolean isPoiHiddenOn3DSliding() {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            return iOperatorGestureImpl.isPoiHiddenOn3DSliding();
        }
        return false;
    }

    public void setAxisOfZoomInOnDoublePress(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setAxisOfZoomInOnDoublePress(z);
        }
    }

    public void setAxisOfTwoFingersPress(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setAxisOfTwoFingersPress(z);
        }
    }

    public void setAxisOfTwoFingersScaleRotate(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setAxisOfTwoFingersScaleRotate(z);
        }
    }

    public void setMapLabelClickable(boolean z) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setMapLabelClickable(z);
        }
    }

    public void setLongPressTimeOut(long j) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setLongPressTimeOut(j);
        }
    }

    public void setSinglePressTimeOut(long j) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setSinglePressTimeOut(j);
        }
    }

    public void setTimeOutOfTwoFingersPress(long j) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setTimeOutOfTwoFingersPress(j);
        }
    }

    public void setMaxValidOffsetOfTwoFingersPress(long j, long j2) {
        IOperatorGestureImpl iOperatorGestureImpl = this.mControl;
        if (iOperatorGestureImpl != null) {
            iOperatorGestureImpl.setMaxValidOffsetOfTwoFingersPress(j, j2);
        }
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
