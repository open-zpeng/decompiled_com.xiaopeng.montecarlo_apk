package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.CollisionGroupImpl;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionGroup;
import com.autonavi.gbl.map.observer.ICollisionItem;
import com.autonavi.gbl.map.router.CollisionGroupRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = CollisionGroupRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class CollisionGroup implements ICollisionGroup {
    private static String PACKAGE = ReflexTool.PN(CollisionGroup.class);
    private boolean mHasDestroy;
    private CollisionGroupImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CollisionGroup(long j, boolean z) {
        this(new CollisionGroupRouter("CollisionGroup", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICollisionGroup.class}, new Object[]{this});
    }

    public CollisionGroup() {
        this(new CollisionGroupRouter("CollisionGroup", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICollisionGroup.class}, new Object[]{this});
    }

    public CollisionGroup(CollisionGroupImpl collisionGroupImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(collisionGroupImpl);
    }

    private void $constructor(CollisionGroupImpl collisionGroupImpl) {
        if (collisionGroupImpl != null) {
            this.mService = collisionGroupImpl;
            this.mTargetId = String.format("CollisionGroup_%s_%d", String.valueOf(CollisionGroupImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected CollisionGroupImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.ICollisionItem")).iterator();
            while (it.hasNext()) {
                removeCollisionItem((ICollisionItem) it.next());
            }
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }

    public boolean addCollisionItem(ICollisionItem iCollisionItem) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionGroup.class.getMethod("addCollisionItem", ICollisionItem.class);
            CollisionItemImpl collisionItemImpl = null;
            if (iCollisionItem != null && (typeHelper = this.mTypeHelper) != null) {
                collisionItemImpl = (CollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem);
            }
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl != null) {
                return collisionGroupImpl.$explicit_addCollisionItem(collisionItemImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeCollisionItem(ICollisionItem iCollisionItem) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionGroup.class.getMethod("removeCollisionItem", ICollisionItem.class);
            CollisionItemImpl collisionItemImpl = null;
            if (iCollisionItem != null && (typeHelper = this.mTypeHelper) != null) {
                collisionItemImpl = (CollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem);
            }
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl != null) {
                boolean $explicit_removeCollisionItem = collisionGroupImpl.$explicit_removeCollisionItem(collisionItemImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iCollisionItem);
                }
                return $explicit_removeCollisionItem;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void clearAllCollisionItems() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_clearAllCollisionItems();
        }
    }

    public ArrayList<ICollisionItem> getCollisionItems() {
        ArrayList<CollisionItemImpl> $explicit_getCollisionItems;
        TypeHelper typeHelper;
        try {
            Method method = CollisionGroup.class.getMethod("getCollisionItems", new Class[0]);
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl == null || ($explicit_getCollisionItems = collisionGroupImpl.$explicit_getCollisionItems()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) $explicit_getCollisionItems, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void resetNextPair() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public boolean testIntersect(ICollisionItem iCollisionItem) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionGroup.class.getMethod("testIntersect", ICollisionItem.class);
            CollisionItemImpl collisionItemImpl = null;
            if (iCollisionItem != null && (typeHelper = this.mTypeHelper) != null) {
                collisionItemImpl = (CollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem);
            }
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl != null) {
                return collisionGroupImpl.$explicit_testIntersect(collisionItemImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    @CollisionType.CollisionType1
    public int getType() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            return collisionGroupImpl.$explicit_getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void lockItems() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void unLockItems() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void caculateCollision() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void enableAreaCollision(boolean z) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public boolean isAreaCollision() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            return collisionGroupImpl.$explicit_isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void enableCollision(boolean z) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public boolean isCollision() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            return collisionGroupImpl.$explicit_isCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public void setIntersectAreaThreshold(float f) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public float getIntersectAreaThreshold() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            return collisionGroupImpl.$explicit_getIntersectAreaThreshold();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_setIntersectThreshold(i, f);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            return collisionGroupImpl.$explicit_getIntersectThreshold(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public void updateQuadrantItems() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public LayerPriority getPriority() {
        LayerPriority layerPriority = new LayerPriority();
        getPriority(layerPriority);
        return layerPriority;
    }

    private void getPriority(LayerPriority layerPriority) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_getPriority(layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public void applyItemsOnVisible() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public void setApplyItemsOnVisible(boolean z) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_setApplyItemsOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public boolean hasAppliedItemsOnVisible() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            return collisionGroupImpl.$explicit_hasAppliedItemsOnVisible();
        }
        return false;
    }
}
