package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizCarControlImpl;
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
@IntfAuto(target = IBizCarControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizCarControl {
    private static String PACKAGE = ReflexTool.PN(BizCarControl.class);
    private IBizCarControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizCarControl(long j, boolean z) {
        this(new IBizCarControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizCarControl.class, this, this.mControl);
        }
    }

    public BizCarControl(IBizCarControlImpl iBizCarControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizCarControlImpl);
    }

    private void $constructor(IBizCarControlImpl iBizCarControlImpl) {
        if (iBizCarControlImpl != null) {
            this.mControl = iBizCarControlImpl;
            this.mTargetId = String.format("BizCarControl_%s_%d", String.valueOf(IBizCarControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizCarControlImpl getControl() {
        return this.mControl;
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = BizCarControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            IPrepareLayerStyleImpl iPrepareLayerStyleImpl = null;
            if (iPrepareLayerStyle != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerStyleImpl = (IPrepareLayerStyleImpl) typeHelper.transfer(method, 0, iPrepareLayerStyle);
            }
            IBizCarControlImpl iBizCarControlImpl = this.mControl;
            if (iBizCarControlImpl != null) {
                iBizCarControlImpl.setStyle(iPrepareLayerStyleImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IPrepareLayerStyle getStyle() {
        IPrepareLayerStyleImpl style;
        TypeHelper typeHelper;
        try {
            Method method = BizCarControl.class.getMethod("getStyle", new Class[0]);
            IBizCarControlImpl iBizCarControlImpl = this.mControl;
            if (iBizCarControlImpl == null || (style = iBizCarControlImpl.getStyle()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IPrepareLayerStyle) typeHelper.transfer(method, -1, (Object) style, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateStyle(@BizCarType.BizCarType1 int i) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.updateStyle(i);
        }
    }

    public void updateStyle() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.updateStyle();
        }
    }

    public boolean matchBizControl(long j) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.matchBizControl(j);
        }
        return false;
    }

    public void setCarMode(@CarMode.CarMode1 int i, boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setCarMode(i, z);
        }
    }

    @CarMode.CarMode1
    public int getCarMode() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.getCarMode();
        }
        return Integer.MIN_VALUE;
    }

    public void setSkeletonBaseScale(float f) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setSkeletonBaseScale(f);
        }
    }

    public void setSkeletonData(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setSkeletonData(bArr);
        }
    }

    public void setFollowMode(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setFollowMode(z);
        }
    }

    public boolean getFollowMode() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.getFollowMode();
        }
        return false;
    }

    public void setCarUpMode(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setCarUpMode(z);
        }
    }

    public boolean getCarUpMode() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.getCarUpMode();
        }
        return false;
    }

    public void setPreviewMode(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setPreviewMode(z);
        }
    }

    public boolean getPreviewMode() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.getPreviewMode();
        }
        return false;
    }

    public void setLockMapRollAngle(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setLockMapRollAngle(z);
        }
    }

    public boolean getLockMapRollAngle() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.getLockMapRollAngle();
        }
        return false;
    }

    public void setSkeletonCarStatus(@SkeletonCarStatus.SkeletonCarStatus1 int i) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setSkeletonCarStatus(i);
        }
    }

    public void setCarPosition(CarLoc carLoc) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setCarPosition(carLoc);
        }
    }

    public CarLoc getCarPosition() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.getCarPosition();
        }
        return null;
    }

    public void updateCarPosition(CarLoc carLoc) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.updateCarPosition(carLoc);
        }
    }

    public void setOcclusionCar(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setOcclusionCar(z);
        }
    }

    public void setRouteArrowPriority(LayerPriority layerPriority) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setRouteArrowPriority(layerPriority);
        }
    }

    public boolean setCarScaleByMapLevel(float[] fArr) {
        if (fArr != null && fArr.length == 0) {
            fArr = null;
        }
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.setCarScaleByMapLevel(fArr);
        }
        return false;
    }

    public void setMaxPitchAngle(float f) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setMaxPitchAngle(f);
        }
    }

    public void setVisible(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setVisible(z);
        }
    }

    public boolean getVisible() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            return iBizCarControlImpl.getVisible();
        }
        return false;
    }

    public void saveVisible() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.saveVisible();
        }
    }

    public void restoreVisible() {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.restoreVisible();
        }
    }

    public void setCarAnimationSwitch(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setCarAnimationSwitch(z);
        }
    }

    public void setClickable(boolean z) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setClickable(z);
        }
    }

    public void setModelScale(float f) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.setModelScale(f);
        }
    }

    public void updatePointLightParam(ArrayList<PointLightParam> arrayList) {
        IBizCarControlImpl iBizCarControlImpl = this.mControl;
        if (iBizCarControlImpl != null) {
            iBizCarControlImpl.updatePointLightParam(arrayList);
        }
    }

    public boolean addCarObserver(ICarObserver iCarObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BizCarControl.class.getMethod("addCarObserver", ICarObserver.class);
            ICarObserverImpl iCarObserverImpl = null;
            if (iCarObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iCarObserverImpl = (ICarObserverImpl) typeHelper.transfer(method, 0, iCarObserver);
            }
            IBizCarControlImpl iBizCarControlImpl = this.mControl;
            if (iBizCarControlImpl != null) {
                return iBizCarControlImpl.addCarObserver(iCarObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeCarObserver(ICarObserver iCarObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BizCarControl.class.getMethod("removeCarObserver", ICarObserver.class);
            ICarObserverImpl iCarObserverImpl = null;
            if (iCarObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iCarObserverImpl = (ICarObserverImpl) typeHelper.transfer(method, 0, iCarObserver);
            }
            IBizCarControlImpl iBizCarControlImpl = this.mControl;
            if (iBizCarControlImpl != null) {
                boolean removeCarObserver = iBizCarControlImpl.removeCarObserver(iCarObserverImpl);
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
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ICarObserver")).iterator();
            while (it.hasNext()) {
                removeCarObserver((ICarObserver) it.next());
            }
        }
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
