package com.dingtalk.bifrost;

import android.content.Context;
import android.content.Intent;
import com.dingtalk.mars.BaseEvent;
import com.dingtalk.mobile.common.adapter.BifrostRigorousNetworkConnReceiver;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
/* loaded from: classes2.dex */
public class BifrostNetworkConnReceiver extends BifrostRigorousNetworkConnReceiver {
    private static final String TAG = "bifrost";
    private static BifrostNetworkConnReceiver networkConnectListener;

    private BifrostNetworkConnReceiver(Context context) {
        super(context);
    }

    public static BifrostNetworkConnReceiver instance(Context context) {
        if (networkConnectListener == null) {
            networkConnectListener = new BifrostNetworkConnReceiver(context);
        }
        return networkConnectListener;
    }

    public static boolean hasInstance() {
        return networkConnectListener != null;
    }

    @Override // com.dingtalk.mobile.common.adapter.BifrostRigorousNetworkConnReceiver
    protected void onReceivee(Context context, Intent intent) {
        if (context == null) {
            BifrostLogCatUtil.warn(TAG, "context is null.");
        } else {
            new Thread() { // from class: com.dingtalk.bifrost.BifrostNetworkConnReceiver.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    BifrostLogCatUtil.debug(BifrostNetworkConnReceiver.TAG, "network change.");
                    BaseEvent.onNetworkChange();
                }
            }.start();
        }
    }
}
