package com.autonavi.gbl.recorder.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class RecorderLaneResourceInfo implements Serializable {
    public BinaryStream buffer;

    public RecorderLaneResourceInfo() {
        this.buffer = new BinaryStream();
    }

    public RecorderLaneResourceInfo(BinaryStream binaryStream) {
        this.buffer = binaryStream;
    }
}
