package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RestAreaInfo;
import com.autonavi.gbl.layer.RouteRestAreaLayerItem;
import com.autonavi.gbl.layer.impl.RouteRestAreaLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteRestAreaLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteRestAreaLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class RouteRestAreaLayerItemRouter extends RouteRestAreaLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteRestAreaLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteRestAreaLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteRestAreaLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteRestAreaLayerItem iRouteRestAreaLayerItem) {
        if (iRouteRestAreaLayerItem != null) {
            this.mObserver = iRouteRestAreaLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteRestAreaLayerItem.class, iRouteRestAreaLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteRestAreaLayerItem iRouteRestAreaLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteRestAreaLayerItemImpl.getCPtr((RouteRestAreaLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteRestAreaLayerItem);
    }

    public RouteRestAreaLayerItemRouter(String str, IRouteRestAreaLayerItem iRouteRestAreaLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteRestAreaLayerItem);
    }

    public RouteRestAreaLayerItemRouter(String str, IRouteRestAreaLayerItem iRouteRestAreaLayerItem, RestAreaInfo restAreaInfo) {
        super(restAreaInfo);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteRestAreaLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteRestAreaLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteRestAreaLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteRestAreaLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteRestAreaLayerItemImpl
    public RestAreaInfo getMRestAreaInfo() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getMRestAreaInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteRestAreaLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteRestAreaLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteRestAreaLayerItem.getPosition(), coord3DDouble);
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
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteRestAreaLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteRestAreaLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteRestAreaLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteRestAreaLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            iRouteRestAreaLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            iRouteRestAreaLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            return iRouteRestAreaLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteRestAreaLayerItem iRouteRestAreaLayerItem = this.mObserver;
        if (iRouteRestAreaLayerItem != null) {
            iRouteRestAreaLayerItem.setAreaCollision(z);
        }
    }
}
