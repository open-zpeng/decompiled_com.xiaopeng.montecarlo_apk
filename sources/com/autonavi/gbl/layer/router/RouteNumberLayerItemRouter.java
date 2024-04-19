package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.RouteNumberLayerItem;
import com.autonavi.gbl.layer.impl.RouteNumberLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteNumberLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteNumberLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteNumberLayerItemRouter extends RouteNumberLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteNumberLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteNumberLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteNumberLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteNumberLayerItem iRouteNumberLayerItem) {
        if (iRouteNumberLayerItem != null) {
            this.mObserver = iRouteNumberLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteNumberLayerItem.class, iRouteNumberLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteNumberLayerItem iRouteNumberLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteNumberLayerItemImpl.getCPtr((RouteNumberLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteNumberLayerItem);
    }

    public RouteNumberLayerItemRouter(String str, IRouteNumberLayerItem iRouteNumberLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteNumberLayerItem);
    }

    public RouteNumberLayerItemRouter(String str, IRouteNumberLayerItem iRouteNumberLayerItem, boolean z, int i) {
        super(z, i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteNumberLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteNumberLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteNumberLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteNumberLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteNumberLayerItemImpl
    public boolean getIsSelectedPath() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getIsSelectedPath();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteNumberLayerItemImpl
    public int getRouteNumberId() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getRouteNumberId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.RouteNumberLayerItemImpl
    public long getPathID() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteNumberLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteNumberLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteNumberLayerItem.getPosition(), coord3DDouble);
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
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteNumberLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteNumberLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteNumberLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteNumberLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            iRouteNumberLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            iRouteNumberLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            iRouteNumberLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            iRouteNumberLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            return iRouteNumberLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteNumberLayerItem iRouteNumberLayerItem = this.mObserver;
        if (iRouteNumberLayerItem != null) {
            iRouteNumberLayerItem.setAreaCollision(z);
        }
    }
}
