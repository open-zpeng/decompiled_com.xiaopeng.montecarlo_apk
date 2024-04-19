package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AutopilotData implements Serializable {
    public BinaryStream data;

    public AutopilotData() {
        this.data = new BinaryStream();
    }

    public AutopilotData(BinaryStream binaryStream) {
        this.data = binaryStream;
    }
}
