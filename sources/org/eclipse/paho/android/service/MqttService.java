package org.eclipse.paho.android.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
@SuppressLint({"Registered"})
/* loaded from: classes3.dex */
public class MqttService extends Service implements MqttTraceHandler {
    static final String TAG = "MqttService";
    private BackgroundDataPreferenceReceiver backgroundDataPreferenceMonitor;
    private HandlerThread mHanlerThread;
    private Handler mThreadHandler;
    MessageStore messageStore;
    private MqttServiceBinder mqttServiceBinder;
    private NetworkConnectionIntentReceiver networkConnectionMonitor;
    private String traceCallbackId;
    private boolean traceEnabled = true;
    private boolean XMART_ENABLE_NETWORK_MONITOR = false;
    private volatile boolean backgroundDataEnabled = true;
    private Map<String, MqttConnection> connections = new ConcurrentHashMap();
    private int oldNetType = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void callbackToActivity(String str, Status status, Bundle bundle) {
        Intent intent = new Intent(MqttServiceConstants.CALLBACK_TO_ACTIVITY);
        if (str != null) {
            intent.putExtra(MqttServiceConstants.CALLBACK_CLIENT_HANDLE, str);
        }
        intent.putExtra(MqttServiceConstants.CALLBACK_STATUS, status);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public String getClient(String str, String str2, String str3, MqttClientPersistence mqttClientPersistence) {
        String str4 = str + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + str2 + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + str3;
        if (!this.connections.containsKey(str4)) {
            this.connections.put(str4, new MqttConnection(this, str, str2, mqttClientPersistence, str4));
        }
        return str4;
    }

    public void connect(String str, MqttConnectOptions mqttConnectOptions, String str2, String str3) throws MqttSecurityException, MqttException {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.connect(mqttConnectOptions, null, str3);
    }

    void reconnect() {
        traceDebug("MqttService", "Reconnect to server, client size=" + this.connections.size());
        for (MqttConnection mqttConnection : this.connections.values()) {
            traceDebug("Reconnect Client:", mqttConnection.getClientId() + '/' + mqttConnection.getServerURI());
            if (isOnline()) {
                mqttConnection.reconnect();
            }
        }
    }

    public void close(String str) {
        MqttConnection connection = getConnection(str);
        if (connection != null) {
            connection.close();
        }
    }

    public void disconnect(String str, String str2, String str3) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.disconnect(str2, str3);
        close(str);
        this.connections.remove(str);
        stopSelf();
    }

    public void disconnect(String str, long j, String str2, String str3) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.disconnect(j, str2, str3);
        close(str);
        this.connections.remove(str);
        stopSelf();
    }

    public void disconnectConnection(String str, String str2, String str3) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.disconnectForcibly(str2, str3);
        close(str);
        this.connections.remove(str);
        stopSelf();
    }

    public boolean isConnected(String str) {
        try {
            MqttConnection connection = getConnection(str);
            if (connection != null) {
                return connection.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public IMqttDeliveryToken publish(String str, String str2, byte[] bArr, int i, boolean z, String str3, String str4) throws MqttPersistenceException, MqttException {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return null;
        }
        return connection.publish(str2, bArr, i, z, str3, str4);
    }

    public IMqttDeliveryToken publish(String str, String str2, MqttMessage mqttMessage, String str3, String str4) throws MqttPersistenceException, MqttException {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return null;
        }
        return connection.publish(str2, mqttMessage, str3, str4);
    }

    public void subscribe(String str, String str2, int i, String str3, String str4) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.subscribe(str2, i, str3, str4);
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.subscribe(strArr, iArr, str2, str3);
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3, IMqttMessageListener[] iMqttMessageListenerArr) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.subscribe(strArr, iArr, str2, str3, iMqttMessageListenerArr);
    }

    public void unsubscribe(String str, String str2, String str3, String str4) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.unsubscribe(str2, str3, str4);
    }

    public void unsubscribe(String str, String[] strArr, String str2, String str3) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.unsubscribe(strArr, str2, str3);
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens(String str) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return null;
        }
        return connection.getPendingDeliveryTokens();
    }

    public MqttConnection getConnection(String str) {
        Map<String, MqttConnection> map = this.connections;
        if (map == null) {
            return null;
        }
        MqttConnection mqttConnection = map.get(str);
        if (mqttConnection != null) {
            return mqttConnection;
        }
        throw new IllegalArgumentException("Invalid ClientHandle");
    }

    public Status acknowledgeMessageArrival(String str, String str2) {
        if (this.messageStore.discardArrived(str, str2)) {
            return Status.OK;
        }
        return Status.ERROR;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mqttServiceBinder = new MqttServiceBinder(this);
        this.messageStore = new DatabaseMessageStore(this, this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        traceDebug("MqttService", "onDestroy");
        for (MqttConnection mqttConnection : this.connections.values()) {
            mqttConnection.disconnect(null, null);
        }
        if (this.mqttServiceBinder != null) {
            this.mqttServiceBinder = null;
        }
        if (this.XMART_ENABLE_NETWORK_MONITOR) {
            unregisterBroadcastReceivers();
        }
        MessageStore messageStore = this.messageStore;
        if (messageStore != null) {
            messageStore.close();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.mqttServiceBinder.setActivityToken(intent.getStringExtra(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN));
        return this.mqttServiceBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.XMART_ENABLE_NETWORK_MONITOR) {
            registerBroadcastReceivers();
            return 1;
        }
        return 1;
    }

    public void setTraceCallbackId(String str) {
        this.traceCallbackId = str;
    }

    public void setTraceEnabled(boolean z) {
        this.traceEnabled = z;
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    @Override // org.eclipse.paho.android.service.MqttTraceHandler
    public void traceDebug(String str, String str2) {
        traceCallback("debug", str, str2);
    }

    @Override // org.eclipse.paho.android.service.MqttTraceHandler
    public void traceError(String str, String str2) {
        traceCallback(MqttServiceConstants.TRACE_ERROR, str, str2);
    }

    private void traceCallback(String str, String str2, String str3) {
        if (this.traceCallbackId == null || !this.traceEnabled) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.TRACE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, str);
        bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str3);
        callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
    }

    @Override // org.eclipse.paho.android.service.MqttTraceHandler
    public void traceException(String str, String str2, Exception exc) {
        if (this.traceCallbackId != null) {
            Bundle bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.TRACE_ACTION);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, MqttServiceConstants.TRACE_EXCEPTION);
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str2);
            bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str);
            callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
        }
    }

    private void registerBroadcastReceivers() {
        if (this.networkConnectionMonitor == null) {
            this.networkConnectionMonitor = new NetworkConnectionIntentReceiver();
            registerReceiver(this.networkConnectionMonitor, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.backgroundDataEnabled = ((ConnectivityManager) getSystemService("connectivity")).getBackgroundDataSetting();
            if (this.backgroundDataPreferenceMonitor == null) {
                this.backgroundDataPreferenceMonitor = new BackgroundDataPreferenceReceiver();
                registerReceiver(this.backgroundDataPreferenceMonitor, new IntentFilter("android.net.conn.BACKGROUND_DATA_SETTING_CHANGED"));
            }
        }
    }

    private void unregisterBroadcastReceivers() {
        BackgroundDataPreferenceReceiver backgroundDataPreferenceReceiver;
        NetworkConnectionIntentReceiver networkConnectionIntentReceiver = this.networkConnectionMonitor;
        if (networkConnectionIntentReceiver != null) {
            unregisterReceiver(networkConnectionIntentReceiver);
            this.networkConnectionMonitor = null;
        }
        if (Build.VERSION.SDK_INT >= 14 || (backgroundDataPreferenceReceiver = this.backgroundDataPreferenceMonitor) == null) {
            return;
        }
        unregisterReceiver(backgroundDataPreferenceReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class NetworkConnectionIntentReceiver extends BroadcastReceiver {
        private NetworkConnectionIntentReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"Wakelock"})
        public void onReceive(final Context context, Intent intent) {
            MqttService.this.traceDebug("MqttService", "Internal network status receive.");
            if (MqttService.this.mHanlerThread == null) {
                MqttService.this.mHanlerThread = new HandlerThread("handlerThread", 10);
                MqttService.this.mHanlerThread.start();
            }
            if (MqttService.this.mThreadHandler == null) {
                MqttService mqttService = MqttService.this;
                mqttService.mThreadHandler = new Handler(mqttService.mHanlerThread.getLooper());
            }
            MqttService.this.mThreadHandler.post(new Runnable() { // from class: org.eclipse.paho.android.service.MqttService.NetworkConnectionIntentReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    PowerManager.WakeLock newWakeLock = ((PowerManager) MqttService.this.getSystemService("power")).newWakeLock(1, "MQTT");
                    newWakeLock.acquire();
                    MqttService.this.traceDebug("MqttService", "Reconnect for Network recovery.");
                    if (!MqttService.this.isOnline()) {
                        MqttService.this.oldNetType = -1;
                        MqttService.this.notifyClientsOffline();
                    } else {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            int type = activeNetworkInfo.getType();
                            if (MqttService.this.oldNetType != type && MqttService.this.oldNetType != 0) {
                                MqttService.this.traceDebug("MqttService", "Online,reconnect.");
                                new Timer().schedule(new TimerTask() { // from class: org.eclipse.paho.android.service.MqttService.NetworkConnectionIntentReceiver.1.1
                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public void run() {
                                        MqttService.this.reconnect();
                                    }
                                }, 1000L);
                            }
                            MqttService.this.oldNetType = type;
                        }
                    }
                    newWakeLock.release();
                }
            });
        }
    }

    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && this.backgroundDataEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClientsOffline() {
        for (MqttConnection mqttConnection : this.connections.values()) {
            mqttConnection.offline();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class BackgroundDataPreferenceReceiver extends BroadcastReceiver {
        private BackgroundDataPreferenceReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MqttService.this.traceDebug("MqttService", "Reconnect since BroadcastReceiver.");
            if (((ConnectivityManager) MqttService.this.getSystemService("connectivity")).getBackgroundDataSetting()) {
                if (MqttService.this.backgroundDataEnabled) {
                    return;
                }
                MqttService.this.backgroundDataEnabled = true;
                MqttService.this.reconnect();
                return;
            }
            MqttService.this.backgroundDataEnabled = false;
            MqttService.this.notifyClientsOffline();
        }
    }

    public void setBufferOpts(String str, DisconnectedBufferOptions disconnectedBufferOptions) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.setBufferOpts(disconnectedBufferOptions);
    }

    public int getBufferedMessageCount(String str) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return 0;
        }
        return connection.getBufferedMessageCount();
    }

    public MqttMessage getBufferedMessage(String str, int i) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return null;
        }
        return connection.getBufferedMessage(i);
    }

    public void deleteBufferedMessage(String str, int i) {
        MqttConnection connection = getConnection(str);
        if (connection == null) {
            return;
        }
        connection.deleteBufferedMessage(i);
    }

    public void removeConnection(MqttConnection mqttConnection) {
        traceDebug("MqttService", "remove connection:" + mqttConnection);
        if (mqttConnection == null) {
            traceDebug("MqttService", "connection is null, return!");
            return;
        }
        for (Map.Entry<String, MqttConnection> entry : this.connections.entrySet()) {
            if (mqttConnection.equals(entry.getValue())) {
                traceDebug("MqttService", "connection's key is '" + entry.getKey() + "', disconnect, close and remove it");
                mqttConnection.disconnect(null, null);
                mqttConnection.close();
                this.connections.remove(entry.getKey());
                return;
            }
        }
    }

    public void checkPing(String str, String str2) {
        MqttConnection mqttConnection;
        try {
            mqttConnection = getConnection(str);
        } catch (Exception unused) {
            mqttConnection = null;
        }
        if (mqttConnection != null) {
            mqttConnection.checkPing(str2);
        }
    }
}
