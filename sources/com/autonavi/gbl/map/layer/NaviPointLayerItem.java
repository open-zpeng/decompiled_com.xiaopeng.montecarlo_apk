package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.ItemMarkerInfo;
import com.autonavi.gbl.map.layer.model.LayerItemPoiAnimation;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.RotateMode;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.INaviPointLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.router.NaviPointLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = NaviPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class NaviPointLayerItem extends LayerItem implements INaviPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(NaviPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private NaviPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected NaviPointLayerItem(long j, boolean z) {
        this(new NaviPointLayerItemRouter("NaviPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{INaviPointLayerItem.class}, new Object[]{this});
    }

    public NaviPointLayerItem() {
        this(new NaviPointLayerItemRouter("NaviPointLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{INaviPointLayerItem.class}, new Object[]{this});
    }

    public NaviPointLayerItem(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        super(naviPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(naviPointLayerItemImpl);
    }

    private void $constructor(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        if (naviPointLayerItemImpl != null) {
            this.mService = naviPointLayerItemImpl;
            this.mTargetId = String.format("NaviPointLayerItem_%s_%d", String.valueOf(NaviPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public NaviPointLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.NaviPointLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.NaviPointLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.NaviPointLayerItem.3
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
        return NaviPointLayerItemImpl.getClassTypeName();
    }

    public void setDepthMask(boolean z) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setDepthMask(z);
        }
    }

    public void setResolveConflict(boolean z) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setResolveConflict(z);
        }
    }

    public void setVisible3V(Visible3V visible3V) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setVisible3V(visible3V);
        }
    }

    public void setBillboard(boolean z) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setBillboard(z);
        }
    }

    public void setPosition3D(Coord3DDouble coord3DDouble) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setPosition3D(coord3DDouble);
        }
    }

    public void setRotateCenter3D(Coord3DDouble coord3DDouble) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setRotateCenter3D(coord3DDouble);
        }
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setPosition(coord3DDouble);
        }
    }

    public void setRotateCenter(Coord3DDouble coord3DDouble) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setRotateCenter(coord3DDouble);
        }
    }

    public void setItemVisibleRegion(RectInt rectInt) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setItemVisibleRegion(rectInt);
        }
    }

    public void setItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setItemIgnoreRegion(itemIgnoreRegion);
        }
    }

    public void setScaleFactor(float[] fArr) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setScaleFactor(fArr);
        }
    }

    public void setScale(ScaleInfo scaleInfo) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setScale(scaleInfo);
        }
    }

    public void setRotateMode(@RotateMode.RotateMode1 int i) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setRotateMode(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void setAnimation(@LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_setAnimation(i, i2);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_updateStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void addPoiFilter() {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_addPoiFilter();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void removePoiFilter() {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_removePoiFilter();
        }
    }

    public boolean addMarker(ItemMarkerInfo itemMarkerInfo) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            return naviPointLayerItemImpl.$explicit_addMarker(itemMarkerInfo);
        }
        return false;
    }

    public void clearAllMarkers() {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_clearAllMarkers();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            return naviPointLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public Visible3V getVisible3V() {
        Visible3V visible3V = new Visible3V();
        getVisible3V(visible3V);
        return visible3V;
    }

    private void getVisible3V(Visible3V visible3V) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getVisible3V(visible3V);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public boolean getBillboard() {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            return naviPointLayerItemImpl.$explicit_getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public Coord3DDouble getPosition3D() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getPosition3D(coord3DDouble);
        return coord3DDouble;
    }

    private void getPosition3D(Coord3DDouble coord3DDouble) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getPosition3D(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public Coord3DDouble getRotateCenter3D() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getRotateCenter3D(coord3DDouble);
        return coord3DDouble;
    }

    private void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getRotateCenter3D(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public Coord3DDouble getPosition() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getPosition(coord3DDouble);
        return coord3DDouble;
    }

    private void getPosition(Coord3DDouble coord3DDouble) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getPosition(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public PointLayerItemStyle getNormalStyle() {
        PointLayerItemStyle pointLayerItemStyle = new PointLayerItemStyle();
        getNormalStyle(pointLayerItemStyle);
        return pointLayerItemStyle;
    }

    private void getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getNormalStyle(pointLayerItemStyle);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public PointLayerItemStyle getFocusStyle() {
        PointLayerItemStyle pointLayerItemStyle = new PointLayerItemStyle();
        getFocusStyle(pointLayerItemStyle);
        return pointLayerItemStyle;
    }

    private void getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getFocusStyle(pointLayerItemStyle);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public RectInt getItemVisibleRegion() {
        RectInt rectInt = new RectInt();
        getItemVisibleRegion(rectInt);
        return rectInt;
    }

    private void getItemVisibleRegion(RectInt rectInt) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getItemVisibleRegion(rectInt);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public ItemIgnoreRegion getItemIgnoreRegion() {
        ItemIgnoreRegion itemIgnoreRegion = new ItemIgnoreRegion();
        getItemIgnoreRegion(itemIgnoreRegion);
        return itemIgnoreRegion;
    }

    private void getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getItemIgnoreRegion(itemIgnoreRegion);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.INaviPointLayerItem
    public ScaleInfo getScale() {
        ScaleInfo scaleInfo = new ScaleInfo();
        getScale(scaleInfo);
        return scaleInfo;
    }

    private void getScale(ScaleInfo scaleInfo) {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            naviPointLayerItemImpl.$explicit_getScale(scaleInfo);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public ArrayList<PixelPoint> getBound() {
        NaviPointLayerItemImpl naviPointLayerItemImpl = this.mService;
        if (naviPointLayerItemImpl != null) {
            return naviPointLayerItemImpl.$explicit_getBound();
        }
        return null;
    }
}
