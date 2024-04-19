package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.FacilityType;
import com.autonavi.gbl.layer.GuideFacilityLayerItem;
import com.autonavi.gbl.layer.impl.GuideFacilityLayerItemImpl;
import com.autonavi.gbl.layer.observer.IGuideFacilityLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideFacilityLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideFacilityLayerItemRouter extends GuideFacilityLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideFacilityLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideFacilityLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideFacilityLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideFacilityLayerItem iGuideFacilityLayerItem) {
        if (iGuideFacilityLayerItem != null) {
            this.mObserver = iGuideFacilityLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideFacilityLayerItem.class, iGuideFacilityLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideFacilityLayerItem iGuideFacilityLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideFacilityLayerItemImpl.getCPtr((GuideFacilityLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideFacilityLayerItem);
    }

    public GuideFacilityLayerItemRouter(String str, IGuideFacilityLayerItem iGuideFacilityLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideFacilityLayerItem);
    }

    public GuideFacilityLayerItemRouter(String str, IGuideFacilityLayerItem iGuideFacilityLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideFacilityLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideFacilityLayerItemRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.GuideFacilityLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideFacilityLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideFacilityLayerItemImpl
    public int getMDistance() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideFacilityLayerItemImpl
    @FacilityType.FacilityType1
    public int getMType() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFacilityLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFacilityLayerItem.getRotateCenter3D(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getRotateCenter3D copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getPosition(Coord3DDouble coord3DDouble) {
        $wrapper_getPosition(coord3DDouble);
    }

    private void $wrapper_getPosition(Coord3DDouble coord3DDouble) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFacilityLayerItem.getPosition(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getPosition copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        $wrapper_getNormalStyle(pointLayerItemStyle);
    }

    private void $wrapper_getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFacilityLayerItem.getNormalStyle(), pointLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getNormalStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        $wrapper_getFocusStyle(pointLayerItemStyle);
    }

    private void $wrapper_getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFacilityLayerItem.getFocusStyle(), pointLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getFocusStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        $wrapper_getItemIgnoreRegion(itemIgnoreRegion);
    }

    private void $wrapper_getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFacilityLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
            } catch (Exception unused) {
                DebugTool.e("getItemIgnoreRegion copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getScale(ScaleAttribute scaleAttribute) {
        $wrapper_getScale(scaleAttribute);
    }

    private void $wrapper_getScale(ScaleAttribute scaleAttribute) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFacilityLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            iGuideFacilityLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            iGuideFacilityLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            iGuideFacilityLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            iGuideFacilityLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            return iGuideFacilityLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideFacilityLayerItem iGuideFacilityLayerItem = this.mObserver;
        if (iGuideFacilityLayerItem != null) {
            iGuideFacilityLayerItem.setAreaCollision(z);
        }
    }
}
