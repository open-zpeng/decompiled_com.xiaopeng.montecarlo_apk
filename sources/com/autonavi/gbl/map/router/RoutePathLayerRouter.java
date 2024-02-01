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
import com.autonavi.gbl.map.layer.RoutePathLayer;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.observer.IRoutePathLayer;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = RoutePathLayer.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RoutePathLayerRouter extends RoutePathLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(RoutePathLayerRouter.class);
    private static String PACKAGE = ReflexTool.PN(RoutePathLayerRouter.class);
    private TypeHelper mHelper;
    private IRoutePathLayer mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRoutePathLayer iRoutePathLayer) {
        if (iRoutePathLayer != null) {
            this.mObserver = iRoutePathLayer;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RoutePathLayer.class, iRoutePathLayer, this);
            }
        }
    }

    private void $constructor(String str, IRoutePathLayer iRoutePathLayer) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RoutePathLayerImpl.getCPtr((RoutePathLayerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRoutePathLayer);
    }

    public RoutePathLayerRouter(String str, IRoutePathLayer iRoutePathLayer, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRoutePathLayer);
    }

    public RoutePathLayerRouter(String str, IRoutePathLayer iRoutePathLayer, String str2, String str3, IMapViewImpl iMapViewImpl) {
        super(str2, str3, iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRoutePathLayer);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getVisible() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getClickable() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void getPriority(LayerPriority layerPriority) {
        $wrapper_getPriority(layerPriority);
    }

    private void $wrapper_getPriority(LayerPriority layerPriority) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            try {
                TypeUtil.deepcopy(iRoutePathLayer.getPriority(), layerPriority);
            } catch (Exception unused) {
                DebugTool.e("getPriority copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getDisplayScale(LayerScale layerScale) {
        $wrapper_getDisplayScale(layerScale);
    }

    private void $wrapper_getDisplayScale(LayerScale layerScale) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            try {
                TypeUtil.deepcopy(iRoutePathLayer.getDisplayScale(), layerScale);
            } catch (Exception unused) {
                DebugTool.e("getDisplayScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl
    public long getPathID() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl
    public void getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        $wrapper_getRouteDrawParam(routeLayerDrawParam);
    }

    private void $wrapper_getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            try {
                TypeUtil.deepcopy(iRoutePathLayer.getRouteDrawParam(), routeLayerDrawParam);
            } catch (Exception unused) {
                DebugTool.e("getRouteDrawParam copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl
    public boolean isPathIntersectRect(RectDouble rectDouble) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.isPathIntersectRect(rectDouble);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl
    public boolean getSelectStatus() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getSelectStatus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl
    public boolean getOddVisible() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getOddVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public String getName() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public long getLayerID() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getLayerID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public LayerItemImpl getItem(String str) {
        LayerItem item;
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayerRouter.class.getMethod("getItem", String.class);
            IRoutePathLayer iRoutePathLayer = this.mObserver;
            if (iRoutePathLayer == null || (item = iRoutePathLayer.getItem(str)) == null || (typeHelper = this.mHelper) == null) {
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
            Method method = RoutePathLayerRouter.class.getMethod("getAllItems", new Class[0]);
            IRoutePathLayer iRoutePathLayer = this.mObserver;
            if (iRoutePathLayer == null || (allItems = iRoutePathLayer.getAllItems()) == null || (typeHelper = this.mHelper) == null) {
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
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getFocus(String str) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getFocus(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void onPaint() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void applyItemsOnVisible() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void unLockItems() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public int getFilterPoiType() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getFilterPoiType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayerRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            IRoutePathLayer iRoutePathLayer = this.mObserver;
            if (iRoutePathLayer != null) {
                return iRoutePathLayer.testIntersect(iCollisionItem);
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
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.isCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectAreaThreshold(float f) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectAreaThreshold() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getIntersectAreaThreshold();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.setIntersectThreshold(i, f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.getIntersectThreshold(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setApplyItemsOnVisible(boolean z) {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            iRoutePathLayer.setApplyItemsOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean hasAppliedItemsOnVisible() {
        IRoutePathLayer iRoutePathLayer = this.mObserver;
        if (iRoutePathLayer != null) {
            return iRoutePathLayer.hasAppliedItemsOnVisible();
        }
        return false;
    }
}
