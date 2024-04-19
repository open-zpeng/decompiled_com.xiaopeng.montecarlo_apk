package com.xiaopeng.montecarlo.navcore.download.helper;

import android.text.TextUtils;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.observer.IMapNumObserver;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class MapNumHelper {
    private static final L.Tag TAG = new L.Tag("MapNumHelper");

    public void initMapNum() {
        boolean isMapNumOutOfDate = isMapNumOutOfDate(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.MAP_PUBLICATION_NUM_LAST_UPDATE_TIME, -1L));
        L.Tag tag = TAG;
        L.i(tag, "initMapNum isNeedUpdate = " + isMapNumOutOfDate);
        MapNum mapNum = new MapNum();
        mapNum.strKey = ContextUtils.getString(R.string.setting_map_publication_num_key);
        mapNum.strVersion = ContextUtils.getString(R.string.setting_map_num_version);
        if (isMapNumOutOfDate) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.MAP_PUBLICATION_NUM_LAST_UPDATE_TIME, Calendar.getInstance().getTimeInMillis());
            updateMapNum(mapNum);
        }
    }

    public void initInternetNum() {
        boolean isMapNumOutOfDate = isMapNumOutOfDate(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.MAP_INTERNET_NUM_LAST_UPDATE_TIME, -1L));
        L.Tag tag = TAG;
        L.i(tag, "initInternetNum isNeedUpdate = " + isMapNumOutOfDate);
        MapNum mapNum = new MapNum();
        mapNum.strKey = ContextUtils.getString(R.string.setting_map_internet_num_key);
        if (isMapNumOutOfDate) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.MAP_INTERNET_NUM_LAST_UPDATE_TIME, Calendar.getInstance().getTimeInMillis());
            updateInternetMapNum(mapNum);
        }
    }

    private boolean isMapNumValid(MapNum mapNum) {
        return (mapNum == null || TextUtils.isEmpty(mapNum.strKey) || TextUtils.isEmpty(mapNum.strVersion) || TextUtils.isEmpty(mapNum.strContent)) ? false : true;
    }

    private MapNum getLocalMapNum() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.MAP_PUBLICATION_NUM_DATA, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (MapNum) GsonUtil.fromJson(string, (Class<Object>) MapNum.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private MapNum getLocalInternetMapNum() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.MAP_INTERNET_NUM_DATA, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (MapNum) GsonUtil.fromJson(string, (Class<Object>) MapNum.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private void updateMapNum(MapNum mapNum) {
        MapDataManager.getInstance().requestMapNum(mapNum, new IMapNumObserver() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$MapNumHelper$nt8w5qmNi5495Kizt6tlNq4Xx7E
            @Override // com.autonavi.gbl.data.observer.IMapNumObserver
            public final void onRequestMapNum(int i, MapNum mapNum2) {
                MapNumHelper.this.lambda$updateMapNum$0$MapNumHelper(i, mapNum2);
            }
        });
    }

    public /* synthetic */ void lambda$updateMapNum$0$MapNumHelper(int i, MapNum mapNum) {
        if (mapNum != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "IMapNumObserver opErrCode=" + i + ",mapNumContent=" + mapNum.strContent + ",mapNumKey=" + mapNum.strKey + ",mapNumVersion=" + mapNum.strVersion);
            }
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.MAP_PUBLICATION_NUM_DATA, GsonUtil.toJson(mapNum));
            initInternetNum();
        }
    }

    private void updateInternetMapNum(MapNum mapNum) {
        MapDataManager.getInstance().requestMapNum(mapNum, new IMapNumObserver() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$MapNumHelper$VgjrZMaKdeu0NX3GYzlJ-kj23E0
            @Override // com.autonavi.gbl.data.observer.IMapNumObserver
            public final void onRequestMapNum(int i, MapNum mapNum2) {
                MapNumHelper.lambda$updateInternetMapNum$1(i, mapNum2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateInternetMapNum$1(int i, MapNum mapNum) {
        if (mapNum != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "IMapNumObserver opErrCode=" + i + ",mapNumContent=" + mapNum.strContent + ",mapNumKey=" + mapNum.strKey + ",mapNumVersion=" + mapNum.strVersion);
            }
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.MAP_INTERNET_NUM_DATA, GsonUtil.toJson(mapNum));
        }
    }

    public String getPublicationMapNumContent() {
        MapNum localMapNum = getLocalMapNum();
        return (localMapNum == null || TextUtils.isEmpty(localMapNum.strContent)) ? "" : localMapNum.strContent;
    }

    public String getInternetMapNumContent() {
        MapNum localInternetMapNum = getLocalInternetMapNum();
        return localInternetMapNum != null ? localInternetMapNum.strContent : "";
    }

    public void initLaneMapNum() {
        boolean z = getLocalLane30MapNum() != null;
        long j = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.LANE_MAP_NUM_LAST_UPDATE_TIME, -1L);
        if (!z || isMapNumOutOfDate(j)) {
            updateLane30MapNum(z);
        }
    }

    public String getLocalLaneMapNumContent() {
        MapNum localLaneMapNum = getLocalLaneMapNum();
        return localLaneMapNum != null ? localLaneMapNum.strContent : "";
    }

    public String getLocalLane30MapNumContent() {
        MapNum localLane30MapNum = getLocalLane30MapNum();
        return localLane30MapNum != null ? localLane30MapNum.strContent : "";
    }

    private void updateLaneMapNum(boolean z) {
        MapNum requestLaneMapNum = MapDataManager.getInstance().requestLaneMapNum(new IMapNumObserver() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$MapNumHelper$c8EzVyB0B-8fPfW0IQGSyYE12ks
            @Override // com.autonavi.gbl.data.observer.IMapNumObserver
            public final void onRequestMapNum(int i, MapNum mapNum) {
                MapNumHelper.this.lambda$updateLaneMapNum$2$MapNumHelper(i, mapNum);
            }
        });
        if (z || requestLaneMapNum == null || TextUtils.isEmpty(requestLaneMapNum.strContent)) {
            return;
        }
        saveLanMapNum(requestLaneMapNum);
    }

    public /* synthetic */ void lambda$updateLaneMapNum$2$MapNumHelper(int i, MapNum mapNum) {
        if (i == 0) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "requestLaneMapNum:" + i + "  MapNum strKey:" + mapNum.strKey + "-- strVersion:" + mapNum.strVersion + "-- strContent:" + mapNum.strContent);
            }
            saveLanMapNum(mapNum);
            return;
        }
        L.Tag tag2 = TAG;
        L.e(tag2, "request lane mapNum fail errorCode:" + i);
    }

    private void updateLane30MapNum(boolean z) {
        MapNum requestLane30MapNum = MapDataManager.getInstance().requestLane30MapNum(new IMapNumObserver() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$MapNumHelper$E2JyPjzUGk-ZujSER_J1-1TRQgs
            @Override // com.autonavi.gbl.data.observer.IMapNumObserver
            public final void onRequestMapNum(int i, MapNum mapNum) {
                MapNumHelper.this.lambda$updateLane30MapNum$3$MapNumHelper(i, mapNum);
            }
        });
        if (z || requestLane30MapNum == null || TextUtils.isEmpty(requestLane30MapNum.strContent)) {
            return;
        }
        saveLan30MapNum(requestLane30MapNum);
    }

    public /* synthetic */ void lambda$updateLane30MapNum$3$MapNumHelper(int i, MapNum mapNum) {
        if (i == 0) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "requestLane30MapNum:" + i + "  MapNum strKey:" + mapNum.strKey + "-- strVersion:" + mapNum.strVersion + "-- strContent:" + mapNum.strContent);
            }
            saveLan30MapNum(mapNum);
            return;
        }
        L.Tag tag2 = TAG;
        L.e(tag2, "request lane30 mapNum fail errorCode:" + i);
    }

    private void saveLanMapNum(MapNum mapNum) {
        if (mapNum != null) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.LANE_MAP_NUM_DATA, GsonUtil.toJson(mapNum));
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.LANE_MAP_NUM_LAST_UPDATE_TIME, Calendar.getInstance().getTimeInMillis());
        }
    }

    private void saveLan30MapNum(MapNum mapNum) {
        if (mapNum != null) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.LANE30_MAP_NUM_DATA, GsonUtil.toJson(mapNum));
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.LANE_MAP_NUM_LAST_UPDATE_TIME, Calendar.getInstance().getTimeInMillis());
        }
    }

    private MapNum getLocalLaneMapNum() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.LANE_MAP_NUM_DATA, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return (MapNum) GsonUtil.fromJson(string, (Class<Object>) MapNum.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private MapNum getLocalLane30MapNum() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.LANE30_MAP_NUM_DATA, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return (MapNum) GsonUtil.fromJson(string, (Class<Object>) MapNum.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private boolean isMapNumOutOfDate(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j > 0) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) ? false : true;
        }
        return true;
    }
}
