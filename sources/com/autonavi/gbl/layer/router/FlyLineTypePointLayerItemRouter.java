package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.FlyLineTypePointLayerItem;
import com.autonavi.gbl.layer.impl.FlyLineTypePointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IFlyLineTypePointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = FlyLineTypePointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class FlyLineTypePointLayerItemRouter extends FlyLineTypePointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(FlyLineTypePointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(FlyLineTypePointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IFlyLineTypePointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem) {
        if (iFlyLineTypePointLayerItem != null) {
            this.mObserver = iFlyLineTypePointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(FlyLineTypePointLayerItem.class, iFlyLineTypePointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(FlyLineTypePointLayerItemImpl.getCPtr((FlyLineTypePointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iFlyLineTypePointLayerItem);
    }

    public FlyLineTypePointLayerItemRouter(String str, IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFlyLineTypePointLayerItem);
    }

    public FlyLineTypePointLayerItemRouter(String str, IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFlyLineTypePointLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.FlyLineTypePointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.FlyLineTypePointLayerItemImpl
    public String getName() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.FlyLineTypePointLayerItemImpl
    public int getMainkey() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getMainkey();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.FlyLineTypePointLayerItemImpl
    public int getSubkey() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getSubkey();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.FlyLineTypePointLayerItemImpl
    public float getTextFontScale() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getTextFontScale();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFlyLineTypePointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFlyLineTypePointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFlyLineTypePointLayerItem.getPosition(), coord3DDouble);
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
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFlyLineTypePointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFlyLineTypePointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFlyLineTypePointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iFlyLineTypePointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            iFlyLineTypePointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            iFlyLineTypePointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            iFlyLineTypePointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            iFlyLineTypePointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            iFlyLineTypePointLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IFlyLineTypePointLayerItem iFlyLineTypePointLayerItem = this.mObserver;
        if (iFlyLineTypePointLayerItem != null) {
            return iFlyLineTypePointLayerItem.canAreaCollision();
        }
        return false;
    }
}
