package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.GuideTrafficSignalLightLayerItem;
import com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem;
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
@IntfAuto(target = GuideTrafficSignalLightLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideTrafficSignalLightLayerItemRouter extends GuideTrafficSignalLightLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideTrafficSignalLightLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideTrafficSignalLightLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideTrafficSignalLightLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem) {
        if (iGuideTrafficSignalLightLayerItem != null) {
            this.mObserver = iGuideTrafficSignalLightLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideTrafficSignalLightLayerItem.class, iGuideTrafficSignalLightLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideTrafficSignalLightLayerItemImpl.getCPtr((GuideTrafficSignalLightLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideTrafficSignalLightLayerItem);
    }

    public GuideTrafficSignalLightLayerItemRouter(String str, IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficSignalLightLayerItem);
    }

    public GuideTrafficSignalLightLayerItemRouter(String str, IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem, @QuadrantType.QuadrantType1 int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficSignalLightLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl
    public long getWaitRoundCount() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getWaitRoundCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl
    public int getCrossManeuverID() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getCrossManeuverID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl
    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int getTrafficLightStatus() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getTrafficLightStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl
    public int getLightCountDown() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getLightCountDown();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl
    public float getLightAlpha() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getLightAlpha();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl
    public float getArrowDirectionAlpha() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getArrowDirectionAlpha();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficSignalLightLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficSignalLightLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficSignalLightLayerItem.getPosition(), coord3DDouble);
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
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficSignalLightLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficSignalLightLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficSignalLightLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficSignalLightLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            iGuideTrafficSignalLightLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            iGuideTrafficSignalLightLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            iGuideTrafficSignalLightLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            iGuideTrafficSignalLightLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            iGuideTrafficSignalLightLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IGuideTrafficSignalLightLayerItem iGuideTrafficSignalLightLayerItem = this.mObserver;
        if (iGuideTrafficSignalLightLayerItem != null) {
            return iGuideTrafficSignalLightLayerItem.canAreaCollision();
        }
        return false;
    }
}
