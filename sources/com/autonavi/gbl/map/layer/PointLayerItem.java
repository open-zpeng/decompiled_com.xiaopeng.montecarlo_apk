package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ForeshorteningCoefParam;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.ItemMarkerInfo;
import com.autonavi.gbl.map.layer.model.LayerItemPoiAnimation;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.PointLayerItemType;
import com.autonavi.gbl.map.layer.model.RotateMode;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.ScalePriority;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.router.PointLayerItemRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = PointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class PointLayerItem extends LayerItem implements IPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(PointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private PointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PointLayerItem(long j, boolean z) {
        this(new PointLayerItemRouter("PointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPointLayerItem.class}, new Object[]{this});
    }

    public PointLayerItem() {
        this(new PointLayerItemRouter("PointLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPointLayerItem.class}, new Object[]{this});
    }

    public PointLayerItem(@PointLayerItemType.PointLayerItemType1 int i) {
        this(new PointLayerItemRouter("PointLayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPointLayerItem.class}, new Object[]{this});
    }

    public PointLayerItem(PointLayerItemImpl pointLayerItemImpl) {
        super(pointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(pointLayerItemImpl);
    }

    private void $constructor(PointLayerItemImpl pointLayerItemImpl) {
        if (pointLayerItemImpl != null) {
            this.mService = pointLayerItemImpl;
            this.mTargetId = String.format("PointLayerItem_%s_%d", String.valueOf(PointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public PointLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.PointLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.PointLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.PointLayerItem.3
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
        return PointLayerItemImpl.getClassTypeName();
    }

    public void setVisible3V(Visible3V visible3V) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setVisible3V(visible3V);
        }
    }

    public void setBillboard(boolean z) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setBillboard(z);
        }
    }

    public void setPosition3D(Coord3DDouble coord3DDouble) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setPosition3D(coord3DDouble);
        }
    }

    public void setRotateCenter3D(Coord3DDouble coord3DDouble) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setRotateCenter3D(coord3DDouble);
        }
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setPosition(coord3DDouble);
        }
    }

    public void setRotateCenter(Coord3DDouble coord3DDouble) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setRotateCenter(coord3DDouble);
        }
    }

    public void setItemVisibleRegion(RectInt rectInt) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setItemVisibleRegion(rectInt);
        }
    }

    public void setItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setItemIgnoreRegion(itemIgnoreRegion);
        }
    }

    public void setScale(@ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setScale(i, scaleInfo);
        }
    }

    public void setPointTypeCode(String str) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setPointTypeCode(str);
        }
    }

    public void setScaleFactor(float[] fArr) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setScaleFactor(fArr);
        }
    }

    public void setRotateMode(@RotateMode.RotateMode1 int i) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setRotateMode(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void setAnimation(@LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setAnimation(i, i2);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_updateStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle(LayerItem layerItem) {
        try {
            Method method = PointLayerItem.class.getMethod("updateStyle", LayerItem.class);
            if (layerItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (LayerItemImpl) typeHelper.transfer(method, 0, layerItem) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.PointLayerItem.4
                    }));
                }
            }
            PointLayerItemImpl pointLayerItemImpl = this.mService;
            if (pointLayerItemImpl != null) {
                pointLayerItemImpl.$explicit_updateStyle(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void addPoiFilter() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_addPoiFilter();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void removePoiFilter() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_removePoiFilter();
        }
    }

    public boolean addMarker(ItemMarkerInfo itemMarkerInfo) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            return pointLayerItemImpl.$explicit_addMarker(itemMarkerInfo);
        }
        return false;
    }

    public void clearAllMarkers() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_clearAllMarkers();
        }
    }

    public void setForeshorteningCoef(boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_setForeshorteningCoef(z, foreshorteningCoefParam);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            return pointLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public Visible3V getVisible3V() {
        Visible3V visible3V = new Visible3V();
        getVisible3V(visible3V);
        return visible3V;
    }

    private void getVisible3V(Visible3V visible3V) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_getVisible3V(visible3V);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public boolean getBillboard() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            return pointLayerItemImpl.$explicit_getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public Coord3DDouble getRotateCenter3D() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getRotateCenter3D(coord3DDouble);
        return coord3DDouble;
    }

    private void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_getRotateCenter3D(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public Coord3DDouble getPosition() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getPosition(coord3DDouble);
        return coord3DDouble;
    }

    private void getPosition(Coord3DDouble coord3DDouble) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_getPosition(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public PointLayerItemStyle getNormalStyle() {
        PointLayerItemStyle pointLayerItemStyle = new PointLayerItemStyle();
        getNormalStyle(pointLayerItemStyle);
        return pointLayerItemStyle;
    }

    private void getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_getNormalStyle(pointLayerItemStyle);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public PointLayerItemStyle getFocusStyle() {
        PointLayerItemStyle pointLayerItemStyle = new PointLayerItemStyle();
        getFocusStyle(pointLayerItemStyle);
        return pointLayerItemStyle;
    }

    private void getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_getFocusStyle(pointLayerItemStyle);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public ItemIgnoreRegion getItemIgnoreRegion() {
        ItemIgnoreRegion itemIgnoreRegion = new ItemIgnoreRegion();
        getItemIgnoreRegion(itemIgnoreRegion);
        return itemIgnoreRegion;
    }

    private void getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_getItemIgnoreRegion(itemIgnoreRegion);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public ScaleAttribute getScale() {
        ScaleAttribute scaleAttribute = new ScaleAttribute();
        getScale(scaleAttribute);
        return scaleAttribute;
    }

    private void getScale(ScaleAttribute scaleAttribute) {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            pointLayerItemImpl.$explicit_getScale(scaleAttribute);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public String getPointTypeCode() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            return pointLayerItemImpl.$explicit_getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public ArrayList<PixelPoint> getBound() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            return pointLayerItemImpl.$explicit_getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem
    public float getForeshorteningCoef() {
        PointLayerItemImpl pointLayerItemImpl = this.mService;
        if (pointLayerItemImpl != null) {
            return pointLayerItemImpl.$explicit_getForeshorteningCoef();
        }
        return 0.0f;
    }
}
