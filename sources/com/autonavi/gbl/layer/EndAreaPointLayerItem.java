package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.EndAreaPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IEndAreaPointLayerItem;
import com.autonavi.gbl.layer.router.EndAreaPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = EndAreaPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class EndAreaPointLayerItem extends PointLayerItem implements IEndAreaPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(EndAreaPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private EndAreaPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected EndAreaPointLayerItem(long j, boolean z) {
        this(new EndAreaPointLayerItemRouter("EndAreaPointLayerItem", (IEndAreaPointLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IEndAreaPointLayerItem.class}, new Object[]{this});
    }

    public EndAreaPointLayerItem(String str, int i) {
        this(new EndAreaPointLayerItemRouter("EndAreaPointLayerItem", (IEndAreaPointLayerItem) null, str, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IEndAreaPointLayerItem.class}, new Object[]{this});
    }

    public EndAreaPointLayerItem(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        super(endAreaPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(endAreaPointLayerItemImpl);
    }

    private void $constructor(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        if (endAreaPointLayerItemImpl != null) {
            this.mService = endAreaPointLayerItemImpl;
            this.mTargetId = String.format("EndAreaPointLayerItem_%s_%d", String.valueOf(EndAreaPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public EndAreaPointLayerItemImpl getService() {
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
        return EndAreaPointLayerItemImpl.getClassTypeName();
    }

    public void setMPoiName(String str) {
        EndAreaPointLayerItemImpl endAreaPointLayerItemImpl = this.mService;
        if (endAreaPointLayerItemImpl != null) {
            endAreaPointLayerItemImpl.$explicit_setMPoiName(str);
        }
    }

    public void setMPoiType(int i) {
        EndAreaPointLayerItemImpl endAreaPointLayerItemImpl = this.mService;
        if (endAreaPointLayerItemImpl != null) {
            endAreaPointLayerItemImpl.$explicit_setMPoiType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaPointLayerItem
    public String getMPoiName() {
        EndAreaPointLayerItemImpl endAreaPointLayerItemImpl = this.mService;
        if (endAreaPointLayerItemImpl != null) {
            return endAreaPointLayerItemImpl.$explicit_getMPoiName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IEndAreaPointLayerItem
    public int getMPoiType() {
        EndAreaPointLayerItemImpl endAreaPointLayerItemImpl = this.mService;
        if (endAreaPointLayerItemImpl != null) {
            return endAreaPointLayerItemImpl.$explicit_getMPoiType();
        }
        return 0;
    }
}
