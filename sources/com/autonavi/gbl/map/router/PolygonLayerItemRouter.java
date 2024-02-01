package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.PolygonLayerItem;
import com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IPolygonLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = PolygonLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PolygonLayerItemRouter extends PolygonLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PolygonLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(PolygonLayerItemRouter.class);
    private TypeHelper mHelper;
    private IPolygonLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPolygonLayerItem iPolygonLayerItem) {
        if (iPolygonLayerItem != null) {
            this.mObserver = iPolygonLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PolygonLayerItem.class, iPolygonLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IPolygonLayerItem iPolygonLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(PolygonLayerItemImpl.getCPtr((PolygonLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPolygonLayerItem);
    }

    public PolygonLayerItemRouter(String str, IPolygonLayerItem iPolygonLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPolygonLayerItem);
    }

    public PolygonLayerItemRouter(String str, IPolygonLayerItem iPolygonLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPolygonLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl
    public long getColor() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getColor();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            iPolygonLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            iPolygonLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            iPolygonLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            iPolygonLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            iPolygonLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IPolygonLayerItem iPolygonLayerItem = this.mObserver;
        if (iPolygonLayerItem != null) {
            return iPolygonLayerItem.canAreaCollision();
        }
        return false;
    }
}
