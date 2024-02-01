package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.IntersectValueType;
import com.autonavi.gbl.map.layer.model.PointLayerItemType;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
import com.autonavi.gbl.map.router.QuadrantLayerItemRouter;
@IntfAuto(target = QuadrantLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class QuadrantLayerItem extends PointLayerItem implements IQuadrantLayerItem {
    private static String PACKAGE = ReflexTool.PN(QuadrantLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private QuadrantLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected QuadrantLayerItem(long j, boolean z) {
        this(new QuadrantLayerItemRouter("QuadrantLayerItem", (IQuadrantLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IQuadrantLayerItem.class}, new Object[]{this});
    }

    public QuadrantLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new QuadrantLayerItemRouter("QuadrantLayerItem", (IQuadrantLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IQuadrantLayerItem.class}, new Object[]{this});
    }

    public QuadrantLayerItem(@PointLayerItemType.PointLayerItemType1 int i, @QuadrantType.QuadrantType1 int i2, long j) {
        this(new QuadrantLayerItemRouter("QuadrantLayerItem", null, i, i2, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IQuadrantLayerItem.class}, new Object[]{this});
    }

    public QuadrantLayerItem(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        super(quadrantLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(quadrantLayerItemImpl);
    }

    private void $constructor(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        if (quadrantLayerItemImpl != null) {
            this.mService = quadrantLayerItemImpl;
            this.mTargetId = String.format("QuadrantLayerItem_%s_%d", String.valueOf(QuadrantLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public QuadrantLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return QuadrantLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public void resetOnVisible(boolean z) {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_resetOnVisible(z);
        }
    }

    public void setIdle(boolean z) {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_setIdle(z);
        }
    }

    public boolean isIdle() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_isIdle();
        }
        return false;
    }

    public void addIntersectArea(float f) {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_addIntersectArea(f);
        }
    }

    public void resetIntersectArea() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_resetIntersectArea();
        }
    }

    public void addIntersectAreaEx(float f) {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_addIntersectAreaEx(f);
        }
    }

    public void resetIntersectAreaEx() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_resetIntersectAreaEx();
        }
    }

    public void addIntersectValue(@IntersectValueType.IntersectValueType1 int i, float f) {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_addIntersectValue(i, f);
        }
    }

    public void resetIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            quadrantLayerItemImpl.$explicit_resetIntersectValue(i);
        }
    }

    public boolean checkShowFlag() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_checkShowFlag();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public boolean canCollision() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public boolean canAreaCollision() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_canAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    public float getIntersectArea() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    public float getIntersectAreaEx() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    public long getQuadrantGroupId() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        QuadrantLayerItemImpl quadrantLayerItemImpl = this.mService;
        if (quadrantLayerItemImpl != null) {
            return quadrantLayerItemImpl.$explicit_getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }
}
