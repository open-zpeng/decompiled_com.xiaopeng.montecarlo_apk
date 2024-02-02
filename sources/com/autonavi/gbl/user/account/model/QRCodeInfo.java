package com.autonavi.gbl.user.account.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class QRCodeInfo implements Serializable {
    public BinaryStream data;
    public String id;
    public int timeout;

    public QRCodeInfo() {
        this.id = "";
        this.data = new BinaryStream();
        this.timeout = 0;
    }

    public QRCodeInfo(String str, BinaryStream binaryStream, int i) {
        this.id = str;
        this.data = binaryStream;
        this.timeout = i;
    }
}
