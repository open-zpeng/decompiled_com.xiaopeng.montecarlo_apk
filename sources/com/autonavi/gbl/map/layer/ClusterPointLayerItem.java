package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.impl.ClusterPointLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.observer.IClusterPointLayerItem;
import com.autonavi.gbl.map.router.ClusterPointLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = ClusterPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class ClusterPointLayerItem extends PointLayerItem implements IClusterPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(ClusterPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private ClusterPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ClusterPointLayerItem(long j, boolean z) {
        this(new ClusterPointLayerItemRouter("ClusterPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IClusterPointLayerItem.class}, new Object[]{this});
    }

    public ClusterPointLayerItem() {
        this(new ClusterPointLayerItemRouter("ClusterPointLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IClusterPointLayerItem.class}, new Object[]{this});
    }

    public ClusterPointLayerItem(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        super(clusterPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(clusterPointLayerItemImpl);
    }

    private void $constructor(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        if (clusterPointLayerItemImpl != null) {
            this.mService = clusterPointLayerItemImpl;
            this.mTargetId = String.format("ClusterPointLayerItem_%s_%d", String.valueOf(ClusterPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public ClusterPointLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.ClusterPointLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.ClusterPointLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.ClusterPointLayerItem.3
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
        return ClusterPointLayerItemImpl.getClassTypeName();
    }

    public void setClusterPointSize(int i) {
        ClusterPointLayerItemImpl clusterPointLayerItemImpl = this.mService;
        if (clusterPointLayerItemImpl != null) {
            clusterPointLayerItemImpl.$explicit_setClusterPointSize(i);
        }
    }

    public void setVecOriginalItemID(ArrayList<String> arrayList) {
        ClusterPointLayerItemImpl clusterPointLayerItemImpl = this.mService;
        if (clusterPointLayerItemImpl != null) {
            clusterPointLayerItemImpl.$explicit_setVecOriginalItemID(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ClusterPointLayerItemImpl clusterPointLayerItemImpl = this.mService;
        if (clusterPointLayerItemImpl != null) {
            return clusterPointLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IClusterPointLayerItem
    public int getClusterPointSize() {
        ClusterPointLayerItemImpl clusterPointLayerItemImpl = this.mService;
        if (clusterPointLayerItemImpl != null) {
            return clusterPointLayerItemImpl.$explicit_getClusterPointSize();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IClusterPointLayerItem
    public ArrayList<String> getVecOriginalItemID() {
        ClusterPointLayerItemImpl clusterPointLayerItemImpl = this.mService;
        if (clusterPointLayerItemImpl != null) {
            return clusterPointLayerItemImpl.$explicit_getVecOriginalItemID();
        }
        return null;
    }
}
