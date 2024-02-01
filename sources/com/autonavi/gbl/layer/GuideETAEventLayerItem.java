package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.GuideETAEventLayerItemImpl;
import com.autonavi.gbl.layer.observer.IGuideETAEventLayerItem;
import com.autonavi.gbl.layer.router.GuideETAEventLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = GuideETAEventLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideETAEventLayerItem extends PointLayerItem implements IGuideETAEventLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideETAEventLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideETAEventLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideETAEventLayerItem(long j, boolean z) {
        this(new GuideETAEventLayerItemRouter("GuideETAEventLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideETAEventLayerItem.class}, new Object[]{this});
    }

    public GuideETAEventLayerItem() {
        this(new GuideETAEventLayerItemRouter("GuideETAEventLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideETAEventLayerItem.class}, new Object[]{this});
    }

    public GuideETAEventLayerItem(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        super(guideETAEventLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideETAEventLayerItemImpl);
    }

    private void $constructor(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        if (guideETAEventLayerItemImpl != null) {
            this.mService = guideETAEventLayerItemImpl;
            this.mTargetId = String.format("GuideETAEventLayerItem_%s_%d", String.valueOf(GuideETAEventLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideETAEventLayerItemImpl getService() {
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
        return GuideETAEventLayerItemImpl.getClassTypeName();
    }

    public void setMType(int i) {
        GuideETAEventLayerItemImpl guideETAEventLayerItemImpl = this.mService;
        if (guideETAEventLayerItemImpl != null) {
            guideETAEventLayerItemImpl.$explicit_setMType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideETAEventLayerItem
    public int getMType() {
        GuideETAEventLayerItemImpl guideETAEventLayerItemImpl = this.mService;
        if (guideETAEventLayerItemImpl != null) {
            return guideETAEventLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }
}
