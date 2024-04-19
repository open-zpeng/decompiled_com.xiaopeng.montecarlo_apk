package com.xiaopeng.montecarlo.navcore.location;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes3.dex */
public class NmeaGxgsvHelper {
    public static final int GPGSV_MAX_NUM = 16;
    public static final int GPGSV_TYPE_BEIDOU = 1;
    public static final int GPGSV_TYPE_GALILEO = 3;
    public static final int GPGSV_TYPE_GLONASS = 2;
    public static final int GPGSV_TYPE_GPS = 0;
    public static final int GPGSV_TYPE_UNKNOWN = -1;
    private static final int NMEA_GXGSV_RECEIVED = 1000;
    private static final L.Tag TAG = new L.Tag("NmeaGxgsvHelper");
    private final DRServiceManager mDRServiceManager;
    private final NmeaGxgsvHandler mNmeaGxgsvHandler = new NmeaGxgsvHandler(WorkThreadUtil.getInstance().getNmeaThreadLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLastMessage(int i, int i2) {
        return i == i2;
    }

    public void unInit() {
    }

    public NmeaGxgsvHelper(DRServiceManager dRServiceManager) {
        this.mDRServiceManager = dRServiceManager;
    }

    public void onNmeaGxgsvReceived(long j, String str) {
        if (this.mNmeaGxgsvHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 1000;
            obtain.obj = new Nmea(j, str);
            this.mNmeaGxgsvHandler.removeMessages(1000);
            this.mNmeaGxgsvHandler.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getGxgsvType(String str) {
        if ("$GPGSV".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("$GBGSV".equalsIgnoreCase(str)) {
            return 1;
        }
        return "$GAGSV".equalsIgnoreCase(str) ? 3 : -1;
    }

    /* loaded from: classes3.dex */
    public static class Nmea {
        String mNmea;
        long mTimestamp;

        Nmea(long j, String str) {
            this.mTimestamp = j;
            this.mNmea = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class Gxgsv {
        public int mNum;
        public long mTickTime;
        public int mType;
        public int[] mSv = new int[16];
        public int[] mElv = new int[16];
        public int[] mAz = new int[16];
        public int[] mCno = new int[16];

        public void reset() {
            this.mType = 0;
            this.mNum = 0;
            this.mSv = new int[16];
            this.mElv = new int[16];
            this.mAz = new int[16];
            this.mCno = new int[16];
            this.mTickTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class NmeaGxgsvHandler extends Handler {
        private Gxgsv mGxgsv;

        public NmeaGxgsvHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public synchronized void handleMessage(Message message) {
            if (message.what == 1000) {
                parseGxgsv((Nmea) message.obj);
            }
        }

        private void parseGxgsv(Nmea nmea) {
            int parseInt;
            try {
                String[] split = nmea.mNmea.split(",");
                if (split.length < 5) {
                    return;
                }
                if (this.mGxgsv == null) {
                    this.mGxgsv = new Gxgsv();
                    this.mGxgsv.mType = NmeaGxgsvHelper.this.getGxgsvType(split[0]);
                    this.mGxgsv.mNum = Integer.parseInt(split[3]);
                    if (this.mGxgsv.mNum > 16) {
                        this.mGxgsv.mNum = 16;
                    }
                }
                for (int i = 4; i <= split.length - 4 && (parseInt = ((i / 4) - 1) + ((Integer.parseInt(split[2]) - 1) * 4)) < 16; i += 4) {
                    if (!split[i].isEmpty()) {
                        this.mGxgsv.mSv[parseInt] = Integer.parseInt(split[i]);
                    }
                    int i2 = i + 1;
                    if (!split[i2].isEmpty()) {
                        this.mGxgsv.mElv[parseInt] = Integer.parseInt(split[i2]);
                    }
                    int i3 = i + 2;
                    if (!split[i3].isEmpty()) {
                        this.mGxgsv.mAz[parseInt] = Integer.parseInt(split[i3]);
                    }
                    int i4 = i + 3;
                    if (!split[i4].isEmpty()) {
                        if (split[i4].contains("*")) {
                            this.mGxgsv.mCno[parseInt] = 0;
                        } else {
                            this.mGxgsv.mCno[parseInt] = Integer.parseInt(split[i4]);
                        }
                    }
                }
                if (NmeaGxgsvHelper.this.isLastMessage(Integer.parseInt(split[1]), Integer.parseInt(split[2]))) {
                    this.mGxgsv.mTickTime = SystemClock.elapsedRealtime();
                    NmeaGxgsvHelper.this.mDRServiceManager.onGnssStatusChanged(this.mGxgsv);
                    this.mGxgsv = null;
                }
            } catch (Exception e) {
                L.w(NmeaGxgsvHelper.TAG, "parseGxgsv exception:" + e.getMessage() + " error msg:" + nmea.mNmea);
            }
        }
    }
}
