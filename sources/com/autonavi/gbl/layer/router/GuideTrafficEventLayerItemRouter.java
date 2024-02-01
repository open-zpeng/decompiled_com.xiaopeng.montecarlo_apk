package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.GuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem;
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
@IntfAuto(target = GuideTrafficEventLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GuideTrafficEventLayerItemRouter extends GuideTrafficEventLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideTrafficEventLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideTrafficEventLayerItemRouter.class);
    private TypeHelper mHelper;
    private IGuideTrafficEventLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem) {
        if (iGuideTrafficEventLayerItem != null) {
            this.mObserver = iGuideTrafficEventLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(GuideTrafficEventLayerItem.class, iGuideTrafficEventLayerItem, this);
            }
        }
    }

    private void $constructor(String str, IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(GuideTrafficEventLayerItemImpl.getCPtr((GuideTrafficEventLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iGuideTrafficEventLayerItem);
    }

    public GuideTrafficEventLayerItemRouter(String str, IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficEventLayerItem);
    }

    public GuideTrafficEventLayerItemRouter(String str, IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem, @QuadrantType.QuadrantType1 int i, long j) {
        super(i, j);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideTrafficEventLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl, com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public int getMIndex() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public boolean getMIsPreview() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMIsPreview();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public int getMLayerTag() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMLayerTag();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public String getMLane() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMLane();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public int getMLayer() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMLayer();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public long getPathId() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public int getMId() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl
    public String getMLabelDesc() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMLabelDesc();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectArea() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getIntersectArea();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectAreaEx() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getIntersectAreaEx();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getIntersectValue(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public long getQuadrantGroupId() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getQuadrantGroupId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getQuadrantType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficEventLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficEventLayerItem.getRotateCenter3D(), coord3DDouble);
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
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficEventLayerItem.getPosition(), coord3DDouble);
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
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficEventLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficEventLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficEventLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            try {
                TypeUtil.deepcopy(iGuideTrafficEventLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            iGuideTrafficEventLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            iGuideTrafficEventLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            iGuideTrafficEventLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            iGuideTrafficEventLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            iGuideTrafficEventLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        IGuideTrafficEventLayerItem iGuideTrafficEventLayerItem = this.mObserver;
        if (iGuideTrafficEventLayerItem != null) {
            return iGuideTrafficEventLayerItem.canAreaCollision();
        }
        return false;
    }
}
