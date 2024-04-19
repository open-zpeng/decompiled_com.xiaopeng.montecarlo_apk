package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.ILayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LayerItemRouter extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LayerItemRouter.class);
    private TypeHelper mHelper;
    private ILayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILayerItem iLayerItem) {
        if (iLayerItem != null) {
            this.mObserver = iLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LayerItem.class, iLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILayerItem iLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LayerItemImpl.getCPtr((LayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLayerItem);
    }

    public LayerItemRouter(String str, ILayerItem iLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerItem);
    }

    public LayerItemRouter(String str, ILayerItem iLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerItemRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerItemRouter.2
        }));
        ((LayerItem) this.mObserver).delete();
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            iLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            iLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            iLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            iLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            return iLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILayerItem iLayerItem = this.mObserver;
        if (iLayerItem != null) {
            iLayerItem.setAreaCollision(z);
        }
    }
}
