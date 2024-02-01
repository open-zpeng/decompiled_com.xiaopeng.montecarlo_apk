package com.xiaopeng.montecarlo.mapoverlay.poidetail;

import android.os.Bundle;
import android.text.TextUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.DecoratorResponseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PoiDetailDecoratorPresenter extends BaseDecoratorPresenter {
    private static final L.Tag TAG = new L.Tag("POP=>PoiDetailDecoratorPresenter");
    protected String mName;
    protected Coord2DDouble mRGCLonLat;
    protected int mRefreshType;
    protected XPPoiInfo mXPPoint;

    public PoiDetailDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        super(baseDecoratorCallback);
        this.mRefreshType = 0;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void update(Bundle bundle) {
        XPPoiInfo xPPoiInfo;
        Coord2DDouble coord2DDouble;
        super.update(bundle);
        this.mName = null;
        this.mRGCLonLat = null;
        if (bundle != null) {
            XPPoiInfo xPPoiInfo2 = (XPPoiInfo) bundle.getParcelable(PoiDetailDecorator.POI_INFO);
            if (xPPoiInfo2 == null) {
                String string = bundle.getString(PoiDetailDecorator.SEARCH_POI_ID);
                this.mName = bundle.getString(PoiDetailDecorator.SEARCH_NAME);
                int i = bundle.getInt(PoiDetailDecorator.SEARCH_PX);
                int i2 = bundle.getInt(PoiDetailDecorator.SEARCH_PY);
                XPPoiInfo xPPoiInfo3 = new XPPoiInfo();
                xPPoiInfo3.setPoiId(string);
                if (this.mDecoratorCallback != null && this.mDecoratorCallback.getMainContext() != null) {
                    this.mRGCLonLat = this.mDecoratorCallback.getMainContext().getMapView().p20ToLonLat(i, i2);
                    Coord2DDouble coord2DDouble2 = this.mRGCLonLat;
                    if (coord2DDouble2 != null) {
                        xPPoiInfo3.setDisplayLat(coord2DDouble2.lat);
                        xPPoiInfo3.setDisplayLon(this.mRGCLonLat.lon);
                        if (isExpanded()) {
                            if (TextUtils.isEmpty(string)) {
                                if (this.mXPPoint != null && RootUtil.compareDouble(this.mRGCLonLat.lon, this.mXPPoint.getDisplayLon()) && RootUtil.compareDouble(this.mRGCLonLat.lat, this.mXPPoint.getDisplayLat())) {
                                    if (L.ENABLE) {
                                        L.Tag tag = TAG;
                                        L.d(tag, "update rgc is same point poiId = " + string);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                XPPoiInfo xPPoiInfo4 = this.mXPPoint;
                                if (xPPoiInfo4 != null && TextUtils.equals(xPPoiInfo4.getPoiId(), string)) {
                                    if (L.ENABLE) {
                                        L.Tag tag2 = TAG;
                                        L.d(tag2, "update detail is same point poiInfo = " + xPPoiInfo3.dumpXPPoiInfo());
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(this.mName)) {
                        xPPoiInfo3.setName(this.mName);
                    } else {
                        xPPoiInfo3.setName(ContextUtils.getString(R.string.none_nearby_poi_name));
                    }
                    xPPoiInfo3.setAddress(ContextUtils.getString(R.string.none_nearby_poi_address));
                    XPCoordinate2DDouble currentLocation = this.mDecoratorCallback.getMainContext().getMapView() != null ? TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation() : null;
                    if (currentLocation != null && (coord2DDouble = this.mRGCLonLat) != null) {
                        xPPoiInfo3.setDistance(LocationUtils.getDistance(currentLocation, new XPCoordinate2DDouble(coord2DDouble)));
                    }
                }
                this.mRefreshType = 1;
                xPPoiInfo2 = xPPoiInfo3;
            } else {
                this.mRefreshType = 2;
                if (isExpanded() && (xPPoiInfo = this.mXPPoint) != null && TextUtils.equals(xPPoiInfo.getPoiId(), xPPoiInfo2.getPoiId())) {
                    if (L.ENABLE) {
                        L.Tag tag3 = TAG;
                        L.d(tag3, "update is same point poiInfo = " + xPPoiInfo2.dumpXPPoiInfo());
                        return;
                    }
                    return;
                }
            }
            this.mXPPoint = xPPoiInfo2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mXPPoint);
            if (L.ENABLE && this.mXPPoint != null) {
                L.Tag tag4 = TAG;
                L.d(tag4, "update mXPPoint = " + this.mXPPoint.dumpXPPoiInfo());
            }
            updateXPPoiInfoList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void refreshPoiInfo(XPPoiInfo xPPoiInfo) {
        if (this.mRefreshType == 2) {
            super.refreshPoiInfo(xPPoiInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public boolean lazyLoad() {
        if (this.mRefreshType == 1) {
            getDataProvider().keywordPoiSearch(this.mXPPoint);
            return true;
        }
        return super.lazyLoad();
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void updateFocusedPoint(DecoratorResponseData decoratorResponseData) {
        if (L.ENABLE) {
            L.d(TAG, "Search Decorator updateFocusedPoint: ");
        }
        int i = 2;
        XPPoiInfo xPPoiInfo = null;
        if (decoratorResponseData != null) {
            int searchType = decoratorResponseData.getSearchType();
            if (decoratorResponseData.getList() == null) {
                decoratorResponseData.setList(new ArrayList());
            }
            if (decoratorResponseData.getList().size() > 0) {
                if (L.ENABLE) {
                    L.d(TAG, "DecoratorResponseData size = " + decoratorResponseData.getList().size());
                }
                xPPoiInfo = decoratorResponseData.getList().get(0);
            }
            if (xPPoiInfo == null) {
                if (L.ENABLE) {
                    L.d(TAG, "updateFocusedPoint no result, type = " + searchType);
                }
                xPPoiInfo = this.mXPPoint;
                if (searchType == 5 && !TextUtils.isEmpty(this.mName)) {
                    xPPoiInfo.setName(this.mName);
                }
            } else {
                if (L.ENABLE) {
                    L.d(TAG, "updateFocusedPoint before set, poiInfo = " + xPPoiInfo.dumpXPPoiInfo() + ", type = " + searchType);
                    if (this.mXPPoint != null) {
                        L.d(TAG, "updateFocusedPoint before set, mXPPoint = " + this.mXPPoint.dumpXPPoiInfo());
                    }
                }
                if (XPPoiCategory.isCityName(xPPoiInfo.getCategory())) {
                    if (TextUtils.isEmpty(xPPoiInfo.getName())) {
                        xPPoiInfo.setName(ContextUtils.getString(R.string.none_nearby_poi_name));
                    }
                    if (TextUtils.isEmpty(xPPoiInfo.getAddress())) {
                        xPPoiInfo.setAddress(ContextUtils.getString(R.string.none_nearby_poi_address));
                    }
                } else if (6 == searchType) {
                    xPPoiInfo = xPPoiInfo.toRGCPoi();
                    String string = RootUtil.isEmptyString(xPPoiInfo.getAddress()) ? ContextUtils.getString(R.string.none_nearby_poi_name) : xPPoiInfo.getAddress();
                    String name = xPPoiInfo.getName();
                    if (!RootUtil.isEmptyString(name)) {
                        if (!name.endsWith(ContextUtils.getString(R.string.nearby))) {
                            name = name + ContextUtils.getString(R.string.nearby);
                        }
                    } else {
                        name = ContextUtils.getString(R.string.none_nearby_poi_address);
                    }
                    XPPoiInfo xPPoiInfo2 = this.mXPPoint;
                    if (xPPoiInfo2 != null) {
                        xPPoiInfo.setDisplayLat(xPPoiInfo2.getDisplayLat());
                        xPPoiInfo.setDisplayLon(this.mXPPoint.getDisplayLon());
                    }
                    xPPoiInfo.setName(string);
                    xPPoiInfo.setAddress(name);
                } else {
                    i = xPPoiInfo.getPoiSource();
                }
                if (L.ENABLE) {
                    L.d(TAG, "updateFocusedPoint after set, poiInfo = " + xPPoiInfo.dumpXPPoiInfo());
                }
            }
            XPPoiInfo.generatePoiIdIfEmpty(xPPoiInfo, i);
            if (decoratorResponseData.getList().size() > 0) {
                decoratorResponseData.getList().set(0, xPPoiInfo);
            } else {
                decoratorResponseData.getList().add(xPPoiInfo);
            }
        }
        super.updateFocusedPoint(decoratorResponseData);
    }
}
