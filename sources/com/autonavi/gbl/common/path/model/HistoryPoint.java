package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class HistoryPoint implements Serializable {
    public float angle;
    public boolean isLastMatch;
    public Coord2DDouble pos;
    public float speed;
    public long tickTime;

    public HistoryPoint() {
        this.pos = new Coord2DDouble();
        this.angle = 0.0f;
        this.speed = 0.0f;
        this.tickTime = 0L;
        this.isLastMatch = false;
    }

    public HistoryPoint(Coord2DDouble coord2DDouble, float f, float f2, long j, boolean z) {
        this.pos = coord2DDouble;
        this.angle = f;
        this.speed = f2;
        this.tickTime = j;
        this.isLastMatch = z;
    }
}
