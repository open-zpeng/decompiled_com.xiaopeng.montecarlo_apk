package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RoutePathPointItem;
import com.autonavi.gbl.layer.impl.RoutePathPointItemImpl;
import com.autonavi.gbl.layer.model.BizRouteMapMode;
import com.autonavi.gbl.layer.observer.IRoutePathPointItem;
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
@IntfAuto(target = RoutePathPointItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RoutePathPointItemRouter extends RoutePathPointItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RoutePathPointItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RoutePathPointItemRouter.class);
    private TypeHelper mHelper;
    private IRoutePathPointItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRoutePathPointItem iRoutePathPointItem) {
        if (iRoutePathPointItem != null) {
            this.mObserver = iRoutePathPointItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RoutePathPointItem.class, iRoutePathPointItem, this);
            }
        }
    }

    private void $constructor(String str, IRoutePathPointItem iRoutePathPointItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RoutePathPointItemImpl.getCPtr((RoutePathPointItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRoutePathPointItem);
    }

    public RoutePathPointItemRouter(String str, IRoutePathPointItem iRoutePathPointItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRoutePathPointItem);
    }

    public RoutePathPointItemRouter(String str, IRoutePathPointItem iRoutePathPointItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRoutePathPointItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RoutePathPointItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RoutePathPointItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl
    public boolean getMIsNavi() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getMIsNavi();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl
    public boolean getIsInEndFloor() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getIsInEndFloor();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl
    @BizRouteMapMode.BizRouteMapMode1
    public int getMMode() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getMMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl
    @RouteLayerScene.RouteLayerScene1
    public int getMScene() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getMScene();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl
    @PathPointType.PathPointType1
    public int getMType() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl
    public int getMLeftEnergy() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.RoutePathPointItemImpl
    public int getMTotalCount() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getMTotalCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iRoutePathPointItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iRoutePathPointItem.getRotateCenter3D(), coord3DDouble);
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
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iRoutePathPointItem.getPosition(), coord3DDouble);
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
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iRoutePathPointItem.getNormalStyle(), pointLayerItemStyle);
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
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iRoutePathPointItem.getFocusStyle(), pointLayerItemStyle);
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
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iRoutePathPointItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            try {
                TypeUtil.deepcopy(iRoutePathPointItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            iRoutePathPointItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            iRoutePathPointItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            iRoutePathPointItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            iRoutePathPointItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            return iRoutePathPointItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRoutePathPointItem iRoutePathPointItem = this.mObserver;
        if (iRoutePathPointItem != null) {
            iRoutePathPointItem.setAreaCollision(z);
        }
    }
}
