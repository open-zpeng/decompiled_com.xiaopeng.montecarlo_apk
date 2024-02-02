package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneResourceInfo implements Serializable {
    public BinaryStream buffer;

    public LaneResourceInfo() {
        this.buffer = new BinaryStream();
    }

    public LaneResourceInfo(BinaryStream binaryStream) {
        this.buffer = binaryStream;
    }
}
