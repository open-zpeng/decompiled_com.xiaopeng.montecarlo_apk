package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.PolygonGradientItem;
import com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IPolygonGradientItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = PolygonGradientItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PolygonGradientItemRouter extends PolygonGradientItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PolygonGradientItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(PolygonGradientItemRouter.class);
    private TypeHelper mHelper;
    private IPolygonGradientItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPolygonGradientItem iPolygonGradientItem) {
        if (iPolygonGradientItem != null) {
            this.mObserver = iPolygonGradientItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PolygonGradientItem.class, iPolygonGradientItem, this);
            }
        }
    }

    private void $constructor(String str, IPolygonGradientItem iPolygonGradientItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(PolygonGradientItemImpl.getCPtr((PolygonGradientItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPolygonGradientItem);
    }

    public PolygonGradientItemRouter(String str, IPolygonGradientItem iPolygonGradientItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPolygonGradientItem);
    }

    public PolygonGradientItemRouter(String str, IPolygonGradientItem iPolygonGradientItem, IMapViewImpl iMapViewImpl) {
        super(iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPolygonGradientItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            iPolygonGradientItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            iPolygonGradientItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            iPolygonGradientItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            iPolygonGradientItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            iPolygonGradientItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IPolygonGradientItem iPolygonGradientItem = this.mObserver;
        if (iPolygonGradientItem != null) {
            return iPolygonGradientItem.canAreaCollision();
        }
        return false;
    }
}
