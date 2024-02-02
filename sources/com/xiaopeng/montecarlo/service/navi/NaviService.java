package com.xiaopeng.montecarlo.service.navi;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.routescene.RouteSaveState;
import com.xiaopeng.montecarlo.service.navi.INaviCallback;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.service.navi.type.RequestIntField;
import com.xiaopeng.montecarlo.service.navi.type.RequestStringField;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class NaviService extends Service {
    public static L.Tag TAG = new L.Tag("NaviService");
    private volatile ServiceHandler mServiceHandler;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("com.xiaopeng.montecarlo", "Montecarlo", 3));
            startForeground(1, new NotificationCompat.Builder(this, "com.xiaopeng.montecarlo").setSmallIcon(R.drawable.x_ic_logo).setContentTitle("").setContentText("").build());
        }
        this.mServiceHandler = new ServiceHandler(WorkThreadUtil.getInstance().getNavThreadLooper());
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.obj = intent;
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        String stringExtra = intent.getStringExtra("service");
        String stringExtra2 = intent.getStringExtra("app_id");
        L.Tag tag = TAG;
        L.i(tag, "onBind service:" + stringExtra + " appId:" + stringExtra2);
        if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return LocalNaviService.getInstance().getService(this, stringExtra);
    }

    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null) {
            L.e(TAG, "onHandleIntent intent is NULl.");
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("param");
        if (intent.getBooleanExtra("is_test", false)) {
            bundleExtra = new Bundle();
            bundleExtra.putString("app_id", intent.getStringExtra("app_id"));
            bundleExtra.putInt(RouteSaveState.KEY_ROUTE_REQUEST_ID, intent.getIntExtra(RouteSaveState.KEY_ROUTE_REQUEST_ID, 0));
            bundleExtra.putInt(SpeechRequestFactory.PARAM_WHAT, intent.getIntExtra(SpeechRequestFactory.PARAM_WHAT, 0));
            bundleExtra.putString("content", intent.getStringExtra("content"));
            bundleExtra.putInt("back_type", 3);
        }
        if (bundleExtra == null) {
            L.e(TAG, "onHandleIntent param is NULl.");
        } else {
            handleBundleParam(bundleExtra);
        }
    }

    private void handleBundleParam(Bundle bundle) {
        Field[] declaredFields;
        Request request = new Request();
        for (Field field : Request.class.getDeclaredFields()) {
            RequestStringField requestStringField = (RequestStringField) field.getAnnotation(RequestStringField.class);
            RequestIntField requestIntField = (RequestIntField) field.getAnnotation(RequestIntField.class);
            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
            if (requestStringField != null && serializedName != null) {
                try {
                    Request.class.getMethod(requestStringField.value(), String.class).invoke(request, bundle.getString(serializedName.value(), requestStringField.def()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (requestIntField != null && serializedName != null) {
                try {
                    Request.class.getMethod(requestIntField.value(), Integer.TYPE).invoke(request, Integer.valueOf(bundle.getInt(serializedName.value(), requestIntField.def())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        L.i(TAG, "onHandleIntent request:" + request);
        if (request.isValid()) {
            IBinder binder = bundle.getBinder("callback");
            LocalNaviService.getInstance().onHandleRequest(this, request, binder != null ? new RemoteCallback(INaviCallback.Stub.asInterface(binder)) : null, this.mServiceHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NaviService.this.onHandleIntent((Intent) message.obj);
        }
    }
}
