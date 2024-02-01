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
import com.autonavi.gbl.map.layer.MassDataLayer;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.MassDataLayerImpl;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.observer.IMassDataLayer;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = MassDataLayer.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MassDataLayerRouter extends MassDataLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(MassDataLayerRouter.class);
    private static String PACKAGE = ReflexTool.PN(MassDataLayerRouter.class);
    private TypeHelper mHelper;
    private IMassDataLayer mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMassDataLayer iMassDataLayer) {
        if (iMassDataLayer != null) {
            this.mObserver = iMassDataLayer;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MassDataLayer.class, iMassDataLayer, this);
            }
        }
    }

    private void $constructor(String str, IMassDataLayer iMassDataLayer) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(MassDataLayerImpl.getCPtr((MassDataLayerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMassDataLayer);
    }

    public MassDataLayerRouter(String str, IMassDataLayer iMassDataLayer, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMassDataLayer);
    }

    public MassDataLayerRouter(String str, IMassDataLayer iMassDataLayer, String str2, IMapViewImpl iMapViewImpl) {
        super(str2, iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMassDataLayer);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl
    public long getPointDataCount() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getPointDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl
    public long getPolylineDataCount() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getPolylineDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl
    public long getPolygonDataCount() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getPolygonDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl
    public long getCircleDataCount() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getCircleDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MassDataLayerImpl
    public long getAllDataCount() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getAllDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public String getName() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public long getLayerID() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getLayerID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public LayerItemImpl getItem(String str) {
        LayerItem item;
        TypeHelper typeHelper;
        try {
            Method method = MassDataLayerRouter.class.getMethod("getItem", String.class);
            IMassDataLayer iMassDataLayer = this.mObserver;
            if (iMassDataLayer == null || (item = iMassDataLayer.getItem(str)) == null || (typeHelper = this.mHelper) == null) {
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
            Method method = MassDataLayerRouter.class.getMethod("getAllItems", new Class[0]);
            IMassDataLayer iMassDataLayer = this.mObserver;
            if (iMassDataLayer == null || (allItems = iMassDataLayer.getAllItems()) == null || (typeHelper = this.mHelper) == null) {
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
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getVisible() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getClickable() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getDisplayScale(LayerScale layerScale) {
        $wrapper_getDisplayScale(layerScale);
    }

    private void $wrapper_getDisplayScale(LayerScale layerScale) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            try {
                TypeUtil.deepcopy(iMassDataLayer.getDisplayScale(), layerScale);
            } catch (Exception unused) {
                DebugTool.e("getDisplayScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getFocus(String str) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getFocus(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void getPriority(LayerPriority layerPriority) {
        $wrapper_getPriority(layerPriority);
    }

    private void $wrapper_getPriority(LayerPriority layerPriority) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            try {
                TypeUtil.deepcopy(iMassDataLayer.getPriority(), layerPriority);
            } catch (Exception unused) {
                DebugTool.e("getPriority copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void onPaint() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void applyItemsOnVisible() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void unLockItems() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public int getFilterPoiType() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getFilterPoiType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = MassDataLayerRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            IMassDataLayer iMassDataLayer = this.mObserver;
            if (iMassDataLayer != null) {
                return iMassDataLayer.testIntersect(iCollisionItem);
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
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.isCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectAreaThreshold(float f) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectAreaThreshold() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getIntersectAreaThreshold();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.setIntersectThreshold(i, f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.getIntersectThreshold(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setApplyItemsOnVisible(boolean z) {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            iMassDataLayer.setApplyItemsOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean hasAppliedItemsOnVisible() {
        IMassDataLayer iMassDataLayer = this.mObserver;
        if (iMassDataLayer != null) {
            return iMassDataLayer.hasAppliedItemsOnVisible();
        }
        return false;
    }
}
