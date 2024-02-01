package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RouteIndoorParkLayerItem;
import com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IRouteIndoorParkLayerItem;
import com.autonavi.gbl.map.layer.model.IntersectValueType;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteIndoorParkLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteIndoorParkLayerItemRouter extends RouteIndoorParkLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteIndoorParkLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteIndoorParkLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteIndoorParkLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem) {
        if (iRouteIndoorParkLayerItem != null) {
            this.mObserver = iRouteIndoorParkLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteIndoorParkLayerItem.class, iRouteIndoorParkLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteIndoorParkLayerItemImpl.getCPtr((RouteIndoorParkLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteIndoorParkLayerItem);
    }

    public RouteIndoorParkLayerItemRouter(String str, IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteIndoorParkLayerItem);
    }

    public RouteIndoorParkLayerItemRouter(String str, IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteIndoorParkLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl
    public long getPathID() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl
    public int getToFloorNumber() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getToFloorNumber();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl
    public int getCurFloorNumber() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getCurFloorNumber();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl
    public boolean getIsUpstairs() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getIsUpstairs();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getBoardStyle() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getBoardStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkLayerItem.getPosition(), coord3DDouble);
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
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteIndoorParkLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            iRouteIndoorParkLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            iRouteIndoorParkLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            iRouteIndoorParkLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            iRouteIndoorParkLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            iRouteIndoorParkLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IRouteIndoorParkLayerItem iRouteIndoorParkLayerItem = this.mObserver;
        if (iRouteIndoorParkLayerItem != null) {
            return iRouteIndoorParkLayerItem.canAreaCollision();
        }
        return false;
    }
}
