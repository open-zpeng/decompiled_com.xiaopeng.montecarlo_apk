package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Vector3i;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.RctRouteLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.RealCityNaviInfo;
import com.autonavi.gbl.map.layer.model.RealCityTmcParam;
import com.autonavi.gbl.map.layer.observer.IRctRouteLayerItem;
import com.autonavi.gbl.map.router.RctRouteLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = RctRouteLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class RctRouteLayerItem extends LayerItem implements IRctRouteLayerItem {
    private static String PACKAGE = ReflexTool.PN(RctRouteLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RctRouteLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RctRouteLayerItem(long j, boolean z) {
        this(new RctRouteLayerItemRouter("RctRouteLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRctRouteLayerItem.class}, new Object[]{this});
    }

    public RctRouteLayerItem(MapView mapView) {
        this(new RctRouteLayerItemRouter("RctRouteLayerItem", null, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRctRouteLayerItem.class}, new Object[]{this});
    }

    public RctRouteLayerItem(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        super(rctRouteLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(rctRouteLayerItemImpl);
    }

    private void $constructor(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        if (rctRouteLayerItemImpl != null) {
            this.mService = rctRouteLayerItemImpl;
            this.mTargetId = String.format("RctRouteLayerItem_%s_%d", String.valueOf(RctRouteLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public RctRouteLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return RctRouteLayerItemImpl.getClassTypeName();
    }

    public boolean setFlyRoute(byte[] bArr) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            return rctRouteLayerItemImpl.$explicit_setFlyRoute(bArr);
        }
        return false;
    }

    public boolean setFlyTmc(byte[] bArr, ArrayList<RealCityTmcParam> arrayList) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            return rctRouteLayerItemImpl.$explicit_setFlyTmc(bArr, arrayList);
        }
        return false;
    }

    public void updataNaviInfo(RealCityNaviInfo realCityNaviInfo) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_updataNaviInfo(realCityNaviInfo);
        }
    }

    public boolean setRctNaviMode(int i) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            return rctRouteLayerItemImpl.$explicit_setRctNaviMode(i);
        }
        return false;
    }

    public boolean setRctHeadAngleSync(boolean z) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            return rctRouteLayerItemImpl.$explicit_setRctHeadAngleSync(z);
        }
        return false;
    }

    public boolean setGpsPos(Vector3i vector3i, float f) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            return rctRouteLayerItemImpl.$explicit_setGpsPos(vector3i, f);
        }
        return false;
    }

    public void startNavi() {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_startNavi();
        }
    }

    public void pauseNavi() {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_pauseNavi();
        }
    }

    public void resumeNavi() {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_resumeNavi();
        }
    }

    public void stopNavi() {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_stopNavi();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_updateStyle();
        }
    }

    public void showRtcSkeleton(boolean z) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_showRtcSkeleton(z);
        }
    }

    public void showRtcArrow3D(boolean z) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_showRtcArrow3D(z);
        }
    }

    public void setRtcBinaryData(byte[] bArr) {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            rctRouteLayerItemImpl.$explicit_setRtcBinaryData(bArr);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        RctRouteLayerItemImpl rctRouteLayerItemImpl = this.mService;
        if (rctRouteLayerItemImpl != null) {
            return rctRouteLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }
}
