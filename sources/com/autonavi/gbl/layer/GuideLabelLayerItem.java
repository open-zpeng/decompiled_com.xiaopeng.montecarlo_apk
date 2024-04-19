package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideLabelLayerItem;
import com.autonavi.gbl.layer.router.GuideLabelLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = GuideLabelLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideLabelLayerItem extends QuadrantLayerItem implements IGuideLabelLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideLabelLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideLabelLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideLabelLayerItem(long j, boolean z) {
        this(new GuideLabelLayerItemRouter("GuideLabelLayerItem", (IGuideLabelLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideLabelLayerItem.class}, new Object[]{this});
    }

    public GuideLabelLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new GuideLabelLayerItemRouter("GuideLabelLayerItem", (IGuideLabelLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideLabelLayerItem.class}, new Object[]{this});
    }

    public GuideLabelLayerItem(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        super(guideLabelLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideLabelLayerItemImpl);
    }

    private void $constructor(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        if (guideLabelLayerItemImpl != null) {
            this.mService = guideLabelLayerItemImpl;
            this.mTargetId = String.format("GuideLabelLayerItem_%s_%d", String.valueOf(GuideLabelLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideLabelLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideLabelLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideLabelLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideLabelLayerItem.3
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
        return GuideLabelLayerItemImpl.getClassTypeName();
    }

    public void setMLabelIndex(int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMLabelIndex(i);
        }
    }

    public void setMPathCost(long j) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMPathCost(j);
        }
    }

    public void setMAlterPathIndx(int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMAlterPathIndx(i);
        }
    }

    public void setMPathId(long j) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMPathId(j);
        }
    }

    public void setMCostDiff(int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMCostDiff(i);
        }
    }

    public void setMDistanceDiff(int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMDistanceDiff(i);
        }
    }

    public void setMTravelTimeDiff(int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMTravelTimeDiff(i);
        }
    }

    public void setMTrafficLightDiff(int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMTrafficLightDiff(i);
        }
    }

    public void setMBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMBoardStyle(i);
        }
    }

    public void setMRoadName(String str) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMRoadName(str);
        }
    }

    public void setMRoadFormway(@Formway.Formway1 int i) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMRoadFormway(i);
        }
    }

    public void setMPreviewMode(boolean z) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMPreviewMode(z);
        }
    }

    public void setMIsFaster(boolean z) {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            guideLabelLayerItemImpl.$explicit_setMIsFaster(z);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public int getMLabelIndex() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMLabelIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public long getMPathCost() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMPathCost();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public int getMAlterPathIndx() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMAlterPathIndx();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public long getMPathId() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public int getMCostDiff() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMCostDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public int getMDistanceDiff() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMDistanceDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public int getMTravelTimeDiff() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMTravelTimeDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public int getMTrafficLightDiff() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMTrafficLightDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMBoardStyle() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMBoardStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public String getMRoadName() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMRoadName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    @Formway.Formway1
    public int getMRoadFormway() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMRoadFormway();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public boolean getMPreviewMode() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMPreviewMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public boolean getMIsFaster() {
        GuideLabelLayerItemImpl guideLabelLayerItemImpl = this.mService;
        if (guideLabelLayerItemImpl != null) {
            return guideLabelLayerItemImpl.$explicit_getMIsFaster();
        }
        return false;
    }
}
