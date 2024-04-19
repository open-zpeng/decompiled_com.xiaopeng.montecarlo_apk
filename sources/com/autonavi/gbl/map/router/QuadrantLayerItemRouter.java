package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.PointLayerItemType;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = QuadrantLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class QuadrantLayerItemRouter extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(QuadrantLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(QuadrantLayerItemRouter.class);
    private TypeHelper mHelper;
    private IQuadrantLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IQuadrantLayerItem iQuadrantLayerItem) {
        if (iQuadrantLayerItem != null) {
            this.mObserver = iQuadrantLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(QuadrantLayerItem.class, iQuadrantLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IQuadrantLayerItem iQuadrantLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(QuadrantLayerItemImpl.getCPtr((QuadrantLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iQuadrantLayerItem);
    }

    public QuadrantLayerItemRouter(String str, IQuadrantLayerItem iQuadrantLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iQuadrantLayerItem);
    }

    public QuadrantLayerItemRouter(String str, IQuadrantLayerItem iQuadrantLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iQuadrantLayerItem);
    }

    public QuadrantLayerItemRouter(String str, IQuadrantLayerItem iQuadrantLayerItem, @PointLayerItemType.PointLayerItemType1 int i, @QuadrantType.QuadrantType1 int i2, long j) {
        super(i, i2, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iQuadrantLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.QuadrantLayerItemRouter.1
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
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.QuadrantLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayerItem.getPosition(), coord3DDouble);
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
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            try {
                TypeUtil.deepcopy(iQuadrantLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            iQuadrantLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            iQuadrantLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getOnVisible() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void resetOnVisible(boolean z) {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            iQuadrantLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void applyOnVisible() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            iQuadrantLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            return iQuadrantLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        IQuadrantLayerItem iQuadrantLayerItem = this.mObserver;
        if (iQuadrantLayerItem != null) {
            iQuadrantLayerItem.setAreaCollision(z);
        }
    }
}
