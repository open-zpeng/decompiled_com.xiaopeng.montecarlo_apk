package com.xiaopeng.montecarlo.root.util.bitmapfactory;

import android.graphics.BitmapFactory;
/* loaded from: classes3.dex */
public class DecodeByteParam extends BitmapFactoryParam {
    public byte[] mData;
    public int mLength;
    public int mOffset;
    public BitmapFactory.Options mOpts;

    private DecodeByteParam(Builder builder) {
        this.mType = builder.mType;
        this.mData = builder.mData;
        this.mOffset = builder.mOffset;
        this.mLength = builder.mLength;
        this.mOpts = builder.mOpts;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private byte[] mData;
        private int mLength;
        private int mOffset;
        private BitmapFactory.Options mOpts;
        private int mType = 1;

        public Builder mType(int i) {
            this.mType = i;
            return this;
        }

        public Builder mData(byte[] bArr) {
            this.mData = bArr;
            return this;
        }

        public Builder mOffset(int i) {
            this.mOffset = i;
            return this;
        }

        public Builder mLength(int i) {
            this.mLength = i;
            return this;
        }

        public Builder mOpts(BitmapFactory.Options options) {
            this.mOpts = options;
            return this;
        }

        public DecodeByteParam build() {
            return new DecodeByteParam(this);
        }
    }
}
