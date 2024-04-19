package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.CustomPlaneLayerItem;
import com.autonavi.gbl.layer.impl.CustomPlaneLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomPlaneLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CustomPlaneLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CustomPlaneLayerItemRouter extends CustomPlaneLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomPlaneLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomPlaneLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICustomPlaneLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICustomPlaneLayerItem iCustomPlaneLayerItem) {
        if (iCustomPlaneLayerItem != null) {
            this.mObserver = iCustomPlaneLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CustomPlaneLayerItem.class, iCustomPlaneLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICustomPlaneLayerItem iCustomPlaneLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomPlaneLayerItemImpl.getCPtr((CustomPlaneLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCustomPlaneLayerItem);
    }

    public CustomPlaneLayerItemRouter(String str, ICustomPlaneLayerItem iCustomPlaneLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomPlaneLayerItem);
    }

    public CustomPlaneLayerItemRouter(String str, ICustomPlaneLayerItem iCustomPlaneLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomPlaneLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomPlaneLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CustomPlaneLayerItemImpl, com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomPlaneLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomPlaneLayerItemImpl
    public int getMType() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomPlaneLayerItemImpl
    public String getMValue() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getMValue();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            iCustomPlaneLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            iCustomPlaneLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            iCustomPlaneLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            iCustomPlaneLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            return iCustomPlaneLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICustomPlaneLayerItem iCustomPlaneLayerItem = this.mObserver;
        if (iCustomPlaneLayerItem != null) {
            iCustomPlaneLayerItem.setAreaCollision(z);
        }
    }
}
