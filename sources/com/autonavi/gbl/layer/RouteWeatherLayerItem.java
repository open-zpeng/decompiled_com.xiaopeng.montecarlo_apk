package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RouteWeatherLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteWeatherLayerItem;
import com.autonavi.gbl.layer.router.RouteWeatherLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.route.model.WeatherLabelItem;
@IntfAuto(target = RouteWeatherLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteWeatherLayerItem extends PointLayerItem implements IRouteWeatherLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteWeatherLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteWeatherLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteWeatherLayerItem(long j, boolean z) {
        this(new RouteWeatherLayerItemRouter("RouteWeatherLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteWeatherLayerItem.class}, new Object[]{this});
    }

    public RouteWeatherLayerItem(WeatherLabelItem weatherLabelItem) {
        this(new RouteWeatherLayerItemRouter("RouteWeatherLayerItem", null, weatherLabelItem));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteWeatherLayerItem.class}, new Object[]{this});
    }

    public RouteWeatherLayerItem(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        super(routeWeatherLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeWeatherLayerItemImpl);
    }

    private void $constructor(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        if (routeWeatherLayerItemImpl != null) {
            this.mService = routeWeatherLayerItemImpl;
            this.mTargetId = String.format("RouteWeatherLayerItem_%s_%d", String.valueOf(RouteWeatherLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteWeatherLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        return RouteWeatherLayerItemImpl.getClassTypeName();
    }

    public void setMWeatherInfo(WeatherLabelItem weatherLabelItem) {
        RouteWeatherLayerItemImpl routeWeatherLayerItemImpl = this.mService;
        if (routeWeatherLayerItemImpl != null) {
            routeWeatherLayerItemImpl.$explicit_setMWeatherInfo(weatherLabelItem);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteWeatherLayerItem
    public WeatherLabelItem getMWeatherInfo() {
        RouteWeatherLayerItemImpl routeWeatherLayerItemImpl = this.mService;
        if (routeWeatherLayerItemImpl != null) {
            return routeWeatherLayerItemImpl.$explicit_getMWeatherInfo();
        }
        return null;
    }
}
