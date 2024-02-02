package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.ViaETALayerItem;
import com.autonavi.gbl.layer.impl.ViaETALayerItemImpl;
import com.autonavi.gbl.layer.model.ViaETADirection;
import com.autonavi.gbl.layer.observer.IViaETALayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = ViaETALayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ViaETALayerItemRouter extends ViaETALayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ViaETALayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(ViaETALayerItemRouter.class);
    private TypeHelper mHelper;
    private IViaETALayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IViaETALayerItem iViaETALayerItem) {
        if (iViaETALayerItem != null) {
            this.mObserver = iViaETALayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(ViaETALayerItem.class, iViaETALayerItem, this);
            }
        }
    }

    private void $constructor(String str, IViaETALayerItem iViaETALayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ViaETALayerItemImpl.getCPtr((ViaETALayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iViaETALayerItem);
    }

    public ViaETALayerItemRouter(String str, IViaETALayerItem iViaETALayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iViaETALayerItem);
    }

    public ViaETALayerItemRouter(String str, IViaETALayerItem iViaETALayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iViaETALayerItem);
    }

    public ViaETALayerItemRouter(String str, IViaETALayerItem iViaETALayerItem, @QuadrantType.QuadrantType1 int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iViaETALayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.ViaETALayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.ViaETALayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.ViaETALayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.ViaETALayerItemImpl
    public long getMTravelTime() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getMTravelTime();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.ViaETALayerItemImpl
    public int getMLeftEnergy() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.ViaETALayerItemImpl
    @ViaETADirection.ViaETADirection1
    public int getMDirection() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getMDirection();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            iViaETALayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    public float getIntersectArea() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    public long getQuadrantGroupId() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaETALayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaETALayerItem.getRotateCenter3D(), coord3DDouble);
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
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaETALayerItem.getPosition(), coord3DDouble);
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
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaETALayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaETALayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaETALayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            try {
                TypeUtil.deepcopy(iViaETALayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            iViaETALayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            return iViaETALayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IViaETALayerItem iViaETALayerItem = this.mObserver;
        if (iViaETALayerItem != null) {
            iViaETALayerItem.setAreaCollision(z);
        }
    }
}
