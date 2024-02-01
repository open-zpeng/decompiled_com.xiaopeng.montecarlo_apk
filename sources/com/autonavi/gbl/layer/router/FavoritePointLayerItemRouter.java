package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.FavoritePointLayerItem;
import com.autonavi.gbl.layer.impl.FavoritePointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IFavoritePointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import java.util.ArrayList;
@IntfAuto(target = FavoritePointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class FavoritePointLayerItemRouter extends FavoritePointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(FavoritePointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(FavoritePointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IFavoritePointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IFavoritePointLayerItem iFavoritePointLayerItem) {
        if (iFavoritePointLayerItem != null) {
            this.mObserver = iFavoritePointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(FavoritePointLayerItem.class, iFavoritePointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IFavoritePointLayerItem iFavoritePointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(FavoritePointLayerItemImpl.getCPtr((FavoritePointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iFavoritePointLayerItem);
    }

    public FavoritePointLayerItemRouter(String str, IFavoritePointLayerItem iFavoritePointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFavoritePointLayerItem);
    }

    public FavoritePointLayerItemRouter(String str, IFavoritePointLayerItem iFavoritePointLayerItem, @FavoriteType.FavoriteType1 int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFavoritePointLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.FavoritePointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.FavoritePointLayerItemImpl
    @FavoriteType.FavoriteType1
    public int getMFavoriteType() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getMFavoriteType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFavoritePointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFavoritePointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFavoritePointLayerItem.getPosition(), coord3DDouble);
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
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFavoritePointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFavoritePointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFavoritePointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFavoritePointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            iFavoritePointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            iFavoritePointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            iFavoritePointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            iFavoritePointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            iFavoritePointLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IFavoritePointLayerItem iFavoritePointLayerItem = this.mObserver;
        if (iFavoritePointLayerItem != null) {
            return iFavoritePointLayerItem.canAreaCollision();
        }
        return false;
    }
}
