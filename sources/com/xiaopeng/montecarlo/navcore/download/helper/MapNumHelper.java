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
        boolean z;
        MapNum localMapNum = getLocalMapNum();
        if (isMapNumValid(localMapNum)) {
            z = false;
        } else {
            localMapNum = new MapNum();
            localMapNum.strKey = ContextUtils.getString(R.string.setting_map_num_key);
            localMapNum.strVersion = ContextUtils.getString(R.string.setting_map_num_version);
            localMapNum.strContent = ContextUtils.getString(R.string.setting_map_num_content);
            z = true;
        }
        Calendar calendar = Calendar.getInstance();
        int i = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.MAP_NUM_LAST_UPDATE_MONTH, -1);
        int i2 = calendar.get(2);
        if (i2 != i) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.MAP_NUM_LAST_UPDATE_MONTH, i2);
            z = true;
        }
        if (z) {
            updateMapNum(localMapNum);
        }
    }

    private boolean isMapNumValid(MapNum mapNum) {
        return (mapNum == null || TextUtils.isEmpty(mapNum.strKey) || TextUtils.isEmpty(mapNum.strVersion) || TextUtils.isEmpty(mapNum.strContent)) ? false : true;
    }

    private MapNum getLocalMapNum() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.MAP_NUM_DATA, "");
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
        MapDataManager.getInstance().requestMapNum(mapNum, new IMapNumObserver() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$MapNumHelper$X3TgmTkct6jhlHLYGNhrPfhq0uw
            @Override // com.autonavi.gbl.data.observer.IMapNumObserver
            public final void onRequestMapNum(int i, MapNum mapNum2) {
                MapNumHelper.lambda$updateMapNum$0(i, mapNum2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateMapNum$0(int i, MapNum mapNum) {
        if (mapNum != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "IMapNumObserver opErrCode=" + i + ",mapNumContent=" + mapNum.strContent + ",mapNumKey=" + mapNum.strKey + ",mapNumVersion=" + mapNum.strVersion);
            }
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.MAP_NUM_DATA, GsonUtil.toJson(mapNum));
        }
    }

    public String getMapNumContent() {
        MapNum localMapNum = getLocalMapNum();
        return (localMapNum == null || TextUtils.isEmpty(localMapNum.strContent)) ? ContextUtils.getString(R.string.setting_map_num_content) : localMapNum.strContent;
    }

    public void initLaneMapNum() {
        boolean z = getLocalLaneMapNum() != null;
        if (!z || isLaneMapNumOutOfDate()) {
            updateLaneMapNum(z);
        }
    }

    public String getLocalLaneMapNumContent() {
        MapNum localLaneMapNum = getLocalLaneMapNum();
        return localLaneMapNum != null ? localLaneMapNum.strContent : "";
    }

    private void updateLaneMapNum(boolean z) {
        MapNum requestLaneMapNum = MapDataManager.getInstance().requestLaneMapNum(new IMapNumObserver() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$MapNumHelper$epHcBryx2sfCYiqZg3_ZgMzbgWI
            @Override // com.autonavi.gbl.data.observer.IMapNumObserver
            public final void onRequestMapNum(int i, MapNum mapNum) {
                MapNumHelper.this.lambda$updateLaneMapNum$1$MapNumHelper(i, mapNum);
            }
        });
        if (z || requestLaneMapNum == null || TextUtils.isEmpty(requestLaneMapNum.strContent)) {
            return;
        }
        saveLanMapNum(requestLaneMapNum);
    }

    public /* synthetic */ void lambda$updateLaneMapNum$1$MapNumHelper(int i, MapNum mapNum) {
        if (i == 0) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onRequestMapNum:" + i + "  MapNum strKey:" + mapNum.strKey + "-- strVersion:" + mapNum.strVersion + "-- strContent:" + mapNum.strContent);
            }
            saveLanMapNum(mapNum);
            return;
        }
        L.Tag tag2 = TAG;
        L.e(tag2, "request lane mapNum fail errorCode:" + i);
    }

    private void saveLanMapNum(MapNum mapNum) {
        if (mapNum != null) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.LANE_MAP_NUM_DATA, GsonUtil.toJson(mapNum));
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

    private boolean isLaneMapNumOutOfDate() {
        Calendar calendar = Calendar.getInstance();
        long j = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.LANE_MAP_NUM_LAST_UPDATE_TIME, -1L);
        if (j > 0) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2)) ? false : true;
        }
        return true;
    }
}
