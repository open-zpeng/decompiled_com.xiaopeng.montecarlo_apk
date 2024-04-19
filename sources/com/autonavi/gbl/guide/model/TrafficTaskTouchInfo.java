package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class TrafficTaskTouchInfo implements Serializable {
    public String appendData;
    public int appendType;
    public Coord2DDouble coord2D;
    public boolean displayAudio;
    public BigInteger linkid;
    public short scene;
    public boolean showWindow;
    public long time;
    public short touchSpeed;

    public TrafficTaskTouchInfo() {
        this.scene = (short) 0;
        this.touchSpeed = (short) 0;
        this.showWindow = false;
        this.displayAudio = false;
        this.coord2D = new Coord2DDouble();
        this.linkid = new BigInteger("0");
        this.time = 0L;
        this.appendType = 0;
        this.appendData = "";
    }

    public TrafficTaskTouchInfo(short s, short s2, boolean z, boolean z2, Coord2DDouble coord2DDouble, BigInteger bigInteger, long j, int i, String str) {
        this.scene = s;
        this.touchSpeed = s2;
        this.showWindow = z;
        this.displayAudio = z2;
        this.coord2D = coord2DDouble;
        this.linkid = bigInteger;
        this.time = j;
        this.appendType = i;
        this.appendData = str;
    }
}
