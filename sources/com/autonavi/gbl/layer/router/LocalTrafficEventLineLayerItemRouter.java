package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.layer.LocalTrafficEventLineLayerItem;
import com.autonavi.gbl.layer.impl.LocalTrafficEventLineLayerItemImpl;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import com.autonavi.gbl.layer.observer.ILocalTrafficEventLineLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LocalTrafficEventLineLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LocalTrafficEventLineLayerItemRouter extends LocalTrafficEventLineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LocalTrafficEventLineLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LocalTrafficEventLineLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILocalTrafficEventLineLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem) {
        if (iLocalTrafficEventLineLayerItem != null) {
            this.mObserver = iLocalTrafficEventLineLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LocalTrafficEventLineLayerItem.class, iLocalTrafficEventLineLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LocalTrafficEventLineLayerItemImpl.getCPtr((LocalTrafficEventLineLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLocalTrafficEventLineLayerItem);
    }

    public LocalTrafficEventLineLayerItemRouter(String str, ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLocalTrafficEventLineLayerItem);
    }

    public LocalTrafficEventLineLayerItemRouter(String str, ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem, @LocalTrafficEventType.LocalTrafficEventType1 int i, String str2, @RoadClass.RoadClass1 int i2) {
        super(i, str2, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLocalTrafficEventLineLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventLineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventLineLayerItemImpl
    @LocalTrafficEventType.LocalTrafficEventType1
    public int getEventType() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getEventType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventLineLayerItemImpl
    public String getEventID() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getEventID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventLineLayerItemImpl
    @RoadClass.RoadClass1
    public int getRoadClass() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getRoadClass();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        $wrapper_getStyle(lineLayerItemStyle);
    }

    private void $wrapper_getStyle(LineLayerItemStyle lineLayerItemStyle) {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventLineLayerItem.getStyle(), lineLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public long getPointsCount() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getPointsCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            iLocalTrafficEventLineLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            iLocalTrafficEventLineLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            iLocalTrafficEventLineLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            iLocalTrafficEventLineLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            iLocalTrafficEventLineLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILocalTrafficEventLineLayerItem iLocalTrafficEventLineLayerItem = this.mObserver;
        if (iLocalTrafficEventLineLayerItem != null) {
            return iLocalTrafficEventLineLayerItem.canAreaCollision();
        }
        return false;
    }
}
