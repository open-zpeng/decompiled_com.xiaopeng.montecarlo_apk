package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FileOperationEvent implements Serializable {
    public boolean bCheckKey;
    public String fileKey;
    public String fileURI;
    public int timeout;
    public long type;

    public FileOperationEvent() {
        this.type = 0L;
        this.fileKey = "";
        this.fileURI = "";
        this.timeout = 8000;
        this.bCheckKey = true;
    }

    public FileOperationEvent(long j, String str, String str2, int i, boolean z) {
        this.type = j;
        this.fileKey = str;
        this.fileURI = str2;
        this.timeout = i;
        this.bCheckKey = z;
    }
}
