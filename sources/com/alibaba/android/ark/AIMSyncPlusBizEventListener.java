package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMSyncPlusBizEventListener {
    String GetTag();

    boolean OnDispatchRetryFailed(ArrayList<AIMSyncData> arrayList);

    void OnTooLong2(AIMSyncDataExtend aIMSyncDataExtend, AIMSyncPlusAck aIMSyncPlusAck);
}
