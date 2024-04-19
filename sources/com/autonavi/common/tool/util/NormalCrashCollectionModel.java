package com.autonavi.common.tool.util;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class NormalCrashCollectionModel {
    private static final String GAP = "::";
    private static final SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(TimeFormatUtil.DEFAULT_PATTERN);
    private static final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
    public String adiu;
    public String crashDate;
    public String crashProcessReStartDate;
    public String crashProcessReStartTime;
    public String crashProcessReStartTimestamp;
    public String crashProcessRestartRunTime;
    public String crashProcessRunTime;
    public String crashProcessStartDate;
    public String crashProcessStartTime;
    public String crashProcessStartTimestamp;
    public String crashTime;
    public String crashTimestamp;
    public String dibv;
    public String dic;
    public String diu;
    public String diu2;
    public String diu3;
    public String div;
    public String foreground;
    public String model;
    public String os;
    public String osVersion;
    public String session;

    public void setProcessReStartTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.crashProcessReStartTime = str;
        try {
            Date parse = simpleDateFormat1.parse(str);
            this.crashProcessReStartTimestamp = String.valueOf(parse.getTime());
            this.crashProcessReStartDate = simpleDateFormat2.format(parse);
        } catch (Exception unused) {
        }
    }

    public void setProcessReStartTime(long j) {
        this.crashProcessReStartTimestamp = String.valueOf(j);
        Date date = new Date(j);
        try {
            this.crashProcessReStartTime = simpleDateFormat1.format(date);
            this.crashProcessReStartDate = simpleDateFormat2.format(date);
        } catch (Exception unused) {
        }
    }

    public void setProcessReStartTime() {
        Date applicationInitTime = CrashFileManager.getInstance().getApplicationInitTime();
        this.crashProcessReStartTimestamp = String.valueOf(applicationInitTime.getTime());
        try {
            this.crashProcessReStartTime = simpleDateFormat1.format(applicationInitTime);
            this.crashProcessReStartDate = simpleDateFormat2.format(applicationInitTime);
        } catch (Exception unused) {
        }
    }

    public void setProcessStartTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.crashProcessStartTime = str;
        try {
            Date parse = simpleDateFormat1.parse(str);
            this.crashProcessStartTimestamp = String.valueOf(parse.getTime());
            this.crashProcessStartDate = simpleDateFormat2.format(parse);
        } catch (Exception unused) {
        }
    }

    public void setCrashTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.crashTime = str;
        try {
            Date parse = simpleDateFormat1.parse(str);
            this.crashTimestamp = String.valueOf(parse.getTime());
            this.crashDate = simpleDateFormat2.format(parse);
        } catch (Exception unused) {
        }
    }

    public void countProcessRunTime() {
        if (TextUtils.isEmpty(this.crashProcessStartTimestamp) || TextUtils.isEmpty(this.crashTimestamp)) {
            this.crashProcessRunTime = "0";
            return;
        }
        try {
            this.crashProcessRunTime = String.valueOf(Long.valueOf(Math.abs(Long.valueOf(this.crashTimestamp).longValue() - Long.valueOf(this.crashProcessStartTimestamp).longValue())));
        } catch (Exception unused) {
        }
    }

    public void countProcessReRunTime() {
        if (TextUtils.isEmpty(this.crashProcessReStartTimestamp) || TextUtils.isEmpty(this.crashTimestamp)) {
            this.crashProcessRestartRunTime = "0";
            return;
        }
        try {
            this.crashProcessRestartRunTime = String.valueOf(Long.valueOf(Math.abs(Long.valueOf(this.crashProcessReStartTimestamp).longValue() - Long.valueOf(this.crashTimestamp).longValue())));
        } catch (Exception unused) {
        }
    }

    public static String modelToString(NormalCrashCollectionModel normalCrashCollectionModel) {
        return normalCrashCollectionModel == null ? "" : normalCrashCollectionModel.toString();
    }

    public static NormalCrashCollectionModel stringToModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(GAP);
        if (split.length != 19) {
            return null;
        }
        try {
            NormalCrashCollectionModel normalCrashCollectionModel = new NormalCrashCollectionModel();
            normalCrashCollectionModel.diu = split[0];
            normalCrashCollectionModel.diu2 = split[1];
            normalCrashCollectionModel.diu3 = split[2];
            normalCrashCollectionModel.adiu = split[3];
            normalCrashCollectionModel.model = split[4];
            normalCrashCollectionModel.os = split[5];
            normalCrashCollectionModel.div = split[6];
            normalCrashCollectionModel.dibv = split[7];
            normalCrashCollectionModel.session = split[8];
            normalCrashCollectionModel.dic = split[9];
            normalCrashCollectionModel.osVersion = split[10];
            normalCrashCollectionModel.foreground = split[11];
            normalCrashCollectionModel.crashProcessStartTime = split[12];
            normalCrashCollectionModel.crashProcessStartTimestamp = split[13];
            normalCrashCollectionModel.crashProcessStartDate = split[14];
            normalCrashCollectionModel.crashTime = split[15];
            normalCrashCollectionModel.crashTimestamp = split[16];
            normalCrashCollectionModel.crashDate = split[17];
            normalCrashCollectionModel.crashProcessRunTime = split[18];
            return normalCrashCollectionModel;
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        return this.diu + GAP + this.diu2 + GAP + this.diu3 + GAP + this.adiu + GAP + this.model + GAP + this.os + GAP + this.div + GAP + this.dibv + GAP + this.session + GAP + this.dic + GAP + this.osVersion + GAP + this.foreground + GAP + this.crashProcessStartTime + GAP + this.crashProcessStartTimestamp + GAP + this.crashProcessStartDate + GAP + this.crashTime + GAP + this.crashTimestamp + GAP + this.crashDate + GAP + this.crashProcessRunTime;
    }
}
