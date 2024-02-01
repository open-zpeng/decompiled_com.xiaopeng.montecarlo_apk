package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.ViaChargeStationLayerItem;
import com.autonavi.gbl.layer.impl.ViaChargeStationLayerItemImpl;
import com.autonavi.gbl.layer.observer.IViaChargeStationLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = ViaChargeStationLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ViaChargeStationLayerItemRouter extends ViaChargeStationLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ViaChargeStationLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(ViaChargeStationLayerItemRouter.class);
    private TypeHelper mHelper;
    private IViaChargeStationLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IViaChargeStationLayerItem iViaChargeStationLayerItem) {
        if (iViaChargeStationLayerItem != null) {
            this.mObserver = iViaChargeStationLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(ViaChargeStationLayerItem.class, iViaChargeStationLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IViaChargeStationLayerItem iViaChargeStationLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ViaChargeStationLayerItemImpl.getCPtr((ViaChargeStationLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iViaChargeStationLayerItem);
    }

    public ViaChargeStationLayerItemRouter(String str, IViaChargeStationLayerItem iViaChargeStationLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iViaChargeStationLayerItem);
    }

    public ViaChargeStationLayerItemRouter(String str, IViaChargeStationLayerItem iViaChargeStationLayerItem, boolean z) {
        super(z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iViaChargeStationLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.ViaChargeStationLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.ViaChargeStationLayerItemImpl
    public boolean getIsEagleEye() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getIsEagleEye();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaChargeStationLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaChargeStationLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaChargeStationLayerItem.getPosition(), coord3DDouble);
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
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaChargeStationLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaChargeStationLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaChargeStationLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaChargeStationLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            iViaChargeStationLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            iViaChargeStationLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            iViaChargeStationLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            iViaChargeStationLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            iViaChargeStationLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IViaChargeStationLayerItem iViaChargeStationLayerItem = this.mObserver;
        if (iViaChargeStationLayerItem != null) {
            return iViaChargeStationLayerItem.canAreaCollision();
        }
        return false;
    }
}
