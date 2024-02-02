package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.EndAreaPointLayerItem;
import com.autonavi.gbl.layer.impl.EndAreaPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IEndAreaPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = EndAreaPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class EndAreaPointLayerItemRouter extends EndAreaPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(EndAreaPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(EndAreaPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private IEndAreaPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IEndAreaPointLayerItem iEndAreaPointLayerItem) {
        if (iEndAreaPointLayerItem != null) {
            this.mObserver = iEndAreaPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(EndAreaPointLayerItem.class, iEndAreaPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IEndAreaPointLayerItem iEndAreaPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(EndAreaPointLayerItemImpl.getCPtr((EndAreaPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iEndAreaPointLayerItem);
    }

    public EndAreaPointLayerItemRouter(String str, IEndAreaPointLayerItem iEndAreaPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEndAreaPointLayerItem);
    }

    public EndAreaPointLayerItemRouter(String str, IEndAreaPointLayerItem iEndAreaPointLayerItem, String str2, int i) {
        super(str2, i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEndAreaPointLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.EndAreaPointLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.EndAreaPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.EndAreaPointLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaPointLayerItemImpl
    public String getMPoiName() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getMPoiName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaPointLayerItemImpl
    public int getMPoiType() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getMPoiType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaPointLayerItem.getPosition(), coord3DDouble);
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
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            iEndAreaPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            iEndAreaPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            return iEndAreaPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IEndAreaPointLayerItem iEndAreaPointLayerItem = this.mObserver;
        if (iEndAreaPointLayerItem != null) {
            iEndAreaPointLayerItem.setAreaCollision(z);
        }
    }
}
