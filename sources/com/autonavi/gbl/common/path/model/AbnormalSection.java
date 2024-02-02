package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.AbnormalStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AbnormalSection implements Serializable {
    public long beginLinkID;
    public int beginSegID;
    public int diffTime;
    public long endLinkID;
    public int endSegID;
    public long length;
    public short realSpeed;
    public int realTravelTime;
    @AbnormalStatus.AbnormalStatus1
    public int status;

    public AbnormalSection() {
        this.status = 0;
        this.length = 0L;
        this.realTravelTime = 0;
        this.diffTime = 0;
        this.beginSegID = 0;
        this.endSegID = 0;
        this.beginLinkID = 0L;
        this.endLinkID = 0L;
        this.realSpeed = (short) 0;
    }

    public AbnormalSection(@AbnormalStatus.AbnormalStatus1 int i, long j, int i2, int i3, int i4, int i5, long j2, long j3, short s) {
        this.status = i;
        this.length = j;
        this.realTravelTime = i2;
        this.diffTime = i3;
        this.beginSegID = i4;
        this.endSegID = i5;
        this.beginLinkID = j2;
        this.endLinkID = j3;
        this.realSpeed = s;
    }
}
