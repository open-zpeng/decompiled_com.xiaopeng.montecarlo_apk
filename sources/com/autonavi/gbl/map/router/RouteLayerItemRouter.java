package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.RouteLayerItem;
import com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.observer.IRouteLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteLayerItemRouter extends RouteLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteLayerItem iRouteLayerItem) {
        if (iRouteLayerItem != null) {
            this.mObserver = iRouteLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteLayerItem.class, iRouteLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteLayerItem iRouteLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteLayerItemImpl.getCPtr((RouteLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteLayerItem);
    }

    public RouteLayerItemRouter(String str, IRouteLayerItem iRouteLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteLayerItem);
    }

    public RouteLayerItemRouter(String str, IRouteLayerItem iRouteLayerItem, MapViewImpl mapViewImpl) {
        super(mapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.RouteLayerItemRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.RouteLayerItemRouter.2
        }));
        ((RouteLayerItem) this.mObserver).delete();
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl
    public void getDisplayScale(LayerScale layerScale) {
        $wrapper_getDisplayScale(layerScale);
    }

    private void $wrapper_getDisplayScale(LayerScale layerScale) {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteLayerItem.getDisplayScale(), layerScale);
            } catch (Exception unused) {
                DebugTool.e("getDisplayScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl
    public void getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        $wrapper_getRouteDrawParam(routeLayerDrawParam);
    }

    private void $wrapper_getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteLayerItem.getRouteDrawParam(), routeLayerDrawParam);
            } catch (Exception unused) {
                DebugTool.e("getRouteDrawParam copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl
    public boolean isPathIntersectRect(RectDouble rectDouble) {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.isPathIntersectRect(rectDouble);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl
    public boolean getSelectStatus() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getSelectStatus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            iRouteLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            iRouteLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            iRouteLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            iRouteLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            return iRouteLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteLayerItem iRouteLayerItem = this.mObserver;
        if (iRouteLayerItem != null) {
            iRouteLayerItem.setAreaCollision(z);
        }
    }
}
