package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class JamBubblesSegmentData implements Serializable {
    public Coord2DDouble bottomRight;
    public String congestionId;
    public long eventId;
    public String roadName;
    public Coord2DDouble topLeft;
    public int trendCode;
    public int trendEtaMatch;

    public JamBubblesSegmentData() {
        this.congestionId = "";
        this.eventId = 0L;
        this.topLeft = new Coord2DDouble();
        this.bottomRight = new Coord2DDouble();
        this.roadName = "";
        this.trendCode = 0;
        this.trendEtaMatch = 0;
    }

    public JamBubblesSegmentData(String str, long j, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, String str2, int i, int i2) {
        this.congestionId = str;
        this.eventId = j;
        this.topLeft = coord2DDouble;
        this.bottomRight = coord2DDouble2;
        this.roadName = str2;
        this.trendCode = i;
        this.trendEtaMatch = i2;
    }
}
