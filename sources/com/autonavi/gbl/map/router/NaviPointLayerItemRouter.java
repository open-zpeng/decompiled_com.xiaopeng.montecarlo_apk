package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.NaviPointLayerItem;
import com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.INaviPointLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = NaviPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class NaviPointLayerItemRouter extends NaviPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(NaviPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(NaviPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private INaviPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(INaviPointLayerItem iNaviPointLayerItem) {
        if (iNaviPointLayerItem != null) {
            this.mObserver = iNaviPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(NaviPointLayerItem.class, iNaviPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, INaviPointLayerItem iNaviPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(NaviPointLayerItemImpl.getCPtr((NaviPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iNaviPointLayerItem);
    }

    public NaviPointLayerItemRouter(String str, INaviPointLayerItem iNaviPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNaviPointLayerItem);
    }

    public NaviPointLayerItemRouter(String str, INaviPointLayerItem iNaviPointLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNaviPointLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public boolean getBillboard() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl
    public void getPosition3D(Coord3DDouble coord3DDouble) {
        $wrapper_getPosition3D(coord3DDouble);
    }

    private void $wrapper_getPosition3D(Coord3DDouble coord3DDouble) {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getPosition3D(), coord3DDouble);
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
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getPosition(), coord3DDouble);
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
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getItemVisibleRegion(), rectInt);
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
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iNaviPointLayerItem.getScale(), scaleInfo);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            iNaviPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            iNaviPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            iNaviPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            iNaviPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            iNaviPointLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        INaviPointLayerItem iNaviPointLayerItem = this.mObserver;
        if (iNaviPointLayerItem != null) {
            return iNaviPointLayerItem.canAreaCollision();
        }
        return false;
    }
}
