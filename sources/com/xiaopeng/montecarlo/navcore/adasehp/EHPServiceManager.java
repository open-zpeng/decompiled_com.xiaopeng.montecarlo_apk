package com.xiaopeng.montecarlo.navcore.adasehp;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.autonavi.gbl.ehp.observer.IEHPOutputObserver;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EHPServiceManager implements IEHPOutputObserver {
    private static final int LOG_CONTROL_LIMIT = 600;
    private static final L.Tag TAG = new L.Tag("EHPServiceManager");
    private static final EHPServiceManager sInstance = new EHPServiceManager();
    private static final byte[] START_JSON = "{\"msgType\":\"".getBytes(StandardCharsets.UTF_8);
    private static final byte[] MID_JSON = "\",\"msgValue\":".getBytes(StandardCharsets.UTF_8);
    private static final byte[] END_JSON = "}".getBytes(StandardCharsets.UTF_8);
    private volatile boolean mInitialized = false;
    private Socket mSocket = null;
    private boolean mIsSendBySocket = false;
    private int mLogCounter = 0;
    private final EHPServiceWrapper mEHPServiceWrapper = new EHPServiceWrapper();
    private final Handler mEhpHandler = new Handler(WorkThreadUtil.getInstance().getEHPServiceThreadLooper());

    private EHPServiceManager() {
    }

    @NonNull
    public static EHPServiceManager getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] convertByte(String str, byte[] bArr) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArr2 = START_JSON;
        byte[] bArr3 = new byte[bArr2.length + bytes.length + MID_JSON.length + bArr.length + END_JSON.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        int length = START_JSON.length + 0;
        System.arraycopy(bytes, 0, bArr3, length, bytes.length);
        int length2 = length + bytes.length;
        byte[] bArr4 = MID_JSON;
        System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
        int length3 = length2 + MID_JSON.length;
        System.arraycopy(bArr, 0, bArr3, length3, bArr.length);
        int length4 = length3 + bArr.length;
        byte[] bArr5 = END_JSON;
        System.arraycopy(bArr5, 0, bArr3, length4, bArr5.length);
        return bArr3;
    }

    public boolean init(boolean z) {
        if (this.mInitialized || !CarServiceManager.getInstance().hasXpuForNgp()) {
            return false;
        }
        this.mInitialized = this.mEHPServiceWrapper.init(z);
        L.Tag tag = TAG;
        L.i(tag, "EHPService init = " + this.mInitialized);
        if (this.mInitialized) {
            this.mEHPServiceWrapper.addEhpOutputObserver(this);
            this.mEHPServiceWrapper.setAutoUpdateRoute(2 == TBTManager.getInstance().getCurrentStatus());
        }
        this.mIsSendBySocket = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SEND_V2_DATA_BY_SOCKET, false);
        this.mEhpHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.adasehp.EHPServiceManager.1
            @Override // java.lang.Runnable
            public void run() {
                EHPServiceManager.this.connectSocket();
            }
        });
        return this.mInitialized;
    }

    public void setIsSendV2DataBySocket(boolean z) {
        this.mIsSendBySocket = z;
    }

    public boolean setConfigValue(int i, int i2) {
        EHPServiceWrapper eHPServiceWrapper;
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn() && (eHPServiceWrapper = this.mEHPServiceWrapper) != null) {
            return eHPServiceWrapper.setConfigValue(i, i2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectSocket() {
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn() && this.mIsSendBySocket) {
            Socket socket = this.mSocket;
            if (socket == null || !socket.isConnected()) {
                if (this.mSocket == null) {
                    this.mSocket = new Socket();
                }
                try {
                    this.mSocket.connect(new InetSocketAddress("172.20.1.22", Integer.valueOf("8989").intValue()));
                    L.Tag tag = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("EHPService connectSocket isConnect = ");
                    sb.append(this.mSocket != null && this.mSocket.isConnected());
                    L.i(tag, sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disConnectSocket() {
        Socket socket;
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn() && this.mIsSendBySocket && (socket = this.mSocket) != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mSocket = null;
        }
    }

    public boolean uninit() {
        if (this.mInitialized) {
            this.mInitialized = false;
            disConnectSocket();
            this.mEHPServiceWrapper.removeEhpOutputObserver(this);
            return this.mEHPServiceWrapper.uninit();
        }
        return false;
    }

    public boolean setAutoUpdateRoute(boolean z) {
        EHPServiceWrapper eHPServiceWrapper;
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn() && (eHPServiceWrapper = this.mEHPServiceWrapper) != null) {
            return eHPServiceWrapper.setAutoUpdateRoute(z);
        }
        return false;
    }

    public void updateNetworkStatus(int i) {
        EHPServiceWrapper eHPServiceWrapper;
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn() && (eHPServiceWrapper = this.mEHPServiceWrapper) != null) {
            eHPServiceWrapper.updateNetworkStatus(i);
        }
    }

    public boolean beforeMapDataOperation(ArrayList<Integer> arrayList, int i) {
        EHPServiceWrapper eHPServiceWrapper;
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn() && (eHPServiceWrapper = this.mEHPServiceWrapper) != null) {
            return eHPServiceWrapper.beforeMapDataOperation(arrayList, i);
        }
        return false;
    }

    public boolean afterMapDataOperation(ArrayList<Integer> arrayList, int i) {
        EHPServiceWrapper eHPServiceWrapper;
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn() && (eHPServiceWrapper = this.mEHPServiceWrapper) != null) {
            return eHPServiceWrapper.afterMapDataOperation(arrayList, i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.ehp.observer.IEHPOutputObserver
    public void output(final String str, final byte[] bArr) {
        if (this.mInitialized && CarServiceManager.getInstance().isNGPOn()) {
            if (this.mLogCounter % 600 == 0) {
                L.i(TAG, "EHPService output key = " + str + " value = " + new String(bArr) + " mIsSendBySocket = " + this.mIsSendBySocket);
                this.mLogCounter = 0;
            } else if (L.ENABLE) {
                L.d(TAG, "EHPService output key = " + str + " value = " + new String(bArr) + " mIsSendBySocket = " + this.mIsSendBySocket);
            }
            this.mLogCounter++;
            this.mEhpHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.adasehp.EHPServiceManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!EHPServiceManager.this.mIsSendBySocket) {
                        CarServiceManager.getInstance().sendSrRdCdu2XpuNgpTrajectoryV2Data(EHPServiceManager.convertByte(str, bArr));
                        return;
                    }
                    if (L.ENABLE) {
                        L.Tag tag = EHPServiceManager.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("EHPService output by socket isConnect = ");
                        sb.append(EHPServiceManager.this.mSocket != null && EHPServiceManager.this.mSocket.isConnected());
                        L.d(tag, sb.toString());
                    }
                    if (EHPServiceManager.this.mSocket == null || !EHPServiceManager.this.mSocket.isConnected()) {
                        EHPServiceManager.this.connectSocket();
                        return;
                    }
                    OutputStream outputStream = null;
                    try {
                        outputStream = EHPServiceManager.this.mSocket.getOutputStream();
                        if (outputStream != null) {
                            outputStream.write(EHPServiceManager.convertByte(str, bArr));
                            outputStream.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        EHPServiceManager.this.disConnectSocket();
                    }
                }
            });
        }
    }
}
