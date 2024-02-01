package com.xiaopeng.montecarlo.root.util.bitmapfactory;

import android.view.View;
/* loaded from: classes3.dex */
public class BitmapCreateByViewParam extends BitmapFactoryParam {
    public boolean mIsNeedScale;
    public int mScalePercent;
    public View mView;

    private BitmapCreateByViewParam(Builder builder) {
        this.mType = builder.mType;
        this.mView = builder.mView;
        this.mIsNeedScale = builder.mIsNeedScale;
        this.mScalePercent = builder.mScalePercent;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private boolean mIsNeedScale;
        private int mScalePercent;
        private int mType = 3;
        private View mView;

        public Builder mType(int i) {
            this.mType = i;
            return this;
        }

        public Builder mView(View view) {
            this.mView = view;
            return this;
        }

        public Builder mIsNeedScale(boolean z) {
            this.mIsNeedScale = z;
            return this;
        }

        public Builder mScalePercent(int i) {
            this.mScalePercent = i;
            return this;
        }

        public BitmapCreateByViewParam build() {
            return new BitmapCreateByViewParam(this);
        }
    }
}
