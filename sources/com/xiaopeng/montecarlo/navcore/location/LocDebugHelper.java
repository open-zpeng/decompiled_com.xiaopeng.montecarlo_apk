package com.xiaopeng.montecarlo.navcore.location;

import android.os.Handler;
import android.os.Message;
import com.xiaopeng.montecarlo.navcore.bean.location.TestLocInfo;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.location.NmeaGxgsvHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LocDebugHelper {
    private static final float KMPHR_TO_METRE_SECOND = 3.6f;
    public static final int LOC_DEBUG_MODE_BENCH = 1;
    public static final int LOC_DEBUG_MODE_VEHICLE = 2;
    private static final int MSG_ACCEL = 3;
    private static final int MSG_GNSS_OUTAGE_ERROR = 4;
    private static final int MSG_GSY = 2;
    private static final int MSG_LOCATION = 1;
    private static final long ONE_MINUTE = 60000;
    private static final L.Tag TAG = new L.Tag("LocDebugHelper");
    private Handler mLocDebugHandler;
    private TestLocInfo mTestLocInfo = new TestLocInfo();
    private boolean mIsLocDebugSwitch = false;
    private List<DRServiceManager.ILocChangeTestListener> mILocChangeTestListenerList = new ArrayList();
    private NmeaGxgsvHelper.Gxgsv mGpsgsv = new NmeaGxgsvHelper.Gxgsv();
    private NmeaGxgsvHelper.Gxgsv mBDgsv = new NmeaGxgsvHelper.Gxgsv();
    private NmeaGxgsvHelper.Gxgsv mGalgsv = new NmeaGxgsvHelper.Gxgsv();
    private GnssLocation mGnssLocation = new GnssLocation();
    private int mLocDebugMode = 1;
    private long mLastPrintLogTime = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LocDebugMode {
    }

    public boolean isLocDebugSwitch() {
        return this.mIsLocDebugSwitch;
    }

    public int getLocDebugMode() {
        return this.mLocDebugMode;
    }

    public LocDebugHelper() {
        this.mLocDebugHandler = null;
        this.mLocDebugHandler = new Handler(WorkThreadUtil.getInstance().getLocationThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.location.LocDebugHelper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1) {
                    if (message.obj instanceof NmeaSentence) {
                        LocDebugHelper.this.analyzeLocationInfo((NmeaSentence) message.obj);
                        LocDebugHelper.this.notifyLocChangeTestListener();
                    }
                } else if (i == 2) {
                    LocDebugHelper.this.analyzeGyrInfo(message.arg1 == 1, message.arg2 == 1);
                    LocDebugHelper.this.notifyLocChangeTestListener();
                } else if (i == 3) {
                    LocDebugHelper.this.analyzeAccelSpeed();
                    LocDebugHelper.this.notifyLocChangeTestListener();
                } else if (i != 4) {
                } else {
                    LocDebugHelper.this.analyzeGnssOutageError(message.arg1 == 1, message.arg2 == 1);
                    LocDebugHelper.this.notifyLocChangeTestListener();
                }
            }
        };
    }

    public void setLocDebugSwitch(boolean z) {
        if (this.mIsLocDebugSwitch != z) {
            saveLog(true);
        }
        this.mIsLocDebugSwitch = z;
    }

    public void resetLocDebugTtff() {
        this.mTestLocInfo.setTtffStartTime(0L);
        this.mTestLocInfo.setTtffEndTime(0L);
        this.mTestLocInfo.setTtffTime(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyzeGyrInfo(boolean z, boolean z2) {
        if (z) {
            this.mTestLocInfo.autoGyrXyzUnexpectCount();
        }
        if (z2) {
            this.mTestLocInfo.autoGyrTmepUnexpectCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyzeAccelSpeed() {
        this.mTestLocInfo.autoAccelSpeedUnexpectCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyzeGnssOutageError(boolean z, boolean z2) {
        if (z) {
            this.mTestLocInfo.autoLocGnssOutageCount();
        }
        if (z2) {
            this.mTestLocInfo.autoLocInfoErrorCount();
        }
    }

    public void sendNmeaReceiveMsg(NmeaSentence nmeaSentence) {
        Handler handler = this.mLocDebugHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = nmeaSentence;
            this.mLocDebugHandler.sendMessage(obtainMessage);
        }
    }

    public void sendGyrMsg(boolean z, boolean z2) {
        if (this.mLocDebugHandler != null) {
            if (z && z2) {
                return;
            }
            this.mLocDebugHandler.obtainMessage(2, z ? 1 : 0, z2 ? 1 : 0).sendToTarget();
        }
    }

    public void sendAccelSpeedMsg() {
        Handler handler = this.mLocDebugHandler;
        if (handler != null) {
            handler.obtainMessage(3).sendToTarget();
        }
    }

    public void sendGnssOutageErorMsg(boolean z, boolean z2) {
        Handler handler = this.mLocDebugHandler;
        if (handler != null) {
            handler.obtainMessage(4, z ? 1 : 0, z2 ? 1 : 0).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyzeLocationInfo(NmeaSentence nmeaSentence) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        nmeaSentence.getGnssLocation(this.mGnssLocation);
        if (nmeaSentence.isGSV() != -1) {
            parseGxgsv(nmeaSentence);
        }
        int i8 = 0;
        if (this.mTestLocInfo.getTtffStartTime() <= 0) {
            if (isGsvCnoNotEmpty(this.mGpsgsv)) {
                int i9 = 0;
                while (true) {
                    if (i9 >= this.mGpsgsv.mCno.length) {
                        break;
                    } else if (this.mGpsgsv.mCno[i9] > 36) {
                        this.mTestLocInfo.setTtffStartTime(System.currentTimeMillis());
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            if (isGsvCnoNotEmpty(this.mBDgsv)) {
                int i10 = 0;
                while (true) {
                    if (i10 >= this.mBDgsv.mCno.length) {
                        break;
                    } else if (this.mBDgsv.mCno[i10] > 36) {
                        this.mTestLocInfo.setTtffStartTime(System.currentTimeMillis());
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            if (isGsvCnoNotEmpty(this.mGalgsv)) {
                int i11 = 0;
                while (true) {
                    if (i11 >= this.mGalgsv.mCno.length) {
                        break;
                    } else if (this.mGalgsv.mCno[i11] > 36) {
                        this.mTestLocInfo.setTtffStartTime(System.currentTimeMillis());
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        if (this.mGnssLocation.getRmcUtcTime() != this.mGnssLocation.getGgaUtcTime() || !this.mGnssLocation.isRmcEnable() || !this.mGnssLocation.isGgaEnable() || !this.mGnssLocation.isGsaEnable() || !this.mGnssLocation.isGstEnable()) {
            if (this.mGnssLocation.isRmcEnable() && this.mGnssLocation.isGgaEnable() && Math.abs(this.mGnssLocation.getRmcUtcTime() - this.mGnssLocation.getGgaUtcTime()) >= 1) {
                this.mTestLocInfo.autoLocDropFrameCount();
                resetData();
                analyzeLocationInfo(nmeaSentence);
                return;
            }
            return;
        }
        if (this.mGnssLocation.getStatus() == 65) {
            if (this.mTestLocInfo.getTtffEndTime() <= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mTestLocInfo.setTtffEndTime(currentTimeMillis);
                TestLocInfo testLocInfo = this.mTestLocInfo;
                testLocInfo.setTtffTime(currentTimeMillis - testLocInfo.getTtffStartTime());
            }
            this.mTestLocInfo.autoIncrementSuccessCount();
        } else {
            this.mTestLocInfo.autoIncrementFailCount();
        }
        if (this.mGnssLocation.getAccuracy() > 20.0f) {
            this.mTestLocInfo.autoAccuraryOverCount();
        }
        if (this.mGnssLocation.getStatus() == 65) {
            if (isGsvCnoNotEmpty(this.mGpsgsv)) {
                i = this.mGpsgsv.mNum + 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i2 = this.mGpsgsv.mCno.length;
                for (int i12 = 0; i12 < i2; i12++) {
                    int i13 = this.mGpsgsv.mCno[i12];
                    i3 = Math.max(i13, i3);
                    i4 += i13;
                    if (i13 > 40) {
                        i5++;
                    }
                    if (i13 == 0) {
                        i2--;
                    }
                }
                this.mTestLocInfo.setLocGpsSateLiteCount(this.mGpsgsv.mNum);
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (isGsvCnoNotEmpty(this.mBDgsv)) {
                i += this.mBDgsv.mNum;
                int i14 = i5;
                int i15 = i4;
                int i16 = i3;
                i7 = this.mBDgsv.mCno.length;
                for (int i17 = 0; i17 < i7; i17++) {
                    int i18 = this.mBDgsv.mCno[i17];
                    i16 = Math.max(i18, i16);
                    i15 += i18;
                    if (i18 > 40) {
                        i14++;
                    }
                    if (i18 == 0) {
                        i7--;
                    }
                }
                this.mTestLocInfo.setLocCpsSateLiteCount(this.mBDgsv.mNum);
                i6 = i16;
                i4 = i15;
                i5 = i14;
            } else {
                i6 = i3;
                i7 = 0;
            }
            if (isGsvCnoNotEmpty(this.mGalgsv)) {
                i += this.mGalgsv.mNum;
                int length = this.mGalgsv.mCno.length;
                while (i8 < length) {
                    int i19 = this.mGalgsv.mCno[i8];
                    i6 = Math.max(i19, i6);
                    i4 += i19;
                    if (i19 > 40) {
                        i5++;
                    }
                    if (i19 == 0) {
                        length--;
                    }
                    i8++;
                }
                this.mTestLocInfo.setLocGalSateLiteCount(this.mGalgsv.mNum);
                i8 = length;
            }
            this.mTestLocInfo.setLocSateLiteCnoAve(i4 / ((i2 + i7) + i8));
            this.mTestLocInfo.setLocSateLiteCnoMax(i6);
            this.mTestLocInfo.setLocSateLiteCount(i);
            if (i5 < 5) {
                this.mTestLocInfo.autoLocCnoUnexpectCount();
            }
        }
        if (this.mGnssLocation.getHdop() > 5.0f) {
            this.mTestLocInfo.autoLocHdopUnexpectCount();
        }
        if (this.mGnssLocation.getSpeed() / KMPHR_TO_METRE_SECOND > 1.0f) {
            this.mTestLocInfo.autoLocSpeedUnexpectCount();
        }
        resetData();
    }

    private void resetData() {
        this.mGnssLocation.reset();
        if (isGsvCnoNotEmpty(this.mGpsgsv)) {
            this.mGpsgsv.reset();
        }
        if (isGsvCnoNotEmpty(this.mBDgsv)) {
            this.mBDgsv.reset();
        }
        if (isGsvCnoNotEmpty(this.mGalgsv)) {
            this.mGalgsv.reset();
        }
    }

    public void parseGxgsv(NmeaSentence nmeaSentence) {
        try {
            String[] nmeaParts = nmeaSentence.getNmeaParts();
            if (nmeaParts.length < 5) {
                return;
            }
            int gxgsvType = getGxgsvType(nmeaParts[0]);
            if (gxgsvType == 0) {
                this.mGpsgsv.mType = gxgsvType;
                parseGsv(this.mGpsgsv, nmeaParts);
            } else if (1 == gxgsvType) {
                this.mBDgsv.mType = gxgsvType;
                parseGsv(this.mBDgsv, nmeaParts);
            } else if (3 == gxgsvType) {
                this.mGalgsv.mType = gxgsvType;
                parseGsv(this.mGalgsv, nmeaParts);
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

    public void addLocChangeTestListener(DRServiceManager.ILocChangeTestListener iLocChangeTestListener) {
        this.mILocChangeTestListenerList.add(iLocChangeTestListener);
    }

    public void removeLocChangeTestListener(DRServiceManager.ILocChangeTestListener iLocChangeTestListener) {
        this.mILocChangeTestListenerList.remove(iLocChangeTestListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLocChangeTestListener() {
        saveLog(false);
        for (int i = 0; i < this.mILocChangeTestListenerList.size(); i++) {
            this.mILocChangeTestListenerList.get(i).locChange(this.mTestLocInfo);
        }
    }

    public void setLocDebugMode(int i) {
        if (this.mLocDebugMode != i) {
            saveLog(true);
        }
        this.mLocDebugMode = i;
    }

    private void saveLog(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - this.mLastPrintLogTime > 60000) {
            int i = this.mLocDebugMode;
            String str = 1 == i ? "bench " : 2 == i ? "vehicle " : "";
            L.Tag tag = TAG;
            L.i(tag, "" + str + this.mTestLocInfo.toString());
            this.mLastPrintLogTime = currentTimeMillis;
        }
    }
}
