package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.impl.CollisionGroupImpl;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.layer.model.LayerPriority;
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

    public CollisionGroupImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionGroup.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionGroup.2
        }));
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionGroup.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
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
        try {
            Method method = CollisionGroup.class.getMethod("addCollisionItem", ICollisionItem.class);
            if (iCollisionItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionGroup.4
                    }));
                }
            }
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl != null) {
                return collisionGroupImpl.$explicit_addCollisionItem(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeCollisionItem(ICollisionItem iCollisionItem) {
        try {
            Method method = CollisionGroup.class.getMethod("removeCollisionItem", ICollisionItem.class);
            if (iCollisionItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionGroup.5
                    }));
                }
            }
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl != null) {
                boolean $explicit_removeCollisionItem = collisionGroupImpl.$explicit_removeCollisionItem(r2);
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
        ArrayList<ICollisionItemImpl> $explicit_getCollisionItems;
        try {
            Method method = CollisionGroup.class.getMethod("getCollisionItems", new Class[0]);
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl != null && ($explicit_getCollisionItems = collisionGroupImpl.$explicit_getCollisionItems()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) $explicit_getCollisionItems, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionGroup.6
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public LayerPriority getPriority() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            return collisionGroupImpl.$explicit_getPriority();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void resetNextPair() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup
    public void intersectUI(ArrayList<RectDouble> arrayList) {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public boolean testIntersect(ICollisionItem iCollisionItem) {
        try {
            Method method = CollisionGroup.class.getMethod("testIntersect", ICollisionItem.class);
            if (iCollisionItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionGroup.7
                    }));
                }
            }
            CollisionGroupImpl collisionGroupImpl = this.mService;
            if (collisionGroupImpl != null) {
                return collisionGroupImpl.$explicit_testIntersect(r2);
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
    public void updateQuadrantItems() {
        CollisionGroupImpl collisionGroupImpl = this.mService;
        if (collisionGroupImpl != null) {
            collisionGroupImpl.$explicit_updateQuadrantItems();
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
