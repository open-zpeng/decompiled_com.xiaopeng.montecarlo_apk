package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.CustomGradientPolygonItem;
import com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl;
import com.autonavi.gbl.layer.observer.ICustomGradientPolygonItem;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CustomGradientPolygonItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CustomGradientPolygonItemRouter extends CustomGradientPolygonItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomGradientPolygonItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomGradientPolygonItemRouter.class);
    private TypeHelper mHelper;
    private ICustomGradientPolygonItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICustomGradientPolygonItem iCustomGradientPolygonItem) {
        if (iCustomGradientPolygonItem != null) {
            this.mObserver = iCustomGradientPolygonItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CustomGradientPolygonItem.class, iCustomGradientPolygonItem, this);
            }
        }
    }

    private void $constructor(String str, ICustomGradientPolygonItem iCustomGradientPolygonItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomGradientPolygonItemImpl.getCPtr((CustomGradientPolygonItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCustomGradientPolygonItem);
    }

    public CustomGradientPolygonItemRouter(String str, ICustomGradientPolygonItem iCustomGradientPolygonItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomGradientPolygonItem);
    }

    public CustomGradientPolygonItemRouter(String str, ICustomGradientPolygonItem iCustomGradientPolygonItem, IMapViewImpl iMapViewImpl) {
        super(iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomGradientPolygonItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl, com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl
    public int getMType() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl
    public String getMValue() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getMValue();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            iCustomGradientPolygonItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            iCustomGradientPolygonItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            iCustomGradientPolygonItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            iCustomGradientPolygonItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            iCustomGradientPolygonItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ICustomGradientPolygonItem iCustomGradientPolygonItem = this.mObserver;
        if (iCustomGradientPolygonItem != null) {
            return iCustomGradientPolygonItem.canAreaCollision();
        }
        return false;
    }
}
