package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.CustomPolygonLayerItem;
import com.autonavi.gbl.layer.impl.CustomPolygonLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomPolygonLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CustomPolygonLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CustomPolygonLayerItemRouter extends CustomPolygonLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomPolygonLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomPolygonLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICustomPolygonLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICustomPolygonLayerItem iCustomPolygonLayerItem) {
        if (iCustomPolygonLayerItem != null) {
            this.mObserver = iCustomPolygonLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CustomPolygonLayerItem.class, iCustomPolygonLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICustomPolygonLayerItem iCustomPolygonLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomPolygonLayerItemImpl.getCPtr((CustomPolygonLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCustomPolygonLayerItem);
    }

    public CustomPolygonLayerItemRouter(String str, ICustomPolygonLayerItem iCustomPolygonLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomPolygonLayerItem);
    }

    public CustomPolygonLayerItemRouter(String str, ICustomPolygonLayerItem iCustomPolygonLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomPolygonLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomPolygonLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CustomPolygonLayerItemImpl, com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomPolygonLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomPolygonLayerItemImpl
    public int getMType() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomPolygonLayerItemImpl
    public String getMValue() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getMValue();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl
    public long getColor() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getColor();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            iCustomPolygonLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            iCustomPolygonLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            return iCustomPolygonLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICustomPolygonLayerItem iCustomPolygonLayerItem = this.mObserver;
        if (iCustomPolygonLayerItem != null) {
            iCustomPolygonLayerItem.setAreaCollision(z);
        }
    }
}
