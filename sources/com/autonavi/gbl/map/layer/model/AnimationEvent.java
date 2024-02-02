package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.map.layer.model.AnimationStatusType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AnimationEvent implements Serializable {
    public int engineID;
    @AnimationStatusType.AnimationStatusType1
    public int status;
    public long userData;

    public AnimationEvent() {
        this.engineID = 0;
        this.status = 1;
        this.userData = 0L;
    }

    public AnimationEvent(int i, @AnimationStatusType.AnimationStatusType1 int i2, long j) {
        this.engineID = i;
        this.status = i2;
        this.userData = j;
    }
}
