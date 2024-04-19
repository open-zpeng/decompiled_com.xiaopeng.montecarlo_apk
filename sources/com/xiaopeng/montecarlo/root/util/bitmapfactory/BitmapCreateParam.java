package com.xiaopeng.montecarlo.root.util.bitmapfactory;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class BitmapCreateParam extends BitmapFactoryParam {
    public int mDstHeight;
    public int mDstWidth;
    public boolean mFilter;
    public Bitmap mSourceBitmap;

    private BitmapCreateParam(Builder builder) {
        this.mType = builder.mType;
        this.mSourceBitmap = builder.mSourceBitmap;
        this.mDstWidth = builder.mDstWidth;
        this.mDstHeight = builder.mDstHeight;
        this.mFilter = builder.mFilter;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private int mDstHeight;
        private int mDstWidth;
        private boolean mFilter;
        private Bitmap mSourceBitmap;
        private int mType = 2;

        public Builder mType(int i) {
            this.mType = i;
            return this;
        }

        public Builder mSourceBitmap(Bitmap bitmap) {
            this.mSourceBitmap = bitmap;
            return this;
        }

        public Builder mDstWidth(int i) {
            this.mDstWidth = i;
            return this;
        }

        public Builder mDstHeight(int i) {
            this.mDstHeight = i;
            return this;
        }

        public Builder mFilter(boolean z) {
            this.mFilter = z;
            return this;
        }

        public BitmapCreateParam build() {
            return new BitmapCreateParam(this);
        }
    }
}
