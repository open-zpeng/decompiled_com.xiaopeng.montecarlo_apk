package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.layer.CruiseCongestionItem;
import com.autonavi.gbl.layer.impl.CruiseCongestionItemImpl;
import com.autonavi.gbl.layer.observer.ICruiseCongestionItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CruiseCongestionItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CruiseCongestionItemRouter extends CruiseCongestionItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseCongestionItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CruiseCongestionItemRouter.class);
    private TypeHelper mHelper;
    private ICruiseCongestionItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICruiseCongestionItem iCruiseCongestionItem) {
        if (iCruiseCongestionItem != null) {
            this.mObserver = iCruiseCongestionItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CruiseCongestionItem.class, iCruiseCongestionItem, this);
            }
        }
    }

    private void $constructor(String str, ICruiseCongestionItem iCruiseCongestionItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CruiseCongestionItemImpl.getCPtr((CruiseCongestionItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCruiseCongestionItem);
    }

    public CruiseCongestionItemRouter(String str, ICruiseCongestionItem iCruiseCongestionItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseCongestionItem);
    }

    public CruiseCongestionItemRouter(String str, ICruiseCongestionItem iCruiseCongestionItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseCongestionItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseCongestionItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionItemImpl, com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseCongestionItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionItemImpl
    @TrafficStatus.TrafficStatus1
    public int getMStatus() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getMStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionItemImpl
    public CruiseCongestionInfo getMInfo() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getMInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        $wrapper_getStyle(lineLayerItemStyle);
    }

    private void $wrapper_getStyle(LineLayerItemStyle lineLayerItemStyle) {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionItem.getStyle(), lineLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            iCruiseCongestionItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            iCruiseCongestionItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            iCruiseCongestionItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            iCruiseCongestionItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            return iCruiseCongestionItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICruiseCongestionItem iCruiseCongestionItem = this.mObserver;
        if (iCruiseCongestionItem != null) {
            iCruiseCongestionItem.setAreaCollision(z);
        }
    }
}
