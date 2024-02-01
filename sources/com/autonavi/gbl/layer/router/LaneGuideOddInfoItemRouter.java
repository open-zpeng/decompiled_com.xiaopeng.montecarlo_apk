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
import com.autonavi.gbl.layer.LaneGuideOddInfoItem;
import com.autonavi.gbl.layer.impl.LaneGuideOddInfoItemImpl;
import com.autonavi.gbl.layer.model.LaneODDPointType;
import com.autonavi.gbl.layer.observer.ILaneGuideOddInfoItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideOddInfoItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideOddInfoItemRouter extends LaneGuideOddInfoItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideOddInfoItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideOddInfoItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideOddInfoItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideOddInfoItem iLaneGuideOddInfoItem) {
        if (iLaneGuideOddInfoItem != null) {
            this.mObserver = iLaneGuideOddInfoItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideOddInfoItem.class, iLaneGuideOddInfoItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideOddInfoItem iLaneGuideOddInfoItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideOddInfoItemImpl.getCPtr((LaneGuideOddInfoItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideOddInfoItem);
    }

    public LaneGuideOddInfoItemRouter(String str, ILaneGuideOddInfoItem iLaneGuideOddInfoItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideOddInfoItem);
    }

    public LaneGuideOddInfoItemRouter(String str, ILaneGuideOddInfoItem iLaneGuideOddInfoItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideOddInfoItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideOddInfoItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideOddInfoItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getDirectionType() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideOddInfoItemImpl
    @LaneODDPointType.LaneODDPointType1
    public int getType() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideOddInfoItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideOddInfoItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideOddInfoItem.getPosition(), coord3DDouble);
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
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideOddInfoItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideOddInfoItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideOddInfoItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideOddInfoItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            iLaneGuideOddInfoItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            iLaneGuideOddInfoItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            iLaneGuideOddInfoItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            iLaneGuideOddInfoItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            iLaneGuideOddInfoItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideOddInfoItem iLaneGuideOddInfoItem = this.mObserver;
        if (iLaneGuideOddInfoItem != null) {
            return iLaneGuideOddInfoItem.canAreaCollision();
        }
        return false;
    }
}
