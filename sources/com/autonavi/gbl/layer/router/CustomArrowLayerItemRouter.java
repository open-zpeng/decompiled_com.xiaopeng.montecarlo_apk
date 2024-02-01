package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.layer.CustomArrowLayerItem;
import com.autonavi.gbl.layer.impl.CustomArrowLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomArrowLayerItem;
import com.autonavi.gbl.map.layer.model.ArrowAnimationPlayState;
import com.autonavi.gbl.map.layer.model.ArrowLayerItemStyle;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CustomArrowLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CustomArrowLayerItemRouter extends CustomArrowLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomArrowLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomArrowLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICustomArrowLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICustomArrowLayerItem iCustomArrowLayerItem) {
        if (iCustomArrowLayerItem != null) {
            this.mObserver = iCustomArrowLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CustomArrowLayerItem.class, iCustomArrowLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICustomArrowLayerItem iCustomArrowLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomArrowLayerItemImpl.getCPtr((CustomArrowLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCustomArrowLayerItem);
    }

    public CustomArrowLayerItemRouter(String str, ICustomArrowLayerItem iCustomArrowLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomArrowLayerItem);
    }

    public CustomArrowLayerItemRouter(String str, ICustomArrowLayerItem iCustomArrowLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomArrowLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.CustomArrowLayerItemImpl, com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomArrowLayerItemImpl
    public int getMType() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomArrowLayerItemImpl
    public String getMValue() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getMValue();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl
    public void getStyle(ArrowLayerItemStyle arrowLayerItemStyle) {
        $wrapper_getStyle(arrowLayerItemStyle);
    }

    private void $wrapper_getStyle(ArrowLayerItemStyle arrowLayerItemStyle) {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomArrowLayerItem.getStyle(), arrowLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl
    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    public int getAnimationPlayState() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getAnimationPlayState();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            iCustomArrowLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            iCustomArrowLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            iCustomArrowLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            iCustomArrowLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            iCustomArrowLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ICustomArrowLayerItem iCustomArrowLayerItem = this.mObserver;
        if (iCustomArrowLayerItem != null) {
            return iCustomArrowLayerItem.canAreaCollision();
        }
        return false;
    }
}
