package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.GpsTrackPointLayerItem;
import com.autonavi.gbl.layer.impl.GpsTrackPointLayerItemImpl;
import com.autonavi.gbl.layer.model.BizGpsPointType;
import com.autonavi.gbl.layer.observer.IGpsTrackPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GpsTrackPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GpsTrackPointLayerItemRouter extends GpsTrackPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GpsTrackPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GpsTrackPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGpsTrackPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGpsTrackPointLayerItem iGpsTrackPointLayerItem) {
        if (iGpsTrackPointLayerItem != null) {
            this.mObserver = iGpsTrackPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GpsTrackPointLayerItem.class, iGpsTrackPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGpsTrackPointLayerItem iGpsTrackPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GpsTrackPointLayerItemImpl.getCPtr((GpsTrackPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGpsTrackPointLayerItem);
    }

    public GpsTrackPointLayerItemRouter(String str, IGpsTrackPointLayerItem iGpsTrackPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGpsTrackPointLayerItem);
    }

    public GpsTrackPointLayerItemRouter(String str, IGpsTrackPointLayerItem iGpsTrackPointLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGpsTrackPointLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GpsTrackPointLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.GpsTrackPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GpsTrackPointLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GpsTrackPointLayerItemImpl
    @BizGpsPointType.BizGpsPointType1
    public int getMGpsPointType() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getMGpsPointType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGpsTrackPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGpsTrackPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGpsTrackPointLayerItem.getPosition(), coord3DDouble);
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
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGpsTrackPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGpsTrackPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGpsTrackPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGpsTrackPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            iGpsTrackPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            iGpsTrackPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            iGpsTrackPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            iGpsTrackPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            return iGpsTrackPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGpsTrackPointLayerItem iGpsTrackPointLayerItem = this.mObserver;
        if (iGpsTrackPointLayerItem != null) {
            iGpsTrackPointLayerItem.setAreaCollision(z);
        }
    }
}
