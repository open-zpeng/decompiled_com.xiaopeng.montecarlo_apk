package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.layer.GuideLabelLayerItem;
import com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideLabelLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideLabelLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class GuideLabelLayerItemRouter extends GuideLabelLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideLabelLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideLabelLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideLabelLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideLabelLayerItem iGuideLabelLayerItem) {
        if (iGuideLabelLayerItem != null) {
            this.mObserver = iGuideLabelLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideLabelLayerItem.class, iGuideLabelLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideLabelLayerItem iGuideLabelLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideLabelLayerItemImpl.getCPtr((GuideLabelLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideLabelLayerItem);
    }

    public GuideLabelLayerItemRouter(String str, IGuideLabelLayerItem iGuideLabelLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideLabelLayerItem);
    }

    public GuideLabelLayerItemRouter(String str, IGuideLabelLayerItem iGuideLabelLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideLabelLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideLabelLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideLabelLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            iGuideLabelLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public int getMLabelIndex() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMLabelIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public long getMPathCost() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMPathCost();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public int getMAlterPathIndx() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMAlterPathIndx();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public long getMPathId() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public int getMCostDiff() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMCostDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public int getMDistanceDiff() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMDistanceDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public int getMTravelTimeDiff() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMTravelTimeDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public int getMTrafficLightDiff() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMTrafficLightDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMBoardStyle() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMBoardStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public String getMRoadName() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMRoadName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    @Formway.Formway1
    public int getMRoadFormway() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMRoadFormway();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public boolean getMPreviewMode() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMPreviewMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl
    public boolean getMIsFaster() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMIsFaster();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    public float getIntersectArea() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    public long getQuadrantGroupId() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideLabelLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideLabelLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideLabelLayerItem.getPosition(), coord3DDouble);
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
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideLabelLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideLabelLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideLabelLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideLabelLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            iGuideLabelLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            return iGuideLabelLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideLabelLayerItem iGuideLabelLayerItem = this.mObserver;
        if (iGuideLabelLayerItem != null) {
            iGuideLabelLayerItem.setAreaCollision(z);
        }
    }
}
