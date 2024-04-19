package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.PathBoardLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizRouteBoardStyle;
import com.autonavi.gbl.layer.observer.IPathBoardLayerItem;
import com.autonavi.gbl.layer.router.PathBoardLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = PathBoardLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class PathBoardLayerItem extends PointLayerItem implements IPathBoardLayerItem {
    private static String PACKAGE = ReflexTool.PN(PathBoardLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private PathBoardLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PathBoardLayerItem(long j, boolean z) {
        this(new PathBoardLayerItemRouter("PathBoardLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPathBoardLayerItem.class}, new Object[]{this});
    }

    public PathBoardLayerItem(String str, @BizDirectionStyle.BizDirectionStyle1 int i, @BizRouteBoardStyle.BizRouteBoardStyle1 int i2) {
        this(new PathBoardLayerItemRouter("PathBoardLayerItem", null, str, i, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPathBoardLayerItem.class}, new Object[]{this});
    }

    public PathBoardLayerItem(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        super(pathBoardLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(pathBoardLayerItemImpl);
    }

    private void $constructor(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        if (pathBoardLayerItemImpl != null) {
            this.mService = pathBoardLayerItemImpl;
            this.mTargetId = String.format("PathBoardLayerItem_%s_%d", String.valueOf(PathBoardLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public PathBoardLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PathBoardLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PathBoardLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.PathBoardLayerItem.3
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
        return PathBoardLayerItemImpl.getClassTypeName();
    }

    public void setMBoardName(String str) {
        PathBoardLayerItemImpl pathBoardLayerItemImpl = this.mService;
        if (pathBoardLayerItemImpl != null) {
            pathBoardLayerItemImpl.$explicit_setMBoardName(str);
        }
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        PathBoardLayerItemImpl pathBoardLayerItemImpl = this.mService;
        if (pathBoardLayerItemImpl != null) {
            pathBoardLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMType(@BizRouteBoardStyle.BizRouteBoardStyle1 int i) {
        PathBoardLayerItemImpl pathBoardLayerItemImpl = this.mService;
        if (pathBoardLayerItemImpl != null) {
            pathBoardLayerItemImpl.$explicit_setMType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPathBoardLayerItem
    public String getMBoardName() {
        PathBoardLayerItemImpl pathBoardLayerItemImpl = this.mService;
        if (pathBoardLayerItemImpl != null) {
            return pathBoardLayerItemImpl.$explicit_getMBoardName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IPathBoardLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        PathBoardLayerItemImpl pathBoardLayerItemImpl = this.mService;
        if (pathBoardLayerItemImpl != null) {
            return pathBoardLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IPathBoardLayerItem
    @BizRouteBoardStyle.BizRouteBoardStyle1
    public int getMType() {
        PathBoardLayerItemImpl pathBoardLayerItemImpl = this.mService;
        if (pathBoardLayerItemImpl != null) {
            return pathBoardLayerItemImpl.$explicit_getMType();
        }
        return Integer.MIN_VALUE;
    }
}
