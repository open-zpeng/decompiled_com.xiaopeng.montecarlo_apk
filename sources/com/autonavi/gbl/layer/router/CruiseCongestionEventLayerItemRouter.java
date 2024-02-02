package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.CruiseCongestionEventLayerItem;
import com.autonavi.gbl.layer.impl.CruiseCongestionEventLayerItemImpl;
import com.autonavi.gbl.layer.model.BizSocolEventInfo;
import com.autonavi.gbl.layer.observer.ICruiseCongestionEventLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CruiseCongestionEventLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CruiseCongestionEventLayerItemRouter extends CruiseCongestionEventLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseCongestionEventLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CruiseCongestionEventLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICruiseCongestionEventLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem) {
        if (iCruiseCongestionEventLayerItem != null) {
            this.mObserver = iCruiseCongestionEventLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CruiseCongestionEventLayerItem.class, iCruiseCongestionEventLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CruiseCongestionEventLayerItemImpl.getCPtr((CruiseCongestionEventLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCruiseCongestionEventLayerItem);
    }

    public CruiseCongestionEventLayerItemRouter(String str, ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseCongestionEventLayerItem);
    }

    public CruiseCongestionEventLayerItemRouter(String str, ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseCongestionEventLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseCongestionEventLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionEventLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseCongestionEventLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseCongestionEventLayerItemImpl
    public BizSocolEventInfo getMSocolEventInfo() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getMSocolEventInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionEventLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionEventLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionEventLayerItem.getPosition(), coord3DDouble);
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
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionEventLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionEventLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionEventLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseCongestionEventLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            iCruiseCongestionEventLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            iCruiseCongestionEventLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            return iCruiseCongestionEventLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICruiseCongestionEventLayerItem iCruiseCongestionEventLayerItem = this.mObserver;
        if (iCruiseCongestionEventLayerItem != null) {
            iCruiseCongestionEventLayerItem.setAreaCollision(z);
        }
    }
}
