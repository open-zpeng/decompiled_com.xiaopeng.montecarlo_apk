package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.MapModelLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.ModelDescInfo;
import com.autonavi.gbl.map.layer.observer.IMapModelLayerItem;
import com.autonavi.gbl.map.router.MapModelLayerItemRouter;
@IntfAuto(target = MapModelLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class MapModelLayerItem extends LayerItem implements IMapModelLayerItem {
    private static String PACKAGE = ReflexTool.PN(MapModelLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private MapModelLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapModelLayerItem(long j, boolean z) {
        this(new MapModelLayerItemRouter("MapModelLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapModelLayerItem.class}, new Object[]{this});
    }

    public MapModelLayerItem() {
        this(new MapModelLayerItemRouter("MapModelLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapModelLayerItem.class}, new Object[]{this});
    }

    public MapModelLayerItem(MapModelLayerItemImpl mapModelLayerItemImpl) {
        super(mapModelLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(mapModelLayerItemImpl);
    }

    private void $constructor(MapModelLayerItemImpl mapModelLayerItemImpl) {
        if (mapModelLayerItemImpl != null) {
            this.mService = mapModelLayerItemImpl;
            this.mTargetId = String.format("MapModelLayerItem_%s_%d", String.valueOf(MapModelLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public MapModelLayerItemImpl getService() {
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
        return MapModelLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_updateStyle();
        }
    }

    public void setModelDescInfo(ModelDescInfo modelDescInfo) {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_setModelDescInfo(modelDescInfo);
        }
    }

    public void setPos(Coord3DDouble coord3DDouble) {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_setPos(coord3DDouble);
        }
    }

    public void setPos3D(Coord3DDouble coord3DDouble) {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_setPos3D(coord3DDouble);
        }
    }

    public void setScale(float f) {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_setScale(f);
        }
    }

    public void setDepthMask(boolean z) {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_setDepthMask(z);
        }
    }

    public void setResolveConflict(boolean z) {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_setResolveConflict(z);
        }
    }

    public void setMaxPitchAxisOffset(float f) {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            mapModelLayerItemImpl.$explicit_setMaxPitchAxisOffset(f);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMapModelLayerItem
    public int getModelID() {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            return mapModelLayerItemImpl.$explicit_getModelID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            return mapModelLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMapModelLayerItem
    public boolean getDepthMask() {
        MapModelLayerItemImpl mapModelLayerItemImpl = this.mService;
        if (mapModelLayerItemImpl != null) {
            return mapModelLayerItemImpl.$explicit_getDepthMask();
        }
        return false;
    }
}
