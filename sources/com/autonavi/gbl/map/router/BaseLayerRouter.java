package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IBaseLayer;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = BaseLayer.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BaseLayerRouter extends BaseLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(BaseLayerRouter.class);
    private static String PACKAGE = ReflexTool.PN(BaseLayerRouter.class);
    private TypeHelper mHelper;
    private IBaseLayer mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IBaseLayer iBaseLayer) {
        if (iBaseLayer != null) {
            this.mObserver = iBaseLayer;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(BaseLayer.class, iBaseLayer, this);
            }
        }
    }

    private void $constructor(String str, IBaseLayer iBaseLayer) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(BaseLayerImpl.getCPtr((BaseLayerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iBaseLayer);
    }

    public BaseLayerRouter(String str, IBaseLayer iBaseLayer, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBaseLayer);
    }

    public BaseLayerRouter(String str, IBaseLayer iBaseLayer, String str2, MapViewImpl mapViewImpl) {
        super(str2, mapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBaseLayer);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BaseLayerRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BaseLayerRouter.2
        }));
        ((BaseLayer) this.mObserver).delete();
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public String getName() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public long getLayerID() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getLayerID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public LayerItemImpl getItem(String str) {
        LayerItem item;
        try {
            Method method = BaseLayerRouter.class.getMethod("getItem", String.class);
            IBaseLayer iBaseLayer = this.mObserver;
            if (iBaseLayer != null && (item = iBaseLayer.getItem(str)) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (LayerItemImpl) typeHelper.transfer(method, -1, (Object) item, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BaseLayerRouter.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public ArrayList<LayerItemImpl> getAllItems() {
        ArrayList<LayerItem> allItems;
        try {
            Method method = BaseLayerRouter.class.getMethod("getAllItems", new Class[0]);
            IBaseLayer iBaseLayer = this.mObserver;
            if (iBaseLayer != null && (allItems = iBaseLayer.getAllItems()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) allItems, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BaseLayerRouter.4
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public int getCount() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getVisible() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getClickable() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getDisplayScale(LayerScale layerScale) {
        $wrapper_getDisplayScale(layerScale);
    }

    private void $wrapper_getDisplayScale(LayerScale layerScale) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            try {
                TypeUtil.deepcopy(iBaseLayer.getDisplayScale(), layerScale);
            } catch (Exception unused) {
                DebugTool.e("getDisplayScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getPriority(LayerPriority layerPriority) {
        $wrapper_getPriority(layerPriority);
    }

    private void $wrapper_getPriority(LayerPriority layerPriority) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            try {
                TypeUtil.deepcopy(iBaseLayer.getPriority(), layerPriority);
            } catch (Exception unused) {
                DebugTool.e("getPriority copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void onPaint() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<RectDouble> arrayList) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void unLockItems() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public int getFilterPoiType() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getFilterPoiType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void resetNextPair() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        try {
            Method method = BaseLayerRouter.class.getMethod("testIntersect", ICollisionItemImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BaseLayerRouter.5
                    }));
                }
            }
            IBaseLayer iBaseLayer = this.mObserver;
            if (iBaseLayer != null) {
                return iBaseLayer.testIntersect(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void caculateCollision() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean isAreaCollision() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectAreaThreshold(float f) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectAreaThreshold() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getIntersectAreaThreshold();
        }
        return 0.0f;
    }
}
