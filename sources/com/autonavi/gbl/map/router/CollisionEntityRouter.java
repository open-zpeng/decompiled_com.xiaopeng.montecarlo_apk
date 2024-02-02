package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.ICollisionEntityImpl;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionEntity;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
@IntfAuto(target = ICollisionEntity.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CollisionEntityRouter extends ICollisionEntityImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionEntityRouter.class);
    private static String PACKAGE = ReflexTool.PN(CollisionEntityRouter.class);
    private TypeHelper mHelper;
    private ICollisionEntity mObserver;
    private String mTargetId;

    private void $constructor(String str, ICollisionEntity iCollisionEntity) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICollisionEntityImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionEntityRouter.1
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
    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionEntityRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void resetNextPair() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        try {
            Method method = CollisionEntityRouter.class.getMethod("testIntersect", ICollisionItemImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionEntityRouter.3
                    }));
                }
            }
            ICollisionEntity iCollisionEntity = this.mObserver;
            if (iCollisionEntity != null) {
                return iCollisionEntity.testIntersect(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            return iCollisionEntity.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean isAreaCollision() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            return iCollisionEntity.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void unLockItems() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void caculateCollision() {
        ICollisionEntity iCollisionEntity = this.mObserver;
        if (iCollisionEntity != null) {
            iCollisionEntity.caculateCollision();
        }
    }
}
