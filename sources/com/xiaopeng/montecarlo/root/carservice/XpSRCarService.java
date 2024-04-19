package com.xiaopeng.montecarlo.root.carservice;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.xpu.CarXpuManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.ISRCarService;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.Collections;
/* loaded from: classes3.dex */
public class XpSRCarService implements ISRCarService {
    private static final int DEFAULT_LOG_INTERVAL = 100;
    private static final String SERVICE_NAME = "XpSRCarService";
    private static final L.Tag TAG = new L.Tag(SERVICE_NAME);
    private Car mCarApiClient;
    private CarXpuManager mCarXpuManager;
    private ISRCarService.ISRCarStateListener mListener;
    private long mDataCount = 0;
    private final CarXpuManager.CarXpuEventCallback mCarXpuEventCallback = new CarXpuManager.CarXpuEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpSRCarService.2
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            if (propertyId == 561002509 && (value instanceof byte[])) {
                XpSRCarService.this.sendSrData((byte[]) value, carPropertyValue.getTimestamp());
            }
        }

        public void onErrorEvent(int i, int i2) {
            L.Tag tag = XpSRCarService.TAG;
            L.e(tag, "CarXpuManager.CarXpuEventCallback onErrorEvent: " + i);
        }
    };

    @Override // com.xiaopeng.montecarlo.root.util.ISRCarService
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override // com.xiaopeng.montecarlo.root.util.ISRCarService
    public void init() {
        L.i(TAG, "init start");
        this.mCarApiClient = Car.createCar(ContextUtils.getContext(), new ServiceConnection() { // from class: com.xiaopeng.montecarlo.root.carservice.XpSRCarService.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                L.i(XpSRCarService.TAG, "onServiceConnected");
                WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.carservice.XpSRCarService.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        XpSRCarService.this.initXpuCarManager();
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                L.i(XpSRCarService.TAG, "onServiceDisconnected");
                XpSRCarService.this.release();
            }
        }, new Handler(WorkThreadUtil.getInstance().getSrCarServiceThreadLooper()));
        this.mCarApiClient.connect();
        L.i(TAG, "init end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initXpuCarManager() {
        try {
            this.mCarXpuManager = (CarXpuManager) this.mCarApiClient.getCarManager("xp_xpu");
            this.mCarXpuManager.registerPropCallback(Collections.singletonList(561002509), this.mCarXpuEventCallback);
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarXpuManager");
        }
        L.i(TAG, "init XpuCarManager done");
    }

    @Override // com.xiaopeng.montecarlo.root.util.ISRCarService
    public void release() {
        if (this.mCarXpuManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarXpuManager.unregisterCallback");
            }
            try {
                this.mCarXpuManager.unregisterPropCallback(Collections.singletonList(561002509), this.mCarXpuEventCallback);
            } catch (CarNotConnectedException e) {
                e.printStackTrace();
            }
        }
        Car car = this.mCarApiClient;
        if (car != null) {
            car.disconnect();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.util.ISRCarService
    public void registerObserver(ISRCarService.ISRCarStateListener iSRCarStateListener) {
        this.mListener = iSRCarStateListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSrData(byte[] bArr, long j) {
        long j2 = j / 1000000;
        if (j2 == 0) {
            j2 = SystemClock.uptimeMillis();
        }
        this.mDataCount++;
        if (0 == this.mDataCount % 100) {
            L.i(TAG, "receive XPU data:" + bArr.length + ",dataTime:" + j2 + ",timestamp:" + j);
        }
        ISRCarService.ISRCarStateListener iSRCarStateListener = this.mListener;
        if (iSRCarStateListener != null) {
            iSRCarStateListener.onSrRdPeriodDataComing(bArr, j2);
        }
    }
}
