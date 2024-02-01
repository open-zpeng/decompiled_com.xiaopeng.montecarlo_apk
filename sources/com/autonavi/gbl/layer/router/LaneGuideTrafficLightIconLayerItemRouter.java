package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.LaneGuideTrafficLightIconLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideTrafficLightIconLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightIconLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideTrafficLightIconLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideTrafficLightIconLayerItemRouter extends LaneGuideTrafficLightIconLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideTrafficLightIconLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideTrafficLightIconLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideTrafficLightIconLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem) {
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            this.mObserver = iLaneGuideTrafficLightIconLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideTrafficLightIconLayerItem.class, iLaneGuideTrafficLightIconLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideTrafficLightIconLayerItemImpl.getCPtr((LaneGuideTrafficLightIconLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideTrafficLightIconLayerItem);
    }

    public LaneGuideTrafficLightIconLayerItemRouter(String str, ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTrafficLightIconLayerItem);
    }

    public LaneGuideTrafficLightIconLayerItemRouter(String str, ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTrafficLightIconLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LaneGuideTrafficLightIconLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightIconLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightIconLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightIconLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightIconLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightIconLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightIconLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTrafficLightIconLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            iLaneGuideTrafficLightIconLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            iLaneGuideTrafficLightIconLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            iLaneGuideTrafficLightIconLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            iLaneGuideTrafficLightIconLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            iLaneGuideTrafficLightIconLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILaneGuideTrafficLightIconLayerItem iLaneGuideTrafficLightIconLayerItem = this.mObserver;
        if (iLaneGuideTrafficLightIconLayerItem != null) {
            return iLaneGuideTrafficLightIconLayerItem.canAreaCollision();
        }
        return false;
    }
}
