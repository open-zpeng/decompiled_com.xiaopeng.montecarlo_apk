package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ArrowAnimationPlayState;
import com.autonavi.gbl.map.layer.model.ArrowLayerItemStyle;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.observer.IArrowLayerItem;
import com.autonavi.gbl.map.layer.observer.ILayerItemAnimationObserver;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import com.autonavi.gbl.map.router.ArrowLayerItemRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = ArrowLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class ArrowLayerItem extends LayerItem implements IArrowLayerItem {
    private static String PACKAGE = ReflexTool.PN(ArrowLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private ArrowLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ArrowLayerItem(long j, boolean z) {
        this(new ArrowLayerItemRouter("ArrowLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IArrowLayerItem.class}, new Object[]{this});
    }

    public ArrowLayerItem() {
        this(new ArrowLayerItemRouter("ArrowLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IArrowLayerItem.class}, new Object[]{this});
    }

    public ArrowLayerItem(ArrowLayerItemImpl arrowLayerItemImpl) {
        super(arrowLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(arrowLayerItemImpl);
    }

    private void $constructor(ArrowLayerItemImpl arrowLayerItemImpl) {
        if (arrowLayerItemImpl != null) {
            this.mService = arrowLayerItemImpl;
            this.mTargetId = String.format("ArrowLayerItem_%s_%d", String.valueOf(ArrowLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public ArrowLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerItemAnimationObserver")).iterator();
            while (it.hasNext()) {
                removeGrownAnimationObserver((ILayerItemAnimationObserver) it.next());
            }
        }
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return ArrowLayerItemImpl.getClassTypeName();
    }

    public void setPoints(ArrayList<Coord3DDouble> arrayList) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            arrowLayerItemImpl.$explicit_setPoints(arrayList);
        }
    }

    public void setPoints3D(ArrayList<Coord3DDouble> arrayList) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            arrowLayerItemImpl.$explicit_setPoints3D(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            arrowLayerItemImpl.$explicit_updateStyle();
        }
    }

    public void setAnimationPlayState(@ArrowAnimationPlayState.ArrowAnimationPlayState1 int i) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            arrowLayerItemImpl.$explicit_setAnimationPlayState(i);
        }
    }

    public void setGrownAnimation(int i, int i2, long j) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            arrowLayerItemImpl.$explicit_setGrownAnimation(i, i2, j);
        }
    }

    public void setGrownAnimation(int i, int i2) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            arrowLayerItemImpl.$explicit_setGrownAnimation(i, i2);
        }
    }

    public boolean addGrownAnimationObserver(ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ArrowLayerItem.class.getMethod("addGrownAnimationObserver", ILayerItemAnimationObserver.class);
            ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl = null;
            if (iLayerItemAnimationObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerItemAnimationObserverImpl = (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver);
            }
            ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
            if (arrowLayerItemImpl != null) {
                return arrowLayerItemImpl.$explicit_addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGrownAnimationObserver(ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ArrowLayerItem.class.getMethod("removeGrownAnimationObserver", ILayerItemAnimationObserver.class);
            ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl = null;
            if (iLayerItemAnimationObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerItemAnimationObserverImpl = (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver);
            }
            ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
            if (arrowLayerItemImpl != null) {
                boolean $explicit_removeGrownAnimationObserver = arrowLayerItemImpl.$explicit_removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerItemAnimationObserver);
                }
                return $explicit_removeGrownAnimationObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean isIntersectCircle(double d, double d2, int i) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            return arrowLayerItemImpl.$explicit_isIntersectCircle(d, d2, i);
        }
        return false;
    }

    public boolean isIntersectRect(RectDouble rectDouble) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            return arrowLayerItemImpl.$explicit_isIntersectRect(rectDouble);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            return arrowLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    public ArrowLayerItemStyle getStyle() {
        ArrowLayerItemStyle arrowLayerItemStyle = new ArrowLayerItemStyle();
        getStyle(arrowLayerItemStyle);
        return arrowLayerItemStyle;
    }

    private void getStyle(ArrowLayerItemStyle arrowLayerItemStyle) {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            arrowLayerItemImpl.$explicit_getStyle(arrowLayerItemStyle);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    public int getAnimationPlayState() {
        ArrowLayerItemImpl arrowLayerItemImpl = this.mService;
        if (arrowLayerItemImpl != null) {
            return arrowLayerItemImpl.$explicit_getAnimationPlayState();
        }
        return Integer.MIN_VALUE;
    }
}
