package com.xiaopeng.montecarlo.root.util;
/* loaded from: classes2.dex */
public interface ISRCarService {

    /* loaded from: classes2.dex */
    public interface ISRCarStateListener {
        void onSrRdPeriodDataComing(byte[] bArr, long j);
    }

    String getServiceName();

    void init();

    void registerObserver(ISRCarStateListener iSRCarStateListener);

    void release();
}
