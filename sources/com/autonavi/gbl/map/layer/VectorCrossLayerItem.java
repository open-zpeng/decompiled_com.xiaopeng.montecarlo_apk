package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.VectorCrossLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.observer.IVectorCrossLayerItem;
import com.autonavi.gbl.map.router.VectorCrossLayerItemRouter;
@IntfAuto(target = VectorCrossLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class VectorCrossLayerItem extends LayerItem implements IVectorCrossLayerItem {
    private static String PACKAGE = ReflexTool.PN(VectorCrossLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private VectorCrossLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected VectorCrossLayerItem(long j, boolean z) {
        this(new VectorCrossLayerItemRouter("VectorCrossLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IVectorCrossLayerItem.class}, new Object[]{this});
    }

    public VectorCrossLayerItem() {
        this(new VectorCrossLayerItemRouter("VectorCrossLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IVectorCrossLayerItem.class}, new Object[]{this});
    }

    public VectorCrossLayerItem(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        super(vectorCrossLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(vectorCrossLayerItemImpl);
    }

    private void $constructor(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        if (vectorCrossLayerItemImpl != null) {
            this.mService = vectorCrossLayerItemImpl;
            this.mTargetId = String.format("VectorCrossLayerItem_%s_%d", String.valueOf(VectorCrossLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public VectorCrossLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.VectorCrossLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.VectorCrossLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.VectorCrossLayerItem.3
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
        return VectorCrossLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            vectorCrossLayerItemImpl.$explicit_updateStyle();
        }
    }

    public void setVectorCar(Coord3DDouble coord3DDouble, int i) {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            vectorCrossLayerItemImpl.$explicit_setVectorCar(coord3DDouble, i);
        }
    }

    public int showVectorCross(byte[] bArr) {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            return vectorCrossLayerItemImpl.$explicit_showVectorCross(bArr);
        }
        return 0;
    }

    public void setPriority(LayerPriority layerPriority) {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            vectorCrossLayerItemImpl.$explicit_setPriority(layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void setVisible(boolean z) {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            vectorCrossLayerItemImpl.$explicit_setVisible(z);
        }
    }

    public void clearAll() {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            vectorCrossLayerItemImpl.$explicit_clearAll();
        }
    }

    public void setViewPostureEvent(@VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            vectorCrossLayerItemImpl.$explicit_setViewPostureEvent(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        VectorCrossLayerItemImpl vectorCrossLayerItemImpl = this.mService;
        if (vectorCrossLayerItemImpl != null) {
            return vectorCrossLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }
}
