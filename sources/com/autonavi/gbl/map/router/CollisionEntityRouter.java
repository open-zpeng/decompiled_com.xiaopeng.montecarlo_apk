package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.CollisionEntityImpl;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionEntity;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
@IntfAuto(target = ICollisionEntity.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CollisionEntityRouter extends CollisionEntityImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionEntityRouter.class);
    private static String PACKAGE = ReflexTool.PN(CollisionEntityRouter.class);
    private TypeHelper mHelper;
    private ICollisionEntity mObserver;
    private String mTargetId;

    private void $constructor(String str, ICollisionEntity iCollisionEntity) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CollisionEntityImpl.getCPtr((CollisionEntityImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCollisionEntity;
    }

    protected CollisionEntityRouter(String str, ICollisionEntity iCollisionEntity, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionEntity);
    }

    protected CollisionEntityRouter(String str, ICollisionEntity iCollisionEntity) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionEntity);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionEntityRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            ICollisionEntity iCollisionEntity = this.mObserver;
            if (iCollisionEntity != null) {
                return iCollisionEntity.testIntersect(iCollisionItem);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            return iCollisionEntity.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            return iCollisionEntity.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            return iCollisionEntity.isCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void unLockItems() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.caculateCollision();
        }
    }
}
