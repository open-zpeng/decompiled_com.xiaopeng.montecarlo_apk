package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.CollisionCombination;
import com.autonavi.gbl.map.impl.CollisionCombinationImpl;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionCombination;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
@IntfAuto(target = CollisionCombination.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CollisionCombinationRouter extends CollisionCombinationImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionCombinationRouter.class);
    private static String PACKAGE = ReflexTool.PN(CollisionCombinationRouter.class);
    private TypeHelper mHelper;
    private ICollisionCombination mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICollisionCombination iCollisionCombination) {
        if (iCollisionCombination != null) {
            this.mObserver = iCollisionCombination;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CollisionCombination.class, iCollisionCombination, this);
            }
        }
    }

    private void $constructor(String str, ICollisionCombination iCollisionCombination) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CollisionCombinationImpl.getCPtr((CollisionCombinationImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCollisionCombination);
    }

    public CollisionCombinationRouter(String str, ICollisionCombination iCollisionCombination, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionCombination);
    }

    public CollisionCombinationRouter(String str, ICollisionCombination iCollisionCombination) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionCombination);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionCombinationRouter.1
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
    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionCombinationRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void resetNextPair() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        try {
            Method method = CollisionCombinationRouter.class.getMethod("testIntersect", ICollisionItemImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionCombinationRouter.3
                    }));
                }
            }
            ICollisionCombination iCollisionCombination = this.mObserver;
            if (iCollisionCombination != null) {
                return iCollisionCombination.testIntersect(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            return iCollisionCombination.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean isAreaCollision() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            return iCollisionCombination.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl
    public void setCollidedByFocusItem(boolean z) {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.setCollidedByFocusItem(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl
    public boolean isCollidedByFocusItem() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            return iCollisionCombination.isCollidedByFocusItem();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void unLockItems() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void caculateCollision() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl
    public void onRecoverCollisonItem(ICollisionItemImpl iCollisionItemImpl) {
        try {
            Method method = CollisionCombinationRouter.class.getMethod("onRecoverCollisonItem", ICollisionItemImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionCombinationRouter.4
                    }));
                }
            }
            ICollisionCombination iCollisionCombination = this.mObserver;
            if (iCollisionCombination != null) {
                iCollisionCombination.onRecoverCollisonItem(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl
    public void clearAreaCollisionRecord() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.clearAreaCollisionRecord();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl
    public void recoverAreaCollisionRecord(ICollisionItemImpl iCollisionItemImpl, CollisionCombinationImpl collisionCombinationImpl) {
        ICollisionItem iCollisionItem;
        try {
            Method method = CollisionCombinationRouter.class.getMethod("recoverAreaCollisionRecord", ICollisionItemImpl.class, CollisionCombinationImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                iCollisionItem = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (iCollisionItem == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionCombinationRouter.5
                    }));
                }
            } else {
                iCollisionItem = null;
            }
            if (collisionCombinationImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (CollisionCombination) typeHelper2.transfer(method, 1, collisionCombinationImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $comb == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionCombinationRouter.6
                    }));
                }
            }
            ICollisionCombination iCollisionCombination = this.mObserver;
            if (iCollisionCombination != null) {
                iCollisionCombination.recoverAreaCollisionRecord(iCollisionItem, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl
    public void applyItemsOnVisible() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.applyItemsOnVisible();
        }
    }
}
