package com.xiaopeng.montecarlo.navcore.location.sensor;

import android.os.Handler;
import com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.net.DatagramSocket;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
/* loaded from: classes3.dex */
public class UbxSensor implements IXpSensor {
    private static final int ADR_COMMAND_DISABLE_ADR = 0;
    private static final int ADR_COMMAND_ENABLE_ADR = 1;
    private static final int ADR_COMMAND_IDLE = -1;
    private static final int CLIENT_PORT = 29947;
    private static final int ERROR_RETRY_TIMEOUT = 5000;
    private static final int FAILURE_REASON_CREATE_SOCKET = 1;
    private static final int FAILURE_REASON_DISCONNECT_FROM_SERVER = 5;
    private static final int FAILURE_REASON_GET_SERVER_HOST_NAME = 2;
    private static final int FAILURE_REASON_SEND_ADR_CLOSE_COMMAND = 7;
    private static final int FAILURE_REASON_SEND_ADR_OPEN_COMMAND = 8;
    private static final int FAILURE_REASON_SEND_RST_UBX_COMMAND = 9;
    private static final int FAILURE_REASON_SEND_SERVER_START_COMMAND = 4;
    private static final int FAILURE_REASON_SEND_SERVER_STOP_COMMAND = 6;
    private static final int FAILURE_REASON_SET_SOCKET_TIME_OUT = 3;
    private static final int FAILURE_REASON_TIMEOUT_RECEIVE_FROM_UDP_SERVER = 10;
    private static final int FIRST_TIME_RETRY_MAX_NUM = 600;
    private static final float INVALID_TEMPERATURE = -274.0f;
    private static final int RECEIVE_BUF_MAX_SIZE = 1024;
    private static final int RECEIVE_PACKAGE_RETRY_MAX_NUM = 10;
    private static final int RST_COMMAND_DISABLE = 0;
    private static final int RST_COMMAND_ENABLE = 1;
    private static final int RST_COMMAND_IDLE = -1;
    private static final int SERVER_PORT = 29946;
    private static final int SOCKET_TIMEOUT = 500;
    private static final int UBLOX_EFS_ALG = 1000;
    private Handler mHandler;
    private IXpSensor.ISensorListener mListener;
    private DatagramSocket mUDPSocket;
    private static final L.Tag TAG = new L.Tag("UDPClient");
    private static final byte[] START_COMMAND = {TarConstants.LF_PAX_EXTENDED_HEADER_UC, 1, 16};
    private static final byte[] STOP_COMMAND = {TarConstants.LF_PAX_EXTENDED_HEADER_UC, 3};
    private static final byte[] PING_COMMAND = {TarConstants.LF_PAX_EXTENDED_HEADER_UC, 0};
    private static final byte[] UBX_CLOSE_ADR = {-75, 98, 6, 35, 44, 0, -1, -1, TarConstants.LF_GNUTYPE_LONGNAME, 102, -64, 0, 0, 0, 0, 0, 5, 24, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 0, 0, 0, 0, TarConstants.LF_GNUTYPE_LONGLINK, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -92, -13};
    private static final byte[] UBX_OPEN_ADR = {-75, 98, 6, 35, 44, 0, -1, -1, TarConstants.LF_GNUTYPE_LONGNAME, 102, -64, 0, 0, 0, 0, 0, 5, 24, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 0, 0, 0, 0, TarConstants.LF_GNUTYPE_LONGLINK, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, -91, -8};
    private static final byte[] UBX_RST_USER_CONFIG = {-75, 98, 6, 4, 4, 0, -4, -71, 2, 0, -59, -125};
    private static UbxSensor sUDPClient = new UbxSensor();
    private boolean mIsStarted = false;
    private int mNeedSendADRCommand = -1;
    private int mNeedSendRSTCommand = -1;
    private int mFailureCounter = 0;
    private int mFailureReason = 0;
    private Runnable mSocketHandlerRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.sensor.UbxSensor.1
        /* JADX WARN: Removed duplicated region for block: B:201:0x04bb A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.location.sensor.UbxSensor.AnonymousClass1.run():void");
        }
    };

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void setRawData(boolean z, boolean z2, float[] fArr, long j) {
    }

    static /* synthetic */ int access$108(UbxSensor ubxSensor) {
        int i = ubxSensor.mFailureCounter;
        ubxSensor.mFailureCounter = i + 1;
        return i;
    }

    public static UbxSensor getInstance() {
        return sUDPClient;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void setClientListener(IXpSensor.ISensorListener iSensorListener) {
        this.mListener = iSensorListener;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void enableADR(boolean z) {
        if (z) {
            this.mNeedSendADRCommand = 1;
        } else {
            this.mNeedSendADRCommand = 0;
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void enableUbxReset(boolean z) {
        if (z) {
            this.mNeedSendRSTCommand = 1;
        } else {
            this.mNeedSendRSTCommand = 0;
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void open() {
        if (this.mIsStarted) {
            return;
        }
        this.mHandler = new Handler(WorkThreadUtil.getInstance().getUDPClientThreadLooper());
        this.mIsStarted = true;
        L.i(TAG, "open ublox sensor");
        this.mHandler.post(this.mSocketHandlerRunnable);
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void close() {
        if (this.mIsStarted) {
            this.mIsStarted = false;
            this.mUDPSocket.close();
            this.mHandler.removeCallbacks(this.mSocketHandlerRunnable);
        }
        this.mListener = null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public IXpSensor.XPSensorType getSensorType() {
        return IXpSensor.XPSensorType.SENSOR_TYPE_UBX;
    }
}
