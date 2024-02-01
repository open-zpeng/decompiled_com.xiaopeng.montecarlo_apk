package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.PathBoardLayerItem;
import com.autonavi.gbl.layer.impl.PathBoardLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizRouteBoardStyle;
import com.autonavi.gbl.layer.observer.IPathBoardLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = PathBoardLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PathBoardLayerItemRouter extends PathBoardLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PathBoardLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(PathBoardLayerItemRouter.class);
    private TypeHelper mHelper;
    private IPathBoardLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPathBoardLayerItem iPathBoardLayerItem) {
        if (iPathBoardLayerItem != null) {
            this.mObserver = iPathBoardLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PathBoardLayerItem.class, iPathBoardLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IPathBoardLayerItem iPathBoardLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(PathBoardLayerItemImpl.getCPtr((PathBoardLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPathBoardLayerItem);
    }

    public PathBoardLayerItemRouter(String str, IPathBoardLayerItem iPathBoardLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPathBoardLayerItem);
    }

    public PathBoardLayerItemRouter(String str, IPathBoardLayerItem iPathBoardLayerItem, String str2, @BizDirectionStyle.BizDirectionStyle1 int i, @BizRouteBoardStyle.BizRouteBoardStyle1 int i2) {
        super(str2, i, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPathBoardLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.PathBoardLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.PathBoardLayerItemImpl
    public String getMBoardName() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getMBoardName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.PathBoardLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.PathBoardLayerItemImpl
    @BizRouteBoardStyle.BizRouteBoardStyle1
    public int getMType() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathBoardLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathBoardLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathBoardLayerItem.getPosition(), coord3DDouble);
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
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathBoardLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathBoardLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathBoardLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPathBoardLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            iPathBoardLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            iPathBoardLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            iPathBoardLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            iPathBoardLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            iPathBoardLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IPathBoardLayerItem iPathBoardLayerItem = this.mObserver;
        if (iPathBoardLayerItem != null) {
            return iPathBoardLayerItem.canAreaCollision();
        }
        return false;
    }
}
