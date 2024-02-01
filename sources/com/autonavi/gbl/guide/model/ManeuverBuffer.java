package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ManeuverBuffer implements Serializable {
    public int arrowColor;
    public int backColor;
    public BinaryStream dataBuf;
    public int height;
    public int roadColor;
    public int width;

    public ManeuverBuffer() {
        this.dataBuf = new BinaryStream();
        this.width = 0;
        this.height = 0;
        this.backColor = 0;
        this.roadColor = 0;
        this.arrowColor = 0;
    }

    public ManeuverBuffer(BinaryStream binaryStream, int i, int i2, int i3, int i4, int i5) {
        this.dataBuf = binaryStream;
        this.width = i;
        this.height = i2;
        this.backColor = i3;
        this.roadColor = i4;
        this.arrowColor = i5;
    }
}
