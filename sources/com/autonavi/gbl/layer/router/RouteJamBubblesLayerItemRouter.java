package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.JamBubblesSegmentDeepInfo;
import com.autonavi.gbl.layer.RouteJamBubblesLayerItem;
import com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem;
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
@IntfAuto(target = RouteJamBubblesLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteJamBubblesLayerItemRouter extends RouteJamBubblesLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteJamBubblesLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteJamBubblesLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteJamBubblesLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem) {
        if (iRouteJamBubblesLayerItem != null) {
            this.mObserver = iRouteJamBubblesLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteJamBubblesLayerItem.class, iRouteJamBubblesLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteJamBubblesLayerItemImpl.getCPtr((RouteJamBubblesLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteJamBubblesLayerItem);
    }

    public RouteJamBubblesLayerItemRouter(String str, IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteJamBubblesLayerItem);
    }

    public RouteJamBubblesLayerItemRouter(String str, IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteJamBubblesLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getDirectionStyle() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public JamBubblesSegmentDeepInfo getDeepInfo() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getDeepInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public JamBubblesSegmentDeepInfo getTrend() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getTrend();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public JamBubblesSegmentDeepInfo getCost() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getCost();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public JamBubblesSegmentDeepInfo getDegree() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getDegree();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public String getPicPath() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getPicPath();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public boolean getIsJamWord() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getIsJamWord();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public long getPathId() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl
    public long getBubbleIndexId() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getBubbleIndexId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamBubblesLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamBubblesLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamBubblesLayerItem.getPosition(), coord3DDouble);
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
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamBubblesLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamBubblesLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamBubblesLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamBubblesLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            iRouteJamBubblesLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            iRouteJamBubblesLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            iRouteJamBubblesLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            iRouteJamBubblesLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            iRouteJamBubblesLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IRouteJamBubblesLayerItem iRouteJamBubblesLayerItem = this.mObserver;
        if (iRouteJamBubblesLayerItem != null) {
            return iRouteJamBubblesLayerItem.canAreaCollision();
        }
        return false;
    }
}
