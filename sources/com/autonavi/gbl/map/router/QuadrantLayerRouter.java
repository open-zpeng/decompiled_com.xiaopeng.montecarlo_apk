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
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.QuadrantLayer;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerImpl;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayer;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = QuadrantLayer.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class QuadrantLayerRouter extends QuadrantLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(QuadrantLayerRouter.class);
    private static String PACKAGE = ReflexTool.PN(QuadrantLayerRouter.class);
    private TypeHelper mHelper;
    private IQuadrantLayer mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IQuadrantLayer iQuadrantLayer) {
        if (iQuadrantLayer != null) {
            this.mObserver = iQuadrantLayer;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(QuadrantLayer.class, iQuadrantLayer, this);
            }
        }
    }

    private void $constructor(String str, IQuadrantLayer iQuadrantLayer) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(QuadrantLayerImpl.getCPtr((QuadrantLayerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iQuadrantLayer);
    }

    public QuadrantLayerRouter(String str, IQuadrantLayer iQuadrantLayer, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iQuadrantLayer);
    }

    public QuadrantLayerRouter(String str, IQuadrantLayer iQuadrantLayer, String str2, IMapViewImpl iMapViewImpl) {
        super(str2, iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iQuadrantLayer);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public String getName() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public long getLayerID() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getLayerID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public LayerItemImpl getItem(String str) {
        LayerItem item;
        TypeHelper typeHelper;
        try {
            Method method = QuadrantLayerRouter.class.getMethod("getItem", String.class);
            IQuadrantLayer iQuadrantLayer = this.mObserver;
            if (iQuadrantLayer == null || (item = iQuadrantLayer.getItem(str)) == null || (typeHelper = this.mHelper) == null) {
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
            Method method = QuadrantLayerRouter.class.getMethod("getAllItems", new Class[0]);
            IQuadrantLayer iQuadrantLayer = this.mObserver;
            if (iQuadrantLayer == null || (allItems = iQuadrantLayer.getAllItems()) == null || (typeHelper = this.mHelper) == null) {
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
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getVisible() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getClickable() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getDisplayScale(LayerScale layerScale) {
        $wrapper_getDisplayScale(layerScale);
    }

    private void $wrapper_getDisplayScale(LayerScale layerScale) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayer.getDisplayScale(), layerScale);
            } catch (Exception unused) {
                DebugTool.e("getDisplayScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getFocus(String str) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getFocus(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void getPriority(LayerPriority layerPriority) {
        $wrapper_getPriority(layerPriority);
    }

    private void $wrapper_getPriority(LayerPriority layerPriority) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayer.getPriority(), layerPriority);
            } catch (Exception unused) {
                DebugTool.e("getPriority copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void onPaint() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void applyItemsOnVisible() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void unLockItems() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public int getFilterPoiType() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getFilterPoiType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = QuadrantLayerRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            IQuadrantLayer iQuadrantLayer = this.mObserver;
            if (iQuadrantLayer != null) {
                return iQuadrantLayer.testIntersect(iCollisionItem);
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
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.isCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectAreaThreshold(float f) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectAreaThreshold() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getIntersectAreaThreshold();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.setIntersectThreshold(i, f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.getIntersectThreshold(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setApplyItemsOnVisible(boolean z) {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            iQuadrantLayer.setApplyItemsOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean hasAppliedItemsOnVisible() {
        IQuadrantLayer iQuadrantLayer = this.mObserver;
        if (iQuadrantLayer != null) {
            return iQuadrantLayer.hasAppliedItemsOnVisible();
        }
        return false;
    }
}
