package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CruiseCongestionEventLayerItemImpl;
import com.autonavi.gbl.layer.model.BizSocolEventInfo;
import com.autonavi.gbl.layer.observer.ICruiseCongestionEventLayerItem;
import com.autonavi.gbl.layer.router.CruiseCongestionEventLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = CruiseCongestionEventLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CruiseCongestionEventLayerItem extends PointLayerItem implements ICruiseCongestionEventLayerItem {
    private static String PACKAGE = ReflexTool.PN(CruiseCongestionEventLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CruiseCongestionEventLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CruiseCongestionEventLayerItem(long j, boolean z) {
        this(new CruiseCongestionEventLayerItemRouter("CruiseCongestionEventLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseCongestionEventLayerItem.class}, new Object[]{this});
    }

    public CruiseCongestionEventLayerItem() {
        this(new CruiseCongestionEventLayerItemRouter("CruiseCongestionEventLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseCongestionEventLayerItem.class}, new Object[]{this});
    }

    public CruiseCongestionEventLayerItem(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        super(cruiseCongestionEventLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cruiseCongestionEventLayerItemImpl);
    }

    private void $constructor(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        if (cruiseCongestionEventLayerItemImpl != null) {
            this.mService = cruiseCongestionEventLayerItemImpl;
            this.mTargetId = String.format("CruiseCongestionEventLayerItem_%s_%d", String.valueOf(CruiseCongestionEventLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CruiseCongestionEventLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.CruiseCongestionEventLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.CruiseCongestionEventLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.CruiseCongestionEventLayerItem.3
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
        return CruiseCongestionEventLayerItemImpl.getClassTypeName();
    }

    public void setMSocolEventInfo(BizSocolEventInfo bizSocolEventInfo) {
        CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl = this.mService;
        if (cruiseCongestionEventLayerItemImpl != null) {
            cruiseCongestionEventLayerItemImpl.$explicit_setMSocolEventInfo(bizSocolEventInfo);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionEventLayerItem
    public BizSocolEventInfo getMSocolEventInfo() {
        CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl = this.mService;
        if (cruiseCongestionEventLayerItemImpl != null) {
            return cruiseCongestionEventLayerItemImpl.$explicit_getMSocolEventInfo();
        }
        return null;
    }
}
