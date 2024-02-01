package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizControlImpl;
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
@IntfAuto(target = IBizControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizControl {
    private static String PACKAGE = ReflexTool.PN(BizControl.class);
    private IBizControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizControl(long j, boolean z) {
        this(new IBizControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizControl.class, this, this.mControl);
        }
    }

    public BizControl(IBizControlImpl iBizControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizControlImpl);
    }

    private void $constructor(IBizControlImpl iBizControlImpl) {
        if (iBizControlImpl != null) {
            this.mControl = iBizControlImpl;
            this.mTargetId = String.format("BizControl_%s_%d", String.valueOf(IBizControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizControlImpl getControl() {
        return this.mControl;
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = BizControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
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
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl != null) {
                iBizControlImpl.setStyle(iPrepareLayerStyleImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = BizControl.class.getMethod("setStyle", Long.TYPE, IPrepareLayerStyle.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(Long.valueOf(j));
            IPrepareLayerStyleImpl iPrepareLayerStyleImpl = null;
            if (iPrepareLayerStyle != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerStyleImpl = (IPrepareLayerStyleImpl) typeHelper.transfer(method, 1, iPrepareLayerStyle);
            }
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl != null) {
                iBizControlImpl.setStyle(j, iPrepareLayerStyleImpl);
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
            Method method = BizControl.class.getMethod("getStyle", new Class[0]);
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl == null || (style = iBizControlImpl.getStyle()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IPrepareLayerStyle) typeHelper.transfer(method, -1, (Object) style, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setParam(PrepareLayerParam prepareLayerParam) {
        TypeHelper typeHelper;
        try {
            Method method = BizControl.class.getMethod("setParam", PrepareLayerParam.class);
            IPrepareLayerParamImpl iPrepareLayerParamImpl = null;
            if (prepareLayerParam != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerParamImpl = (IPrepareLayerParamImpl) typeHelper.transfer(method, 0, prepareLayerParam);
            }
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl != null) {
                iBizControlImpl.setParam(iPrepareLayerParamImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateStyle() {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.updateStyle();
        }
    }

    public void updateStyle(long j) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.updateStyle(j);
        }
    }

    public boolean matchBizControl(long j) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            return iBizControlImpl.matchBizControl(j);
        }
        return false;
    }

    public void clearAllItems(long j) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.clearAllItems(j);
        }
    }

    public void clearAllItems() {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.clearAllItems();
        }
    }

    public void setVisible(long j, boolean z) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.setVisible(j, z);
        }
    }

    public boolean getVisible(long j) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            return iBizControlImpl.getVisible(j);
        }
        return false;
    }

    public boolean getVisible() {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            return iBizControlImpl.getVisible();
        }
        return false;
    }

    public void setVisible(boolean z) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.setVisible(z);
        }
    }

    public void saveVisible() {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.saveVisible();
        }
    }

    public void restoreVisible() {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.restoreVisible();
        }
    }

    public void setClickable(long j, boolean z) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.setClickable(j, z);
        }
    }

    public boolean getClickable(long j) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            return iBizControlImpl.getClickable(j);
        }
        return false;
    }

    public void setFocus(long j, String str, boolean z) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.setFocus(j, str, z);
        }
    }

    public boolean getFocus(long j, String str) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            return iBizControlImpl.getFocus(j, str);
        }
        return false;
    }

    public void clearFocus(long j) {
        IBizControlImpl iBizControlImpl = this.mControl;
        if (iBizControlImpl != null) {
            iBizControlImpl.clearFocus(j);
        }
    }

    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BizControl.class.getMethod("addClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl != null) {
                iBizControlImpl.addClickObserver(iLayerClickObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BizControl.class.getMethod("removeClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl != null) {
                iBizControlImpl.removeClickObserver(iLayerClickObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = BizControl.class.getMethod("addFocusChangeObserver", ILayerFocusChangeObserver.class);
            ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl = null;
            if (iLayerFocusChangeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerFocusChangeObserverImpl = (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver);
            }
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl != null) {
                iBizControlImpl.addFocusChangeObserver(iLayerFocusChangeObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BizControl.class.getMethod("removeFocusChangeObserver", ILayerFocusChangeObserver.class);
            ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl = null;
            if (iLayerFocusChangeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerFocusChangeObserverImpl = (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver);
            }
            IBizControlImpl iBizControlImpl = this.mControl;
            if (iBizControlImpl != null) {
                iBizControlImpl.removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
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
