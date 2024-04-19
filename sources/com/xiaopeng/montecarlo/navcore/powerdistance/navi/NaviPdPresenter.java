package com.xiaopeng.montecarlo.navcore.powerdistance.navi;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnlineKHolder;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisDataProvider;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisRequestParam;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisResultData;
import com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract;
import com.xiaopeng.montecarlo.navcore.powerdistance.navi.PowerDisTimerWorker;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
class NaviPdPresenter implements BaseCallBack<PowerDisRequestParam, PowerDisResultData>, INaviOnLinePdContract.Presenter, PowerDisTimerWorker.IPowerDisOnTimerListener, IXPNetworkListener {
    private static final int DISTANCE_1KM = 1000;
    private static final int LIMIT_POWER_DISTANCE = -10000;
    private static final int ROUTE_REMAIN_DISTANCE_INTERVAL = 1000;
    private static final L.Tag TAG = new L.Tag("navi_pd_helper");
    private PowerDisDataProvider mDataProvider;
    private boolean mIsGuideNavi;
    private boolean mIsNetworkConnected;
    private boolean mIsVia;
    private INaviOnLinePdContract.LogicView mLogicView;
    private IVariantPath mPath;
    protected long mPathLength;
    private IPathResult mPathResult;
    private PowerDisTimerWorker mPowerDisTimerWorker;
    private long mViaRemainDist;
    private int mLastRouteRemainDis = 0;
    private int mCurViaArrayLength = -1;
    private long mPathId = -1;
    private int mStartSegIndex = 0;
    private int mStartLinkIndex = 0;
    private int mDisToTarget = 0;
    private boolean mObtainOnlineKErrorFlag = false;
    private boolean mIsKValid = false;
    private boolean mIsRunning = false;
    private OnlineKHolder mOnlineKHolder = new OnlineKHolder();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull PowerDisResultData powerDisResultData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(PowerDisRequestParam powerDisRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(PowerDisRequestParam powerDisRequestParam) {
    }

    public NaviPdPresenter(IPathResult iPathResult, IVariantPath iVariantPath, boolean z, INaviOnLinePdContract.LogicView logicView) {
        this.mLogicView = logicView;
        this.mIsGuideNavi = z;
        this.mPath = iVariantPath;
        this.mPathResult = iPathResult;
        setPathInfo();
    }

    private boolean isPathValid() {
        IVariantPath iVariantPath = this.mPath;
        return (iVariantPath == null || this.mPathResult == null || !iVariantPath.isValid()) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract.Presenter
    public void init() {
        L.Tag tag = TAG;
        L.i(tag, "init -----mPathResult:" + this.mPathResult + ", " + this);
        XPNetworkManager.INSTANCE.addNetworkListener(this);
        this.mIsNetworkConnected = XPNetworkManager.INSTANCE.isNetworkConnected();
        initRoadInfo(null);
        this.mDataProvider = new PowerDisDataProvider();
        this.mDataProvider.setCallBack(this);
        this.mPowerDisTimerWorker = new PowerDisTimerWorker();
        this.mPowerDisTimerWorker.addPowerDisOnTimerListener(this);
        if (isPathValid()) {
            start(0L);
        }
    }

    public void start(long j) {
        if (this.mIsRunning) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "start.." + j + ", mPathResult:" + this.mPathResult + ", " + this);
        this.mIsRunning = true;
        this.mPowerDisTimerWorker.start(j);
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract.Presenter
    public void stop() {
        if (this.mIsRunning) {
            L.Tag tag = TAG;
            L.i(tag, "stop-- mPathResult:" + this.mPathResult + ", " + this);
            this.mIsRunning = false;
            this.mDataProvider.close();
            this.mPowerDisTimerWorker.stop();
            IPathResult iPathResult = this.mPathResult;
            if (iPathResult != null) {
                iPathResult.delRef();
            }
            this.mPathResult = null;
            this.mPath = null;
            this.mPathId = -1L;
            this.mLastRouteRemainDis = 0;
            this.mCurViaArrayLength = -1;
            this.mOnlineKHolder.setK(1.0d);
            this.mObtainOnlineKErrorFlag = false;
            this.mIsKValid = false;
            this.mStartSegIndex = 0;
            this.mStartLinkIndex = 0;
            this.mDisToTarget = 0;
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract.Presenter
    public void close() {
        L.Tag tag = TAG;
        L.i(tag, "close mOnlineKHolder--" + this.mOnlineKHolder.getK() + "   pathId:" + this.mPathId + ", mPathResult:" + this.mPathResult + ", " + this);
        XPNetworkManager.INSTANCE.removeNetworkListener(this);
        this.mDataProvider.close();
        this.mPowerDisTimerWorker.close();
        IPathResult iPathResult = this.mPathResult;
        if (iPathResult != null) {
            iPathResult.delRef();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract.Presenter
    public void changePath(IPathResult iPathResult, IVariantPath iVariantPath) {
        if (iVariantPath == null || iPathResult == null) {
            return;
        }
        long pathId = iVariantPath.getPathId();
        L.Tag tag = TAG;
        L.i(tag, "changePath-- new pathId:" + pathId + ", mPathResult:" + this.mPathResult + ", " + this);
        stop();
        this.mPath = iVariantPath;
        this.mPathResult = iPathResult;
        setPathInfo();
        start(0L);
    }

    private void setPathInfo() {
        if (isPathValid()) {
            this.mPathId = this.mPath.getPathId();
            this.mPathLength = this.mPath.getPathLength();
            this.mPathResult.addRef();
            this.mDisToTarget = (int) this.mPathLength;
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract.Presenter
    @MainThread
    public void updateNaviInfo(@NonNull XPNaviInfo xPNaviInfo) {
        if (isPathValid()) {
            initRoadInfo(xPNaviInfo);
            double d = xPNaviInfo.mRouteRemainDist;
            if (this.mLastRouteRemainDis == 0) {
                this.mLastRouteRemainDis = (int) d;
            }
            if (this.mLastRouteRemainDis - d > 1000.0d) {
                this.mLastRouteRemainDis = (int) d;
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "RefreshPanel  update 1 kmile interval --mObtainOnlineKErrorFlag:" + this.mObtainOnlineKErrorFlag + "   pathId:" + this.mPathId);
                }
                updateRemainDis();
            }
        }
    }

    private void initRoadInfo(XPNaviInfo xPNaviInfo) {
        if (xPNaviInfo != null) {
            this.mStartSegIndex = xPNaviInfo.mCurSegIdx;
            this.mStartLinkIndex = xPNaviInfo.mCurLinkIdx;
            if (xPNaviInfo.mViaRemainDist != null && xPNaviInfo.mViaRemainDist.length > 0 && this.mIsGuideNavi) {
                this.mIsVia = true;
                this.mViaRemainDist = xPNaviInfo.mViaRemainDist[0];
                this.mDisToTarget = (int) this.mViaRemainDist;
            } else {
                this.mIsVia = false;
                this.mViaRemainDist = 0L;
                this.mDisToTarget = (int) xPNaviInfo.mRouteRemainDist;
            }
            if (this.mIsGuideNavi) {
                int length = xPNaviInfo.mViaRemainDist != null ? xPNaviInfo.mViaRemainDist.length : 0;
                if (this.mCurViaArrayLength != length) {
                    L.Tag tag = TAG;
                    L.i(tag, " initRoadInfo mCurViaArrayLength:" + this.mCurViaArrayLength + "length:" + length);
                    this.mCurViaArrayLength = length;
                    refreshPanel(true);
                    return;
                }
                return;
            }
            return;
        }
        this.mStartSegIndex = 0;
        this.mStartLinkIndex = 0;
        this.mDisToTarget = (int) this.mPathLength;
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.PowerDisTimerWorker.IPowerDisOnTimerListener
    public void onTimerUpdateRemainDis() {
        L.Tag tag = TAG;
        L.i(tag, "RefreshPanel  update 1 minute interval --mObtainOnlineKErrorFlag:" + this.mObtainOnlineKErrorFlag + "   pathId:" + this.mPathId);
        updateRemainDis();
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.PowerDisTimerWorker.IPowerDisOnTimerListener
    public void onTimerRefreshOnlineK() {
        L.Tag tag = TAG;
        L.i(tag, "onTimerRefreshOnlineK  update 5 minute interval --mObtainOnlineKErrorFlag:" + this.mObtainOnlineKErrorFlag + " pathId:" + this.mPathId);
        refreshPanel(true);
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.PowerDisTimerWorker.IPowerDisOnTimerListener
    public void onCarModeChanged() {
        L.Tag tag = TAG;
        L.i(tag, "onCarModeChanged   pathId:" + this.mPathId + "  mObtainOnlineKErrorFlag:" + this.mObtainOnlineKErrorFlag);
        this.mIsKValid = false;
        if (!this.mObtainOnlineKErrorFlag) {
            this.mPowerDisTimerWorker.resetUpdateKTask(UILooperObserver.ANR_TRIGGER_TIME, CityDataBean.UNZIPPING_BLOCKING_TIME);
        } else {
            this.mPowerDisTimerWorker.resetUpdateReDisTask(UILooperObserver.ANR_TRIGGER_TIME, 60000L);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.PowerDisTimerWorker.IPowerDisOnTimerListener
    public void onEnduranceMileageModeChange(int i) {
        refreshPanel(false);
    }

    public void updateRemainDis() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateRemainDis--mObtainOnlineKErrorFlag：" + this.mObtainOnlineKErrorFlag + " mIsKValid:" + this.mIsKValid);
        }
        refreshPanel(this.mObtainOnlineKErrorFlag || !this.mIsKValid);
    }

    private void refreshPanel(boolean z) {
        if (!isPathValid()) {
            L.i(TAG, "refreshPanel path not valid return  ---");
            return;
        }
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        double routeRemain = getRouteRemain();
        double d = carRemainDistance;
        if (d - routeRemain >= 1000.0d) {
            if (this.mIsNetworkConnected && z) {
                double k = d - (this.mOnlineKHolder.getK() * routeRemain);
                boolean z2 = k < -10000.0d;
                L.Tag tag = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("refreshOnlineK d:");
                sb.append(k);
                sb.append("  isNeedRefresh :");
                sb.append(!z2);
                sb.append(" mObtainOnlineKErrorFlag:");
                sb.append(this.mObtainOnlineKErrorFlag);
                sb.append("   pathId:");
                sb.append(this.mPathId);
                L.i(tag, sb.toString());
                if (!z2) {
                    if (L.ENABLE) {
                        L.d(TAG, "refreshOnlineK--startSegIndex：" + this.mStartSegIndex + " startLinkIndex:" + this.mStartLinkIndex + " disToTarget:" + this.mDisToTarget + "   pathId:" + this.mPathId);
                    }
                    this.mDataProvider.refreshOnlineK(this.mStartSegIndex, this.mStartLinkIndex, this.mDisToTarget, this.mPath, this.mPathResult);
                    return;
                }
            }
            if (this.mIsKValid) {
                if (L.ENABLE) {
                    L.d(TAG, "refreshPanel UseValidKey  >>>   pathId:" + this.mPathId);
                }
                refreshPanel(carRemainDistance - ((int) (this.mOnlineKHolder.getK() * routeRemain)), true);
                return;
            }
            if (L.ENABLE) {
                L.d(TAG, "refreshPanel  key is not valid >>>> try to refreshWithOfflineK--startSegIndex：" + this.mStartSegIndex + " startLinkIndex:" + this.mStartLinkIndex + " disToTarget:" + this.mDisToTarget + "   pathId:" + this.mPathId);
            }
            this.mDataProvider.refreshWithOfflineK(this.mStartSegIndex, this.mStartLinkIndex, this.mDisToTarget, this.mPath, this.mPathResult);
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "refreshPanel onTimerRefreshPanel(0) for reason( cannot ReachDes)   pathId:" + this.mPathId + "   carRemain:" + CarServiceManager.getInstance().getCarRemainDistance() + "  mDisToTarget:" + this.mDisToTarget);
        }
        refreshPanel(0, true);
    }

    private void refreshPanel(int i, boolean z) {
        this.mLogicView.onUpdateRemainDis(this.mDisToTarget, i > 0 ? i : 0);
        if (L.ENABLE) {
            dumpRemainInfo(i, z);
        }
    }

    private void dumpRemainInfo(int i, boolean z) {
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        StringBuilder sb = new StringBuilder("");
        sb.append("dumpRemainInfo ");
        sb.append("(##-obtainOnlineKError:" + this.mObtainOnlineKErrorFlag);
        sb.append(" -iskeyValid:" + this.mIsKValid);
        sb.append("-isUsedOfflineK:-" + (z ^ true));
        sb.append("##)   -pathId:" + this.mPathId);
        sb.append(" -carRemain:" + carRemainDistance);
        sb.append(" -mOnlineKHolder:" + this.mOnlineKHolder.getK());
        sb.append(" -routeRemain:" + getRouteRemain());
        sb.append(" -kRouteRemainDes:" + (carRemainDistance - i));
        sb.append(" -remainDis:" + i);
        sb.append(" -isVia:" + this.mIsVia);
        sb.append(" -passingViaRemainDist:" + this.mViaRemainDist);
        sb.append(" -isNetConnected:" + this.mIsNetworkConnected);
        sb.append(" -th:" + Thread.currentThread().getName());
        L.d(TAG, sb.toString());
    }

    private double getRouteRemain() {
        return this.mDisToTarget;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull PowerDisResultData powerDisResultData) {
        int paramType = powerDisResultData.getParamType();
        if (paramType != 0) {
            if (paramType != 1) {
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, "onDataFetched REFRESH_WITH_OFFLINE_K -mObtainOnlineKErrorFlag-" + this.mObtainOnlineKErrorFlag + "   pathId:" + this.mPathId);
            refreshPanel(powerDisResultData.getRemainDis(), false);
            return;
        }
        this.mOnlineKHolder.setK(powerDisResultData.getK());
        this.mIsKValid = true;
        L.Tag tag2 = TAG;
        L.i(tag2, "onDataFetched REFRESH_ONLINE_K --" + this.mOnlineKHolder.getK() + "   pathId:" + this.mPathId);
        refreshPanel(false);
        if (this.mObtainOnlineKErrorFlag) {
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "onDataFetched --startUpdateKTask mOnlineKHolder:" + this.mOnlineKHolder.getK() + "   pathId:" + this.mPathId);
            }
            this.mPowerDisTimerWorker.startUpdateKTask();
            this.mObtainOnlineKErrorFlag = false;
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        L.Tag tag = TAG;
        L.i(tag, "onError--errorCode:" + i + " mOnlineKHolder:" + this.mOnlineKHolder.getK() + "  mObtainOnlineKErrorFlag:" + this.mObtainOnlineKErrorFlag + "   pathId:" + this.mPathId);
        if (!this.mObtainOnlineKErrorFlag) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "onError --stopUpdateKTask mOnlineKHolder：" + this.mOnlineKHolder.getK() + "   pathId:" + this.mPathId);
            }
            this.mPowerDisTimerWorker.stopUpdateKTask();
            this.mObtainOnlineKErrorFlag = true;
            refreshPanel(false);
            return;
        }
        refreshPanel(false);
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract.Presenter
    public long getPathId() {
        return this.mPathId;
    }

    @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
    public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
        this.mIsNetworkConnected = z;
        L.Tag tag = TAG;
        L.i(tag, "onNetworkChanged --isConnect：" + z + " mObtainOnlineKErrorFlag:" + this.mObtainOnlineKErrorFlag + "   pathId:" + this.mPathId);
        if (this.mIsNetworkConnected) {
            if (this.mObtainOnlineKErrorFlag) {
                return;
            }
            this.mPowerDisTimerWorker.startUpdateKTask(0L, CityDataBean.UNZIPPING_BLOCKING_TIME);
            return;
        }
        this.mPowerDisTimerWorker.stopUpdateKTask();
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }
}
