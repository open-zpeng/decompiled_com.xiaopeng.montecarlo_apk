package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.CruiseFacilityType;
import com.autonavi.gbl.layer.CruiseFacilityLayerItem;
import com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl;
import com.autonavi.gbl.layer.model.BizCruiseFacilityInfo;
import com.autonavi.gbl.layer.observer.ICruiseFacilityLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CruiseFacilityLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CruiseFacilityLayerItemRouter extends CruiseFacilityLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseFacilityLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CruiseFacilityLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICruiseFacilityLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICruiseFacilityLayerItem iCruiseFacilityLayerItem) {
        if (iCruiseFacilityLayerItem != null) {
            this.mObserver = iCruiseFacilityLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CruiseFacilityLayerItem.class, iCruiseFacilityLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICruiseFacilityLayerItem iCruiseFacilityLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CruiseFacilityLayerItemImpl.getCPtr((CruiseFacilityLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCruiseFacilityLayerItem);
    }

    public CruiseFacilityLayerItemRouter(String str, ICruiseFacilityLayerItem iCruiseFacilityLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseFacilityLayerItem);
    }

    public CruiseFacilityLayerItemRouter(String str, ICruiseFacilityLayerItem iCruiseFacilityLayerItem, @CruiseFacilityType.CruiseFacilityType1 int i, int i2, int i3) {
        super(i, i2, i3);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseFacilityLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl
    @CruiseFacilityType.CruiseFacilityType1
    public int getMType() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl
    public int getMSpeed() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getMSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl
    public int getMDistance() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl
    public ArrayList<BizCruiseFacilityInfo> getMFacilityList() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getMFacilityList();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl
    public int getIndex() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseFacilityLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseFacilityLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseFacilityLayerItem.getPosition(), coord3DDouble);
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
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseFacilityLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseFacilityLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseFacilityLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseFacilityLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            iCruiseFacilityLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            iCruiseFacilityLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            iCruiseFacilityLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            iCruiseFacilityLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            iCruiseFacilityLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ICruiseFacilityLayerItem iCruiseFacilityLayerItem = this.mObserver;
        if (iCruiseFacilityLayerItem != null) {
            return iCruiseFacilityLayerItem.canAreaCollision();
        }
        return false;
    }
}
