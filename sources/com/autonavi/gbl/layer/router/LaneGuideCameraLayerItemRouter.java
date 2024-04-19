package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.BreakRuleCameraSubType;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideCameraLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideCameraLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideCameraLayerItemRouter extends LaneGuideCameraLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideCameraLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideCameraLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideCameraLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem) {
        if (iLaneGuideCameraLayerItem != null) {
            this.mObserver = iLaneGuideCameraLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideCameraLayerItem.class, iLaneGuideCameraLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideCameraLayerItemImpl.getCPtr((LaneGuideCameraLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideCameraLayerItem);
    }

    public LaneGuideCameraLayerItemRouter(String str, ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideCameraLayerItem);
    }

    public LaneGuideCameraLayerItemRouter(String str, ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideCameraLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneGuideCameraLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneGuideCameraLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl
    @CameraType.CameraType1
    public int getMCameraType() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getMCameraType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl
    @BreakRuleCameraSubType.BreakRuleCameraSubType1
    public int getMBreakSubType() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getMBreakSubType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl
    public int getMCameraSpeed() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getMCameraSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl
    public int getMDistance() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl
    public long getMCameraId() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getMCameraId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCameraLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCameraLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCameraLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCameraLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCameraLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCameraLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideCameraLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            iLaneGuideCameraLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            iLaneGuideCameraLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            iLaneGuideCameraLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            iLaneGuideCameraLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            return iLaneGuideCameraLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideCameraLayerItem iLaneGuideCameraLayerItem = this.mObserver;
        if (iLaneGuideCameraLayerItem != null) {
            iLaneGuideCameraLayerItem.setAreaCollision(z);
        }
    }
}
