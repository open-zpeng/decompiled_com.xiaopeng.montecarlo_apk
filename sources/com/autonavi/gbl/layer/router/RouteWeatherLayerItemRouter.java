package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RouteWeatherLayerItem;
import com.autonavi.gbl.layer.impl.RouteWeatherLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteWeatherLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.route.model.WeatherLabelItem;
import java.util.ArrayList;
@IntfAuto(target = RouteWeatherLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteWeatherLayerItemRouter extends RouteWeatherLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteWeatherLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteWeatherLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteWeatherLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteWeatherLayerItem iRouteWeatherLayerItem) {
        if (iRouteWeatherLayerItem != null) {
            this.mObserver = iRouteWeatherLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteWeatherLayerItem.class, iRouteWeatherLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteWeatherLayerItem iRouteWeatherLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteWeatherLayerItemImpl.getCPtr((RouteWeatherLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteWeatherLayerItem);
    }

    public RouteWeatherLayerItemRouter(String str, IRouteWeatherLayerItem iRouteWeatherLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteWeatherLayerItem);
    }

    public RouteWeatherLayerItemRouter(String str, IRouteWeatherLayerItem iRouteWeatherLayerItem, WeatherLabelItem weatherLabelItem) {
        super(weatherLabelItem);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteWeatherLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteWeatherLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteWeatherLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteWeatherLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteWeatherLayerItemImpl
    public WeatherLabelItem getMWeatherInfo() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getMWeatherInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteWeatherLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteWeatherLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteWeatherLayerItem.getPosition(), coord3DDouble);
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
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteWeatherLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteWeatherLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteWeatherLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteWeatherLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            iRouteWeatherLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            iRouteWeatherLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            iRouteWeatherLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            iRouteWeatherLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            return iRouteWeatherLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteWeatherLayerItem iRouteWeatherLayerItem = this.mObserver;
        if (iRouteWeatherLayerItem != null) {
            iRouteWeatherLayerItem.setAreaCollision(z);
        }
    }
}
