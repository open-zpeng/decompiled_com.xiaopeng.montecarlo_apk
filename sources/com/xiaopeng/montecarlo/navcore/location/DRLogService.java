package com.xiaopeng.montecarlo.navcore.location;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.pos.model.LocAcce3d;
import com.autonavi.gbl.pos.model.LocGyro;
import com.autonavi.gbl.pos.model.LocSignData;
import com.xiaopeng.montecarlo.navcore.location.DRLogRecordThread;
import com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.carservice.MockCarService;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
/* loaded from: classes3.dex */
public class DRLogService implements CarServiceManager.IXPCarStateListener {
    private static final L.Tag TAG = new L.Tag("DRLogService");
    private ICarService mCarService;
    @NonNull
    private Object mMutex;
    private final DRLogRecordThread mRecordThread;
    private volatile boolean mRunningFlag;
    private final String mSaveFileDir;
    private final DRLogSimulateThread mSimulationThread;

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    public DRLogService(@NonNull String str) {
        this.mRunningFlag = false;
        this.mCarService = null;
        this.mMutex = new Object();
        this.mSaveFileDir = str;
        this.mRecordThread = new DRLogRecordThread(str);
        this.mSimulationThread = null;
    }

    public DRLogService(@NonNull String str, PosServiceWrapper posServiceWrapper) {
        this.mRunningFlag = false;
        this.mCarService = null;
        this.mMutex = new Object();
        this.mSaveFileDir = str;
        this.mSimulationThread = new DRLogSimulateThread(str, posServiceWrapper);
        this.mRecordThread = null;
    }

    public void startDebugLocationSimulate() {
        synchronized (this.mMutex) {
            if (!this.mRunningFlag && this.mSimulationThread != null && !TextUtils.isEmpty(this.mSaveFileDir)) {
                this.mRunningFlag = true;
                WorkThreadUtil.getInstance().executeCachedTask(this.mSimulationThread);
                this.mCarService = CarServiceManager.getInstance().getCarService();
                CarServiceManager.getInstance().reinit(new MockCarService());
            }
        }
    }

    public void stopLocationSimulate() {
        synchronized (this.mMutex) {
            if (this.mRunningFlag) {
                this.mRunningFlag = false;
                this.mSimulationThread.stopThread();
                CarServiceManager.getInstance().reinit(this.mCarService);
                this.mCarService = null;
            }
        }
    }

    public void stopLocationRecord() {
        synchronized (this.mMutex) {
            if (this.mRunningFlag) {
                this.mRunningFlag = false;
                this.mRecordThread.stopThread();
                CarServiceManager.getInstance().removeCarStateListener(this);
                ContextUtils.getContext().sendBroadcast(new Intent("com.xiaopeng.montecarlo.LOCATION_RECORD_STOP"));
            }
        }
    }

    public void startLocationRecord() {
        synchronized (this.mMutex) {
            if (!this.mRunningFlag && this.mRecordThread != null && !TextUtils.isEmpty(this.mSaveFileDir)) {
                this.mRunningFlag = true;
                DRLogRecordThread.WorkStatus workStatus = this.mRecordThread.getWorkStatus();
                if (DRLogRecordThread.WorkStatus.WorkStatusIdle == workStatus) {
                    L.i(TAG, "start DRLogRecordThread");
                    WorkThreadUtil.getInstance().executeCachedTask(this.mRecordThread);
                } else if (DRLogRecordThread.WorkStatus.WorkStatusToClose == workStatus) {
                    this.mRecordThread.restartThread();
                } else {
                    L.w(TAG, "RecordThread is running");
                }
                CarServiceManager.getInstance().addCarStateListener(this);
                ContextUtils.getContext().sendBroadcast(new Intent("com.xiaopeng.montecarlo.LOCATION_RECORD_START"));
            }
        }
    }

    public boolean isRecorderRunning() {
        return this.mRunningFlag;
    }

    public void setLocation(LocSignData locSignData) {
        if (this.mRunningFlag) {
            StringBuilder sb = new StringBuilder();
            sb.append("dataType:Gnss");
            sb.append(";y:" + locSignData.gnss.year);
            sb.append(";m:" + locSignData.gnss.month);
            sb.append(";d:" + locSignData.gnss.day);
            sb.append(";h:" + locSignData.gnss.hour);
            sb.append(";min:" + locSignData.gnss.minute);
            sb.append(";sec:" + locSignData.gnss.second);
            sb.append(";sT:" + locSignData.gnss.sourType);
            sb.append(";lon:" + locSignData.gnss.stPtS.lon);
            sb.append(";lat:" + locSignData.gnss.stPtS.lat);
            sb.append(";sp:" + locSignData.gnss.speed);
            sb.append(";co:" + locSignData.gnss.course);
            sb.append(";alt:" + locSignData.gnss.alt);
            sb.append(";acc:" + locSignData.gnss.accuracy);
            sb.append(";ti:" + locSignData.gnss.tickTime);
            sb.append(";n:" + locSignData.gnss.num);
            sb.append(";hp:" + locSignData.gnss.hdop);
            sb.append(";vp:" + locSignData.gnss.vdop);
            sb.append(";pp:" + locSignData.gnss.pdop);
            this.mRecordThread.addRecord(Long.valueOf(locSignData.gnss.tickTime.longValue()), sb.toString());
        }
    }

    public void setGYR(LocGyro locGyro) {
        if (this.mRunningFlag) {
            StringBuilder sb = new StringBuilder();
            sb.append("dataType:Gyro");
            sb.append(";x:" + locGyro.valueX);
            sb.append(";y:" + locGyro.valueY);
            sb.append(";z:" + locGyro.valueZ);
            sb.append(";ti:" + locGyro.tickTime);
            sb.append(";te:" + locGyro.temperature);
            sb.append(";in:" + locGyro.interval);
            this.mRecordThread.addRecord(Long.valueOf(locGyro.tickTime.longValue()), sb.toString());
        }
    }

    public void setPulse(LocSignData locSignData) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(Long.valueOf(locSignData.pulse.tickTime.longValue()), String.format("dataType:Pulse;value:" + locSignData.pulse.value + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "in" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locSignData.pulse.interval + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "ti" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locSignData.pulse.tickTime, new Object[0]));
        }
    }

    public void setGSV(LocSignData locSignData) {
        if (this.mRunningFlag) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < locSignData.gpgsv.num; i++) {
                sb.append(locSignData.gpgsv.prn[i] + "," + locSignData.gpgsv.elevation[i] + "," + locSignData.gpgsv.azimuth[i] + "," + locSignData.gpgsv.snr[i] + ",");
            }
            this.mRecordThread.addRecord(Long.valueOf(locSignData.gpgsv.tickTime.longValue()), String.format("dataType:Gsv;num:" + locSignData.gpgsv.num + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "gsv" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + sb.toString() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "ti" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locSignData.gpgsv.tickTime + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "type" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locSignData.gpgsv.type, new Object[0]));
        }
    }

    public void setA3D(LocAcce3d locAcce3d) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(Long.valueOf(locAcce3d.tickTime.longValue()), String.format("dataType:A3d;y:" + locAcce3d.acceY + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "x" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locAcce3d.acceX + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + CompressorStreamFactory.Z + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locAcce3d.acceZ + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "ti" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locAcce3d.tickTime + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + "in" + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + locAcce3d.interval, new Object[0]));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
        if (this.mRunningFlag) {
            String format = String.format("dataType:car;cs:" + f, new Object[0]);
            L.Tag tag = TAG;
            L.i(tag, "cs:" + f);
            this.mRecordThread.addRecord(format);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(String.format("dataType:car;rcs:" + f, new Object[0]));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIgStatusChange(int i) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(String.format("dataType:car;pms:" + i, new Object[0]));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(String.format("dataType:car;ds:" + i, new Object[0]));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(String.format("dataType:car;gl:" + i, new Object[0]));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarRemainDistanceChange(int i) {
        if (this.mRunningFlag) {
            String format = String.format("dataType:car;rd:" + i, new Object[0]);
            L.i(TAG, format);
            this.mRecordThread.addRecord(format);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
        if (this.mRunningFlag) {
            String format = String.format("dataType:car;emm:" + i, new Object[0]);
            L.i(TAG, format);
            this.mRecordThread.addRecord(format);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(String.format("dataType:car;hvacpm:" + z, new Object[0]));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(String.format("dataType:car;dm:" + i, new Object[0]));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
        if (this.mRunningFlag) {
            this.mRecordThread.addRecord(String.format("dataType:car;erl:" + i, new Object[0]));
        }
    }
}
