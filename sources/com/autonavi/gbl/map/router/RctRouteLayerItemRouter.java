package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.RctRouteLayerItem;
import com.autonavi.gbl.map.layer.impl.RctRouteLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IRctRouteLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RctRouteLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RctRouteLayerItemRouter extends RctRouteLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RctRouteLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RctRouteLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRctRouteLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRctRouteLayerItem iRctRouteLayerItem) {
        if (iRctRouteLayerItem != null) {
            this.mObserver = iRctRouteLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RctRouteLayerItem.class, iRctRouteLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRctRouteLayerItem iRctRouteLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RctRouteLayerItemImpl.getCPtr((RctRouteLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRctRouteLayerItem);
    }

    public RctRouteLayerItemRouter(String str, IRctRouteLayerItem iRctRouteLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRctRouteLayerItem);
    }

    public RctRouteLayerItemRouter(String str, IRctRouteLayerItem iRctRouteLayerItem, IMapViewImpl iMapViewImpl) {
        super(iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRctRouteLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.RctRouteLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.RctRouteLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            iRctRouteLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            iRctRouteLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            iRctRouteLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            iRctRouteLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            iRctRouteLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IRctRouteLayerItem iRctRouteLayerItem = this.mObserver;
        if (iRctRouteLayerItem != null) {
            return iRctRouteLayerItem.canAreaCollision();
        }
        return false;
    }
}
