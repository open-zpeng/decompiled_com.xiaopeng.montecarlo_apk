package com.xiaopeng.montecarlo.appengine;

import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public class CarGreetingInfoClient {
    private static final String AI_APP_PACKAGE = "com.xiaopeng.aiassistant";
    private static final String AI_APP_SERVICE_NAME = "GreetingService";
    private static final String AI_APP_SERVICE_PATH = "com.xiaopeng.aiassistant.GreetingService";
    private static final CarGreetingInfoClient sInstance = new CarGreetingInfoClient();
    private static final L.Tag TAG = new L.Tag("CarGInfoClient");

    private CarGreetingInfoClient() {
    }

    public static CarGreetingInfoClient getInstance() {
        return sInstance;
    }

    /* renamed from: onCallBackUserSearch */
    public String lambda$onCheckCallBackUserSearchInThread$0$CarGreetingInfoClient() {
        String str;
        L.Tag tag = TAG;
        L.i(tag, "onCallBackUserSearch= " + SystemClock.uptimeMillis());
        Uri.Builder builder = new Uri.Builder();
        builder.authority(AI_APP_SERVICE_PATH).path("dismissGreeting");
        try {
            str = (String) ApiRouter.route(builder.build());
        } catch (RemoteException | IllegalArgumentException e) {
            L.Tag tag2 = TAG;
            L.e(tag2, "onCallBackUserSearch ERROR=" + e.getMessage());
            str = "";
        }
        L.Tag tag3 = TAG;
        L.i(tag3, "onCallBackUserSearch result=" + str);
        return str;
    }

    public void onCheckCallBackUserSearchInThread() {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.appengine.-$$Lambda$CarGreetingInfoClient$DnsTcAlSiNfcpAY9BfrRXqxJ_7o
            @Override // java.lang.Runnable
            public final void run() {
                CarGreetingInfoClient.this.lambda$onCheckCallBackUserSearchInThread$0$CarGreetingInfoClient();
            }
        });
    }

    public int getCarGreetingRect() {
        String str;
        Uri.Builder builder = new Uri.Builder();
        builder.authority(AI_APP_SERVICE_PATH).path("getCarGreetingHeight");
        try {
            str = (String) ApiRouter.route(builder.build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "getCarGreetingRect ERROR=" + e.getMessage());
            str = "";
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "getCarGreetingRect result=" + str);
        return !TextUtils.isEmpty(str) ? Integer.valueOf(str).intValue() : MarkUtils.MARKER_ID_ROUTE_CHARGE_REACHABLE;
    }
}
