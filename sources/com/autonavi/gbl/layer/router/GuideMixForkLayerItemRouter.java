package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.GuideMixForkLayerItem;
import com.autonavi.gbl.layer.impl.GuideMixForkLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideMixForkLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideMixForkLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideMixForkLayerItemRouter extends GuideMixForkLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideMixForkLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideMixForkLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideMixForkLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideMixForkLayerItem iGuideMixForkLayerItem) {
        if (iGuideMixForkLayerItem != null) {
            this.mObserver = iGuideMixForkLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideMixForkLayerItem.class, iGuideMixForkLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideMixForkLayerItem iGuideMixForkLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideMixForkLayerItemImpl.getCPtr((GuideMixForkLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideMixForkLayerItem);
    }

    public GuideMixForkLayerItemRouter(String str, IGuideMixForkLayerItem iGuideMixForkLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideMixForkLayerItem);
    }

    public GuideMixForkLayerItemRouter(String str, IGuideMixForkLayerItem iGuideMixForkLayerItem, @BizDirectionStyle.BizDirectionStyle1 int i, int i2, int i3) {
        super(i, i2, i3);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideMixForkLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.GuideMixForkLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideMixForkLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideMixForkLayerItemImpl
    public int getMDistance() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideMixForkLayerItemImpl
    public int getMRoadClass() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getMRoadClass();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideMixForkLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideMixForkLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideMixForkLayerItem.getPosition(), coord3DDouble);
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
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideMixForkLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideMixForkLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideMixForkLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideMixForkLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            iGuideMixForkLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            iGuideMixForkLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            iGuideMixForkLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            iGuideMixForkLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            iGuideMixForkLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IGuideMixForkLayerItem iGuideMixForkLayerItem = this.mObserver;
        if (iGuideMixForkLayerItem != null) {
            return iGuideMixForkLayerItem.canAreaCollision();
        }
        return false;
    }
}
