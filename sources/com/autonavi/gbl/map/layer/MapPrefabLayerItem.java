package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.MapPrefabLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.observer.IMapPrefabLayerItem;
import com.autonavi.gbl.map.router.MapPrefabLayerItemRouter;
@IntfAuto(target = MapPrefabLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class MapPrefabLayerItem extends LayerItem implements IMapPrefabLayerItem {
    private static String PACKAGE = ReflexTool.PN(MapPrefabLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private MapPrefabLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapPrefabLayerItem(long j, boolean z) {
        this(new MapPrefabLayerItemRouter("MapPrefabLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapPrefabLayerItem.class}, new Object[]{this});
    }

    public MapPrefabLayerItem(String str) {
        this(new MapPrefabLayerItemRouter("MapPrefabLayerItem", null, str));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapPrefabLayerItem.class}, new Object[]{this});
    }

    public MapPrefabLayerItem(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        super(mapPrefabLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(mapPrefabLayerItemImpl);
    }

    private void $constructor(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        if (mapPrefabLayerItemImpl != null) {
            this.mService = mapPrefabLayerItemImpl;
            this.mTargetId = String.format("MapPrefabLayerItem_%s_%d", String.valueOf(MapPrefabLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public MapPrefabLayerItemImpl getService() {
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
        return MapPrefabLayerItemImpl.getClassTypeName();
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        MapPrefabLayerItemImpl mapPrefabLayerItemImpl = this.mService;
        if (mapPrefabLayerItemImpl != null) {
            mapPrefabLayerItemImpl.$explicit_setPosition(coord3DDouble);
        }
    }

    public void setItemVisible(boolean z) {
        MapPrefabLayerItemImpl mapPrefabLayerItemImpl = this.mService;
        if (mapPrefabLayerItemImpl != null) {
            mapPrefabLayerItemImpl.$explicit_setItemVisible(z);
        }
    }

    public void setConfigData(byte[] bArr, int i) {
        MapPrefabLayerItemImpl mapPrefabLayerItemImpl = this.mService;
        if (mapPrefabLayerItemImpl != null) {
            mapPrefabLayerItemImpl.$explicit_setConfigData(bArr, i);
        }
    }

    public boolean reload() {
        MapPrefabLayerItemImpl mapPrefabLayerItemImpl = this.mService;
        if (mapPrefabLayerItemImpl != null) {
            return mapPrefabLayerItemImpl.$explicit_reload();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        MapPrefabLayerItemImpl mapPrefabLayerItemImpl = this.mService;
        if (mapPrefabLayerItemImpl != null) {
            return mapPrefabLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMapPrefabLayerItem
    public boolean getItemVisible() {
        MapPrefabLayerItemImpl mapPrefabLayerItemImpl = this.mService;
        if (mapPrefabLayerItemImpl != null) {
            return mapPrefabLayerItemImpl.$explicit_getItemVisible();
        }
        return false;
    }
}
