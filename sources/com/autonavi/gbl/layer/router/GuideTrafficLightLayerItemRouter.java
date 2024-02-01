package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.TrafficLight;
import com.autonavi.gbl.layer.GuideTrafficLightLayerItem;
import com.autonavi.gbl.layer.impl.GuideTrafficLightLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideTrafficLightLayerItem;
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
@IntfAuto(target = GuideTrafficLightLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideTrafficLightLayerItemRouter extends GuideTrafficLightLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideTrafficLightLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideTrafficLightLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideTrafficLightLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem) {
        if (iGuideTrafficLightLayerItem != null) {
            this.mObserver = iGuideTrafficLightLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideTrafficLightLayerItem.class, iGuideTrafficLightLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideTrafficLightLayerItemImpl.getCPtr((GuideTrafficLightLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideTrafficLightLayerItem);
    }

    public GuideTrafficLightLayerItemRouter(String str, IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficLightLayerItem);
    }

    public GuideTrafficLightLayerItemRouter(String str, IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem, @TrafficLight.TrafficLight1 int i, int i2, @BizDirectionStyle.BizDirectionStyle1 int i3) {
        super(i, i2, i3);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficLightLayerItem);
    }

    public GuideTrafficLightLayerItemRouter(String str, IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem, @TrafficLight.TrafficLight1 int i, int i2) {
        super(i, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficLightLayerItem);
    }

    public GuideTrafficLightLayerItemRouter(String str, IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem, @QuadrantType.QuadrantType1 int i, long j, @TrafficLight.TrafficLight1 int i2, int i3) {
        super(i, j, i2, i3);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficLightLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.GuideTrafficLightLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficLightLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficLightLayerItemImpl
    @TrafficLight.TrafficLight1
    public int getMLightStatus() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getMLightStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficLightLayerItemImpl
    public int getMLightCountDown() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getMLightCountDown();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficLightLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficLightLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficLightLayerItem.getPosition(), coord3DDouble);
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
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficLightLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficLightLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficLightLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficLightLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            iGuideTrafficLightLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            iGuideTrafficLightLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            iGuideTrafficLightLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            iGuideTrafficLightLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            iGuideTrafficLightLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IGuideTrafficLightLayerItem iGuideTrafficLightLayerItem = this.mObserver;
        if (iGuideTrafficLightLayerItem != null) {
            return iGuideTrafficLightLayerItem.canAreaCollision();
        }
        return false;
    }
}
