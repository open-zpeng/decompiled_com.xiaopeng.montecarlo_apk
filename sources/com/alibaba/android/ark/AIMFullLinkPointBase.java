package com.alibaba.android.ark;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMFullLinkPointBase {
    public String appKey;
    public String appVersion;
    public String code;
    public String deviceId;
    public int direction;
    public HashMap<String, String> ext;
    public String index;
    public String parent;
    public String sdkVersion;
    public String serveId;
    public String stepId;
    public String subTraceType;
    public String tcId;
    public long timeStamp;
    public String traceType;
    public int typeId;
    public String uid;

    public AIMFullLinkPointBase(int i, String str, String str2, String str3, HashMap<String, String> hashMap, String str4, String str5, String str6, String str7, String str8, long j, int i2, String str9, String str10, String str11, String str12, String str13) {
        this.typeId = 5;
        this.timeStamp = 0L;
        this.direction = 0;
        this.typeId = i;
        this.tcId = str;
        this.serveId = str2;
        this.sdkVersion = str3;
        this.ext = hashMap;
        this.traceType = str4;
        this.subTraceType = str5;
        this.stepId = str6;
        this.parent = str7;
        this.code = str8;
        this.timeStamp = j;
        this.direction = i2;
        this.appKey = str9;
        this.appVersion = str10;
        this.deviceId = str11;
        this.index = str12;
        this.uid = str13;
    }

    public AIMFullLinkPointBase() {
        this.typeId = 5;
        this.timeStamp = 0L;
        this.direction = 0;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public String getTcId() {
        return this.tcId;
    }

    public String getServeId() {
        return this.serveId;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public HashMap<String, String> getExt() {
        return this.ext;
    }

    public String getTraceType() {
        return this.traceType;
    }

    public String getSubTraceType() {
        return this.subTraceType;
    }

    public String getStepId() {
        return this.stepId;
    }

    public String getParent() {
        return this.parent;
    }

    public String getCode() {
        return this.code;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getIndex() {
        return this.index;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "AIMFullLinkPointBase{typeId=" + this.typeId + ",tcId=" + this.tcId + ",serveId=" + this.serveId + ",sdkVersion=" + this.sdkVersion + ",ext=" + this.ext + ",traceType=" + this.traceType + ",subTraceType=" + this.subTraceType + ",stepId=" + this.stepId + ",parent=" + this.parent + ",code=" + this.code + ",timeStamp=" + this.timeStamp + ",direction=" + this.direction + ",appKey=" + this.appKey + ",appVersion=" + this.appVersion + ",deviceId=" + this.deviceId + ",index=" + this.index + ",uid=" + this.uid + "}";
    }
}
