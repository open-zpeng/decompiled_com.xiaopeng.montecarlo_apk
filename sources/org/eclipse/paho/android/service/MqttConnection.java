package org.eclipse.paho.android.service;

import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.android.service.MessageStore;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPingReq;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MqttConnection implements MqttCallbackExtended {
    private static final long DISCONNECT_TIMEOUT = 5000;
    private static final String NOT_CONNECTED = "not connected";
    private static final boolean NO_DISCONNECT_PACKET = false;
    private static final long QUIESCE_TIMEOUT = 10000;
    private static final String TAG = "MqttConnection";
    private static final boolean USE_EXTERNAL_STORAGE = false;
    private String clientHandle;
    private String clientId;
    private MqttConnectOptions connectOptions;
    private MqttClientPersistence persistence;
    private String serverURI;
    private MqttService service;
    private String wakeLockTag;
    private String reconnectActivityToken = null;
    private MqttAsyncClient myClient = null;
    private AlarmPingSender alarmPingSender = null;
    private volatile boolean disconnected = true;
    private boolean cleanSession = true;
    private volatile boolean isConnecting = false;
    private Map<IMqttDeliveryToken, String> savedTopics = new HashMap();
    private Map<IMqttDeliveryToken, MqttMessage> savedSentMessages = new HashMap();
    private Map<IMqttDeliveryToken, String> savedActivityTokens = new HashMap();
    private Map<IMqttDeliveryToken, String> savedInvocationContexts = new HashMap();
    private PowerManager.WakeLock wakelock = null;
    private DisconnectedBufferOptions bufferOpts = null;

    public String getServerURI() {
        return this.serverURI;
    }

    public void setServerURI(String str) {
        this.serverURI = str;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public MqttConnectOptions getConnectOptions() {
        return this.connectOptions;
    }

    public void setConnectOptions(MqttConnectOptions mqttConnectOptions) {
        this.connectOptions = mqttConnectOptions;
    }

    public String getClientHandle() {
        return this.clientHandle;
    }

    public void setClientHandle(String str) {
        this.clientHandle = str;
    }

    /* loaded from: classes3.dex */
    private class CustomMqttAsyncClient extends MqttAsyncClient {
        private MqttPingReq mPingMessage;

        public CustomMqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender) throws MqttException {
            super(str, str2, mqttClientPersistence, mqttPingSender, null);
            this.mPingMessage = new MqttPingReq();
        }

        public void checkPing(IMqttActionListener iMqttActionListener) throws MqttException {
            if (this.comms == null || !this.comms.isConnected()) {
                return;
            }
            MqttToken mqttToken = new MqttToken(getClientId());
            mqttToken.setActionCallback(iMqttActionListener);
            mqttToken.setUserContext(null);
            this.comms.sendNoWait(this.mPingMessage, mqttToken);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttConnection(MqttService mqttService, String str, String str2, MqttClientPersistence mqttClientPersistence, String str3) {
        this.persistence = null;
        this.service = null;
        this.wakeLockTag = null;
        this.serverURI = str;
        this.service = mqttService;
        this.clientId = str2;
        this.persistence = mqttClientPersistence;
        this.clientHandle = str3;
        this.wakeLockTag = getClass().getCanonicalName() + " " + str2 + " on host " + str;
    }

    public void connect(MqttConnectOptions mqttConnectOptions, String str, String str2) {
        this.connectOptions = mqttConnectOptions;
        this.reconnectActivityToken = str2;
        if (mqttConnectOptions != null) {
            this.cleanSession = mqttConnectOptions.isCleanSession();
        }
        if (this.connectOptions.isCleanSession()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "Connecting {" + this.serverURI + "} as {" + this.clientId + "}");
        final Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
        try {
            if (this.persistence == null) {
                File dir = this.service.getDir(TAG, 0);
                if (dir == null) {
                    bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, "Error! No external and internal storage available");
                    bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, new MqttPersistenceException());
                    this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
                    return;
                }
                this.persistence = new MqttDefaultFilePersistence(dir.getAbsolutePath());
            }
            MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle) { // from class: org.eclipse.paho.android.service.MqttConnection.1
                @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken iMqttToken) {
                    MqttConnection.this.doAfterConnectSuccess(bundle);
                    MqttConnection.this.service.traceDebug(MqttConnection.TAG, "connect success!");
                }

                @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                    bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                    MqttService mqttService2 = MqttConnection.this.service;
                    mqttService2.traceError(MqttConnection.TAG, "connect fail, call connect to reconnect.reason:" + th.getMessage());
                    MqttConnection.this.doAfterConnectFail(bundle);
                }
            };
            if (this.myClient != null) {
                if (this.isConnecting) {
                    this.service.traceDebug(TAG, "myClient != null and the client is connecting. Connect return directly.");
                    MqttService mqttService2 = this.service;
                    mqttService2.traceDebug(TAG, "Connect return:isConnecting:" + this.isConnecting + ".disconnected:" + this.disconnected);
                    return;
                } else if (!this.disconnected) {
                    this.service.traceDebug(TAG, "myClient != null and the client is connected and notify!");
                    doAfterConnectSuccess(bundle);
                    return;
                } else {
                    this.service.traceDebug(TAG, "myClient != null and the client is not connected");
                    this.service.traceDebug(TAG, "Do Real connect!");
                    setConnectingState(true);
                    this.myClient.connect(this.connectOptions, str, mqttConnectionListener);
                    return;
                }
            }
            this.alarmPingSender = new AlarmPingSender(this.service, this);
            this.myClient = new CustomMqttAsyncClient(this.serverURI, this.clientId, this.persistence, this.alarmPingSender);
            this.myClient.setCallback(this);
            this.service.traceDebug(TAG, "Do Real connect!");
            setConnectingState(true);
            this.myClient.connect(this.connectOptions, str, mqttConnectionListener);
        } catch (Exception e) {
            MqttService mqttService3 = this.service;
            mqttService3.traceError(TAG, "Exception occurred attempting to connect: " + e.getMessage());
            setConnectingState(false);
            handleException(bundle, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterConnectSuccess(Bundle bundle) {
        acquireWakeLock();
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        deliverBacklog();
        setConnectingState(false);
        this.disconnected = false;
        releaseWakeLock();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
    public void connectComplete(boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_EXTENDED_ACTION);
        bundle.putBoolean(MqttServiceConstants.CALLBACK_RECONNECT, z);
        bundle.putString(MqttServiceConstants.CALLBACK_SERVER_URI, str);
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterConnectFail(Bundle bundle) {
        acquireWakeLock();
        this.disconnected = true;
        setConnectingState(false);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        releaseWakeLock();
    }

    private void handleException(Bundle bundle, Exception exc) {
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, exc.getLocalizedMessage());
        bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    private void deliverBacklog() {
        Iterator<MessageStore.StoredMessage> allArrivedMessages = this.service.messageStore.getAllArrivedMessages(this.clientHandle);
        while (allArrivedMessages.hasNext()) {
            MessageStore.StoredMessage next = allArrivedMessages.next();
            Bundle messageToBundle = messageToBundle(next.getMessageId(), next.getTopic(), next.getMessage());
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    private Bundle messageToBundle(String str, String str2, MqttMessage mqttMessage) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, str);
        bundle.putString(MqttServiceConstants.CALLBACK_DESTINATION_NAME, str2);
        bundle.putParcelable(MqttServiceConstants.CALLBACK_MESSAGE_PARCEL, new ParcelableMqttMessage(mqttMessage));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        this.service.traceDebug(TAG, "close()");
        try {
            if (this.myClient != null) {
                this.myClient.close(true);
                this.myClient = null;
            }
        } catch (MqttException e) {
            handleException(new Bundle(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void disconnect(long j, String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.DISCONNECT_ACTION);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            try {
                this.myClient.disconnect(j, str, new MqttConnectionListener(bundle));
                this.alarmPingSender.stop();
            } catch (Exception e) {
                handleException(bundle, e);
            }
        } else {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.DISCONNECT_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        }
        MqttConnectOptions mqttConnectOptions = this.connectOptions;
        if (mqttConnectOptions != null && mqttConnectOptions.isCleanSession()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void disconnect(String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.DISCONNECT_ACTION);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            try {
                this.myClient.disconnect(str, new MqttConnectionListener(bundle));
                this.alarmPingSender.stop();
            } catch (Exception e) {
                handleException(bundle, e);
            }
        } else {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.DISCONNECT_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        }
        MqttConnectOptions mqttConnectOptions = this.connectOptions;
        if (mqttConnectOptions != null && mqttConnectOptions.isCleanSession()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    public void disconnectForcibly(String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.DISCONNECT_ACTION);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            new MqttConnectionListener(bundle);
            try {
                this.myClient.disconnectForcibly(10000L, 5000L, false);
                this.alarmPingSender.stop();
            } catch (Exception e) {
                handleException(bundle, e);
            }
        } else {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.DISCONNECT_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        }
        MqttConnectOptions mqttConnectOptions = this.connectOptions;
        if (mqttConnectOptions != null && mqttConnectOptions.isCleanSession()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    public void checkPing(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, null);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle);
            try {
                if (this.myClient instanceof CustomMqttAsyncClient) {
                    ((CustomMqttAsyncClient) this.myClient).checkPing(mqttConnectionListener);
                    return;
                }
                return;
            } catch (Exception e) {
                handleException(bundle, e);
                return;
            }
        }
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
        this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public boolean isConnected() {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        return mqttAsyncClient != null && mqttAsyncClient.isConnected();
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z, String str2, String str3) {
        MqttMessage mqttMessage;
        IMqttDeliveryToken publish;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        IMqttDeliveryToken iMqttDeliveryToken = null;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle);
            try {
                mqttMessage = new MqttMessage(bArr);
                mqttMessage.setQos(i);
                mqttMessage.setRetained(z);
                publish = this.myClient.publish(str, bArr, i, z, str2, mqttConnectionListener);
            } catch (Exception e) {
                e = e;
            }
            try {
                storeSendDetails(str, mqttMessage, publish, str2, str3);
                return publish;
            } catch (Exception e2) {
                e = e2;
                iMqttDeliveryToken = publish;
                handleException(bundle, e);
                return iMqttDeliveryToken;
            }
        }
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
        this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        return null;
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, String str2, String str3) {
        DisconnectedBufferOptions disconnectedBufferOptions;
        IMqttDeliveryToken publish;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        IMqttDeliveryToken iMqttDeliveryToken = null;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            try {
                publish = this.myClient.publish(str, mqttMessage, str2, new MqttConnectionListener(bundle));
            } catch (Exception e) {
                e = e;
            }
            try {
                storeSendDetails(str, mqttMessage, publish, str2, str3);
            } catch (Exception e2) {
                e = e2;
                iMqttDeliveryToken = publish;
                handleException(bundle, e);
                return iMqttDeliveryToken;
            }
        } else if (this.myClient != null && (disconnectedBufferOptions = this.bufferOpts) != null && disconnectedBufferOptions.isBufferEnabled()) {
            try {
                publish = this.myClient.publish(str, mqttMessage, str2, new MqttConnectionListener(bundle));
            } catch (Exception e3) {
                e = e3;
            }
            try {
                storeSendDetails(str, mqttMessage, publish, str2, str3);
            } catch (Exception e4) {
                e = e4;
                iMqttDeliveryToken = publish;
                handleException(bundle, e);
                return iMqttDeliveryToken;
            }
        } else {
            Log.i(TAG, "Client is not connected, so not sending message");
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return null;
        }
        return publish;
    }

    public void subscribe(String str, int i, String str2, String str3) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "subscribe({" + str + "}," + i + ",{" + str2 + "}, {" + str3 + "}");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            try {
                this.myClient.subscribe(str, i, str2, new MqttConnectionListener(bundle));
                return;
            } catch (Exception e) {
                handleException(bundle, e);
                return;
            }
        }
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
        this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "subscribe({" + Arrays.toString(strArr) + "}," + Arrays.toString(iArr) + ",{" + str + "}, {" + str2 + "}");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            try {
                this.myClient.subscribe(strArr, iArr, str, new MqttConnectionListener(bundle));
                return;
            } catch (Exception e) {
                handleException(bundle, e);
                return;
            }
        }
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
        this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2, IMqttMessageListener[] iMqttMessageListenerArr) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "subscribe({" + Arrays.toString(strArr) + "}," + Arrays.toString(iArr) + ",{" + str + "}, {" + str2 + "}");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            new MqttConnectionListener(bundle);
            try {
                this.myClient.subscribe(strArr, iArr, iMqttMessageListenerArr);
                return;
            } catch (Exception e) {
                handleException(bundle, e);
                return;
            }
        }
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
        this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unsubscribe(String str, String str2, String str3) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "unsubscribe({" + str + "},{" + str2 + "}, {" + str3 + "})");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            try {
                this.myClient.unsubscribe(str, str2, new MqttConnectionListener(bundle));
                return;
            } catch (Exception e) {
                handleException(bundle, e);
                return;
            }
        }
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
        this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unsubscribe(String[] strArr, String str, String str2) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "unsubscribe({" + Arrays.toString(strArr) + "},{" + str + "}, {" + str2 + "})");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null && mqttAsyncClient.isConnected()) {
            try {
                this.myClient.unsubscribe(strArr, str, new MqttConnectionListener(bundle));
                return;
            } catch (Exception e) {
                handleException(bundle, e);
                return;
            }
        }
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
        this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.myClient.getPendingDeliveryTokens();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallback
    public void connectionLost(Throwable th) {
        MqttService mqttService = this.service;
        StringBuilder sb = new StringBuilder();
        sb.append("connectionLost(");
        sb.append(th == null ? "" : th.getMessage());
        sb.append(")");
        mqttService.traceDebug(TAG, sb.toString());
        this.disconnected = true;
        try {
            if (!this.connectOptions.isAutomaticReconnect()) {
                this.myClient.disconnect(null, new IMqttActionListener() { // from class: org.eclipse.paho.android.service.MqttConnection.2
                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        MqttConnection.this.service.traceDebug(MqttConnection.TAG, "disconnect onSuccess");
                    }

                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                        MqttService mqttService2 = MqttConnection.this.service;
                        mqttService2.traceDebug(MqttConnection.TAG, "disconnect onFailure, exception:" + th2);
                    }
                });
            } else {
                this.alarmPingSender.schedule(100L);
            }
        } catch (Exception e) {
            MqttService mqttService2 = this.service;
            mqttService2.traceDebug(TAG, "disconnect fail, exception:" + e);
        }
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.ON_CONNECTION_LOST_ACTION);
        if (th != null) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getMessage());
            if (th instanceof MqttException) {
                bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
            }
            bundle.putString(MqttServiceConstants.CALLBACK_EXCEPTION_STACK, Log.getStackTraceString(th));
        }
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        releaseWakeLock();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallback
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "deliveryComplete(" + iMqttDeliveryToken + ")");
        MqttMessage remove = this.savedSentMessages.remove(iMqttDeliveryToken);
        if (remove != null) {
            String remove2 = this.savedActivityTokens.remove(iMqttDeliveryToken);
            String remove3 = this.savedInvocationContexts.remove(iMqttDeliveryToken);
            Bundle messageToBundle = messageToBundle(null, this.savedTopics.remove(iMqttDeliveryToken), remove);
            if (remove2 != null) {
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, remove2);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, remove3);
                this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
            }
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_DELIVERED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallback
    public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "messageArrived(" + str + ",{" + mqttMessage.toString() + "})");
        String storeArrived = this.service.messageStore.storeArrived(this.clientHandle, str, mqttMessage);
        Bundle messageToBundle = messageToBundle(storeArrived, str, mqttMessage);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, storeArrived);
        this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
    }

    private void storeSendDetails(String str, MqttMessage mqttMessage, IMqttDeliveryToken iMqttDeliveryToken, String str2, String str3) {
        this.savedTopics.put(iMqttDeliveryToken, str);
        this.savedSentMessages.put(iMqttDeliveryToken, mqttMessage);
        this.savedActivityTokens.put(iMqttDeliveryToken, str3);
        this.savedInvocationContexts.put(iMqttDeliveryToken, str2);
    }

    private void acquireWakeLock() {
        if (this.wakelock == null) {
            this.wakelock = ((PowerManager) this.service.getSystemService("power")).newWakeLock(1, this.wakeLockTag);
        }
        this.wakelock.acquire();
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.wakelock.release();
    }

    /* loaded from: classes3.dex */
    private class MqttConnectionListener implements IMqttActionListener {
        private final Bundle resultBundle;

        private MqttConnectionListener(Bundle bundle) {
            this.resultBundle = bundle;
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onSuccess(IMqttToken iMqttToken) {
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.OK, this.resultBundle);
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            this.resultBundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
            this.resultBundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, this.resultBundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void offline() {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "start offline. disconnected:" + this.disconnected + " cleanSession:" + this.cleanSession);
        if (this.disconnected || this.cleanSession) {
            return;
        }
        connectionLost(new Exception("Android offline"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void reconnect() {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "start reconnect, disconnected:" + this.disconnected + " cleanSession:" + this.cleanSession);
        if (this.myClient == null) {
            this.service.traceError(TAG, "Reconnect myClient = null. Will not do reconnect");
        } else if (this.isConnecting) {
            this.service.traceDebug(TAG, "The client is connecting. Reconnect return directly.");
        } else if (!this.service.isOnline()) {
            this.service.traceDebug(TAG, "The network is not reachable. Will not do reconnect");
        } else {
            if (this.connectOptions.isAutomaticReconnect()) {
                this.service.traceDebug(TAG, "Requesting Automatic reconnect using New Java AC");
                Bundle bundle = new Bundle();
                bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
                bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, null);
                bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
                try {
                    this.myClient.reconnect();
                } catch (MqttException e) {
                    Log.e(TAG, "Exception occurred attempting to reconnect: " + e.getMessage());
                    setConnectingState(false);
                    handleException(bundle, e);
                }
                return;
            }
            if (this.disconnected && !this.cleanSession) {
                this.service.traceDebug(TAG, "Do Real Reconnect!");
                final Bundle bundle2 = new Bundle();
                bundle2.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
                bundle2.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, null);
                bundle2.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
                try {
                    try {
                        this.myClient.connect(this.connectOptions, null, new MqttConnectionListener(bundle2) { // from class: org.eclipse.paho.android.service.MqttConnection.3
                            @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, org.eclipse.paho.client.mqttv3.IMqttActionListener
                            public void onSuccess(IMqttToken iMqttToken) {
                                MqttConnection.this.service.traceDebug(MqttConnection.TAG, "Reconnect Success!");
                                MqttConnection.this.service.traceDebug(MqttConnection.TAG, "DeliverBacklog when reconnect.");
                                MqttConnection.this.doAfterConnectSuccess(bundle2);
                            }

                            @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, org.eclipse.paho.client.mqttv3.IMqttActionListener
                            public void onFailure(IMqttToken iMqttToken, Throwable th) {
                                bundle2.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                                bundle2.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                                MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, bundle2);
                                MqttConnection.this.doAfterConnectFail(bundle2);
                            }
                        });
                        setConnectingState(true);
                    } catch (Exception e2) {
                        MqttService mqttService2 = this.service;
                        mqttService2.traceError(TAG, "Cannot reconnect to remote server." + e2.getMessage());
                        setConnectingState(false);
                        handleException(bundle2, new MqttException(6, e2.getCause()));
                    }
                } catch (MqttException e3) {
                    MqttService mqttService3 = this.service;
                    mqttService3.traceError(TAG, "Cannot reconnect to remote server." + e3.getMessage());
                    setConnectingState(false);
                    handleException(bundle2, e3);
                }
            }
            return;
        }
    }

    private synchronized void setConnectingState(boolean z) {
        this.isConnecting = z;
    }

    public void setBufferOpts(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.bufferOpts = disconnectedBufferOptions;
        this.myClient.setBufferOpts(disconnectedBufferOptions);
    }

    public int getBufferedMessageCount() {
        return this.myClient.getBufferedMessageCount();
    }

    public MqttMessage getBufferedMessage(int i) {
        return this.myClient.getBufferedMessage(i);
    }

    public void deleteBufferedMessage(int i) {
        this.myClient.deleteBufferedMessage(i);
    }
}
