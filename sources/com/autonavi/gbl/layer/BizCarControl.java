package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizCarControl;
import com.autonavi.gbl.layer.model.BizCarType;
import com.autonavi.gbl.layer.model.SkeletonCarStatus;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.CarMode;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.observer.ICarObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.ICarObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.PointLightParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IBizCarControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizCarControl {
    private static String PACKAGE = ReflexTool.PN(BizCarControl.class);
    private IBizCarControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizCarControl(long j, boolean z) {
        this(new IBizCarControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizCarControl.class, this, this.mControl);
        }
    }

    public BizCarControl(IBizCarControl iBizCarControl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizCarControl);
    }

    private void $constructor(IBizCarControl iBizCarControl) {
        if (iBizCarControl != null) {
            this.mControl = iBizCarControl;
            this.mTargetId = String.format("BizCarControl_%s_%d", String.valueOf(IBizCarControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizCarControl getControl() {
        return this.mControl;
    }

    public CarLoc getCarPosition() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.getCarPosition();
        }
        return null;
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        try {
            Method method = BizCarControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            if (iPrepareLayerStyle != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (IPrepareLayerStyleImpl) typeHelper2.transfer(method, 0, iPrepareLayerStyle) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCarControl.1
                    }));
                }
            }
            IBizCarControl iBizCarControl = this.mControl;
            if (iBizCarControl != null) {
                iBizCarControl.setStyle(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateStyle(@BizCarType.BizCarType1 int i) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.updateStyle(i);
        }
    }

    public void updateStyle() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.updateStyle();
        }
    }

    public boolean matchBizControl(long j) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.matchBizControl(j);
        }
        return false;
    }

    public void setCarMode(@CarMode.CarMode1 int i, boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setCarMode(i, z);
        }
    }

    @CarMode.CarMode1
    public int getCarMode() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.getCarMode();
        }
        return Integer.MIN_VALUE;
    }

    public void setSkeletonBaseScale(float f) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setSkeletonBaseScale(f);
        }
    }

    public void setSkeletonData(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setSkeletonData(bArr);
        }
    }

    public void setFollowMode(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setFollowMode(z);
        }
    }

    public boolean getFollowMode() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.getFollowMode();
        }
        return false;
    }

    public void setCarUpMode(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setCarUpMode(z);
        }
    }

    public boolean getCarUpMode() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.getCarUpMode();
        }
        return false;
    }

    public void setPreviewMode(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setPreviewMode(z);
        }
    }

    public boolean getPreviewMode() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.getPreviewMode();
        }
        return false;
    }

    public void setLockMapRollAngle(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setLockMapRollAngle(z);
        }
    }

    public boolean getLockMapRollAngle() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.getLockMapRollAngle();
        }
        return false;
    }

    public void setSkeletonCarStatus(@SkeletonCarStatus.SkeletonCarStatus1 int i) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setSkeletonCarStatus(i);
        }
    }

    public void setCarPosition(CarLoc carLoc) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setCarPosition(carLoc);
        }
    }

    public void updateCarPosition(CarLoc carLoc) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.updateCarPosition(carLoc);
        }
    }

    public void setOcclusionCar(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setOcclusionCar(z);
        }
    }

    public void setRouteArrowPriority(LayerPriority layerPriority) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setRouteArrowPriority(layerPriority);
        }
    }

    public boolean setCarScaleByMapLevel(float[] fArr) {
        if (fArr != null && fArr.length == 0) {
            fArr = null;
        }
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.setCarScaleByMapLevel(fArr);
        }
        return false;
    }

    public void setMaxPitchAngle(float f) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setMaxPitchAngle(f);
        }
    }

    public void setVisible(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setVisible(z);
        }
    }

    public boolean getVisible() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            return iBizCarControl.getVisible();
        }
        return false;
    }

    public void saveVisible() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.saveVisible();
        }
    }

    public void restoreVisible() {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.restoreVisible();
        }
    }

    public void setCarAnimationSwitch(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setCarAnimationSwitch(z);
        }
    }

    public void setClickable(boolean z) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setClickable(z);
        }
    }

    public void setModelScale(float f) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.setModelScale(f);
        }
    }

    public void updatePointLightParam(ArrayList<PointLightParam> arrayList) {
        IBizCarControl iBizCarControl = this.mControl;
        if (iBizCarControl != null) {
            iBizCarControl.updatePointLightParam(arrayList);
        }
    }

    public boolean addCarObserver(ICarObserver iCarObserver) {
        try {
            Method method = BizCarControl.class.getMethod("addCarObserver", ICarObserver.class);
            if (iCarObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICarObserverImpl) typeHelper.transfer(method, 0, iCarObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCarControl.2
                    }));
                    return false;
                }
            }
            IBizCarControl iBizCarControl = this.mControl;
            if (iBizCarControl != null) {
                return iBizCarControl.addCarObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeCarObserver(ICarObserver iCarObserver) {
        try {
            Method method = BizCarControl.class.getMethod("removeCarObserver", ICarObserver.class);
            if (iCarObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICarObserverImpl) typeHelper.transfer(method, 0, iCarObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCarControl.3
                    }));
                    return false;
                }
            }
            IBizCarControl iBizCarControl = this.mControl;
            if (iBizCarControl != null) {
                boolean removeCarObserver = iBizCarControl.removeCarObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iCarObserver);
                }
                return removeCarObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCarControl.4
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCarControl.5
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ICarObserver")).iterator();
            while (it.hasNext()) {
                removeCarObserver((ICarObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizCarControl.6
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
