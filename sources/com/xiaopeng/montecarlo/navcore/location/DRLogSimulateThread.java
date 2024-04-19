package com.xiaopeng.montecarlo.navcore.location;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.pos.model.LocGnss;
import com.autonavi.gbl.pos.model.LocGpgsv;
import com.autonavi.gbl.pos.model.LocSignData;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DRLogSimulateThread implements Runnable {
    public static final int SEND_LOCATION_CHANGED_SPEED = 1000;
    private static final L.Tag TAG = new L.Tag("DebugLocationSimulateThd");
    private final PosServiceWrapper mPosService;
    private volatile boolean mRunningFlag = true;
    private final String mSimulatedLogFilePath;

    public DRLogSimulateThread(String str, PosServiceWrapper posServiceWrapper) {
        this.mSimulatedLogFilePath = str;
        this.mPosService = posServiceWrapper;
    }

    public void stopThread() {
        this.mRunningFlag = false;
    }

    @Nullable
    private void parseToDRRecord(List<Map.Entry<Long, String>> list) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        if (list == null) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    File file = new File(this.mSimulatedLogFilePath + DRLogRecordThread.FILE_NAME);
                    list.clear();
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStream);
                            try {
                                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                                while (true) {
                                    try {
                                        String readLine = bufferedReader2.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        if (L.ENABLE) {
                                            L.d(TAG, ">>>> parse dr record read: " + readLine);
                                        }
                                        Map.Entry<Long, String> logStringToDRRecord = LocationUtils.logStringToDRRecord(readLine);
                                        if (logStringToDRRecord != null) {
                                            list.add(logStringToDRRecord);
                                        } else {
                                            L.w(TAG, ">>>> parse dr record failed read: " + readLine);
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        bufferedReader = bufferedReader2;
                                        L.w(TAG, e.getMessage());
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedReader = bufferedReader2;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (IOException e5) {
                                                e5.printStackTrace();
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                bufferedReader = bufferedReader2;
                            } catch (IOException e7) {
                                e = e7;
                            }
                        } catch (IOException e8) {
                            e = e8;
                            inputStreamReader = null;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStreamReader = null;
                        }
                    } else {
                        if (L.ENABLE) {
                            L.d(TAG, this.mSimulatedLogFilePath + " file doesn't exist!!");
                        }
                        inputStreamReader = null;
                        fileInputStream = null;
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e11) {
                e = e11;
                inputStreamReader = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                fileInputStream = null;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException e12) {
            e12.printStackTrace();
        }
    }

    private long parseLong(String str, String str2) throws Exception {
        String[] split = str.split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
        if (split[0].equals(str2)) {
            return Long.parseLong(split[1]);
        }
        throw new Exception("field " + str2 + " should not be:" + split[0]);
    }

    private int parseInt(String str, String str2) throws Exception {
        String[] split = str.split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
        if (split[0].equals(str2)) {
            return Integer.parseInt(split[1]);
        }
        throw new Exception("field " + str2 + " should not be:" + split[0]);
    }

    private float parseFloat(String str, String str2) throws Exception {
        String[] split = str.split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
        if (split[0].equals(str2)) {
            return Float.parseFloat(split[1]);
        }
        throw new Exception("field " + str2 + " should not be:" + split[0]);
    }

    private double parseDouble(String str, String str2) throws Exception {
        String[] split = str.split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
        if (split[0].equals(str2)) {
            return Double.parseDouble(split[1]);
        }
        throw new Exception("field " + str2 + " should not be:" + split[0]);
    }

    private void sendFakeA3d(String[] strArr, long j) {
        if (strArr.length != 6) {
            L.Tag tag = TAG;
            L.w(tag, "data length check failed:" + strArr.length + "!=6");
            return;
        }
        try {
            float parseFloat = parseFloat(strArr[1], "y");
            this.mPosService.setA3D(parseFloat(strArr[2], "x"), parseFloat, parseFloat(strArr[3], CompressorStreamFactory.Z), BigInteger.valueOf(SystemClock.elapsedRealtime()), parseInt(strArr[5], "in"), true);
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }

    private void sendFakeGsv(String[] strArr, long j) {
        if (strArr.length != 5) {
            L.Tag tag = TAG;
            L.w(tag, "data length check failed:" + strArr.length + "!=5");
            return;
        }
        try {
            LocSignData locSignData = new LocSignData();
            locSignData.dataType = 64;
            locSignData.gpgsv = new LocGpgsv();
            locSignData.gpgsv.dataType = 64;
            locSignData.gpgsv.prn = new int[16];
            locSignData.gpgsv.elevation = new int[16];
            locSignData.gpgsv.azimuth = new int[16];
            locSignData.gpgsv.snr = new int[16];
            locSignData.gpgsv.num = parseInt(strArr[1], "num");
            String[] split = strArr[2].split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
            if (split[0].equals("gsv")) {
                String[] split2 = split[1].split(",");
                if (locSignData.gpgsv.num == split2.length / 4) {
                    for (int i = 0; i < locSignData.gpgsv.num; i++) {
                        int i2 = i * 4;
                        locSignData.gpgsv.prn[i] = Integer.parseInt(split2[i2]);
                        locSignData.gpgsv.elevation[i] = Integer.parseInt(split2[i2 + 1]);
                        locSignData.gpgsv.azimuth[i] = Integer.parseInt(split2[i2 + 2]);
                        locSignData.gpgsv.snr[i] = Integer.parseInt(split2[i2 + 3]);
                    }
                    locSignData.gpgsv.tickTime = BigInteger.valueOf(parseLong(strArr[3], "ti"));
                    locSignData.gpgsv.type = parseInt(strArr[4], "type");
                    this.mPosService.setFakeGSV(locSignData);
                    return;
                }
                L.Tag tag2 = TAG;
                L.w(tag2, "gsv num: " + locSignData.gpgsv.num + "should not be:" + split2.length + "div 4");
                return;
            }
            L.Tag tag3 = TAG;
            L.w(tag3, "field gsv should not be:" + split[0]);
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }

    private void sendFakePulse(String[] strArr, long j) {
        if (strArr.length != 4) {
            L.Tag tag = TAG;
            L.w(tag, "data length check failed:" + strArr.length + "!=4");
            return;
        }
        try {
            float parseFloat = parseFloat(strArr[1], "value");
            int parseInt = parseInt(strArr[2], "in");
            this.mPosService.setPulse(parseFloat, BigInteger.valueOf(parseLong(strArr[3], "ti")), parseInt, true);
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }

    private void sendFakeGyro(String[] strArr, long j) {
        if (strArr.length != 7) {
            L.Tag tag = TAG;
            L.w(tag, "data length check failed:" + strArr.length + "!=7");
            return;
        }
        try {
            this.mPosService.setGYR(parseFloat(strArr[1], "x"), parseFloat(strArr[2], "y"), parseFloat(strArr[3], CompressorStreamFactory.Z), BigInteger.valueOf(parseLong(strArr[4], "ti")), parseFloat(strArr[5], "te"), parseInt(strArr[6], "in"), true);
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }

    private void sendFakeGnss(String[] strArr, long j) {
        if (strArr.length != 19) {
            L.Tag tag = TAG;
            L.w(tag, "data length check failed:" + strArr.length + "!=19");
            return;
        }
        try {
            LocSignData locSignData = new LocSignData();
            locSignData.gnss = new LocGnss();
            locSignData.dataType = 16;
            locSignData.gnss.mode = GnssLocation.LOC_VALID;
            locSignData.gnss.status = GnssLocation.LOC_VALID;
            locSignData.gnss.isEncrypted = (short) 0;
            locSignData.gnss.isNS = (byte) 78;
            locSignData.gnss.isEW = (byte) 69;
            locSignData.gnss.stPtS = new Coord2DDouble();
            locSignData.gnss.stPt = locSignData.gnss.stPtS;
            locSignData.gnss.year = parseInt(strArr[1], "y");
            locSignData.gnss.month = parseInt(strArr[2], "m");
            locSignData.gnss.day = parseInt(strArr[3], "d");
            locSignData.gnss.hour = parseInt(strArr[4], "h");
            locSignData.gnss.minute = parseInt(strArr[5], "min");
            locSignData.gnss.second = parseInt(strArr[6], "sec");
            locSignData.gnss.sourType = parseInt(strArr[7], "sT");
            locSignData.gnss.stPtS.lon = parseDouble(strArr[8], CPSearchParam.PARAM_KEY_LON);
            locSignData.gnss.stPtS.lat = parseDouble(strArr[9], CPSearchParam.PARAM_KEY_LAT);
            locSignData.gnss.speed = parseFloat(strArr[10], "sp");
            locSignData.gnss.course = parseFloat(strArr[11], "co");
            locSignData.gnss.alt = parseFloat(strArr[12], "alt");
            locSignData.gnss.accuracy = parseFloat(strArr[13], DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_ACC);
            locSignData.gnss.tickTime = BigInteger.valueOf(parseLong(strArr[14], "ti"));
            locSignData.gnss.num = parseInt(strArr[15], "n");
            locSignData.gnss.hdop = parseFloat(strArr[16], "hp");
            locSignData.gnss.vdop = parseFloat(strArr[17], "vp");
            locSignData.gnss.pdop = parseFloat(strArr[18], "pp");
            this.mPosService.setFakeLocation(locSignData);
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }

    private void sendFakeDrRecord(String str, long j) {
        String[] split = str.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        boolean z = false;
        try {
            String[] split2 = split[0].split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
            if (!LocationUtils.DR_RECORD_TAG_DATA_TYPE.equals(split2[0])) {
                L.w(TAG, "no data type tag");
            }
            String str2 = split2[1];
            switch (str2.hashCode()) {
                case 64146:
                    if (str2.equals("A3d")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 71914:
                    if (str2.equals("Gsv")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 98260:
                    if (str2.equals("car")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 2224551:
                    if (str2.equals("Gnss")) {
                        break;
                    }
                    z = true;
                    break;
                case 2235087:
                    if (str2.equals("Gyro")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 77474681:
                    if (str2.equals("Pulse")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                sendFakeGnss(split, j);
            } else if (z) {
                sendFakeGyro(split, j);
            } else if (z) {
                sendFakePulse(split, j);
            } else if (z) {
                sendFakeGsv(split, j);
            } else if (z) {
                sendFakeA3d(split, j);
            } else if (z) {
                sendCarService(split);
            } else {
                L.w(TAG, "unknown data type:" + str2);
            }
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }

    private void sendCarService(String[] strArr) {
        try {
            String[] split = strArr[1].split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
            CarServiceManager.getInstance().setFakeData(split[0], split[1]);
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mRunningFlag = true;
        ArrayList arrayList = new ArrayList();
        parseToDRRecord(arrayList);
        L.i(TAG, "parseToDRRecord done");
        int size = arrayList.size();
        Map.Entry<Long, String> entry = arrayList.get(0);
        while (true) {
            int i = 0;
            while (i < size && this.mRunningFlag) {
                long longValue = entry.getKey().longValue();
                sendFakeDrRecord(entry.getValue(), longValue);
                i++;
                if (i >= size) {
                    L.i(TAG, "loop finished");
                    return;
                }
                entry = arrayList.get(i);
                long longValue2 = entry.getKey().longValue();
                int i2 = (int) (longValue2 - longValue);
                if (i2 < 0) {
                    L.w(TAG, "wrong timetick:" + longValue2 + "-" + longValue);
                    return;
                }
                if (i2 > 1) {
                    i2--;
                }
                try {
                    Thread.sleep(i2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == size) {
                    break;
                }
            }
            return;
        }
    }
}
