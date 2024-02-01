package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.SearchChargeStationLayerItem;
import com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl;
import com.autonavi.gbl.layer.model.BizChargeStationInfo;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.layer.observer.ISearchChargeStationLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SearchChargeStationLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SearchChargeStationLayerItemRouter extends SearchChargeStationLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchChargeStationLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SearchChargeStationLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISearchChargeStationLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISearchChargeStationLayerItem iSearchChargeStationLayerItem) {
        if (iSearchChargeStationLayerItem != null) {
            this.mObserver = iSearchChargeStationLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SearchChargeStationLayerItem.class, iSearchChargeStationLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISearchChargeStationLayerItem iSearchChargeStationLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SearchChargeStationLayerItemImpl.getCPtr((SearchChargeStationLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSearchChargeStationLayerItem);
    }

    public SearchChargeStationLayerItemRouter(String str, ISearchChargeStationLayerItem iSearchChargeStationLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchChargeStationLayerItem);
    }

    public SearchChargeStationLayerItemRouter(String str, ISearchChargeStationLayerItem iSearchChargeStationLayerItem, BizSearchChargeStationInfo bizSearchChargeStationInfo) {
        super(bizSearchChargeStationInfo);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchChargeStationLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            iSearchChargeStationLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl
    public void onVisible3V(Visible3V visible3V) {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            iSearchChargeStationLayerItem.onVisible3V(visible3V);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl
    public Visible3V getOnVisible3V() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getOnVisible3V();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl
    public BizChargeStationInfo getMChargeStationInfo() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getMChargeStationInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChargeStationLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChargeStationLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChargeStationLayerItem.getPosition(), coord3DDouble);
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
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChargeStationLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChargeStationLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChargeStationLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChargeStationLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            iSearchChargeStationLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            iSearchChargeStationLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            iSearchChargeStationLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            iSearchChargeStationLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ISearchChargeStationLayerItem iSearchChargeStationLayerItem = this.mObserver;
        if (iSearchChargeStationLayerItem != null) {
            return iSearchChargeStationLayerItem.canAreaCollision();
        }
        return false;
    }
}
