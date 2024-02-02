package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LineItem implements Serializable {
    public byte[] lineData;

    public LineItem() {
        this.lineData = null;
    }

    public LineItem(byte[] bArr) {
        this.lineData = bArr;
    }
}
