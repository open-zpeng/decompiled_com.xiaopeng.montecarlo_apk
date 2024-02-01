package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.map.CollisionGroup;
import com.autonavi.gbl.map.impl.CollisionGroupImpl;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void resetNextPair() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.resetNextPair();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        TypeHelper typeHelper;
        try {
            Method method = CollisionGroupRouter.class.getMethod("testIntersect", CollisionItemImpl.class);
            ICollisionItem iCollisionItem = null;
            if (collisionItemImpl != null && (typeHelper = this.mHelper) != null) {
                iCollisionItem = (ICollisionItem) typeHelper.transfer(method, 0, collisionItemImpl);
            }
            ICollisionGroup iCollisionGroup = this.mObserver;
            if (iCollisionGroup != null) {
                return iCollisionGroup.testIntersect(iCollisionItem);
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
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void lockItems() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void unLockItems() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void caculateCollision() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.caculateCollision();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.enableAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isAreaCollision() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public boolean isCollision() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.isCollision();
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
    public void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.setIntersectThreshold(i, f);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.getIntersectThreshold(i);
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

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void getPriority(LayerPriority layerPriority) {
        $wrapper_getPriority(layerPriority);
    }

    private void $wrapper_getPriority(LayerPriority layerPriority) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            try {
                TypeUtil.deepcopy(iCollisionGroup.getPriority(), layerPriority);
            } catch (Exception unused) {
                DebugTool.e("getPriority copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void applyItemsOnVisible() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void setApplyItemsOnVisible(boolean z) {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            iCollisionGroup.setApplyItemsOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean hasAppliedItemsOnVisible() {
        ICollisionGroup iCollisionGroup = this.mObserver;
        if (iCollisionGroup != null) {
            return iCollisionGroup.hasAppliedItemsOnVisible();
        }
        return false;
    }
}
