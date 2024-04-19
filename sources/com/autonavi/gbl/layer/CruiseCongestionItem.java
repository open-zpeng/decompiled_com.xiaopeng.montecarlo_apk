package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.layer.impl.CruiseCongestionItemImpl;
import com.autonavi.gbl.layer.observer.ICruiseCongestionItem;
import com.autonavi.gbl.layer.router.CruiseCongestionItemRouter;
import com.autonavi.gbl.map.layer.LineLayerItem;
@IntfAuto(target = CruiseCongestionItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CruiseCongestionItem extends LineLayerItem implements ICruiseCongestionItem {
    private static String PACKAGE = ReflexTool.PN(CruiseCongestionItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CruiseCongestionItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CruiseCongestionItem(long j, boolean z) {
        this(new CruiseCongestionItemRouter("CruiseCongestionItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseCongestionItem.class}, new Object[]{this});
    }

    public CruiseCongestionItem() {
        this(new CruiseCongestionItemRouter("CruiseCongestionItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICruiseCongestionItem.class}, new Object[]{this});
    }

    public CruiseCongestionItem(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        super(cruiseCongestionItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cruiseCongestionItemImpl);
    }

    private void $constructor(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        if (cruiseCongestionItemImpl != null) {
            this.mService = cruiseCongestionItemImpl;
            this.mTargetId = String.format("CruiseCongestionItem_%s_%d", String.valueOf(CruiseCongestionItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CruiseCongestionItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.CruiseCongestionItem.1
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
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.CruiseCongestionItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.CruiseCongestionItem.3
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
        return CruiseCongestionItemImpl.getClassTypeName();
    }

    public void setMStatus(@TrafficStatus.TrafficStatus1 int i) {
        CruiseCongestionItemImpl cruiseCongestionItemImpl = this.mService;
        if (cruiseCongestionItemImpl != null) {
            cruiseCongestionItemImpl.$explicit_setMStatus(i);
        }
    }

    public void setMInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        CruiseCongestionItemImpl cruiseCongestionItemImpl = this.mService;
        if (cruiseCongestionItemImpl != null) {
            cruiseCongestionItemImpl.$explicit_setMInfo(cruiseCongestionInfo);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionItem
    @TrafficStatus.TrafficStatus1
    public int getMStatus() {
        CruiseCongestionItemImpl cruiseCongestionItemImpl = this.mService;
        if (cruiseCongestionItemImpl != null) {
            return cruiseCongestionItemImpl.$explicit_getMStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ICruiseCongestionItem
    public CruiseCongestionInfo getMInfo() {
        CruiseCongestionItemImpl cruiseCongestionItemImpl = this.mService;
        if (cruiseCongestionItemImpl != null) {
            return cruiseCongestionItemImpl.$explicit_getMInfo();
        }
        return null;
    }
}
