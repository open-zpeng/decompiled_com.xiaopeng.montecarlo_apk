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
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.OverlayGeometryType;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
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

    public BaseLayerRouter(String str, IBaseLayer iBaseLayer, String str2, IMapViewImpl iMapViewImpl) {
        super(str2, iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBaseLayer);
    }

    public BaseLayerRouter(String str, IBaseLayer iBaseLayer, String str2, IMapViewImpl iMapViewImpl, @OverlayGeometryType.OverlayGeometryType1 int i) {
        super(str2, iMapViewImpl, i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBaseLayer);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
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
        TypeHelper typeHelper;
        try {
            Method method = BaseLayerRouter.class.getMethod("getItem", String.class);
            IBaseLayer iBaseLayer = this.mObserver;
            if (iBaseLayer == null || (item = iBaseLayer.getItem(str)) == null || (typeHelper = this.mHelper) == null) {
                return null;
            }
            return (LayerItemImpl) typeHelper.transfer(method, -1, (Object) item, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public ArrayList<LayerItemImpl> getAllItems() {
        ArrayList<LayerItem> allItems;
        TypeHelper typeHelper;
        try {
            Method method = BaseLayerRouter.class.getMethod("getAllItems", new Class[0]);
            IBaseLayer iBaseLayer = this.mObserver;
            if (iBaseLayer == null || (allItems = iBaseLayer.getAllItems()) == null || (typeHelper = this.mHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) allItems, true);
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
    public boolean getFocus(String str) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getFocus(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.enableCollision(z);
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
    public void applyItemsOnVisible() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
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

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayerRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            IBaseLayer iBaseLayer = this.mObserver;
            if (iBaseLayer != null) {
                return iBaseLayer.testIntersect(iCollisionItem);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.isCollision();
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

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.setIntersectThreshold(i, f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.getIntersectThreshold(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setApplyItemsOnVisible(boolean z) {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            iBaseLayer.setApplyItemsOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean hasAppliedItemsOnVisible() {
        IBaseLayer iBaseLayer = this.mObserver;
        if (iBaseLayer != null) {
            return iBaseLayer.hasAppliedItemsOnVisible();
        }
        return false;
    }
}
