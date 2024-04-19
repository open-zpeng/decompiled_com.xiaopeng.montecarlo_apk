package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class BinaryStream implements Serializable {
    public byte[] buffer;

    public BinaryStream() {
    }

    public BinaryStream(byte[] bArr) {
        this.buffer = bArr;
    }
}
