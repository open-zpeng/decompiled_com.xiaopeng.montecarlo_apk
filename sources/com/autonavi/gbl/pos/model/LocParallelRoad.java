package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.LinkType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocParallelRoad implements Serializable {
    @Formway.Formway1
    public int formway;
    @LinkType.LinkType1
    public int linkType;
    public BigInteger roadId;
    public int type;

    public LocParallelRoad() {
        this.roadId = new BigInteger("0");
        this.type = 0;
        this.formway = -1;
        this.linkType = -1;
    }

    public LocParallelRoad(BigInteger bigInteger, int i, @Formway.Formway1 int i2, @LinkType.LinkType1 int i3) {
        this.roadId = bigInteger;
        this.type = i;
        this.formway = i2;
        this.linkType = i3;
    }
}
