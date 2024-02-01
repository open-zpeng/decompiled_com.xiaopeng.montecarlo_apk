package com.xiaopeng.montecarlo.root.util.bitmapfactory;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class DecodeResourceParam extends BitmapFactoryParam {
    public boolean mIsNeedScale;
    public HashMap<Integer, BitmapFactory.Options> mParams;
    public Resources mRes;
    public int mScalePercent;
    public TextOption mTextOption;
    public HashMap<Integer, Integer> mTextureResIdMap;

    /* loaded from: classes3.dex */
    public static class TextOption {
        public int mTextColor;
        public boolean mTextIsBold = false;
        public String mTextName;
        public int mTextOffsetX;
        public int mTextOffsetY;
        public int mTextSize;
    }

    private DecodeResourceParam(Builder builder) {
        this.mType = builder.mType;
        this.mRes = builder.mRes;
        this.mParams = builder.mParams;
        this.mIsUseDrawable = builder.mIsUseDrawable;
        this.mIsNeedScale = builder.mIsNeedScale;
        this.mScalePercent = builder.mScalePercent;
        this.mTextOption = builder.mTextOption;
        this.mTextureResIdMap = builder.mTextureResIdMap;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Resources mRes;
        private int mScalePercent;
        private HashMap<Integer, Integer> mTextureResIdMap = new HashMap<>();
        private int mType = 0;
        private HashMap<Integer, BitmapFactory.Options> mParams = new HashMap<>();
        private boolean mIsUseDrawable = true;
        private boolean mIsNeedScale = false;
        private TextOption mTextOption = null;

        public Builder(Resources resources) {
            this.mRes = resources;
        }

        public Builder setRes(Resources resources) {
            this.mRes = resources;
            return this;
        }

        public Builder setParams(HashMap<Integer, BitmapFactory.Options> hashMap) {
            this.mParams = hashMap;
            return this;
        }

        public Builder putParam(int i, BitmapFactory.Options options) {
            this.mParams.put(Integer.valueOf(i), options);
            return this;
        }

        public Builder setUseDrawable(boolean z) {
            this.mIsUseDrawable = z;
            return this;
        }

        public Builder setIsNeedScale(boolean z) {
            this.mIsNeedScale = z;
            return this;
        }

        public Builder setScalePercent(int i) {
            this.mScalePercent = i;
            return this;
        }

        public Builder setTextOption(TextOption textOption) {
            this.mTextOption = textOption;
            return this;
        }

        public Builder putTextureId(int i, int i2) {
            this.mTextureResIdMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            return this;
        }

        public Builder setType(int i) {
            this.mType = i;
            return this;
        }

        public DecodeResourceParam build() {
            return new DecodeResourceParam(this);
        }
    }
}
