package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.SpeedCarLayerItem;
import com.autonavi.gbl.layer.impl.SpeedCarLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISpeedCarLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SpeedCarLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class SpeedCarLayerItemRouter extends SpeedCarLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SpeedCarLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SpeedCarLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISpeedCarLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISpeedCarLayerItem iSpeedCarLayerItem) {
        if (iSpeedCarLayerItem != null) {
            this.mObserver = iSpeedCarLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SpeedCarLayerItem.class, iSpeedCarLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISpeedCarLayerItem iSpeedCarLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SpeedCarLayerItemImpl.getCPtr((SpeedCarLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSpeedCarLayerItem);
    }

    public SpeedCarLayerItemRouter(String str, ISpeedCarLayerItem iSpeedCarLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSpeedCarLayerItem);
    }

    public SpeedCarLayerItemRouter(String str, ISpeedCarLayerItem iSpeedCarLayerItem, boolean z) {
        super(z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSpeedCarLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SpeedCarLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.SpeedCarLayerItemImpl, com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SpeedCarLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SpeedCarLayerItemImpl
    public boolean getBBackGround() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getBBackGround();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public boolean getBillboard() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getPosition3D(Coord3DDouble coord3DDouble) {
        $wrapper_getPosition3D(coord3DDouble);
    }

    private void $wrapper_getPosition3D(Coord3DDouble coord3DDouble) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getPosition3D(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getPosition3D copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getRotateCenter3D(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getRotateCenter3D copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getPosition(Coord3DDouble coord3DDouble) {
        $wrapper_getPosition(coord3DDouble);
    }

    private void $wrapper_getPosition(Coord3DDouble coord3DDouble) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getPosition(), coord3DDouble);
            } catch (Exception unused) {
                DebugTool.e("getPosition copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        $wrapper_getNormalStyle(pointLayerItemStyle);
    }

    private void $wrapper_getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getNormalStyle(), pointLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getNormalStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        $wrapper_getFocusStyle(pointLayerItemStyle);
    }

    private void $wrapper_getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getFocusStyle(), pointLayerItemStyle);
            } catch (Exception unused) {
                DebugTool.e("getFocusStyle copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getItemVisibleRegion(RectInt rectInt) {
        $wrapper_getItemVisibleRegion(rectInt);
    }

    private void $wrapper_getItemVisibleRegion(RectInt rectInt) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getItemVisibleRegion(), rectInt);
            } catch (Exception unused) {
                DebugTool.e("getItemVisibleRegion copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        $wrapper_getItemIgnoreRegion(itemIgnoreRegion);
    }

    private void $wrapper_getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
            } catch (Exception unused) {
                DebugTool.e("getItemIgnoreRegion copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getScale(ScaleInfo scaleInfo) {
        $wrapper_getScale(scaleInfo);
    }

    private void $wrapper_getScale(ScaleInfo scaleInfo) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSpeedCarLayerItem.getScale(), scaleInfo);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            iSpeedCarLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            iSpeedCarLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            return iSpeedCarLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISpeedCarLayerItem iSpeedCarLayerItem = this.mObserver;
        if (iSpeedCarLayerItem != null) {
            iSpeedCarLayerItem.setAreaCollision(z);
        }
    }
}
