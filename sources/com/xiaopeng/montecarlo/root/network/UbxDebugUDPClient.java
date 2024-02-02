package com.xiaopeng.montecarlo.root.network;

import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
/* loaded from: classes2.dex */
public class UbxDebugUDPClient {
    private static final float AGC_PERCENT = 100.0f;
    private static final float AGC_RANGE = 8191.0f;
    private static final byte CLIENT_MUX_ENABLED = 4;
    private static final byte CLIENT_NMEA_ENABLED = 1;
    private static final int CLIENT_PORT = 29948;
    private static final byte CLIENT_UBX_ENABLED = 2;
    private static final int DEBUG_COMMAND_DISABLE = 0;
    private static final int DEBUG_COMMAND_ENABLE = 1;
    private static final int DEBUG_COMMAND_IDLE = -1;
    private static final int DELTA_TIME_10MIN = 600000;
    private static final int DOWN_UBX_DEBUG_LOG_DISABLE = 0;
    private static final int DOWN_UBX_DEBUG_LOG_ENABLE = 1;
    private static final int ERROR_RETRY_TIMEOUT = 5000;
    private static final int FAILURE_REASON_CREATE_SOCKET = 1;
    private static final int FAILURE_REASON_DISCONNECT_FROM_SERVER = 5;
    private static final int FAILURE_REASON_GET_SERVER_HOST_NAME = 2;
    private static final int FAILURE_REASON_POLL_MON_HW_AGC_COMMAND = 11;
    private static final int FAILURE_REASON_SEND_DEBUG_UBX_COMMAND = 10;
    private static final int FAILURE_REASON_SEND_SERVER_START_COMMAND = 4;
    private static final int FAILURE_REASON_SEND_SERVER_STOP_COMMAND = 6;
    private static final int FAILURE_REASON_SET_SOCKET_TIME_OUT = 3;
    private static final int FAILURE_REASON_START_UBX_DATA_COMMAND = 12;
    private static final int FAILURE_REASON_TIMEOUT_RECEIVE_FROM_UDP_SERVER = 11;
    private static final int FIRST_TIME_RETRY_MAX_NUM = 600;
    private static final byte MSG_CLASS = 10;
    private static final byte MSG_ID = 9;
    private static final int POLL_MON_HW_AGC_COMMAND_DISABLE = 0;
    private static final int POLL_MON_HW_AGC_COMMAND_ENABLE = 1;
    private static final int POLL_MON_HW_AGC_COMMAND_IDLE = -1;
    private static final int RECEIVE_BUF_MAX_SIZE = 1024;
    private static final int RECEIVE_PACKAGE_RETRY_MAX_NUM = 10;
    private static final int SERVER_PORT = 46434;
    private static final int SOCKET_TIMEOUT = 500;
    private static final int START_UBX_DATA_COMMAND_DISABLE = 0;
    private static final int START_UBX_DATA_COMMAND_ENABLE = 1;
    private static final int START_UBX_DATA_COMMAND_IDLE = -1;
    private static final int SUM_AGC_CNT_MAX = 10;
    private static final int UDP_FAILURE_COUNTER_DEFAULT = 0;
    private static final int UDP_FAILURE_REASON_DEFAULT = 0;
    private static final byte UDP_MUX_END_SESSION = 3;
    private static final byte UDP_MUX_PACKET_HEADER = 88;
    private static final byte UDP_MUX_PING = 0;
    private static final byte UDP_MUX_START_SESSION = 1;
    private DatagramSocket mUbxDebugUDPSocket;
    private static final L.Tag TAG = new L.Tag("UbxDebugUDPClient");
    private static final byte[] START_MUX_COMMAND = {88, 1, 4};
    private static final byte[] START_NMEA_COMMAND = {88, 1, 1};
    private static final byte[] START_UBX_COMMAND = {88, 1, 2};
    private static final byte[] STOP_COMMAND = {88, 3};
    private static final byte[] PING_COMMAND = {88, 0};
    private static final byte MSG_HEADER_1 = -75;
    private static final byte MSG_HEADER_2 = 98;
    private static final byte[] UBX_MON_HW_AGC = {MSG_HEADER_1, MSG_HEADER_2, 10, 9};
    private static final byte CLIENT_SENSOR_ENABLED = 16;
    private static final byte[] UBX_DEBUG_CONFFIG = {MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 3, 15, 1, 29, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 3, CLIENT_SENSOR_ENABLED, 1, 30, 105, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, MqttWireMessage.MESSAGE_TYPE_PINGREQ, CLIENT_SENSOR_ENABLED, 1, 39, -124, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, MqttWireMessage.MESSAGE_TYPE_PINGREQ, TarConstants.LF_LINK, 1, 72, -58, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 3, 9, 1, 23, 91, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 3, 17, 1, 31, 107, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 2, 87, 1, 100, -12, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 10, 38, 1, 59, -86, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 10, 6, 1, 27, 106, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 1, 34, 1, 46, -121, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 1, 6, 1, 18, 79, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 1, TarConstants.LF_NORMAL, 1, 60, -93, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 1, 7, 1, 19, 81, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 1, 3, 1, 15, 73, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 1, TarConstants.LF_BLK, 1, 64, -85, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, MqttWireMessage.MESSAGE_TYPE_PINGREQ, TarConstants.LF_BLK, 1, TarConstants.LF_GNUTYPE_LONGLINK, -52, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, CLIENT_SENSOR_ENABLED, 2, 1, 29, 116, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, CLIENT_SENSOR_ENABLED, 20, 1, 47, -104, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, CLIENT_SENSOR_ENABLED, CLIENT_SENSOR_ENABLED, 1, 43, -112, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, CLIENT_SENSOR_ENABLED, 17, 1, 44, -110, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 10, 9, 1, 30, 112, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, 9, 19, 1, 39, -127, MSG_HEADER_1, MSG_HEADER_2, 6, 1, 3, 0, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 6, 1, 30, 115};
    private static final byte[] UBX_POLL_MON_HW_AGC = {MSG_HEADER_1, MSG_HEADER_2, 10, 9, 0, 0, 19, 67};
    private static UbxDebugUDPClient sUbxDebugUDPClient = new UbxDebugUDPClient();
    private int mNeedPollMonHwAgcCommand = -1;
    private float mSumAGC = 0.0f;
    private int mSumAGCCnt = 0;
    private boolean mSendStopCommandEnable = false;
    private int mNeedStartUbxDataCommand = -1;
    private volatile boolean mIsStarted = false;
    private long mLastTime = 0;
    private int mNeedSendDebugCommand = -1;
    private int mDownUbxDebugDataFlag = 0;
    private int mFailureCounter = 0;
    private int mFailureReason = 0;
    private Runnable mUbxDebugSocketHandlerRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.root.network.UbxDebugUDPClient.1
        @Override // java.lang.Runnable
        public void run() {
            int i;
            L.i(UbxDebugUDPClient.TAG, "start ubx debug socket handler runnable");
            while (UbxDebugUDPClient.this.mIsStarted) {
                L.i(UbxDebugUDPClient.TAG, "Failure counter = " + UbxDebugUDPClient.this.mFailureCounter + ", Failure reason = " + UbxDebugUDPClient.this.mFailureReason);
                byte[] bArr = new byte[1024];
                try {
                    UbxDebugUDPClient.this.mUbxDebugUDPSocket = new DatagramSocket((SocketAddress) null);
                    UbxDebugUDPClient.this.mUbxDebugUDPSocket.setReuseAddress(true);
                    UbxDebugUDPClient.this.mUbxDebugUDPSocket.bind(new InetSocketAddress(UbxDebugUDPClient.CLIENT_PORT));
                    try {
                        InetAddress byName = InetAddress.getByName("127.0.0.1");
                        DatagramPacket datagramPacket = new DatagramPacket(UbxDebugUDPClient.START_UBX_COMMAND, 0, UbxDebugUDPClient.START_UBX_COMMAND.length, byName, UbxDebugUDPClient.SERVER_PORT);
                        DatagramPacket datagramPacket2 = new DatagramPacket(bArr, 1024);
                        try {
                            UbxDebugUDPClient.this.mUbxDebugUDPSocket.setSoTimeout(500);
                            int i2 = 0;
                            int i3 = 0;
                            boolean z = false;
                            while (!z && i3 < 600) {
                                try {
                                    UbxDebugUDPClient.this.mUbxDebugUDPSocket.send(datagramPacket);
                                    try {
                                        UbxDebugUDPClient.this.mUbxDebugUDPSocket.receive(datagramPacket2);
                                        if (datagramPacket2.getAddress().equals(byName)) {
                                            z = true;
                                        } else {
                                            L.e(UbxDebugUDPClient.TAG, "Received packet from an unknown source: " + datagramPacket2.getAddress());
                                        }
                                    } catch (InterruptedIOException unused) {
                                        i3++;
                                        if (L.ENABLE) {
                                            L.d(UbxDebugUDPClient.TAG, "Time out," + (600 - i3) + " more tries...");
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (!z) {
                                L.e(UbxDebugUDPClient.TAG, "Server not response, try again");
                                try {
                                    Thread.sleep(UILooperObserver.ANR_TRIGGER_TIME);
                                } catch (InterruptedException e3) {
                                    L.w(UbxDebugUDPClient.TAG, e3.getMessage());
                                }
                                UbxDebugUDPClient.this.mUbxDebugUDPSocket.close();
                                UbxDebugUDPClient.access$208(UbxDebugUDPClient.this);
                                UbxDebugUDPClient.this.mFailureReason = 4;
                            } else {
                                L.Tag tag = UbxDebugUDPClient.TAG;
                                L.i(tag, "Received data " + (new String(datagramPacket2.getData(), 0, datagramPacket2.getLength()) + " from: " + datagramPacket2.getAddress().getHostAddress() + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + datagramPacket2.getPort()));
                                datagramPacket2.setLength(1024);
                                L.i(UbxDebugUDPClient.TAG, "Getting into main handler loop of udp client socket");
                                int i4 = 0;
                                while (true) {
                                    if (UbxDebugUDPClient.this.mIsStarted) {
                                        if (1 != UbxDebugUDPClient.this.mNeedPollMonHwAgcCommand || UbxDebugUDPClient.this.mSendStopCommandEnable) {
                                            i = i2;
                                        } else {
                                            i = i2;
                                            try {
                                                UbxDebugUDPClient.this.mUbxDebugUDPSocket.send(new DatagramPacket(UbxDebugUDPClient.UBX_POLL_MON_HW_AGC, 0, UbxDebugUDPClient.UBX_POLL_MON_HW_AGC.length, byName, UbxDebugUDPClient.SERVER_PORT));
                                                UbxDebugUDPClient.this.mNeedPollMonHwAgcCommand = -1;
                                                L.i(UbxDebugUDPClient.TAG, "Poll MON HW AGC is done");
                                            } catch (IOException unused2) {
                                                L.i(UbxDebugUDPClient.TAG, "Failed to Poll MON HW AGC command");
                                                UbxDebugUDPClient.access$208(UbxDebugUDPClient.this);
                                                UbxDebugUDPClient.this.mFailureReason = 11;
                                            }
                                        }
                                        datagramPacket2.setLength(1024);
                                        if (!UbxDebugUDPClient.this.mSendStopCommandEnable) {
                                            try {
                                                UbxDebugUDPClient.this.mUbxDebugUDPSocket.receive(datagramPacket2);
                                            } catch (SocketTimeoutException unused3) {
                                                L.e(UbxDebugUDPClient.TAG, "Time out during receiving from the UDP server");
                                                UbxDebugUDPClient.access$208(UbxDebugUDPClient.this);
                                                UbxDebugUDPClient.this.mFailureReason = 11;
                                                int i5 = i4 + 1;
                                                if (i4 < 10) {
                                                    if (L.ENABLE) {
                                                        L.d(UbxDebugUDPClient.TAG, "try again");
                                                    }
                                                    i4 = i5;
                                                    i2 = i;
                                                } else if (L.ENABLE) {
                                                    L.d(UbxDebugUDPClient.TAG, "reach to max try times, go out of main handler");
                                                }
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        }
                                        byte[] data = datagramPacket2.getData();
                                        if (2 == datagramPacket2.getLength() && UbxDebugUDPClient.PING_COMMAND[i] == data[i] && UbxDebugUDPClient.PING_COMMAND[1] == data[1]) {
                                            try {
                                                UbxDebugUDPClient.this.mUbxDebugUDPSocket.send(new DatagramPacket(UbxDebugUDPClient.PING_COMMAND, 0, 2, byName, UbxDebugUDPClient.SERVER_PORT));
                                            } catch (IOException e5) {
                                                e5.printStackTrace();
                                            }
                                        } else if (data != null && data.length >= 26 && !UbxDebugUDPClient.this.mSendStopCommandEnable && UbxDebugUDPClient.UBX_MON_HW_AGC[i] == data[i] && UbxDebugUDPClient.UBX_MON_HW_AGC[1] == data[1] && UbxDebugUDPClient.UBX_MON_HW_AGC[2] == data[2]) {
                                            if (UbxDebugUDPClient.UBX_MON_HW_AGC[3] == data[3]) {
                                                String hexString = Integer.toHexString(data[25] & 255);
                                                String hexString2 = Integer.toHexString(data[24] & 255);
                                                int i6 = ((data[24] & 255) | ((data[25] & 255) << 8)) & 65535;
                                                float f = (i6 * UbxDebugUDPClient.AGC_PERCENT) / UbxDebugUDPClient.AGC_RANGE;
                                                UbxDebugUDPClient.access$1108(UbxDebugUDPClient.this);
                                                UbxDebugUDPClient.this.mSumAGC += f;
                                                L.i(UbxDebugUDPClient.TAG, "UBX MON HW AGC is :" + f + "%, agcMonitor:" + i6 + ",data[25]:" + hexString + ",data[24]:" + hexString2);
                                                if (UbxDebugUDPClient.this.mSumAGCCnt >= 10) {
                                                    try {
                                                        UbxDebugUDPClient.this.mUbxDebugUDPSocket.send(new DatagramPacket(UbxDebugUDPClient.STOP_COMMAND, 0, UbxDebugUDPClient.STOP_COMMAND.length, byName, UbxDebugUDPClient.SERVER_PORT));
                                                        UbxDebugUDPClient.this.mSendStopCommandEnable = true;
                                                        L.i(UbxDebugUDPClient.TAG, "send stop command is ok");
                                                    } catch (IOException e6) {
                                                        e6.printStackTrace();
                                                        L.e(UbxDebugUDPClient.TAG, "Send STOP_COMMAND failed, try again");
                                                    }
                                                }
                                            }
                                            i4 = i;
                                            i2 = i4;
                                        }
                                        i4 = i;
                                        i2 = i4;
                                    }
                                }
                            }
                        } catch (SocketException e7) {
                            L.e(UbxDebugUDPClient.TAG, "Can not setSoTimeout");
                            e7.printStackTrace();
                            try {
                                Thread.sleep(UILooperObserver.ANR_TRIGGER_TIME);
                            } catch (InterruptedException e8) {
                                L.w(UbxDebugUDPClient.TAG, e8.getMessage());
                            }
                            UbxDebugUDPClient.this.mUbxDebugUDPSocket.close();
                            UbxDebugUDPClient.access$208(UbxDebugUDPClient.this);
                            UbxDebugUDPClient.this.mFailureReason = 3;
                        }
                    } catch (UnknownHostException e9) {
                        L.e(UbxDebugUDPClient.TAG, "Can not getByName 127.0.0.1");
                        e9.printStackTrace();
                        try {
                            Thread.sleep(UILooperObserver.ANR_TRIGGER_TIME);
                        } catch (InterruptedException e10) {
                            L.w(UbxDebugUDPClient.TAG, e10.getMessage());
                        }
                        UbxDebugUDPClient.this.mUbxDebugUDPSocket.close();
                        UbxDebugUDPClient.access$208(UbxDebugUDPClient.this);
                        UbxDebugUDPClient.this.mFailureReason = 2;
                    }
                } catch (SocketException e11) {
                    L.e(UbxDebugUDPClient.TAG, "Can not create udp socket with port: 29948");
                    e11.printStackTrace();
                    try {
                        Thread.sleep(UILooperObserver.ANR_TRIGGER_TIME);
                    } catch (InterruptedException e12) {
                        L.w(UbxDebugUDPClient.TAG, e12.getMessage());
                    }
                    UbxDebugUDPClient.access$208(UbxDebugUDPClient.this);
                    UbxDebugUDPClient.this.mFailureReason = 1;
                }
            }
            L.e(UbxDebugUDPClient.TAG, "Exit the mSocketHandlerRunnable thread.");
        }
    };

    public UbxDebugUDPClient setDownUbxDebugDataFlag(int i) {
        this.mDownUbxDebugDataFlag = i;
        return this;
    }

    public UbxDebugUDPClient setFailureCounter(int i) {
        this.mFailureCounter = i;
        return this;
    }

    public UbxDebugUDPClient setFailureReason(int i) {
        this.mFailureReason = i;
        return this;
    }

    public UbxDebugUDPClient setLastTime(long j) {
        this.mLastTime = j;
        return this;
    }

    public UbxDebugUDPClient setNeedPollMonHwAgcCommand(int i) {
        this.mNeedPollMonHwAgcCommand = i;
        return this;
    }

    public UbxDebugUDPClient setNeedSendDebugCommand(int i) {
        this.mNeedSendDebugCommand = i;
        return this;
    }

    public UbxDebugUDPClient setNeedStartUbxDataCommand(int i) {
        this.mNeedStartUbxDataCommand = i;
        return this;
    }

    public UbxDebugUDPClient setSendStopCommandEnable(boolean z) {
        this.mSendStopCommandEnable = z;
        return this;
    }

    public UbxDebugUDPClient setStarted(boolean z) {
        this.mIsStarted = z;
        return this;
    }

    public UbxDebugUDPClient setSumAGC(float f) {
        this.mSumAGC = f;
        return this;
    }

    public UbxDebugUDPClient setSumAGCCnt(int i) {
        this.mSumAGCCnt = i;
        return this;
    }

    public UbxDebugUDPClient setUbxDebugSocketHandlerRunnable(Runnable runnable) {
        this.mUbxDebugSocketHandlerRunnable = runnable;
        return this;
    }

    public UbxDebugUDPClient setUbxDebugUDPSocket(DatagramSocket datagramSocket) {
        this.mUbxDebugUDPSocket = datagramSocket;
        return this;
    }

    static /* synthetic */ int access$1108(UbxDebugUDPClient ubxDebugUDPClient) {
        int i = ubxDebugUDPClient.mSumAGCCnt;
        ubxDebugUDPClient.mSumAGCCnt = i + 1;
        return i;
    }

    static /* synthetic */ int access$208(UbxDebugUDPClient ubxDebugUDPClient) {
        int i = ubxDebugUDPClient.mFailureCounter;
        ubxDebugUDPClient.mFailureCounter = i + 1;
        return i;
    }

    public int getNeedPollMonHwAgcCommand() {
        return this.mNeedPollMonHwAgcCommand;
    }

    public float getSumAGC() {
        return this.mSumAGC;
    }

    public int getSumAGCCnt() {
        return this.mSumAGCCnt;
    }

    public boolean isSendStopCommandEnable() {
        return this.mSendStopCommandEnable;
    }

    public int getNeedStartUbxDataCommand() {
        return this.mNeedStartUbxDataCommand;
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }

    public DatagramSocket getUbxDebugUDPSocket() {
        return this.mUbxDebugUDPSocket;
    }

    public long getLastTime() {
        return this.mLastTime;
    }

    public int getNeedSendDebugCommand() {
        return this.mNeedSendDebugCommand;
    }

    public int getDownUbxDebugDataFlag() {
        return this.mDownUbxDebugDataFlag;
    }

    public int getFailureCounter() {
        return this.mFailureCounter;
    }

    public int getFailureReason() {
        return this.mFailureReason;
    }

    public Runnable getUbxDebugSocketHandlerRunnable() {
        return this.mUbxDebugSocketHandlerRunnable;
    }

    public void enableUbxDebug(boolean z) {
        if (z) {
            this.mNeedSendDebugCommand = 1;
        } else {
            this.mNeedSendDebugCommand = 0;
        }
    }

    public void enablePollMonHwAgc(boolean z) {
        if (z) {
            this.mNeedPollMonHwAgcCommand = 1;
        } else {
            this.mNeedPollMonHwAgcCommand = 0;
        }
    }

    public void enableStartUbxData(boolean z) {
        if (z) {
            this.mNeedStartUbxDataCommand = 1;
        } else {
            this.mNeedStartUbxDataCommand = 0;
        }
    }

    public void open() {
        if (this.mIsStarted) {
            return;
        }
        this.mIsStarted = true;
        WorkThreadUtil.getInstance().executeCachedTask(this.mUbxDebugSocketHandlerRunnable);
    }

    public void close() {
        this.mIsStarted = false;
        this.mSendStopCommandEnable = false;
        this.mNeedPollMonHwAgcCommand = -1;
        this.mFailureCounter = 0;
        this.mFailureReason = 0;
        DatagramSocket datagramSocket = this.mUbxDebugUDPSocket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
        L.i(TAG, "remove ubx debug Runnable");
    }
}
