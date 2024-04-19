package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.ViaRoadInfo;
import com.autonavi.gbl.layer.RouteViaRoadLayerItem;
import com.autonavi.gbl.layer.impl.RouteViaRoadLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IRouteViaRoadLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteViaRoadLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteViaRoadLayerItemRouter extends RouteViaRoadLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteViaRoadLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteViaRoadLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteViaRoadLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteViaRoadLayerItem iRouteViaRoadLayerItem) {
        if (iRouteViaRoadLayerItem != null) {
            this.mObserver = iRouteViaRoadLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteViaRoadLayerItem.class, iRouteViaRoadLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteViaRoadLayerItem iRouteViaRoadLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteViaRoadLayerItemImpl.getCPtr((RouteViaRoadLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteViaRoadLayerItem);
    }

    public RouteViaRoadLayerItemRouter(String str, IRouteViaRoadLayerItem iRouteViaRoadLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteViaRoadLayerItem);
    }

    public RouteViaRoadLayerItemRouter(String str, IRouteViaRoadLayerItem iRouteViaRoadLayerItem, ViaRoadInfo viaRoadInfo, @BizDirectionStyle.BizDirectionStyle1 int i) {
        super(viaRoadInfo, i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteViaRoadLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteViaRoadLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteViaRoadLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteViaRoadLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteViaRoadLayerItemImpl
    public ViaRoadInfo getMViaRoadInfo() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getMViaRoadInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteViaRoadLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteViaRoadLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteViaRoadLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteViaRoadLayerItem.getPosition(), coord3DDouble);
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
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteViaRoadLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteViaRoadLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteViaRoadLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteViaRoadLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            iRouteViaRoadLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            iRouteViaRoadLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            iRouteViaRoadLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            iRouteViaRoadLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            return iRouteViaRoadLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteViaRoadLayerItem iRouteViaRoadLayerItem = this.mObserver;
        if (iRouteViaRoadLayerItem != null) {
            iRouteViaRoadLayerItem.setAreaCollision(z);
        }
    }
}
