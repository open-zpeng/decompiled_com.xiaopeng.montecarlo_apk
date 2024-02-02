package com.xiaopeng.montecarlo.base.scene;

import java.util.HashMap;
/* loaded from: classes2.dex */
public interface IXPBroadcastReceiver {
    String[] getActions();

    String[] getDataKeys();

    void onReceive(String str, HashMap<String, String> hashMap);
}
