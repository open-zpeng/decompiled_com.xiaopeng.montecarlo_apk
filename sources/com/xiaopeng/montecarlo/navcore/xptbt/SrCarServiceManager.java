package com.xiaopeng.montecarlo.navcore.xptbt;

import com.xiaopeng.montecarlo.root.util.ISRCarService;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class SrCarServiceManager implements ISRCarService.ISRCarStateListener {
    private static final L.Tag TAG = new L.Tag("SrCarServiceManager");
    private static final SrCarServiceManager sInstance = new SrCarServiceManager();
    private SrCarServiceWrapper mCarServiceWrapper;
    private boolean mIsInitialized = false;
    private final List<IXPSrCarStateListener> mListeners = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface IXPSrCarStateListener {
        default void onSrRdPeriodDataComing(byte[] bArr, long j) {
        }
    }

    private SrCarServiceManager() {
    }

    public static SrCarServiceManager getInstance() {
        return sInstance;
    }

    public void init(ISRCarService iSRCarService) {
        if (this.mIsInitialized) {
            return;
        }
        L.i(TAG, "init");
        this.mCarServiceWrapper = new SrCarServiceWrapper(iSRCarService);
        this.mCarServiceWrapper.setListener(this);
        this.mIsInitialized = true;
    }

    public void reinit(ISRCarService iSRCarService) {
        if (!this.mIsInitialized) {
            init(iSRCarService);
            return;
        }
        SrCarServiceWrapper srCarServiceWrapper = this.mCarServiceWrapper;
        if (srCarServiceWrapper != null) {
            srCarServiceWrapper.reInit(iSRCarService);
        }
    }

    public void release() {
        L.i(TAG, "release");
        if (this.mIsInitialized) {
            SrCarServiceWrapper srCarServiceWrapper = this.mCarServiceWrapper;
            if (srCarServiceWrapper != null) {
                srCarServiceWrapper.release();
                this.mCarServiceWrapper.setListener(null);
            }
            this.mCarServiceWrapper = null;
            this.mIsInitialized = false;
        }
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public String getServiceName() {
        return this.mCarServiceWrapper.getServiceName();
    }

    public void addCarStateListener(IXPSrCarStateListener iXPSrCarStateListener) {
        if (iXPSrCarStateListener == null || this.mListeners.contains(iXPSrCarStateListener)) {
            return;
        }
        this.mListeners.add(iXPSrCarStateListener);
    }

    public void removeCarStateListener(IXPSrCarStateListener iXPSrCarStateListener) {
        this.mListeners.remove(iXPSrCarStateListener);
    }

    @Override // com.xiaopeng.montecarlo.root.util.ISRCarService.ISRCarStateListener
    public void onSrRdPeriodDataComing(byte[] bArr, long j) {
        for (IXPSrCarStateListener iXPSrCarStateListener : this.mListeners) {
            iXPSrCarStateListener.onSrRdPeriodDataComing(bArr, j);
        }
    }

    public ISRCarService getCarService() {
        SrCarServiceWrapper srCarServiceWrapper = this.mCarServiceWrapper;
        if (srCarServiceWrapper != null) {
            return srCarServiceWrapper.getCarService();
        }
        return null;
    }
}
