package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.FlyLineTypePointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IFlyLineTypePointLayerItem;
import com.autonavi.gbl.layer.router.FlyLineTypePointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = FlyLineTypePointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class FlyLineTypePointLayerItem extends PointLayerItem implements IFlyLineTypePointLayerItem {
    private static String PACKAGE = ReflexTool.PN(FlyLineTypePointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private FlyLineTypePointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected FlyLineTypePointLayerItem(long j, boolean z) {
        this(new FlyLineTypePointLayerItemRouter("FlyLineTypePointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IFlyLineTypePointLayerItem.class}, new Object[]{this});
    }

    public FlyLineTypePointLayerItem() {
        this(new FlyLineTypePointLayerItemRouter("FlyLineTypePointLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IFlyLineTypePointLayerItem.class}, new Object[]{this});
    }

    public FlyLineTypePointLayerItem(FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl) {
        super(flyLineTypePointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(flyLineTypePointLayerItemImpl);
    }

    private void $constructor(FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl) {
        if (flyLineTypePointLayerItemImpl != null) {
            this.mService = flyLineTypePointLayerItemImpl;
            this.mTargetId = String.format("FlyLineTypePointLayerItem_%s_%d", String.valueOf(FlyLineTypePointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public FlyLineTypePointLayerItemImpl getService() {
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
        return FlyLineTypePointLayerItemImpl.getClassTypeName();
    }

    public void setName(String str) {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            flyLineTypePointLayerItemImpl.$explicit_setName(str);
        }
    }

    public void setMainkey(int i) {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            flyLineTypePointLayerItemImpl.$explicit_setMainkey(i);
        }
    }

    public void setSubkey(int i) {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            flyLineTypePointLayerItemImpl.$explicit_setSubkey(i);
        }
    }

    public void setTextFontScale(float f) {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            flyLineTypePointLayerItemImpl.$explicit_setTextFontScale(f);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IFlyLineTypePointLayerItem
    public String getName() {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            return flyLineTypePointLayerItemImpl.$explicit_getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IFlyLineTypePointLayerItem
    public int getMainkey() {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            return flyLineTypePointLayerItemImpl.$explicit_getMainkey();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IFlyLineTypePointLayerItem
    public int getSubkey() {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            return flyLineTypePointLayerItemImpl.$explicit_getSubkey();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IFlyLineTypePointLayerItem
    public float getTextFontScale() {
        FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl = this.mService;
        if (flyLineTypePointLayerItemImpl != null) {
            return flyLineTypePointLayerItemImpl.$explicit_getTextFontScale();
        }
        return 0.0f;
    }
}
