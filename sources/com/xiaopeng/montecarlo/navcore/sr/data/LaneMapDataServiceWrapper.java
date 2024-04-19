package com.xiaopeng.montecarlo.navcore.sr.data;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.data.HotUpdateService;
import com.autonavi.gbl.data.LNDSService;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver;
import com.autonavi.gbl.data.observer.IMapNumObserver;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
/* loaded from: classes3.dex */
public class LaneMapDataServiceWrapper {
    private static final int MSG_START_INIT = 101;
    private static final L.Tag TAG = new L.Tag(LaneMapDataServiceWrapper.class.getSimpleName());
    private double mCurrentDownloadSize;
    private Handler mHandler;
    private HotUpdateService mHotUpdateService;
    private LNDSService mLndsService;
    private double mTotalDownloadSize;
    private final ILNDSCityDownloadObserver mLNDSCityDownloadObserver = new ILNDSCityDownloadObserver() { // from class: com.xiaopeng.montecarlo.navcore.sr.data.LaneMapDataServiceWrapper.1
        @Override // com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver
        public void onFileRecoverStatus(int i) {
        }

        @Override // com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver
        public void onDownloadVersion(int i, String str) {
            L.Tag tag = LaneMapDataServiceWrapper.TAG;
            L.i(tag, "onDownloadVersion urID:" + i + ",version:" + str);
            LaneDataAction obtain = LaneDataAction.obtain(2);
            obtain.setDownloadTaskUrId(i);
            obtain.setDownloadTaskVersion(str);
            LaneMapDataServiceWrapper.this.mLaneDataServicePublisher.onNext(obtain);
        }

        @Override // com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver
        public void onDownloadStatus(int i, int i2) {
            L.i(LaneMapDataServiceWrapper.TAG, "onDownloadStatus urID:" + i + ",taskCode:" + i2);
            if (i2 == 2) {
                LaneMapDataServiceWrapper.this.mCurrentDownloadSize = 0.0d;
            } else if (i2 == 4) {
                LaneMapDataServiceWrapper.this.mTotalDownloadSize += LaneMapDataServiceWrapper.this.mCurrentDownloadSize;
                LaneMapDataServiceWrapper.this.mCurrentDownloadSize = 0.0d;
            }
            LaneDataAction obtain = LaneDataAction.obtain(3);
            obtain.setDownloadTaskUrId(i);
            obtain.setDownloadTaskStatus(i2);
            LaneMapDataServiceWrapper.this.mLaneDataServicePublisher.onNext(obtain);
        }

        @Override // com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver
        public void onDownloadError(int i, int i2) {
            L.Tag tag = LaneMapDataServiceWrapper.TAG;
            L.w(tag, "onDownloadError urID:" + i + ",errorCode:" + i2);
            LaneDataAction obtain = LaneDataAction.obtain(4);
            obtain.setDownloadTaskUrId(i);
            obtain.setDownloadTaskErrorCode(i2);
            LaneMapDataServiceWrapper.this.mLaneDataServicePublisher.onNext(obtain);
        }

        @Override // com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver
        public void onDownloadProgress(int i, long j, float f) {
            LaneMapDataServiceWrapper.this.mCurrentDownloadSize = (((float) j) * f) / 100.0f;
            LaneDataAction obtain = LaneDataAction.obtain(5);
            obtain.setDownloadTaskUrId(i);
            obtain.setDownloadTaskTotalSize(j);
            obtain.setDownloadTaskPercent(f);
            obtain.setAllDownloadTaskCurrentSize(LaneMapDataServiceWrapper.this.mCurrentDownloadSize + LaneMapDataServiceWrapper.this.mTotalDownloadSize);
            LaneMapDataServiceWrapper.this.mLaneDataServicePublisher.onNext(obtain);
        }

        @Override // com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver
        public void onMergeProgress(int i, float f) {
            LaneDataAction obtain = LaneDataAction.obtain(6);
            obtain.setDownloadTaskUrId(i);
            obtain.setDownloadTaskMergePercent(f);
            LaneMapDataServiceWrapper.this.mLaneDataServicePublisher.onNext(obtain);
        }
    };
    private boolean mIsDestroyed = false;
    private PublishSubject<LaneDataAction> mLaneDataServicePublisher = PublishSubject.create();

    public LaneMapDataServiceWrapper(@Nullable Observer<LaneDataAction> observer) {
        if (observer != null) {
            this.mLaneDataServicePublisher.observeOn(Schedulers.io()).subscribe(observer);
        }
    }

    public void init() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(WorkThreadUtil.getInstance().getDataProcessThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.sr.data.LaneMapDataServiceWrapper.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        if (message.what == 101) {
                            synchronized (LaneMapDataServiceWrapper.this) {
                                if (!LaneMapDataServiceWrapper.this.mIsDestroyed) {
                                    LNDSService lndsService = LaneMapDataServiceWrapper.this.getLndsService();
                                    if (lndsService != null) {
                                        L.i(LaneMapDataServiceWrapper.TAG, "LNDSService addCityDownloadObserver~");
                                        lndsService.addCityDownloadObserver(LaneMapDataServiceWrapper.this.mLNDSCityDownloadObserver);
                                    }
                                    HotUpdateService hotUpdateService = LaneMapDataServiceWrapper.this.getHotUpdateService();
                                    if (hotUpdateService != null) {
                                        hotUpdateService.init();
                                    }
                                    LaneMapDataServiceWrapper.this.mLaneDataServicePublisher.onNext(LaneDataAction.obtain(1));
                                }
                            }
                        }
                    }
                };
                this.mHandler.sendEmptyMessage(101);
            }
        }
    }

    protected LNDSService getLndsService() {
        LNDSService lNDSService;
        synchronized (this) {
            if (this.mLndsService == null) {
                this.mLndsService = (LNDSService) ServiceMgr.getServiceMgrInstance().getBLService(24);
            }
            lNDSService = this.mLndsService;
        }
        return lNDSService;
    }

    protected HotUpdateService getHotUpdateService() {
        HotUpdateService hotUpdateService;
        synchronized (this) {
            if (this.mHotUpdateService == null) {
                this.mHotUpdateService = (HotUpdateService) ServiceMgr.getServiceMgrInstance().getBLService(21);
            }
            hotUpdateService = this.mHotUpdateService;
        }
        return hotUpdateService;
    }

    public void unInit() {
        synchronized (this) {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            if (this.mLndsService != null) {
                this.mLndsService.removeCityDownloadObserver(this.mLNDSCityDownloadObserver);
                this.mLndsService.unInit();
                this.mLndsService = null;
            }
            this.mLaneDataServicePublisher.onComplete();
            this.mLaneDataServicePublisher = null;
            if (this.mHotUpdateService != null) {
                this.mHotUpdateService.unInit();
                this.mHotUpdateService = null;
            }
            this.mIsDestroyed = true;
        }
    }

    public Disposable registerLaneDataObserver(@NonNull DisposableObserver<LaneDataAction> disposableObserver) {
        synchronized (this) {
            if (this.mLaneDataServicePublisher == null) {
                L.w(TAG, "LNDSService is not init yet!");
                return disposableObserver;
            }
            return (Disposable) this.mLaneDataServicePublisher.observeOn(Schedulers.io()).subscribeWith(disposableObserver);
        }
    }

    public MapNum requestLaneMapNum(IMapNumObserver iMapNumObserver) {
        synchronized (this) {
            if (this.mHotUpdateService == null) {
                L.w(TAG, "requestMapNum error: mHotUpdateService is null!");
                return null;
            }
            MapNum mapNum = new MapNum();
            mapNum.strKey = "lane";
            this.mHotUpdateService.requestMapNum(mapNum, iMapNumObserver);
            return mapNum;
        }
    }

    public MapNum requestLane30MapNum(IMapNumObserver iMapNumObserver) {
        synchronized (this) {
            if (this.mHotUpdateService == null) {
                L.w(TAG, "requestLane30MapNum error: mHotUpdateService is null!");
                return null;
            }
            MapNum mapNum = new MapNum();
            mapNum.strKey = "lane30";
            this.mHotUpdateService.requestMapNum(mapNum, iMapNumObserver);
            return mapNum;
        }
    }
}
