package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.CollisionGroup;
import com.autonavi.gbl.map.impl.CollisionGroupImpl;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionGroup;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = CollisionGroup.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CollisionGroupRouter extends CollisionGroupImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionGroupRouter.class);
    private static String PACKAGE = ReflexTool.PN(CollisionGroupRouter.class);
    private TypeHelper mHelper;
    private ICollisionGroup mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICollisionGroup iCollisionGroup) {
        if (iCollisionGroup != null) {
            this.mObserver = iCollisionGroup;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CollisionGroup.class, iCollisionGroup, this);
            }
        }
    }

    private void $constructor(String str, ICollisionGroup iCollisionGroup) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CollisionGroupImpl.getCPtr((CollisionGroupImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCollisionGroup);
    }

    public CollisionGroupRouter(String str, ICollisionGroup iCollisionGroup, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionGroup);
    }

    public CollisionGroupRouter(String str, ICollisionGroup iCollisionGroup) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCollisionGroup);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionGroupRouter.1
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
    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionGroupRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void resetNextPair() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<RectDouble> arrayList) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        try {
            Method method = CollisionGroupRouter.class.getMethod("testIntersect", ICollisionItemImpl.class);
            if (iCollisionItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (ICollisionItem) typeHelper.transfer(method, 0, iCollisionItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.CollisionGroupRouter.3
                    }));
                }
            }
            ICollisionGroup iCollisionGroup = this.mObserver;
            if (iCollisionGroup != null) {
                return iCollisionGroup.testIntersect(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void unLockItems() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void caculateCollision() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean isAreaCollision() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setIntersectAreaThreshold(float f) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.setIntersectAreaThreshold(f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectAreaThreshold() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.getIntersectAreaThreshold();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.updateQuadrantItems();
        }
    }
}
