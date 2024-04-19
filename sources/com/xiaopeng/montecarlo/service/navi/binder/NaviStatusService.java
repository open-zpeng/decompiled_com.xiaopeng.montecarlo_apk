package com.xiaopeng.montecarlo.service.navi.binder;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.FavoriteType;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.bean.FavoriteAddressBean;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchSceneDataHelper;
import com.xiaopeng.montecarlo.service.navi.INaviStatusService;
import com.xiaopeng.montecarlo.util.SRUtil;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
import com.xiaopeng.speech.protocol.node.navi.bean.NaviInfoBean;
import com.xiaopeng.speech.protocol.query.navi.bean.NavigationInfoBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class NaviStatusService extends INaviStatusService.Stub implements IBinderService {
    private static final L.Tag TAG = new L.Tag("NaviStatusService");
    private static MainContext sMainContext;
    private static IMapDelegate sMapDelegate;

    @Override // com.xiaopeng.montecarlo.service.navi.binder.IBinderService
    public IBinder getBinder() {
        return this;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.binder.IBinderService
    public void onCreate(Context context) {
    }

    @Override // com.xiaopeng.montecarlo.service.navi.binder.IBinderService
    public void onDestroy() {
    }

    public static void setMainContext(MainContext mainContext) {
        sMainContext = mainContext;
    }

    public static void setMapDelegate(IMapDelegate iMapDelegate) {
        sMapDelegate = iMapDelegate;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isCruise() {
        return TBTManager.getInstance().getCurrentStatus() == 0;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isExplore() {
        return TBTManager.getInstance().getCurrentStatus() == 2;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isNavi() {
        return TBTManager.getInstance().getCurrentStatus() == 1;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isLaneMode() throws RemoteException {
        return SRUtil.isLaneMode();
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getViaPointSize() {
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (viaInfos != null) {
            return viaInfos.size();
        }
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public String getViaPointName(int i) {
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (viaInfos != null && viaInfos.size() > i) {
            XPViaPoint xPViaPoint = viaInfos.get(i);
            XPPoiInfo poiPoint = xPViaPoint != null ? xPViaPoint.getPoiPoint() : null;
            if (poiPoint != null) {
                return poiPoint.getName();
            }
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getViaPointType(int i) {
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (viaInfos == null || viaInfos.size() <= i) {
            return -1;
        }
        XPViaPoint xPViaPoint = viaInfos.get(i);
        XPPoiInfo poiPoint = xPViaPoint != null ? xPViaPoint.getPoiPoint() : null;
        if (poiPoint != null) {
            return poiPoint.getType();
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getViaRemainDist(int i) {
        int[] iArr;
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo == null || (iArr = naviInfo.mViaRemainDist) == null || i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getViaRemainTime(int i) {
        int[] iArr;
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo == null || (iArr = naviInfo.mViaRemainTime) == null || i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public String getEndPointName() {
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        if (endInfo != null) {
            return endInfo.getName();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getEndRemainDist() {
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            return (int) naviInfo.mRouteRemainDist;
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getEndRemainTime() {
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            return (int) naviInfo.mRouteRemainTime;
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getCarRemainDistance() {
        return CarServiceManager.getInstance().getCarRemainDistance();
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public float getCarSpeed() {
        return TBTManager.getInstance().getCarSpeed();
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public String getCommonAddress(String str) {
        if (AddressBean.ADDRESS_TYPE_HOME.equals(str)) {
            return getHomeAddress();
        }
        if (AddressBean.ADDRESS_TYPE_COMPANY.equals(str)) {
            return getCompanyAddress();
        }
        return null;
    }

    private String getHomeAddress() {
        FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
        FavoriteAddressBean favoriteAddressBean = new FavoriteAddressBean();
        String str = null;
        if (home != null) {
            favoriteAddressBean.setPoiBean(home.toPoiBean());
            favoriteAddressBean.setFromBigData(false);
        } else if (!XPNetworkManager.INSTANCE.isNetworkConnected() || SearchSceneDataHelper.home == null) {
            favoriteAddressBean = null;
        } else {
            favoriteAddressBean.setPoiBean(SearchSceneDataHelper.home.toPoiBean());
            favoriteAddressBean.setFromBigData(true);
        }
        if (favoriteAddressBean != null) {
            favoriteAddressBean.setAddressType("home");
            str = GsonUtil.toJson(favoriteAddressBean);
        }
        if (L.ENABLE) {
            L.d(TAG, "getHomeAddress: " + str);
        }
        return str;
    }

    private String getCompanyAddress() {
        FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
        FavoriteAddressBean favoriteAddressBean = new FavoriteAddressBean();
        String str = null;
        if (company != null) {
            favoriteAddressBean.setPoiBean(company.toPoiBean());
            favoriteAddressBean.setFromBigData(false);
        } else if (!XPNetworkManager.INSTANCE.isNetworkConnected() || SearchSceneDataHelper.company == null) {
            favoriteAddressBean = null;
        } else {
            favoriteAddressBean.setPoiBean(SearchSceneDataHelper.company.toPoiBean());
            favoriteAddressBean.setFromBigData(true);
        }
        if (favoriteAddressBean != null) {
            favoriteAddressBean.setAddressType(FavoriteType.COMPANY_STRING);
            str = GsonUtil.toJson(favoriteAddressBean);
        }
        if (L.ENABLE) {
            L.d(TAG, "getCompanyAddress: " + str);
        }
        return str;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public String getNavigationInfo() {
        NavigationInfoBean navigationInfoBean = new NavigationInfoBean();
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        if (endInfo != null) {
            navigationInfoBean.setDestinationPoint(endInfo.toPoiBean());
        }
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (viaInfos != null) {
            ArrayList arrayList = new ArrayList();
            for (XPViaPoint xPViaPoint : viaInfos) {
                if (2 == xPViaPoint.getViaType() && xPViaPoint.getPoiPoint() != null) {
                    NaviInfoBean naviInfoBean = new NaviInfoBean();
                    naviInfoBean.setPoiBean(xPViaPoint.getPoiPoint().toPoiBean());
                    arrayList.add(naviInfoBean);
                }
            }
            navigationInfoBean.setViaPoints(arrayList);
        }
        navigationInfoBean.setRemainderLift(CarServiceManager.getInstance().getCarRemainDistance());
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            navigationInfoBean.setRemainderRange((long) naviInfo.mRouteRemainDist);
            navigationInfoBean.setRemainderTime((long) naviInfo.mRouteRemainTime);
        }
        return GsonUtil.toJson(navigationInfoBean);
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isZoomInMax() {
        IMapDelegate iMapDelegate = sMapDelegate;
        return (iMapDelegate == null || iMapDelegate.canZoomIn()) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isZoomOutMin() {
        IMapDelegate iMapDelegate = sMapDelegate;
        return (iMapDelegate == null || iMapDelegate.canZoomOut()) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isRoute() {
        return StatusConst.Mode.ROUTE.name().equals(getCurrentSceneName(false));
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public String getCurrentSceneName(boolean z) {
        MainContext mainContext = sMainContext;
        if (mainContext != null) {
            String name = mainContext.getCurrentScene().getMode().name();
            return (z && sMainContext.getCurrentScene().hasChildScene()) ? sMainContext.getCurrentScene().getTopChildScene().getMode().name() : name;
        }
        return StatusConst.Mode.EMPTY.name();
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public String getHighWayInfo() {
        return TBTManager.getInstance().getHighWayInfo();
    }

    public Coord2DDouble getCenterLocation() {
        IMapDelegate iMapDelegate = sMapDelegate;
        if (iMapDelegate != null) {
            return iMapDelegate.getLonLatFromCenter();
        }
        return null;
    }

    public CarLoc getCarLocation() {
        IMapDelegate iMapDelegate = sMapDelegate;
        if (iMapDelegate != null) {
            return iMapDelegate.getCarLocation();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public boolean isOpenOverViewMode() {
        MainContext mainContext = sMainContext;
        if (mainContext == null || mainContext.getMapView() == null) {
            return false;
        }
        return sMainContext.getMapView().isPreview();
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getMapMode() {
        IMapDelegate iMapDelegate = sMapDelegate;
        if (iMapDelegate != null) {
            return iMapDelegate.getMapMode();
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public String getSettingInfo() {
        return GsonUtil.toJson(SettingWrapper.getCurrentSettingInfo());
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
    public int getCurrentMapScaleLevel() {
        L.d(TAG, "get current map scale Level.");
        IMapDelegate iMapDelegate = sMapDelegate;
        if (iMapDelegate != null) {
            return iMapDelegate.getMapLevel();
        }
        return -1000;
    }
}
