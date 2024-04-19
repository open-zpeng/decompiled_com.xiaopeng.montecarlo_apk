package com.xiaopeng.montecarlo.scenes.mapscene;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.ScratchSpotDataHelper;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ScratchSpotBroadcastHelper {
    private static final float DIS_CACHE = 0.03f;
    private static final int DIS_TRIGGER = 200;
    private static final int INTERVAL_BROADCAST = 86400000;
    private static final int INTERVAL_QUERY_CACHE = 5000;
    private static final int INTERVAL_QUERY_DB = 60000;
    private static final int MSG_INIT_DATA = 0;
    private static final int MSG_QUERY_CACHE = 2;
    private static final int MSG_QUERY_DB = 1;
    private static final L.Tag TAG = new L.Tag("SSBroadcastHelper");
    private HashMap<String, Long> mBoardCastHistory = new HashMap<>();
    private BroadcastHandler mHandler = new BroadcastHandler(WorkThreadUtil.getInstance().getStatusThreadLooper());
    private List<XPPoiInfo> mPoiInfoList;

    public void start() {
        L.i(TAG, "start");
        this.mHandler.sendEmptyMessage(0);
        this.mHandler.sendEmptyMessage(1);
    }

    public void stop() {
        L.i(TAG, "stop");
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBoardCastHistory() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_SCRATCHSPOT_BOARDCAST_HISTORY, "");
        HashMap hashMap = (HashMap) GsonUtil.fromJson(string, new TypeToken<HashMap<String, Long>>() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.ScratchSpotBroadcastHelper.1
        }.getType());
        if (CollectionUtils.isEmpty(hashMap)) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "initBoardCastHistory:" + string);
        }
        this.mBoardCastHistory.putAll(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerQueryDb() {
        this.mHandler.sendEmptyMessageDelayed(1, 60000L);
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            return;
        }
        double lon = currentLocation.getLon();
        double lat = currentLocation.getLat();
        double d = lon - 0.029999999329447746d;
        double d2 = lat - 0.029999999329447746d;
        double d3 = lat + 0.029999999329447746d;
        double d4 = lon + 0.029999999329447746d;
        this.mPoiInfoList = ScratchSpotDataHelper.query(new Coord2DDouble[]{new Coord2DDouble(d, d2), new Coord2DDouble(d, d3), new Coord2DDouble(d4, d2), new Coord2DDouble(d4, d3)});
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("handlerQueryDb mPoiInfoList size:");
            List<XPPoiInfo> list = this.mPoiInfoList;
            sb.append(list != null ? list.size() : 0);
            L.d(tag, sb.toString());
        }
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
        if (CollectionUtils.isNotEmpty(this.mPoiInfoList)) {
            this.mHandler.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerQueryCache() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("handlerQueryCache mPoiInfoList size:");
            List<XPPoiInfo> list = this.mPoiInfoList;
            sb.append(list == null ? 0 : list.size());
            L.d(tag, sb.toString());
        }
        this.mHandler.sendEmptyMessageDelayed(2, UILooperObserver.ANR_TRIGGER_TIME);
        if (CollectionUtils.isEmpty(this.mPoiInfoList)) {
            return;
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList();
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        for (XPPoiInfo xPPoiInfo : this.mPoiInfoList) {
            double distance = LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat()), currentLocation);
            if (distance <= 200.0d) {
                xPPoiInfo.setDistance(distance);
                arrayList.add(xPPoiInfo);
            }
        }
        if (CollectionUtils.isEmpty(arrayList)) {
            return;
        }
        Collections.sort(arrayList, new Comparator<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.ScratchSpotBroadcastHelper.2
            @Override // java.util.Comparator
            public int compare(XPPoiInfo xPPoiInfo2, XPPoiInfo xPPoiInfo3) {
                if (xPPoiInfo2.getDistance() > xPPoiInfo3.getDistance()) {
                    return 1;
                }
                return xPPoiInfo2.getDistance() < xPPoiInfo3.getDistance() ? -1 : 0;
            }
        });
        if (this.mBoardCastHistory == null) {
            return;
        }
        for (XPPoiInfo xPPoiInfo2 : arrayList) {
            String key = getKey(xPPoiInfo2);
            if (!this.mBoardCastHistory.containsKey(key)) {
                L.Tag tag2 = TAG;
                L.i(tag2, "mBoardCastHistory not contain key " + key);
                executeTTS(xPPoiInfo2);
                return;
            }
            long longValue = this.mBoardCastHistory.get(key).longValue();
            if (longValue <= System.currentTimeMillis() - XpCacheConsts.ONE_DAY) {
                L.Tag tag3 = TAG;
                L.i(tag3, "mBoardCastHistory contain key " + key + " lastTime " + longValue);
                executeTTS(xPPoiInfo2);
                return;
            }
        }
    }

    private void executeTTS(XPPoiInfo xPPoiInfo) {
        L.i(TAG, "executeTTS");
        TTSProxy.getInstance().speak(ContextUtils.getString(R.string.scratch_spot_broadcast), null);
        addBoardCastHistoryRecord(xPPoiInfo, System.currentTimeMillis());
    }

    private void addBoardCastHistoryRecord(XPPoiInfo xPPoiInfo, long j) {
        HashMap<String, Long> hashMap;
        if (xPPoiInfo == null || (hashMap = this.mBoardCastHistory) == null) {
            return;
        }
        hashMap.put(getKey(xPPoiInfo), Long.valueOf(j));
        Iterator<Map.Entry<String, Long>> it = this.mBoardCastHistory.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().longValue() <= System.currentTimeMillis() - XpCacheConsts.ONE_DAY) {
                it.remove();
            }
        }
        String json = GsonUtil.toJson(this.mBoardCastHistory);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "save scratch spot broadcast:" + json);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_SCRATCHSPOT_BOARDCAST_HISTORY, json);
    }

    private String getKey(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return "";
        }
        return xPPoiInfo.getDisplayLon() + "," + xPPoiInfo.getDisplayLat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class BroadcastHandler extends Handler {
        public BroadcastHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 0) {
                ScratchSpotBroadcastHelper.this.initBoardCastHistory();
            } else if (i == 1) {
                ScratchSpotBroadcastHelper.this.handlerQueryDb();
            } else if (i != 2) {
            } else {
                ScratchSpotBroadcastHelper.this.handlerQueryCache();
            }
        }
    }
}
