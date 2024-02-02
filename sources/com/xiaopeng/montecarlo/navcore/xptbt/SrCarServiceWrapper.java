package com.xiaopeng.montecarlo.navcore.xptbt;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.ISRCarService;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class SrCarServiceWrapper {
    private static final L.Tag TAG = new L.Tag("SrCarServiceWrapper");
    private ISRCarService mCarService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SrCarServiceWrapper(@NonNull ISRCarService iSRCarService) {
        this.mCarService = iSRCarService;
        this.mCarService.init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.mCarService.release();
    }

    public void setListener(ISRCarService.ISRCarStateListener iSRCarStateListener) {
        this.mCarService.registerObserver(iSRCarStateListener);
    }

    public void reInit(ISRCarService iSRCarService) {
        if (this.mCarService != null) {
            release();
            this.mCarService = null;
        }
        this.mCarService = iSRCarService;
    }

    public ISRCarService getCarService() {
        return this.mCarService;
    }

    public String getServiceName() {
        return this.mCarService.getServiceName();
    }
}
