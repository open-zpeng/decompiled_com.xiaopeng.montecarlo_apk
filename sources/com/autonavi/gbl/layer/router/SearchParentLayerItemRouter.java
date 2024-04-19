package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.SearchParentLayerItem;
import com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl;
import com.autonavi.gbl.layer.model.PoiParentType;
import com.autonavi.gbl.layer.observer.ISearchParentLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SearchParentLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SearchParentLayerItemRouter extends SearchParentLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchParentLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SearchParentLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISearchParentLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISearchParentLayerItem iSearchParentLayerItem) {
        if (iSearchParentLayerItem != null) {
            this.mObserver = iSearchParentLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SearchParentLayerItem.class, iSearchParentLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISearchParentLayerItem iSearchParentLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SearchParentLayerItemImpl.getCPtr((SearchParentLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSearchParentLayerItem);
    }

    public SearchParentLayerItemRouter(String str, ISearchParentLayerItem iSearchParentLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchParentLayerItem);
    }

    public SearchParentLayerItemRouter(String str, ISearchParentLayerItem iSearchParentLayerItem, @PoiParentType.PoiParentType1 int i, int i2, int i3, String str2, String str3, String str4) {
        super(i, i2, i3, str2, str3, str4);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchParentLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchParentLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchParentLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl
    @PoiParentType.PoiParentType1
    public int getPoiType() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getPoiType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl
    public int getTypeCode() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getTypeCode();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl
    public int getMIndex() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getMIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl
    public String getMText() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getMText();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl
    public String getPoiName() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getPoiName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl
    public String getMMarkerBGRes() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getMMarkerBGRes();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchParentLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchParentLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchParentLayerItem.getPosition(), coord3DDouble);
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
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchParentLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchParentLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchParentLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchParentLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            iSearchParentLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            iSearchParentLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            iSearchParentLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            iSearchParentLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            return iSearchParentLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISearchParentLayerItem iSearchParentLayerItem = this.mObserver;
        if (iSearchParentLayerItem != null) {
            iSearchParentLayerItem.setAreaCollision(z);
        }
    }
}
