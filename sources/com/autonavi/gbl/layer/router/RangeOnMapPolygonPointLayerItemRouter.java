package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RangeOnMapPolygonPointLayerItem;
import com.autonavi.gbl.layer.impl.RangeOnMapPolygonPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRangeOnMapPolygonPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RangeOnMapPolygonPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RangeOnMapPolygonPointLayerItemRouter extends RangeOnMapPolygonPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RangeOnMapPolygonPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RangeOnMapPolygonPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRangeOnMapPolygonPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem) {
        if (iRangeOnMapPolygonPointLayerItem != null) {
            this.mObserver = iRangeOnMapPolygonPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RangeOnMapPolygonPointLayerItem.class, iRangeOnMapPolygonPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RangeOnMapPolygonPointLayerItemImpl.getCPtr((RangeOnMapPolygonPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRangeOnMapPolygonPointLayerItem);
    }

    public RangeOnMapPolygonPointLayerItemRouter(String str, IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRangeOnMapPolygonPointLayerItem);
    }

    public RangeOnMapPolygonPointLayerItemRouter(String str, IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem, float f, String[] strArr) {
        super(f, strArr);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRangeOnMapPolygonPointLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.RangeOnMapPolygonPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RangeOnMapPolygonPointLayerItemImpl
    public float getMEnergy() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getMEnergy();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.impl.RangeOnMapPolygonPointLayerItemImpl
    public String getMRetainEnergy() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getMRetainEnergy();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRangeOnMapPolygonPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRangeOnMapPolygonPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRangeOnMapPolygonPointLayerItem.getPosition(), coord3DDouble);
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
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRangeOnMapPolygonPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRangeOnMapPolygonPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRangeOnMapPolygonPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRangeOnMapPolygonPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            iRangeOnMapPolygonPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            iRangeOnMapPolygonPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            iRangeOnMapPolygonPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            iRangeOnMapPolygonPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            iRangeOnMapPolygonPointLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IRangeOnMapPolygonPointLayerItem iRangeOnMapPolygonPointLayerItem = this.mObserver;
        if (iRangeOnMapPolygonPointLayerItem != null) {
            return iRangeOnMapPolygonPointLayerItem.canAreaCollision();
        }
        return false;
    }
}
