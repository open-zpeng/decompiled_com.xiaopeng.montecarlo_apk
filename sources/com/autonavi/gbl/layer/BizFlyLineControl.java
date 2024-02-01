package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.BizClickLabelInfoImpl;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = BizFlyLineControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
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
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null) {
                iBizFlyLineControlImpl.setStyle(iPrepareLayerStyleImpl);
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
            Method method = BizFlyLineControl.class.getMethod("getStyle", new Class[0]);
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl == null || (style = iBizFlyLineControlImpl.getStyle()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IPrepareLayerStyle) typeHelper.transfer(method, -1, (Object) style, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateStyle() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.updateStyle();
        }
    }

    public boolean matchBizControl(long j) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.matchBizControl(j);
        }
        return false;
    }

    public BaseLayer getFlylineLayer(@BizFlyLineType.BizFlyLineType1 int i) {
        BaseLayerImpl flylineLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizFlyLineControl.class.getMethod("getFlylineLayer", Integer.TYPE);
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl == null || (flylineLayer = iBizFlyLineControlImpl.getFlylineLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) flylineLayer, true);
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

    public void setVisible(boolean z) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setVisible(z);
        }
    }

    public void setVisible(@BizFlyLineType.BizFlyLineType1 int i, boolean z) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setVisible(i, z);
        }
    }

    public boolean getVisible1() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getVisible1();
        }
        return false;
    }

    public boolean getVisible(@BizFlyLineType.BizFlyLineType1 int i) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getVisible(i);
        }
        return false;
    }

    public ArrayList getVisible() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getVisible();
        }
        return null;
    }

    public void saveVisible() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.saveVisible();
        }
    }

    public void restoreVisible() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.restoreVisible();
        }
    }

    public void updateDrawMode(@FlylineDrawMode.FlylineDrawMode1 int i, boolean z) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.updateDrawMode(i, z);
        }
    }

    public int getDrawMode() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getDrawMode();
        }
        return 0;
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

    public int getClickLabelType() {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            return iBizFlyLineControlImpl.getClickLabelType();
        }
        return 0;
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

    public void setClickLabelInfo(BizClickLabelInfo bizClickLabelInfo) {
        TypeHelper typeHelper;
        try {
            Method method = BizFlyLineControl.class.getMethod("setClickLabelInfo", BizClickLabelInfo.class);
            BizClickLabelInfoImpl bizClickLabelInfoImpl = null;
            if (bizClickLabelInfo != null && (typeHelper = this.mTypeHelper) != null) {
                bizClickLabelInfoImpl = (BizClickLabelInfoImpl) typeHelper.transfer(method, 0, bizClickLabelInfo);
            }
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null) {
                iBizFlyLineControlImpl.setClickLabelInfo(bizClickLabelInfoImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setTextScale(float f) {
        IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
        if (iBizFlyLineControlImpl != null) {
            iBizFlyLineControlImpl.setTextScale(f);
        }
    }

    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BizFlyLineControl.class.getMethod("addClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null) {
                iBizFlyLineControlImpl.addClickObserver(iLayerClickObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BizFlyLineControl.class.getMethod("removeClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            IBizFlyLineControlImpl iBizFlyLineControlImpl = this.mControl;
            if (iBizFlyLineControlImpl != null) {
                iBizFlyLineControlImpl.removeClickObserver(iLayerClickObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerClickObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
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
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerClickObserver")).iterator();
            while (it.hasNext()) {
                removeClickObserver((ILayerClickObserver) it.next());
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
