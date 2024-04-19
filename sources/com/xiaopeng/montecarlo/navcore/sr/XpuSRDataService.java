package com.xiaopeng.montecarlo.navcore.sr;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SharedMemory;
import android.os.SystemClock;
import android.system.ErrnoException;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.SrCarServiceManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.nio.ByteBuffer;
import lane.auto_pilot.data.AutoPilotDataOuterClass;
import xpilot.sr.proto.Imudata;
import xpilot.sr.proto.Nmeadata;
/* loaded from: classes3.dex */
public class XpuSRDataService extends Service {
    private static final int DEFAULT_LOG_INTERVAL = 100;
    private static final String KEY_XPU_GNSS_DATA = "gnss";
    private static final String KEY_XPU_IMU_DATA = "imu";
    private static final String KEY_XPU_PROTO_TO_AMAP = "gaode";
    private static final String KEY_XPU_PROTO_TO_APP = "sm";
    private static final String KEY_XPU_TIME = "timeTicket";
    private static final L.Tag TAG = new L.Tag(XpuSRDataService.class.getSimpleName());
    private static final int XPU_DATA = 1;
    private long mDataCount = 0;
    Messenger mServerMessenger = new Messenger(new Handler(WorkThreadUtil.getInstance().getSrCarServiceThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.sr.XpuSRDataService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr;
            byte[] bArr2;
            if (message == null || message.what != 1 || message.getData() == null) {
                return;
            }
            Object obj = message.getData().get(XpuSRDataService.KEY_XPU_PROTO_TO_APP);
            Object obj2 = message.getData().get(XpuSRDataService.KEY_XPU_PROTO_TO_AMAP);
            Object obj3 = message.getData().get(XpuSRDataService.KEY_XPU_IMU_DATA);
            Object obj4 = message.getData().get(XpuSRDataService.KEY_XPU_GNSS_DATA);
            if ((obj instanceof byte[]) && (bArr2 = (byte[]) obj) != null) {
                long j = 0;
                try {
                    j = Long.parseLong((String) message.getData().get(XpuSRDataService.KEY_XPU_TIME));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                XpuSRDataService.this.sendSrData(bArr2, j);
            }
            if ((obj2 instanceof byte[]) && (bArr = (byte[]) obj2) != null) {
                XpuSRDataService.this.handleProto2AMap(bArr);
                LaneServiceManager.getInstance().setAutopilotData(bArr);
            }
            if (obj3 instanceof byte[]) {
                try {
                    Imudata.ImuInfo parseFrom = Imudata.ImuInfo.parseFrom((byte[]) obj3);
                    if (parseFrom == null || parseFrom.getImusysstList() == null) {
                        L.d(XpuSRDataService.TAG, "Imudata is null!");
                    } else {
                        CarServiceManager.getInstance().mockScuCarSpeed((Float[]) parseFrom.getImusysstList().toArray(new Float[0]), parseFrom.getTime());
                    }
                } catch (InvalidProtocolBufferException e2) {
                    e2.printStackTrace();
                }
            }
            if (obj4 instanceof byte[]) {
                try {
                    Nmeadata.NmeadataInfo parseFrom2 = Nmeadata.NmeadataInfo.parseFrom((byte[]) obj4);
                    if (parseFrom2 == null || parseFrom2.getData() == null) {
                        L.d(XpuSRDataService.TAG, "Nmeadata is null!");
                    } else {
                        LocationServiceManager.getInstance().onMockNmeaMessage(parseFrom2.getData().getMessage(), parseFrom2.getData().getTimeStamp(), parseFrom2.getTimeStamp());
                    }
                } catch (InvalidProtocolBufferException e3) {
                    e3.printStackTrace();
                }
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProto2AMap(byte[] bArr) {
        try {
            AutoPilotDataOuterClass.AutoPilotData parseFrom = AutoPilotDataOuterClass.AutoPilotData.parseFrom(bArr);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, bArr.length + "--handleProto2AMap light count:" + parseFrom.getLightGroup().getLightsCount());
                if (parseFrom.getLightGroup().getLightsCount() > 0) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "handleProto2AMap status:" + parseFrom.getLightGroup().getLights(0).getStatus());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            L.Tag tag3 = TAG;
            L.e(tag3, "handleProto2AMap:" + e.toString());
        }
    }

    private byte[] readSRData(SharedMemory sharedMemory) {
        if (sharedMemory != null) {
            try {
                ByteBuffer mapReadOnly = sharedMemory.mapReadOnly();
                byte[] bArr = new byte[mapReadOnly.remaining()];
                mapReadOnly.get(bArr);
                SharedMemory.unmap(mapReadOnly);
                sharedMemory.close();
                return bArr;
            } catch (ErrnoException e) {
                e.printStackTrace();
                L.Tag tag = TAG;
                L.e(tag, "readShareMemory：" + e.toString());
                return null;
            }
        }
        L.e(TAG, "read shareMemory no data!");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSrData(byte[] bArr, long j) {
        long uptimeMillis = j == 0 ? SystemClock.uptimeMillis() : j;
        this.mDataCount++;
        if (0 == this.mDataCount % 100) {
            L.i(TAG, "receive XPU data:" + bArr.length + ",dataTime:" + uptimeMillis + ",timestamp:" + j);
        }
        SrCarServiceManager.getInstance().onSrRdPeriodDataComing(bArr, uptimeMillis);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        L.i(TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        L.i(TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        L.i(TAG, "onBind");
        return this.mServerMessenger.getBinder();
    }
}
