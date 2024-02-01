package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.CollisionCombination;
import com.autonavi.gbl.map.impl.CollisionCombinationImpl;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombinationRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            ICollisionCombination iCollisionCombination = this.mObserver;
            if (iCollisionCombination != null) {
                return iCollisionCombination.testIntersect(iCollisionItem);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            return iCollisionCombination.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            return iCollisionCombination.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            return iCollisionCombination.isCollision();
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

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void unLockItems() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        ICollisionCombination iCollisionCombination = this.mObserver;
        if (iCollisionCombination != null) {
            iCollisionCombination.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionCombinationImpl
    public void onRecoverCollisonItem(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionCombinationRouter.class.getMethod("onRecoverCollisonItem", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            ICollisionCombination iCollisionCombination = this.mObserver;
            if (iCollisionCombination != null) {
                iCollisionCombination.onRecoverCollisonItem(iCollisionItem);
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
    public void recoverAreaCollisionRecord(CollisionItemImpl collisionItemImpl, CollisionCombinationImpl collisionCombinationImpl) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = CollisionCombinationRouter.class.getMethod("recoverAreaCollisionRecord", CollisionItemImpl.class, CollisionCombinationImpl.class);
            CollisionCombination collisionCombination = null;
            ICollisionItem iCollisionItem = (collisionItemImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (ICollisionItem) typeHelper2.transfer(method, 0, collisionItemImpl);
            if (collisionCombinationImpl != null && (typeHelper = this.mHelper) != null) {
                collisionCombination = (CollisionCombination) typeHelper.transfer(method, 1, collisionCombinationImpl);
            }
            ICollisionCombination iCollisionCombination = this.mObserver;
            if (iCollisionCombination != null) {
                iCollisionCombination.recoverAreaCollisionRecord(iCollisionItem, collisionCombination);
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
