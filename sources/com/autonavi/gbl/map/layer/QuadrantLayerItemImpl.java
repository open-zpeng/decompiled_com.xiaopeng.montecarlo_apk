package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
import com.autonavi.gbl.map.router.QuadrantLayerItemRouter;
@IntfAuto(target = QuadrantLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class QuadrantLayerItemImpl extends PointLayerItem implements IQuadrantLayerItem {
    private static String PACKAGE = ReflexTool.PN(QuadrantLayerItemImpl.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private QuadrantLayerItem mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected QuadrantLayerItemImpl(long j, boolean z) {
        this(new QuadrantLayerItemRouter("QuadrantLayerItemImpl", (IQuadrantLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IQuadrantLayerItem.class}, new Object[]{this});
    }

    public QuadrantLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(new QuadrantLayerItemRouter("QuadrantLayerItemImpl", (IQuadrantLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IQuadrantLayerItem.class}, new Object[]{this});
    }

    public QuadrantLayerItemImpl(QuadrantLayerItem quadrantLayerItem) {
        super(quadrantLayerItem);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(quadrantLayerItem);
    }

    private void $constructor(QuadrantLayerItem quadrantLayerItem) {
        if (quadrantLayerItem != null) {
            this.mService = quadrantLayerItem;
            this.mTargetId = String.format("QuadrantLayerItemImpl_%s_%d", String.valueOf(QuadrantLayerItem.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public QuadrantLayerItem getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.QuadrantLayerItemImpl.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.QuadrantLayerItemImpl.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.QuadrantLayerItemImpl.3
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
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return QuadrantLayerItem.getClassTypeName();
    }

    public void setIdle(boolean z) {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            quadrantLayerItem.$explicit_setIdle(z);
        }
    }

    public boolean isIdle() {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            return quadrantLayerItem.$explicit_isIdle();
        }
        return false;
    }

    public void addIntersectArea(float f) {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            quadrantLayerItem.$explicit_addIntersectArea(f);
        }
    }

    public void resetIntersectArea() {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            quadrantLayerItem.$explicit_resetIntersectArea();
        }
    }

    public boolean checkShowFlag() {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            return quadrantLayerItem.$explicit_checkShowFlag();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem, com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public void onVisible(boolean z) {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            quadrantLayerItem.$explicit_onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    public float getIntersectArea() {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            return quadrantLayerItem.$explicit_getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    public long getQuadrantGroupId() {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            return quadrantLayerItem.$explicit_getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        QuadrantLayerItem quadrantLayerItem = this.mService;
        if (quadrantLayerItem != null) {
            return quadrantLayerItem.$explicit_getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }
}
