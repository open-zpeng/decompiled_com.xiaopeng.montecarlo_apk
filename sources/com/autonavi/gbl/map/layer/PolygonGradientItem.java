package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.PolygonGradientPointInfo;
import com.autonavi.gbl.map.layer.observer.IPolygonGradientItem;
import com.autonavi.gbl.map.router.PolygonGradientItemRouter;
import java.util.ArrayList;
@IntfAuto(target = PolygonGradientItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class PolygonGradientItem extends LayerItem implements IPolygonGradientItem {
    private static String PACKAGE = ReflexTool.PN(PolygonGradientItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private PolygonGradientItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PolygonGradientItem(long j, boolean z) {
        this(new PolygonGradientItemRouter("PolygonGradientItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPolygonGradientItem.class}, new Object[]{this});
    }

    public PolygonGradientItem(MapView mapView) {
        this(new PolygonGradientItemRouter("PolygonGradientItem", null, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPolygonGradientItem.class}, new Object[]{this});
    }

    public PolygonGradientItem(PolygonGradientItemImpl polygonGradientItemImpl) {
        super(polygonGradientItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(polygonGradientItemImpl);
    }

    private void $constructor(PolygonGradientItemImpl polygonGradientItemImpl) {
        if (polygonGradientItemImpl != null) {
            this.mService = polygonGradientItemImpl;
            this.mTargetId = String.format("PolygonGradientItem_%s_%d", String.valueOf(PolygonGradientItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public PolygonGradientItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
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
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
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
        return PolygonGradientItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        PolygonGradientItemImpl polygonGradientItemImpl = this.mService;
        if (polygonGradientItemImpl != null) {
            polygonGradientItemImpl.$explicit_updateStyle();
        }
    }

    public void setPoints(ArrayList<PolygonGradientPointInfo> arrayList) {
        PolygonGradientItemImpl polygonGradientItemImpl = this.mService;
        if (polygonGradientItemImpl != null) {
            polygonGradientItemImpl.$explicit_setPoints(arrayList);
        }
    }

    public void clearAll() {
        PolygonGradientItemImpl polygonGradientItemImpl = this.mService;
        if (polygonGradientItemImpl != null) {
            polygonGradientItemImpl.$explicit_clearAll();
        }
    }

    public void startAlphaAnimation(int i, double d, double d2) {
        PolygonGradientItemImpl polygonGradientItemImpl = this.mService;
        if (polygonGradientItemImpl != null) {
            polygonGradientItemImpl.$explicit_startAlphaAnimation(i, d, d2);
        }
    }

    public void setPriority(LayerPriority layerPriority) {
        PolygonGradientItemImpl polygonGradientItemImpl = this.mService;
        if (polygonGradientItemImpl != null) {
            polygonGradientItemImpl.$explicit_setPriority(layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void setVisible(boolean z) {
        PolygonGradientItemImpl polygonGradientItemImpl = this.mService;
        if (polygonGradientItemImpl != null) {
            polygonGradientItemImpl.$explicit_setVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        PolygonGradientItemImpl polygonGradientItemImpl = this.mService;
        if (polygonGradientItemImpl != null) {
            return polygonGradientItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }
}
