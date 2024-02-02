package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgDataInternalTexture implements Serializable {
    public byte[] buffer;
    public String name;
    public int type;

    public MsgDataInternalTexture() {
        this.name = "";
        this.type = 0;
        this.buffer = null;
    }

    public MsgDataInternalTexture(String str, int i, byte[] bArr) {
        this.name = str;
        this.type = i;
        this.buffer = bArr;
    }
}
