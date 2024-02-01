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
import com.autonavi.gbl.layer.LaneGuideBusLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideBusLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideBusLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideBusLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideBusLayerItemRouter extends LaneGuideBusLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideBusLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideBusLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideBusLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideBusLayerItem iLaneGuideBusLayerItem) {
        if (iLaneGuideBusLayerItem != null) {
            this.mObserver = iLaneGuideBusLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideBusLayerItem.class, iLaneGuideBusLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideBusLayerItem iLaneGuideBusLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideBusLayerItemImpl.getCPtr((LaneGuideBusLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideBusLayerItem);
    }

    public LaneGuideBusLayerItemRouter(String str, ILaneGuideBusLayerItem iLaneGuideBusLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideBusLayerItem);
    }

    public LaneGuideBusLayerItemRouter(String str, ILaneGuideBusLayerItem iLaneGuideBusLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideBusLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideBusLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideBusLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideBusLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideBusLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideBusLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideBusLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideBusLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideBusLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideBusLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            iLaneGuideBusLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            iLaneGuideBusLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            iLaneGuideBusLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            iLaneGuideBusLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            iLaneGuideBusLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideBusLayerItem iLaneGuideBusLayerItem = this.mObserver;
        if (iLaneGuideBusLayerItem != null) {
            return iLaneGuideBusLayerItem.canAreaCollision();
        }
        return false;
    }
}
