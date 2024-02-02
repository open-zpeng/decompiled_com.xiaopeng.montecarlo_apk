package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.RasterImageLayerItem;
import com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IRasterImageLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RasterImageLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RasterImageLayerItemRouter extends RasterImageLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RasterImageLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RasterImageLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRasterImageLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRasterImageLayerItem iRasterImageLayerItem) {
        if (iRasterImageLayerItem != null) {
            this.mObserver = iRasterImageLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RasterImageLayerItem.class, iRasterImageLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRasterImageLayerItem iRasterImageLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RasterImageLayerItemImpl.getCPtr((RasterImageLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRasterImageLayerItem);
    }

    public RasterImageLayerItemRouter(String str, IRasterImageLayerItem iRasterImageLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRasterImageLayerItem);
    }

    public RasterImageLayerItemRouter(String str, IRasterImageLayerItem iRasterImageLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRasterImageLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.RasterImageLayerItemRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.RasterImageLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            iRasterImageLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            iRasterImageLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            return iRasterImageLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRasterImageLayerItem iRasterImageLayerItem = this.mObserver;
        if (iRasterImageLayerItem != null) {
            iRasterImageLayerItem.setAreaCollision(z);
        }
    }
}
