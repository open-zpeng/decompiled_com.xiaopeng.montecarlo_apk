package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.SearchBeginEndLayerItem;
import com.autonavi.gbl.layer.impl.SearchBeginEndLayerItemImpl;
import com.autonavi.gbl.layer.observer.ISearchBeginEndLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(target = SearchBeginEndLayerItem.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class SearchBeginEndLayerItemRouter extends SearchBeginEndLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchBeginEndLayerItemRouter.class);
    private static String PACKAGE = ReflexTool.PN(SearchBeginEndLayerItemRouter.class);
    private TypeHelper mHelper;
    private ISearchBeginEndLayerItem mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISearchBeginEndLayerItem iSearchBeginEndLayerItem) {
        if (iSearchBeginEndLayerItem != null) {
            this.mObserver = iSearchBeginEndLayerItem;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SearchBeginEndLayerItem.class, iSearchBeginEndLayerItem, this);
            }
        }
    }

    private void $constructor(String str, ISearchBeginEndLayerItem iSearchBeginEndLayerItem) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SearchBeginEndLayerItemImpl.getCPtr((SearchBeginEndLayerItemImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSearchBeginEndLayerItem);
    }

    public SearchBeginEndLayerItemRouter(String str, ISearchBeginEndLayerItem iSearchBeginEndLayerItem, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchBeginEndLayerItem);
    }

    public SearchBeginEndLayerItemRouter(String str, ISearchBeginEndLayerItem iSearchBeginEndLayerItem, int i, int i2) {
        super(i, i2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSearchBeginEndLayerItem);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchBeginEndLayerItemRouter.1
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
    @Override // com.autonavi.gbl.layer.impl.SearchBeginEndLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.SearchBeginEndLayerItemRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.impl.SearchBeginEndLayerItemImpl
    public int getMPointType() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getMPointType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.impl.SearchBeginEndLayerItemImpl
    public int getMPointCount() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getMPointCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getVisible3V(Visible3V visible3V) {
        $wrapper_getVisible3V(visible3V);
    }

    private void $wrapper_getVisible3V(Visible3V visible3V) {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchBeginEndLayerItem.getVisible3V(), visible3V);
            } catch (Exception unused) {
                DebugTool.e("getVisible3V copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public boolean getBillboard() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getBillboard();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $wrapper_getRotateCenter3D(coord3DDouble);
    }

    private void $wrapper_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchBeginEndLayerItem.getRotateCenter3D(), coord3DDouble);
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
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchBeginEndLayerItem.getPosition(), coord3DDouble);
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
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchBeginEndLayerItem.getNormalStyle(), pointLayerItemStyle);
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
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchBeginEndLayerItem.getFocusStyle(), pointLayerItemStyle);
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
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchBeginEndLayerItem.getItemIgnoreRegion(), itemIgnoreRegion);
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
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            try {
                TypeUtil.deepcopy(iSearchBeginEndLayerItem.getScale(), scaleAttribute);
            } catch (Exception unused) {
                DebugTool.e("getScale copy failed", new Object[0]);
            }
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl
    public String getTypeCode() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getTypeCode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getID() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public String getInfo() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean getFocus() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAlpha() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getAngle() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getPitch() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public double getMaxPitch() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public LayerScale getDisplayScale() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            iSearchBeginEndLayerItem.onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public int getBusinessType() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            iSearchBeginEndLayerItem.onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            return iSearchBeginEndLayerItem.isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        ISearchBeginEndLayerItem iSearchBeginEndLayerItem = this.mObserver;
        if (iSearchBeginEndLayerItem != null) {
            iSearchBeginEndLayerItem.setAreaCollision(z);
        }
    }
}
