package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.EndAreaParentLayerItem;
import com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl;
import com.autonavi.gbl.layer.model.RouteEndAreaDirection;
import com.autonavi.gbl.layer.observer.IEndAreaParentLayerItem;
import com.autonavi.gbl.map.layer.model.IntersectValueType;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = EndAreaParentLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class EndAreaParentLayerItemRouter extends EndAreaParentLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(EndAreaParentLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(EndAreaParentLayerItemRouter.class);
    private TypeHelper mHelper;
    private IEndAreaParentLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IEndAreaParentLayerItem iEndAreaParentLayerItem) {
        if (iEndAreaParentLayerItem != null) {
            this.mObserver = iEndAreaParentLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(EndAreaParentLayerItem.class, iEndAreaParentLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IEndAreaParentLayerItem iEndAreaParentLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(EndAreaParentLayerItemImpl.getCPtr((EndAreaParentLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iEndAreaParentLayerItem);
    }

    public EndAreaParentLayerItemRouter(String str, IEndAreaParentLayerItem iEndAreaParentLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEndAreaParentLayerItem);
    }

    public EndAreaParentLayerItemRouter(String str, IEndAreaParentLayerItem iEndAreaParentLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEndAreaParentLayerItem);
    }

    public EndAreaParentLayerItemRouter(String str, IEndAreaParentLayerItem iEndAreaParentLayerItem, @QuadrantType.QuadrantType1 int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEndAreaParentLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl
    public String getMPoiName() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMPoiName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl
    public long getMTravelTime() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMTravelTime();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl
    public int getMLeftEnergy() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl
    public int getMOddNum() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMOddNum();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl
    public double getMOddLength() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMOddLength();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl
    @RouteEndAreaDirection.RouteEndAreaDirection1
    public int getMDirection() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMDirection();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl
    public int getMWeatherID() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMWeatherID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaParentLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaParentLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaParentLayerItem.getPosition(), coord3DDouble);
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
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaParentLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaParentLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaParentLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            try {
                TypeUtil.deepcopy(iEndAreaParentLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            iEndAreaParentLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            iEndAreaParentLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            iEndAreaParentLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            iEndAreaParentLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            iEndAreaParentLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IEndAreaParentLayerItem iEndAreaParentLayerItem = this.mObserver;
        if (iEndAreaParentLayerItem != null) {
            return iEndAreaParentLayerItem.canAreaCollision();
        }
        return false;
    }
}
