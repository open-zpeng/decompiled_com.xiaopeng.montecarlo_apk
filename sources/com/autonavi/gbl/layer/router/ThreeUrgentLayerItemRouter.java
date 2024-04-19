package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.ThreeUrgentLayerItem;
import com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.ThreeUrgentType;
import com.autonavi.gbl.layer.observer.IThreeUrgentLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = ThreeUrgentLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ThreeUrgentLayerItemRouter extends ThreeUrgentLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ThreeUrgentLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(ThreeUrgentLayerItemRouter.class);
    private TypeHelper mHelper;
    private IThreeUrgentLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IThreeUrgentLayerItem iThreeUrgentLayerItem) {
        if (iThreeUrgentLayerItem != null) {
            this.mObserver = iThreeUrgentLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(ThreeUrgentLayerItem.class, iThreeUrgentLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IThreeUrgentLayerItem iThreeUrgentLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ThreeUrgentLayerItemImpl.getCPtr((ThreeUrgentLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iThreeUrgentLayerItem);
    }

    public ThreeUrgentLayerItemRouter(String str, IThreeUrgentLayerItem iThreeUrgentLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iThreeUrgentLayerItem);
    }

    public ThreeUrgentLayerItemRouter(String str, IThreeUrgentLayerItem iThreeUrgentLayerItem, @ThreeUrgentType.ThreeUrgentType1 int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iThreeUrgentLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.ThreeUrgentLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.ThreeUrgentLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl
    @ThreeUrgentType.ThreeUrgentType1
    public int getMType() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMBigBubbleStyle() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getMBigBubbleStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl
    public boolean getMbIsMaxOverSpeedPoint() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getMbIsMaxOverSpeedPoint();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl
    public int getMPassingSpeed() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getMPassingSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl
    public int getMElectronicEyeSpeed() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getMElectronicEyeSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iThreeUrgentLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iThreeUrgentLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iThreeUrgentLayerItem.getPosition(), coord3DDouble);
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
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iThreeUrgentLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iThreeUrgentLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iThreeUrgentLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iThreeUrgentLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            iThreeUrgentLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            iThreeUrgentLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            iThreeUrgentLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            iThreeUrgentLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            return iThreeUrgentLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IThreeUrgentLayerItem iThreeUrgentLayerItem = this.mObserver;
        if (iThreeUrgentLayerItem != null) {
            iThreeUrgentLayerItem.setAreaCollision(z);
        }
    }
}
