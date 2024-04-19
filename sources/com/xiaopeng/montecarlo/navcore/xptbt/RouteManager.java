package com.xiaopeng.montecarlo.navcore.xptbt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.route.model.PathResultData;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPSearchRoadId;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRestoreRouteData;
import com.xiaopeng.montecarlo.root.carservice.XpSRCarService;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.IdGenerator;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class RouteManager {
    private static final int MSG_CANCEL_ROUTE = 1003;
    private static final int MSG_REQUEST_NEXT_ROUTE = 1002;
    private static final int MSG_REQUEST_REROUTE = 1001;
    private static final int MSG_REQUEST_ROUTE = 1000;
    private static final int MSG_SEND_NEW_ROUTE_ERROR = 4000;
    private static final int MSG_SEND_NEW_ROUTE_ERROR_CALL_FAIL = 4002;
    private static final int MSG_SEND_NEW_ROUTE_ERROR_ONLINE_TO_OFFLINE = 4003;
    private static final int MSG_SEND_NEW_ROUTE_ERROR_USER_CANCEL = 4001;
    private static final int MSG_SEND_NEW_ROUTE_ODD_ERROR = 4005;
    private static final int MSG_SEND_NEW_ROUTE_ODD_SUCCESS = 4006;
    private static final int MSG_SEND_NEW_ROUTE_SUCCESS = 4004;
    private static final int MSG_SET_ETA_RESTRICTION = 1005;
    private static final int MSG_SET_VEHICLE = 1004;
    private static final double REQUEST_ROUTE_MIN_DIS = 5.0d;
    public static final int REQUEST_STATE_CANCELING = 2;
    public static final int REQUEST_STATE_NORMAL = 0;
    public static final int REQUEST_STATE_ROUTING = 1;
    private static final L.Tag TAG = new L.Tag("RouteManager");
    private final Handler mListenerHandler = new Handler(WorkThreadUtil.getInstance().getNavThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            L.Tag tag = RouteManager.TAG;
            L.i(tag, ">>> mListenerHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 4000:
                case 4001:
                case 4002:
                case 4003:
                    long longValue = ((Long) message.obj).longValue();
                    RouteDataModel routeDataModel = (RouteDataModel) RouteManager.this.mRouteDataMap.get(Long.valueOf(longValue));
                    if (routeDataModel != null) {
                        RouteManager.this.sendRouteError(longValue, routeDataModel.mRouteResult);
                        return;
                    }
                    return;
                case 4004:
                    long longValue2 = ((Long) message.obj).longValue();
                    RouteDataModel routeDataModel2 = (RouteDataModel) RouteManager.this.mRouteDataMap.get(Long.valueOf(longValue2));
                    if (routeDataModel2 != null) {
                        RouteManager.this.sendRouteSuccess(longValue2, routeDataModel2.mRouteResult);
                        return;
                    }
                    return;
                case 4005:
                    RouteManager.this.sendRouteOddError(((Long) message.obj).longValue());
                    return;
                case 4006:
                    long longValue3 = ((Long) message.obj).longValue();
                    RouteDataModel routeDataModel3 = (RouteDataModel) RouteManager.this.mRouteDataMap.get(Long.valueOf(longValue3));
                    if (routeDataModel3 != null) {
                        RouteManager.this.sendRouteOddSuccess(longValue3, routeDataModel3.mRouteResult);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final Handler mRequestHandler = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            L.Tag tag = RouteManager.TAG;
            L.i(tag, ">>> mRequestHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 1000:
                    RouteManager.this.requestRoute(((Long) message.obj).longValue(), false);
                    return;
                case 1001:
                    RouteManager.this.requestReroute(((Long) message.obj).longValue(), false);
                    return;
                case 1002:
                    RouteManager.this.requestNextRoute();
                    return;
                case 1003:
                    RouteManager.this.cancelRoute(((Long) message.obj).longValue());
                    return;
                case 1004:
                    RouteManager.this.mRouteServiceWrapper.setVehicleId((String) message.obj);
                    return;
                case 1005:
                    RouteManager.this.mRouteServiceWrapper.setETARestriction(((Boolean) message.obj).booleanValue());
                    return;
                default:
                    return;
            }
        }
    };
    private final RouteServiceWrapper mRouteServiceWrapper = new RouteServiceWrapper(this);
    private final Map<Long, RouteDataModel> mRouteDataMap = new LinkedHashMap();
    private final Map<Long, RouteDataModel> mRouteDataReferenceMap = new LinkedHashMap();
    private final Map<Long, Long> mRouteRequestIdMap = new LinkedHashMap();
    private final CopyOnWriteArrayList<Long> mRequestList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<IRouteResultListener> mRouteListeners = new CopyOnWriteArrayList<>();
    private final Map<Long, IRouteResultListener> mRequestListenerMap = new HashMap();
    private volatile long mCurrentRequestId = -1;
    private volatile long mPrivRequestId = -1;
    private volatile int mCurrentRequestState = 0;
    private IdGenerator mIdGenerator = new IdGenerator();
    private IRequestLevelStrategy mRequestLevelStrategy = new RequestLevelStrategy();

    /* loaded from: classes3.dex */
    public interface IRestoreListener {
        void onRestoreResult(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface IRouteResultListener {
        void onNewRouteError(long j, RouteResult routeResult);

        default void onNewRouteOddError(long j) {
        }

        default void onNewRouteOddSuccess(long j, RouteResult routeResult) {
        }

        void onNewRouteSuccess(long j, RouteResult routeResult);
    }

    public synchronized void addRouteListener(IRouteResultListener iRouteResultListener) {
        if (!this.mRouteListeners.contains(iRouteResultListener)) {
            this.mRouteListeners.add(iRouteResultListener);
        }
    }

    public synchronized void removeRouteListener(IRouteResultListener iRouteResultListener) {
        this.mRouteListeners.remove(iRouteResultListener);
    }

    public void setRequestLevelStrategy(IRequestLevelStrategy iRequestLevelStrategy) {
        this.mRequestLevelStrategy = iRequestLevelStrategy;
    }

    public void restoreNavi(final int i, final boolean z, final IRestoreListener iRestoreListener) {
        L.Tag tag = TAG;
        L.i(tag, "RestoreFromByteData >>> requestRestoreNavi time = " + i + " ，isInApplication = " + z);
        final RouteParams restoreRouteParams = TBTManager.getInstance().getRestoreRouteParams();
        if (restoreRouteParams == null || restoreRouteParams.mRestoreRouteData == null || restoreRouteParams.mRestoreRouteData.isClear()) {
            L.i(TAG, "RestoreFromByteData >>> requestRestoreNavi params == null or params.mRestoreRouteData == null");
            iRestoreListener.onRestoreResult(false);
            return;
        }
        final long generateRequestId = generateRequestId();
        addNewRequestData(generateRequestId, restoreRouteParams);
        RouteDataModel routeData = getRouteData(generateRequestId);
        if (routeData == null) {
            L.i(TAG, "RestoreFromByteData >>> requestRestoreNavi routeDataModel == null ");
            iRestoreListener.onRestoreResult(false);
            return;
        }
        TBTManager.getInstance().getPosServiceWrapper().setContextPos();
        XPPathResult pathResult = restoreRouteParams.mRestoreRouteData.getPathResult();
        if (pathResult == null) {
            L.i(TAG, "RestoreFromByteData >>> requestRestoreNavi pathResult == null ");
            iRestoreListener.onRestoreResult(false);
            return;
        }
        final int pathIndex = restoreRouteParams.mRestoreRouteData.getPathIndex(pathResult);
        if (pathIndex == -1) {
            L.i(TAG, "RestoreFromByteData >>> requestRestoreNavi index == -1 ");
            pathResult.recycle();
            iRestoreListener.onRestoreResult(false);
            return;
        }
        RouteResult parsePath = parsePath(pathResult, restoreRouteParams.mHaveOddInfo);
        PathResultData mainPathResultData = restoreRouteParams.mRestoreRouteData.getMainPathResultData();
        if (mainPathResultData == null) {
            L.i(TAG, "RestoreFromByteData >>> requestRestoreNavi pathResultData == null ");
            pathResult.recycle();
            iRestoreListener.onRestoreResult(false);
        } else if (mainPathResultData.isLocal) {
            L.i(TAG, "RestoreFromByteData >>> pathResultData.isLocal ");
            pathResult.recycle();
            iRestoreListener.onRestoreResult(false);
        } else {
            parsePath.mRouteMode = mainPathResultData.mode;
            parsePath.mRouteType = mainPathResultData.type;
            parsePath.mIsLocal = false;
            routeData.mRouteResult = parsePath;
            restoreRouteParams.mRestoring = true;
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$RouteManager$rKwsnxQjaNpg_TZGbNlwoAYXgcQ
                @Override // java.lang.Runnable
                public final void run() {
                    RouteManager.lambda$restoreNavi$0(z, generateRequestId, pathIndex, i, restoreRouteParams, iRestoreListener);
                }
            });
            L.Tag tag2 = TAG;
            L.i(tag2, "RestoreFromByteData >>> requestId=" + generateRequestId + " params=" + restoreRouteParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$restoreNavi$0(boolean z, long j, int i, int i2, RouteParams routeParams, IRestoreListener iRestoreListener) {
        if (z && !SrCarServiceManager.getInstance().isInitialized()) {
            SrCarServiceManager.getInstance().init(new XpSRCarService());
        }
        TBTManager.getInstance().setEhpConfigValue(false);
        TBTManager.getInstance().startNavi(j, i, i2, TBTUtil.getRestoreStatus(), true);
        StateManager.getInstance().switchImmersionState();
        routeParams.mRestoring = false;
        L.Tag tag = TAG;
        L.i(tag, "RestoreFromByteData >>> requestRestoreNavi requestId=" + j + " params=" + routeParams);
        iRestoreListener.onRestoreResult(true);
    }

    public long requestRoute(RouteParams routeParams, IRouteResultListener iRouteResultListener) {
        long generateRequestId = generateRequestId();
        if (iRouteResultListener != null) {
            addCurrentCallback(generateRequestId, iRouteResultListener);
        }
        addNewRequestData(generateRequestId, routeParams);
        Handler handler = this.mRequestHandler;
        handler.sendMessage(handler.obtainMessage(1000, Long.valueOf(generateRequestId)));
        L.Tag tag = TAG;
        L.i(tag, ">>> requestRoute requestId=" + generateRequestId + " params=" + routeParams);
        return generateRequestId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long requestReroute(RouteParams routeParams, IRouteResultListener iRouteResultListener) {
        long generateRequestId = generateRequestId();
        if (iRouteResultListener != null) {
            addCurrentCallback(generateRequestId, iRouteResultListener);
        }
        addNewRequestData(generateRequestId, routeParams);
        Handler handler = this.mRequestHandler;
        handler.sendMessage(handler.obtainMessage(1001, Long.valueOf(generateRequestId)));
        L.Tag tag = TAG;
        L.i(tag, ">>> requestReroute requestId=" + generateRequestId);
        return generateRequestId;
    }

    public void abortRoute(long j) {
        L.Tag tag = TAG;
        L.i(tag, ">>> abortRoute requestId=" + j);
        Handler handler = this.mRequestHandler;
        handler.sendMessage(handler.obtainMessage(1003, Long.valueOf(j)));
    }

    public void setVehicleId(String str) {
        Handler handler = this.mRequestHandler;
        handler.sendMessage(handler.obtainMessage(1004, str));
    }

    public void setETARestriction(boolean z) {
        Handler handler = this.mRequestHandler;
        handler.sendMessage(handler.obtainMessage(1005, Boolean.valueOf(z)));
    }

    public synchronized void clearRouteData(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel != null) {
            if (routeDataModel.mRouteResult != null && routeDataModel.mRouteResult.mPathResult != null && !routeDataModel.mRouteResult.mPathResult.recycle()) {
                this.mRouteDataReferenceMap.put(Long.valueOf(j), routeDataModel);
            }
            if (routeDataModel.mRouteParams != null && routeDataModel.mRouteParams.mRerouteOption != null) {
                L.Tag tag = TAG;
                L.i(tag, ">>> clearRouteData requestId=" + j + "  rerouteOption recycle");
                RouteOption.destroy(routeDataModel.mRouteParams.mRerouteOption);
                routeDataModel.mRouteParams.mRerouteOption = null;
            }
            this.mRouteDataMap.remove(Long.valueOf(j));
            this.mRequestList.remove(Long.valueOf(j));
            this.mRouteRequestIdMap.remove(Long.valueOf(j));
        }
        L.Tag tag2 = TAG;
        L.i(tag2, ">>> clearRouteData requestId=" + j + "  routeDataMap Size:" + this.mRouteDataMap.size());
    }

    public synchronized void clearAllRouteData() {
        if (this.mRouteDataMap.size() > 0) {
            for (Long l : this.mRouteDataMap.keySet()) {
                long longValue = l.longValue();
                RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(longValue));
                if (routeDataModel != null) {
                    if (routeDataModel.mRouteResult != null && routeDataModel.mRouteResult.mPathResult != null && !routeDataModel.mRouteResult.mPathResult.recycle()) {
                        this.mRouteDataReferenceMap.put(Long.valueOf(longValue), routeDataModel);
                    }
                    if (routeDataModel.mRouteParams != null && routeDataModel.mRouteParams.mRerouteOption != null) {
                        RouteOption.destroy(routeDataModel.mRouteParams.mRerouteOption);
                        routeDataModel.mRouteParams.mRerouteOption = null;
                    }
                }
            }
            this.mRouteDataMap.clear();
            this.mRequestList.clear();
            this.mRouteRequestIdMap.clear();
        }
    }

    public synchronized void clearAllRemoveRouteData() {
        if (this.mRouteDataReferenceMap.size() > 0) {
            L.Tag tag = TAG;
            L.i(tag, ">>> clearAllRemoveRouteData map size = " + this.mRouteDataReferenceMap.size());
            Iterator<Long> it = this.mRouteDataReferenceMap.keySet().iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                RouteDataModel routeDataModel = this.mRouteDataReferenceMap.get(Long.valueOf(longValue));
                if (routeDataModel != null && routeDataModel.mRouteResult != null && routeDataModel.mRouteResult.mPathResult != null) {
                    boolean recycle = routeDataModel.mRouteResult.mPathResult.recycle();
                    if (L.ENABLE) {
                        L.Tag tag2 = TAG;
                        L.d(tag2, ">>> clearAllRemoveRouteData map key = " + longValue + ", mPathResult:" + routeDataModel.mRouteResult.mPathResult + ", recycle result = " + recycle);
                    }
                    if (recycle) {
                        it.remove();
                        this.mRouteDataReferenceMap.remove(Long.valueOf(longValue));
                    }
                }
            }
        }
    }

    public RouteDataModel getRouteData(long j) {
        return this.mRouteDataMap.get(Long.valueOf(j));
    }

    public RouteResult getRouteResult(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel != null) {
            return routeDataModel.mRouteResult;
        }
        return null;
    }

    public IVariantPath getVariantPath(long j, int i) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteResult == null || routeDataModel.mRouteResult.mPathResult == null) {
            return null;
        }
        return routeDataModel.mRouteResult.mPathResult.getPath(i);
    }

    public int getSegmentLength(IVariantPath iVariantPath, long j) {
        return this.mRouteServiceWrapper.getSegmentLength(iVariantPath, j);
    }

    public int getSegmentFormway(IVariantPath iVariantPath, long j, long j2) {
        return this.mRouteServiceWrapper.getSegmentFormway(iVariantPath, j, j2);
    }

    public List<XPCoordinate2DDouble> getCurrentRoutePoints() {
        return this.mRouteServiceWrapper.getCurrentRoutePoints();
    }

    public List<XPCoordinate2DDouble> getCurrentRouteAllPoints() {
        return this.mRouteServiceWrapper.getCurrentRouteAllPoints();
    }

    public XPSearchRoadId[] getCurrentRoadIds() {
        return this.mRouteServiceWrapper.getCurrentRoadIds();
    }

    public RouteResult.RouteInfo getRouteResultInfo(long j, long j2) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteResult == null) {
            return null;
        }
        int size = routeDataModel.mRouteResult.mRouteInfos.size();
        for (int i = 0; i < size; i++) {
            RouteResult.RouteInfo routeInfo = routeDataModel.mRouteResult.mRouteInfos.get(i);
            if (routeInfo != null && routeInfo.mPathId == j2) {
                return routeInfo;
            }
        }
        return null;
    }

    public List<XPOddInfo> getRouteOddInfos(long j, int i) {
        RouteResult.RouteInfo routeInfo;
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteResult == null || i >= routeDataModel.mRouteResult.mRouteInfos.size() || (routeInfo = routeDataModel.mRouteResult.mRouteInfos.get(i)) == null) {
            return null;
        }
        return routeInfo.mOddInfos;
    }

    public int getRouteType(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteResult == null) {
            return 1;
        }
        return routeDataModel.mRouteResult.mRouteType;
    }

    public IPathResult getRoutePathResult(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteResult == null) {
            return null;
        }
        return routeDataModel.mRouteResult.mPathResult;
    }

    public List<XPViaPoint> getUnPassedViasPoiInfos(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteParams == null) {
            return null;
        }
        RouteParams routeParams = routeDataModel.mRouteParams;
        if (CollectionUtils.isNotEmpty(routeParams.mViaInfos)) {
            ArrayList arrayList = new ArrayList();
            for (XPViaPoint xPViaPoint : routeParams.mViaInfos) {
                if (!xPViaPoint.getIsPassedVia()) {
                    arrayList.add(xPViaPoint);
                }
            }
            return arrayList;
        }
        return null;
    }

    public List<XPViaPoint> getPassedViasPoiInfos(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteParams == null) {
            return null;
        }
        RouteParams routeParams = routeDataModel.mRouteParams;
        if (CollectionUtils.isNotEmpty(routeParams.mViaInfos)) {
            ArrayList arrayList = new ArrayList();
            for (XPViaPoint xPViaPoint : routeParams.mViaInfos) {
                if (xPViaPoint.getIsPassedVia()) {
                    arrayList.add(xPViaPoint);
                }
            }
            return arrayList;
        }
        return null;
    }

    public synchronized void updateViaPass(long j, int i) {
        XPViaPoint xPViaPoint;
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel != null && routeDataModel.mRouteParams != null) {
            RouteParams routeParams = routeDataModel.mRouteParams;
            if (routeParams.mViaInfos != null && (xPViaPoint = routeParams.mViaInfos.get(i)) != null) {
                xPViaPoint.setIsPassedVia(true);
            }
        }
    }

    public XPPoiInfo getStartInfo(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteParams == null) {
            return null;
        }
        return routeDataModel.mRouteParams.mStartInfo;
    }

    public XPPoiInfo getEndInfo(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteParams == null) {
            return null;
        }
        return routeDataModel.mRouteParams.mEndInfo;
    }

    public List<XPViaPoint> getViaInfos(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel == null || routeDataModel.mRouteParams == null) {
            return null;
        }
        return routeDataModel.mRouteParams.mViaInfos;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble getRouteLastPoint(long r3, int r5) {
        /*
            r2 = this;
            java.util.Map<java.lang.Long, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel> r0 = r2.mRouteDataMap
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r3 = r0.get(r3)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel r3 = (com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel) r3
            if (r3 == 0) goto L2d
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r4 = r3.mRouteResult
            if (r4 == 0) goto L2d
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r4 = r3.mRouteResult
            java.util.List<com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult$RouteInfo> r4 = r4.mRouteInfos
            int r4 = r4.size()
            if (r5 < 0) goto L2d
            if (r5 >= r4) goto L2d
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r4 = r3.mRouteResult
            java.util.List<com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult$RouteInfo> r4 = r4.mRouteInfos
            java.lang.Object r4 = r4.get(r5)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult$RouteInfo r4 = (com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult.RouteInfo) r4
            if (r4 == 0) goto L2d
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r4 = r4.mLastPoint
            goto L2e
        L2d:
            r4 = 0
        L2e:
            if (r4 != 0) goto L5d
            if (r3 == 0) goto L5d
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r5 = r3.mRouteParams
            if (r5 == 0) goto L5d
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r3 = r3.mRouteParams
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r3 = r3.mEndInfo
            if (r3 == 0) goto L5d
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r4 = new com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble
            r4.<init>()
            r5 = 0
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r5 = r3.getNaviPoint(r5)
            if (r5 == 0) goto L51
            double r0 = r5.mLat
            r4.mLat = r0
            double r0 = r5.mLon
            r4.mLon = r0
            goto L5d
        L51:
            double r0 = r3.getDisplayLat()
            r4.mLat = r0
            double r0 = r3.getDisplayLon()
            r4.mLon = r0
        L5d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.getRouteLastPoint(long, int):com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble");
    }

    public int getRouteState() {
        return this.mCurrentRequestState;
    }

    public boolean isRouting(long j) {
        return -1 != j && (j == this.mCurrentRequestId || this.mRequestList.contains(Long.valueOf(j)));
    }

    public RouteParams getRouteParams(long j) {
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel != null) {
            return routeDataModel.mRouteParams;
        }
        return null;
    }

    public boolean initRouteService() {
        return this.mRouteServiceWrapper.initRouteService();
    }

    protected void onOddData() {
        L.Tag tag = TAG;
        L.i(tag, "onOddData mCurrentRequestId=" + this.mCurrentRequestId);
        if (-1 == this.mCurrentRequestId) {
            RouteDataModel routeData = getRouteData(this.mPrivRequestId);
            if (routeData == null || routeData.mRouteParams == null) {
                return;
            }
            routeData.mRouteParams.mHaveOddInfo = true;
            this.mRouteServiceWrapper.parsePathOdd(routeData.mRouteResult);
            Handler handler = this.mListenerHandler;
            handler.sendMessage(handler.obtainMessage(4006, Long.valueOf(this.mPrivRequestId)));
            return;
        }
        RouteDataModel routeData2 = getRouteData(this.mCurrentRequestId);
        if (routeData2 == null || routeData2.mRouteParams == null) {
            return;
        }
        routeData2.mRouteParams.mHaveOddInfo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onOddDataError() {
        L.i(TAG, "onOddDataError");
        Handler handler = this.mListenerHandler;
        handler.sendMessage(handler.obtainMessage(4005, Long.valueOf(this.mPrivRequestId)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewRoute(PathResultData pathResultData, @NonNull IPathResult iPathResult, RouteLimitInfo routeLimitInfo) {
        L.Tag tag = TAG;
        L.i(tag, ">>> onNewRoute requestId=" + this.mCurrentRequestId);
        clearAllRemoveRouteData();
        long j = this.mCurrentRequestId;
        this.mPrivRequestId = this.mCurrentRequestId;
        this.mCurrentRequestId = -1L;
        RouteDataModel routeData = getRouteData(j);
        if (routeData != null && routeData.mRouteParams != null && pathResultData != null) {
            L.Tag tag2 = TAG;
            L.i(tag2, ">>> onNewRoute type=" + pathResultData.type + " isLocal=" + pathResultData.isLocal);
            if (2 == this.mCurrentRequestState) {
                RouteResult routeResult = new RouteResult();
                routeResult.mErrorCode = 15;
                routeResult.mRouteType = pathResultData.type;
                routeData.mRouteResult = routeResult;
                Handler handler = this.mListenerHandler;
                handler.sendMessage(handler.obtainMessage(4001, Long.valueOf(j)));
                removeRequestList(j);
                iPathResult.recycle();
            } else {
                RouteResult parsePath = parsePath(iPathResult, routeData.mRouteParams.mHaveOddInfo);
                parsePath.mRouteMode = pathResultData.mode;
                parsePath.mRouteType = pathResultData.type;
                parsePath.mExternData = routeLimitInfo;
                parsePath.mIsLocal = pathResultData.isLocal;
                routeData.mRouteResult = parsePath;
                L.Tag tag3 = TAG;
                L.i(tag3, "RestoreFromByteData >>> onNewRoute RouteType = " + pathResultData.type);
                if (routeData.mRouteParams.mRestoreRouteData == null) {
                    L.i(TAG, "RestoreFromByteData >>> onNewRoute mRestoreRouteData == null");
                    routeData.mRouteParams.mRestoreRouteData = new XPRestoreRouteData();
                }
                routeData.mRouteParams.mRestoreRouteData.addPathResultData(pathResultData);
                Handler handler2 = this.mListenerHandler;
                handler2.sendMessage(handler2.obtainMessage(4004, Long.valueOf(j)));
                removeRequestList(j);
                if (routeData.mRouteParams.mRoutePriority == 2 && NavCoreUtil.isNormalCalcRoute(pathResultData.type)) {
                    saveHistoryDestination(routeData.mRouteParams);
                }
                if (routeData.mRouteParams.mHaveOddInfo) {
                    Handler handler3 = this.mListenerHandler;
                    handler3.sendMessage(handler3.obtainMessage(4006, Long.valueOf(j)));
                }
            }
        } else {
            L.w(TAG, ">>> onNewRoute but requestId was not in data map, ignore!!!");
            iPathResult.recycle();
        }
        this.mCurrentRequestState = 0;
        Handler handler4 = this.mRequestHandler;
        handler4.sendMessageDelayed(handler4.obtainMessage(1002), 100L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewRouteError(int i, int i2, int i3, RouteLimitInfo routeLimitInfo, boolean z, boolean z2) {
        L.Tag tag = TAG;
        L.i(tag, ">>> onNewRouteError requestId=" + this.mCurrentRequestId + " type=" + i2 + " errorCode=" + i3 + " isLocal=" + z);
        long j = this.mCurrentRequestId;
        this.mPrivRequestId = this.mCurrentRequestId;
        this.mCurrentRequestId = -1L;
        RouteDataModel routeData = getRouteData(j);
        if (routeData != null) {
            if (2 == this.mCurrentRequestState) {
                RouteResult routeResult = new RouteResult();
                routeResult.mErrorCode = 15;
                routeResult.mRouteMode = i;
                routeResult.mRouteType = i2;
                routeResult.mExternData = routeLimitInfo;
                routeResult.mIsLocal = z;
                routeResult.mIsChange = z2;
                routeData.mRouteResult = routeResult;
                Handler handler = this.mListenerHandler;
                handler.sendMessage(handler.obtainMessage(4001, Long.valueOf(j)));
                removeRequestList(j);
            } else {
                RouteResult routeResult2 = new RouteResult();
                routeResult2.mRouteMode = i;
                routeResult2.mRouteType = i2;
                routeResult2.mErrorCode = i3;
                routeResult2.mExternData = routeLimitInfo;
                routeResult2.mIsLocal = z;
                routeResult2.mIsChange = z2;
                routeData.mRouteResult = routeResult2;
                if (NavCoreUtil.isNeedOfflineReroute(i3, z, z2, i2, routeData.mRouteParams.mNetworkProperty)) {
                    routeResult2.mErrorCode = 37;
                    Handler handler2 = this.mListenerHandler;
                    handler2.sendMessage(handler2.obtainMessage(4003, Long.valueOf(j)));
                    routeData.mRouteParams.mNetworkProperty = 0;
                    updateRequestList(j, true);
                    RootUtil.testPing();
                    int bLNetworkStatus = CommonUtil.getBLNetworkStatus(XPNetworkManager.INSTANCE.getNetworkType(), XPNetworkManager.INSTANCE.isNetworkConnected());
                    L.Tag tag2 = TAG;
                    L.i(tag2, "Do updateBLNetworkStatus:" + bLNetworkStatus);
                    if (1 != bLNetworkStatus) {
                        TBTManager.getInstance().updateNetworkStatus(bLNetworkStatus);
                    }
                } else {
                    Handler handler3 = this.mListenerHandler;
                    handler3.sendMessage(handler3.obtainMessage(4000, Long.valueOf(j)));
                    removeRequestList(j);
                }
            }
        } else {
            L.i(TAG, ">>> onNewRouteError but requestId was not in data map, ignore!!!");
        }
        this.mCurrentRequestState = 0;
        Handler handler4 = this.mRequestHandler;
        handler4.sendMessageDelayed(handler4.obtainMessage(1002), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRoute(long j) {
        Long l = this.mRouteRequestIdMap.get(Long.valueOf(j));
        L.Tag tag = TAG;
        L.i(tag, ">>> cancelRoute requestId=" + j + " mCurrentRequestId=" + this.mCurrentRequestId + ",realRequestId:" + l);
        if (j == this.mCurrentRequestId && this.mCurrentRequestId != -1 && l != null && l.longValue() > 0) {
            this.mCurrentRequestState = 2;
            this.mRouteServiceWrapper.cancelRoute(l.longValue());
            return;
        }
        RouteDataModel routeData = getRouteData(j);
        if (routeData != null) {
            RouteResult routeResult = new RouteResult();
            routeResult.mErrorCode = 15;
            routeData.mRouteResult = routeResult;
            Handler handler = this.mListenerHandler;
            handler.sendMessage(handler.obtainMessage(4001, Long.valueOf(j)));
            removeRequestList(j);
            return;
        }
        L.i(TAG, ">>> cancelRoute but requestId was not in data map, ignore!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestNextRoute() {
        long longValue = this.mRequestList.size() > 0 ? this.mRequestList.get(0).longValue() : -1L;
        if (-1 != longValue) {
            RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(longValue));
            RouteParams routeParams = routeDataModel != null ? routeDataModel.mRouteParams : null;
            if (routeParams != null) {
                L.Tag tag = TAG;
                L.i(tag, ">>> requestNextRoute nextRequestId=" + longValue + " params.mRerouteType=" + routeParams.mRerouteType);
                if (1 == routeParams.mRerouteType) {
                    requestRoute(longValue, true);
                    return;
                } else {
                    requestReroute(longValue, true);
                    return;
                }
            }
            L.Tag tag2 = TAG;
            L.i(tag2, ">>> requestNextRoute nextRequestId=" + longValue + " can not find, continue request next");
            removeRequestList(longValue);
            requestNextRoute();
            return;
        }
        L.i(TAG, ">>> requestNextRoute but request list have not content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestRoute(long r9, boolean r11) {
        /*
            r8 = this;
            int r0 = r8.mCurrentRequestState
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lb
            r8.requestWhenRouting(r9)
        L9:
            r11 = r2
            goto L1a
        Lb:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.Long> r0 = r8.mRequestList
            int r0 = r0.size()
            if (r0 <= 0) goto L19
            if (r11 != 0) goto L19
            r8.updateRequestList(r9, r2)
            goto L9
        L19:
            r11 = r1
        L1a:
            if (r11 == 0) goto Lb6
            r8.mCurrentRequestId = r9
            r8.mCurrentRequestState = r1
            java.util.Map<java.lang.Long, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel> r11 = r8.mRouteDataMap
            java.lang.Long r0 = java.lang.Long.valueOf(r9)
            java.lang.Object r11 = r11.get(r0)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel r11 = (com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel) r11
            r0 = -1
            r3 = 1002(0x3ea, float:1.404E-42)
            r4 = 0
            if (r11 == 0) goto L77
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r6 = r11.mRouteParams
            boolean r6 = r8.canRequestRoute(r6)
            if (r6 == 0) goto L45
            com.xiaopeng.montecarlo.navcore.xptbt.RouteServiceWrapper r6 = r8.mRouteServiceWrapper
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r7 = r11.mRouteParams
            long r6 = r6.requestRoute(r7)
            goto L78
        L45:
            com.xiaopeng.montecarlo.root.util.L$Tag r4 = com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.TAG
            java.lang.String r5 = "requestRoute but distance was too short"
            com.xiaopeng.montecarlo.root.util.L.i(r4, r5)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r4 = new com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult
            r4.<init>()
            r5 = 38
            r4.mErrorCode = r5
            r11.mRouteResult = r4
            android.os.Handler r11 = r8.mListenerHandler
            r4 = 4000(0xfa0, float:5.605E-42)
            java.lang.Long r5 = java.lang.Long.valueOf(r9)
            android.os.Message r4 = r11.obtainMessage(r4, r5)
            r11.sendMessage(r4)
            r8.removeRequestList(r9)
            android.os.Handler r9 = r8.mRequestHandler
            android.os.Message r10 = r9.obtainMessage(r3)
            r9.sendMessage(r10)
            r8.mCurrentRequestId = r0
            r8.mCurrentRequestState = r2
            return
        L77:
            r6 = r4
        L78:
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 != 0) goto La9
            if (r11 == 0) goto L9b
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r4 = new com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult
            r4.<init>()
            r5 = 36
            r4.mErrorCode = r5
            r11.mRouteResult = r4
            android.os.Handler r11 = r8.mListenerHandler
            r4 = 4002(0xfa2, float:5.608E-42)
            java.lang.Long r5 = java.lang.Long.valueOf(r9)
            android.os.Message r4 = r11.obtainMessage(r4, r5)
            r11.sendMessage(r4)
            r8.removeRequestList(r9)
        L9b:
            android.os.Handler r9 = r8.mRequestHandler
            android.os.Message r10 = r9.obtainMessage(r3)
            r9.sendMessage(r10)
            r8.mCurrentRequestId = r0
            r8.mCurrentRequestState = r2
            return
        La9:
            java.util.Map<java.lang.Long, java.lang.Long> r11 = r8.mRouteRequestIdMap
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            r11.put(r9, r10)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.requestRoute(long, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestReroute(long r10, boolean r12) {
        /*
            r9 = this;
            int r0 = r9.mCurrentRequestState
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lb
            r9.requestWhenRouting(r10)
        L9:
            r12 = r2
            goto L1a
        Lb:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.Long> r0 = r9.mRequestList
            int r0 = r0.size()
            if (r0 <= 0) goto L19
            if (r12 != 0) goto L19
            r9.updateRequestList(r10, r2)
            goto L9
        L19:
            r12 = r1
        L1a:
            if (r12 == 0) goto Lb4
            r9.mCurrentRequestId = r10
            r9.mCurrentRequestState = r1
            java.util.Map<java.lang.Long, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel> r12 = r9.mRouteDataMap
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            java.lang.Object r12 = r12.get(r0)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel r12 = (com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel) r12
            r0 = -1
            r3 = 1002(0x3ea, float:1.404E-42)
            r4 = 4002(0xfa2, float:5.608E-42)
            r5 = 0
            if (r12 == 0) goto L77
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r7 = r12.mRouteParams
            boolean r7 = r9.canRequestRoute(r7)
            if (r7 == 0) goto L47
            com.xiaopeng.montecarlo.navcore.xptbt.RouteServiceWrapper r7 = r9.mRouteServiceWrapper
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r8 = r12.mRouteParams
            long r7 = r7.requestReroute(r8)
            goto L78
        L47:
            com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.TAG
            java.lang.String r6 = "requestReroute but distance was too short"
            com.xiaopeng.montecarlo.root.util.L.i(r5, r6)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r5 = new com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult
            r5.<init>()
            r6 = 38
            r5.mErrorCode = r6
            r12.mRouteResult = r5
            android.os.Handler r12 = r9.mListenerHandler
            java.lang.Long r5 = java.lang.Long.valueOf(r10)
            android.os.Message r4 = r12.obtainMessage(r4, r5)
            r12.sendMessage(r4)
            r9.removeRequestList(r10)
            android.os.Handler r10 = r9.mRequestHandler
            android.os.Message r11 = r10.obtainMessage(r3)
            r10.sendMessage(r11)
            r9.mCurrentRequestId = r0
            r9.mCurrentRequestState = r2
            return
        L77:
            r7 = r5
        L78:
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 != 0) goto La7
            if (r12 == 0) goto L99
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r5 = new com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult
            r5.<init>()
            r6 = 36
            r5.mErrorCode = r6
            r12.mRouteResult = r5
            android.os.Handler r12 = r9.mListenerHandler
            java.lang.Long r5 = java.lang.Long.valueOf(r10)
            android.os.Message r4 = r12.obtainMessage(r4, r5)
            r12.sendMessage(r4)
            r9.removeRequestList(r10)
        L99:
            android.os.Handler r10 = r9.mRequestHandler
            android.os.Message r11 = r10.obtainMessage(r3)
            r10.sendMessage(r11)
            r9.mCurrentRequestId = r0
            r9.mCurrentRequestState = r2
            return
        La7:
            java.util.Map<java.lang.Long, java.lang.Long> r12 = r9.mRouteRequestIdMap
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            java.lang.Long r11 = java.lang.Long.valueOf(r7)
            r12.put(r10, r11)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.requestReroute(long, boolean):void");
    }

    private boolean canRequestRoute(RouteParams routeParams) {
        boolean z = (routeParams == null || routeParams.mStartInfo == null || routeParams.mEndInfo == null) ? false : true;
        if (LocationUtils.getDistanceByNavi(routeParams.mStartInfo, routeParams.mEndInfo) <= 5.0d) {
            return false;
        }
        return z;
    }

    private void requestWhenRouting(long j) {
        int requestPriority = this.mRequestLevelStrategy.getRequestPriority(this.mRouteDataMap, this.mCurrentRequestId, this.mCurrentRequestState, j);
        L.Tag tag = TAG;
        L.i(tag, ">>> requestWhenRouting requestState=" + requestPriority);
        if (requestPriority != 0) {
            if (1 == requestPriority) {
                cancelRoute(this.mCurrentRequestId);
                updateRequestList(j, false);
                return;
            }
            updateRequestList(j, false);
            return;
        }
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel != null) {
            RouteResult routeResult = new RouteResult();
            routeResult.mErrorCode = 36;
            routeDataModel.mRouteResult = routeResult;
            Handler handler = this.mListenerHandler;
            handler.sendMessage(handler.obtainMessage(4002, Long.valueOf(j)));
            removeRequestList(j);
        }
    }

    private synchronized void updateRequestList(long j, boolean z) {
        int size;
        RouteDataModel routeDataModel = this.mRouteDataMap.get(Long.valueOf(j));
        if (routeDataModel != null) {
            int i = 0;
            if (this.mRequestList.contains(Long.valueOf(j))) {
                L.i(TAG, ">>> updateRequestList list have =" + j + " remove first");
                this.mRequestList.remove(Long.valueOf(j));
            }
            if (!z && (size = this.mRequestList.size()) > 0) {
                RouteParams routeParams = routeDataModel.mRouteParams;
                int i2 = 1;
                for (int i3 = 1; i3 < size; i3++) {
                    RouteDataModel routeDataModel2 = this.mRouteDataMap.get(this.mRequestList.get(i3));
                    if (routeDataModel2 != null) {
                        if (routeParams.mRoutePriority <= routeDataModel2.mRouteParams.mRoutePriority) {
                            i2 = i3 + 1;
                        }
                    }
                }
                i = i2;
            }
            L.i(TAG, ">>> updateRequestList addIndex=" + i + " requestId=" + j);
            this.mRequestList.add(i, Long.valueOf(j));
        }
    }

    private synchronized void removeRequestList(long j) {
        this.mRequestList.remove(Long.valueOf(j));
    }

    private synchronized void addNewRequestData(long j, RouteParams routeParams) {
        RouteDataModel routeDataModel = new RouteDataModel();
        routeDataModel.mRouteParams = routeParams;
        routeDataModel.mRouteResult = null;
        routeDataModel.mRequestId = j;
        this.mRouteDataMap.put(Long.valueOf(j), routeDataModel);
    }

    private synchronized long generateRequestId() {
        long nextId;
        nextId = this.mIdGenerator.nextId();
        L.Tag tag = TAG;
        L.i(tag, ">>> generateRequestId : " + nextId);
        return nextId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRouteError(long j, RouteResult routeResult) {
        IRouteResultListener iRouteResultListener = this.mRequestListenerMap.get(Long.valueOf(j));
        if (iRouteResultListener != null) {
            iRouteResultListener.onNewRouteError(j, routeResult);
            if (routeResult.mErrorCode != 37) {
                removeCurrentCallback(j);
            }
        }
        Iterator<IRouteResultListener> it = this.mRouteListeners.iterator();
        while (it.hasNext()) {
            IRouteResultListener next = it.next();
            if (next != null) {
                next.onNewRouteError(j, routeResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRouteSuccess(long j, RouteResult routeResult) {
        L.Tag tag = TAG;
        L.i(tag, ">>> sendRouteSuccess for request:" + j);
        IRouteResultListener iRouteResultListener = this.mRequestListenerMap.get(Long.valueOf(j));
        if (iRouteResultListener != null) {
            iRouteResultListener.onNewRouteSuccess(j, routeResult);
            removeCurrentCallback(j);
        }
        Iterator<IRouteResultListener> it = this.mRouteListeners.iterator();
        while (it.hasNext()) {
            IRouteResultListener next = it.next();
            if (next != null) {
                next.onNewRouteSuccess(j, routeResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRouteOddError(long j) {
        Iterator<IRouteResultListener> it = this.mRouteListeners.iterator();
        while (it.hasNext()) {
            IRouteResultListener next = it.next();
            if (next != null) {
                next.onNewRouteOddError(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRouteOddSuccess(long j, RouteResult routeResult) {
        Iterator<IRouteResultListener> it = this.mRouteListeners.iterator();
        while (it.hasNext()) {
            IRouteResultListener next = it.next();
            if (next != null) {
                next.onNewRouteOddSuccess(j, routeResult);
            }
        }
    }

    private RouteResult parsePath(@NonNull IPathResult iPathResult, boolean z) {
        return this.mRouteServiceWrapper.parsePath(iPathResult, z);
    }

    private synchronized void addCurrentCallback(long j, IRouteResultListener iRouteResultListener) {
        this.mRequestListenerMap.put(Long.valueOf(j), iRouteResultListener);
    }

    private synchronized void removeCurrentCallback(long j) {
        this.mRequestListenerMap.remove(Long.valueOf(j));
    }

    private void saveHistoryDestination(RouteParams routeParams) {
        if (routeParams == null || routeParams.mEndInfo == null || ContextUtils.getContext() == null) {
            return;
        }
        if (routeParams.mEndInfo != null && !routeParams.mEndInfo.isNameAndAddressEmpty()) {
            HistoryRecordInfo historyRecordInfo = new HistoryRecordInfo(routeParams.mEndInfo, 2);
            printHistoryRecordInfo(FavoriteDataManager.getInstance().insertOrReplace(historyRecordInfo), historyRecordInfo);
        }
        if (CloudRouteDataHelper.getInstance().isCloudRouteModeOpen()) {
            List<XPViaPoint> list = routeParams.mViaInfos;
            if (CollectionUtils.isNotEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    XPViaPoint xPViaPoint = list.get(i);
                    if (xPViaPoint.getPoiPoint() != null && !xPViaPoint.getPoiPoint().isNameAndAddressEmpty()) {
                        HistoryRecordInfo historyRecordInfo2 = new HistoryRecordInfo(xPViaPoint.getPoiPoint(), 2);
                        if (!CloudRouteDataHelper.getInstance().isInvisibleVia(xPViaPoint)) {
                            printHistoryRecordInfo(FavoriteDataManager.getInstance().insertOrReplace(historyRecordInfo2), historyRecordInfo2);
                        }
                    }
                }
            }
        }
    }

    private void printHistoryRecordInfo(boolean z, HistoryRecordInfo historyRecordInfo) {
        if (historyRecordInfo.getXPPoiInfo() == null || !L.ENABLE) {
            return;
        }
        L.Tag tag = TAG;
        L.d(tag, ">>> insertOrReplace history record result=" + z + " poiInfo=" + NaviLogUtil.dumpXPPOIInfo(historyRecordInfo.getXPPoiInfo()));
    }
}
