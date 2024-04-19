package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.PopPointLayerItem;
import com.autonavi.gbl.layer.impl.PopPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IPopPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = PopPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PopPointLayerItemRouter extends PopPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PopPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(PopPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IPopPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPopPointLayerItem iPopPointLayerItem) {
        if (iPopPointLayerItem != null) {
            this.mObserver = iPopPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PopPointLayerItem.class, iPopPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IPopPointLayerItem iPopPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(PopPointLayerItemImpl.getCPtr((PopPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPopPointLayerItem);
    }

    public PopPointLayerItemRouter(String str, IPopPointLayerItem iPopPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPopPointLayerItem);
    }

    public PopPointLayerItemRouter(String str, IPopPointLayerItem iPopPointLayerItem, String str2) {
        super(str2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPopPointLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PopPointLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.PopPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PopPointLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.PopPointLayerItemImpl
    public String getMText() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getMText();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPopPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPopPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPopPointLayerItem.getPosition(), coord3DDouble);
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
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPopPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPopPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPopPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iPopPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            iPopPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            iPopPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            iPopPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            iPopPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            return iPopPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IPopPointLayerItem iPopPointLayerItem = this.mObserver;
        if (iPopPointLayerItem != null) {
            iPopPointLayerItem.setAreaCollision(z);
        }
    }
}
