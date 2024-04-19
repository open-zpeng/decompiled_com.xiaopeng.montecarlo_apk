package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.layer.CommonLineLayerItem;
import com.autonavi.gbl.layer.impl.CommonLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICommonLineLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CommonLineLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CommonLineLayerItemRouter extends CommonLineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CommonLineLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CommonLineLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICommonLineLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICommonLineLayerItem iCommonLineLayerItem) {
        if (iCommonLineLayerItem != null) {
            this.mObserver = iCommonLineLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CommonLineLayerItem.class, iCommonLineLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICommonLineLayerItem iCommonLineLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CommonLineLayerItemImpl.getCPtr((CommonLineLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCommonLineLayerItem);
    }

    public CommonLineLayerItemRouter(String str, ICommonLineLayerItem iCommonLineLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCommonLineLayerItem);
    }

    public CommonLineLayerItemRouter(String str, ICommonLineLayerItem iCommonLineLayerItem, int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCommonLineLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CommonLineLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CommonLineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CommonLineLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CommonLineLayerItemImpl
    public int getMType() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        $wrapper_getStyle(lineLayerItemStyle);
    }

    private void $wrapper_getStyle(LineLayerItemStyle lineLayerItemStyle) {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCommonLineLayerItem.getStyle(), lineLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            iCommonLineLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            iCommonLineLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            iCommonLineLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            iCommonLineLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            return iCommonLineLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICommonLineLayerItem iCommonLineLayerItem = this.mObserver;
        if (iCommonLineLayerItem != null) {
            iCommonLineLayerItem.setAreaCollision(z);
        }
    }
}
