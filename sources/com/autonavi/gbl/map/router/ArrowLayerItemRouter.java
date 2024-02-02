package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.map.layer.ArrowLayerItem;
import com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ArrowAnimationPlayState;
import com.autonavi.gbl.map.layer.model.ArrowLayerItemStyle;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IArrowLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = ArrowLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ArrowLayerItemRouter extends ArrowLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ArrowLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(ArrowLayerItemRouter.class);
    private TypeHelper mHelper;
    private IArrowLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IArrowLayerItem iArrowLayerItem) {
        if (iArrowLayerItem != null) {
            this.mObserver = iArrowLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(ArrowLayerItem.class, iArrowLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IArrowLayerItem iArrowLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ArrowLayerItemImpl.getCPtr((ArrowLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iArrowLayerItem);
    }

    public ArrowLayerItemRouter(String str, IArrowLayerItem iArrowLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iArrowLayerItem);
    }

    public ArrowLayerItemRouter(String str, IArrowLayerItem iArrowLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iArrowLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.ArrowLayerItemRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.ArrowLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl
    public void getStyle(ArrowLayerItemStyle arrowLayerItemStyle) {
        $wrapper_getStyle(arrowLayerItemStyle);
    }

    private void $wrapper_getStyle(ArrowLayerItemStyle arrowLayerItemStyle) {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            try {
                TypeUtil.deepcopy(iArrowLayerItem.getStyle(), arrowLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl
    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    public int getAnimationPlayState() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getAnimationPlayState();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            iArrowLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            iArrowLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            return iArrowLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IArrowLayerItem iArrowLayerItem = this.mObserver;
        if (iArrowLayerItem != null) {
            iArrowLayerItem.setAreaCollision(z);
        }
    }
}
