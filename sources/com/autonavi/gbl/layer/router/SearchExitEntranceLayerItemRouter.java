package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.SearchExitEntranceLayerItem;
import com.autonavi.gbl.layer.impl.SearchExitEntranceLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISearchExitEntranceLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SearchExitEntranceLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SearchExitEntranceLayerItemRouter extends SearchExitEntranceLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchExitEntranceLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SearchExitEntranceLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISearchExitEntranceLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem) {
        if (iSearchExitEntranceLayerItem != null) {
            this.mObserver = iSearchExitEntranceLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SearchExitEntranceLayerItem.class, iSearchExitEntranceLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SearchExitEntranceLayerItemImpl.getCPtr((SearchExitEntranceLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSearchExitEntranceLayerItem);
    }

    public SearchExitEntranceLayerItemRouter(String str, ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchExitEntranceLayerItem);
    }

    public SearchExitEntranceLayerItemRouter(String str, ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem, int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchExitEntranceLayerItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.SearchExitEntranceLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SearchExitEntranceLayerItemImpl
    public int getMType() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchExitEntranceLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchExitEntranceLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchExitEntranceLayerItem.getPosition(), coord3DDouble);
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
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchExitEntranceLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchExitEntranceLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchExitEntranceLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchExitEntranceLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getPointTypeCode() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getPointTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public float getForeshorteningCoef() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getForeshorteningCoef();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public int getPriority() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getVisible() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getClickable() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            iSearchExitEntranceLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            iSearchExitEntranceLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean getOnVisible() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.getOnVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            iSearchExitEntranceLayerItem.resetOnVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void applyOnVisible() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            iSearchExitEntranceLayerItem.applyOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean isAreaCollision() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            iSearchExitEntranceLayerItem.setAreaCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.canCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        ISearchExitEntranceLayerItem iSearchExitEntranceLayerItem = this.mObserver;
        if (iSearchExitEntranceLayerItem != null) {
            return iSearchExitEntranceLayerItem.canAreaCollision();
        }
        return false;
    }
}
