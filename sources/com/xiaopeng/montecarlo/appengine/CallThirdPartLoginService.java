package com.xiaopeng.montecarlo.appengine;

import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class CallThirdPartLoginService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("CallThirdPartLoginService");
    private static final String USER_CENTER_APP_PACKAGE = "com.xiaopeng.caraccount";
    private static final String USER_CENTER_APP_SERVICE_NAME = "GallThirdPartService";
    private static final String USER_CENTER_APP_SERVICE_PATH = "com.xiaopeng.caraccount.GallThirdPartService";

    @Publish
    public void weChat() {
        if (L.ENABLE) {
            L.d(TAG, "user center call weChat function");
        }
        sendMapToFront();
    }

    void sendMapToFront() {
        Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
        intent.setAction(IntentActions.ACTION_THIRD_APP_ACCESS);
        intent.setFlags(268435456);
        ContextUtils.getContext().startActivity(intent);
    }

    public static String closeUserCenterFromClient() {
        String str;
        RemoteException e;
        Uri.Builder builder = new Uri.Builder();
        builder.authority(USER_CENTER_APP_SERVICE_PATH).path("dismissUserCenter");
        try {
            str = (String) ApiRouter.route(builder.build());
        } catch (RemoteException e2) {
            str = "";
            e = e2;
        }
        try {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "closeUserCenter result=" + str);
            }
        } catch (RemoteException e3) {
            e = e3;
            L.Tag tag2 = TAG;
            L.e(tag2, "closeUserCenter error=" + e.getMessage());
            return str;
        }
        return str;
    }

    public static void openUserCenterFromClient() {
        Uri.Builder builder = new Uri.Builder();
        builder.authority(USER_CENTER_APP_SERVICE_PATH).path("openUserCenter");
        try {
            ApiRouter.route(builder.build());
            if (L.ENABLE) {
                L.d(TAG, "openUserCenter success");
            }
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "openUserCenter error=" + e.getMessage());
        }
    }
}
