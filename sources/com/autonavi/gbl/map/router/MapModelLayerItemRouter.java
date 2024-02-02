package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.MapModelLayerItem;
import com.autonavi.gbl.map.layer.impl.MapModelLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IMapModelLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = MapModelLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapModelLayerItemRouter extends MapModelLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(MapModelLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapModelLayerItemRouter.class);
    private TypeHelper mHelper;
    private IMapModelLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMapModelLayerItem iMapModelLayerItem) {
        if (iMapModelLayerItem != null) {
            this.mObserver = iMapModelLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MapModelLayerItem.class, iMapModelLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IMapModelLayerItem iMapModelLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(MapModelLayerItemImpl.getCPtr((MapModelLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMapModelLayerItem);
    }

    public MapModelLayerItemRouter(String str, IMapModelLayerItem iMapModelLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapModelLayerItem);
    }

    public MapModelLayerItemRouter(String str, IMapModelLayerItem iMapModelLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapModelLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapModelLayerItemRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.MapModelLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapModelLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.MapModelLayerItemImpl
    public int getModelID() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getModelID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MapModelLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.MapModelLayerItemImpl
    public boolean getDepthMask() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getDepthMask();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            iMapModelLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            iMapModelLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            return iMapModelLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IMapModelLayerItem iMapModelLayerItem = this.mObserver;
        if (iMapModelLayerItem != null) {
            iMapModelLayerItem.setAreaCollision(z);
        }
    }
}
