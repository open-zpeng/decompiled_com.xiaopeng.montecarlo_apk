package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GpsTrackPoint implements Serializable {
    public float f32Accuracy;
    public float f32Course;
    public float f32Speed;
    public double f64Altitude;
    public double f64Latitude;
    public double f64Longitude;
    public int n32SateliteTotal;
    public long n64TickTime;
    public int nSectionId;

    public GpsTrackPoint() {
        this.f64Longitude = 0.0d;
        this.f64Latitude = 0.0d;
        this.f64Altitude = 0.0d;
        this.f32Accuracy = 0.0f;
        this.f32Speed = 0.0f;
        this.f32Course = 0.0f;
        this.n64TickTime = 0L;
        this.n32SateliteTotal = 0;
        this.nSectionId = -1;
    }

    public GpsTrackPoint(double d, double d2, double d3, float f, float f2, float f3, long j, int i, int i2) {
        this.f64Longitude = d;
        this.f64Latitude = d2;
        this.f64Altitude = d3;
        this.f32Accuracy = f;
        this.f32Speed = f2;
        this.f32Course = f3;
        this.n64TickTime = j;
        this.n32SateliteTotal = i;
        this.nSectionId = i2;
    }
}
