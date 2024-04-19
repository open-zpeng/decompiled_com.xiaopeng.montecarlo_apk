package com.xiaopeng.montecarlo.navcore.sr;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.os.SystemClock;
import android.system.ErrnoException;
import androidx.annotation.NonNull;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.IXpuBinderDataProvider;
import com.xiaopeng.montecarlo.navcore.sr.IXpuDataListener;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.nio.ByteBuffer;
import java.util.List;
import xpilot.sr.proto.Imudata;
import xpilot.sr.proto.Nmeadata;
/* loaded from: classes3.dex */
public class XpuSRBinderClient {
    private static final int DEFAULT_LOG_INTERVAL = 100;
    private static final L.Tag TAG = new L.Tag(XpuSRBinderClient.class.getSimpleName());
    private IXpuBinderDataProvider mBinderDataProvider;
    Context mContext;
    private long mDataCount = 0;
    private final IXpuDataListener mDataListener = new IXpuDataListener.Stub() { // from class: com.xiaopeng.montecarlo.navcore.sr.XpuSRBinderClient.1
        @Override // com.xiaopeng.montecarlo.navcore.sr.IXpuDataListener
        public void onDispatchServerData(List<XpuBinderData> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            XpuSRBinderClient.this.handleXpuData(list.get(0));
        }
    };
    private final ServiceConnection mBinderConnection = new ServiceConnection() { // from class: com.xiaopeng.montecarlo.navcore.sr.XpuSRBinderClient.2
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            XpuSRBinderClient.this.mBinderDataProvider = IXpuBinderDataProvider.Stub.asInterface(iBinder);
            if (XpuSRBinderClient.this.mBinderDataProvider != null) {
                try {
                    XpuSRBinderClient.this.mBinderDataProvider.registerListener(2, XpuSRBinderClient.this.mDataListener);
                    XpuSRBinderClient.this.mBinderDataProvider.notifyConnectionReady();
                    L.i(XpuSRBinderClient.TAG, "client notifyConnectionReady ");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void bindXpuService(@NonNull Context context) {
        L.i(TAG, "bindXpuService");
        this.mContext = context;
        Intent intent = new Intent();
        intent.setClassName("com.xiaopeng.xpuservice", "com.xiaopeng.xpuservicelibrary.binder.server.BinderService");
        context.bindService(intent, this.mBinderConnection, 1);
    }

    public void unBindXpuService(Context context) {
        L.i(TAG, "unBindXpuService");
        try {
            if (this.mBinderDataProvider != null) {
                this.mBinderDataProvider.unregisterListener(1, this.mDataListener);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        context.unbindService(this.mBinderConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleXpuData(XpuBinderData xpuBinderData) {
        byte[] readSRData;
        byte[] readSRData2;
        if (xpuBinderData.mProto2App != null && (readSRData2 = readSRData(xpuBinderData.mProto2App)) != null) {
            sendSrData(xpuBinderData.mIndex, readSRData2, xpuBinderData.mUpTimeInMillis, xpuBinderData.mCurrentTimeInMillis);
        }
        if (xpuBinderData.mProto2AMap != null && (readSRData = readSRData(xpuBinderData.mProto2AMap)) != null) {
            LaneServiceManager.getInstance().setAutopilotData(readSRData);
        }
        if (xpuBinderData.mImuData != null) {
            try {
                Imudata.ImuInfo parseFrom = Imudata.ImuInfo.parseFrom(xpuBinderData.mImuData);
                if (parseFrom != null && parseFrom.getImusysstList() != null) {
                    CarServiceManager.getInstance().mockScuCarSpeed((Float[]) parseFrom.getImusysstList().toArray(new Float[0]), parseFrom.getTime());
                }
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
        if (xpuBinderData.mGnssData != null) {
            try {
                Nmeadata.NmeadataInfo parseFrom2 = Nmeadata.NmeadataInfo.parseFrom(xpuBinderData.mGnssData);
                if (parseFrom2 == null || parseFrom2.getData() == null) {
                    return;
                }
                LocationServiceManager.getInstance().onMockNmeaMessage(parseFrom2.getData().getMessage(), parseFrom2.getData().getTimeStamp(), parseFrom2.getTimeStamp());
            } catch (InvalidProtocolBufferException e2) {
                e2.printStackTrace();
            }
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
        return null;
    }

    private void sendSrData(long j, byte[] bArr, long j2, long j3) {
        long uptimeMillis = j2 == 0 ? SystemClock.uptimeMillis() : j2;
        this.mDataCount++;
        if (0 == this.mDataCount % 100) {
            L.i(TAG, "receive XPU data:" + bArr.length + " ,index:" + j + ",dataTime:" + SystemClock.uptimeMillis() + ",upTimeInMillis:" + j2 + ",timeInMillis:" + j3);
        }
        SRNaviManager.getInstance().onSrRdPeriodDataComing(bArr, uptimeMillis);
    }
}
