package org.eclipse.paho.android.service;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.autonavi.gbl.pos.model.LocDataType;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AlarmPingSender implements MqttPingSender {
    private static final String TAG = "AlarmPingSender";
    private BroadcastReceiver alarmReceiver;
    private ClientComms comms;
    private volatile boolean hasStarted = false;
    private PendingIntent pendingIntent;
    private MqttService service;
    private AlarmPingSender that;

    public AlarmPingSender(MqttService mqttService, MqttConnection mqttConnection) {
        if (mqttService == null) {
            throw new IllegalArgumentException("Neither service nor client can be null.");
        }
        this.service = mqttService;
        this.that = this;
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void init(ClientComms clientComms) {
        this.comms = clientComms;
        this.alarmReceiver = new AlarmReceiver();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public synchronized void start() {
        if (this.hasStarted) {
            return;
        }
        String str = MqttServiceConstants.PING_SENDER + this.comms.getClient().getClientId();
        Log.d(TAG, "Register AlarmReceiver to MqttService" + str);
        this.service.registerReceiver(this.alarmReceiver, new IntentFilter(str));
        this.pendingIntent = PendingIntent.getBroadcast(this.service, 0, new Intent(str), LocDataType.LocDataVDRInfo);
        schedule(this.comms.getKeepAlive());
        this.hasStarted = true;
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public synchronized void stop() {
        if (this.hasStarted) {
            Log.d(TAG, "Unregister AlarmReceiver to MqttService:" + this.comms.getClient().getClientId());
            if (this.pendingIntent != null) {
                ((AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.pendingIntent);
            }
            this.hasStarted = false;
            try {
                this.service.unregisterReceiver(this.alarmReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public synchronized void schedule(long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        AlarmManager alarmManager = (AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, this.pendingIntent);
        } else {
            alarmManager.set(0, currentTimeMillis, this.pendingIntent);
        }
    }

    /* loaded from: classes3.dex */
    private class PingAsyncTask extends AsyncTask<ClientComms, Void, Boolean> {
        private static final int TIMEOUT_COMPLETION = 6000;
        boolean success;

        private PingAsyncTask() {
            this.success = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(ClientComms... clientCommsArr) {
            MqttToken checkForActivity = clientCommsArr[0].checkForActivity(new IMqttActionListener() { // from class: org.eclipse.paho.android.service.AlarmPingSender.PingAsyncTask.1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken iMqttToken) {
                    PingAsyncTask.this.success = true;
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    Log.d(AlarmPingSender.TAG, "Ping async task : Failed.");
                    PingAsyncTask.this.success = false;
                }
            });
            try {
                if (checkForActivity != null) {
                    checkForActivity.waitForCompletion(6000L);
                } else {
                    Log.d(AlarmPingSender.TAG, "Ping async background : Ping command was not sent by the client.");
                }
            } catch (MqttException e) {
                Log.d(AlarmPingSender.TAG, "Ping async background : Ignore MQTT exception : " + e.getMessage());
            } catch (Exception e2) {
                Log.d(AlarmPingSender.TAG, "Ping async background : Ignore unknown exception : " + e2.getMessage());
            }
            if (!this.success) {
                Log.d(AlarmPingSender.TAG, "Ping async background task completed at " + System.currentTimeMillis() + " Success is " + this.success);
            }
            return new Boolean(this.success);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                return;
            }
            Log.d(AlarmPingSender.TAG, "Ping async task onPostExecute() Success is " + this.success);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(Boolean bool) {
            Log.d(AlarmPingSender.TAG, "Ping async task onCancelled() Success is " + this.success);
        }
    }

    /* loaded from: classes3.dex */
    class AlarmReceiver extends BroadcastReceiver {
        private PingAsyncTask pingRunner = null;
        private final String wakeLockTag;
        private PowerManager.WakeLock wakelock;

        AlarmReceiver() {
            this.wakeLockTag = MqttServiceConstants.PING_WAKELOCK + AlarmPingSender.this.that.comms.getClient().getClientId();
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            this.wakelock = ((PowerManager) AlarmPingSender.this.service.getSystemService("power")).newWakeLock(1, this.wakeLockTag);
            this.wakelock.acquire();
            PingAsyncTask pingAsyncTask = this.pingRunner;
            if (pingAsyncTask != null && pingAsyncTask.cancel(true)) {
                Log.d(AlarmPingSender.TAG, "Previous ping async task was cancelled at:" + System.currentTimeMillis());
            }
            this.pingRunner = new PingAsyncTask();
            this.pingRunner.execute(AlarmPingSender.this.comms);
            if (this.wakelock.isHeld()) {
                this.wakelock.release();
            }
        }
    }
}
