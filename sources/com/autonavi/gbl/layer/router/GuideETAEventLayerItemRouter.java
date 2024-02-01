package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.GuideETAEventLayerItem;
import com.autonavi.gbl.layer.impl.GuideETAEventLayerItemImpl;
import com.autonavi.gbl.layer.observer.IGuideETAEventLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = GuideETAEventLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideETAEventLayerItemRouter extends GuideETAEventLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideETAEventLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideETAEventLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideETAEventLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideETAEventLayerItem iGuideETAEventLayerItem) {
        if (iGuideETAEventLayerItem != null) {
            this.mObserver = iGuideETAEventLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideETAEventLayerItem.class, iGuideETAEventLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideETAEventLayerItem iGuideETAEventLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideETAEventLayerItemImpl.getCPtr((GuideETAEventLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideETAEventLayerItem);
    }

    public GuideETAEventLayerItemRouter(String str, IGuideETAEventLayerItem iGuideETAEventLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideETAEventLayerItem);
    }

    public GuideETAEventLayerItemRouter(String str, IGuideETAEventLayerItem iGuideETAEventLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideETAEventLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.GuideETAEventLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideETAEventLayerItemImpl
    public int getMType() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideETAEventLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideETAEventLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideETAEventLayerItem.getPosition(), coord3DDouble);
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
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideETAEventLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideETAEventLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideETAEventLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideETAEventLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            iGuideETAEventLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            iGuideETAEventLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            iGuideETAEventLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            iGuideETAEventLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            iGuideETAEventLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IGuideETAEventLayerItem iGuideETAEventLayerItem = this.mObserver;
        if (iGuideETAEventLayerItem != null) {
            return iGuideETAEventLayerItem.canAreaCollision();
        }
        return false;
    }
}
