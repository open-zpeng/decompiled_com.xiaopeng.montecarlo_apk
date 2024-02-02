package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.layer.CruiseEventLayerItem;
import com.autonavi.gbl.layer.impl.CruiseEventLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICruiseEventLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = CruiseEventLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CruiseEventLayerItemRouter extends CruiseEventLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseEventLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(CruiseEventLayerItemRouter.class);
    private TypeHelper mHelper;
    private ICruiseEventLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICruiseEventLayerItem iCruiseEventLayerItem) {
        if (iCruiseEventLayerItem != null) {
            this.mObserver = iCruiseEventLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CruiseEventLayerItem.class, iCruiseEventLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ICruiseEventLayerItem iCruiseEventLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CruiseEventLayerItemImpl.getCPtr((CruiseEventLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCruiseEventLayerItem);
    }

    public CruiseEventLayerItemRouter(String str, ICruiseEventLayerItem iCruiseEventLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseEventLayerItem);
    }

    public CruiseEventLayerItemRouter(String str, ICruiseEventLayerItem iCruiseEventLayerItem, CruiseEventInfo cruiseEventInfo) {
        super(cruiseEventInfo);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseEventLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseEventLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.CruiseEventLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.CruiseEventLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseEventLayerItemImpl
    public CruiseEventInfo getMCruiseEventInfo() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getMCruiseEventInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.CruiseEventLayerItemImpl
    public boolean getMShowText() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getMShowText();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseEventLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseEventLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseEventLayerItem.getPosition(), coord3DDouble);
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
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseEventLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseEventLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseEventLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iCruiseEventLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            iCruiseEventLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            iCruiseEventLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            return iCruiseEventLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ICruiseEventLayerItem iCruiseEventLayerItem = this.mObserver;
        if (iCruiseEventLayerItem != null) {
            iCruiseEventLayerItem.setAreaCollision(z);
        }
    }
}
