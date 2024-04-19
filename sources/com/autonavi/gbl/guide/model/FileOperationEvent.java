package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FileOperationEvent implements Serializable {
    public String fileKey;
    public String fileURI;

    public FileOperationEvent() {
        this.fileKey = "";
        this.fileURI = "";
    }

    public FileOperationEvent(String str, String str2) {
        this.fileKey = str;
        this.fileURI = str2;
    }
}
