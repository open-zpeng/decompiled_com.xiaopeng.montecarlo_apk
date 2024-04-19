package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.GuideFamiliarRouteLayerItem;
import com.autonavi.gbl.layer.impl.GuideFamiliarRouteLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideFamiliarRouteLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideFamiliarRouteLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideFamiliarRouteLayerItemRouter extends GuideFamiliarRouteLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideFamiliarRouteLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideFamiliarRouteLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideFamiliarRouteLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem) {
        if (iGuideFamiliarRouteLayerItem != null) {
            this.mObserver = iGuideFamiliarRouteLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideFamiliarRouteLayerItem.class, iGuideFamiliarRouteLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideFamiliarRouteLayerItemImpl.getCPtr((GuideFamiliarRouteLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideFamiliarRouteLayerItem);
    }

    public GuideFamiliarRouteLayerItemRouter(String str, IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideFamiliarRouteLayerItem);
    }

    public GuideFamiliarRouteLayerItemRouter(String str, IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideFamiliarRouteLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideFamiliarRouteLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.GuideFamiliarRouteLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideFamiliarRouteLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideFamiliarRouteLayerItemImpl
    public long getPathId() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideFamiliarRouteLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getBoardStyle() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getBoardStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFamiliarRouteLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFamiliarRouteLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFamiliarRouteLayerItem.getPosition(), coord3DDouble);
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
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFamiliarRouteLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFamiliarRouteLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFamiliarRouteLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideFamiliarRouteLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            iGuideFamiliarRouteLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            iGuideFamiliarRouteLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            iGuideFamiliarRouteLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            iGuideFamiliarRouteLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            return iGuideFamiliarRouteLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideFamiliarRouteLayerItem iGuideFamiliarRouteLayerItem = this.mObserver;
        if (iGuideFamiliarRouteLayerItem != null) {
            iGuideFamiliarRouteLayerItem.setAreaCollision(z);
        }
    }
}
