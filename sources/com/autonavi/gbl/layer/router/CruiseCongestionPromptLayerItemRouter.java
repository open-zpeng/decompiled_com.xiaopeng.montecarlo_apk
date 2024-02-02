package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.layer.CruiseCongestionPromptLayerItem;
import com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.ICruiseCongestionPromptLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CruiseCongestionPromptLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CruiseCongestionPromptLayerItemRouter extends CruiseCongestionPromptLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseCongestionPromptLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CruiseCongestionPromptLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICruiseCongestionPromptLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem) {
        if (iCruiseCongestionPromptLayerItem != null) {
            this.mObserver = iCruiseCongestionPromptLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CruiseCongestionPromptLayerItem.class, iCruiseCongestionPromptLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CruiseCongestionPromptLayerItemImpl.getCPtr((CruiseCongestionPromptLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCruiseCongestionPromptLayerItem);
    }

    public CruiseCongestionPromptLayerItemRouter(String str, ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseCongestionPromptLayerItem);
    }

    public CruiseCongestionPromptLayerItemRouter(String str, ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseCongestionPromptLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseCongestionPromptLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseCongestionPromptLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    public int getMEtaTime() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMEtaTime();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    public int getMLength() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMLength();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    public long getMEnterTime() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMEnterTime();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    public Coord2DDouble getMEnterCarPos() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMEnterCarPos();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    public Coord2DDouble getMCongestionEndPos() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMCongestionEndPos();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    @TrafficStatus.TrafficStatus1
    public int getMCongestionStatus() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMCongestionStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl
    public String getMCongestionDetail() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMCongestionDetail();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            iCruiseCongestionPromptLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    public float getIntersectArea() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    public long getQuadrantGroupId() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionPromptLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionPromptLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionPromptLayerItem.getPosition(), coord3DDouble);
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
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionPromptLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionPromptLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionPromptLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionPromptLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            iCruiseCongestionPromptLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            return iCruiseCongestionPromptLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICruiseCongestionPromptLayerItem iCruiseCongestionPromptLayerItem = this.mObserver;
        if (iCruiseCongestionPromptLayerItem != null) {
            iCruiseCongestionPromptLayerItem.setAreaCollision(z);
        }
    }
}
