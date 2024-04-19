package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideTurnLayerItem;
import com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideTurnLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideTurnLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LaneGuideTurnLayerItemRouter extends LaneGuideTurnLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideTurnLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneGuideTurnLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILaneGuideTurnLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem) {
        if (iLaneGuideTurnLayerItem != null) {
            this.mObserver = iLaneGuideTurnLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LaneGuideTurnLayerItem.class, iLaneGuideTurnLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LaneGuideTurnLayerItemImpl.getCPtr((LaneGuideTurnLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLaneGuideTurnLayerItem);
    }

    public LaneGuideTurnLayerItemRouter(String str, ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTurnLayerItem);
    }

    public LaneGuideTurnLayerItemRouter(String str, ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneGuideTurnLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneGuideTurnLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.LaneGuideTurnLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl
    public long getMPathID() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getMPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl
    public int getMSegmentID() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getMSegmentID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl
    public short getMMainAction() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getMMainAction();
        }
        return (short) 0;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl
    public long getMRemainDist() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getMRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTurnLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTurnLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTurnLayerItem.getPosition(), coord3DDouble);
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
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTurnLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTurnLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTurnLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLaneGuideTurnLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            iLaneGuideTurnLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            iLaneGuideTurnLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            iLaneGuideTurnLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            iLaneGuideTurnLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            return iLaneGuideTurnLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILaneGuideTurnLayerItem iLaneGuideTurnLayerItem = this.mObserver;
        if (iLaneGuideTurnLayerItem != null) {
            iLaneGuideTurnLayerItem.setAreaCollision(z);
        }
    }
}
