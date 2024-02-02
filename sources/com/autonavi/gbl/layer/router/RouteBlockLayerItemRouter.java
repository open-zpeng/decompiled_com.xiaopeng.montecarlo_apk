package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.EventCloudControl;
import com.autonavi.gbl.layer.RouteBlockLayerItem;
import com.autonavi.gbl.layer.impl.RouteBlockLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteBlockLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteBlockLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class RouteBlockLayerItemRouter extends RouteBlockLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteBlockLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteBlockLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteBlockLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteBlockLayerItem iRouteBlockLayerItem) {
        if (iRouteBlockLayerItem != null) {
            this.mObserver = iRouteBlockLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteBlockLayerItem.class, iRouteBlockLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteBlockLayerItem iRouteBlockLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteBlockLayerItemImpl.getCPtr((RouteBlockLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteBlockLayerItem);
    }

    public RouteBlockLayerItemRouter(String str, IRouteBlockLayerItem iRouteBlockLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteBlockLayerItem);
    }

    public RouteBlockLayerItemRouter(String str, IRouteBlockLayerItem iRouteBlockLayerItem, EventCloudControl eventCloudControl) {
        super(eventCloudControl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteBlockLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteBlockLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteBlockLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteBlockLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteBlockLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            iRouteBlockLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.RouteBlockLayerItemImpl
    public EventCloudControl getMEventCloud() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getMEventCloud();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteBlockLayerItemImpl
    public boolean getMbEnableCollision() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getMbEnableCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteBlockLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteBlockLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteBlockLayerItem.getPosition(), coord3DDouble);
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
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteBlockLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteBlockLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteBlockLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteBlockLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            iRouteBlockLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            return iRouteBlockLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteBlockLayerItem iRouteBlockLayerItem = this.mObserver;
        if (iRouteBlockLayerItem != null) {
            iRouteBlockLayerItem.setAreaCollision(z);
        }
    }
}
