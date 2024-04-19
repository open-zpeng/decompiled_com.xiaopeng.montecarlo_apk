package com.xiaopeng.montecarlo.scenes.mapscene;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.pos.model.LocInfo;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.LccGeoFenceInfo;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class LccGeoFenceHelper {
    private static final int CONFIDENCE_LEVEL_HIGH = 1;
    private static final int CONFIDENCE_LEVEL_LOW = 3;
    private static final int CONFIDENCE_LEVEL_MEDIUM = 2;
    private static final int CONFIDENCE_LEVEL_NO_DEFINED = 0;
    private static final int DIR_MISTAKE_THRESHOLD = 30;
    private static final float DIS_CACHE = 0.03f;
    private static final int INTERVAL_QUERY_CACHE = 1000;
    private static final int INTERVAL_QUERY_DB = 60000;
    private static final double INVALID_LONLAT = 361.0d;
    private static final int IN_DANGER_AREA = 1;
    private static final int MSG_QUERY_CACHE = 2;
    private static final int MSG_QUERY_DB = 1;
    private static final int NOT_IN_DANGER_AREA = 0;
    private static final L.Tag TAG = new L.Tag("LccGeoFenceHelper");
    private List<LccGeoFenceInfo> mLccGeoFenceInfoList;
    boolean mMatchGeoFence = false;
    private boolean mEnableBroadcast = false;
    private GeoFenceHelperHandler mHandler = new GeoFenceHelperHandler(WorkThreadUtil.getInstance().getStatusThreadLooper());

    public void start() {
        L.i(TAG, "start");
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mHandler.sendEmptyMessage(1);
    }

    public void stop() {
        L.i(TAG, "stop");
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
    }

    public void enableBroadcast(boolean z) {
        this.mEnableBroadcast = z;
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
        this.mLccGeoFenceInfoList = LccGeoFenceDataHelper.query(new XPCoordinate2DDouble[]{new XPCoordinate2DDouble(d, d2), new XPCoordinate2DDouble(d, d3), new XPCoordinate2DDouble(d4, d2), new XPCoordinate2DDouble(d4, d3)});
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handlerQueryDb mLccGeoFenceInfoList size:");
        List<LccGeoFenceInfo> list = this.mLccGeoFenceInfoList;
        sb.append(list == null ? 0 : list.size());
        L.i(tag, sb.toString());
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
        if (CollectionUtils.isNotEmpty(this.mLccGeoFenceInfoList)) {
            this.mHandler.sendEmptyMessage(2);
        } else if (this.mMatchGeoFence) {
            handlerGeoFenceChange(false, 0, null);
        }
    }

    private void handlerGeoFenceChange(boolean z, int i, LccGeoFenceInfo lccGeoFenceInfo) {
        this.mMatchGeoFence = z;
        if (this.mMatchGeoFence) {
            L.i(TAG, "enter lcc geoFence");
            if (lccGeoFenceInfo == null) {
                L.w(TAG, "handlerGeoFenceChange matchedInfo is null");
                setNaviDangerAreaRDInfo(1, 0, 0, 0, 0, i, 0);
            } else {
                setNaviDangerAreaRDInfo(1, lccGeoFenceInfo.getDangerLane(), lccGeoFenceInfo.getDangerLaneNumber(), lccGeoFenceInfo.getDangerType(), lccGeoFenceInfo.getDangerLevel(), i, lccGeoFenceInfo.getAction());
            }
            if (this.mEnableBroadcast) {
                TTSProxy.getInstance().speak(ContextUtils.getString(R.string.enter_lcc_geo_fence), null);
                return;
            }
            return;
        }
        L.i(TAG, "exit lcc geoFence");
        setNaviDangerAreaRDInfo(0, 0, 0, 0, 0, 0, 0);
        if (this.mEnableBroadcast) {
            TTSProxy.getInstance().speak(ContextUtils.getString(R.string.exit_lcc_geo_fence), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerQueryCache() {
        boolean z;
        boolean z2;
        boolean z3;
        LccGeoFenceInfo lccGeoFenceInfo;
        this.mHandler.sendEmptyMessageDelayed(2, 1000L);
        int i = 0;
        if (CollectionUtils.isEmpty(this.mLccGeoFenceInfoList)) {
            handlerGeoFenceChange(false, 0, null);
            return;
        }
        Iterator<LccGeoFenceInfo> it = this.mLccGeoFenceInfoList.iterator();
        boolean z4 = false;
        boolean z5 = false;
        while (it.hasNext()) {
            lccGeoFenceInfo = it.next();
            boolean inGeoFence = inGeoFence(new XPCoordinate2DDouble[]{new XPCoordinate2DDouble(lccGeoFenceInfo.getRangeLeftBottomLon(), lccGeoFenceInfo.getRangeLeftBottomLat()), new XPCoordinate2DDouble(lccGeoFenceInfo.getRangeRightTopLon(), lccGeoFenceInfo.getRangeRightTopLat())});
            boolean isDirectionMatched = isDirectionMatched(lccGeoFenceInfo.getRoadDir());
            z3 = isRoadNameMatched(lccGeoFenceInfo.getRoadName());
            z2 = isRoadTypeMatched(lccGeoFenceInfo.getType1(), lccGeoFenceInfo.getType2());
            if (L.ENABLE) {
                L.d(TAG, inGeoFence + ", " + isDirectionMatched + " " + z3 + " " + z2);
            }
            if (!this.mMatchGeoFence) {
                if (inGeoFence && isDirectionMatched) {
                    z = true;
                    break;
                }
                z5 = z3;
                z4 = z2;
            } else if (inGeoFence) {
                z = true;
                break;
            } else {
                z5 = z3;
                z4 = z2;
            }
        }
        z = false;
        z2 = z4;
        z3 = z5;
        lccGeoFenceInfo = null;
        if (z) {
            i = (z3 || z2) ? 2 : 3;
            if (z3 && z2) {
                i = 1;
            }
        }
        if (this.mMatchGeoFence != z) {
            handlerGeoFenceChange(z, i, lccGeoFenceInfo);
        }
    }

    private boolean inGeoFence(XPCoordinate2DDouble[] xPCoordinate2DDoubleArr) {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            return false;
        }
        double d = INVALID_LONLAT;
        int i = 0;
        double d2 = 361.0d;
        double d3 = 361.0d;
        double d4 = 361.0d;
        double d5 = 361.0d;
        while (i < xPCoordinate2DDoubleArr.length) {
            XPCoordinate2DDouble xPCoordinate2DDouble = xPCoordinate2DDoubleArr[i];
            if (xPCoordinate2DDouble == null) {
                L.w(TAG, "coord2DDouble is null " + i);
            } else if (d == d3 || d == d2 || d == d5 || d == d4) {
                double d6 = xPCoordinate2DDouble.mLon;
                d2 = xPCoordinate2DDouble.mLon;
                double d7 = xPCoordinate2DDouble.mLat;
                d4 = xPCoordinate2DDouble.mLat;
                d5 = d7;
                d3 = d6;
            } else {
                if (xPCoordinate2DDouble.mLon < d3) {
                    d3 = xPCoordinate2DDouble.mLon;
                }
                if (xPCoordinate2DDouble.mLon > d2) {
                    d2 = xPCoordinate2DDouble.mLon;
                }
                if (xPCoordinate2DDouble.mLat < d5) {
                    d5 = xPCoordinate2DDouble.mLat;
                }
                if (xPCoordinate2DDouble.mLat > d4) {
                    d4 = xPCoordinate2DDouble.mLat;
                }
            }
            i++;
            d = INVALID_LONLAT;
        }
        if (L.ENABLE) {
            L.d(TAG, "current:" + currentLocation.mLon + "," + currentLocation.mLat);
        }
        return currentLocation.mLon < d2 && currentLocation.mLon > d3 && currentLocation.mLat < d4 && currentLocation.mLat > d5;
    }

    private boolean isRoadNameMatched(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String str2 = "";
            if (TBTManager.getInstance().getCurrentStatus() == 0) {
                XPCruiseInfo xPCruiseInfo = TBTManager.getInstance().getXPCruiseInfo();
                if (xPCruiseInfo != null) {
                    str2 = xPCruiseInfo.mRoadName;
                }
            } else {
                XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
                if (naviInfo != null) {
                    str2 = naviInfo.mCurRouteName;
                }
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "currentRoadName:" + str2 + ", name:" + str);
            }
            return str2.equalsIgnoreCase(str);
        } catch (Exception e) {
            L.Tag tag2 = TAG;
            L.d(tag2, "exception=" + e);
            return false;
        }
    }

    private boolean isDirectionMatched(float f) {
        LocInfo currentLocInfo = TBTManager.getInstance().getCurrentLocInfo();
        if (currentLocInfo != null) {
            try {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "roadDir:" + f + ", matchInfo.roadCourse:" + currentLocInfo.matchInfo.get(0).roadCourse);
                }
                return Math.abs(((float) ((int) currentLocInfo.matchInfo.get(0).roadCourse)) - f) <= 30.0f;
            } catch (Exception unused) {
                L.w(TAG, "get direction error");
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
        if (7 != r0.matchInfo.get(0).formway) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:4:0x000b, B:6:0x000f, B:9:0x0058, B:11:0x0064, B:24:0x0092, B:28:0x00a1, B:15:0x0073, B:17:0x007f), top: B:39:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isRoadTypeMatched(int r7, int r8) {
        /*
            r6 = this;
            com.xiaopeng.montecarlo.navcore.xptbt.TBTManager r0 = com.xiaopeng.montecarlo.navcore.xptbt.TBTManager.getInstance()
            com.autonavi.gbl.pos.model.LocInfo r0 = r0.getCurrentLocInfo()
            r1 = 0
            if (r0 == 0) goto Lbe
            boolean r2 = com.xiaopeng.montecarlo.root.util.L.ENABLE     // Catch: java.lang.Exception -> Lb7
            if (r2 == 0) goto L52
            com.xiaopeng.montecarlo.root.util.L$Tag r2 = com.xiaopeng.montecarlo.scenes.mapscene.LccGeoFenceHelper.TAG     // Catch: java.lang.Exception -> Lb7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb7
            r3.<init>()     // Catch: java.lang.Exception -> Lb7
            java.lang.String r4 = "type1:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            r3.append(r7)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r4 = ", type2:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            r3.append(r8)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r4 = ", matchInfo.linkType:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r4 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r4 = (com.autonavi.gbl.pos.model.LocMatchInfo) r4     // Catch: java.lang.Exception -> Lb7
            int r4 = r4.linkType     // Catch: java.lang.Exception -> Lb7
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r4 = ", matchInfo.formway:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r4 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r4 = (com.autonavi.gbl.pos.model.LocMatchInfo) r4     // Catch: java.lang.Exception -> Lb7
            int r4 = r4.formway     // Catch: java.lang.Exception -> Lb7
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Lb7
            com.xiaopeng.montecarlo.root.util.L.d(r2, r3)     // Catch: java.lang.Exception -> Lb7
        L52:
            r2 = 3
            r3 = 4
            r4 = 2
            r5 = 1
            if (r5 != r7) goto L71
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r7 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r7 = (com.autonavi.gbl.pos.model.LocMatchInfo) r7     // Catch: java.lang.Exception -> Lb7
            int r7 = r7.linkType     // Catch: java.lang.Exception -> Lb7
            if (r3 == r7) goto L8e
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r7 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r7 = (com.autonavi.gbl.pos.model.LocMatchInfo) r7     // Catch: java.lang.Exception -> Lb7
            int r7 = r7.linkType     // Catch: java.lang.Exception -> Lb7
            if (r2 != r7) goto L8c
            goto L8e
        L71:
            if (r4 != r7) goto L8e
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r7 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r7 = (com.autonavi.gbl.pos.model.LocMatchInfo) r7     // Catch: java.lang.Exception -> Lb7
            int r7 = r7.linkType     // Catch: java.lang.Exception -> Lb7
            if (r3 == r7) goto L8c
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r7 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r7 = (com.autonavi.gbl.pos.model.LocMatchInfo) r7     // Catch: java.lang.Exception -> Lb7
            int r7 = r7.linkType     // Catch: java.lang.Exception -> Lb7
            if (r2 == r7) goto L8c
            goto L8e
        L8c:
            r7 = r1
            goto L8f
        L8e:
            r7 = r5
        L8f:
            r2 = 7
            if (r5 != r8) goto L9f
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r8 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r8 = r8.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r8 = (com.autonavi.gbl.pos.model.LocMatchInfo) r8     // Catch: java.lang.Exception -> Lb7
            int r8 = r8.formway     // Catch: java.lang.Exception -> Lb7
            if (r2 == r8) goto Lae
            goto Lb0
        L9f:
            if (r4 != r8) goto Lb0
            java.util.ArrayList<com.autonavi.gbl.pos.model.LocMatchInfo> r8 = r0.matchInfo     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r8 = r8.get(r1)     // Catch: java.lang.Exception -> Lb7
            com.autonavi.gbl.pos.model.LocMatchInfo r8 = (com.autonavi.gbl.pos.model.LocMatchInfo) r8     // Catch: java.lang.Exception -> Lb7
            int r8 = r8.formway     // Catch: java.lang.Exception -> Lb7
            if (r2 != r8) goto Lae
            goto Lb0
        Lae:
            r8 = r1
            goto Lb1
        Lb0:
            r8 = r5
        Lb1:
            if (r7 == 0) goto Lb6
            if (r8 == 0) goto Lb6
            r1 = r5
        Lb6:
            return r1
        Lb7:
            com.xiaopeng.montecarlo.root.util.L$Tag r7 = com.xiaopeng.montecarlo.scenes.mapscene.LccGeoFenceHelper.TAG
            java.lang.String r8 = "get roadType error"
            com.xiaopeng.montecarlo.root.util.L.w(r7, r8)
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.LccGeoFenceHelper.isRoadTypeMatched(int, int):boolean");
    }

    private void setNaviDangerAreaRDInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        CarServiceManager.getInstance().setNaviDangerAreaRDInfo(i, i2, i3, i4, i5, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class GeoFenceHelperHandler extends Handler {
        GeoFenceHelperHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 1) {
                LccGeoFenceHelper.this.handlerQueryDb();
            } else if (i != 2) {
            } else {
                LccGeoFenceHelper.this.handlerQueryCache();
            }
        }
    }
}
