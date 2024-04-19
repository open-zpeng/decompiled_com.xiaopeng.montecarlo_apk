package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.PathTMCPointLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IPathTMCPointLayerItem;
import com.autonavi.gbl.layer.router.PathTMCPointLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = PathTMCPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class PathTMCPointLayerItem extends QuadrantLayerItem implements IPathTMCPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(PathTMCPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private PathTMCPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PathTMCPointLayerItem(long j, boolean z) {
        this(new PathTMCPointLayerItemRouter("PathTMCPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPathTMCPointLayerItem.class}, new Object[]{this});
    }

    public PathTMCPointLayerItem(@QuadrantType.QuadrantType1 int i, long j, @BizDirectionStyle.BizDirectionStyle1 int i2) {
        this(new PathTMCPointLayerItemRouter("PathTMCPointLayerItem", null, i, j, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPathTMCPointLayerItem.class}, new Object[]{this});
    }

    public PathTMCPointLayerItem(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        super(pathTMCPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(pathTMCPointLayerItemImpl);
    }

    private void $constructor(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        if (pathTMCPointLayerItemImpl != null) {
            this.mService = pathTMCPointLayerItemImpl;
            this.mTargetId = String.format("PathTMCPointLayerItem_%s_%d", String.valueOf(PathTMCPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public PathTMCPointLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PathTMCPointLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PathTMCPointLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PathTMCPointLayerItem.3
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
        return PathTMCPointLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem
    public boolean checkShowFlag() {
        PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl = this.mService;
        if (pathTMCPointLayerItemImpl != null) {
            return pathTMCPointLayerItemImpl.$explicit_checkShowFlag();
        }
        return false;
    }

    public void setMBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl = this.mService;
        if (pathTMCPointLayerItemImpl != null) {
            pathTMCPointLayerItemImpl.$explicit_setMBoardStyle(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPathTMCPointLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMBoardStyle() {
        PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl = this.mService;
        if (pathTMCPointLayerItemImpl != null) {
            return pathTMCPointLayerItemImpl.$explicit_getMBoardStyle();
        }
        return Integer.MIN_VALUE;
    }
}
