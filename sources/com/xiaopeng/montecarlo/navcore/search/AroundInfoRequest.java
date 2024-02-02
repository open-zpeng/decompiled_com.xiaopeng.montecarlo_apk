package com.xiaopeng.montecarlo.navcore.search;
/* loaded from: classes2.dex */
public class AroundInfoRequest {
    public final String mKeyword;
    public final double mPoiLat;
    public final double mPoiLon;
    public final String mRange;
    public final int mSearchId;

    private AroundInfoRequest(Builder builder) {
        this.mKeyword = builder.mKeyword;
        this.mRange = builder.mRange;
        this.mPoiLon = builder.mPoiLon;
        this.mPoiLat = builder.mPoiLat;
        this.mSearchId = builder.mSearchId;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private String mKeyword;
        private double mPoiLat;
        private double mPoiLon;
        private String mRange;
        private int mSearchId;

        public Builder mKeyword(String str) {
            this.mKeyword = str;
            return this;
        }

        public Builder mRange(String str) {
            this.mRange = str;
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

        public Builder mSearchId(int i) {
            this.mSearchId = i;
            return this;
        }

        public AroundInfoRequest build() {
            return new AroundInfoRequest(this);
        }
    }
}
