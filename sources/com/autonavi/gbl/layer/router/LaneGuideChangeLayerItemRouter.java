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
import com.autonavi.gbl.lane.model.LaneChangeGuidanceType;
import com.autonavi.gbl.layer.LaneGuideChangeLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideChangeLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideChangeLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideChangeLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideChangeLayerItemRouter extends LaneGuideChangeLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideChangeLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideChangeLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideChangeLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem) {
        if (iLaneGuideChangeLayerItem != null) {
            this.mObserver = iLaneGuideChangeLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideChangeLayerItem.class, iLaneGuideChangeLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideChangeLayerItemImpl.getCPtr((LaneGuideChangeLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideChangeLayerItem);
    }

    public LaneGuideChangeLayerItemRouter(String str, ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideChangeLayerItem);
    }

    public LaneGuideChangeLayerItemRouter(String str, ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideChangeLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideChangeLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideChangeLayerItemImpl
    @LaneChangeGuidanceType.LaneChangeGuidanceType1
    public int getSceneType() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getSceneType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideChangeLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideChangeLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideChangeLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideChangeLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideChangeLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideChangeLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideChangeLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideChangeLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            iLaneGuideChangeLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            iLaneGuideChangeLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            iLaneGuideChangeLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            iLaneGuideChangeLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            iLaneGuideChangeLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideChangeLayerItem iLaneGuideChangeLayerItem = this.mObserver;
        if (iLaneGuideChangeLayerItem != null) {
            return iLaneGuideChangeLayerItem.canAreaCollision();
        }
        return false;
    }
}
