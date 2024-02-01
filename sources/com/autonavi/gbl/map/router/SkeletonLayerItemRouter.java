package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.SkeletonLayerItem;
import com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ActionLastDesc;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.ISkeletonLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.model.RotateAngle;
import java.util.ArrayList;
@IntfAuto(target = SkeletonLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SkeletonLayerItemRouter extends SkeletonLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SkeletonLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SkeletonLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISkeletonLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISkeletonLayerItem iSkeletonLayerItem) {
        if (iSkeletonLayerItem != null) {
            this.mObserver = iSkeletonLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SkeletonLayerItem.class, iSkeletonLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISkeletonLayerItem iSkeletonLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SkeletonLayerItemImpl.getCPtr((SkeletonLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSkeletonLayerItem);
    }

    public SkeletonLayerItemRouter(String str, ISkeletonLayerItem iSkeletonLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSkeletonLayerItem);
    }

    public SkeletonLayerItemRouter(String str, ISkeletonLayerItem iSkeletonLayerItem, IMapViewImpl iMapViewImpl) {
        super(iMapViewImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSkeletonLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl
    public void getPosition(Coord3DDouble coord3DDouble) {
        $wrapper_getPosition(coord3DDouble);
    }

    private void $wrapper_getPosition(Coord3DDouble coord3DDouble) {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSkeletonLayerItem.getPosition(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getPosition copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl
    public void getPosition3D(Coord3DDouble coord3DDouble) {
        $wrapper_getPosition3D(coord3DDouble);
    }

    private void $wrapper_getPosition3D(Coord3DDouble coord3DDouble) {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSkeletonLayerItem.getPosition3D(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getPosition3D copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl
    public void getActionList(ArrayList<ActionLastDesc> arrayList) {
        $wrapper_getActionList(arrayList);
    }

    private void $wrapper_getActionList(ArrayList<ActionLastDesc> arrayList) {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSkeletonLayerItem.getActionList(), arrayList);
            } catch (Exception unused) {
                DebugTool.e("getActionList copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl
    public String getCurrentAction() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getCurrentAction();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl
    public float getScaleRation() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getScaleRation();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl
    public void getScreenBound(RectDouble rectDouble) {
        $wrapper_getScreenBound(rectDouble);
    }

    private void $wrapper_getScreenBound(RectDouble rectDouble) {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSkeletonLayerItem.getScreenBound(), rectDouble);
            } catch (Exception unused) {
                DebugTool.e("getScreenBound copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl
    public RotateAngle getRotateAngles() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getRotateAngles();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            iSkeletonLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            iSkeletonLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            iSkeletonLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            iSkeletonLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            iSkeletonLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ISkeletonLayerItem iSkeletonLayerItem = this.mObserver;
        if (iSkeletonLayerItem != null) {
            return iSkeletonLayerItem.canAreaCollision();
        }
        return false;
    }
}
