package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.RouteJamPointLayerItem;
import com.autonavi.gbl.layer.impl.RouteJamPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteJamPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteJamPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteJamPointLayerItemRouter extends RouteJamPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteJamPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteJamPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteJamPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteJamPointLayerItem iRouteJamPointLayerItem) {
        if (iRouteJamPointLayerItem != null) {
            this.mObserver = iRouteJamPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteJamPointLayerItem.class, iRouteJamPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteJamPointLayerItem iRouteJamPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteJamPointLayerItemImpl.getCPtr((RouteJamPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteJamPointLayerItem);
    }

    public RouteJamPointLayerItemRouter(String str, IRouteJamPointLayerItem iRouteJamPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteJamPointLayerItem);
    }

    public RouteJamPointLayerItemRouter(String str, IRouteJamPointLayerItem iRouteJamPointLayerItem, AvoidJamCloudControl avoidJamCloudControl) {
        super(avoidJamCloudControl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteJamPointLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteJamPointLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteJamPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteJamPointLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            iRouteJamPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamPointLayerItemImpl
    public AvoidJamCloudControl getMAvoidJamCloud() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getMAvoidJamCloud();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamPointLayerItemImpl
    public boolean getMbEnableCollision() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getMbEnableCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamPointLayerItem.getPosition(), coord3DDouble);
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
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            iRouteJamPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            iRouteJamPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            iRouteJamPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            return iRouteJamPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteJamPointLayerItem iRouteJamPointLayerItem = this.mObserver;
        if (iRouteJamPointLayerItem != null) {
            iRouteJamPointLayerItem.setAreaCollision(z);
        }
    }
}
