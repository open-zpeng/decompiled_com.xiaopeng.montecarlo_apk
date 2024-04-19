package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizControl;
import com.autonavi.gbl.layer.observer.PrepareLayerParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IBizControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizControl {
    private static String PACKAGE = ReflexTool.PN(BizControl.class);
    private IBizControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizControl(long j, boolean z) {
        this(new IBizControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizControl.class, this, this.mControl);
        }
    }

    public BizControl(IBizControl iBizControl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizControl);
    }

    private void $constructor(IBizControl iBizControl) {
        if (iBizControl != null) {
            this.mControl = iBizControl;
            this.mTargetId = String.format("BizControl_%s_%d", String.valueOf(IBizControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizControl getControl() {
        return this.mControl;
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        try {
            Method method = BizControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
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
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.1
                    }));
                }
            }
            IBizControl iBizControl = this.mControl;
            if (iBizControl != null) {
                iBizControl.setStyle(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setStyle(long j, IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        try {
            Method method = BizControl.class.getMethod("setStyle", Long.TYPE, IPrepareLayerStyle.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(Long.valueOf(j));
            if (iPrepareLayerStyle != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (IPrepareLayerStyleImpl) typeHelper2.transfer(method, 1, iPrepareLayerStyle) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.2
                    }));
                }
            }
            IBizControl iBizControl = this.mControl;
            if (iBizControl != null) {
                iBizControl.setStyle(j, r2);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setParam(PrepareLayerParam prepareLayerParam) {
        try {
            Method method = BizControl.class.getMethod("setParam", PrepareLayerParam.class);
            if (prepareLayerParam != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPrepareLayerParamImpl) typeHelper.transfer(method, 0, prepareLayerParam) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $customParam == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.3
                    }));
                }
            }
            IBizControl iBizControl = this.mControl;
            if (iBizControl != null) {
                iBizControl.setParam(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateStyle() {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.updateStyle();
        }
    }

    public void updateStyle(long j) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.updateStyle(j);
        }
    }

    public boolean matchBizControl(long j) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            return iBizControl.matchBizControl(j);
        }
        return false;
    }

    public void clearAllItems(long j) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.clearAllItems(j);
        }
    }

    public void clearAllItems() {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.clearAllItems();
        }
    }

    public void setVisible(long j, boolean z) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.setVisible(j, z);
        }
    }

    public boolean getVisible(long j) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            return iBizControl.getVisible(j);
        }
        return false;
    }

    public boolean getVisible() {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            return iBizControl.getVisible();
        }
        return false;
    }

    public void setVisible(boolean z) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.setVisible(z);
        }
    }

    public void saveVisible() {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.saveVisible();
        }
    }

    public void restoreVisible() {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.restoreVisible();
        }
    }

    public void setClickable(long j, boolean z) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.setClickable(j, z);
        }
    }

    public boolean getClickable(long j) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            return iBizControl.getClickable(j);
        }
        return false;
    }

    public void setFocus(long j, String str, boolean z) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.setFocus(j, str, z);
        }
    }

    public boolean getFocus(long j, String str) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            return iBizControl.getFocus(j, str);
        }
        return false;
    }

    public void clearFocus(long j) {
        IBizControl iBizControl = this.mControl;
        if (iBizControl != null) {
            iBizControl.clearFocus(j);
        }
    }

    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        try {
            Method method = BizControl.class.getMethod("addClickObserver", ILayerClickObserver.class);
            if (iLayerClickObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.4
                    }));
                }
            }
            IBizControl iBizControl = this.mControl;
            if (iBizControl != null) {
                iBizControl.addClickObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        try {
            Method method = BizControl.class.getMethod("removeClickObserver", ILayerClickObserver.class);
            if (iLayerClickObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.5
                    }));
                }
            }
            IBizControl iBizControl = this.mControl;
            if (iBizControl != null) {
                iBizControl.removeClickObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerClickObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        try {
            Method method = BizControl.class.getMethod("addFocusChangeObserver", ILayerFocusChangeObserver.class);
            if (iLayerFocusChangeObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.6
                    }));
                }
            }
            IBizControl iBizControl = this.mControl;
            if (iBizControl != null) {
                iBizControl.addFocusChangeObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        try {
            Method method = BizControl.class.getMethod("removeFocusChangeObserver", ILayerFocusChangeObserver.class);
            if (iLayerFocusChangeObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.7
                    }));
                }
            }
            IBizControl iBizControl = this.mControl;
            if (iBizControl != null) {
                iBizControl.removeFocusChangeObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerFocusChangeObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.8
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.9
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerClickObserver")).iterator();
            while (it.hasNext()) {
                removeClickObserver((ILayerClickObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver")).iterator();
            while (it2.hasNext()) {
                removeFocusChangeObserver((ILayerFocusChangeObserver) it2.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControl.10
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
