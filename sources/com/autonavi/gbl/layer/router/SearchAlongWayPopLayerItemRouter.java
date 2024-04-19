package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.SearchAlongWayPopLayerItem;
import com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.layer.observer.ISearchAlongWayPopLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SearchAlongWayPopLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SearchAlongWayPopLayerItemRouter extends SearchAlongWayPopLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchAlongWayPopLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SearchAlongWayPopLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISearchAlongWayPopLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem) {
        if (iSearchAlongWayPopLayerItem != null) {
            this.mObserver = iSearchAlongWayPopLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SearchAlongWayPopLayerItem.class, iSearchAlongWayPopLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SearchAlongWayPopLayerItemImpl.getCPtr((SearchAlongWayPopLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSearchAlongWayPopLayerItem);
    }

    public SearchAlongWayPopLayerItemRouter(String str, ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchAlongWayPopLayerItem);
    }

    public SearchAlongWayPopLayerItemRouter(String str, ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem, @QuadrantType.QuadrantType1 int i, long j, BizSearchAlongWayPoint bizSearchAlongWayPoint, @AlongWayLabelType.AlongWayLabelType1 int i2) {
        super(i, j, bizSearchAlongWayPoint, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchAlongWayPopLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchAlongWayPopLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchAlongWayPopLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl
    public int getMSearchType() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getMSearchType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl
    public int getMTypeCode() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getMTypeCode();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl
    @AlongWayLabelType.AlongWayLabelType1
    public int getMLabelType() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getMLabelType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl
    public String getMName() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getMName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl
    public SearchAlongWayExtraData getMExtraData() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getMExtraData();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayPopLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayPopLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayPopLayerItem.getPosition(), coord3DDouble);
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
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayPopLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayPopLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayPopLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchAlongWayPopLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            iSearchAlongWayPopLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            iSearchAlongWayPopLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            iSearchAlongWayPopLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            iSearchAlongWayPopLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            return iSearchAlongWayPopLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISearchAlongWayPopLayerItem iSearchAlongWayPopLayerItem = this.mObserver;
        if (iSearchAlongWayPopLayerItem != null) {
            iSearchAlongWayPopLayerItem.setAreaCollision(z);
        }
    }
}
