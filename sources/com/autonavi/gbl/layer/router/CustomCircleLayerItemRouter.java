package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.layer.CustomCircleLayerItem;
import com.autonavi.gbl.layer.impl.CustomCircleLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomCircleLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.SectorAngles;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CustomCircleLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CustomCircleLayerItemRouter extends CustomCircleLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomCircleLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomCircleLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICustomCircleLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICustomCircleLayerItem iCustomCircleLayerItem) {
        if (iCustomCircleLayerItem != null) {
            this.mObserver = iCustomCircleLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CustomCircleLayerItem.class, iCustomCircleLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICustomCircleLayerItem iCustomCircleLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomCircleLayerItemImpl.getCPtr((CustomCircleLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCustomCircleLayerItem);
    }

    public CustomCircleLayerItemRouter(String str, ICustomCircleLayerItem iCustomCircleLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomCircleLayerItem);
    }

    public CustomCircleLayerItemRouter(String str, ICustomCircleLayerItem iCustomCircleLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomCircleLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomCircleLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CustomCircleLayerItemImpl, com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomCircleLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomCircleLayerItemImpl
    public int getMType() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomCircleLayerItemImpl
    public String getMValue() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getMValue();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl
    public double getRadius() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getRadius();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl
    public void getSectorAngles(SectorAngles sectorAngles) {
        $wrapper_getSectorAngles(sectorAngles);
    }

    private void $wrapper_getSectorAngles(SectorAngles sectorAngles) {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomCircleLayerItem.getSectorAngles(), sectorAngles);
            } catch (Exception unused) {
                DebugTool.e("getSectorAngles copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl
    public long getColor() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getColor();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            iCustomCircleLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            iCustomCircleLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            iCustomCircleLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            iCustomCircleLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            return iCustomCircleLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICustomCircleLayerItem iCustomCircleLayerItem = this.mObserver;
        if (iCustomCircleLayerItem != null) {
            iCustomCircleLayerItem.setAreaCollision(z);
        }
    }
}
