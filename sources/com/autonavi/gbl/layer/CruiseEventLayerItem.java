package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.layer.impl.CruiseEventLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICruiseEventLayerItem;
import com.autonavi.gbl.layer.router.CruiseEventLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = CruiseEventLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CruiseEventLayerItem extends PointLayerItem implements ICruiseEventLayerItem {
    private static String PACKAGE = ReflexTool.PN(CruiseEventLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CruiseEventLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CruiseEventLayerItem(long j, boolean z) {
        this(new CruiseEventLayerItemRouter("CruiseEventLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseEventLayerItem.class}, new Object[]{this});
    }

    public CruiseEventLayerItem(CruiseEventInfo cruiseEventInfo) {
        this(new CruiseEventLayerItemRouter("CruiseEventLayerItem", null, cruiseEventInfo));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseEventLayerItem.class}, new Object[]{this});
    }

    public CruiseEventLayerItem(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        super(cruiseEventLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cruiseEventLayerItemImpl);
    }

    private void $constructor(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        if (cruiseEventLayerItemImpl != null) {
            this.mService = cruiseEventLayerItemImpl;
            this.mTargetId = String.format("CruiseEventLayerItem_%s_%d", String.valueOf(CruiseEventLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CruiseEventLayerItemImpl getService() {
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
        return CruiseEventLayerItemImpl.getClassTypeName();
    }

    public void setMCruiseEventInfo(CruiseEventInfo cruiseEventInfo) {
        CruiseEventLayerItemImpl cruiseEventLayerItemImpl = this.mService;
        if (cruiseEventLayerItemImpl != null) {
            cruiseEventLayerItemImpl.$explicit_setMCruiseEventInfo(cruiseEventInfo);
        }
    }

    public void setMShowText(boolean z) {
        CruiseEventLayerItemImpl cruiseEventLayerItemImpl = this.mService;
        if (cruiseEventLayerItemImpl != null) {
            cruiseEventLayerItemImpl.$explicit_setMShowText(z);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseEventLayerItem
    public CruiseEventInfo getMCruiseEventInfo() {
        CruiseEventLayerItemImpl cruiseEventLayerItemImpl = this.mService;
        if (cruiseEventLayerItemImpl != null) {
            return cruiseEventLayerItemImpl.$explicit_getMCruiseEventInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseEventLayerItem
    public boolean getMShowText() {
        CruiseEventLayerItemImpl cruiseEventLayerItemImpl = this.mService;
        if (cruiseEventLayerItemImpl != null) {
            return cruiseEventLayerItemImpl.$explicit_getMShowText();
        }
        return false;
    }
}
