package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.PathTMCPointLayerItem;
import com.autonavi.gbl.layer.impl.PathTMCPointLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IPathTMCPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = PathTMCPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PathTMCPointLayerItemRouter extends PathTMCPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PathTMCPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(PathTMCPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IPathTMCPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPathTMCPointLayerItem iPathTMCPointLayerItem) {
        if (iPathTMCPointLayerItem != null) {
            this.mObserver = iPathTMCPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PathTMCPointLayerItem.class, iPathTMCPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IPathTMCPointLayerItem iPathTMCPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(PathTMCPointLayerItemImpl.getCPtr((PathTMCPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPathTMCPointLayerItem);
    }

    public PathTMCPointLayerItemRouter(String str, IPathTMCPointLayerItem iPathTMCPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPathTMCPointLayerItem);
    }

    public PathTMCPointLayerItemRouter(String str, IPathTMCPointLayerItem iPathTMCPointLayerItem, @QuadrantType.QuadrantType1 int i, long j, @BizDirectionStyle.BizDirectionStyle1 int i2) {
        super(i, j, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPathTMCPointLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PathTMCPointLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.PathTMCPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PathTMCPointLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.PathTMCPointLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMBoardStyle() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getMBoardStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathTMCPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathTMCPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathTMCPointLayerItem.getPosition(), coord3DDouble);
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
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathTMCPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathTMCPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathTMCPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathTMCPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            iPathTMCPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            iPathTMCPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            iPathTMCPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            iPathTMCPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            return iPathTMCPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IPathTMCPointLayerItem iPathTMCPointLayerItem = this.mObserver;
        if (iPathTMCPointLayerItem != null) {
            iPathTMCPointLayerItem.setAreaCollision(z);
        }
    }
}
