package com.xiaopeng.montecarlo.root.util;

import android.app.Application;
import android.location.Location;
import androidx.annotation.NonNull;
import com.xiaopeng.lib.framework.locationmodule.LocationModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationServiceException;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class LocationDataUploader {
    private static final long GPS_TIME_CAN_OFFSET = 1262304000000L;
    private static final int LOG_OUTPUT_LIMIT_TIME = 30;
    private static final L.Tag TAG = new L.Tag("LocationDataUploader");
    private final Application mApplication;
    private ILocationProvider mProvider;
    private volatile boolean mStart = false;
    private int mGPSLogOutputCount = 0;
    private int mDRLogOutputCount = 0;

    private double encodeLatLon(double d, int i) {
        return i != 0 ? d / (i / 1000.0f) : d;
    }

    public LocationDataUploader(@NonNull Application application) {
        this.mApplication = application;
        start();
    }

    private void start() {
        this.mProvider = (ILocationProvider) Module.get(LocationModuleEntry.class).get(ILocationProvider.class);
        try {
            this.mProvider.start(this.mApplication);
            this.mStart = true;
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
        }
    }

    public void uploadGPSLocation(Location location, Location location2, int i, String str, int i2) {
        if (!this.mStart || !this.mProvider.serviceStarted()) {
            start();
            if (!this.mStart) {
                return;
            }
        }
        if (location == null || location.getProvider() == null || location2 == null) {
            return;
        }
        int i3 = (!location.getProvider().equals("gps") && location.getProvider().equals("network")) ? 5 : 1;
        long time = location.getTime();
        if (time > GPS_TIME_CAN_OFFSET) {
            time -= GPS_TIME_CAN_OFFSET;
        }
        try {
            this.mProvider.publishLocation(this.mProvider.buildLocation().category(ILocation.Category.GPS_LOCATION).latitude((float) location2.getLatitude()).longitude((float) location2.getLongitude()).rawLatitude((float) location.getLatitude()).rawLongitude((float) location.getLongitude()).angle(location.getBearing()).speed(location.getSpeed()).accuracy((int) location.getAccuracy()).satellites(i).altitude((int) location.getAltitude()).time(time).city(str).adCode(String.valueOf(i2)).sourceType(i3));
        } catch (ILocationServiceException e) {
            L.printStackTrace(TAG, e);
        }
        int i4 = this.mGPSLogOutputCount;
        if (i4 > 30) {
            L.Tag tag = TAG;
            L.i(tag, "G," + encodeLatLon(location2.getLatitude(), i2) + "," + encodeLatLon(location2.getLongitude(), i2) + "," + location.getBearing() + "," + location.getSpeed() + "," + i + "," + i2);
            this.mGPSLogOutputCount = 0;
            return;
        }
        this.mGPSLogOutputCount = i4 + 1;
    }

    public void uploadGnssLocation(double d, double d2, double d3, double d4, float f, float f2, float f3, int i, float f4, long j, String str, int i2) {
        if (!this.mStart || !this.mProvider.serviceStarted()) {
            start();
            if (!this.mStart) {
                return;
            }
        }
        try {
            this.mProvider.publishLocation(this.mProvider.buildLocation().category(ILocation.Category.GPS_LOCATION).latitude((float) d).longitude((float) d2).rawLatitude((float) d3).rawLongitude((float) d4).angle(f).speed(f2).accuracy((int) f3).satellites(i).altitude((int) f4).time(j > GPS_TIME_CAN_OFFSET ? j - GPS_TIME_CAN_OFFSET : j).city(str).adCode(String.valueOf(i2)).sourceType(1));
        } catch (ILocationServiceException e) {
            L.printStackTrace(TAG, e);
        }
        int i3 = this.mGPSLogOutputCount;
        if (i3 > 30) {
            L.Tag tag = TAG;
            L.i(tag, "G," + encodeLatLon(d, i2) + "," + encodeLatLon(d2, i2) + "," + f + "," + f2 + "," + i + "," + i2);
            this.mGPSLogOutputCount = 0;
            return;
        }
        this.mGPSLogOutputCount = i3 + 1;
    }

    public void forceOutputGnssLog() {
        this.mGPSLogOutputCount = 31;
    }

    public void uploadDRLocation(float f, float f2, float f3, float f4, String str, int i) {
        if (!this.mStart || !this.mProvider.serviceStarted()) {
            start();
            if (!this.mStart) {
                return;
            }
        }
        try {
            this.mProvider.publishLocation(this.mProvider.buildLocation().category(ILocation.Category.DR_LOCATION).latitude(f).longitude(f2).angle(f3).speed(f4).city(str).adCode(String.valueOf(i)));
        } catch (ILocationServiceException e) {
            L.printStackTrace(TAG, e);
        }
        int i2 = this.mDRLogOutputCount;
        if (i2 > 30) {
            L.Tag tag = TAG;
            L.i(tag, "D," + encodeLatLon(f, i) + "," + encodeLatLon(f2, i) + "," + f3 + "," + f4 + "," + i);
            this.mDRLogOutputCount = 0;
            return;
        }
        this.mDRLogOutputCount = i2 + 1;
    }
}
