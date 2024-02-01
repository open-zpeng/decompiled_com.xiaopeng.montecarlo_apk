package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class QrCodeStream implements Serializable {
    public long height;
    public BinaryStream qrData;
    public long width;

    public QrCodeStream() {
        this.qrData = new BinaryStream();
        this.width = 0L;
        this.height = 0L;
    }

    public QrCodeStream(BinaryStream binaryStream, long j, long j2) {
        this.qrData = binaryStream;
        this.width = j;
        this.height = j2;
    }
}
