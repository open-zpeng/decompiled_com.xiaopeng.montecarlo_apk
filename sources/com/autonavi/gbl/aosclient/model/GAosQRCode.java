package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GAosQRCode implements Serializable {
    public BinaryStream buffer;
    public String id;
    public int timeout;

    public GAosQRCode() {
        this.id = "";
        this.buffer = new BinaryStream();
        this.timeout = 0;
    }

    public GAosQRCode(String str, BinaryStream binaryStream, int i) {
        this.id = str;
        this.buffer = binaryStream;
        this.timeout = i;
    }
}
