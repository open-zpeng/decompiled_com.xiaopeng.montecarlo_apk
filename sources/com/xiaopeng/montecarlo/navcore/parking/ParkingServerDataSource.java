package com.xiaopeng.montecarlo.navcore.parking;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPNaviServerPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviParkingService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviParkRecommendRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviParkRecommendResponse;
import com.xiaopeng.montecarlo.navcore.parking.bean.DestinationBean;
import com.xiaopeng.montecarlo.navcore.parking.bean.DestinationExtraBean;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseLinkAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPVariantPath;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class ParkingServerDataSource implements ParkingDataSource {
    private static final L.Tag TAG = new L.Tag("ParkingServerDataSource");
    private static ParkingServerDataSource sInstance;
    private INaviParkingService mNaviParkingService = (INaviParkingService) HttpClientManager.getInstance().getService(INaviParkingService.class);

    private ParkingServerDataSource() {
    }

    public static ParkingServerDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new ParkingServerDataSource();
        }
        return sInstance;
    }

    @Override // com.xiaopeng.montecarlo.navcore.parking.ParkingDataSource
    public List<XPPoiInfo> fetchParking(XPPoiInfo xPPoiInfo) {
        NaviParkRecommendRequest createParkRecommendRequest = createParkRecommendRequest(xPPoiInfo);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "fetchParking request : " + GsonUtil.toJson(createParkRecommendRequest));
        }
        NaviParkRecommendResponse recommend = this.mNaviParkingService.recommend(createParkRecommendRequest);
        if (recommend == null) {
            return null;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.longLog(tag2, "fetchParking response : " + GsonUtil.toJson(recommend));
        }
        return PoiConvert.toXpPoiInfoList(recommend.getParks());
    }

    private NaviParkRecommendRequest createParkRecommendRequest(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.w(TAG, "createParkRecommendRequest, endPoint is null");
            return null;
        }
        XPCarLocation currentCarLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentCarLocation();
        XPNaviServerPoint xPNaviServerPoint = new XPNaviServerPoint(currentCarLocation.mLongitude, currentCarLocation.mLatitude);
        return new NaviParkRecommendRequest().setCurrentLocation(xPNaviServerPoint).setDestination(createDestinationBean(xPPoiInfo));
    }

    private DestinationBean createDestinationBean(XPPoiInfo xPPoiInfo) {
        int i;
        DestinationBean destinationBean = new DestinationBean();
        if (FavoriteDataManager.getInstance().isCompany(xPPoiInfo)) {
            i = 3;
        } else {
            i = FavoriteDataManager.getInstance().isHome(xPPoiInfo) ? 2 : 1;
        }
        XPCoordinate2DDouble routeLastPoint = TBTManager.getInstance().getRouteLastPoint(TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentRoutePathIndex());
        if (routeLastPoint == null) {
            routeLastPoint = xPPoiInfo.getNaviPoint(false);
        }
        destinationBean.setFavoriteType(i).setPoi(xPPoiInfo.getPoiId()).setCategory(xPPoiInfo.getBlCategory()).setCoordType("gcj02").setSource(String.valueOf(xPPoiInfo.getPoiSource())).setName(xPPoiInfo.getName()).setAddress(xPPoiInfo.getAddress()).setNaviLocation(new XPNaviServerPoint(routeLastPoint.getLon(), routeLastPoint.getLat())).setLocation(new XPNaviServerPoint(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat()));
        if (xPPoiInfo.isInAOI()) {
            destinationBean.setAoi(PoiConvert.toNaviServerPoi(xPPoiInfo));
        }
        ArrayList<XPPoiInfo> park = xPPoiInfo.getPark();
        if (park != null && !park.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<XPPoiInfo> it = park.iterator();
            while (it.hasNext()) {
                arrayList.add(PoiConvert.toNaviServerPoi(it.next()));
            }
            destinationBean.setSubPois(arrayList);
        }
        destinationBean.setExtraInfo(createDestinationExtraBean());
        return destinationBean;
    }

    private DestinationExtraBean createDestinationExtraBean() {
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if (currentNaviVariantPath == null || !(currentNaviVariantPath instanceof XPVariantPath)) {
            return null;
        }
        DestinationExtraBean destinationExtraBean = new DestinationExtraBean();
        XPDrivePathAccessor drivePathAccessor = currentNaviVariantPath.getDrivePathAccessor();
        if (drivePathAccessor == null) {
            return destinationExtraBean;
        }
        XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(drivePathAccessor.getSegmentCount() - 1);
        if (segmentAccessor == null) {
            drivePathAccessor.recycle();
            return destinationExtraBean;
        }
        XPBaseLinkAccessor linkAccessor = segmentAccessor.getLinkAccessor(segmentAccessor.getLinkCount() - 1);
        if (linkAccessor == null) {
            drivePathAccessor.recycle();
            return destinationExtraBean;
        }
        int roadClass = linkAccessor.getRoadClass();
        int linkType = linkAccessor.getLinkType();
        int formway = linkAccessor.getFormway();
        drivePathAccessor.recycle();
        destinationExtraBean.setRoadClass(roadClass).setRoadLinkType(linkType).setRoadFormway(formway);
        return destinationExtraBean;
    }
}
