package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ActionLastDesc;
import com.autonavi.gbl.map.layer.model.ActionPlayDesc;
import com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem;
import com.autonavi.gbl.map.model.Point3F;
import com.autonavi.gbl.map.router.SkeletonLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = SkeletonLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class SkeletonLayerItem extends LayerItem implements ISkeletonLayerItem {
    private static String PACKAGE = ReflexTool.PN(SkeletonLayerItem.class);
    private boolean mHasDestroy;
    private SkeletonLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SkeletonLayerItem(long j, boolean z) {
        this(new SkeletonLayerItemRouter("SkeletonLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISkeletonLayerItem.class}, new Object[]{this});
    }

    public SkeletonLayerItem(MapView mapView) {
        this(new SkeletonLayerItemRouter("SkeletonLayerItem", null, (MapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISkeletonLayerItem.class}, new Object[]{this});
    }

    public SkeletonLayerItem(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        super(skeletonLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(skeletonLayerItemImpl);
    }

    private void $constructor(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        if (skeletonLayerItemImpl != null) {
            this.mService = skeletonLayerItemImpl;
            this.mTargetId = String.format("SkeletonLayerItem_%s_%d", String.valueOf(SkeletonLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public SkeletonLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.SkeletonLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.SkeletonLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.SkeletonLayerItem.3
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

    public void setPosition(Coord3DDouble coord3DDouble) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_setPosition(coord3DDouble);
        }
    }

    public void setBinaryData(byte[] bArr, int i) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_setBinaryData(bArr, i);
        }
    }

    public boolean setActionPlayList(ArrayList<ActionPlayDesc> arrayList) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            return skeletonLayerItemImpl.$explicit_setActionPlayList(arrayList);
        }
        return false;
    }

    public void setRotateAngles(float f, float f2, float f3) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_setRotateAngles(f, f2, f3);
        }
    }

    public void setScaleRation(float f) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_setScaleRation(f);
        }
    }

    public void setRotateWithMap(boolean z) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_setRotateWithMap(z);
        }
    }

    public void setScaleWithMap(boolean z) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_setScaleWithMap(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem
    public Coord3DDouble getPosition() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getPosition(coord3DDouble);
        return coord3DDouble;
    }

    private void getPosition(Coord3DDouble coord3DDouble) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_getPosition(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem
    public void onPaint() {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem
    public ArrayList<ActionLastDesc> getActionList() {
        ArrayList<ActionLastDesc> arrayList = new ArrayList<>();
        getActionList(arrayList);
        return arrayList;
    }

    private void getActionList(ArrayList<ActionLastDesc> arrayList) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_getActionList(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem
    public String getCurrentAction() {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            return skeletonLayerItemImpl.$explicit_getCurrentAction();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem
    public float getScaleRation() {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            return skeletonLayerItemImpl.$explicit_getScaleRation();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem
    public RectDouble getScreenBound() {
        RectDouble rectDouble = new RectDouble();
        getScreenBound(rectDouble);
        return rectDouble;
    }

    private void getScreenBound(RectDouble rectDouble) {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            skeletonLayerItemImpl.$explicit_getScreenBound(rectDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem
    public Point3F getRotateAngles() {
        SkeletonLayerItemImpl skeletonLayerItemImpl = this.mService;
        if (skeletonLayerItemImpl != null) {
            return skeletonLayerItemImpl.$explicit_getRotateAngles();
        }
        return null;
    }
}
