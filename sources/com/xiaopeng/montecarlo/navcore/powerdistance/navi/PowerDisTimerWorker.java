package com.xiaopeng.montecarlo.navcore.powerdistance.navi;

import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class PowerDisTimerWorker implements CarServiceManager.IXPCarStateListener {
    private static final int STATUS_CLOSE = 3;
    private static final int STATUS_INIT = 0;
    private static final int STATUS_START = 1;
    private static final int STATUS_STOP = 2;
    private static final L.Tag TAG = new L.Tag("navi_pd_helper");
    public static final int UPDATE_K_INITIALDELAY = 5000;
    public static final int UPDATE_K_INTERVAL_5_MIN = 300000;
    public static final int UPDATE_REMAINDIS_INTERVAL = 60000;
    private boolean mIsUpdateKTaskRunning;
    private boolean mIsUpdateRemainDisTaskRunning;
    private Disposable mRefreshOnlineKDisposable;
    private Disposable mUpdateRemainDisDisposable;
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private final ArrayList<IPowerDisOnTimerListener> mTimerListeners = new ArrayList<>();
    private int mStatus = 0;

    /* loaded from: classes2.dex */
    public interface IPowerDisOnTimerListener {
        void onCarModeChanged();

        void onEnduranceMileageModeChange(int i);

        void onTimerRefreshOnlineK();

        void onTimerUpdateRemainDis();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    public void start(long j) {
        int i = this.mStatus;
        if (i == 0 || i == 2) {
            L.Tag tag = TAG;
            L.i(tag, " start worker---" + this);
            startUpdateKTask(j, CityDataBean.UNZIPPING_BLOCKING_TIME);
            startUpdateReDisTask(60000L, 60000L);
            CarServiceManager.getInstance().addCarStateListener(this);
            this.mStatus = 1;
        }
    }

    public void stop() {
        if (this.mStatus == 1) {
            stopUpdateKTask();
            stopUpdateReDisTask();
            CarServiceManager.getInstance().removeCarStateListener(this);
            if (this.mCompositeDisposable.size() > 0) {
                this.mCompositeDisposable.clear();
            }
            this.mStatus = 2;
            L.Tag tag = TAG;
            L.i(tag, " stop worker---" + this);
        }
    }

    public void close() {
        if (this.mStatus >= 0) {
            if (this.mTimerListeners.size() > 0) {
                this.mTimerListeners.clear();
            }
            stopUpdateKTask();
            stopUpdateReDisTask();
            CarServiceManager.getInstance().removeCarStateListener(this);
            if (this.mCompositeDisposable.size() > 0) {
                this.mCompositeDisposable.dispose();
            }
            this.mStatus = 3;
            L.Tag tag = TAG;
            L.i(tag, " close worker---" + this);
        }
    }

    public void startUpdateKTask() {
        startUpdateKTask(CityDataBean.UNZIPPING_BLOCKING_TIME, CityDataBean.UNZIPPING_BLOCKING_TIME);
    }

    public void startUpdateKTask(long j, long j2) {
        if (this.mIsUpdateKTaskRunning) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, " startUpdateKTask-- initialDelay:" + j + "  period:" + j2);
        this.mRefreshOnlineKDisposable = Observable.interval(j, j2, TimeUnit.MILLISECONDS).subscribe(new Consumer<Long>() { // from class: com.xiaopeng.montecarlo.navcore.powerdistance.navi.PowerDisTimerWorker.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Long l) throws Exception {
                PowerDisTimerWorker.this.refreshOnlineK();
            }
        });
        try {
            this.mCompositeDisposable.add(this.mRefreshOnlineKDisposable);
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
        }
        this.mIsUpdateKTaskRunning = true;
    }

    public void stopUpdateKTask() {
        if (!this.mIsUpdateKTaskRunning || this.mRefreshOnlineKDisposable == null) {
            return;
        }
        L.i(TAG, " stopUpdateKTask-- ");
        try {
            this.mCompositeDisposable.remove(this.mRefreshOnlineKDisposable);
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
        }
        this.mIsUpdateKTaskRunning = false;
        this.mRefreshOnlineKDisposable = null;
    }

    public void resetUpdateKTask(long j, long j2) {
        stopUpdateKTask();
        startUpdateKTask(j, j2);
    }

    private void startUpdateReDisTask(long j, long j2) {
        if (this.mIsUpdateRemainDisTaskRunning) {
            return;
        }
        L.i(TAG, " startUpdateReDisTask-- ");
        this.mUpdateRemainDisDisposable = Observable.interval(j, j2, TimeUnit.MILLISECONDS).subscribe(new Consumer<Long>() { // from class: com.xiaopeng.montecarlo.navcore.powerdistance.navi.PowerDisTimerWorker.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Long l) throws Exception {
                PowerDisTimerWorker.this.updateRemainDis();
            }
        });
        try {
            this.mCompositeDisposable.add(this.mUpdateRemainDisDisposable);
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
        }
        this.mIsUpdateRemainDisTaskRunning = true;
    }

    private void stopUpdateReDisTask() {
        if (!this.mIsUpdateRemainDisTaskRunning || this.mUpdateRemainDisDisposable == null) {
            return;
        }
        L.i(TAG, " stopUpdateReDisTask-- ");
        try {
            this.mCompositeDisposable.remove(this.mUpdateRemainDisDisposable);
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
        }
        this.mIsUpdateRemainDisTaskRunning = false;
        this.mUpdateRemainDisDisposable = null;
    }

    public void resetUpdateReDisTask(long j, long j2) {
        stopUpdateReDisTask();
        startUpdateReDisTask(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshOnlineK() {
        Iterator<IPowerDisOnTimerListener> it = this.mTimerListeners.iterator();
        while (it.hasNext()) {
            IPowerDisOnTimerListener next = it.next();
            if (next != null) {
                next.onTimerRefreshOnlineK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemainDis() {
        Iterator<IPowerDisOnTimerListener> it = this.mTimerListeners.iterator();
        while (it.hasNext()) {
            IPowerDisOnTimerListener next = it.next();
            if (next != null) {
                next.onTimerUpdateRemainDis();
            }
        }
    }

    private void notifyCarModeChanged() {
        Iterator<IPowerDisOnTimerListener> it = this.mTimerListeners.iterator();
        while (it.hasNext()) {
            IPowerDisOnTimerListener next = it.next();
            if (next != null) {
                next.onCarModeChanged();
            }
        }
    }

    public synchronized void addPowerDisOnTimerListener(IPowerDisOnTimerListener iPowerDisOnTimerListener) {
        CollectionUtils.listAdd(this.mTimerListeners, iPowerDisOnTimerListener);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
        Iterator<IPowerDisOnTimerListener> it = this.mTimerListeners.iterator();
        while (it.hasNext()) {
            IPowerDisOnTimerListener next = it.next();
            if (next != null) {
                next.onEnduranceMileageModeChange(i);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, " onHVACPowerModeChange-- isPowerOn:" + z);
        notifyCarModeChanged();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
        L.Tag tag = TAG;
        L.i(tag, " onDrivingModeChange-- mode:" + i);
        notifyCarModeChanged();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
        L.Tag tag = TAG;
        L.i(tag, " onEnergyRecycleLevelChange-- level:" + i);
        notifyCarModeChanged();
    }
}
