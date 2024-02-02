package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocPoint implements Serializable {
    public float course;
    public boolean isLastMatch;
    public String pointInfo;
    public float speed;
    public Coord3DDouble stPos;
    public BigInteger tickTime;

    public LocPoint() {
        this.stPos = new Coord3DDouble();
        this.course = 0.0f;
        this.speed = 0.0f;
        this.tickTime = new BigInteger("0");
        this.isLastMatch = false;
        this.pointInfo = "";
    }

    public LocPoint(Coord3DDouble coord3DDouble, float f, float f2, BigInteger bigInteger, boolean z, String str) {
        this.stPos = coord3DDouble;
        this.course = f;
        this.speed = f2;
        this.tickTime = bigInteger;
        this.isLastMatch = z;
        this.pointInfo = str;
    }
}
