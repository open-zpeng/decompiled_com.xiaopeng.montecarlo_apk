package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EventTrackHistory implements Serializable {
    public BigInteger eventId;
    public int eventIndex;
    public ArrayList<EventTrackPoint> trackPoints;

    public EventTrackHistory() {
        this.eventId = new BigInteger("0");
        this.eventIndex = -1;
        this.trackPoints = new ArrayList<>();
    }

    public EventTrackHistory(BigInteger bigInteger, int i, ArrayList<EventTrackPoint> arrayList) {
        this.eventId = bigInteger;
        this.eventIndex = i;
        this.trackPoints = arrayList;
    }
}
