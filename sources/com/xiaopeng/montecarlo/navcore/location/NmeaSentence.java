package com.xiaopeng.montecarlo.navcore.location;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class NmeaSentence {
    private static final int BEIJING_TIME_AFTER_UTC = 28800000;
    private static final float CONSTANT_100 = 100.0f;
    private static final float CONSTANT_60 = 60.0f;
    private static final int CONSTELLATION_BD = 2;
    public static final int CONSTELLATION_DEFAULT = -1;
    private static final int CONSTELLATION_GALILEO = 3;
    private static final int CONSTELLATION_GNSS = 0;
    private static final int CONSTELLATION_GPS = 1;
    private static final String GAVTG = "$GAVTG";
    private static final String GBVTG = "$GBVTG";
    private static final int GGA_FRAME_STRING_MAX = 10;
    private static final String GNVTG = "$GNVTG";
    private static final String GPVTG = "$GPVTG";
    private static final int GSA_FRAME_STRING_MAX = 18;
    private static final int GST_FRAME_STRING_MAX = 8;
    private static final float KNOTS_TO_KMPHR = 1.852f;
    private static final int RMC_FRAME_STRING_MAX = 10;
    private String[] mNmeaParts;
    private String mRawMsg;
    private long mTimestamp;
    private static final L.Tag TAG = new L.Tag("NmeaSentence");
    private static final String GNRMC = "$GNRMC";
    private static final String GPRMC = "$GPRMC";
    private static final String GBRMC = "$GBRMC";
    private static final String GARMC = "$GARMC";
    private static final String GNGGA = "$GNGGA";
    private static final String GPGGA = "$GPGGA";
    private static final String GBGGA = "$GBGGA";
    private static final String GAGGA = "$GAGGA";
    private static final String GNGSA = "$GNGSA";
    private static final String GPGSA = "$GPGSA";
    private static final String GBGSA = "$GBGSA";
    private static final String GAGSA = "$GAGSA";
    private static final String GNGSV = "$GNGSV";
    private static final String GPGSV = "$GPGSV";
    private static final String GBGSV = "$GBGSV";
    private static final String GAGSV = "$GAGSV";
    private static final String GNGST = "$GNGST";
    private static final String GPGST = "$GPGST";
    private static final String GBGST = "$GBGST";
    private static final String GAGST = "$GAGST";
    private static final HashSet<String> sValidKey = new HashSet<>(Arrays.asList(GNRMC, GPRMC, GBRMC, GARMC, GNGGA, GPGGA, GBGGA, GAGGA, GNGSA, GPGSA, GBGSA, GAGSA, GNGSV, GPGSV, GBGSV, GAGSV, GNGST, GPGST, GBGST, GAGST));

    public String[] getNmeaParts() {
        return this.mNmeaParts;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public String getRawMsg() {
        return this.mRawMsg;
    }

    public NmeaSentence(String str, long j) {
        this.mTimestamp = j;
        this.mRawMsg = str;
        if (TextUtils.isEmpty(str)) {
            this.mNmeaParts = new String[]{""};
        } else {
            this.mNmeaParts = str.split(",");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidSentence(String str) {
        if (str.length() <= 6) {
            return false;
        }
        return sValidKey.contains(str.substring(0, 6));
    }

    public int isRMC() {
        String str = this.mNmeaParts[0];
        if (GNRMC.equalsIgnoreCase(str)) {
            return 0;
        }
        if (GPRMC.equalsIgnoreCase(str)) {
            return 1;
        }
        if (GBRMC.equalsIgnoreCase(str)) {
            return 2;
        }
        return GARMC.equalsIgnoreCase(str) ? 3 : -1;
    }

    public int isVTG() {
        String str = this.mNmeaParts[0];
        if (GNVTG.equalsIgnoreCase(str)) {
            return 0;
        }
        if (GPVTG.equalsIgnoreCase(str)) {
            return 1;
        }
        if (GBVTG.equalsIgnoreCase(str)) {
            return 2;
        }
        return GAVTG.equalsIgnoreCase(str) ? 3 : -1;
    }

    public int isGGA() {
        String str = this.mNmeaParts[0];
        if (GNGGA.equalsIgnoreCase(str)) {
            return 0;
        }
        if (GPGGA.equalsIgnoreCase(str)) {
            return 1;
        }
        if (GBGGA.equalsIgnoreCase(str)) {
            return 2;
        }
        return GAGGA.equalsIgnoreCase(str) ? 3 : -1;
    }

    public int isGSA() {
        String str = this.mNmeaParts[0];
        if (GNGSA.equalsIgnoreCase(str)) {
            return 0;
        }
        if (GPGSA.equalsIgnoreCase(str)) {
            return 1;
        }
        if (GBGSA.equalsIgnoreCase(str)) {
            return 2;
        }
        return GAGSA.equalsIgnoreCase(str) ? 3 : -1;
    }

    public int isGSV() {
        String str = this.mNmeaParts[0];
        if (GNGSV.equalsIgnoreCase(str)) {
            return 0;
        }
        if (GPGSV.equalsIgnoreCase(str)) {
            return 1;
        }
        if (GBGSV.equalsIgnoreCase(str)) {
            return 2;
        }
        return GAGSV.equalsIgnoreCase(str) ? 3 : -1;
    }

    public int isGST() {
        String str = this.mNmeaParts[0];
        if (GNGST.equalsIgnoreCase(str)) {
            return 0;
        }
        if (GPGST.equalsIgnoreCase(str)) {
            return 1;
        }
        if (GBGST.equalsIgnoreCase(str)) {
            return 2;
        }
        return GAGST.equalsIgnoreCase(str) ? 3 : -1;
    }

    /* loaded from: classes3.dex */
    public class BeiJingTime {
        private int mDay;
        private int mHour;
        private int mMinute;
        private int mMonth;
        private int mSecond;
        private int mYear;

        public BeiJingTime() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof BeiJingTime;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof BeiJingTime) {
                BeiJingTime beiJingTime = (BeiJingTime) obj;
                return beiJingTime.canEqual(this) && getHour() == beiJingTime.getHour() && getMinute() == beiJingTime.getMinute() && getSecond() == beiJingTime.getSecond() && getYear() == beiJingTime.getYear() && getMonth() == beiJingTime.getMonth() && getDay() == beiJingTime.getDay();
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((getHour() + 59) * 59) + getMinute()) * 59) + getSecond()) * 59) + getYear()) * 59) + getMonth()) * 59) + getDay();
        }

        public BeiJingTime setDay(int i) {
            this.mDay = i;
            return this;
        }

        public BeiJingTime setHour(int i) {
            this.mHour = i;
            return this;
        }

        public BeiJingTime setMinute(int i) {
            this.mMinute = i;
            return this;
        }

        public BeiJingTime setMonth(int i) {
            this.mMonth = i;
            return this;
        }

        public BeiJingTime setSecond(int i) {
            this.mSecond = i;
            return this;
        }

        public BeiJingTime setYear(int i) {
            this.mYear = i;
            return this;
        }

        public String toString() {
            return "NmeaSentence.BeiJingTime(mHour=" + getHour() + ", mMinute=" + getMinute() + ", mSecond=" + getSecond() + ", mYear=" + getYear() + ", mMonth=" + getMonth() + ", mDay=" + getDay() + ")";
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public int getSecond() {
            return this.mSecond;
        }

        public int getYear() {
            return this.mYear;
        }

        public int getMonth() {
            return this.mMonth;
        }

        public int getDay() {
            return this.mDay;
        }
    }

    private BeiJingTime getBeiJingTimeFromUtc(String str, String str2) {
        BeiJingTime beiJingTime = new BeiJingTime();
        try {
            Date date = new Date(new SimpleDateFormat("ddMMyyHHmmss").parse(str + str2).getTime() + 28800000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            beiJingTime.setYear(calendar.get(1));
            beiJingTime.setMonth(calendar.get(2) + 1);
            beiJingTime.setDay(calendar.get(5));
            beiJingTime.setHour(calendar.get(11));
            beiJingTime.setMinute(calendar.get(12));
            beiJingTime.setSecond(calendar.get(13));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return beiJingTime;
    }

    public GnssLocation getGnssLocation(GnssLocation gnssLocation) {
        if (-1 != isRMC()) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length < 10 || TextUtils.isEmpty(strArr[1])) {
                return null;
            }
            try {
                String str = this.mNmeaParts[1];
                gnssLocation.setRmcUtcTime((int) Float.parseFloat(str));
                if (TextUtils.isEmpty(this.mNmeaParts[2])) {
                    return null;
                }
                try {
                    gnssLocation.setStatus(this.mNmeaParts[2].getBytes()[0]);
                    if (TextUtils.isEmpty(this.mNmeaParts[3])) {
                        return null;
                    }
                    try {
                        double parseDouble = Double.parseDouble(this.mNmeaParts[3]);
                        int i = (int) (parseDouble / 100.0d);
                        gnssLocation.setLatitude(i + ((parseDouble - (i * CONSTANT_100)) / 60.0d));
                        if (TextUtils.isEmpty(this.mNmeaParts[4])) {
                            return null;
                        }
                        try {
                            gnssLocation.setNorthSouth(this.mNmeaParts[4].getBytes()[0]);
                            if (TextUtils.isEmpty(this.mNmeaParts[5])) {
                                return null;
                            }
                            try {
                                double parseDouble2 = Double.parseDouble(this.mNmeaParts[5]);
                                int i2 = (int) (parseDouble2 / 100.0d);
                                gnssLocation.setLongitude(i2 + ((parseDouble2 - (i2 * CONSTANT_100)) / 60.0d));
                                if (TextUtils.isEmpty(this.mNmeaParts[6])) {
                                    return null;
                                }
                                try {
                                    gnssLocation.setEastWest(this.mNmeaParts[6].getBytes()[0]);
                                    if (TextUtils.isEmpty(this.mNmeaParts[7])) {
                                        return null;
                                    }
                                    try {
                                        gnssLocation.setSpeed(Float.parseFloat(this.mNmeaParts[7]) * KNOTS_TO_KMPHR);
                                        float f = 0.0f;
                                        if (!TextUtils.isEmpty(this.mNmeaParts[8])) {
                                            try {
                                                float parseFloat = Float.parseFloat(this.mNmeaParts[8]);
                                                if (Float.compare(parseFloat, 0.0f) == 0) {
                                                    f = 360.0f;
                                                } else if (parseFloat <= 360.0f && parseFloat >= 0.0f) {
                                                    f = parseFloat;
                                                }
                                                gnssLocation.setCourse(f);
                                            } catch (NumberFormatException e) {
                                                e.printStackTrace();
                                                return null;
                                            }
                                        } else {
                                            gnssLocation.setCourse(0.0f);
                                        }
                                        if (TextUtils.isEmpty(this.mNmeaParts[9])) {
                                            return null;
                                        }
                                        try {
                                            BeiJingTime beiJingTimeFromUtc = getBeiJingTimeFromUtc(this.mNmeaParts[9], str);
                                            gnssLocation.setDay(beiJingTimeFromUtc.getDay());
                                            gnssLocation.setMonth(beiJingTimeFromUtc.getMonth());
                                            gnssLocation.setYear(beiJingTimeFromUtc.getYear());
                                            gnssLocation.setHour(beiJingTimeFromUtc.getHour());
                                            gnssLocation.setMinute(beiJingTimeFromUtc.getMinute());
                                            gnssLocation.setSecond(beiJingTimeFromUtc.getSecond());
                                            gnssLocation.setRmcEnable(true);
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                            return null;
                                        }
                                    } catch (NumberFormatException e3) {
                                        e3.printStackTrace();
                                        return null;
                                    }
                                } catch (NumberFormatException e4) {
                                    e4.printStackTrace();
                                    return null;
                                }
                            } catch (NumberFormatException e5) {
                                e5.printStackTrace();
                                return null;
                            }
                        } catch (NumberFormatException e6) {
                            e6.printStackTrace();
                            return null;
                        }
                    } catch (NumberFormatException e7) {
                        e7.printStackTrace();
                        return null;
                    }
                } catch (NumberFormatException e8) {
                    e8.printStackTrace();
                    return null;
                }
            } catch (NumberFormatException e9) {
                e9.printStackTrace();
                return null;
            }
        }
        if (-1 != isGGA()) {
            String[] strArr2 = this.mNmeaParts;
            if (strArr2.length < 10 || TextUtils.isEmpty(strArr2[1])) {
                return null;
            }
            try {
                gnssLocation.setGgaUtcTime((int) Float.parseFloat(this.mNmeaParts[1]));
                if (TextUtils.isEmpty(this.mNmeaParts[7])) {
                    return null;
                }
                try {
                    gnssLocation.setNumSV(Integer.parseInt(this.mNmeaParts[7]));
                    if (TextUtils.isEmpty(this.mNmeaParts[9])) {
                        return null;
                    }
                    try {
                        gnssLocation.setAltitude(Float.parseFloat(this.mNmeaParts[9]));
                        gnssLocation.setGgaEnable(true);
                    } catch (NumberFormatException e10) {
                        e10.printStackTrace();
                        return null;
                    }
                } catch (NumberFormatException e11) {
                    e11.printStackTrace();
                    return null;
                }
            } catch (NumberFormatException e12) {
                e12.printStackTrace();
                return null;
            }
        }
        if (-1 != isGSA()) {
            String[] strArr3 = this.mNmeaParts;
            if (strArr3.length < 18 || TextUtils.isEmpty(strArr3[15])) {
                return null;
            }
            try {
                gnssLocation.setPdop(Float.parseFloat(this.mNmeaParts[15]));
                if (TextUtils.isEmpty(this.mNmeaParts[16])) {
                    return null;
                }
                try {
                    gnssLocation.setHdop(Float.parseFloat(this.mNmeaParts[16]));
                    if (TextUtils.isEmpty(this.mNmeaParts[17]) || this.mNmeaParts[17].startsWith("*")) {
                        return null;
                    }
                    try {
                        gnssLocation.setVdop(Float.parseFloat(this.mNmeaParts[17].split("\\*")[0]));
                        gnssLocation.setGsaEnable(true);
                    } catch (NumberFormatException e13) {
                        e13.printStackTrace();
                        return null;
                    }
                } catch (NumberFormatException e14) {
                    e14.printStackTrace();
                    return null;
                }
            } catch (NumberFormatException e15) {
                e15.printStackTrace();
                return null;
            }
        }
        if (-1 != isGST()) {
            String[] strArr4 = this.mNmeaParts;
            if (strArr4.length < 8 || TextUtils.isEmpty(strArr4[7])) {
                return null;
            }
            try {
                gnssLocation.setAccuracy(Float.parseFloat(this.mNmeaParts[7]));
                gnssLocation.setGstEnable(true);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return gnssLocation;
    }

    public boolean isLocationSentence() {
        return GPGSA.equalsIgnoreCase(this.mNmeaParts[0]) || GPGGA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGSA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGGA.equalsIgnoreCase(this.mNmeaParts[0]);
    }

    public String getLatestPdop() {
        if (GPGSA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGSA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length <= 15 || TextUtils.isEmpty(strArr[15])) {
                return null;
            }
            return this.mNmeaParts[15];
        }
        return null;
    }

    public String getLatestVdop() {
        if (GPGSA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGSA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length <= 17 || TextUtils.isEmpty(strArr[17]) || this.mNmeaParts[17].startsWith("*")) {
                return null;
            }
            return this.mNmeaParts[17].split("\\*")[0];
        }
        return null;
    }

    public String getLatestHdop() {
        if (GPGGA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGGA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length <= 8 || TextUtils.isEmpty(strArr[8])) {
                return null;
            }
            return this.mNmeaParts[8];
        } else if (GPGSA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGSA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr2 = this.mNmeaParts;
            if (strArr2.length <= 16 || TextUtils.isEmpty(strArr2[16])) {
                return null;
            }
            return this.mNmeaParts[16];
        } else {
            return null;
        }
    }

    public String getGeoIdHeight() {
        if (GPGGA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGGA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length <= 11 || TextUtils.isEmpty(strArr[11])) {
                return null;
            }
            return this.mNmeaParts[11];
        }
        return null;
    }

    public String getAgeOfDgpsData() {
        if (GPGGA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGGA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length <= 13 || TextUtils.isEmpty(strArr[13])) {
                return null;
            }
            return this.mNmeaParts[13];
        }
        return null;
    }

    public String getDgpsId() {
        if (GPGGA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGGA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length <= 14 || TextUtils.isEmpty(strArr[14]) || this.mNmeaParts[14].startsWith("*")) {
                return null;
            }
            return this.mNmeaParts[14].split("\\*")[0];
        }
        return null;
    }

    public String getValidSatelliteNumber() {
        if (GPGGA.equalsIgnoreCase(this.mNmeaParts[0]) || GNGGA.equalsIgnoreCase(this.mNmeaParts[0])) {
            String[] strArr = this.mNmeaParts;
            if (strArr.length <= 7 || TextUtils.isEmpty(strArr[7])) {
                return null;
            }
            return this.mNmeaParts[7];
        }
        return null;
    }
}
