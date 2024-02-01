package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.LightBeamLayerItem;
import com.autonavi.gbl.map.layer.impl.LightBeamLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.ILightBeamLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LightBeamLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LightBeamLayerItemRouter extends LightBeamLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LightBeamLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LightBeamLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILightBeamLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILightBeamLayerItem iLightBeamLayerItem) {
        if (iLightBeamLayerItem != null) {
            this.mObserver = iLightBeamLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LightBeamLayerItem.class, iLightBeamLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILightBeamLayerItem iLightBeamLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LightBeamLayerItemImpl.getCPtr((LightBeamLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLightBeamLayerItem);
    }

    public LightBeamLayerItemRouter(String str, ILightBeamLayerItem iLightBeamLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLightBeamLayerItem);
    }

    public LightBeamLayerItemRouter(String str, ILightBeamLayerItem iLightBeamLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLightBeamLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LightBeamLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LightBeamLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            iLightBeamLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            iLightBeamLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            iLightBeamLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            iLightBeamLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            iLightBeamLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILightBeamLayerItem iLightBeamLayerItem = this.mObserver;
        if (iLightBeamLayerItem != null) {
            return iLightBeamLayerItem.canAreaCollision();
        }
        return false;
    }
}
