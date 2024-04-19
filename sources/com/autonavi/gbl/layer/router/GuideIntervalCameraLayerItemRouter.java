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
import com.autonavi.gbl.layer.GuideIntervalCameraLayerItem;
import com.autonavi.gbl.layer.impl.GuideIntervalCameraLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideIntervalCameraLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideIntervalCameraLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideIntervalCameraLayerItemRouter extends GuideIntervalCameraLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideIntervalCameraLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideIntervalCameraLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideIntervalCameraLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem) {
        if (iGuideIntervalCameraLayerItem != null) {
            this.mObserver = iGuideIntervalCameraLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideIntervalCameraLayerItem.class, iGuideIntervalCameraLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideIntervalCameraLayerItemImpl.getCPtr((GuideIntervalCameraLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideIntervalCameraLayerItem);
    }

    public GuideIntervalCameraLayerItemRouter(String str, IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideIntervalCameraLayerItem);
    }

    public GuideIntervalCameraLayerItemRouter(String str, IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem, @CameraType.CameraType1 int i, int i2) {
        super(i, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideIntervalCameraLayerItem);
    }

    public GuideIntervalCameraLayerItemRouter(String str, IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem, @QuadrantType.QuadrantType1 int i, long j, @CameraType.CameraType1 int i2, int i3) {
        super(i, j, i2, i3);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideIntervalCameraLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideIntervalCameraLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.GuideIntervalCameraLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideIntervalCameraLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideIntervalCameraLayerItemImpl
    @CameraType.CameraType1
    public int getMCameraType() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getMCameraType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideIntervalCameraLayerItemImpl
    public int getMSpeed() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getMSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideIntervalCameraLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideIntervalCameraLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideIntervalCameraLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideIntervalCameraLayerItem.getPosition(), coord3DDouble);
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
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideIntervalCameraLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideIntervalCameraLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideIntervalCameraLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideIntervalCameraLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            iGuideIntervalCameraLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            iGuideIntervalCameraLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            iGuideIntervalCameraLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            iGuideIntervalCameraLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            return iGuideIntervalCameraLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideIntervalCameraLayerItem iGuideIntervalCameraLayerItem = this.mObserver;
        if (iGuideIntervalCameraLayerItem != null) {
            iGuideIntervalCameraLayerItem.setAreaCollision(z);
        }
    }
}
