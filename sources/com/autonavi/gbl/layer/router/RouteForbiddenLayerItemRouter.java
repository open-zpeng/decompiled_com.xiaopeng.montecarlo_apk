package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.ForbiddenCloudControl;
import com.autonavi.gbl.layer.RouteForbiddenLayerItem;
import com.autonavi.gbl.layer.impl.RouteForbiddenLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteForbiddenLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = RouteForbiddenLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class RouteForbiddenLayerItemRouter extends RouteForbiddenLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteForbiddenLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteForbiddenLayerItemRouter.class);
    private TypeHelper mHelper;
    private IRouteForbiddenLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRouteForbiddenLayerItem iRouteForbiddenLayerItem) {
        if (iRouteForbiddenLayerItem != null) {
            this.mObserver = iRouteForbiddenLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RouteForbiddenLayerItem.class, iRouteForbiddenLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IRouteForbiddenLayerItem iRouteForbiddenLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RouteForbiddenLayerItemImpl.getCPtr((RouteForbiddenLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRouteForbiddenLayerItem);
    }

    public RouteForbiddenLayerItemRouter(String str, IRouteForbiddenLayerItem iRouteForbiddenLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteForbiddenLayerItem);
    }

    public RouteForbiddenLayerItemRouter(String str, IRouteForbiddenLayerItem iRouteForbiddenLayerItem, ForbiddenCloudControl forbiddenCloudControl) {
        super(forbiddenCloudControl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteForbiddenLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteForbiddenLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.RouteForbiddenLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.RouteForbiddenLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.RouteForbiddenLayerItemImpl
    public ForbiddenCloudControl getMForbiddenCloud() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getMForbiddenCloud();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteForbiddenLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteForbiddenLayerItem.getRotateCenter3D(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getRotateCenter3D copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getPosition(Coord3DDouble coord3DDouble) {
        $wrapper_getPosition(coord3DDouble);
    }

    private void $wrapper_getPosition(Coord3DDouble coord3DDouble) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteForbiddenLayerItem.getPosition(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getPosition copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        $wrapper_getNormalStyle(pointLayerItemStyle);
    }

    private void $wrapper_getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteForbiddenLayerItem.getNormalStyle(), pointLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getNormalStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        $wrapper_getFocusStyle(pointLayerItemStyle);
    }

    private void $wrapper_getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteForbiddenLayerItem.getFocusStyle(), pointLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getFocusStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        $wrapper_getItemIgnoreRegion(itemIgnoreRegion);
    }

    private void $wrapper_getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteForbiddenLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
            } catch (Exception unused) {
                DebugTool.e("getItemIgnoreRegion copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getScale(ScaleAttribute scaleAttribute) {
        $wrapper_getScale(scaleAttribute);
    }

    private void $wrapper_getScale(ScaleAttribute scaleAttribute) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            try {
                TypeUtil.deepcopy(iRouteForbiddenLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            iRouteForbiddenLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            iRouteForbiddenLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            return iRouteForbiddenLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IRouteForbiddenLayerItem iRouteForbiddenLayerItem = this.mObserver;
        if (iRouteForbiddenLayerItem != null) {
            iRouteForbiddenLayerItem.setAreaCollision(z);
        }
    }
}
