package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMSyncPlusPackageDataHandler {
    String GetTag();

    void OnReceived(ArrayList<AIMSyncData> arrayList, AIMSyncDataExtend aIMSyncDataExtend, AIMSyncPlusAck aIMSyncPlusAck);

    ArrayList<Integer> SupportTypes();
}
