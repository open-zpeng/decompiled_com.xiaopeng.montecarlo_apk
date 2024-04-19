package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.VectorCrossLayerItem;
import com.autonavi.gbl.map.layer.impl.VectorCrossLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IVectorCrossLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = VectorCrossLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class VectorCrossLayerItemRouter extends VectorCrossLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(VectorCrossLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(VectorCrossLayerItemRouter.class);
    private TypeHelper mHelper;
    private IVectorCrossLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IVectorCrossLayerItem iVectorCrossLayerItem) {
        if (iVectorCrossLayerItem != null) {
            this.mObserver = iVectorCrossLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(VectorCrossLayerItem.class, iVectorCrossLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IVectorCrossLayerItem iVectorCrossLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(VectorCrossLayerItemImpl.getCPtr((VectorCrossLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iVectorCrossLayerItem);
    }

    public VectorCrossLayerItemRouter(String str, IVectorCrossLayerItem iVectorCrossLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iVectorCrossLayerItem);
    }

    public VectorCrossLayerItemRouter(String str, IVectorCrossLayerItem iVectorCrossLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iVectorCrossLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.VectorCrossLayerItemRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.VectorCrossLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.VectorCrossLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.VectorCrossLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            iVectorCrossLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            iVectorCrossLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            iVectorCrossLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            iVectorCrossLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            return iVectorCrossLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IVectorCrossLayerItem iVectorCrossLayerItem = this.mObserver;
        if (iVectorCrossLayerItem != null) {
            iVectorCrossLayerItem.setAreaCollision(z);
        }
    }
}
