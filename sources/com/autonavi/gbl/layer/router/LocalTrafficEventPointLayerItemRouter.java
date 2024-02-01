package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.layer.LocalTrafficEventPointLayerItem;
import com.autonavi.gbl.layer.impl.LocalTrafficEventPointLayerItemImpl;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import com.autonavi.gbl.layer.observer.ILocalTrafficEventPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = LocalTrafficEventPointLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LocalTrafficEventPointLayerItemRouter extends LocalTrafficEventPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LocalTrafficEventPointLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(LocalTrafficEventPointLayerItemRouter.class);
    private TypeHelper mHelper;
    private ILocalTrafficEventPointLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem) {
        if (iLocalTrafficEventPointLayerItem != null) {
            this.mObserver = iLocalTrafficEventPointLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(LocalTrafficEventPointLayerItem.class, iLocalTrafficEventPointLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(LocalTrafficEventPointLayerItemImpl.getCPtr((LocalTrafficEventPointLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iLocalTrafficEventPointLayerItem);
    }

    public LocalTrafficEventPointLayerItemRouter(String str, ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLocalTrafficEventPointLayerItem);
    }

    public LocalTrafficEventPointLayerItemRouter(String str, ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem, @LocalTrafficEventType.LocalTrafficEventType1 int i, String str2, @RoadClass.RoadClass1 int i2) {
        super(i, str2, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLocalTrafficEventPointLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventPointLayerItemImpl
    @LocalTrafficEventType.LocalTrafficEventType1
    public int getEventType() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getEventType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventPointLayerItemImpl
    public String getEventID() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getEventID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.LocalTrafficEventPointLayerItemImpl
    @RoadClass.RoadClass1
    public int getRoadClass() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getRoadClass();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventPointLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventPointLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventPointLayerItem.getPosition(), coord3DDouble);
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
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventPointLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventPointLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventPointLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            try {
                TypeUtil.deepcopy(iLocalTrafficEventPointLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            iLocalTrafficEventPointLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            iLocalTrafficEventPointLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            iLocalTrafficEventPointLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            iLocalTrafficEventPointLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            iLocalTrafficEventPointLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ILocalTrafficEventPointLayerItem iLocalTrafficEventPointLayerItem = this.mObserver;
        if (iLocalTrafficEventPointLayerItem != null) {
            return iLocalTrafficEventPointLayerItem.canAreaCollision();
        }
        return false;
    }
}
