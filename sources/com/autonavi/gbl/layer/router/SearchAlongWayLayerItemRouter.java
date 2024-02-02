package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.SearchAlongWayLayerItem;
import com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.layer.model.SearchAlongwayType;
import com.autonavi.gbl.layer.observer.ISearchAlongWayLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SearchAlongWayLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class SearchAlongWayLayerItemRouter extends SearchAlongWayLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchAlongWayLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SearchAlongWayLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISearchAlongWayLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISearchAlongWayLayerItem iSearchAlongWayLayerItem) {
        if (iSearchAlongWayLayerItem != null) {
            this.mObserver = iSearchAlongWayLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SearchAlongWayLayerItem.class, iSearchAlongWayLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISearchAlongWayLayerItem iSearchAlongWayLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SearchAlongWayLayerItemImpl.getCPtr((SearchAlongWayLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSearchAlongWayLayerItem);
    }

    public SearchAlongWayLayerItemRouter(String str, ISearchAlongWayLayerItem iSearchAlongWayLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchAlongWayLayerItem);
    }

    public SearchAlongWayLayerItemRouter(String str, ISearchAlongWayLayerItem iSearchAlongWayLayerItem, SearchAlongWayExtraData searchAlongWayExtraData, @SearchAlongwayType.SearchAlongwayType1 int i, @AlongWayLabelType.AlongWayLabelType1 int i2, int i3, String str2) {
        super(searchAlongWayExtraData, i, i2, i3, str2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchAlongWayLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchAlongWayLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchAlongWayLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl
    @SearchAlongwayType.SearchAlongwayType1
    public int getMSearchType() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getMSearchType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl
    @AlongWayLabelType.AlongWayLabelType1
    public int getMLabelType() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getMLabelType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl
    public int getMTypeCode() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getMTypeCode();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl
    public String getMName() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getMName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl
    public SearchAlongWayExtraData getMExtraData() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getMExtraData();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayLayerItem.getPosition(), coord3DDouble);
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
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            iSearchAlongWayLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            iSearchAlongWayLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            return iSearchAlongWayLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISearchAlongWayLayerItem iSearchAlongWayLayerItem = this.mObserver;
        if (iSearchAlongWayLayerItem != null) {
            iSearchAlongWayLayerItem.setAreaCollision(z);
        }
    }
}
