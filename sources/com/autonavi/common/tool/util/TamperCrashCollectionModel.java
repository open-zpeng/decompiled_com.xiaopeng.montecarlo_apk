package com.autonavi.common.tool.util;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class TamperCrashCollectionModel {
    private static final String GAP = "::";
    public String appVersion = "";
    public long installTime = 0;
    public long appStartTime = 0;
    public int tamperType = 0;
    public int fixStatus = 0;
    public int errorCode = 0;

    public static String modelToString(TamperCrashCollectionModel tamperCrashCollectionModel) {
        return tamperCrashCollectionModel == null ? "" : tamperCrashCollectionModel.toString();
    }

    public static TamperCrashCollectionModel stringToModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(GAP);
        if (split.length != 6) {
            return null;
        }
        try {
            TamperCrashCollectionModel tamperCrashCollectionModel = new TamperCrashCollectionModel();
            tamperCrashCollectionModel.appVersion = split[0];
            tamperCrashCollectionModel.installTime = Long.parseLong(split[1]);
            tamperCrashCollectionModel.appStartTime = Long.parseLong(split[2]);
            tamperCrashCollectionModel.tamperType = Integer.parseInt(split[3]);
            tamperCrashCollectionModel.fixStatus = Integer.parseInt(split[4]);
            tamperCrashCollectionModel.errorCode = Integer.parseInt(split[5]);
            return tamperCrashCollectionModel;
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        return this.appVersion + GAP + this.installTime + GAP + this.appStartTime + GAP + this.tamperType + GAP + this.fixStatus + GAP + this.errorCode;
    }
}
