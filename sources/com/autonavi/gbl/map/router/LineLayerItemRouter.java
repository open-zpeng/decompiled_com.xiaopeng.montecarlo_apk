package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.map.layer.LineLayerItem;
import com.autonavi.gbl.map.layer.impl.LineLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.layer.observer.ILineLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LineLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LineLayerItemRouter extends LineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LineLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LineLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILineLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILineLayerItem iLineLayerItem) {
        if (iLineLayerItem != null) {
            this.mObserver = iLineLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LineLayerItem.class, iLineLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILineLayerItem iLineLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LineLayerItemImpl.getCPtr((LineLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLineLayerItem);
    }

    public LineLayerItemRouter(String str, ILineLayerItem iLineLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLineLayerItem);
    }

    public LineLayerItemRouter(String str, ILineLayerItem iLineLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLineLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        $wrapper_getStyle(lineLayerItemStyle);
    }

    private void $wrapper_getStyle(LineLayerItemStyle lineLayerItemStyle) {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLineLayerItem.getStyle(), lineLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl
    public long getPointsCount() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getPointsCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            iLineLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            iLineLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            iLineLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            iLineLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            iLineLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILineLayerItem iLineLayerItem = this.mObserver;
        if (iLineLayerItem != null) {
            return iLineLayerItem.canAreaCollision();
        }
        return false;
    }
}
