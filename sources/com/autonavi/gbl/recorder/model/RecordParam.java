package com.autonavi.gbl.recorder.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RecordParam implements Serializable {
    public boolean autoDelete;
    public int maxFileSize;
    public int maxFiles;
    public String recordPath;

    public RecordParam() {
        this.autoDelete = true;
        this.maxFileSize = 10;
        this.maxFiles = 60;
        this.recordPath = "";
    }

    public RecordParam(boolean z, int i, int i2, String str) {
        this.autoDelete = z;
        this.maxFileSize = i;
        this.maxFiles = i2;
        this.recordPath = str;
    }
}
