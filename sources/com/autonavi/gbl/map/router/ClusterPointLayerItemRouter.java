package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.ClusterPointLayerItem;
import com.autonavi.gbl.map.layer.impl.ClusterPointLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.IClusterPointLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = ClusterPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ClusterPointLayerItemRouter extends ClusterPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ClusterPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(ClusterPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IClusterPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IClusterPointLayerItem iClusterPointLayerItem) {
        if (iClusterPointLayerItem != null) {
            this.mObserver = iClusterPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(ClusterPointLayerItem.class, iClusterPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IClusterPointLayerItem iClusterPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ClusterPointLayerItemImpl.getCPtr((ClusterPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iClusterPointLayerItem);
    }

    public ClusterPointLayerItemRouter(String str, IClusterPointLayerItem iClusterPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iClusterPointLayerItem);
    }

    public ClusterPointLayerItemRouter(String str, IClusterPointLayerItem iClusterPointLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iClusterPointLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.ClusterPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.ClusterPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.ClusterPointLayerItemImpl
    public int getClusterPointSize() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getClusterPointSize();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.ClusterPointLayerItemImpl
    public ArrayList<String> getVecOriginalItemID() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getVecOriginalItemID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iClusterPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iClusterPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iClusterPointLayerItem.getPosition(), coord3DDouble);
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
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iClusterPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iClusterPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iClusterPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iClusterPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            iClusterPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            iClusterPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            iClusterPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            iClusterPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            iClusterPointLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IClusterPointLayerItem iClusterPointLayerItem = this.mObserver;
        if (iClusterPointLayerItem != null) {
            return iClusterPointLayerItem.canAreaCollision();
        }
        return false;
    }
}
