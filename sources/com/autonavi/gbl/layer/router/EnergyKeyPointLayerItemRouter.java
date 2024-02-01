package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.EnergyKeyPointLayerItem;
import com.autonavi.gbl.layer.impl.EnergyKeyPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IEnergyKeyPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = EnergyKeyPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class EnergyKeyPointLayerItemRouter extends EnergyKeyPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(EnergyKeyPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(EnergyKeyPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IEnergyKeyPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem) {
        if (iEnergyKeyPointLayerItem != null) {
            this.mObserver = iEnergyKeyPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(EnergyKeyPointLayerItem.class, iEnergyKeyPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(EnergyKeyPointLayerItemImpl.getCPtr((EnergyKeyPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iEnergyKeyPointLayerItem);
    }

    public EnergyKeyPointLayerItemRouter(String str, IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEnergyKeyPointLayerItem);
    }

    public EnergyKeyPointLayerItemRouter(String str, IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem, float f) {
        super(f);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEnergyKeyPointLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.EnergyKeyPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.EnergyKeyPointLayerItemImpl
    public float getMKeyPercent() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getMKeyPercent();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEnergyKeyPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEnergyKeyPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEnergyKeyPointLayerItem.getPosition(), coord3DDouble);
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
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEnergyKeyPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEnergyKeyPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEnergyKeyPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEnergyKeyPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            iEnergyKeyPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            iEnergyKeyPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            iEnergyKeyPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            iEnergyKeyPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            iEnergyKeyPointLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IEnergyKeyPointLayerItem iEnergyKeyPointLayerItem = this.mObserver;
        if (iEnergyKeyPointLayerItem != null) {
            return iEnergyKeyPointLayerItem.canAreaCollision();
        }
        return false;
    }
}
