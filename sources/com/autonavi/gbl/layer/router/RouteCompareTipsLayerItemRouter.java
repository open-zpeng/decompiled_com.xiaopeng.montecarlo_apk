package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RouteCompareTipsLayerItem;
import com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteCompareTipsLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteCompareTipsLayerItemRouter extends RouteCompareTipsLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteCompareTipsLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteCompareTipsLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteCompareTipsLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem) {
        if (iRouteCompareTipsLayerItem != null) {
            this.mObserver = iRouteCompareTipsLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteCompareTipsLayerItem.class, iRouteCompareTipsLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteCompareTipsLayerItemImpl.getCPtr((RouteCompareTipsLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteCompareTipsLayerItem);
    }

    public RouteCompareTipsLayerItemRouter(String str, IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteCompareTipsLayerItem);
    }

    public RouteCompareTipsLayerItemRouter(String str, IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem, boolean z, String str2) {
        super(z, str2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteCompareTipsLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteCompareTipsLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteCompareTipsLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl
    public boolean getMIsNewRoute() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getMIsNewRoute();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl
    public String getMTipName() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getMTipName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteCompareTipsLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteCompareTipsLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteCompareTipsLayerItem.getPosition(), coord3DDouble);
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
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteCompareTipsLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteCompareTipsLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteCompareTipsLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteCompareTipsLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.setAreaCollision(z);
        }
    }
}
