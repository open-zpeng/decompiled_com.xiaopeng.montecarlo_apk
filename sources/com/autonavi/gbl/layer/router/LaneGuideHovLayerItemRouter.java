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
import com.autonavi.gbl.layer.LaneGuideHovLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideHovLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideHovLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideHovLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideHovLayerItemRouter extends LaneGuideHovLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideHovLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideHovLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideHovLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideHovLayerItem iLaneGuideHovLayerItem) {
        if (iLaneGuideHovLayerItem != null) {
            this.mObserver = iLaneGuideHovLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideHovLayerItem.class, iLaneGuideHovLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideHovLayerItem iLaneGuideHovLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideHovLayerItemImpl.getCPtr((LaneGuideHovLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideHovLayerItem);
    }

    public LaneGuideHovLayerItemRouter(String str, ILaneGuideHovLayerItem iLaneGuideHovLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideHovLayerItem);
    }

    public LaneGuideHovLayerItemRouter(String str, ILaneGuideHovLayerItem iLaneGuideHovLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideHovLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideHovLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideHovLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideHovLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideHovLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideHovLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideHovLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideHovLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideHovLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideHovLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            iLaneGuideHovLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            iLaneGuideHovLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            iLaneGuideHovLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            iLaneGuideHovLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            iLaneGuideHovLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideHovLayerItem iLaneGuideHovLayerItem = this.mObserver;
        if (iLaneGuideHovLayerItem != null) {
            return iLaneGuideHovLayerItem.canAreaCollision();
        }
        return false;
    }
}
