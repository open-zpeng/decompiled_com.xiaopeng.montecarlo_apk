package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizFlyLineControlImpl;
import com.autonavi.gbl.layer.model.BizClickLabelType;
import com.autonavi.gbl.layer.model.BizFlyLineType;
import com.autonavi.gbl.layer.model.FlylineDrawMode;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
@IntfAuto(target = IBizFlyLineControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizFlyLineControl {
    private static String PACKAGE = ReflexTool.PN(BizFlyLineControl.class);
    private IBizFlyLineControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizFlyLineControl(long j, boolean z) {
        this(new IBizFlyLineControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizFlyLineControl.class, this, this.mControl);
        }
    }

    public BizFlyLineControl(IBizFlyLineControlImpl iBizFlyLineControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizFlyLineControlImpl);
    }

    private void $constructor(IBizFlyLineControlImpl iBizFlyLineControlImpl) {
        if (iBizFlyLineControlImpl != null) {
            this.mControl = iBizFlyLineControlImpl;
            this.mTargetId = String.format("BizFlyLineControl_%s_%d", String.valueOf(IBizFlyLineControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizFlyLineControlImpl getControl() {
        return this.mControl;
    }

    @FlylineDrawMode.FlylineDrawMode1
    public int getDrawMode() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getDrawMode();
        }
        return Integer.MIN_VALUE;
    }

    @BizClickLabelType.BizClickLabelType1
    public int getClickLabelType() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getClickLabelType();
        }
        return Integer.MIN_VALUE;
    }

    public boolean[] getVisible() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getVisible();
        }
        return null;
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        try {
            Method method = BizFlyLineControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
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
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizFlyLineControl.1
                    }));
                }
            }
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null) {
                iBizFlyLineControlImpl.setStyle(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateStyle() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.updateStyle();
        }
    }

    public BaseLayer getFlylineLayer(@BizFlyLineType.BizFlyLineType1 int i) {
        BaseLayerImpl flylineLayer;
        try {
            Method method = BizFlyLineControl.class.getMethod("getFlylineLayer", Integer.TYPE);
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null && (flylineLayer = iBizFlyLineControlImpl.getFlylineLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) flylineLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizFlyLineControl.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setVisible(boolean z, boolean z2) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setVisible(z, z2);
        }
    }

    public void updateDrawMode(@FlylineDrawMode.FlylineDrawMode1 int i, boolean z) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.updateDrawMode(i, z);
        }
    }

    public void setClickLabelMoveMap(boolean z) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setClickLabelMoveMap(z);
        }
    }

    public boolean getClickLabelMoveMap() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getClickLabelMoveMap();
        }
        return false;
    }

    public void setClickLabelType(@BizClickLabelType.BizClickLabelType1 int i) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setClickLabelType(i);
        }
    }

    public void hideOnce() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.hideOnce();
        }
    }

    public void setClickable(boolean z) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setClickable(z);
        }
    }

    public boolean getClickable() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getClickable();
        }
        return false;
    }

    public void setBusinessType(int i) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setBusinessType(i);
        }
    }

    public int getBusinessType() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getBusinessType();
        }
        return 0;
    }

    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        try {
            Method method = BizFlyLineControl.class.getMethod("addClickObserver", ILayerClickObserver.class);
            if (iLayerClickObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizFlyLineControl.3
                    }));
                }
            }
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null) {
                iBizFlyLineControlImpl.addClickObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        try {
            Method method = BizFlyLineControl.class.getMethod("removeClickObserver", ILayerClickObserver.class);
            if (iLayerClickObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizFlyLineControl.4
                    }));
                }
            }
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null) {
                iBizFlyLineControlImpl.removeClickObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizFlyLineControl.5
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizFlyLineControl.6
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizFlyLineControl.7
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
