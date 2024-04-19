package com.xiaopeng.montecarlo.trafficevent;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.util.List;
/* loaded from: classes3.dex */
public class TrafficEventPopParam {
    public static final int EVENT_TYPE_AVOID_JAM = 1;
    public static final int EVENT_TYPE_INCIDENT = 2;
    public static final int EVENT_TYPE_POI = 0;
    public static final int EVENT_TYPE_SCRATCH_SPOT = 3;
    public String mDes;
    public String mEventId;
    public int mEventType;
    public List<String> mImages;
    public boolean mIsZoom;
    public String mJamETA;
    public String mJamLen;
    public String mJamRoadName;
    public double mLat;
    public Coord2DDouble mLoc;
    public double mLon;
    public String mUpdateTime;

    private TrafficEventPopParam(Builder builder) {
        this.mLoc = new Coord2DDouble();
        this.mIsZoom = false;
        this.mEventId = builder.mEventId;
        this.mJamLen = builder.mJamLen;
        this.mJamETA = builder.mJamETA;
        this.mJamRoadName = builder.mJamRoadName;
        this.mLoc.lon = builder.mLoc.lon;
        this.mLoc.lat = builder.mLoc.lat;
        this.mIsZoom = builder.mIsZoom;
        this.mLat = builder.mLat;
        this.mLon = builder.mLon;
        this.mEventType = builder.mEventType;
        this.mUpdateTime = builder.mUpdateTime;
        this.mDes = builder.mDes;
        this.mImages = builder.mImages;
    }

    public String toString() {
        return "TrafficEventPopParam: mEventId: " + this.mEventId + ", mEventType: " + this.mEventType + ", mJamLen: " + this.mJamLen + ", mJamETA: " + this.mJamETA + ", mJamRoadName: " + this.mJamRoadName + ", mLoc: [" + this.mLoc.lat + "," + this.mLoc.lon + "], mLat: " + this.mLat + ", mLon: " + this.mLon + ", mUpdateTime: " + this.mUpdateTime + ", mDes: " + this.mDes;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private String mDes;
        private int mEventType;
        private List<String> mImages;
        private String mJamETA;
        private String mJamLen;
        private String mJamRoadName;
        private double mLat;
        private double mLon;
        private String mUpdateTime;
        private String mEventId = "";
        private Coord2DDouble mLoc = new Coord2DDouble();
        private boolean mIsZoom = false;

        public Builder(int i) {
            this.mEventType = i;
        }

        public Builder setEventId(String str) {
            this.mEventId = str;
            return this;
        }

        public Builder setJamLen(String str) {
            this.mJamLen = str;
            return this;
        }

        public Builder setJamETA(String str) {
            this.mJamETA = str;
            return this;
        }

        public Builder setJamRoadName(String str) {
            this.mJamRoadName = str;
            return this;
        }

        public Builder setLoc(Coord2DDouble coord2DDouble) {
            if (coord2DDouble != null) {
                this.mLoc.lon = coord2DDouble.lon;
                this.mLoc.lat = coord2DDouble.lat;
            }
            return this;
        }

        public Builder setLon(double d) {
            this.mLon = d;
            return this;
        }

        public Builder setLat(double d) {
            this.mLat = d;
            return this;
        }

        public Builder setIsZoom(boolean z) {
            this.mIsZoom = z;
            return this;
        }

        public Builder setUpdateTime(String str) {
            this.mUpdateTime = str;
            return this;
        }

        public Builder setDes(String str) {
            this.mDes = str;
            return this;
        }

        public Builder setImages(List<String> list) {
            this.mImages = list;
            return this;
        }

        public TrafficEventPopParam build() {
            return new TrafficEventPopParam(this);
        }
    }
}
