package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.CollisionCombinationImpl;
import com.autonavi.gbl.map.impl.CollisionGroupImpl;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionCombination;
import com.autonavi.gbl.map.observer.ICollisionItem;
import com.autonavi.gbl.map.router.CollisionCombinationRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = CollisionCombinationRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class CollisionCombination implements ICollisionCombination {
    private static String PACKAGE = ReflexTool.PN(CollisionCombination.class);
    private boolean mHasDestroy;
    private CollisionCombinationImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

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

    protected CollisionCombinationImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
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

    public boolean addGroup(CollisionGroup collisionGroup) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombination.class.getMethod("addGroup", CollisionGroup.class);
            CollisionGroupImpl collisionGroupImpl = null;
            if (collisionGroup != null && (typeHelper = this.mTypeHelper) != null) {
                collisionGroupImpl = (CollisionGroupImpl) typeHelper.transfer(method, 0, collisionGroup);
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                return collisionCombinationImpl.$explicit_addGroup(collisionGroupImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGroup(CollisionGroup collisionGroup) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombination.class.getMethod("removeGroup", CollisionGroup.class);
            CollisionGroupImpl collisionGroupImpl = null;
            if (collisionGroup != null && (typeHelper = this.mTypeHelper) != null) {
                collisionGroupImpl = (CollisionGroupImpl) typeHelper.transfer(method, 0, collisionGroup);
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                return collisionCombinationImpl.$explicit_removeGroup(collisionGroupImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public ArrayList<CollisionGroup> getGroups() {
        ArrayList<CollisionGroupImpl> $explicit_getGroups;
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombination.class.getMethod("getGroups", new Class[0]);
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl == null || ($explicit_getGroups = collisionCombinationImpl.$explicit_getGroups()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) $explicit_getGroups, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void removeCollisionItems(ArrayList<ICollisionItem> arrayList) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombination.class.getMethod("removeCollisionItems", ArrayList.class);
            ArrayList<CollisionItemImpl> arrayList2 = null;
            if (arrayList != null && (typeHelper = this.mTypeHelper) != null) {
                arrayList2 = (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList);
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                collisionCombinationImpl.$explicit_removeCollisionItems(arrayList2);
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
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombination.class.getMethod("testIntersect", ICollisionItem.class);
            CollisionItemImpl collisionItemImpl = null;
            if (iCollisionItem != null && (typeHelper = this.mTypeHelper) != null) {
                collisionItemImpl = (CollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem);
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                return collisionCombinationImpl.$explicit_testIntersect(collisionItemImpl);
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

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public void enableCollision(boolean z) {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            collisionCombinationImpl.$explicit_enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination, com.autonavi.gbl.map.observer.ICollisionEntity
    public boolean isCollision() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl != null) {
            return collisionCombinationImpl.$explicit_isCollision();
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
    @Deprecated
    public void onRecoverCollisonItem(ICollisionItem iCollisionItem) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombination.class.getMethod("onRecoverCollisonItem", ICollisionItem.class);
            CollisionItemImpl collisionItemImpl = null;
            if (iCollisionItem != null && (typeHelper = this.mTypeHelper) != null) {
                collisionItemImpl = (CollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem);
            }
            CollisionCombinationImpl collisionCombinationImpl = this.mService;
            if (collisionCombinationImpl != null) {
                collisionCombinationImpl.$explicit_onRecoverCollisonItem(collisionItemImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    @Deprecated
    public void clearAreaCollisionRecord() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl == null || collisionCombinationImpl.isCMemOwn()) {
            return;
        }
        this.mService.$explicit_clearAreaCollisionRecord();
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    @Deprecated
    public void recoverAreaCollisionRecord(ICollisionItem iCollisionItem, CollisionCombination collisionCombination) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = CollisionCombination.class.getMethod("recoverAreaCollisionRecord", ICollisionItem.class, CollisionCombination.class);
            CollisionCombinationImpl collisionCombinationImpl = null;
            CollisionItemImpl collisionItemImpl = (iCollisionItem == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (CollisionItemImpl) typeHelper2.transfer(method, 0, iCollisionItem);
            if (collisionCombination != null && (typeHelper = this.mTypeHelper) != null) {
                collisionCombinationImpl = (CollisionCombinationImpl) typeHelper.transfer(method, 1, collisionCombination);
            }
            CollisionCombinationImpl collisionCombinationImpl2 = this.mService;
            if (collisionCombinationImpl2 == null || collisionCombinationImpl2.isCMemOwn()) {
                return;
            }
            this.mService.$explicit_recoverAreaCollisionRecord(collisionItemImpl, collisionCombinationImpl);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionCombination
    public void applyItemsOnVisible() {
        CollisionCombinationImpl collisionCombinationImpl = this.mService;
        if (collisionCombinationImpl == null || collisionCombinationImpl.isCMemOwn()) {
            return;
        }
        this.mService.$explicit_applyItemsOnVisible();
    }
}
