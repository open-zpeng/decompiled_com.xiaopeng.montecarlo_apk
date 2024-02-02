package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.OddLayerItem;
import com.autonavi.gbl.layer.impl.OddLayerItemImpl;
import com.autonavi.gbl.layer.model.BizOddInfo;
import com.autonavi.gbl.layer.model.ODDPointType;
import com.autonavi.gbl.layer.observer.IOddLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = OddLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class OddLayerItemRouter extends OddLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(OddLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(OddLayerItemRouter.class);
    private TypeHelper mHelper;
    private IOddLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IOddLayerItem iOddLayerItem) {
        if (iOddLayerItem != null) {
            this.mObserver = iOddLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(OddLayerItem.class, iOddLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IOddLayerItem iOddLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(OddLayerItemImpl.getCPtr((OddLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iOddLayerItem);
    }

    public OddLayerItemRouter(String str, IOddLayerItem iOddLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iOddLayerItem);
    }

    public OddLayerItemRouter(String str, IOddLayerItem iOddLayerItem, @ODDPointType.ODDPointType1 int i, BizOddInfo bizOddInfo, RectDouble rectDouble) {
        super(i, bizOddInfo, rectDouble);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iOddLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.OddLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.OddLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.OddLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.OddLayerItemImpl
    @ODDPointType.ODDPointType1
    public int getMPointType() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getMPointType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.OddLayerItemImpl
    public BizOddInfo getMOddInfo() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getMOddInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.OddLayerItemImpl
    public RectDouble getMRect() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getMRect();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            try {
                TypeUtil.deepcopy(iOddLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            try {
                TypeUtil.deepcopy(iOddLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            try {
                TypeUtil.deepcopy(iOddLayerItem.getPosition(), coord3DDouble);
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
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            try {
                TypeUtil.deepcopy(iOddLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            try {
                TypeUtil.deepcopy(iOddLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            try {
                TypeUtil.deepcopy(iOddLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            try {
                TypeUtil.deepcopy(iOddLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            iOddLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            iOddLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            return iOddLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IOddLayerItem iOddLayerItem = this.mObserver;
        if (iOddLayerItem != null) {
            iOddLayerItem.setAreaCollision(z);
        }
    }
}
