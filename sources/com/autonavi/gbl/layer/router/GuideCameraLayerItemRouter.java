package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.layer.GuideCameraLayerItem;
import com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizGuideCameraInfo;
import com.autonavi.gbl.layer.observer.IGuideCameraLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideCameraLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideCameraLayerItemRouter extends GuideCameraLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideCameraLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideCameraLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideCameraLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideCameraLayerItem iGuideCameraLayerItem) {
        if (iGuideCameraLayerItem != null) {
            this.mObserver = iGuideCameraLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideCameraLayerItem.class, iGuideCameraLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideCameraLayerItem iGuideCameraLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideCameraLayerItemImpl.getCPtr((GuideCameraLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideCameraLayerItem);
    }

    public GuideCameraLayerItemRouter(String str, IGuideCameraLayerItem iGuideCameraLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideCameraLayerItem);
    }

    public GuideCameraLayerItemRouter(String str, IGuideCameraLayerItem iGuideCameraLayerItem, BizGuideCameraInfo bizGuideCameraInfo, @BizDirectionStyle.BizDirectionStyle1 int i, int i2) {
        super(bizGuideCameraInfo, i, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideCameraLayerItem);
    }

    public GuideCameraLayerItemRouter(String str, IGuideCameraLayerItem iGuideCameraLayerItem, @QuadrantType.QuadrantType1 int i, long j, BizGuideCameraInfo bizGuideCameraInfo, @BizDirectionStyle.BizDirectionStyle1 int i2, int i3) {
        super(i, j, bizGuideCameraInfo, i2, i3);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideCameraLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideCameraLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideCameraLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    @CameraType.CameraType1
    public int getMCameraType() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMCameraType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public int getMBreakSubType() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMBreakSubType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public boolean getMbContinuous() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMbContinuous();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public int getMCameraSpeed() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMCameraSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public Coord3DDouble getMPosition() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMPosition();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public int getMDistance() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public boolean getMNeedShowPenalty() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMNeedShowPenalty();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMWantDirectionStyle() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMWantDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public boolean getMNeedShowNewCamera() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMNeedShowNewCamera();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl
    public long getMCameraId() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMCameraId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCameraLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCameraLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCameraLayerItem.getPosition(), coord3DDouble);
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
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCameraLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCameraLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCameraLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCameraLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            iGuideCameraLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            iGuideCameraLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            iGuideCameraLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            iGuideCameraLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            return iGuideCameraLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideCameraLayerItem iGuideCameraLayerItem = this.mObserver;
        if (iGuideCameraLayerItem != null) {
            iGuideCameraLayerItem.setAreaCollision(z);
        }
    }
}
