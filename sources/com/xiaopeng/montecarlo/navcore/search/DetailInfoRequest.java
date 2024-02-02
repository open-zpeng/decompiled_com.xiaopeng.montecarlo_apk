package com.xiaopeng.montecarlo.navcore.search;
/* loaded from: classes2.dex */
public class DetailInfoRequest {
    public final String mPoiId;
    public final double mPoiLat;
    public final double mPoiLon;
    public final String mPoiName;
    public final int mSearchId;
    public final double mUserLat;
    public final double mUserLon;

    private DetailInfoRequest(Builder builder) {
        this.mSearchId = builder.mSearchId;
        this.mPoiId = builder.mPoiId;
        this.mPoiName = builder.mPoiName;
        this.mUserLon = builder.mUserLon;
        this.mUserLat = builder.mUserLat;
        this.mPoiLon = builder.mPoiLon;
        this.mPoiLat = builder.mPoiLat;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private String mPoiId;
        private double mPoiLat;
        private double mPoiLon;
        private String mPoiName;
        private int mSearchId;
        private double mUserLat;
        private double mUserLon;

        public Builder mSearchId(int i) {
            this.mSearchId = i;
            return this;
        }

        public Builder mPoiId(String str) {
            this.mPoiId = str;
            return this;
        }

        public Builder mPoiName(String str) {
            this.mPoiName = str;
            return this;
        }

        public Builder mUserLon(double d) {
            this.mUserLon = d;
            return this;
        }

        public Builder mUserLat(double d) {
            this.mUserLat = d;
            return this;
        }

        public Builder mPoiLon(double d) {
            this.mPoiLon = d;
            return this;
        }

        public Builder mPoiLat(double d) {
            this.mPoiLat = d;
            return this;
        }

        public DetailInfoRequest build() {
            return new DetailInfoRequest(this);
        }
    }
}
