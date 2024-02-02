package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.observer.IPolygonLayerItem;
import com.autonavi.gbl.map.router.PolygonLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = PolygonLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class PolygonLayerItem extends LayerItem implements IPolygonLayerItem {
    private static String PACKAGE = ReflexTool.PN(PolygonLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private PolygonLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PolygonLayerItem(long j, boolean z) {
        this(new PolygonLayerItemRouter("PolygonLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPolygonLayerItem.class}, new Object[]{this});
    }

    public PolygonLayerItem() {
        this(new PolygonLayerItemRouter("PolygonLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPolygonLayerItem.class}, new Object[]{this});
    }

    public PolygonLayerItem(PolygonLayerItemImpl polygonLayerItemImpl) {
        super(polygonLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(polygonLayerItemImpl);
    }

    private void $constructor(PolygonLayerItemImpl polygonLayerItemImpl) {
        if (polygonLayerItemImpl != null) {
            this.mService = polygonLayerItemImpl;
            this.mTargetId = String.format("PolygonLayerItem_%s_%d", String.valueOf(PolygonLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public PolygonLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.PolygonLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.PolygonLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.PolygonLayerItem.3
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
        return PolygonLayerItemImpl.getClassTypeName();
    }

    public void setPoints(ArrayList<Coord3DDouble> arrayList) {
        PolygonLayerItemImpl polygonLayerItemImpl = this.mService;
        if (polygonLayerItemImpl != null) {
            polygonLayerItemImpl.$explicit_setPoints(arrayList);
        }
    }

    public void setColor(long j) {
        PolygonLayerItemImpl polygonLayerItemImpl = this.mService;
        if (polygonLayerItemImpl != null) {
            polygonLayerItemImpl.$explicit_setColor(j);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        PolygonLayerItemImpl polygonLayerItemImpl = this.mService;
        if (polygonLayerItemImpl != null) {
            polygonLayerItemImpl.$explicit_updateStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        PolygonLayerItemImpl polygonLayerItemImpl = this.mService;
        if (polygonLayerItemImpl != null) {
            return polygonLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPolygonLayerItem
    public long getColor() {
        PolygonLayerItemImpl polygonLayerItemImpl = this.mService;
        if (polygonLayerItemImpl != null) {
            return polygonLayerItemImpl.$explicit_getColor();
        }
        return 0L;
    }
}
