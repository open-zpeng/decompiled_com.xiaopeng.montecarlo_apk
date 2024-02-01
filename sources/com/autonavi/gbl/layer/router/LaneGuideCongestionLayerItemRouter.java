package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideCongestionLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem;
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
@IntfAuto(target = LaneGuideCongestionLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideCongestionLayerItemRouter extends LaneGuideCongestionLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideCongestionLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideCongestionLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideCongestionLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem) {
        if (iLaneGuideCongestionLayerItem != null) {
            this.mObserver = iLaneGuideCongestionLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideCongestionLayerItem.class, iLaneGuideCongestionLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideCongestionLayerItemImpl.getCPtr((LaneGuideCongestionLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideCongestionLayerItem);
    }

    public LaneGuideCongestionLayerItemRouter(String str, ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideCongestionLayerItem);
    }

    public LaneGuideCongestionLayerItemRouter(String str, ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideCongestionLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            iLaneGuideCongestionLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl
    public long getMPathID() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getMPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl
    public long getMTotalTimeOfSeconds() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getMTotalTimeOfSeconds();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl
    public long getMTotalRemainDist() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getMTotalRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl
    public CongestExtend getMCongestExtend() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getMCongestExtend();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCongestionLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCongestionLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCongestionLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCongestionLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCongestionLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCongestionLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCongestionLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            iLaneGuideCongestionLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            iLaneGuideCongestionLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            iLaneGuideCongestionLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            iLaneGuideCongestionLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideCongestionLayerItem iLaneGuideCongestionLayerItem = this.mObserver;
        if (iLaneGuideCongestionLayerItem != null) {
            return iLaneGuideCongestionLayerItem.canAreaCollision();
        }
        return false;
    }
}
