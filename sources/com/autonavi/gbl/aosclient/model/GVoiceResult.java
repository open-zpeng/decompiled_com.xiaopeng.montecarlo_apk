package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GVoiceResult implements Serializable {
    public String keyword;
    public String schema;
    public String subTaskType;
    public String taskResult;
    public String taskType;
    public GVoiceTrafficResult trafficResult;
    public String voiceText;

    public GVoiceResult() {
        this.keyword = "";
        this.voiceText = "";
        this.taskType = "";
        this.subTaskType = "";
        this.schema = "";
        this.taskResult = "";
        this.trafficResult = new GVoiceTrafficResult();
    }

    public GVoiceResult(String str, String str2, String str3, String str4, String str5, String str6, GVoiceTrafficResult gVoiceTrafficResult) {
        this.keyword = str;
        this.voiceText = str2;
        this.taskType = str3;
        this.subTaskType = str4;
        this.schema = str5;
        this.taskResult = str6;
        this.trafficResult = gVoiceTrafficResult;
    }
}
