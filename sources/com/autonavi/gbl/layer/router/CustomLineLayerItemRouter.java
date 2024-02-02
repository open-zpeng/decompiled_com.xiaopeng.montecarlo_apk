package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.layer.CustomLineLayerItem;
import com.autonavi.gbl.layer.impl.CustomLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomLineLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CustomLineLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CustomLineLayerItemRouter extends CustomLineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomLineLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomLineLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICustomLineLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICustomLineLayerItem iCustomLineLayerItem) {
        if (iCustomLineLayerItem != null) {
            this.mObserver = iCustomLineLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CustomLineLayerItem.class, iCustomLineLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICustomLineLayerItem iCustomLineLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomLineLayerItemImpl.getCPtr((CustomLineLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCustomLineLayerItem);
    }

    public CustomLineLayerItemRouter(String str, ICustomLineLayerItem iCustomLineLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomLineLayerItem);
    }

    public CustomLineLayerItemRouter(String str, ICustomLineLayerItem iCustomLineLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomLineLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomLineLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CustomLineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomLineLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomLineLayerItemImpl
    public int getMType() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomLineLayerItemImpl
    public String getMValue() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getMValue();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        $wrapper_getStyle(lineLayerItemStyle);
    }

    private void $wrapper_getStyle(LineLayerItemStyle lineLayerItemStyle) {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomLineLayerItem.getStyle(), lineLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            iCustomLineLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            iCustomLineLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            return iCustomLineLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICustomLineLayerItem iCustomLineLayerItem = this.mObserver;
        if (iCustomLineLayerItem != null) {
            iCustomLineLayerItem.setAreaCollision(z);
        }
    }
}
