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
import com.autonavi.gbl.layer.LaneGuideSolidLineLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideSolidLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideSolidLineLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideSolidLineLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideSolidLineLayerItemRouter extends LaneGuideSolidLineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideSolidLineLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideSolidLineLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideSolidLineLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem) {
        if (iLaneGuideSolidLineLayerItem != null) {
            this.mObserver = iLaneGuideSolidLineLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideSolidLineLayerItem.class, iLaneGuideSolidLineLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideSolidLineLayerItemImpl.getCPtr((LaneGuideSolidLineLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideSolidLineLayerItem);
    }

    public LaneGuideSolidLineLayerItemRouter(String str, ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideSolidLineLayerItem);
    }

    public LaneGuideSolidLineLayerItemRouter(String str, ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideSolidLineLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideSolidLineLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideSolidLineLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideSolidLineLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideSolidLineLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideSolidLineLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideSolidLineLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideSolidLineLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideSolidLineLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideSolidLineLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            iLaneGuideSolidLineLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            iLaneGuideSolidLineLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            iLaneGuideSolidLineLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            iLaneGuideSolidLineLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            iLaneGuideSolidLineLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideSolidLineLayerItem iLaneGuideSolidLineLayerItem = this.mObserver;
        if (iLaneGuideSolidLineLayerItem != null) {
            return iLaneGuideSolidLineLayerItem.canAreaCollision();
        }
        return false;
    }
}
