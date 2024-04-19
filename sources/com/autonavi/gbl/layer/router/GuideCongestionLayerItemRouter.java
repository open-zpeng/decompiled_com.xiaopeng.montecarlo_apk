package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.layer.GuideCongestionLayerItem;
import com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideCongestionLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideCongestionLayerItemRouter extends GuideCongestionLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideCongestionLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideCongestionLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideCongestionLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideCongestionLayerItem iGuideCongestionLayerItem) {
        if (iGuideCongestionLayerItem != null) {
            this.mObserver = iGuideCongestionLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideCongestionLayerItem.class, iGuideCongestionLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideCongestionLayerItem iGuideCongestionLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideCongestionLayerItemImpl.getCPtr((GuideCongestionLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideCongestionLayerItem);
    }

    public GuideCongestionLayerItemRouter(String str, IGuideCongestionLayerItem iGuideCongestionLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideCongestionLayerItem);
    }

    public GuideCongestionLayerItemRouter(String str, IGuideCongestionLayerItem iGuideCongestionLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideCongestionLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideCongestionLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.GuideCongestionLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    @TrafficStatus.TrafficStatus1
    public int getMCongestionStatus() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMCongestionStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    public String getMTimeInfo() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMTimeInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    public CongestExtend getMCongestExtend() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMCongestExtend();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    public int getMLayerTag() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMLayerTag();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    public long getMRemainDist() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    public long getMTotalTimeOfSeconds() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMTotalTimeOfSeconds();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl
    public long getMTotalRemainDist() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMTotalRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCongestionLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCongestionLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCongestionLayerItem.getPosition(), coord3DDouble);
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
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCongestionLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCongestionLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCongestionLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideCongestionLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            iGuideCongestionLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            iGuideCongestionLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            iGuideCongestionLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            iGuideCongestionLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            return iGuideCongestionLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideCongestionLayerItem iGuideCongestionLayerItem = this.mObserver;
        if (iGuideCongestionLayerItem != null) {
            iGuideCongestionLayerItem.setAreaCollision(z);
        }
    }
}
