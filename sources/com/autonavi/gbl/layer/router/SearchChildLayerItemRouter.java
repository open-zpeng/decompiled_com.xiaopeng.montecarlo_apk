package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.SearchChildLayerItem;
import com.autonavi.gbl.layer.impl.SearchChildLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISearchChildLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SearchChildLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SearchChildLayerItemRouter extends SearchChildLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchChildLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SearchChildLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISearchChildLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISearchChildLayerItem iSearchChildLayerItem) {
        if (iSearchChildLayerItem != null) {
            this.mObserver = iSearchChildLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SearchChildLayerItem.class, iSearchChildLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISearchChildLayerItem iSearchChildLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SearchChildLayerItemImpl.getCPtr((SearchChildLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSearchChildLayerItem);
    }

    public SearchChildLayerItemRouter(String str, ISearchChildLayerItem iSearchChildLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchChildLayerItem);
    }

    public SearchChildLayerItemRouter(String str, ISearchChildLayerItem iSearchChildLayerItem, int i, String str2) {
        super(i, str2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchChildLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchChildLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.SearchChildLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchChildLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChildLayerItemImpl
    public int getMChildType() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getMChildType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchChildLayerItemImpl
    public String getMShortName() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getMShortName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChildLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChildLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChildLayerItem.getPosition(), coord3DDouble);
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
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChildLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChildLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChildLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchChildLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            iSearchChildLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            iSearchChildLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            iSearchChildLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            iSearchChildLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            return iSearchChildLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISearchChildLayerItem iSearchChildLayerItem = this.mObserver;
        if (iSearchChildLayerItem != null) {
            iSearchChildLayerItem.setAreaCollision(z);
        }
    }
}
