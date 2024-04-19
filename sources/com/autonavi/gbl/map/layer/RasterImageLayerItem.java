package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.observer.IRasterImageLayerItem;
import com.autonavi.gbl.map.router.RasterImageLayerItemRouter;
@IntfAuto(target = RasterImageLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class RasterImageLayerItem extends LayerItem implements IRasterImageLayerItem {
    private static String PACKAGE = ReflexTool.PN(RasterImageLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RasterImageLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RasterImageLayerItem(long j, boolean z) {
        this(new RasterImageLayerItemRouter("RasterImageLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRasterImageLayerItem.class}, new Object[]{this});
    }

    public RasterImageLayerItem() {
        this(new RasterImageLayerItemRouter("RasterImageLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRasterImageLayerItem.class}, new Object[]{this});
    }

    public RasterImageLayerItem(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        super(rasterImageLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(rasterImageLayerItemImpl);
    }

    private void $constructor(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        if (rasterImageLayerItemImpl != null) {
            this.mService = rasterImageLayerItemImpl;
            this.mTargetId = String.format("RasterImageLayerItem_%s_%d", String.valueOf(RasterImageLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public RasterImageLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RasterImageLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RasterImageLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RasterImageLayerItem.3
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
        return RasterImageLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        RasterImageLayerItemImpl rasterImageLayerItemImpl = this.mService;
        if (rasterImageLayerItemImpl != null) {
            rasterImageLayerItemImpl.$explicit_updateStyle();
        }
    }

    public void setArrowColor(boolean z, int i) {
        RasterImageLayerItemImpl rasterImageLayerItemImpl = this.mService;
        if (rasterImageLayerItemImpl != null) {
            rasterImageLayerItemImpl.$explicit_setArrowColor(z, i);
        }
    }

    public void setRasterImageData(LayerTexture layerTexture, LayerTexture layerTexture2) {
        RasterImageLayerItemImpl rasterImageLayerItemImpl = this.mService;
        if (rasterImageLayerItemImpl != null) {
            rasterImageLayerItemImpl.$explicit_setRasterImageData(layerTexture, layerTexture2);
        }
    }

    public void setPlaneViewRect(RectInt rectInt) {
        RasterImageLayerItemImpl rasterImageLayerItemImpl = this.mService;
        if (rasterImageLayerItemImpl != null) {
            rasterImageLayerItemImpl.$explicit_setPlaneViewRect(rectInt);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        RasterImageLayerItemImpl rasterImageLayerItemImpl = this.mService;
        if (rasterImageLayerItemImpl != null) {
            return rasterImageLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }
}
