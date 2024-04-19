package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.CustomPointLayerItem;
import com.autonavi.gbl.layer.impl.CustomPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CustomPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CustomPointLayerItemRouter extends CustomPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CustomPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICustomPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICustomPointLayerItem iCustomPointLayerItem) {
        if (iCustomPointLayerItem != null) {
            this.mObserver = iCustomPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CustomPointLayerItem.class, iCustomPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICustomPointLayerItem iCustomPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CustomPointLayerItemImpl.getCPtr((CustomPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCustomPointLayerItem);
    }

    public CustomPointLayerItemRouter(String str, ICustomPointLayerItem iCustomPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomPointLayerItem);
    }

    public CustomPointLayerItemRouter(String str, ICustomPointLayerItem iCustomPointLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCustomPointLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomPointLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CustomPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CustomPointLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CustomPointLayerItemImpl
    public int getMType() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.CustomPointLayerItemImpl
    public String getMValue() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getMValue();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomPointLayerItem.getPosition(), coord3DDouble);
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
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCustomPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            iCustomPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            iCustomPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            iCustomPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            iCustomPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            return iCustomPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICustomPointLayerItem iCustomPointLayerItem = this.mObserver;
        if (iCustomPointLayerItem != null) {
            iCustomPointLayerItem.setAreaCollision(z);
        }
    }
}
