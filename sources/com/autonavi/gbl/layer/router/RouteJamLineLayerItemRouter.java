package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.RouteJamLineLayerItem;
import com.autonavi.gbl.layer.impl.RouteJamLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteJamLineLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteJamLineLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteJamLineLayerItemRouter extends RouteJamLineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteJamLineLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteJamLineLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteJamLineLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteJamLineLayerItem iRouteJamLineLayerItem) {
        if (iRouteJamLineLayerItem != null) {
            this.mObserver = iRouteJamLineLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteJamLineLayerItem.class, iRouteJamLineLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteJamLineLayerItem iRouteJamLineLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteJamLineLayerItemImpl.getCPtr((RouteJamLineLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteJamLineLayerItem);
    }

    public RouteJamLineLayerItemRouter(String str, IRouteJamLineLayerItem iRouteJamLineLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteJamLineLayerItem);
    }

    public RouteJamLineLayerItemRouter(String str, IRouteJamLineLayerItem iRouteJamLineLayerItem, AvoidJamCloudControl avoidJamCloudControl) {
        super(avoidJamCloudControl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteJamLineLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.RouteJamLineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteJamLineLayerItemImpl
    public AvoidJamCloudControl getMAvoidJamCloud() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getMAvoidJamCloud();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        $wrapper_getStyle(lineLayerItemStyle);
    }

    private void $wrapper_getStyle(LineLayerItemStyle lineLayerItemStyle) {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteJamLineLayerItem.getStyle(), lineLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public long getPointsCount() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getPointsCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            iRouteJamLineLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            iRouteJamLineLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            iRouteJamLineLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            iRouteJamLineLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            iRouteJamLineLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IRouteJamLineLayerItem iRouteJamLineLayerItem = this.mObserver;
        if (iRouteJamLineLayerItem != null) {
            return iRouteJamLineLayerItem.canAreaCollision();
        }
        return false;
    }
}
