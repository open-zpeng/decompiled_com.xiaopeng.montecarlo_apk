package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.MapPrefabLayerItem;
import com.autonavi.gbl.map.layer.impl.MapPrefabLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IMapPrefabLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = MapPrefabLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapPrefabLayerItemRouter extends MapPrefabLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(MapPrefabLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapPrefabLayerItemRouter.class);
    private TypeHelper mHelper;
    private IMapPrefabLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMapPrefabLayerItem iMapPrefabLayerItem) {
        if (iMapPrefabLayerItem != null) {
            this.mObserver = iMapPrefabLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MapPrefabLayerItem.class, iMapPrefabLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IMapPrefabLayerItem iMapPrefabLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(MapPrefabLayerItemImpl.getCPtr((MapPrefabLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMapPrefabLayerItem);
    }

    public MapPrefabLayerItemRouter(String str, IMapPrefabLayerItem iMapPrefabLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapPrefabLayerItem);
    }

    public MapPrefabLayerItemRouter(String str, IMapPrefabLayerItem iMapPrefabLayerItem, String str2) {
        super(str2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapPrefabLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.MapPrefabLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.MapPrefabLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MapPrefabLayerItemImpl
    public boolean getItemVisible() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getItemVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            iMapPrefabLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            iMapPrefabLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            iMapPrefabLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            iMapPrefabLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            iMapPrefabLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IMapPrefabLayerItem iMapPrefabLayerItem = this.mObserver;
        if (iMapPrefabLayerItem != null) {
            return iMapPrefabLayerItem.canAreaCollision();
        }
        return false;
    }
}
