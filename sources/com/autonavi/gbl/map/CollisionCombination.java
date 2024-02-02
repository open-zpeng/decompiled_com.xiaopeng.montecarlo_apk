package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.CollisionCombinationImpl;
import com.autonavi.gbl.map.impl.CollisionGroupImpl;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionCombination;
import com.autonavi.gbl.map.observer.ICollisionItem;
import com.autonavi.gbl.map.router.CollisionCombinationRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = CollisionCombinationRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CollisionCombination implements ICollisionCombination {
    private static String PACKAGE = ReflexTool.PN(CollisionCombination.class);
    private boolean mHasDestroy;
    private CollisionCombinationImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CollisionCombination(long j, boolean z) {
        this(new CollisionCombinationRouter("CollisionCombination", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICollisionCombination.class}, new Object[]{this});
    }

    public CollisionCombination() {
        this(new CollisionCombinationRouter("CollisionCombination", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICollisionCombination.class}, new Object[]{this});
    }

    public CollisionCombination(CollisionCombinationImpl collisionCombinationImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(collisionCombinationImpl);
    }

    private void $constructor(CollisionCombinationImpl collisionCombinationImpl) {
        if (collisionCombinationImpl != null) {
            this.mService = collisionCombinationImpl;
            this.mTargetId = String.format("CollisionCombination_%s_%d", String.valueOf(CollisionCombinationImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    public CollisionCombinationImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.3
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

    public boolean addGroup(CollisionGroup collisionGroup) {
        try {
            Method method = CollisionCombination.class.getMethod("addGroup", CollisionGroup.class);
            if (collisionGroup != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (CollisionGroupImpl) typeHelper.transfer(method, 0, collisionGroup) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $group == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.4
                    }));
                }
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                return collisionCombinationImpl.$explicit_addGroup(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGroup(CollisionGroup collisionGroup) {
        try {
            Method method = CollisionCombination.class.getMethod("removeGroup", CollisionGroup.class);
            if (collisionGroup != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (CollisionGroupImpl) typeHelper.transfer(method, 0, collisionGroup) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $group == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.5
                    }));
                }
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                return collisionCombinationImpl.$explicit_removeGroup(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public ArrayList<CollisionGroup> getGroups() {
        ArrayList<CollisionGroupImpl> $explicit_getGroups;
        try {
            Method method = CollisionCombination.class.getMethod("getGroups", new Class[0]);
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null && ($explicit_getGroups = collisionCombinationImpl.$explicit_getGroups()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) $explicit_getGroups, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.6
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void removeCollisionItems(ArrayList<ICollisionItem> arrayList) {
        try {
            Method method = CollisionCombination.class.getMethod("removeCollisionItems", ArrayList.class);
            if (arrayList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $vecItems == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.7
                    }));
                }
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                collisionCombinationImpl.$explicit_removeCollisionItems(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public void resetNextPair() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public boolean testIntersect(ICollisionItem iCollisionItem) {
        try {
            Method method = CollisionCombination.class.getMethod("testIntersect", ICollisionItem.class);
            if (iCollisionItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.8
                    }));
                }
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                return collisionCombinationImpl.$explicit_testIntersect(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    @CollisionType.CollisionType1
    public int getType() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            return collisionCombinationImpl.$explicit_getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public void enableAreaCollision(boolean z) {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public boolean isAreaCollision() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            return collisionCombinationImpl.$explicit_isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    public void setCollidedByFocusItem(boolean z) {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_setCollidedByFocusItem(z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    public boolean isCollidedByFocusItem() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            return collisionCombinationImpl.$explicit_isCollidedByFocusItem();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public void lockItems() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public void unLockItems() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public void caculateCollision() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    public void onRecoverCollisonItem(ICollisionItem iCollisionItem) {
        try {
            Method method = CollisionCombination.class.getMethod("onRecoverCollisonItem", ICollisionItem.class);
            if (iCollisionItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ICollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.9
                    }));
                }
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                collisionCombinationImpl.$explicit_onRecoverCollisonItem(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    public void clearAreaCollisionRecord() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_clearAreaCollisionRecord();
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    public void recoverAreaCollisionRecord(ICollisionItem iCollisionItem, CollisionCombination collisionCombination) {
        ICollisionItemImpl iCollisionItemImpl;
        try {
            Method method = CollisionCombination.class.getMethod("recoverAreaCollisionRecord", ICollisionItem.class, CollisionCombination.class);
            if (iCollisionItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iCollisionItemImpl = typeHelper != null ? (ICollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem) : null;
                if (iCollisionItemImpl == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.10
                    }));
                }
            } else {
                iCollisionItemImpl = null;
            }
            if (collisionCombination != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r1 = typeHelper2 != null ? (CollisionCombinationImpl) typeHelper2.transfer(method, 1, collisionCombination) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $comb == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.CollisionCombination.11
                    }));
                }
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                collisionCombinationImpl.$explicit_recoverAreaCollisionRecord(iCollisionItemImpl, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
