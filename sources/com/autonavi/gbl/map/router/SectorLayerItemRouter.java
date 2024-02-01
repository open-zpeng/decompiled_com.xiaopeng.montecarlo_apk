package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.map.layer.SectorLayerItem;
import com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.SectorAngles;
import com.autonavi.gbl.map.layer.observer.ISectorLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SectorLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SectorLayerItemRouter extends SectorLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SectorLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SectorLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISectorLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISectorLayerItem iSectorLayerItem) {
        if (iSectorLayerItem != null) {
            this.mObserver = iSectorLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SectorLayerItem.class, iSectorLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISectorLayerItem iSectorLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SectorLayerItemImpl.getCPtr((SectorLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSectorLayerItem);
    }

    public SectorLayerItemRouter(String str, ISectorLayerItem iSectorLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSectorLayerItem);
    }

    public SectorLayerItemRouter(String str, ISectorLayerItem iSectorLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSectorLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl
    public double getRadius() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getRadius();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl
    public void getSectorAngles(SectorAngles sectorAngles) {
        $wrapper_getSectorAngles(sectorAngles);
    }

    private void $wrapper_getSectorAngles(SectorAngles sectorAngles) {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSectorLayerItem.getSectorAngles(), sectorAngles);
            } catch (Exception unused) {
                DebugTool.e("getSectorAngles copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl
    public long getColor() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getColor();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            iSectorLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            iSectorLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            iSectorLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            iSectorLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            iSectorLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ISectorLayerItem iSectorLayerItem = this.mObserver;
        if (iSectorLayerItem != null) {
            return iSectorLayerItem.canAreaCollision();
        }
        return false;
    }
}
