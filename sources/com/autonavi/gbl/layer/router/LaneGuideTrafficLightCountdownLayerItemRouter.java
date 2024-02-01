package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideTrafficLightCountdownLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem;
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
@IntfAuto(target = LaneGuideTrafficLightCountdownLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideTrafficLightCountdownLayerItemRouter extends LaneGuideTrafficLightCountdownLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideTrafficLightCountdownLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideTrafficLightCountdownLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideTrafficLightCountdownLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem) {
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            this.mObserver = iLaneGuideTrafficLightCountdownLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideTrafficLightCountdownLayerItem.class, iLaneGuideTrafficLightCountdownLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideTrafficLightCountdownLayerItemImpl.getCPtr((LaneGuideTrafficLightCountdownLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideTrafficLightCountdownLayerItem);
    }

    public LaneGuideTrafficLightCountdownLayerItemRouter(String str, ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTrafficLightCountdownLayerItem);
    }

    public LaneGuideTrafficLightCountdownLayerItemRouter(String str, ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTrafficLightCountdownLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getDirectionType() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    public float getLightBodyAlpha() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getLightBodyAlpha();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    public float getLightDirectionAlpha() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getLightDirectionAlpha();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    public long getLightAnimationBeginTimeMS() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getLightAnimationBeginTimeMS();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int getLightStatus() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getLightStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    public String getLightDirection() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getLightDirection();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    public int getRemainSeconds() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getRemainSeconds();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl
    public int getWaitRound() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getWaitRound();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightCountdownLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightCountdownLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightCountdownLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightCountdownLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightCountdownLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightCountdownLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightCountdownLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            iLaneGuideTrafficLightCountdownLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            iLaneGuideTrafficLightCountdownLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            iLaneGuideTrafficLightCountdownLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            iLaneGuideTrafficLightCountdownLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            iLaneGuideTrafficLightCountdownLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideTrafficLightCountdownLayerItem iLaneGuideTrafficLightCountdownLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightCountdownLayerItem != null) {
            return iLaneGuideTrafficLightCountdownLayerItem.canAreaCollision();
        }
        return false;
    }
}
