package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.layer.impl.RouteTrafficEventTipsLayerItemImpl;
import com.autonavi.gbl.layer.model.RouteTrafficEventTipsPoint;
import com.autonavi.gbl.layer.observer.IRouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteTrafficEventTipsLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteTrafficEventTipsLayerItemRouter extends RouteTrafficEventTipsLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteTrafficEventTipsLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteTrafficEventTipsLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteTrafficEventTipsLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem) {
        if (iRouteTrafficEventTipsLayerItem != null) {
            this.mObserver = iRouteTrafficEventTipsLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteTrafficEventTipsLayerItem.class, iRouteTrafficEventTipsLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteTrafficEventTipsLayerItemImpl.getCPtr((RouteTrafficEventTipsLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteTrafficEventTipsLayerItem);
    }

    public RouteTrafficEventTipsLayerItemRouter(String str, IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteTrafficEventTipsLayerItem);
    }

    public RouteTrafficEventTipsLayerItemRouter(String str, IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem, RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        super(routeTrafficEventTipsPoint);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteTrafficEventTipsLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.RouteTrafficEventTipsLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteTrafficEventTipsLayerItemImpl
    public RouteTrafficEventTipsPoint getMTrafficEventTipsInfo() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getMTrafficEventTipsInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteTrafficEventTipsLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteTrafficEventTipsLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteTrafficEventTipsLayerItem.getPosition(), coord3DDouble);
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
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteTrafficEventTipsLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteTrafficEventTipsLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteTrafficEventTipsLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteTrafficEventTipsLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            iRouteTrafficEventTipsLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            iRouteTrafficEventTipsLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            iRouteTrafficEventTipsLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            iRouteTrafficEventTipsLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            iRouteTrafficEventTipsLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IRouteTrafficEventTipsLayerItem iRouteTrafficEventTipsLayerItem = this.mObserver;
        if (iRouteTrafficEventTipsLayerItem != null) {
            return iRouteTrafficEventTipsLayerItem.canAreaCollision();
        }
        return false;
    }
}
