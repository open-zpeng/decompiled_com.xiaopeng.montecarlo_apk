package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class voiceTask implements Serializable {
    public short taskType;
    public String text;

    public voiceTask() {
        this.taskType = (short) 0;
        this.text = "";
    }

    public voiceTask(short s, String str) {
        this.taskType = s;
        this.text = str;
    }
}
