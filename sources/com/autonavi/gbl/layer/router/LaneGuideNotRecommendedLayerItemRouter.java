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
import com.autonavi.gbl.lane.model.LaneNotRecommendedType;
import com.autonavi.gbl.layer.LaneGuideNotRecommendedLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideNotRecommendedLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideNotRecommendedLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideNotRecommendedLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideNotRecommendedLayerItemRouter extends LaneGuideNotRecommendedLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideNotRecommendedLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideNotRecommendedLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideNotRecommendedLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem) {
        if (iLaneGuideNotRecommendedLayerItem != null) {
            this.mObserver = iLaneGuideNotRecommendedLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideNotRecommendedLayerItem.class, iLaneGuideNotRecommendedLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideNotRecommendedLayerItemImpl.getCPtr((LaneGuideNotRecommendedLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideNotRecommendedLayerItem);
    }

    public LaneGuideNotRecommendedLayerItemRouter(String str, ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideNotRecommendedLayerItem);
    }

    public LaneGuideNotRecommendedLayerItemRouter(String str, ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideNotRecommendedLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideNotRecommendedLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideNotRecommendedLayerItemImpl
    @LaneNotRecommendedType.LaneNotRecommendedType1
    public int getSceneType() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getSceneType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideNotRecommendedLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideNotRecommendedLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideNotRecommendedLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideNotRecommendedLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideNotRecommendedLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideNotRecommendedLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideNotRecommendedLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideNotRecommendedLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            iLaneGuideNotRecommendedLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            iLaneGuideNotRecommendedLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            iLaneGuideNotRecommendedLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            iLaneGuideNotRecommendedLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            iLaneGuideNotRecommendedLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideNotRecommendedLayerItem iLaneGuideNotRecommendedLayerItem = this.mObserver;
        if (iLaneGuideNotRecommendedLayerItem != null) {
            return iLaneGuideNotRecommendedLayerItem.canAreaCollision();
        }
        return false;
    }
}
