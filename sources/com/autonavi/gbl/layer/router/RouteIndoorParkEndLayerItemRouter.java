package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RouteIndoorParkEndLayerItem;
import com.autonavi.gbl.layer.impl.RouteIndoorParkEndLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteIndoorParkEndLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteIndoorParkEndLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteIndoorParkEndLayerItemRouter extends RouteIndoorParkEndLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteIndoorParkEndLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteIndoorParkEndLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteIndoorParkEndLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem) {
        if (iRouteIndoorParkEndLayerItem != null) {
            this.mObserver = iRouteIndoorParkEndLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteIndoorParkEndLayerItem.class, iRouteIndoorParkEndLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteIndoorParkEndLayerItemImpl.getCPtr((RouteIndoorParkEndLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteIndoorParkEndLayerItem);
    }

    public RouteIndoorParkEndLayerItemRouter(String str, IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteIndoorParkEndLayerItem);
    }

    public RouteIndoorParkEndLayerItemRouter(String str, IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteIndoorParkEndLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteIndoorParkEndLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkEndLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteIndoorParkEndLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkEndLayerItemImpl
    public int getFloorNumber() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getFloorNumber();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkEndLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkEndLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkEndLayerItem.getPosition(), coord3DDouble);
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
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkEndLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkEndLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkEndLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkEndLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            iRouteIndoorParkEndLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            iRouteIndoorParkEndLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            iRouteIndoorParkEndLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            iRouteIndoorParkEndLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            return iRouteIndoorParkEndLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteIndoorParkEndLayerItem iRouteIndoorParkEndLayerItem = this.mObserver;
        if (iRouteIndoorParkEndLayerItem != null) {
            iRouteIndoorParkEndLayerItem.setAreaCollision(z);
        }
    }
}
