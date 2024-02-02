package com.xiaopeng.montecarlo.navcore.location;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.location.NmeaGxgsvHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public class GnssDataProcessHelper implements CarServiceManager.IXPCarStateListener {
    private static final int CNO_THRESHOLD_MIN_VALUE = 36;
    private static final int MSG_NMEA_SENTENCE = 1;
    private static final L.Tag TAG = new L.Tag("GnssDataProcessHelper");
    private int mIgStatus = -1;
    private boolean mTtffTimeFlag = false;
    private NmeaGxgsvHelper.Gxgsv mGpgsv = new NmeaGxgsvHelper.Gxgsv();
    private NmeaGxgsvHelper.Gxgsv mGbgsv = new NmeaGxgsvHelper.Gxgsv();
    private NmeaGxgsvHelper.Gxgsv mGagsv = new NmeaGxgsvHelper.Gxgsv();
    private GnssLocation mGnssLocation = new GnssLocation();
    private GnssTtffData mGnssTtffData = new GnssTtffData();
    private GnssDataProcessHandler mGnssDataProcessHandler = new GnssDataProcessHandler(WorkThreadUtil.getInstance().getGnssDataProcessThreadLooper());

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
    }

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

    public GnssDataProcessHelper() {
        CarServiceManager.getInstance().addCarStateListener(this);
    }

    public void sendNmeaReceiveMsg(NmeaSentence nmeaSentence) {
        GnssDataProcessHandler gnssDataProcessHandler = this.mGnssDataProcessHandler;
        if (gnssDataProcessHandler != null) {
            Message obtainMessage = gnssDataProcessHandler.obtainMessage(1);
            obtainMessage.obj = nmeaSentence;
            this.mGnssDataProcessHandler.sendMessage(obtainMessage);
        }
    }

    public boolean getTtffTimeFlag() {
        return this.mTtffTimeFlag;
    }

    private void sendStatData(GnssTtffData gnssTtffData) {
        if (gnssTtffData == null) {
            L.e(TAG, "sendStatData gnssTtffData is null.");
        } else if (gnssTtffData.getGnssLocation() == null || gnssTtffData.getIgOffCarLocation() == null || gnssTtffData.getIgOnCarLocation() == null) {
            L.e(TAG, "sendStatData gnssTtffData location is null.");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.GNSS_TTFF_TIME, gnssTtffData.getGnssLocation(), Long.valueOf(currentTimeMillis), Long.valueOf(gnssTtffData.getTtffTime()), Long.valueOf(gnssTtffData.getIgOnTime()), gnssTtffData.getIgOnCarLocation(), Long.valueOf(gnssTtffData.getIgOffTime()), gnssTtffData.getIgOffCarLocation());
            L.Tag tag = TAG;
            L.i(tag, "gnss location:" + gnssTtffData.getGnssLocation().mLat + "," + gnssTtffData.getGnssLocation().mLon + ",timeStamp:" + currentTimeMillis + ",TTFF:" + gnssTtffData.getTtffTime() + ",igOnTime:" + gnssTtffData.getIgOnTime() + ",IgOnCarLocation:" + gnssTtffData.getIgOnCarLocation().mLat + "," + gnssTtffData.getIgOnCarLocation().mLon + ", igOffTime:" + gnssTtffData.getIgOffTime() + ",igOffCarLocation:" + gnssTtffData.getIgOffCarLocation().mLat + "," + gnssTtffData.getIgOffCarLocation().mLon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyzeLocationInfo(NmeaSentence nmeaSentence) {
        nmeaSentence.getGnssLocation(this.mGnssLocation);
        if (nmeaSentence.isGSV() != -1) {
            parseGxgsv(nmeaSentence);
        }
        if (this.mGnssTtffData.getTtffStartTime() <= 0) {
            int i = 0;
            if (isGsvCnoNotEmpty(this.mGpgsv)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mGpgsv.mCno.length) {
                        break;
                    } else if (this.mGpgsv.mCno[i2] > 36) {
                        this.mGnssTtffData.setTtffStartTime(System.currentTimeMillis());
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (isGsvCnoNotEmpty(this.mGbgsv)) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.mGbgsv.mCno.length) {
                        break;
                    } else if (this.mGbgsv.mCno[i3] > 36) {
                        this.mGnssTtffData.setTtffStartTime(System.currentTimeMillis());
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            if (isGsvCnoNotEmpty(this.mGagsv)) {
                while (true) {
                    if (i >= this.mGagsv.mCno.length) {
                        break;
                    } else if (this.mGagsv.mCno[i] > 36) {
                        this.mGnssTtffData.setTtffStartTime(System.currentTimeMillis());
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (this.mGnssLocation.getStatus() != 65 || this.mGnssTtffData.getTtffEndTime() > 0) {
            return;
        }
        this.mGnssTtffData.setTtffEndTime(System.currentTimeMillis());
        GnssTtffData gnssTtffData = this.mGnssTtffData;
        gnssTtffData.setTtffTime(gnssTtffData.getTtffEndTime() - this.mGnssTtffData.getTtffStartTime());
        L.i(TAG, "TTFF time is: " + this.mGnssTtffData.getTtffTime());
        this.mGnssTtffData.setGnssLocation(this.mGnssLocation);
        sendStatData(this.mGnssTtffData);
        this.mTtffTimeFlag = true;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIgStatusChange(int i) {
        this.mIgStatus = i;
        XPCarLocation currentCarLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentCarLocation();
        if (currentCarLocation == null) {
            return;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble(currentCarLocation.mLongitude, currentCarLocation.mLatitude);
        int i2 = this.mIgStatus;
        if (i2 != 0) {
            if (1 == i2) {
                this.mGnssTtffData.setIgOnTime(System.currentTimeMillis());
                this.mGnssTtffData.setIgOnCarLocation(xPCoordinate2DDouble);
                return;
            }
            return;
        }
        this.mGnssTtffData.setTtffStartTime(0L);
        this.mGnssTtffData.setTtffEndTime(0L);
        this.mTtffTimeFlag = false;
        this.mGnssTtffData.setIgOffTime(System.currentTimeMillis());
        this.mGnssTtffData.setIgOffCarLocation(xPCoordinate2DDouble);
    }

    public void parseGxgsv(NmeaSentence nmeaSentence) {
        try {
            String[] nmeaParts = nmeaSentence.getNmeaParts();
            if (nmeaParts.length < 5) {
                return;
            }
            int gxgsvType = getGxgsvType(nmeaParts[0]);
            if (gxgsvType == 0) {
                this.mGpgsv.mType = gxgsvType;
                parseGsv(this.mGpgsv, nmeaParts);
            } else if (1 == gxgsvType) {
                this.mGbgsv.mType = gxgsvType;
                parseGsv(this.mGbgsv, nmeaParts);
            } else if (3 == gxgsvType) {
                this.mGagsv.mType = gxgsvType;
                parseGsv(this.mGagsv, nmeaParts);
            }
        } catch (NumberFormatException unused) {
            L.Tag tag = TAG;
            L.w(tag, "parseGxgsv error:" + nmeaSentence.getRawMsg());
        }
    }

    private void parseGsv(NmeaGxgsvHelper.Gxgsv gxgsv, String[] strArr) {
        int parseInt;
        try {
            gxgsv.mNum = Integer.parseInt(strArr[3]);
            if (gxgsv.mNum > 16) {
                gxgsv.mNum = 16;
            }
            for (int i = 4; i <= strArr.length - 4 && (parseInt = ((i / 4) - 1) + ((Integer.parseInt(strArr[2]) - 1) * 4)) < 16; i += 4) {
                if (!strArr[i].isEmpty()) {
                    gxgsv.mSv[parseInt] = Integer.parseInt(strArr[i]);
                }
                int i2 = i + 1;
                if (!strArr[i2].isEmpty()) {
                    gxgsv.mElv[parseInt] = Integer.parseInt(strArr[i2]);
                }
                int i3 = i + 2;
                if (!strArr[i3].isEmpty()) {
                    gxgsv.mAz[parseInt] = Integer.parseInt(strArr[i3]);
                }
                int i4 = i + 3;
                if (!strArr[i4].isEmpty()) {
                    if (strArr[i4].contains("*")) {
                        gxgsv.mCno[parseInt] = 0;
                    } else {
                        gxgsv.mCno[parseInt] = Integer.parseInt(strArr[i4]);
                    }
                }
            }
        } catch (NumberFormatException unused) {
            L.w(TAG, "parseGsv error");
        }
    }

    private int getGxgsvType(String str) {
        if ("$GPGSV".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("$GBGSV".equalsIgnoreCase(str)) {
            return 1;
        }
        return "$GAGSV".equalsIgnoreCase(str) ? 3 : -1;
    }

    private boolean isGsvCnoNotEmpty(NmeaGxgsvHelper.Gxgsv gxgsv) {
        return (gxgsv == null || gxgsv.mCno == null || gxgsv.mCno.length <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class GnssDataProcessHandler extends Handler {
        public GnssDataProcessHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1 && (message.obj instanceof NmeaSentence)) {
                GnssDataProcessHelper.this.analyzeLocationInfo((NmeaSentence) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class GnssTtffData {
        private XPCoordinate2DDouble mGnssLocation;
        private XPCoordinate2DDouble mIgOffCarLocation;
        private long mIgOffTime;
        private XPCoordinate2DDouble mIgOnCarLocation;
        private long mIgOnTime;
        private long mTtffEndTime;
        private long mTtffStartTime;
        private long mTtffTime;

        public GnssTtffData setIgOffCarLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
            this.mIgOffCarLocation = xPCoordinate2DDouble;
            return this;
        }

        public GnssTtffData setIgOffTime(long j) {
            this.mIgOffTime = j;
            return this;
        }

        public GnssTtffData setIgOnCarLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
            this.mIgOnCarLocation = xPCoordinate2DDouble;
            return this;
        }

        public GnssTtffData setIgOnTime(long j) {
            this.mIgOnTime = j;
            return this;
        }

        public GnssTtffData setTtffEndTime(long j) {
            this.mTtffEndTime = j;
            return this;
        }

        public GnssTtffData setTtffStartTime(long j) {
            this.mTtffStartTime = j;
            return this;
        }

        public GnssTtffData setTtffTime(long j) {
            this.mTtffTime = j;
            return this;
        }

        private GnssTtffData() {
            this.mTtffStartTime = 0L;
            this.mTtffEndTime = 0L;
            this.mTtffTime = 0L;
            this.mIgOffTime = 0L;
            this.mIgOnTime = 0L;
        }

        public long getTtffStartTime() {
            return this.mTtffStartTime;
        }

        public long getTtffEndTime() {
            return this.mTtffEndTime;
        }

        public long getTtffTime() {
            return this.mTtffTime;
        }

        public XPCoordinate2DDouble getGnssLocation() {
            return this.mGnssLocation;
        }

        public XPCoordinate2DDouble getIgOffCarLocation() {
            return this.mIgOffCarLocation;
        }

        public XPCoordinate2DDouble getIgOnCarLocation() {
            return this.mIgOnCarLocation;
        }

        public long getIgOffTime() {
            return this.mIgOffTime;
        }

        public long getIgOnTime() {
            return this.mIgOnTime;
        }

        XPCoordinate2DDouble setGnssLocation(GnssLocation gnssLocation) {
            if (gnssLocation == null) {
                return null;
            }
            Coord3DDouble coord3DDouble = new Coord3DDouble();
            coord3DDouble.lat = gnssLocation.getLatitude();
            coord3DDouble.lon = gnssLocation.getLongitude();
            coord3DDouble.z = gnssLocation.getAltitude();
            Coord3DDouble encryptLonLat = TBTManager.getInstance().getPosServiceWrapper().encryptLonLat(coord3DDouble);
            if (encryptLonLat == null) {
                L.e(GnssDataProcessHelper.TAG, "get encryptLonLat is null.");
                return null;
            }
            return new XPCoordinate2DDouble(encryptLonLat.lon, encryptLonLat.lat);
        }
    }
}
