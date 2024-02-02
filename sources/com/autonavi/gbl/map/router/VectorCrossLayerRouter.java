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
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.VectorCrossLayer;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.VectorCrossLayerImpl;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IVectorCrossLayer;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = VectorCrossLayer.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class VectorCrossLayerRouter extends VectorCrossLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(VectorCrossLayerRouter.class);
    private static String PACKAGE = ReflexTool.PN(VectorCrossLayerRouter.class);
    private TypeHelper mHelper;
    private IVectorCrossLayer mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IVectorCrossLayer iVectorCrossLayer) {
        if (iVectorCrossLayer != null) {
            this.mObserver = iVectorCrossLayer;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(VectorCrossLayer.class, iVectorCrossLayer, this);
            }
        }
    }

    private void $constructor(String str, IVectorCrossLayer iVectorCrossLayer) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(VectorCrossLayerImpl.getCPtr((VectorCrossLayerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iVectorCrossLayer);
    }

    public VectorCrossLayerRouter(String str, IVectorCrossLayer iVectorCrossLayer, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iVectorCrossLayer);
    }

    public VectorCrossLayerRouter(String str, IVectorCrossLayer iVectorCrossLayer, String str2, MapViewImpl mapViewImpl) {
        super(str2, mapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iVectorCrossLayer);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.VectorCrossLayerRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.VectorCrossLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.VectorCrossLayerRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public String getName() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public long getLayerID() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getLayerID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public LayerItemImpl getItem(String str) {
        LayerItem item;
        try {
            Method method = VectorCrossLayerRouter.class.getMethod("getItem", String.class);
            IVectorCrossLayer iVectorCrossLayer = this.mObserver;
            if (iVectorCrossLayer != null && (item = iVectorCrossLayer.getItem(str)) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (LayerItemImpl) typeHelper.transfer(method, -1, (Object) item, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.VectorCrossLayerRouter.3
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
            Method method = VectorCrossLayerRouter.class.getMethod("getAllItems", new Class[0]);
            IVectorCrossLayer iVectorCrossLayer = this.mObserver;
            if (iVectorCrossLayer != null && (allItems = iVectorCrossLayer.getAllItems()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) allItems, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.VectorCrossLayerRouter.4
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
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getVisible() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getClickable() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getDisplayScale(LayerScale layerScale) {
        $wrapper_getDisplayScale(layerScale);
    }

    private void $wrapper_getDisplayScale(LayerScale layerScale) {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            try {
                TypeUtil.deepcopy(iVectorCrossLayer.getDisplayScale(), layerScale);
            } catch (Exception unused) {
                DebugTool.e("getDisplayScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getPriority(LayerPriority layerPriority) {
        $wrapper_getPriority(layerPriority);
    }

    private void $wrapper_getPriority(LayerPriority layerPriority) {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            try {
                TypeUtil.deepcopy(iVectorCrossLayer.getPriority(), layerPriority);
            } catch (Exception unused) {
                DebugTool.e("getPriority copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void onPaint() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<RectDouble> arrayList) {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void unLockItems() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public int getFilterPoiType() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getFilterPoiType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void resetNextPair() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        try {
            Method method = VectorCrossLayerRouter.class.getMethod("testIntersect", ICollisionItemImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.VectorCrossLayerRouter.5
                    }));
                }
            }
            IVectorCrossLayer iVectorCrossLayer = this.mObserver;
            if (iVectorCrossLayer != null) {
                return iVectorCrossLayer.testIntersect(r2);
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
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void caculateCollision() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean isAreaCollision() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectAreaThreshold(float f) {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            iVectorCrossLayer.setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectAreaThreshold() {
        IVectorCrossLayer iVectorCrossLayer = this.mObserver;
        if (iVectorCrossLayer != null) {
            return iVectorCrossLayer.getIntersectAreaThreshold();
        }
        return 0.0f;
    }
}
