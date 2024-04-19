package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.LaneRoutePathPointItem;
import com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl;
import com.autonavi.gbl.layer.model.BizRouteMapMode;
import com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PathPointType;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneRoutePathPointItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneRoutePathPointItemRouter extends LaneRoutePathPointItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneRoutePathPointItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneRoutePathPointItemRouter.class);
    private TypeHelper mHelper;
    private ILaneRoutePathPointItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneRoutePathPointItem iLaneRoutePathPointItem) {
        if (iLaneRoutePathPointItem != null) {
            this.mObserver = iLaneRoutePathPointItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneRoutePathPointItem.class, iLaneRoutePathPointItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneRoutePathPointItem iLaneRoutePathPointItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneRoutePathPointItemImpl.getCPtr((LaneRoutePathPointItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneRoutePathPointItem);
    }

    public LaneRoutePathPointItemRouter(String str, ILaneRoutePathPointItem iLaneRoutePathPointItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneRoutePathPointItem);
    }

    public LaneRoutePathPointItemRouter(String str, ILaneRoutePathPointItem iLaneRoutePathPointItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneRoutePathPointItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneRoutePathPointItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneRoutePathPointItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl
    public boolean getMIsNavi() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getMIsNavi();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl
    @BizRouteMapMode.BizRouteMapMode1
    public int getMMode() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getMMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl
    @RouteLayerScene.RouteLayerScene1
    public int getMScene() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getMScene();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl
    @PathPointType.PathPointType1
    public int getMType() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl
    public int getMLeftEnergy() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl
    public int getMTotalCount() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getMTotalCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iLaneRoutePathPointItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iLaneRoutePathPointItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iLaneRoutePathPointItem.getPosition(), coord3DDouble);
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
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iLaneRoutePathPointItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iLaneRoutePathPointItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iLaneRoutePathPointItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iLaneRoutePathPointItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            iLaneRoutePathPointItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            iLaneRoutePathPointItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            iLaneRoutePathPointItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            iLaneRoutePathPointItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            return iLaneRoutePathPointItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneRoutePathPointItem iLaneRoutePathPointItem = this.mObserver;
        if (iLaneRoutePathPointItem != null) {
            iLaneRoutePathPointItem.setAreaCollision(z);
        }
    }
}
