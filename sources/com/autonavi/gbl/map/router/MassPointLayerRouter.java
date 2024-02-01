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
import com.autonavi.gbl.map.layer.MassPointLayer;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.MassPointLayerImpl;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.observer.IMassPointLayer;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = MassPointLayer.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MassPointLayerRouter extends MassPointLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(MassPointLayerRouter.class);
    private static String PACKAGE = ReflexTool.PN(MassPointLayerRouter.class);
    private TypeHelper mHelper;
    private IMassPointLayer mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMassPointLayer iMassPointLayer) {
        if (iMassPointLayer != null) {
            this.mObserver = iMassPointLayer;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MassPointLayer.class, iMassPointLayer, this);
            }
        }
    }

    private void $constructor(String str, IMassPointLayer iMassPointLayer) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(MassPointLayerImpl.getCPtr((MassPointLayerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMassPointLayer);
    }

    public MassPointLayerRouter(String str, IMassPointLayer iMassPointLayer, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMassPointLayer);
    }

    public MassPointLayerRouter(String str, IMassPointLayer iMassPointLayer, String str2, IMapViewImpl iMapViewImpl) {
        super(str2, iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMassPointLayer);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.MassPointLayerImpl, com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public String getName() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public long getLayerID() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getLayerID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public LayerItemImpl getItem(String str) {
        LayerItem item;
        TypeHelper typeHelper;
        try {
            Method method = MassPointLayerRouter.class.getMethod("getItem", String.class);
            IMassPointLayer iMassPointLayer = this.mObserver;
            if (iMassPointLayer == null || (item = iMassPointLayer.getItem(str)) == null || (typeHelper = this.mHelper) == null) {
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
            Method method = MassPointLayerRouter.class.getMethod("getAllItems", new Class[0]);
            IMassPointLayer iMassPointLayer = this.mObserver;
            if (iMassPointLayer == null || (allItems = iMassPointLayer.getAllItems()) == null || (typeHelper = this.mHelper) == null) {
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
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getVisible() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getClickable() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getDisplayScale(LayerScale layerScale) {
        $wrapper_getDisplayScale(layerScale);
    }

    private void $wrapper_getDisplayScale(LayerScale layerScale) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            try {
                TypeUtil.deepcopy(iMassPointLayer.getDisplayScale(), layerScale);
            } catch (Exception unused) {
                DebugTool.e("getDisplayScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getFocus(String str) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getFocus(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void getPriority(LayerPriority layerPriority) {
        $wrapper_getPriority(layerPriority);
    }

    private void $wrapper_getPriority(LayerPriority layerPriority) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            try {
                TypeUtil.deepcopy(iMassPointLayer.getPriority(), layerPriority);
            } catch (Exception unused) {
                DebugTool.e("getPriority copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void onPaint() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void applyItemsOnVisible() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void unLockItems() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public int getFilterPoiType() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getFilterPoiType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = MassPointLayerRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            IMassPointLayer iMassPointLayer = this.mObserver;
            if (iMassPointLayer != null) {
                return iMassPointLayer.testIntersect(iCollisionItem);
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
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.isCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectAreaThreshold(float f) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectAreaThreshold() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getIntersectAreaThreshold();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.setIntersectThreshold(i, f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.getIntersectThreshold(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setApplyItemsOnVisible(boolean z) {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            iMassPointLayer.setApplyItemsOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean hasAppliedItemsOnVisible() {
        IMassPointLayer iMassPointLayer = this.mObserver;
        if (iMassPointLayer != null) {
            return iMassPointLayer.hasAppliedItemsOnVisible();
        }
        return false;
    }
}
