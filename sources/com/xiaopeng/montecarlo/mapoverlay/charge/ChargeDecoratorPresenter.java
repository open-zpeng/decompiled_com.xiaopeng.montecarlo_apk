package com.xiaopeng.montecarlo.mapoverlay.charge;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeCacheInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class ChargeDecoratorPresenter extends BaseDecoratorPresenter {
    private static final int CHARGE_BIZ_PRIORITY_LEVEL_1 = 5;
    private static final int CHARGE_BIZ_PRIORITY_LEVEL_2 = 4;
    private static final int CHARGE_BIZ_PRIORITY_LEVEL_3 = 3;
    private static final int CHARGE_BIZ_PRIORITY_LEVEL_4 = 2;
    private static final int CHARGE_BIZ_PRIORITY_LEVEL_5 = 1;
    private static final L.Tag TAG = new L.Tag("POP=>ChargeDecoratorPresenter");
    private final List<XPPointBaseData> mChangedList;
    private List<XPPoiInfo> mNewPointList;
    private List<XPPoiInfo> mOldPointList;

    public ChargeDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        super(baseDecoratorCallback);
        this.mChangedList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void updateXPPoiInfoList(@NonNull List<XPPoiInfo> list) {
        this.mNewPointList = new ArrayList(list);
        this.mOldPointList = new ArrayList(this.mXPPointList);
        super.updateXPPoiInfoList(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public List<XPPointBaseData> getUpdatePointList(List<XPPointBaseData> list, List<XPPointBaseData> list2) {
        List<XPPointBaseData> updatePointList = super.getUpdatePointList(list, list2);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getUpdatePointList update.size = " + updatePointList.size());
        }
        this.mChangedList.clear();
        for (int i = 0; i < updatePointList.size(); i++) {
            XPPointBaseData xPPointBaseData = updatePointList.get(i);
            XPPoiInfo findPointByBizPoint = findPointByBizPoint(xPPointBaseData, list, this.mOldPointList);
            XPPoiInfo findPointByBizPoint2 = findPointByBizPoint(xPPointBaseData, list2, this.mNewPointList);
            if (findPointByBizPoint != null && findPointByBizPoint2 != null) {
                if (Objects.equals(ChargeCacheInfo.parse(findPointByBizPoint), ChargeCacheInfo.parse(findPointByBizPoint2))) {
                    if (L.ENABLE) {
                        L.Tag tag2 = TAG;
                        L.d(tag2, "getUpdatePointList equals i = " + i + ", bizPoint = " + xPPointBaseData);
                    }
                } else {
                    this.mChangedList.add(xPPointBaseData);
                    if (L.ENABLE) {
                        L.Tag tag3 = TAG;
                        L.d(tag3, "getUpdatePointList change i = " + i + ", bizPoint = " + xPPointBaseData);
                    }
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag4 = TAG;
            L.d(tag4, "getUpdatePointList mChangedList.size = " + this.mChangedList.size());
        }
        updatePointList.removeAll(this.mChangedList);
        return updatePointList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public List<XPPointBaseData> getRemovePointList(List<XPPointBaseData> list, List<XPPointBaseData> list2) {
        List<XPPointBaseData> removePointList = super.getRemovePointList(list, list2);
        ChargeBizDataManager.getInstance().clearChargeBizData(removePointList);
        return removePointList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public List<XPPointBaseData> getAddPointList(List<XPPointBaseData> list, List<XPPointBaseData> list2) {
        List<XPPointBaseData> addPointList = super.getAddPointList(list, list2);
        for (XPPointBaseData xPPointBaseData : addPointList) {
            ChargeBizDataManager.getInstance().createChargeBizData(findPointByBizPoint(xPPointBaseData, list, this.mNewPointList), xPPointBaseData);
        }
        return addPointList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public XPPointBaseData generateBizPoint(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        XPPointBaseData generateBizPoint = super.generateBizPoint(i, i2, xPPoiInfo);
        generateBizPoint.priority = getChargeBizPriority(xPPoiInfo, xPPoiInfo.getCategory() == 107);
        return generateBizPoint;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void onClick(XPPointBaseData xPPointBaseData) {
        if (this.mDecoratorCallback == null || Utils.isRestrictScene(this.mDecoratorCallback.getMainContext().getCurrentScene())) {
            return;
        }
        if (xPPointBaseData == null) {
            L.w(TAG, "bizCallbackData is null");
            return;
        }
        XPPoiInfo findPointByBizPoint = findPointByBizPoint(xPPointBaseData);
        if (findPointByBizPoint == null) {
            L.w(TAG, "xpPoiInfo is null");
        } else if (findPointByBizPoint.isGroupInfo()) {
            ArrayList<XPCoordinate2DDouble> poiPolygonBounds = findPointByBizPoint.getPoiPolygonBounds();
            if (CollectionUtils.isEmpty(poiPolygonBounds)) {
                L.w(TAG, "poiPolygonBounds is null");
                return;
            }
            int size = poiPolygonBounds.size();
            if (size <= 0) {
                L.w(TAG, "poiPolygonBounds size is 0");
                return;
            }
            CarLoc carLoc = new CarLoc();
            double d = 0.0d;
            double d2 = 0.0d;
            for (int i = 0; i < size; i++) {
                d2 += poiPolygonBounds.get(i).mLon;
                d += poiPolygonBounds.get(i).mLat;
            }
            PathMatchInfo pathMatchInfo = new PathMatchInfo();
            pathMatchInfo.longitude = d2 / poiPolygonBounds.size();
            pathMatchInfo.latitude = d / poiPolygonBounds.size();
            carLoc.vecPathMatchInfo.add(pathMatchInfo);
            if (this.mDecoratorCallback.getMainContext().getMapView().isFollowMode()) {
                this.mDecoratorCallback.getMainContext().getMapView().getBizControlManager().setFollowMode(false);
                try {
                    Thread.sleep(100L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mDecoratorCallback.getMainContext().getMapView().moveMapCenter(carLoc, true);
            this.mDecoratorCallback.getMainContext().getMapView().setMapLevel(15.0f);
        } else if (findPointByBizPoint.getCategory() == 119) {
            IBaseScene currentScene = this.mDecoratorCallback.getMainContext().getCurrentScene();
            if (currentScene instanceof BaseMapScene) {
                TrafficEventPopParam.Builder builder = new TrafficEventPopParam.Builder(3);
                builder.setLoc(new Coord2DDouble(findPointByBizPoint.getDisplayLon(), findPointByBizPoint.getDisplayLat())).setJamRoadName(findPointByBizPoint.getName()).setDes(findPointByBizPoint.getRoadInfo()).setUpdateTime(findPointByBizPoint.getOpenTime()).setImages(findPointByBizPoint.getImageUrlList());
                ((BaseMapScene) currentScene).showSceneTrafficEventPop(builder.build());
            }
        } else {
            super.onClick(xPPointBaseData);
        }
    }

    private int getChargeBizPriority(XPPoiInfo xPPoiInfo, boolean z) {
        int i = 0;
        try {
            i = xPPoiInfo.getXPDeepInfoPoi().getChargeData()[0].getNumFast();
        } catch (Exception unused) {
        }
        if (z) {
            return 5;
        }
        return i > 0 ? 4 : 1;
    }
}
