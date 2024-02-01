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

    public RouteCompareTipsLayerItemRouter(String str, IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteCompareTipsLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl
    public String getMLabelContent() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getMLabelContent();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl
    public int getMTravelTimeDiff() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getMTravelTimeDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl
    public boolean getMIsFaster() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getMIsFaster();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
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

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
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
    public boolean getClickable() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getClickable();
        }
        return false;
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

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            iRouteCompareTipsLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IRouteCompareTipsLayerItem iRouteCompareTipsLayerItem = this.mObserver;
        if (iRouteCompareTipsLayerItem != null) {
            return iRouteCompareTipsLayerItem.canAreaCollision();
        }
        return false;
    }
}
