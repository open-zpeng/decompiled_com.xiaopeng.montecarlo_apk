package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.pos.model.LocDataType;
import com.xiaopeng.montecarlo.navcore.location.GnssLocation;
import java.io.Serializable;
import java.math.BigInteger;
import org.objectweb.asm.Opcodes;
/* loaded from: classes2.dex */
public class LocGnss implements Serializable {
    public float accuracy;
    public float alt;
    public float arsCourse;
    public float course;
    @LocDataType.LocDataType1
    public int dataType;
    public int day;
    public int flag;
    public float hdop;
    public int hour;
    public byte isEW;
    public short isEncrypted;
    public byte isNS;
    public int minute;
    public byte mode;
    public int month;
    public int num;
    public long overhead;
    public float pdop;
    public int second;
    public int sourType;
    public int spdState;
    public float speed;
    public Coord2DDouble stPt;
    public Coord2DDouble stPtS;
    public byte status;
    public BigInteger tickTime;
    public float vdop;
    public int year;

    public LocGnss() {
        this.dataType = 16;
        this.sourType = 0;
        this.mode = (byte) 0;
        this.status = GnssLocation.LOC_INVALID;
        this.isEncrypted = (short) 0;
        this.isNS = (byte) 78;
        this.isEW = (byte) 69;
        this.stPt = new Coord2DDouble();
        this.stPtS = new Coord2DDouble();
        this.speed = 0.0f;
        this.course = 0.0f;
        this.alt = 0.0f;
        this.num = 0;
        this.hdop = -1.0f;
        this.vdop = -1.0f;
        this.pdop = -1.0f;
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.accuracy = 0.0f;
        this.flag = -1;
        this.spdState = Opcodes.ARETURN;
        this.arsCourse = 0.0f;
        this.tickTime = new BigInteger("0");
        this.overhead = 0L;
    }

    public LocGnss(@LocDataType.LocDataType1 int i, int i2, byte b, byte b2, short s, byte b3, byte b4, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, float f, float f2, float f3, int i3, float f4, float f5, float f6, int i4, int i5, int i6, int i7, int i8, int i9, float f7, int i10, int i11, float f8, BigInteger bigInteger, long j) {
        this.dataType = i;
        this.sourType = i2;
        this.mode = b;
        this.status = b2;
        this.isEncrypted = s;
        this.isNS = b3;
        this.isEW = b4;
        this.stPt = coord2DDouble;
        this.stPtS = coord2DDouble2;
        this.speed = f;
        this.course = f2;
        this.alt = f3;
        this.num = i3;
        this.hdop = f4;
        this.vdop = f5;
        this.pdop = f6;
        this.year = i4;
        this.month = i5;
        this.day = i6;
        this.hour = i7;
        this.minute = i8;
        this.second = i9;
        this.accuracy = f7;
        this.flag = i10;
        this.spdState = i11;
        this.arsCourse = f8;
        this.tickTime = bigInteger;
        this.overhead = j;
    }
}
