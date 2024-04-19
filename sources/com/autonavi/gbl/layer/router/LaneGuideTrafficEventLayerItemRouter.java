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
import com.autonavi.gbl.layer.LaneGuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideTrafficEventLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideTrafficEventLayerItemRouter extends LaneGuideTrafficEventLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideTrafficEventLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideTrafficEventLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideTrafficEventLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem) {
        if (iLaneGuideTrafficEventLayerItem != null) {
            this.mObserver = iLaneGuideTrafficEventLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideTrafficEventLayerItem.class, iLaneGuideTrafficEventLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideTrafficEventLayerItemImpl.getCPtr((LaneGuideTrafficEventLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideTrafficEventLayerItem);
    }

    public LaneGuideTrafficEventLayerItemRouter(String str, ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTrafficEventLayerItem);
    }

    public LaneGuideTrafficEventLayerItemRouter(String str, ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTrafficEventLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneGuideTrafficEventLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneGuideTrafficEventLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl
    public int getMIndex() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getMIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl
    public int getMLayerTag() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getMLayerTag();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl
    public String getMLane() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getMLane();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl
    public int getMLayer() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getMLayer();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl
    public long getPathId() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl
    public int getMId() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getMId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficEventLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficEventLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficEventLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficEventLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficEventLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficEventLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficEventLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            iLaneGuideTrafficEventLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            iLaneGuideTrafficEventLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            iLaneGuideTrafficEventLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            iLaneGuideTrafficEventLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            return iLaneGuideTrafficEventLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideTrafficEventLayerItem iLaneGuideTrafficEventLayerItem = this.mObserver;
        if (iLaneGuideTrafficEventLayerItem != null) {
            iLaneGuideTrafficEventLayerItem.setAreaCollision(z);
        }
    }
}
